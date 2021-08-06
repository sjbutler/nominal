/*
    Copyright (C) 2013-2015 The Open University
    Copyright (C) 2017 Simon Butler

    SPDX-FileCopyrightText: 2013-2015 The Open University
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

package uk.ac.open.crc.nominal.information;

import java.util.ArrayList;
import java.util.List;

/**
 * Summarises information about abbreviations in a name. Indicates where 
 * recognised abbreviations are found in the name 
 */
public class AbbreviationSummaryInformation extends IdentifierInformation {

    private final List<Boolean> isAbbreviationList;
    private final List<Integer> abbreviationIndices;

    /**
     * Creates a summary of the abbreviations found in a name's tokens.
     * @param informationList a list of token abbreviation objects
     */
    public AbbreviationSummaryInformation( 
            final List<AbbreviationInformation> informationList ) {
        super( InformationClassification.ABBREVIATION_SUMMARY );

        this.isAbbreviationList = new ArrayList<>();
        this.abbreviationIndices = new ArrayList<>();
        for ( int i = 0; i < this.isAbbreviationList.size(); i++ ) {
            AbbreviationInformation information = informationList.get( i );
            this.isAbbreviationList.add( information.isCorrect() );
            if ( information.isCorrect() ) {
                this.abbreviationIndices.add( i );
            }
        }
        informationList.stream()
                .forEach( information -> this.isAbbreviationList.add( information.isCorrect() ) );
        
    }

    @Override
    public boolean isCorrect() {
        // there is really no notion of correctness, other than the 
        // abbreviations being recognised
        throw new UnsupportedOperationException( 
                "No notion of correctness for AbbreviationSummaryInformation" );
    }

    /**
     * A list of indices of tokens containing a known abbreviation.
     * @return a list which is empty if there are no abbreviations in the name
     */
    public List<Integer> abbreviationIndices() {
        return this.abbreviationIndices;
    }
    
}
