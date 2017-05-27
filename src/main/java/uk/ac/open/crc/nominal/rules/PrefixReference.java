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

import java.util.HashSet;
import java.util.Set;

/**
 * Fixed reference of standard redundant prefixes.
 */
public class PrefixReference {

    private static final Set<String> hungarianPrefixes;

    static {
        hungarianPrefixes = new HashSet<>();
        hungarianPrefixes.add( "b" );
        hungarianPrefixes.add( "c" );
        hungarianPrefixes.add( "d" );
        hungarianPrefixes.add( "f" );
        hungarianPrefixes.add( "i" );
        hungarianPrefixes.add( "l" );
    }

    private static final Set<String> speciesPrefixes;

    static {
        speciesPrefixes = new HashSet<>();
        speciesPrefixes.add( "f" ); // intersection
        speciesPrefixes.add( "m" );
        speciesPrefixes.add( "p" );
    }

    private static final Set<String> possessivePrefixes;
    
    static {
        possessivePrefixes = new HashSet<>();
        possessivePrefixes.add( "my" );
    }
    
    public static boolean isTypePrefix( String s ) {
        return hungarianPrefixes.contains( s );
    }
    
    public static boolean isSpeciesPrefix( String s ) {
        return speciesPrefixes.contains( s );
    }
    
    public static boolean isPossessivePrefix( String s ) {
        return possessivePrefixes.contains( s );
    }
    
    private PrefixReference() {}
}
