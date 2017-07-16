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

import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.information.LeadingUnderscoreInformation;

// implementation to be revised when use of leading underscores can be defined
/**
 * Checks for the use of leading underscores.
 */
public class LeadingUnderscoreDetector implements Detector {

    /**
     * Evaluates a name against a static rule set forbidding the use of
     * leading underscores.
     * @param identifierName a name to evaluate
     * @return in information object 
     */
    @Override
    public LeadingUnderscoreInformation test( IdentifierName identifierName ) {
        // imprecise test -- need to check for '$_' too
        String nameString = identifierName.nameString();
        boolean hasLeadingUnderscore = nameString.startsWith( "_" );
        boolean isResultingNameLegal = false;
        if ( hasLeadingUnderscore ) {
            isResultingNameLegal = isResultingNameLegal( nameString );
        }
        LeadingUnderscoreInformation information = 
                new LeadingUnderscoreInformation( 
                        hasLeadingUnderscore, isResultingNameLegal );
        
        identifierName.add( information );
        return information;
    }
    
    // REVIEW 
    // look at the use of dollar signs too, though maybe in another detector.
    // also need to consider reporting that first character is letter 
    // so that revised name would be accepted by compiler.
    /**
     * Identifies if a name is composed of at least one alphanumeric character
     * in addition to the leading underscore(s).
     * @param name the name being tested
     * @return {@code true} iff the name contains at least one alphanumeric 
     * character.
     */
    private boolean isResultingNameLegal( String name )  {
        // deal with special case of name being composed solely of 
        // underscores or dollar signs
        if ( name.matches( "^[\\$_]+$" ) ) {
            return false;
        }
        // recursively strip underscores from
        // beginning of name.
        if ( name.startsWith( "_") ) {
            return isResultingNameLegal( name.substring( 1 ) );
        }
        
        return Character.isLetterOrDigit( name.codePointAt( 0 ) );
    }
    
}
