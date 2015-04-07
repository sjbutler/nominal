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

package uk.ac.open.crc.nominal.rules;

import java.util.ArrayList;
import java.util.List;
import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.TaggedToken;
import uk.ac.open.crc.nominal.Token;
import uk.ac.open.crc.nominal.information.BodyCapitalisationInformation;
import uk.ac.open.crc.nominal.information.BodyCapitalisationSummaryInformation;

/**
 * Embodies a rule for the capitalisation of the component words of 
 * an identifier name. 
 *
 *
 * @author Simon Butler <simon@facetus.org.uk>
 * @version $Id: BodyTypographyRule.java 56 2015-04-02 18:43:02Z simon $
 */
public class BodyTypographyRule extends AbstractRule {

    private static final String EXPLANATION_MIXED_FAILURE = "identifier does not match mixed case format";
    private static final String EXPLANATION_MIXED_SUCCESS = "identifier matches mixed case format";
    private static final String EXPLANATION_UPPER_FAILURE = "identifier does not match upper case format";
    private static final String EXPLANATION_UPPER_SUCCESS = "identifier matches upper case format";
    private static final String EXPLANATION_LOWER_FAILURE = "identifier does not match lower case format";
    private static final String EXPLANATION_LOWER_SUCCESS = "identifier matches lower case format";
    
    
    private final CaseType caseType;
    private String explanation;
    
    /**
     * Creates an instance of the rule with the strict parameter set to 
     * {@code false}.
     * @param caseType The case in which the body of the identifier name is expected
     * to be.
     */
    public BodyTypographyRule( CaseType caseType ) {
        super( RuleType.BODY ); 
        this.caseType = caseType;
        this.explanation = "";
    }
    
    // NB future versions will require that the spelling detector has been
    // run first as they will need the acronym information 
    // to be available to 
    // support variations in the capitalisation of acronyms.
    // Do not test the first token in the name -- that is the responsibility of 
    // another detector & rule.
    @Override
    public BodyCapitalisationSummaryInformation test( IdentifierName identifierName ) {
        
        final boolean isCorrect;
        
        final List<TaggedToken> tokens = identifierName.taggedTokens();
        
        BodyCapitalisationInformation information;
        List<Boolean> isTokenCorrectList = new ArrayList<>();
        for ( int i = 0; i < tokens.size(); i++ ) {
            if ( i == 0 ) {
                information = checkCapitalisationFirstToken( tokens.get( i ) );
            }
            else { 
                information = checkCapitalisation( tokens.get( i ) );
            }
            isTokenCorrectList.add( information.isCorrect() );
            
        }
        
        isCorrect = ! isTokenCorrectList.contains( false );
        
        BodyCapitalisationSummaryInformation summaryInformation = 
                new BodyCapitalisationSummaryInformation( isCorrect );

        
        summaryInformation.addExplanation( this.explanation );  // surely this can go or needs to be revised
        identifierName.add( summaryInformation );
        return summaryInformation;
    }
    
    private BodyCapitalisationInformation checkCapitalisation( final Token token ) {
        boolean isCorrect;
        if ( this.caseType == CaseType.UPPER ) {
            isCorrect = token.text().matches( "^[A-Z0-9]+$" );
        }
        else if (this.caseType == CaseType.MIXED ) {
            isCorrect = token.text().matches( "^[A-Z0-9][a-z0-9]*$");
        }
        else {
            isCorrect = token.text().matches( "^[a-z0-9]+$");
        }
        
        BodyCapitalisationInformation information = 
                new BodyCapitalisationInformation( isCorrect );
        
        token.add( information );
        return information;
    }
    
    // candidate for refactoring
    // similar to above, but regex ignores first character
    // in other words this method determines correctness of 
    // capitalisation of the first token, but not its first letter.
    private BodyCapitalisationInformation checkCapitalisationFirstToken( final Token token ) {
        boolean isCorrect;
        if ( token.text().length() == 1 ) {
            isCorrect = true; // but only because the body of the token does not exist
        }
        else if ( this.caseType == CaseType.UPPER ) {
            isCorrect = token.text().matches( "^.[A-Z0-9]+$" );
        }
        else if (this.caseType == CaseType.MIXED ) {
            isCorrect = token.text().matches( "^.[a-z0-9]+$");
        }
        else {
            isCorrect = token.text().matches( "^.[a-z0-9]+$");
        }
        
        BodyCapitalisationInformation information = 
                new BodyCapitalisationInformation( isCorrect );
        
        token.add( information );
        return information;
    }
    
    
    
    /**
     * Provides a textual description of the rule applied.
     * @return A textual description of the rule applied.
     */
    @Override
    public String toString() {
        return this.caseType.description(); 
    }
    
    
    private void setExplanation( boolean isCorrect ) {
        switch ( this.caseType ) {
            case MIXED: 
                if ( isCorrect ) {
                    this.explanation = EXPLANATION_MIXED_SUCCESS;
                }
                else {
                    this.explanation = EXPLANATION_MIXED_FAILURE;
                }
                break;
                
            case UPPER: 
                this.explanation = isCorrect ? EXPLANATION_UPPER_SUCCESS : EXPLANATION_UPPER_FAILURE;
                break;
                
            case LOWER: 
                this.explanation = isCorrect ? EXPLANATION_LOWER_SUCCESS : EXPLANATION_LOWER_FAILURE;
                break;
        }
    }
    
}
