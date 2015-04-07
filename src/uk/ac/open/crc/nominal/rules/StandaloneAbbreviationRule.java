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

import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.information.StandaloneAbbreviationInformation;
import uk.ac.open.crc.mdsc.DictionarySet;

/**
 *
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class StandaloneAbbreviationRule extends IdentifierRule {
    private final DictionarySet abbreviationDictionaries;
    private final DictionarySet wordDictionaries;
    private final DictionarySet acronymDictionaries;
    private final DictionarySet iso3166Dictionaries;
    
    private final boolean isPermitted;

    public StandaloneAbbreviationRule() {
        this( false );
    }
    
    public StandaloneAbbreviationRule( final boolean isPermitted ) {
        super( RuleType.STANDALONE_ABBREVIATION );
        this.isPermitted = isPermitted;
        this.abbreviationDictionaries = MdscDictionaryPool.getInstance().abbreviationDictionaries();
        this.wordDictionaries = MdscDictionaryPool.getInstance().wordDictionaries();
        this.acronymDictionaries = MdscDictionaryPool.getInstance().acronymDictionaries();
        this.iso3166Dictionaries = MdscDictionaryPool.getInstance().iso3166Dictionaries();
    }
    
    @Override
    public StandaloneAbbreviationInformation test( IdentifierName identifierName ) {
        StandaloneAbbreviationInformation information;
        
        if ( identifierName.tokenCount() == 1 ) {
            boolean isCorrect;
            boolean isPresent;
            String name = identifierName.componentWords().get( 0 );
            
            isPresent = ( isAbbreviation( name ) || isIso3166Code( name ) ) 
                    || ! isRecognisedWord( name );
            
            if ( this.isPermitted ) {
                isCorrect = isPresent;
            }
            else {
                isCorrect = ! isPresent;
            }
            
            information = new StandaloneAbbreviationInformation( 
                    isCorrect, isPresent, this.isPermitted );
        }
        else {
            information = new StandaloneAbbreviationInformation( 
                    false, false, this.isPermitted );
        }
        
        identifierName.add( information );
        
        return information;
    }
    
    private boolean isRecognisedWord( String s ) {
        return  isAcronym( s ) || isWord( s );
    }
    
    
    private boolean isWord( String s ) {
            return this.wordDictionaries.spellCheck( s )
                    .stream().anyMatch( result -> result.isCorrect() );
        
    }
    
    private boolean isAcronym( String s ) {
            return this.acronymDictionaries.spellCheck( s )
                    .stream().anyMatch( result -> result.isCorrect() );
    }
    
    private boolean isAbbreviation( String s ) {
            return this.abbreviationDictionaries.spellCheck( s )
                    .stream().anyMatch( result -> result.isCorrect() );
    }
    
    
    private boolean isIso3166Code( String s ) {
        return this.iso3166Dictionaries.spellCheck( s )
                .stream().anyMatch( result -> result.isCorrect() );
    }
}
