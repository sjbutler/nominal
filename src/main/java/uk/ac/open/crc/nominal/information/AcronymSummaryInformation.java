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

/**
 * Summary of position of acronyms in names.
 */
public class AcronymSummaryInformation extends IdentifierInformation {

    private final List<Boolean> isAcronymList;
    private final List<Integer> acronymIndices;
    
    /**
     * Creates a summary of the token information objects in a name.
     * @param informationList a list of token acronym information 
     */
    public AcronymSummaryInformation( final List<AcronymInformation> informationList ) {
        super( InformationClassification.ACRONYM_SUMMARY );
        
        this.isAcronymList = new ArrayList<>();
        this.acronymIndices = new ArrayList<>();
        
        for ( int i = 0; i < informationList.size(); i++ ) {
            AcronymInformation information = informationList.get( i );
            this.isAcronymList.add( information.isCorrect() );
            if ( information.isCorrect() ) {
                this.acronymIndices.add( i );
            }
        }
    }
    
    @Override
    public boolean isCorrect() {
        // there is no such thing as correctness
        throw new UnsupportedOperationException( "No notion of correctness for acronym summary" );
    }
    
    /**
     * Recovers indices of acronym tokens.
     * @return a list of indices of tokens in name that are acronyms. May be empty.
     */
    public List<Integer> acronymIndices() {
        return this.acronymIndices;
    }
}
