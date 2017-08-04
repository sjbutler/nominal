/*
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

package uk.ac.open.crc.nominal;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests for the TaggedToken class and its super class. 
 * 
 */
public class TaggedTokenTest {

    @Test
    public void simpleInstantiationTest() {
	TaggedToken tt = new TaggedToken("noun", "NN");
	
	assertTrue(
		"failed to instantiate TaggedToken correctly for arguments: 'noun' and 'NN'",
		"noun".equals( tt.text() )
		&& "noun".equals( tt.normalisedText())
		&& "NN".equals( tt.tag() )
		);
    }
    
    @Test
    public void normalisationTest() {
	TaggedToken tt = new TaggedToken("NOuN", "NN");
	
	assertTrue(
		"failed to instantiate TaggedToken correctly for arguments: 'NOuN' and 'NN'",
		"NOuN".equals( tt.text() )
		&& "noun".equals( tt.normalisedText())
		&& "NN".equals( tt.tag() )
		);
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void nullTokenTest() {
	TaggedToken tt = new TaggedToken(null, "NN");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nullTagTest() {
	TaggedToken tt = new TaggedToken("noun", null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void emptyTokenTest() {
	TaggedToken tt = new TaggedToken("", "NN");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void emptyTagTest() {
	TaggedToken tt = new TaggedToken("noun", "    ");
    }
}
