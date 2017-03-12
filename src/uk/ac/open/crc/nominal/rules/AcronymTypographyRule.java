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

import java.util.ArrayList;
import java.util.List;
import uk.ac.open.crc.idtk.Modifier;
import uk.ac.open.crc.idtk.Species;
import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.TaggedToken;
import uk.ac.open.crc.nominal.information.AcronymSummaryInformation;
import uk.ac.open.crc.nominal.information.AcronymTypographyInformation;
import uk.ac.open.crc.nominal.information.AcronymTypographySummaryInformation;
import uk.ac.open.crc.nominal.information.IdentifierInformation;
import uk.ac.open.crc.nominal.information.InformationClassification;

/**
 * A configurable rule for acronym typography.
 */
public class AcronymTypographyRule extends AbstractRule {

    private static final String FIRST_TOKEN_MIXED_LC_PATTERN = "^[a-z0-9]+$";
    private static final String FIRST_TOKEN_MIXED_UC_PATTERN = "^[A-Z0-9][a-z0-9]*$";
    private static final String OTHER_TOKEN_MIXED_CASE_PATTERN = "^[A-Z0-9][a-z0-9]*$";
    private static final String OTHER_TOKEN_UPPER_CASE_PATTERN = "^[A-Z0-9]+$";
    
    private final CaseType caseType;
    private String firstTokenPattern;
    private final String otherTokenPattern;
    
    /**
     * Creates a rule for acronym typography according to the argument.
     * @param caseType indicates upper or mixed case acronyms
     */
    public AcronymTypographyRule( final CaseType caseType ) {
        super( RuleType.ACRONYM );
        this.caseType = caseType;
        
        if ( this.caseType == CaseType.MIXED ) {
            this.otherTokenPattern = OTHER_TOKEN_MIXED_CASE_PATTERN;
        }
        else {
            this.otherTokenPattern = OTHER_TOKEN_UPPER_CASE_PATTERN;
        }
    }
    
    /**
     * Tests any acronyms in the name for 'correct' acronym typography.
     * @param identifierName a name to test
     * @return A summary indicating which acronyms have correct typography 
     * or {@code null} if the name contains no acronyms
     */
    @Override
    public AcronymTypographySummaryInformation test( IdentifierName identifierName ) {
        // set first token using name context
        if ( identifierName.species().isClassOrInterface() ) {
            if ( this.caseType == CaseType.MIXED ) {
                this.firstTokenPattern = FIRST_TOKEN_MIXED_UC_PATTERN;
            }
            else {
                this.firstTokenPattern = OTHER_TOKEN_UPPER_CASE_PATTERN;
            }
        }
        else if ( identifierName.species() == Species.FIELD ) {
            if ( isConstant( identifierName.modifiers() ) ) {
                this.firstTokenPattern = OTHER_TOKEN_UPPER_CASE_PATTERN;
            }
            else {
                this.firstTokenPattern = FIRST_TOKEN_MIXED_LC_PATTERN;
            }
        }
        else {
                this.firstTokenPattern = FIRST_TOKEN_MIXED_LC_PATTERN;
        }
        
        return acronymTypographySummary(identifierName);
    }
    
    private boolean isCorrectFirstToken( TaggedToken token ) {
        return this.firstTokenPattern.matches( token.text() );
    }
    
    private boolean isCorrectOtherToken( TaggedToken token ) {
        return this.otherTokenPattern.matches( token.text() );
    }
    
    private boolean isConstant( List<Modifier> modifiers ) {
        return modifiers.contains( Modifier.FINAL ) 
                && modifiers.contains( Modifier.STATIC );
    }
    
    private AcronymTypographySummaryInformation acronymTypographySummary(IdentifierName identifierName) {
        AcronymTypographySummaryInformation summaryInformation = null;
        List<IdentifierInformation> informationList = 
                identifierName.getInformationList( InformationClassification.ACRONYM_SUMMARY );
        AcronymSummaryInformation acronymSummaryInformation = 
                (AcronymSummaryInformation) informationList.get( 0 );
        if ( acronymSummaryInformation != null ) {
            List<Integer> acronymIndices = acronymSummaryInformation.acronymIndices();
            List<Boolean> overallCorrectness = new ArrayList<>();
            
            if ( ! acronymIndices.isEmpty() ) {
                List<TaggedToken> tokens = identifierName.taggedTokens();
                boolean isCorrect;
                for ( int i = 0; i < acronymIndices.size(); i++ ) {
                    TaggedToken token = tokens.get( acronymIndices.get(i) );
                    if ( i == 0 ) {
                        isCorrect = isCorrectFirstToken(token );
                    }
                    else {
                        isCorrect = isCorrectOtherToken(token );
                    }
                    AcronymTypographyInformation acronymTypographyInformation = 
                            new AcronymTypographyInformation( isCorrect );
                    token.add( acronymTypographyInformation );
                    overallCorrectness.add( isCorrect );
                }
                summaryInformation = 
                        new AcronymTypographySummaryInformation( ! overallCorrectness.contains( false ) );
            }
        }
        
        return summaryInformation;
    }
    
}
