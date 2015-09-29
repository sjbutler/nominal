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

package uk.ac.open.crc.nominal.detectors;

import java.util.ArrayList;
import java.util.List;
import uk.ac.open.crc.mdsc.AbbreviationDictionaryManager;
import uk.ac.open.crc.mdsc.DictionaryManager;
import uk.ac.open.crc.mdsc.DictionarySet;
import uk.ac.open.crc.mdsc.Result;
import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.Token;
import uk.ac.open.crc.nominal.information.AbbreviationInformation;
import uk.ac.open.crc.nominal.information.AbbreviationSummaryInformation;
import uk.ac.open.crc.nominal.rules.RulesetGroup;

/**
 * Establishes whether the tokens of an identifier name are known abbreviations.
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class AbbreviationDetector implements Detector {
    private final RulesetGroup ruleSetGroup;  // not currently used. Will need to be used to identify legitimate use of abbreviations other than ciphers
    private final DictionaryManager dictionaryManager;
    private final DictionarySet abbreviationDictionaries;
     
    /**
     * Creates a detector using the supplied rule set.
     * @param ruleSetGroup the rules to be applied by the detector.
     */
    public AbbreviationDetector( RulesetGroup ruleSetGroup ) {
        this.ruleSetGroup = ruleSetGroup;
        this.dictionaryManager = new AbbreviationDictionaryManager();
        this.abbreviationDictionaries = this.dictionaryManager.dictionarySet();
    }
    
    
    /**
     * Checks each token to determine whether it is an abbreviation and 
     * annotates each token and the identifier name with results.
     * @param identifierName the identifier name to test.
     * @return a summary of the results. The same object is attached to the 
     * identifier name.
     */
    @Override
    public AbbreviationSummaryInformation test( IdentifierName identifierName ) {
        
        List<AbbreviationInformation> informationList = new ArrayList<>();
        
        for ( Token token : identifierName.taggedTokens() ) {
            List<Result> resultList = this.abbreviationDictionaries.spellCheck( token.text() );

            AbbreviationInformation information = new AbbreviationInformation( resultList ); 
            
            // check whether any abbreviation should be expanded.

            // test in AMAP whether there are expansions for any of these
            // Need AMAP functionality available to implement


            // for the skeleton implementation -- revise as more detail is available
            
            token.add( information );
            informationList.add( information );
        }
        
        AbbreviationSummaryInformation summaryInformation = 
                new AbbreviationSummaryInformation( informationList );
       
        identifierName.add( summaryInformation );
        return summaryInformation;
    }
    
    
}
