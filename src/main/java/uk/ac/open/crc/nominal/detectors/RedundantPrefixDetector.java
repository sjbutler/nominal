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
import uk.ac.open.crc.nominal.rules.Rule;
import uk.ac.open.crc.nominal.rules.RuleType;
import uk.ac.open.crc.nominal.rules.RulesetGroup;
import uk.ac.open.crc.nominal.information.RedundantPrefixInformation;

/**
 * Examines reference names for the use of redundant prefixes.
 */
public class RedundantPrefixDetector implements Detector {
    
    private final RulesetGroup rulesetGroup;
    
    /**
     * Creates a detector.
     * @param rulesetGroup a set of rules to apply 
     */
    public RedundantPrefixDetector( RulesetGroup rulesetGroup ) {
        this.rulesetGroup = rulesetGroup;
    }
    
    /**
     * Evaluates a name against the rules specified in the constructor.
     * @param identifierName a name to evaluate
     * @return an information object summarising the result
     */
    @Override
    public RedundantPrefixInformation test( IdentifierName identifierName ) {
        RedundantPrefixInformation information = null;
        if ( identifierName.species().isReference() ) {
            Rule redundantPrefixRule = this.rulesetGroup.get( 
                    identifierName.classification(), 
                    RuleType.REDUNDANT_PREFIX );
            information = (RedundantPrefixInformation) redundantPrefixRule.test( identifierName );
        }
        
        return information;
    }
}
