/*
 Copyright (C) 2013-2015 The Open University
 Copyright (C) 2017 Simon Butler

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

import java.util.ArrayList;
import java.util.List;
import uk.ac.open.crc.mdsc.DictionaryManager;
import uk.ac.open.crc.mdsc.DictionarySet;
import uk.ac.open.crc.mdsc.NormalisedIso3166DictionaryManager;
import uk.ac.open.crc.mdsc.Result;
import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.Token;
import uk.ac.open.crc.nominal.information.CountryCodeInformation;
import uk.ac.open.crc.nominal.information.CountryCodeSummaryInformation;
import uk.ac.open.crc.nominal.rules.RulesetGroup;

/**
 * Provides a detector for ISO3166 country codes. 
 */
public class CountryCodeDetector implements Detector {

    private static final DictionaryManager countryCodeDictionaryManager =  
            new NormalisedIso3166DictionaryManager();
    
    private final RulesetGroup ruleSetGroup; // unused atm
    private final DictionarySet countryCodeDictionarySet;
    
    /**
     * Creates the detector.
     * @param ruleSetGroup a rule set to apply
     */
    public CountryCodeDetector( final RulesetGroup ruleSetGroup ) {
        this.ruleSetGroup = ruleSetGroup;
        this.countryCodeDictionarySet = countryCodeDictionaryManager.dictionarySet();
    }
    
    // to be revised when rules on country codes are implemented
    @Override
    public CountryCodeSummaryInformation test( final IdentifierName identifierName ) {
        List<Boolean> codesDetected = new ArrayList<>();
        
        for ( Token token : identifierName.taggedTokens() ) {
            CountryCodeInformation information = createCountryCodeInformation(token);
            codesDetected.add( information.isCorrect() );
            token.add( information );
        }
        
        CountryCodeSummaryInformation summaryInformation 
                = new CountryCodeSummaryInformation( codesDetected.contains( true ) );
        identifierName.add( summaryInformation );
        
        return summaryInformation;
    }
    
    
    private CountryCodeInformation createCountryCodeInformation(Token token) {
        boolean isThreeLetterCode = false;
        boolean isTwoLetterCode = false;
        if ( token.text().length() <= 3 ) {
            List<Result> results = this.countryCodeDictionarySet.spellCheck( token.text() );
            
            isTwoLetterCode = results.stream()
                    .anyMatch( r -> r.isCorrect() && r.dictionaryName().equals( "iso3166-2") );
            isThreeLetterCode = results.stream()
                    .anyMatch( r ->  r.isCorrect() && r.dictionaryName().equals( "iso3166-3") );
        }
        return new CountryCodeInformation( isTwoLetterCode, isThreeLetterCode );
    }
}
