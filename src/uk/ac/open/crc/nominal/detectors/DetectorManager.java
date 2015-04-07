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
import uk.ac.open.crc.nominal.information.Information;
import uk.ac.open.crc.nominal.rules.RulesetGroup;

/**
 *
 * Would a chain of responsibility be better than a set, because I need
 * to control execution order, which I cannot guarantee with iterating 
 * over a set. 
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class DetectorManager {

    private final RulesetGroup ruleSetGroup;
    
    // has to be a list to guarantee iteration order.
    private final ArrayList<Detector> detectorList;
    
    public DetectorManager( RulesetGroup ruleSetGroup ) {
        this.ruleSetGroup = ruleSetGroup;
        this.detectorList = new ArrayList<>();
        
        // now build the detector set
        //this.detectorSet.add( new AbbreviationDetector( this.ruleSetGroup ) );  // managed by SpellingDetector
        //this.detectorSet.add( new AcronymDetector( this.ruleSetGroup ) );  // managed by SpellingDetector
        //this.detectorSet.add( new AcronymTypographyDetector( this.ruleSetGroup ) );  // managed by SpellingDetector
        this.detectorList.add( new BodyCapitalisationDetector( this.ruleSetGroup ) );
        //this.detectorSet.add( new CipherDetector( this.ruleSetGroup ) );  // managed by SpellingDetector
        this.detectorList.add( new FirstCharacterCapitalisationDetector( this.ruleSetGroup ) );
        this.detectorList.add( new LeadingUnderscoreDetector() );
        this.detectorList.add( new PhraseStructureDetector( this.ruleSetGroup ) );
        this.detectorList.add( new PrefixDetector( this.ruleSetGroup ) );
        this.detectorList.add( new StandardPrefixDetector( this.ruleSetGroup ) );
        this.detectorList.add( new RedundantPrefixDetector( this.ruleSetGroup ) );
        this.detectorList.add( new SeparatorDetector( this.ruleSetGroup ) );
        this.detectorList.add( new SpellingDetector( this.ruleSetGroup ) );
        this.detectorList.add( new StandaloneAbbreviationDetector( this.ruleSetGroup ) );
        // to do
//        this.detectorList.add( new TrailingDigitDetector() );
        this.detectorList.add( new TrailingUnderscoreDetector() );
        this.detectorList.add( new PluralDetector( this.ruleSetGroup ) );
    }
    
    
    
    public IdentifierName test( IdentifierName identifierName ) {
        
        this.detectorList.stream().forEach( (detector) -> { 
            detector.test( identifierName );
        } );
        
        return identifierName;
    }
    
}
