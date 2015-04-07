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
 *
 * REQUIRES A NOTION OF CORRECTNESS
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
    
    public boolean hasLeadingUnderscore() {
        return this.hasLeadingUnderscore;
    }
    
    public boolean isResultingNameLegal() {
        return this.isResultingNameLegal;
    }
    
    @Override
    public boolean isCorrect( ) {
        return !this.hasLeadingUnderscore;
    }
}
