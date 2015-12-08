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
 * A central store for cipher maps. A map with the name "__common_ciphers__"
 * is used to store a default set of ciphers and creates a rule where ciphers
 * are not permitted and common usage is flagged as an error. Ciphers are 
 * defined in the .nom rules file and lists may be specified with identifiers
 * to allow the lists of ciphers to be applied in different rules.
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class CipherMapStore {
    private static final Logger LOGGER = 
            LoggerFactory.getLogger( CipherMapStore.class );
    
    private static CipherMapStore instance = null;
    
    /**
     * Retrieves the instance of this object.
     * @return the instance of this object
     */
    public static CipherMapStore getInstance() {
        if ( instance == null ) {
            instance = new CipherMapStore();
        }
        
        return instance;
    }

    // ---------------------------------
    private final Map<String,CipherMap> cipherMaps;
    
    private CipherMapStore() {
        this.cipherMaps = new HashMap<>();
        
        // set up the ciphers to be recognised by the default cipher rule
        // so they can be marked 
        String mapName = "__common_ciphers__";
        CipherMap cm = new CipherMap( mapName );
        this.cipherMaps.put( mapName, cm );
        // now populate the map using the expanded set to flag more 'offenders'.
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
    
    
    /**
     * Adds a cipher map to the store.
     * @param cm a cipher map
     */
    public void add( CipherMap cm ) {
        String key = cm.identifier();
        if ( this.cipherMaps.containsKey( key ) ) {
            LOGGER.error( 
                    "Duplicate cipher list declared with identifier "
                            + "\"{}\"\nOverwriting previously stored list.", 
                    key );
        }
        
        this.cipherMaps.put( key, cm );
    }
    
    /**
     * Adds an instance of {@code CipherMap} to the store and associates it
     * with the given key. The key 
     * @param key the name of a cipher map
     * @param cm a cipher map
     */
    public void store( String key, CipherMap cm ) {
        if ( this.cipherMaps.containsKey( key ) ) {
            LOGGER.error( 
                    "Duplicate cipher list declared with identifier "
                            + "\"{}\"\nOverwriting previously stored list.", 
                    key );
        }
        
        this.cipherMaps.put( key, cm );
    }
    
    /**
     * Retrieves the cipher map associated with the given key. The method 
     * returns null when the key is unrecognised.
     * @param cipherMapKey a key
     * @return the map associated with the key, or null if the 
     * key is not recognised
     */
    public CipherMap get( String cipherMapKey ) {
        return this.cipherMaps.get( cipherMapKey );
    }
    
    
}
