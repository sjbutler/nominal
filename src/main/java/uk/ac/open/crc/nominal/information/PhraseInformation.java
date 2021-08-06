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

import java.util.List;

/**
 * Records the correctness of the phrasal structure used in the name.
 */
public class PhraseInformation extends IdentifierInformation {

    private final boolean isCorrect;
    private final String phraseSummary;
    private final List<String> posTags;
    private final boolean isPlural;

    /**
     * Creates an information object.  
     * @param isCorrect indicates whether the phrase found matches one of those 
     * specified in the rule set
     * @param phraseSummary a summary of the phrase found
     * @param posTags the PoS tags found
     */
    public PhraseInformation( 
            boolean isCorrect, 
            String phraseSummary, 
            List<String> posTags) {
        super( InformationClassification.PHRASE );
        this.isCorrect = isCorrect;
        this.phraseSummary = phraseSummary;
        this.posTags = posTags;
        if ( this.posTags != null ) {
            int lastIndex = this.posTags.size() - 1;
            if ( this.phraseSummary.toUpperCase().endsWith( "NP" ) ) {
                this.isPlural = 
                        this.posTags.get( lastIndex ).toUpperCase().endsWith( "NNS" );
            }
            else {
                this.isPlural = false;
            }
        }
        else {
            this.isPlural = false; // it's certainly not the plural form of a word, though it may have a plural meaning.
        }
    }
    
    /**
     * Indicates whether the phrase found matches one specified in the rule set.
     * @return true if the phrase found is specified in the rule set
     */
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
    /**
     * Retrieves the phrase summary.
     * @return a phrase summary
     */
    public String phraseSummary() {
        return this.phraseSummary;
    }
    
    /**
     * Indicates whether the phrase found is tagged as a plural. The method 
     * is only relevant if the name consists of or ends in a noun phrase
     * @return true if the name is considered plural
     */
    public boolean isPlural() {
        return isPlural;
    }
}
