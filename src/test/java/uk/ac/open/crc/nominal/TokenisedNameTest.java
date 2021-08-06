/*
    Copyright (C) 2017 Simon Butler

    SPDX-FileCopyrightText: 2017 Simon Butler
    SPDX-License-Identifier: Apache-2.0

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
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests for the TokenisedName class.
 * 
 */
public class TokenisedNameTest {

    @Test
    public void instantiationTest() {
	String name = "aaBbCcDd";
	
	List<TaggedToken> tokens = new ArrayList<>();
	tokens.add(new TaggedToken("aa","NN"));
	tokens.add(new TaggedToken("Bb","NN"));
	tokens.add(new TaggedToken("Cc","NN"));
	tokens.add(new TaggedToken("Dd","NN"));
	List<String> normalisedTokens = new ArrayList<>( );
	normalisedTokens.add( "aa");
	normalisedTokens.add( "bb");
	normalisedTokens.add( "cc");
	normalisedTokens.add( "dd");
	List<String> tags = new ArrayList<>();
	tags.add( "NN");
	tags.add( "NN");
	tags.add( "NN");
	tags.add( "NN");
		
	String summary = "NP";
	
	TokenisedName tn = new TokenisedName(name, tokens, summary);
	assertTrue("Unexpected token count returned by TokenisedName", tokens.size() == tn.tokenCount());
	assertTrue("Unexpected phrase summary returned by TokenisedName", summary.equals( tn.phraseSummary()));
	assertTrue("Unexpected name returned by TokenisedName", name.equals( tn.nameString()));
	assertTrue("Tokens returned do not match tokens supplied to constructor", normalisedTokens.equals(tn.normalisedTokensAsText()));
	assertTrue("POS tags returned do not match tokens supplied to constructor", tags.equals(tn.posTags()));
    }
 
    
}
