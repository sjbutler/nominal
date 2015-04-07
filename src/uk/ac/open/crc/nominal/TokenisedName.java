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
package uk.ac.open.crc.nominal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class TokenisedName {
    private final String nameString;
    private final List<Token> unnormalisedTokens;
    private final List<Token> normalisedTokens;
    private final List<String> posTags;
    
    private final List<TaggedToken> taggedTokens;
    private final String phraseSummary;
    
    private final List<String> normalisedTokensAsText;

//    // experimental alternative constructor.
//    // if posTags is set to null ...
//    public TokenisedName( 
//            String nameString, 
//            List<Token> unnormalisedTokens, 
//            List<String> posTags,
//            String phraseSummary ) {
//        this.nameString = nameString;
//        this.unnormalisedTokens = unnormalisedTokens;
//        this.posTags = posTags;
//        this.phraseSummary = phraseSummary;
//        
//        this.taggedTokens = new ArrayList<>();
//        for ( int i = 0; i < this.unnormalisedTokens.size(); i++ ) {
//            TaggedToken tt = new TaggedToken( 
//                    this.unnormalisedTokens.get( i ).text(), 
//                    this.posTags.get( i ) );
//            this.taggedTokens.add( tt );
//        }
//        
//        this.normalisedTokensAsText = new ArrayList<>();
//        this.taggedTokens.stream()
//                .forEach( tt -> { 
//                    this.normalisedTokensAsText.add( tt.text() );
//                });
//        
//    }
    

    public TokenisedName( 
            String nameString, 
            List<TaggedToken> taggedTokens,
            String phraseSummary ) {
        this.nameString = nameString;
        this.taggedTokens = taggedTokens;
        
        this.normalisedTokensAsText = new ArrayList<>();
        this.normalisedTokens = new ArrayList<>();
        this.unnormalisedTokens = new ArrayList<>();
        this.posTags = new ArrayList<>();
        this.taggedTokens.stream()
                .forEach( tt -> {
                    String text = tt.text();
                    this.normalisedTokens.add( new Token(text.toLowerCase() ) );
                    this.unnormalisedTokens.add( new Token( text ) ); 
                    this.posTags.add( text );
                    this.normalisedTokensAsText.add( text.toLowerCase() );
                });
        this.phraseSummary = phraseSummary;
    }
    
    
    public int tokenCount() {
        return this.unnormalisedTokens.size();
    }
    
    public List<String> posTags() {
        return this.posTags;
    }
    
    public String nameString() {
        return this.nameString;
    }
    
    public String phraseSummary() {
        return this.phraseSummary;
    }
    
    public List<String> normalisedTokensAsText() {
        return this.normalisedTokensAsText;
    }
    
    
    public List<TaggedToken> taggedTokens() {
        return this.taggedTokens;
    }
}
