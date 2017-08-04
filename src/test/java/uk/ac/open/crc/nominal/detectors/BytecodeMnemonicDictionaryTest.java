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

package uk.ac.open.crc.nominal.detectors;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests to ensure correctness of dictionary behaviour.
 * 
 */
public class BytecodeMnemonicDictionaryTest {

    
    
    @Test
    public void simpleLookupSuccessTest() {
        BytecodeMnemonicDictionary d = BytecodeMnemonicDictionary.getInstance();
        
        assertTrue("null instance returned by BytecodeMnemonicDictionary", d != null);
        
        assertTrue("'newarray' is not a known mnemonic", d.isMnemonic("newarray"));
    }
    
    @Test
    public void simpleLookupFailTest() {
	BytecodeMnemonicDictionary d = BytecodeMnemonicDictionary.getInstance();
	
	assertFalse(
		"'never heard of it' is a known mnemonic", 
		d.isMnemonic("never heard of it"));
    }
    
    @Test
    public void nullTest() {
	BytecodeMnemonicDictionary d = BytecodeMnemonicDictionary.getInstance();
	
	assertFalse("null is a known mnemonic", d.isMnemonic(null));
	assertFalse("null is a known contracted mnemonic", d.isContractedMnemonic(null));
	assertFalse("null is a known uncontracted mnemonic", d.isUncontractedMnemonic(null));
    }
    
    @Test
    public void emptyStringTest() {
	BytecodeMnemonicDictionary d = BytecodeMnemonicDictionary.getInstance();
	
	assertFalse("an empty string is a known mnemonic", d.isMnemonic(""));
    }
    
    @Test
    public void whitespaceStringTest() {
	BytecodeMnemonicDictionary d = BytecodeMnemonicDictionary.getInstance();
	
	assertFalse("whitespace only string is a known mnemonic", d.isMnemonic("      "));
    }
        
    
    @Test
    public void caseSensitivitySuccessTest() {
	BytecodeMnemonicDictionary d = BytecodeMnemonicDictionary.getInstance();
	
	assertTrue(
		"'NEWARRAY' is not a known mnemonic using case insensitive method", 
		d.isMnemonic("NEWARRAY"));
    }
    
    // contraction
    @Test
    public void uncontractedSuccessTest() {
	BytecodeMnemonicDictionary d = BytecodeMnemonicDictionary.getInstance();
	
	assertTrue(
		"'aload_1' not recognised as and uncontracted mnemonic", 
		d.isUncontractedMnemonic( "aload_1"));
    }
    
    @Test
    public void uncontractedFailTest() {
	BytecodeMnemonicDictionary d = BytecodeMnemonicDictionary.getInstance();

	assertFalse(
		"'aloa1_d' is recognised as and uncontracted mnemonic", 
		d.isUncontractedMnemonic( "aloa1_d"));
    }
    
    @Test
    public void contractedSuccessTest() {
	BytecodeMnemonicDictionary d = BytecodeMnemonicDictionary.getInstance();
	
	assertTrue(
		"'dload3' not recognised as a contracted mnemonic", 
		d.isContractedMnemonic( "dload3"));
    }
    
    @Test
    public void contractedFailTest() {
	BytecodeMnemonicDictionary d = BytecodeMnemonicDictionary.getInstance();
	
	assertFalse(
		"'fstore4' is recognised as a contracted mnemonic", 
		d.isContractedMnemonic( "fstore4"));
    }
}
