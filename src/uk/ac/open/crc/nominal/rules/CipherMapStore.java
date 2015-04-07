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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class CipherMapStore {
    private static final Logger LOGGER = 
            LoggerFactory.getLogger( CipherMapStore.class );
    
    private static CipherMapStore instance = null;
    
    public static CipherMapStore getInstance() {
        if ( instance == null ) {
            instance = new CipherMapStore();
        }
        
        return instance;
    }
    
    private final Map<String,CipherMap> cipherMaps;
    
    
    private CipherMapStore() {
        this.cipherMaps = new HashMap<>();
        
        // set up the ciphers to be recognised by the default cipher rule
        // so they can be marked 
        String mapName = "__common_ciphers__";
        CipherMap cm = new CipherMap( mapName );
        this.cipherMaps.put( mapName, cm );
        // now populate the map. Using the expanded set to flag more 'offenders'.
        Set<String> types = new HashSet<>();
        types.add( "boolean" );
        types.add( "Boolean" );
        types.add( "byte" );
        types.add( "Byte" );
        cm.put( "b", types);
        types = new HashSet<>();
        types.add( "char" );
        types.add( "Character" );
        cm.put( "c", types);
        types = new HashSet<>();
        types.add( "*Exception" );
        cm.put( "e", types );
        types = new HashSet<>();
        types.add( "double" );
        types.add( "Double" );
        cm.put( "d", types);
        types = new HashSet<>();
        types.add( "float" );
        types.add( "Float" );
        cm.put( "f", types );
        types = new HashSet<>();
        types.add( "Graphics" );
        cm.put(  "g", types );
        types = new HashSet<>();
        types.add( "int" );
        types.add( "Integer" );
        cm.put( "i", types);
        types = new HashSet<>();
        types.add( "int" );
        types.add( "Integer" );
        cm.put( "j", types);
        types = new HashSet<>();
        types.add( "int" );
        types.add( "Integer" );
        cm.put( "k", types);
        types = new HashSet<>();
        types.add( "Object" );
        cm.put( "o", types);
        types = new HashSet<>();
        types.add( "String" );
        cm.put( "s", types );
        types = new HashSet<>();
        types.add( "*" );
        cm.put( "v", types );
    }
    
    public void store( String key, CipherMap cipherMap ) {
        if ( this.cipherMaps.containsKey( key ) ) {
            LOGGER.error( 
                    "Duplicate cipher list declared with identifier "
                            + "\"{}\"\nOverwriting previously stored list.", 
                    key );
        }
        
        this.cipherMaps.put( key, cipherMap );
    }
    
    public CipherMap get( String cipherMapKey ) {
        CipherMap cm = this.cipherMaps.get( cipherMapKey );
        if ( cm == null ) {
            LOGGER.warn( "No cipher map found for key: \"{}\"", cipherMapKey );
        }
        return cm;
    }
    
    
}
