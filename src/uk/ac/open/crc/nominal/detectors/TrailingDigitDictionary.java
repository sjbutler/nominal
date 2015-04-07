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
 *
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class TrailingDigitDictionary {

    private static final Logger LOGGER = LoggerFactory.getLogger( TrailingDigitDictionary.class );
    
    private static TrailingDigitDictionary instance = null;
    
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
        try ( BufferedReader in = new BufferedReader( new InputStreamReader( this.getClass().getResourceAsStream( "trailing-digit-abbreviations" ) ) ) ) {
            String line;
            while ( ( line = in.readLine() ) != null ) {
                this.abbreviations.add( line.trim() );
            }
            
        }
        catch ( IOException e ) {
            LOGGER.error(
                    "problem encountered reading trailing digit abbreviations "
                            + "from jar : {}", 
                    e.getMessage() );
        }
    }
    
    
    boolean isAbbreviation( String string ) {
        return this.abbreviations.contains( string );
    }
}

