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

// maybe look at renaming this
/**
 * Represents different kinds of grammatical number. 
 */
public enum GrammaticalNumber { // 'quantity' and 'number' are viable alternatives that may be more correct 
    PLURAL ( "plural" ),
    SINGLUAR ( "singular" ),
    UNSPECIFIED ( "unspecified" ); 
    
    
    // -----------------
    private final String description;
    
    private GrammaticalNumber( String description ) {
        this.description = description;
    }
    
    /**
     * Retrieves a {@code String} description of the grammatical number.
     * @return a {@code String} description of the grammatical number.
     */
    public final String description() {
        return this.description;
    }
    
    /**
     * Obtains a grammatical number for a given description. 
     * @param description a {@code String} that is a member of the 
     * set {"plural", "singular", "unspecified"}
     * @return a grammatical number value.
     */
    public static final GrammaticalNumber getDualFor( String description ) {
        if ( description == null || description.isEmpty() ) {
            throw new IllegalArgumentException( 
                    "null reference or empty String passed to getDualFor()" );
        }
        
        for ( GrammaticalNumber dualValue : GrammaticalNumber.values() ) {
            if ( description.equals( dualValue.description() ) ) {
                return dualValue;
            }
        }
        
        throw new IllegalArgumentException( 
                String.format( "No valid instance of GrammaticalNumber found "
                        + "with description matching: \"%s\"", description ) );
    }
    
}
