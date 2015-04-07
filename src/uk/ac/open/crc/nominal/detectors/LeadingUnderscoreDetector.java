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

/**
 *
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class LeadingUnderscoreDetector implements Detector {

    @Override
    public LeadingUnderscoreInformation test( IdentifierName identifierName ) {
        // imprecise test -- need to check for '$_' too
        String nameString = identifierName.nameString();
        boolean hasLeadingUnderscore = nameString.startsWith( "_" );
        boolean isResultingNameLegal = false;
        if ( hasLeadingUnderscore ) {
            isResultingNameLegal = isResultingNameLegal( nameString );
        }
        LeadingUnderscoreInformation information = new LeadingUnderscoreInformation( hasLeadingUnderscore, isResultingNameLegal );
        
        identifierName.add( information );
        return information;
    }
    
    
    // not sure that this is correct -- REVIEW 
    // determine what this is meant to do!!
    private boolean isResultingNameLegal( String name )  {
        // deal with special case of name being composed solely of underscores or dollar signs
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
