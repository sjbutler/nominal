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

import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.information.RedundantPrefixInformation;

/**
 * Implements a rule for the detection of redundant prefixes.
 */
public class RedundantPrefixRule extends AbstractRule {

    /** 
     * Creates a redundant prefix rule.
     */
    public RedundantPrefixRule() {
        super( RuleType.REDUNDANT_PREFIX );
    }
    
    // the detector only allows through
    // names with 2 or more tokens
    // for obvious reasons.
    // 
    /**
     * Tests for the presence of a redundant prefix.
     * @param identifierName a name to be tested
     * @return an information object or null where the 
     * input contains fewer than 2 tokens.
     */
    @Override
    public RedundantPrefixInformation test( IdentifierName identifierName ) {
        RedundantPrefixInformation information = null;
        
        if ( identifierName.tokenCount() > 1 ) {
            final String firstTokenText = identifierName.firstToken().text();
            final boolean isTypePrefix = 
                    PrefixReference.isTypePrefix( firstTokenText );
            final boolean isSpeciesPrefix = 
                    PrefixReference.isSpeciesPrefix( firstTokenText );

            final boolean isCorrect = ! ( isTypePrefix || isSpeciesPrefix );

            final String originalCaseFirstTokenText = 
                    identifierName.unnormalisedTokens().get( 0 ).text();
            final boolean isCaseSensitivePrefix = 
                    PrefixReference.isTypePrefix( originalCaseFirstTokenText ) 
                    || PrefixReference.isSpeciesPrefix( originalCaseFirstTokenText );
            
            information = new RedundantPrefixInformation( 
                    isCorrect, isTypePrefix, isSpeciesPrefix, isCaseSensitivePrefix );

            identifierName.add( information );
        }
        
        return information;
    }
    
}
