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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import uk.ac.open.crc.mdsc.DictionarySet;
import uk.ac.open.crc.mdsc.Result;
import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.information.PhraseInformation;

/**
 * Represents a phrase rule. 
 */
public class PhraseRule extends IdentifierRule {
    
    
    private static final DictionarySet abbreviationDictionary = 
            MdscDictionaryPool.getInstance().abbreviationDictionaries();
    
    // -------------------------------
    
    private final HashSet<String> phrases;
    
    private final boolean isNoneSpecified;
    private final boolean isNoneOnly;  // maybe this interpretation should be left to the caller?
    
    /**
     * Creates an instance of {@code PhraseRule}.
     * @param phrases the phrases specified by the rule
     */
    public PhraseRule( Set<String> phrases ) {
        super( RuleType.PHRASE );
        this.phrases = new HashSet<>();
        this.phrases.addAll( phrases );
        this.isNoneSpecified = this.phrases.contains( "none" );
        this.isNoneOnly = this.isNoneSpecified && this.phrases.size() == 1;
    }
    
    // CAN NONE BE DECLARED ANY MORE?
    // needs to understand 'none' as a rule
    // need to understand how 'none' should be used -- suggest for single 
    // token identifier names that are single character or other abbreviations.
    // maybe 'none' can be declared for a non-rule, i.e. a permissive rule
    /**
     * Evaluates the name using the user specified phrase rule.
     * @param identifierName a name to evaluate
     * @return an information object
     */
    @Override
    public PhraseInformation test( IdentifierName identifierName ) {
        PhraseInformation returnedInformation = null;
        
        String phraseSummary = identifierName.phraseSummary();
        
        List<String> posTags = identifierName.posTags();
        
        for ( String phrase : this.phrases ) {
            PhraseInformation information;
            switch ( phrase ) {
                case "none":
                    information = noneTest( identifierName );
                    break;
                case "complex":
                    boolean isComplex = ( phraseSummary.split( " " ).length > 2 ); // crude test saying that 3 or more top level components are complex. Not sure the reductionist parser well ever allow this to be true.
                    information = new PhraseInformation( 
                            isComplex, 
                            phraseSummary, 
                            posTags );
                    break;
                default:
                    boolean isCorrect = phraseSummary.equals( phrase );
                    information = new PhraseInformation(
                            isCorrect,
                            phraseSummary,
                            posTags );
                    break;
            }
            
            identifierName.add( information );
            
            if ( information.isCorrect() || returnedInformation == null ) {
                returnedInformation = information;
            }
        }
        
        return returnedInformation;
    }
    

    // review this. Need to understand under what conditions 
    // a name can be declared not to be a phrase.
    private PhraseInformation noneTest( IdentifierName identifierName ) {
        boolean isCorrect;
        
        if ( identifierName.tokenCount() == 1)  {
            String token = identifierName.componentWords().get( 0 );
            boolean isKnownAbbreviation = false;
            for ( Result result : abbreviationDictionary.spellCheck( token ) ) {
                if ( result.isCorrect() ) {
                    isKnownAbbreviation = true;
                    break;
                }
            }
            
            isCorrect = isKnownAbbreviation;
        }
        else {
            isCorrect = false;
            // this needs to be reviewed to ensure that it deals with 
            // multi-token if possible (without overlapping with complex)
        }
        
        PhraseInformation information = 
                new PhraseInformation( isCorrect, "none", null );
        
        return information;
    }

    /**
     * 
     * {@inheritDoc}
     * @return  {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.phrases.stream().collect( Collectors.joining( ", " ) );
    }
    
    private String createExplanation() {
        StringBuilder explanation = new StringBuilder( "Expected " );
        if ( this.phrases.size() > 1 ) {
            explanation.append( "one of: " );
        }
        
        explanation.append( 
                this.phrases.stream().sorted().collect( Collectors.joining( ", " ) ) );
        
        return explanation.toString();
    }

}
