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
 * Ugly, ugly, ugly &mdash; but may work. 
 * 
 * @author Simon Butler (simon@facetus.org.uk)
 */
public enum RuleType {
    ACRONYM( "acronym capitalisation" ),
    BODY( "body capitalisation" ),
    CIPHER( "cipher" ),
    FIRST_CHARACTER( "first character capitalisation" ),
    PHRASE( "phrase structure" ),
    PREFIX( "prefix" ) ,
    REDUNDANT_PREFIX( "redundant prefix" ),
    SEPARATOR( "separators" ),
    STANDALONE_ABBREVIATION( "standalone abbreviation" ),
    TYPE_ACRONYM( "type acronym" ),
    PLURAL( "grammatical number" );
    
    
    private final String description;
    
    private RuleType( String description ) {
        this.description = description;
    } 
    
    
    public String description() {
        return this.description;
    }
    
}
