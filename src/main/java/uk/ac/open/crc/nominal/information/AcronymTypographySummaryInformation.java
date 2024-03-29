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
 * Summary of information about acronym typography in a name.
 */
public class AcronymTypographySummaryInformation extends IdentifierInformation {
    
    private final boolean isCorrect;
    
    /**
     * Creates a summary information object.
     * @param isCorrect indicates whether acronyms adhere to the specified typography
     */
    public AcronymTypographySummaryInformation( boolean isCorrect ) {
        super( InformationClassification.ACRONYM_TYPOGRAPHY_SUMMARY );
        this.isCorrect = isCorrect;
    }
    
    /**
     * Indicates if the name follows the rules on acronym typography.
     * @return {@code true} if acronyms are used in accordance with the rule.
     */
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
}
