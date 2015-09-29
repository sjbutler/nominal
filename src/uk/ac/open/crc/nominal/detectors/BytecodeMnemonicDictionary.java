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

package uk.ac.open.crc.nominal.detectors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides a look up for full Java bytecode mnemonics. These include 
 * underscores for some where they are conventionally used.
 * <p>
 * Two separate tests are available. One is for mnemonics as they are
 * conventionally written, including those that contain underscores, such 
 * as {@code aload_1}. The second contains mnemonics where the underscore 
 * has been removed, so, for example, {@code aload_1} becomes {@code aload1}.
 * </p>
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class BytecodeMnemonicDictionary {

    private static final Logger LOGGER = LoggerFactory.getLogger( BytecodeMnemonicDictionary.class );
    
    private static BytecodeMnemonicDictionary instance = null;
    
    public static BytecodeMnemonicDictionary getInstance() {
        if ( instance == null ) {
            instance = new BytecodeMnemonicDictionary();
        }
        
        return instance;
    }
    
    // ------------------------------------
    
    private final HashSet<String> dictionary;
    private final HashSet<String> contractedDictionary;
    
    
    private BytecodeMnemonicDictionary() {
        this.dictionary = new HashSet<>();
        this.contractedDictionary = new HashSet<>();
        
        try ( BufferedReader in = new BufferedReader( new InputStreamReader( 
                this.getClass().getResourceAsStream( "mnemonics-tokens-java8" ) ) ) ) {
            String line;
            while ( ( line = in.readLine() ) != null ) {
                String trimmedToken = line.trim(); 
                this.dictionary.add( trimmedToken );
                this.contractedDictionary.add( trimmedToken.replace( "_", "" ) );
            }
        }
        catch ( IOException e ) {
            LOGGER.error( 
                    "problem encountered reading bytecode mnemonics from jar : {}", 
                    e.getMessage());
        }
    }
    
    /**
     * Indicates whether the test string is a bytecode mnemonic. This tests 
     * against a dictionary where mnemonics contain underscores. Test is case
     * sensitive.
     * 
     * @param string a string to test
     * @return {@code true} if the test string matches a bytecode mnemonic.
     */
    public boolean isMnemonic( String string ) {
        return this.dictionary.contains( string );
    }
    
    
    /**
     * Indicates whether the test string matches a contracted mnemonic, i{.}e{.}
     * one with any underscore removed. For example {@code dstore_3 --> dstore3}.
     * Test is case sensitive.
     * @param string a string to test
     * @return {@code true} if the test string matches a contracted bytecode mnemonic.
     */
    public boolean isContractedMnemonic( String string ) {
        return this.contractedDictionary.contains( string );
    }
    

    // see if this is any use
    /**
     * Case and format insensitive test for a bytecode mnemonic.
     * @param string a string to test
     * @return {@code true} if the test string matches a bytecode mnemonic, 
     * whether contracted or not, regardless of case. 
     */
    public boolean isMnemonicIgnoreCase( String string ) {
        String normalisedString = string.toLowerCase();
        return ( isMnemonic( normalisedString ) 
                || isContractedMnemonic( normalisedString) );
    }
    
}
