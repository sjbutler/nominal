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

package uk.ac.open.crc.nominal.rules;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.information.PluralInformation;
import uk.ac.open.crc.nominal.information.IdentifierInformation;
import uk.ac.open.crc.nominal.information.InformationClassification;
import uk.ac.open.crc.nominal.information.PhraseInformation;

/**
 * Represents a plural rule.
 */
public class PluralRule extends AbstractRule {
    private final GrammaticalNumber grammaticalNumber;
    private boolean isPlural;
    
    /**
     * Creates an instance of {@code PluralRule}. This rule is only ever
     * instantiated when the use of plural or singular forms has been 
     * specified in nominal.
     * @param isPlural {@code true} specifies plural, {@code false} singular
     */
    public PluralRule( boolean isPlural ) {
        super(RuleType.PLURAL );
        this.isPlural = isPlural;
        this.grammaticalNumber = this.isPlural 
                                 ? GrammaticalNumber.PLURAL 
                                 : GrammaticalNumber.SINGLUAR;
    }
    
    /**
     * Creates a default 'unspecified' plural rule for the given rule set. This
     * will cause the test method to return a result that is correct and 
     * that indicates no plural was expected.
     */
    public PluralRule() {
        super( RuleType.PLURAL );
        this.grammaticalNumber = GrammaticalNumber.UNSPECIFIED;
    }
    
    /**
     * {@inheritDoc }
     * @param identifierName {@inheritDoc }
     * @return {@inheritDoc }
     */
    @Override
    public PluralInformation test( IdentifierName identifierName ) {
        boolean isCorrect;
        boolean isPluralExpected;
        boolean isPluralised;
        
        boolean isUnspecified = this.grammaticalNumber == GrammaticalNumber.UNSPECIFIED;
        
        List<IdentifierInformation> phraseInformationList = 
                identifierName.getInformationList(InformationClassification.PHRASE );
        PhraseInformation phraseInformation = 
                (PhraseInformation) phraseInformationList.get( 0 );
        // if the above line throws an NPE the phrasal detector has not been
        // run previously, and there is an error elsewhere in the code.
        // DetectorManager may be a good place to start!
        isPluralised = phraseInformation.isPlural();
        
        if ( ! isUnspecified ) {
            isPluralExpected = this.isPlural;

            isCorrect = (isPluralExpected && isPluralised) 
                    || ( ! isPluralExpected && ! isPluralised ) ;
        }
        else {
            isCorrect = true;
            isPluralExpected = false;
        }
        
        PluralInformation information = 
                new PluralInformation( 
                        isCorrect, isPluralExpected, isUnspecified, isPluralised );
        
        identifierName.add( information );
        
        return information;
    }
    
    /**
     * {@inheritDoc }
     * @return {@inheritDoc }
     */
    @Override
    public String toString() {
        return this.grammaticalNumber.description();
    }

}
