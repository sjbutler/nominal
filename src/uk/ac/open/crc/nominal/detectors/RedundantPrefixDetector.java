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
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class RedundantPrefixDetector implements Detector {
    
    private final RulesetGroup rulesetGroup;
    
    public RedundantPrefixDetector( RulesetGroup rulesetGroup ) {
        this.rulesetGroup = rulesetGroup;
    }
    
    @Override
    public RedundantPrefixInformation test( IdentifierName identifierName ) {
        RedundantPrefixInformation information = null;
        if ( identifierName.species().isReference() ) {
            Rule redundantPrefixrule = this.rulesetGroup.get( 
                    identifierName.classification(), 
                    RuleType.REDUNDANT_PREFIX );
            information = (RedundantPrefixInformation) redundantPrefixrule.test( identifierName );
        }
        
        return information;
    }
}
