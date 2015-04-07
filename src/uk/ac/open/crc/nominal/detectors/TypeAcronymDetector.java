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
import uk.ac.open.crc.nominal.information.TypeAcronymInformation;

/**
 * Detects the use of type acronyms for single token reference names. Type 
 * acronyms are specified for formal arguments and local
 * variable identifier names in Chapter 6 of the Java
 * Language Specification. They are also found in field names
 * and this detector tests field, formal argument and local 
 * variable names. 
 *
 *
 * @author Simon Butler <simon@facetus.org.uk>
 * @version $Id: TypeAcronymDetector.java 56 2015-04-02 18:43:02Z simon $
 */
public class TypeAcronymDetector implements Detector {

    private final RulesetGroup ruleSetGroup;

    public TypeAcronymDetector(RulesetGroup ruleSetGroup) {
        this.ruleSetGroup = ruleSetGroup;
    }

    /**
     * Evaluates the content of a reference identifier name.
     * @param identifierName a name to be evaluated
     * @return a {@code TypeAcronymInformation} object or {@code null} if
     * a non-reference species is tested. 
     */
    @Override
    public TypeAcronymInformation test( IdentifierName identifierName ) {
        TypeAcronymInformation information = null; 
        if ( identifierName.species().isReference() ) {
            Rule taRule = this.ruleSetGroup.get( 
                    identifierName.classification(), 
                    RuleType.TYPE_ACRONYM );
            information = (TypeAcronymInformation) taRule.test( identifierName );
        }
        return information;
    }

}
