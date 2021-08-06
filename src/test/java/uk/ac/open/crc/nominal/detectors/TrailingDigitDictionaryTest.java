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

package uk.ac.open.crc.nominal.detectors;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the trailing digit dictionary.
 * 
 */
public class TrailingDigitDictionaryTest {

    @Test
    public void instantiationTest() {
	TrailingDigitDictionary dictionary = TrailingDigitDictionary.getInstance();
	
	assertNotNull("null returned by Singleton", dictionary);
    }
    
    @Test
    public void isItTheRightDictionaryTest() {
	TrailingDigitDictionary dictionary = TrailingDigitDictionary.getInstance();
	
	boolean containsJdk8 = dictionary.isAbbreviation( "jdk8" );
	boolean containsHttp11 = dictionary.isAbbreviation( "http11" );
    }
    
    @Test
    public void nullArgumentTest() {
	TrailingDigitDictionary dictionary = TrailingDigitDictionary.getInstance();
	
	assertFalse("null found in dictionary", dictionary.isAbbreviation( null ));
    }
    
    
    
}
