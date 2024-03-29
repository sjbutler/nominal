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
 * Common implementations for all {@code Rule} classes.
 */
public abstract class AbstractRule implements Rule {

    private final RuleType ruleType;
    
    /**
     * Creates in instance of {@code AbstractRule}.
     * @param ruleType specifies a key identifying the type of rule
     */
    public AbstractRule( RuleType ruleType ) {
        this.ruleType = ruleType;
    }
    
    /**
     * Retrieves the {@link RuleType} for the given rule.
     * @return the {@code RuleType}
     */
    @Override
    public final RuleType ruleType() {
        return this.ruleType;
    }
    
    protected String stripLeadingAndTrailingNonAlphaNumericCharacters( String string ) {
        String intermediate = stripLeadingNonAlphaNumericCharacters( string );
        return stripTrailingNonAlphaNumericCharacters( intermediate );
    }
    
    protected String stripLeadingNonAlphaNumericCharacters( String string ) {
        if ( Character.isLetterOrDigit( string.codePointAt( 0 ) ) ) {
            return string;
        }
        else {
            return stripLeadingNonAlphaNumericCharacters( string.substring( 1 ) );
        }
    }
    
    protected String stripTrailingNonAlphaNumericCharacters( String string ) {
        int lastIndex = string.length() - 1;
        if ( Character.isLetterOrDigit( string.codePointAt( lastIndex ) ) ) {
            return string;
        }
        else {
            return stripTrailingNonAlphaNumericCharacters( string.substring( 0, lastIndex) );
        }
    }

}
