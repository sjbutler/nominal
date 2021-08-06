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
 * Summarises the {@code BodyCapitalisationInformation} objects for a name
 * to give correctness of typography of all tokens with the exception of the 
 * first character of the first token.
 */
public class BodyCapitalisationSummaryInformation extends IdentifierInformation {

    private final boolean isCorrect;
    
    public BodyCapitalisationSummaryInformation( boolean isCorrect ) {
        super( InformationClassification.CAPITALISATION_INTERNAL_SUMMARY );
        this.isCorrect = isCorrect;
    }
    
    /**
     * Indicates the correctness of the typography of all the tokens with the 
     * exception of the first character of a name.
     * @return {@code true} if typography of tokens is correct (with the 
     * exception of the first character of the first token)
     */
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
}
