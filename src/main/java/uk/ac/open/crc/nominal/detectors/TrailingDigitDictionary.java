/*
    Copyright (C) 2013-2015 The Open University
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * A simple dictionary of trailing digit abbreviations.
 *
 */
public class TrailingDigitDictionary {

    private static final Logger LOGGER = 
            LoggerFactory.getLogger( TrailingDigitDictionary.class );
    
    private static TrailingDigitDictionary instance = null;
    
    /**
     * Retrieves the instance of this class.
     * @return the instance of this class
     */
    static TrailingDigitDictionary getInstance() {
        if ( instance == null ) {
            instance = new TrailingDigitDictionary();
        }
        
        return instance;
    }
    
    // ------------------------
    
    private final HashSet<String> abbreviations;
    
    private TrailingDigitDictionary() {
        this.abbreviations = new HashSet<>();
        try ( BufferedReader in = new BufferedReader( new InputStreamReader( this.getClass().getResourceAsStream( "/wordlists/trailing-digit-abbreviations" ) ) ) ) {
            String line;
            while ( ( line = in.readLine() ) != null ) {
                this.abbreviations.add( line.trim() );
            }
            
        }
        catch ( IOException e ) {
            LOGGER.error(
                    String.format(
                            "problem encountered reading trailing digit abbreviations "
                            + "from jar : %s", 
                            e.getMessage()),
                    e);
        }
    }
    
    /**
     * Indicates if the given string is found in the dictionary.
     * @param string a token to test
     * @return true iff the string is recognised
     */
    boolean isAbbreviation( String string ) {
	
        return this.abbreviations.contains( string );
    }
    
}

