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
import uk.ac.open.crc.nominal.information.SeparatorInformation;
import uk.ac.open.crc.nominal.rules.Rule;
import uk.ac.open.crc.nominal.rules.RuleType;
import uk.ac.open.crc.nominal.rules.RulesetGroup;

/**
 * Recovers and applies the defined separator rules.
 */
public class SeparatorDetector implements Detector {

    private final RulesetGroup ruleSetGroup;
    
    /**
     * Creates a detector.
     * @param ruleSetGroup a set of rules to apply 
     */
    public SeparatorDetector( RulesetGroup ruleSetGroup ) {
        this.ruleSetGroup = ruleSetGroup;
    }
    
    /**
     * Tests the identifier name for the presence of, and appropriate use of 
     * underscores. The returned information object is added to the identifier
     * name and returned. Also identifies the use of '$' as an internal separator.
     * @param identifierName an {@code IdentifierName} to test
     * @return an information object recording the use of underscores and dollar
     * signs in the identifier name.
     */
    @Override
    public SeparatorInformation test( IdentifierName identifierName) {
        
        Rule separatorRule = this.ruleSetGroup.get( 
                identifierName.classification(), RuleType.SEPARATOR );
        
        return (SeparatorInformation) separatorRule.test( identifierName );
    }
    
}
