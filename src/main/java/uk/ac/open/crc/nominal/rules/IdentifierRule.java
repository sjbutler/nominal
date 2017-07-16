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

/**
 * Base class for rules.
 */
public abstract class IdentifierRule extends AbstractRule {

    /**
     * Creates a rule of the specified type.
     * @param ruleType a rule type
     */
    public IdentifierRule( RuleType ruleType ) {
        super( ruleType );
    }
    
}
