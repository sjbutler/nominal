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

package uk.ac.open.crc.nominal.detectors;

import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.rules.Rule;
import uk.ac.open.crc.nominal.rules.RulesetGroup;
import uk.ac.open.crc.nominal.rules.RuleType;
import uk.ac.open.crc.nominal.information.FirstCharacterCapitalisationInformation;

/**
 * Determines the correctness of the capitalisation of the first character 
 * of an identifier name.
 */
public class FirstCharacterCapitalisationDetector implements Detector {
    private final RulesetGroup ruleSetGroup;
    

    /**
     * Creates the detector.
     * @param ruleSetGroup a rule set to apply
     */
    public FirstCharacterCapitalisationDetector( RulesetGroup ruleSetGroup ) {
        this.ruleSetGroup = ruleSetGroup;
    }
    
    @Override
    public FirstCharacterCapitalisationInformation test( IdentifierName identifierName ) {
        // get the rule & test
        Rule rule = this.ruleSetGroup.get( 
                identifierName.classification(), RuleType.FIRST_CHARACTER );

        return (FirstCharacterCapitalisationInformation) rule.test( identifierName );
    }
}
