/*
 Copyright (C) 2013-2015 The Open University
 Copyright (C) 2017 Simon Butler

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

import java.util.List;
import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.Token;
import uk.ac.open.crc.nominal.information.TrailingDigitInformation;

/**
 * Determines whether an identifier name contains a trailing digit, and whether
 * that use of a trailing digit is acceptable. This functionality is 
 * currently unavailable. It will be reinstated soon.
 */
public class TrailingDigitDetector implements Detector {

    private final TrailingDigitDictionary dictionary;
//    private final IdentifierNameStore identifierNameStore;
    
    /**
     * Creates a detector. The detector is currently unavailable.
     * @throws UnsupportedOperationException if the constructor is invoked
     */
    public TrailingDigitDetector() {
        throw new UnsupportedOperationException( "Functionality to be implemented." );
//        this.dictionary = TrailingDigitDictionary.getInstance();
//        this.identifierNameStore = IdentifierNameStore.getInstance();
    }
    
    /**
     * Tests an identifier name to determine whether it has a trailing digit, 
     * and determines whether that usage is acceptable. The last token of the 
     * identifier name is annotated with the information.
     * 
     * @param identifierName and {@code IdentifierName}
     * @return an instance of {@code TrailingDigitInformation} which summarised
     * the use of trailing digits in the identifier name.
     */
    @Override
    public TrailingDigitInformation test( IdentifierName identifierName ) {
        TrailingDigitInformation information;
        // screen
        Token lastToken = identifierName.lastToken();
        if ( lastToken != null ) {
            boolean isTrailingDigit = lastToken.text().matches( "^([A-Za-z]+)\\d+$" );

            information = new TrailingDigitInformation( isTrailingDigit );

            lastToken.add( information );

            // investigate in more detail
            if ( isTrailingDigit ) {
                // check for known digit ending abbreviation
                boolean isKnownAbbreviation = this.dictionary.isAbbreviation( lastToken.text() );
                information.setKnownAbbreviation( isKnownAbbreviation );

                boolean isKnownPattern = isKnownPattern( lastToken.text() );
                information.setKnownPattern( isKnownPattern );

                if ( isKnownAbbreviation ) {
                    information.setIsAcceptable( true );
                }
                else if ( isKnownPattern ) {
                    // don't want version pattern in certain species -- subject to review
                    if ( isVersionPattern( lastToken.text() ) 
                            && ( identifierName.species().isClassOrInterface()
                            || identifierName.species().isMethod()) ) {
                        information.setIsAcceptable( false );
                    }
                    else {
                        information.setIsAcceptable( true );
                    }
                }
                else {
                    boolean isAcceptable = checkAcceptability( identifierName );
                    information.setIsAcceptable( isAcceptable );
                }
            }
        }
        else {
            information = null;
        }
        
        return information;
    }
    
    
    // review this logic 
    private boolean checkAcceptability( IdentifierName identifierName ) {
        boolean isAcceptable;
////        List<IdentifierName> siblings = identifierNameStore.getSiblings( identifierName );
//        
//        if ( isIsolated( identifierName, siblings ) ) {
//            isAcceptable = false;
//        }
//        else {
//            // only groups of formal arguments are allowed
//            // to have numeric suffixes (and maybe local variables, but we'll deal with that later)
//            isAcceptable = identifierName.species() == Species.FORMAL_ARGUMENT;
//        }
//        
//        return isAcceptable;
        return false;
    }
    
    // the idea is that a1 on its own is not good practice
    // however, a1, a2 ... maybe particularly for parameters
    // in comparator methods and methods processing 2 or more
    // similar instances in a generic way.
    private boolean isIsolated( IdentifierName identifierName, List<IdentifierName> siblings ) {
        if ( ! siblings.isEmpty() ) {
            // we need to determine if there are more than one of a given 
            // trailing digit pattern.

            String token = identifierName.lastToken().text();

            String[] subtokens = token.split( "\\d+" );
            String tokenPattern = subtokens[0] + "\\d+";

            for ( IdentifierName sibling : siblings ) {
                if ( sibling.lastToken().text().matches( tokenPattern ) ) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    private boolean isKnownPattern( String string ) {
        return isRfcPattern( string )
                || isVersionPattern( string )
                || isIsoPattern( string );
    }
    
    
    // ------
    // the following tests may need to be moved somewhere else 
    // as they are utility tests and may prove useful to intt
    // and any abbreviaton expansion code. idtk?
    
    private boolean isRfcPattern( String string ) {
        return string.matches( "^(?iu)rfc\\d+$" );
    }
    
    private boolean isVersionPattern( String string ) {
        return string.matches( "^(?iu)(v|ver|version)\\d+$" );
    }
    
    private boolean isIsoPattern( String string ) {
        return string.matches( "^(?iu)iso\\d+$" );
    }
    
}
