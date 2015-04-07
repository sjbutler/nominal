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

package uk.ac.open.crc.nominal.information;

import java.util.ArrayList;
import java.util.List;
import uk.ac.open.crc.mdsc.Result;

/**
 * Indicates whether a word is spelt correctly, and can provide a 
 * record of the dictionaries consulted.
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class SpellingInformation extends TokenInformation {
    private final boolean isCorrect;
    
    private final List<Result> results;
    
    public SpellingInformation( List<Result> results ) {
        super( InformationClassification.SPELLING );
        this.results = results;
        boolean isCorrectSpelling = false;
        for ( Result result : this.results ) {
            if ( result.isCorrect() ) {
                isCorrectSpelling = true;
                break;
            }
        }
        this.isCorrect = isCorrectSpelling;
    }
    
    /**
     *
     * @return
     */
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
    /**
     * A list of dictionaries which found the word correctly spelt.
     * @return a list of dictionary names. 
     */
    public List<String> successfulDictionaries() {
        ArrayList<String> dictionaries = new ArrayList<>();
        this.results.stream().forEach( (result)->{ if ( result.isCorrect() ) { dictionaries.add( result.dictionaryName() ); } });
        return dictionaries;
    }
    
    /**
     * A list of dictionaries in which the word was not found.
     * @return a list of dictionary names
     */
    public List<String> failedDictionaries() {
        ArrayList<String> dictionaries = new ArrayList<>();
        this.results.stream().forEach( (result)->{ if ( ! result.isCorrect() ) { dictionaries.add( result.dictionaryName() ); } });
        return dictionaries;
    }
    
}
