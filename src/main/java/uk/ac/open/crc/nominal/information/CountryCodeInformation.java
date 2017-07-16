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
 * Records whether a token is an ISO 3166 alpha 2 or alpha 3 country code.
 */
public class CountryCodeInformation extends TokenInformation {
    private final boolean isIso3166_2;
    private final boolean isIso3166_3;
    
    public CountryCodeInformation( final boolean isIso3166_2, final boolean isIso3166_3 ) {
        super( InformationClassification.COUNTRY_CODE );
        this.isIso3166_2 = isIso3166_2;
        this.isIso3166_3 = isIso3166_3;
    }
    
    // will be revised to reflect rules on country code use when they are
    // implemented.
    /**
     * Misuse of this method to indicate that the token is a 
     * country code.
     * @return {@code true} iff the token is an ISO3166 two or three letter
     * country code.
     */
    @Override
    public boolean isCorrect() {
        return this.isIso3166_2 || this.isIso3166_3;
    }
}
