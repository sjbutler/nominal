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

package uk.ac.open.crc.nominal.detectors;

import java.util.HashSet;

/**
 * A small dictionary containing some common prefixes.
 */
public class PrefixDictionary {

    /**
     * Case sensitive list of common prefixes.
     */
    private static final String[] PREFIXES = { "I", "i", "m", "my", "f", "p" };
    
    private static PrefixDictionary instance = null;
    
    /**
     * Retrieves the instance of this object.
     * @return the instance of this object
     */
    public static PrefixDictionary getInstance() {
        if ( instance == null ) {
            instance = new PrefixDictionary();
        }
        
        return instance;
    }
    
    
    // -------------------
    
    private final HashSet<String> prefixSet;
    private final HashSet<String> normalisedPrefixSet;
    
    /**
     * Creates a dictionary with a default set of prefixes.
     */
    private PrefixDictionary() {
        this.prefixSet = new HashSet<>();
        this.normalisedPrefixSet = new HashSet<>();
        for ( String prefix : PREFIXES ) {
            this.prefixSet.add( prefix );
            this.normalisedPrefixSet.add( prefix.toLowerCase() );
        }
    }
    
    /**
     * Adds a prefix to the dictionary.
     * @param prefix a string to add to the dictionary.
     */
    public void add( String prefix ) {
        this.prefixSet.add( prefix );
        this.normalisedPrefixSet.add( prefix.toLowerCase() );
    }
    
    /**
     * Case sensitive test of a possible prefix.
     * @param token a string to test
     * @return {@code true} iff the prefix tested is found in the dictionary.
     */
    public boolean isPrefix( String token ) {
        return this.prefixSet.contains( token );
    }
    
    
    /**
     * Case insensitive test of a possible prefix.
     * @param token a string to test
     * @return {@code true} iff the prefix tested is found in 
     * the dictionary regardless of case.
     */
    public boolean isPrefixIgnoreCase( String token ) {
        return this.normalisedPrefixSet.contains( token.toLowerCase() );
    }
    
}
