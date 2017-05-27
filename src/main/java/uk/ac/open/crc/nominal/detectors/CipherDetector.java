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
import uk.ac.open.crc.nominal.information.CipherInformation;
import uk.ac.open.crc.nominal.rules.Rule;
import uk.ac.open.crc.nominal.rules.RuleType;
import uk.ac.open.crc.nominal.rules.RulesetGroup;

/**
 * Wraps a {@code Rule} for cipher use.
 */
public class CipherDetector implements Detector {

    private final RulesetGroup ruleSetGroup; 
    
    /** 
     * Creates a detector.
     * @param ruleSetGroup a rule set to apply in the detector 
     */
    public CipherDetector( RulesetGroup ruleSetGroup ) {
        this.ruleSetGroup = ruleSetGroup;
    }
    
    /**
     * Determines whether the identifier name is a cipher, if appropriate.
     * @param identifierName an identifier name to be evaluated
     * @return a {@code CipherInformation} object, or {@code null} if the 
     * identifier name consists of more than a single token, or is a 
     * non-reference species.
     */
    @Override
    public CipherInformation test( IdentifierName identifierName ) {
        CipherInformation information = null;
        if ( identifierName.species().isReference() ) {
            Rule rule = this.ruleSetGroup.get( 
                    identifierName.classification(), RuleType.CIPHER );
            information = (CipherInformation) rule.test( identifierName );
        }
        return information;
    }
    
}
