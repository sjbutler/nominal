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

/**
 * Represents typographical case.
 * @author Simon Butler (simon@facetus.org.uk)
 */
public enum CaseType {

    LOWER ( "lower" ),
    MIXED ( "mixed" ),
    UPPER ( "upper" );
    
    private final String description;
    
    private CaseType( String description ) {
        this.description = description;
    }
 
    private boolean hasName( String description ) {
        return this.description.equals( description );
    }
    
    /**
     * Converts a {@code String} to a {@code CaseType}. 
     * @param description a {@code String} belonging to the set {"lower", "mixed", "upper"}
     * All other inputs result in an {@code IllegalArgumentException} being thrown.
     * @return a {@code CaseType} 
     */
    public static CaseType getCaseTypeFor( String description ) {
        if ( description == null || description.isEmpty() ) {
            throw new IllegalArgumentException( 
                    "null reference or empty String passed to method" );
        }
        
        for ( CaseType caseType : CaseType.values() ) {
            if ( caseType.hasName( description ) ) {
                return caseType;
            } 
        }
        
        throw new IllegalArgumentException( 
                "No valid case type found for: \"" + description + "\"");
    }
    
    /**
     * Retrieves a textual description.
     * @return A textual description.
     */
    public String description() {
        return this.description;
    }
}
