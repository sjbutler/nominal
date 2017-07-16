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
import uk.ac.open.crc.mdsc.AcronymDictionaryManager;
import uk.ac.open.crc.mdsc.DictionaryManager;
import uk.ac.open.crc.mdsc.DictionarySet;
import uk.ac.open.crc.mdsc.Result;
import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.Token;
import uk.ac.open.crc.nominal.information.AcronymInformation;
import uk.ac.open.crc.nominal.information.AcronymSummaryInformation;
import uk.ac.open.crc.nominal.rules.RulesetGroup;

/**
 * Identifies whether any tokens in the name are acronyms.
 */
public class AcronymDetector implements Detector {
    private final RulesetGroup ruleSetGroup; // redundant, unless/until the user can add acronyms to the rules.
    
    private final DictionaryManager dictionaryManager;
    private final DictionarySet acronymDictionaries;
    
    /**
     * Creates an acronym detector for the given rule set
     * @param ruleSetGroup a set of rules
     */
    public AcronymDetector( RulesetGroup ruleSetGroup ) {
        this.ruleSetGroup = ruleSetGroup;
        this.dictionaryManager = new AcronymDictionaryManager();
        this.acronymDictionaries = dictionaryManager.dictionarySet();
    }
    
    /**
     * Tests each token of the name to determine if it is an acronym and 
     * annotates each token with the result.
     * @param identifierName a name to test
     * @return a summary of the results for the entire name.
     */
    @Override
    public AcronymSummaryInformation test( IdentifierName identifierName ) {
        List<AcronymInformation> informationList = new ArrayList<>();
        
        for ( Token token : identifierName.taggedTokens() ) {
            List<Result> resultList = this.acronymDictionaries.spellCheck( token.text() );
            AcronymInformation information = new AcronymInformation( resultList );
            
            token.add( information );
            informationList.add( information );
        }
        
        AcronymSummaryInformation summaryInformation = 
                new AcronymSummaryInformation( informationList );
        
        identifierName.add( summaryInformation );
        
        return summaryInformation;
    }
    
}
