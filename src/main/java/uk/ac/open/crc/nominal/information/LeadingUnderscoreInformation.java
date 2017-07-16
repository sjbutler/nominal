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

/**
 * Contains information about the presence of one or more leading underscores. 
 * The current notion of correctness is that leading underscores are not
 * permitted. This implementation will change when the nominal language is 
 * revised to define the use of leading underscores and test the rule fully.
 */
public class LeadingUnderscoreInformation extends IdentifierInformation {

    private final boolean hasLeadingUnderscore;
    private final boolean isResultingNameLegal;
    
    // need to review and revise the isResultingNameLegal behaviour
    // so that it reflects an alphabetical character starting the name
    // when stripped of underscores. Need also to implement a 
    // 'is resulting name empty' functionality
    /**
     * Creates an information object reporting leading underscores in a name.
     * @param hasLeadingUnderscore indicates whether one or more leading 
     * underscores are present
     * @param isResultingNameLegal indicates whether the name is permitted by 
     * the Java grammar when any leading underscores are removed
     */
    public LeadingUnderscoreInformation( 
            boolean hasLeadingUnderscore, boolean isResultingNameLegal ) {
        super( InformationClassification.UNDERSCORE_LEADING );
        this.hasLeadingUnderscore = hasLeadingUnderscore;
        this.isResultingNameLegal = isResultingNameLegal;
    }

    /** 
     * Indicates if one or more leading underscores are present.
     * @return {@code true} when one or more leading underscores are present.
     */
    public boolean hasLeadingUnderscore() {
        return this.hasLeadingUnderscore;
    }
    
    // Review and revise concept behind name, and the name used
    /**
     * Indicates whether there are any alphanumeric components following the 
     * leading underscore(s). 
     * 
     * @return {@code true} if the name contains characters other than the
     * leading underscore(s)
     */
    public boolean isResultingNameLegal() {
        return this.isResultingNameLegal;
    }
    
    /**
     * The fixed notion of correctness is that a name should not have a 
     * leading underscore. This behaviour will be revised.
     * @return true if the names has one or more leading underscores
     */
    @Override
    public boolean isCorrect( ) {
        return !this.hasLeadingUnderscore;
    }
}
