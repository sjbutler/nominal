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
 * Encapsulates a tokenised name; a name with its tokens, part of
 * speech tags for the tokens and a phrase summary. 
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

    /**
     * Creates a new tokenised name using the specified name, tokens and 
     * phrase summary. 
     * 
     * @param nameString the name as it is found in source code
     * @param taggedTokens the output of a name tokeniser with PoS tags
     * @param phraseSummary a phrase summary of the name
     */
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
    
    
    /**
     * Retrieves the number of tokens.
     * @return the number of tokens
     */
    public int tokenCount() {
        return this.unnormalisedTokens.size();
    }
    
    
    /**
     * Retrieves the list of part of speech tags
     * @return a {@code List} of PoS tags.
     */
    public List<String> posTags() {
        return this.posTags;
    }
    
    
    public String nameString() {
        return this.nameString;
    }
    
    /**
     * Retrieves the phrase summary.
     * @return a phrase summary
     */
    public String phraseSummary() {
        return this.phraseSummary;
    }
    
    /**
     * A list of the text of the tokens normalised to lower case.
     * @return a {@code List} of the tokens
     */
    public List<String> normalisedTokensAsText() {
        return this.normalisedTokensAsText;
    }
    
    /**
     * Recovers the list of tagged tokens.
     * @return a {@code List} of {@code TaggedTokens}
     */
    public List<TaggedToken> taggedTokens() {
        return this.taggedTokens;
    }
}
