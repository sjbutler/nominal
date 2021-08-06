/*
    Copyright (C) 2013-2015 The Open University

    SPDX-FileCopyrightText: 2013-2015 The Open University
    SPDX-License-Identifier: Apache-2.0

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
 * Keys to identify {@code Rule}s. 
 */
public enum RuleType {
    /** Identifies a rule for the capitalisation of acronyms. */
    ACRONYM( "acronym capitalisation" ),
    /** Identifies a rule for the typography of the name excluding the first character */
    BODY( "body capitalisation" ),
    /** Identifies a rule for ciphers. */
    CIPHER( "cipher" ),
    /** Identifies a rule for the typography of the first character. */
    FIRST_CHARACTER( "first character capitalisation" ),
    /** Identifies a rule for phrases. */
    PHRASE( "phrase structure" ),
    /** Identifies a rule for prefixes. */
    PREFIX( "prefix" ) ,
    /** Identifies a rule for redundant prefixes. */
    REDUNDANT_PREFIX( "redundant prefix" ),
    /** Identifies a rule for separators. */
    SEPARATOR( "separators" ),
    /** Identifies a rule for standalone abbreviations. */
    STANDALONE_ABBREVIATION( "standalone abbreviation" ),
    /** Identifies a type acronym rule. */
    TYPE_ACRONYM( "type acronym" ),
    /** Identifies a super-type acronym rule */
//    SUPER_TYPE_ACRONYM( "super type acronym" ),
    /** Identifies a pluralisation rule. */
    PLURAL( "grammatical number" );
    
    
    private final String description;
    
    private RuleType( String description ) {
        this.description = description;
    } 
    
    /**
     * Retrieves a textual description of the rule type.
     * @return a textual description
     */
    public String description() {
        return this.description;
    }
    
}
