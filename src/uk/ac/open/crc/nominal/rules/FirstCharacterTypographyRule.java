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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.information.FirstCharacterCapitalisationInformation;

// review whether this functionality should be combined with that of the 
// BodyRule -- possibly in some overarching/supervisory typography rule.
// back to the tree of responsibility again :-)
/**
 * Embodies a rule for the first alphabetic character of an identifier name.
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class FirstCharacterTypographyRule extends AbstractRule {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FirstCharacterTypographyRule.class );
    
    private static final String UPPER_TRUE = "identifier name begins with upper case character";
    private static final String UPPER_FALSE = "identifier name does not begin with upper case character";
    private static final String LOWER_TRUE = "identifier name begins with lower case character";
    private static final String LOWER_FALSE = "identifier name does not begin with lower case character";
    
    private final CaseType caseType;
    private String explanation;
    
    /**
     * Creates a rule for the specified {@linkplain CaseType}.
     * @param caseType must be {@code CaseType.LOWER} or {@code CaseType.UPPER}
     * otherwise instantiation will throw an {@code IllegalArgumentException}.
     */
    public FirstCharacterTypographyRule( CaseType caseType ) {
        super( RuleType.FIRST_CHARACTER );
        this.caseType = caseType;
        // defensive, but not all values of CaseType are legitimate for this rule.
        // So enforce the contract.
        if ( this.caseType == CaseType.MIXED ) {
            LOGGER.error( "First character rule incorrectly defined" );
            throw new IllegalArgumentException( 
                    "FirstCharacterRule incorrectly defined. Must be defined "
                            + "as lower or upper case." );
        }
        this.explanation = "";
    }
    
    
    @Override
    public FirstCharacterCapitalisationInformation test( IdentifierName identifierName ) {
        boolean isCorrect = false;
        FirstCharacterCapitalisationInformation information;
        String nameString = identifierName.nameString();
        if ( nameString.matches( "^[\\$_]+$" ) ) {
            information = new FirstCharacterCapitalisationInformation(
            isCorrect,
            false,
            false,
            "Identifier name composed of separator characters only");
        }
        else {
            String cleanedNameString = stripLeadingNonAlphaNumericCharacters( nameString );
            boolean isUpperCase = Character.isUpperCase( cleanedNameString.codePointAt( 0 ) );
            boolean isDigit = Character.isDigit( cleanedNameString.codePointAt( 0 ) );
            if ( this.caseType == CaseType.LOWER ) {
                isCorrect = ! isUpperCase;
                if ( isCorrect ) {
                    this.explanation = LOWER_TRUE;
                }
                else {
                    this.explanation = LOWER_FALSE;
                }
            }
            else if ( this.caseType == CaseType.UPPER ) {
                isCorrect = isUpperCase;
                if ( isCorrect ) {
                    this.explanation = UPPER_TRUE;
                }
                else {
                    this.explanation = UPPER_FALSE;
                }
            }

            information = new FirstCharacterCapitalisationInformation( 
                            isCorrect, 
                            isUpperCase,
                            isDigit,
                            explanation);
        }
        
        identifierName.add( information );
        
        return information;
    }
    
    /**
     * Provides a means of reading the {@code CaseType} used in the rule.
     * @return A textual representation of the {@code CaseType} defining the rule.
     */
    @Override
    public String toString() {
        return this.caseType.description();
    }
    
}
