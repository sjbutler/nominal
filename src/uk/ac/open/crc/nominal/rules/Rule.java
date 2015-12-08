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
import uk.ac.open.crc.nominal.information.Information;

/**
 * The interface for rules.
 */
public interface Rule {

    /**
     * Evaluates the identifier name.
     * @param identifierName a name to test
     * @return an instance of {@code Information} with details of the test result.
     */
    public Information test( IdentifierName identifierName );
    
    /**
     * Intended for internal use.
     * 
     * @return a {@linkplain RuleType} indicating the type of rule 
     * embodied in the object.
     */
    public RuleType ruleType();
}
