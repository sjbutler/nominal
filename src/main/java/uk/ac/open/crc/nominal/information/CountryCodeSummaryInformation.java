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

/**
 * Records whether a identifier name contains a token that is an ISO 3166 
 * alpha 2 or alpha 3 country code. Full details are in the information 
 * object attached to the token,
 * <p>
 * The semantics of this object are inaccurate. The object records the presence
 * of an ISO 3166 country code in the name. Only JLS forbids the use of country 
 * codes. The semantics will change when the language is expanded to specify
 * the use of country codes. 
 * </p>
 */
public class CountryCodeSummaryInformation extends IdentifierInformation {

    private final boolean isCorrect;
    
    /**
     * Creates a summary of the presence of ISO 3166 country codes in the name.
     * @param isCorrect {@code true} if any token contains a country code
     */
    public CountryCodeSummaryInformation( final boolean isCorrect ) {
        super( InformationClassification.COUNTRY_CODE_SUMMARY );
        this.isCorrect = isCorrect;
    }
    
    /**
     * Misused semantics to indicate the presence of a country code in the name.
     * @return {@code true} if a token in the name matches 
     * an ISO 3166 country code
     */
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
}
