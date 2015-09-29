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
 * permitted. This can change when the nominal language is revised to define 
 * the use of leading underscores and test the rule fully.
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class LeadingUnderscoreInformation extends IdentifierInformation {

    private final boolean hasLeadingUnderscore;
    private final boolean isResultingNameLegal;
    
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
    
    
    @Override
    public boolean isCorrect( ) {
        return !this.hasLeadingUnderscore;
    }
}
