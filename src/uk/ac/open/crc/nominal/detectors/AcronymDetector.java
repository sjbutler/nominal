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
import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.rules.RulesetGroup;
import uk.ac.open.crc.nominal.information.AcronymInformation;
import uk.ac.open.crc.nominal.information.AcronymSummaryInformation;
import uk.ac.open.crc.nominal.Token;
import uk.ac.open.crc.mdsc.AcronymDictionaryManager;
import uk.ac.open.crc.mdsc.DictionaryManager;
import uk.ac.open.crc.mdsc.DictionarySet;
import uk.ac.open.crc.mdsc.Result;

/**
 *
 *
 *
 * @author Simon Butler <simon@facetus.org.uk>
 * @version $Id: AcronymDetector.java 56 2015-04-02 18:43:02Z simon $
 */
public class AcronymDetector implements Detector {
    private final RulesetGroup ruleSetGroup; // redundant, unless/until the user can add acronyms to the rules.
    
    private final DictionaryManager dictionaryManager;
    private final DictionarySet acronymDictionaries;
    
    public AcronymDetector( RulesetGroup ruleSetGroup ) {
        this.ruleSetGroup = ruleSetGroup;
        this.dictionaryManager = new AcronymDictionaryManager();
        this.acronymDictionaries = dictionaryManager.dictionarySet();
    }
    
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