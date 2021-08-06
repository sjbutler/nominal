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

package uk.ac.open.crc.nominal.information;

/**
 * Annotates a single token name to record whether it is a type acronym, and 
 * if so whether it is used correctly.
 */
public class TypeAcronymInformation extends IdentifierInformation {

    private final boolean isCorrect;
    private final boolean isTypeAcronym;
    
    /**
     * Creates an information object.
     * @param isCorrect indicates whether the use of a type acronym accords to 
     * the specified rules
     * @param isTypeAcronym indicates if the name used is a type acronym
     */
    public TypeAcronymInformation( boolean isCorrect, final boolean isTypeAcronym ) {
        super(InformationClassification.TYPE_ACRONYM );
        this.isCorrect = isCorrect;
        this.isTypeAcronym = isTypeAcronym;
    }
    
    /**
     * Indicates whether the type acronym, if present, is used according to the
     * user specified rules.
     * @return true if any type acronym is used according to the specified rules
     */
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
    /**
     * Indicates whether the token is a type acronym.
     * @return true if the token is a type acronym
     */
    public boolean isTypeAcronym() {
        return this.isTypeAcronym;
    }
    
}
