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
import uk.ac.open.crc.nominal.information.TypeAcronymInformation;

// TODO -- look at the feasibility of testing trailing type acronyms.
// e.g. HtmlEditorKit ek; suggest at least 2 characters required.
/**
 * A {@code Rule} used to detect and evaluate type acronyms.
 */
public class TypeAcronymRule extends AbstractRule {
    private static final TypeAcronymCache taCache = TypeAcronymCache.getInstance();
    private final boolean isPermitted;

    /**
     * Creates a default type acronym rule where type acronyms
     * are not permitted, but are detected, so that misuse of 
     * type acronyms can be detected.
     */
    public TypeAcronymRule() {
        this( false );
    }

    /**
     * Creates a permissive or prohibitive type acronym rule.
     * @param isPermitted flags whether type acronyms are permitted. A 
     * value of {@code false} creates the same rule as the no argument
     * constructor.
     */
    public TypeAcronymRule( final boolean isPermitted ) {
        super( RuleType.TYPE_ACRONYM );
        this.isPermitted = isPermitted ;
    }

    @Override
    public TypeAcronymInformation test( IdentifierName identifierName ) {

        boolean isCorrect;
        boolean isTypeAcronym;
        if ( identifierName.tokenCount() == 1 ) {
            String typeAcronym = taCache.acronym( identifierName.type() );
            isTypeAcronym = 
                    identifierName.nameString().toLowerCase().equals( typeAcronym );
        }
        else {
            isTypeAcronym = false;
        }
        
        isCorrect = this.isPermitted && isTypeAcronym;
        
        TypeAcronymInformation information = 
                new TypeAcronymInformation( isCorrect, isTypeAcronym );
        identifierName.add( information );
        
        return information;
    }
}
