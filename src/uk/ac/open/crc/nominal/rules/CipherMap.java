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
 *
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class CipherMap {
    private static final Logger LOGGER = LoggerFactory.getLogger( CipherMap.class );
    
    private final Map<String,Set<String>> map;
    private final String identifier;
    
    public CipherMap( String identifier ) {
        this.map = new HashMap<>();
        this.identifier = identifier;
    }
    
    
    
    public String identifier() {
        return this.identifier;
    }
    
    public Map map() {
        return this.map;
    }
    
    public Set<String> keys() {
        return this.map.keySet();
    }
    
    public Set<String> typeList( String cipher ) {
        return this.map.get( cipher );
    }
    
    public void put( String cipher, Set<String> types ) {
        if ( this.map.containsKey( cipher ) ) {
            Set<String> existingTypes = this.map.get( cipher );
                existingTypes.addAll( types );
        }
        else {
            this.map.put( cipher, types );
        }
    }
    
    public boolean isEmpty() {
        return this.map.isEmpty();
    }
    
    public boolean isKnownCipher( String s ) {
        return this.map.containsKey( s );
    }
    
}
