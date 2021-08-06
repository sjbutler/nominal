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
 * Carries information about the pluralisation of a name.
 *
 */
public class PluralInformation extends IdentifierInformation {

    private final boolean isCorrect;
    private final boolean isPluralExpected;
    private final boolean isUnspecified;
    private final boolean isPlural;

    /**
     * Creates an information object.
     * @param isCorrect indicates whether the rule on pluralisation has be 
     * correctly applied in the name tested
     * @param isPluralExpected does the rule indicate that a plural is to be used
     * @param isUnspecified indicates if pluralisaton is specified
     * @param isPlural indicates whether a plural has been found
     */
    public PluralInformation(
            final boolean isCorrect,
            final boolean isPluralExpected,
            final boolean isUnspecified,
            final boolean isPlural ) {
        super(InformationClassification.GRAMMATICAL_NUMBER );
        this.isCorrect = isCorrect;
        this.isPluralExpected = isPluralExpected;
        this.isUnspecified = isUnspecified;
        this.isPlural = isPlural;
    }

    /**
     * Indicates if the specified pluralisation rule is adhered to.
     * @return {@code true} iff singular or plural are used correctly
     */
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }

    /**
     * Indicates whether the rule specified the use of a plural.
     * @return {@code true} if a plural was specified in the rule.
     */
    public boolean isPluralExpected() {
        return this.isPluralExpected;
    }

    /**
     * Indicates whether the rule for plurals is 'unspecified'.
     * @return {@code true} if plural use is unspecified
     */
    public boolean isUnspecified() {
        return this.isUnspecified;
    }
    
    /**
     * Indicates if the name is a plural.
     * @return {@code true} if the name is a plural.
     */
    public boolean isPlural() {
        return this.isPlural;
    }
}
