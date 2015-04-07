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

import java.util.List;

/**
 *
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class PhraseInformation extends IdentifierInformation {

    private final boolean isCorrect;
    private final String phraseSummary;
    private final List<String> posTags;
    private final boolean isPlural;
    
    public PhraseInformation( 
            boolean isCorrect, 
            String phraseSummary, 
            List<String> posTags) {
        super( InformationClassification.PHRASE );
        this.isCorrect = isCorrect;
        this.phraseSummary = phraseSummary;
        this.posTags = posTags;
        if ( this.posTags != null ) {
            int lastIndex = this.posTags.size() - 1;
            if ( this.phraseSummary.toUpperCase().endsWith( "NP" ) ) {
                this.isPlural = this.posTags.get( lastIndex ).toUpperCase().endsWith( "NNS" );
            }
            else {
                this.isPlural = false;
            }
        }
        else {
            this.isPlural = false; // it's certainly not the plural form of a word, though it may have a plural meaning.
        }
    }
    
    
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
    public String phraseSummary() {
        return this.phraseSummary;
    }
    
    public boolean isPlural() {
        return isPlural;
    }
}
