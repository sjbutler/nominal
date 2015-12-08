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
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A map of cipher names to defined types. This class is instantiated from 
 * the parser and has an identifier specified in the .nom file being parsed.
 */
public class CipherMap {
    private static final Logger LOGGER = 
            LoggerFactory.getLogger( CipherMap.class );
    
    private final Map<String,Set<String>> map;
    private final String identifier;
    
    /**
     * Creates an empty cipher map with an identifier. The identifier is 
     * defined when the cipher list is declared in the .nom file.
     * @param identifier a name for the cipher map
     */
    public CipherMap( String identifier ) {
        this.map = new HashMap<>();
        this.identifier = identifier;
    }
    
    /**
     * Recovers the identifier used for this map of ciphers.
     * 
     * @return an identifier
     */
    public String identifier() {
        return this.identifier;
    }
    
    /** 
     * Retrieves the map of cipher names and types.
     * @return a map
     */
    public Map<String,Set<String>> map() {
        return this.map;
    }
    
    /**
     * Retrieves the set of cipher names recorded in the map.
     * @return the set of cipher names
     */
    public Set<String> keys() {
        return this.map.keySet();
    }
    
    /**
     * Retrieves the set of types for the specified cipher.
     * @param cipher a cipher name
     * @return a set of type names, or {@code null} if the cipher 
     * is not a member of the map.
     */
    public Set<String> typeList( String cipher ) {
        return this.map.get( cipher );
    }
    
    /**
     * Adds a cipher and types to the map. The process is cumulative so 
     * the type is added to the list for the specified cipher.
     * @param cipher a cipher name
     * @param types the type names associated with the cipher.
     */
    public void put( String cipher, Set<String> types ) {
        if ( this.map.containsKey( cipher ) ) {
            Set<String> existingTypes = this.map.get( cipher );
                existingTypes.addAll( types );
        }
        else {
            this.map.put( cipher, types );
        }
    }
    
    /**
     * Indicates whether the map is empty.
     * @return true if the map is empty
     */
    public boolean isEmpty() {
        return this.map.isEmpty();
    }
    
    /**
     * Indicates if the token is a name in the map.
     * @param token a token to test 
     * @return {@code true} if the token is a name found in the map.
     */
    public boolean isKnownCipher( String token ) {
        return this.map.containsKey( token );
    }
    
}
