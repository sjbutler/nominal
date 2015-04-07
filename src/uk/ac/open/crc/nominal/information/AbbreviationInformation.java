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
import uk.ac.open.crc.mdsc.Result;

/**
 * Represents the information known about whether a token is an 
 * abbreviation.
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class AbbreviationInformation extends TokenInformation {

    private final List<Result> resultList;
    
    private boolean isKnownAbbreviation;
    
    private final boolean shouldBeExpanded;
    
    private final boolean isExpandable;
    
    private final boolean isBranding;
  
    public AbbreviationInformation( List<Result> resultList ) {
        super( InformationClassification.ABBREVIATION );
        this.resultList = resultList;
        this.isKnownAbbreviation = false;
        for ( Result result : resultList ) {
            if ( result.isCorrect() ) {
                this.isKnownAbbreviation = true;
            }
        }
        this.shouldBeExpanded = false;
        this.isExpandable = false;
        this.isBranding = false;
    }
    
    
    
    public boolean isKnownAbbreviation() {
        return this.isKnownAbbreviation;
    }

    
    @Override
    public boolean isCorrect() {
        return this.isKnownAbbreviation;  /// REVIEW AND REVISE -- correctness is not that simple
    }
}
