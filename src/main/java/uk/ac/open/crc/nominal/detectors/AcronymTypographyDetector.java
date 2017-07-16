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
import uk.ac.open.crc.nominal.information.AcronymTypographySummaryInformation;
import uk.ac.open.crc.nominal.rules.Rule;
import uk.ac.open.crc.nominal.rules.RuleType;
import uk.ac.open.crc.nominal.rules.RulesetGroup;

/**
 * Entry point to investigate and record the typography of acronyms.
 */
public class AcronymTypographyDetector implements Detector {
    
    private final RulesetGroup rulesetGroup;
    
    /** 
     * Creates a detector using the rule set.
     * @param rulesetGroup a group of rules
     */
    public AcronymTypographyDetector( RulesetGroup rulesetGroup ) {
        this.rulesetGroup = rulesetGroup;
    }
    
    /**
     * Tests the name for the correctness of the typography of any acronyms.
     * @param identifierName a name to test
     * @return a summary indicating which acronyms have the correct typography, 
     * or {@code null} if there are no acronyms in the name.
     */
    @Override
    public AcronymTypographySummaryInformation test( IdentifierName identifierName ) {
        Rule rule = this.rulesetGroup.get( identifierName.classification(), RuleType.ACRONYM );
        
        AcronymTypographySummaryInformation information = 
                (AcronymTypographySummaryInformation) rule.test( identifierName ); 
        
        identifierName.add( information );
        
        return information;
    }
}
