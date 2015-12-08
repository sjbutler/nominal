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

package uk.ac.open.crc.nominal.information;

import java.util.List;

// Is this a practical proposition?
// Review the reasoning behind this class and the states
// it is expected to be able to report.
// There is also a great deal of payload that is never
// used. Why?
/**
 * Summarises the spelling information for the entire identifier name.
 * 
 */
public class SpellingSummaryInformation extends IdentifierInformation {

    private final boolean isCorrect;
    
    // look at the parameters -- most are unused. See comment above. 
    /**
     * Creates a summary information object.
     * @param isCorrect indicates whether the name is correctly spelt
     * @param isSpellingCorrect a list of the correctness of the spelling of each token
     * @param abbreviationInformation a
     * @param acronymInformation a
     * @param cipherInformation a
     */
    public SpellingSummaryInformation( 
            final boolean isCorrect,
            final List<Boolean> isSpellingCorrect, 
            final AbbreviationSummaryInformation abbreviationInformation, 
            final AcronymSummaryInformation acronymInformation, 
            final CipherInformation cipherInformation ) {
        super( InformationClassification.SPELLING_SUMMARY );
        this.isCorrect = isCorrect;
    }
    
    
    
    /**
     * Reports whether the name can be summarised as being correctly spelt.
     * <p>The notion of correctness is that:</p>
     * <ol>
     *  <li>every token is a recognised word or acronym, or iso country code</li>
     *  <li>every token is a recognised word or acronym, or iso country code, 
     * preceded by correctly used branding or prefix</li>
     *  <li>or the identifier name is a correctly used cipher.</li>
     * </ol>
     * <p>Correctness is determined in {@linkplain uk.ac.open.crc.nominal.detectors.SpellingDetector} as it has 
     * access to the identifier name.</p>
     * @return {@code true} if each token is 'correct'
    */
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
    
}
