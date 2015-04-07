/*
 Copyright (C) 2013-2015 The Open University

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package uk.ac.open.crc.nominal.rules;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import uk.ac.open.crc.idtk.SimpleNameTokeniser;

/**
 * Provides a mechanism for creating type acronyms. When acronyms are 
 * created they are cached to save repetitive processing. 
 *
 * Some functionality may belong in a Types service class in idtk.
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class TypeAcronymCache {
    private static TypeAcronymCache instance = null;
    
    public static TypeAcronymCache getInstance() {
        if ( instance == null ) {
            instance = new TypeAcronymCache();
        }
        
        return instance;
    }
    
    
    // ------------------------------
    private final HashMap<String,String> cache;
    
    private final ReentrantLock lock;
    
    private TypeAcronymCache() {
        this.lock = new ReentrantLock();
        this.cache = new HashMap<>();
    }
    
    /**
     * Derives an acronym from the supplied type name. For example, 
     * the acronym of NullPointerException is npe.
     * @param typeName a String 
     * @return a lowercase acronym derived from the supplied type name.
     */
    public String acronym( String typeName ) {
        this.lock.lock();
        try {
            String simplifiedTypeName = simplifyType( typeName );
            String typeAcronym = this.cache.get( simplifiedTypeName );
            if ( typeAcronym == null ) {
                typeAcronym = makeTypeAcronym(  simplifiedTypeName );
                this.cache.put( simplifiedTypeName, typeAcronym );
            }
            
            return typeAcronym;
        }
        finally {
            this.lock.unlock();
        }
    }
    
    // this functionality is being refactored and moved to another place
    // consequently the constructor is likey to change (soon).
    private String simplifyType( String typeName ) {
        // strip everything to the left of the rightmost dot, including the dot
        int lastDotIndex = typeName.lastIndexOf( "." );
        String s = lastDotIndex == -1 ? typeName : typeName.substring( lastDotIndex + 1 );
        
        // strip everything to the right of the first left angle bracket, including the bracket. 
        int lAngleIndex = s.indexOf( "<" );
        return lAngleIndex == -1 ? s : s.substring( 0, lAngleIndex );
    }
    
    private String makeTypeAcronym( String typeName ) {
        List<String> tokens = SimpleNameTokeniser.split( typeName );
        StringBuilder acronym = new StringBuilder();
        tokens.stream()
                .forEach( ( word ) -> { acronym.append( word.charAt( 0 ) ); } );
        
        return acronym.toString().toLowerCase();
    }
    
}
