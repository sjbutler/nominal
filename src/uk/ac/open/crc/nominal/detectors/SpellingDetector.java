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
import uk.ac.open.crc.nominal.information.AbbreviationSummaryInformation;
import uk.ac.open.crc.nominal.information.AcronymInformation;
import uk.ac.open.crc.nominal.information.AcronymSummaryInformation;
import uk.ac.open.crc.nominal.information.CipherInformation;
import uk.ac.open.crc.nominal.information.CountryCodeInformation;
import uk.ac.open.crc.nominal.information.CountryCodeSummaryInformation;
import uk.ac.open.crc.nominal.information.TypeAcronymInformation;
import uk.ac.open.crc.nominal.information.InformationClassification;
import uk.ac.open.crc.nominal.information.PrefixInformation;
import uk.ac.open.crc.nominal.information.SpellingInformation;
import uk.ac.open.crc.nominal.information.SpellingSummaryInformation;
import uk.ac.open.crc.nominal.Token;
import uk.ac.open.crc.nominal.information.TokenInformation;
import uk.ac.open.crc.mdsc.DictionarySet;
import uk.ac.open.crc.mdsc.Result;
import uk.ac.open.crc.nominal.TaggedToken;
import uk.ac.open.crc.nominal.rules.MdscDictionaryPool;

/**
 * Classifies each token in the name. This class also manages
 * instantiation and invocation of the abbreviation, acronym, 
 * acronym typography, cipher, country code, and type acronym detectors.
 * 
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class SpellingDetector implements Detector {

    private static final DictionarySet DICTIONARY = 
            MdscDictionaryPool.getInstance().wordDictionaries();
    
    
    private final RulesetGroup ruleSetGroup;  // not used, this is a test of spelling
    
    private final AbbreviationDetector abbbreviationDetector;
    private final AcronymDetector acronymDetector;
    private final AcronymTypographyDetector acronymTypographyDetector;
    private final CipherDetector cipherDetector;
    private final CountryCodeDetector countryCodeDetector;
    private final TypeAcronymDetector typeAcronymDetector;
    
    
    public SpellingDetector( RulesetGroup ruleSetGroup ) {
        this.ruleSetGroup = ruleSetGroup;
        this.abbbreviationDetector = new AbbreviationDetector( ruleSetGroup );
        this.acronymDetector = new AcronymDetector( ruleSetGroup );
        this.acronymTypographyDetector = new AcronymTypographyDetector( ruleSetGroup );
        this.cipherDetector = new CipherDetector( ruleSetGroup );
        this.countryCodeDetector = new CountryCodeDetector( ruleSetGroup );
        this.typeAcronymDetector = new TypeAcronymDetector( ruleSetGroup );
    }
    
    // REFACTOR -- look for common levels of abstraction and repetitive code.
    /**
     * Tests the spelling of tokens in the name.
     * @param identifierName the name to test
     * @return a summary of the classification and spelling of tokens
     */
    @Override
    public SpellingSummaryInformation test( IdentifierName identifierName ) {
        // there is no rule for spelling -- it has to be correct
        // However, some rules (e.g. Gosling) will permit the use of abbreviations
        // particularly for formal arguments and local variables
        // need to exclude prefixes from spelling check 
        
        
        // now iterate over the tokens
        List<TaggedToken> taggedTokens = identifierName.taggedTokens();
        ArrayList<Boolean> isSpellingCorrect = new ArrayList<>();
        for ( TaggedToken token : taggedTokens ) {
            List<Result> results = DICTIONARY.spellCheck( token.normalisedText() );
            SpellingInformation information = new SpellingInformation( results );
            boolean isTokenSpellingCorrect = information.isCorrect();
            token.add( information );
            isSpellingCorrect.add( isTokenSpellingCorrect );
        } 
        
        // test for abbreviation
        AbbreviationSummaryInformation abbreviationSummaryInformation = 
                this.abbbreviationDetector.test( identifierName );
        // test for acronym
        AcronymSummaryInformation acronymSummaryInformation = 
                this.acronymDetector.test( identifierName );
        // test for cipher -- cipher returns null if the test is not appropriate (i.e. >1 tokens)
        CipherInformation cipherInformation = 
                this.cipherDetector.test( identifierName );
        // test for country codes
        CountryCodeSummaryInformation countryCodeSummaryInformation = 
                this.countryCodeDetector.test( identifierName );
        // check for a Gosling acronym
        TypeAcronymInformation typeAcronymInformation = 
                this.typeAcronymDetector.test( identifierName );
        // acronym typography
//        AcronymTypographySummaryInformation acronymTypographySummaryInformation = 
//                this.acronymTypographyDetector.test( identifierName );
        // iterate over the tokens to determine as summary of
        // spelling correctness
        // - the name is a correctly used cipher
        // - every token is a recognised word or acronym, preceded (if appropriate) by correctly used branding or prefix
        boolean isCorrect;
        if ( cipherInformation != null && typeAcronymInformation != null ) {
            if ( cipherInformation.isCorrect() || typeAcronymInformation.isCorrect() ) {
                isCorrect = true;
            }
            else {
                Token firstToken = identifierName.firstToken();
                if ( firstToken != null ) {
                    SpellingInformation spellingInformation = 
                            (SpellingInformation) firstToken.getInformationList(InformationClassification.SPELLING ).get( 0 );
                    AcronymInformation acronymInformation = 
                            (AcronymInformation) firstToken.getInformationList(InformationClassification.ACRONYM ).get( 0 );
                    isCorrect = spellingInformation.isCorrect() 
                            || acronymInformation.isCorrect();
                }
                else {
                    isCorrect = false; // only thing I can do -- it makes some sense semantically -- this would include a correct iso3166 code being used in a single toke identifier name, which Gosling forbids
                }
            }
        }
        else {
            SpellingInformation spellingInformation;
            AcronymInformation acronymInformation;
            PrefixInformation prefixInformation;
            CountryCodeInformation countryCodeInformation;
            
            List<Boolean> testList = new ArrayList<>();
            for ( Token token : identifierName.taggedTokens() ) {
                spellingInformation = 
                        (SpellingInformation) token.getInformationList(InformationClassification.SPELLING ).get( 0 );
                acronymInformation = 
                        (AcronymInformation) token.getInformationList(InformationClassification.ACRONYM ).get( 0 );
                countryCodeInformation = 
                        (CountryCodeInformation) token.getInformationList(InformationClassification.COUNTRY_CODE ).get( 0 );
                List<TokenInformation> prefixInformationList = 
                        token.getInformationList(InformationClassification.PREFIX );
                if ( ! prefixInformationList.isEmpty() ) {
                    prefixInformation = (PrefixInformation) prefixInformationList.get( 0 );
                    testList.add( spellingInformation.isCorrect() 
                            || acronymInformation.isCorrect() 
                            || countryCodeInformation.isCorrect()
                            || prefixInformation.isCorrect() );
                }
                else {
                    testList.add( spellingInformation.isCorrect() 
                            || acronymInformation.isCorrect()
                            || countryCodeInformation.isCorrect() );
                }
            }
            isCorrect = ! testList.contains( false );
        }
        
        
        SpellingSummaryInformation summaryInformation = 
                new SpellingSummaryInformation( 
                        isCorrect,
                        isSpellingCorrect, 
                        abbreviationSummaryInformation, 
                        acronymSummaryInformation, 
                        cipherInformation );
        identifierName.add( summaryInformation );
        
        return summaryInformation;
    }
}
