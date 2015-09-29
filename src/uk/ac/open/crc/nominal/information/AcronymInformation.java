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
 * Identifies a token as an acronym. 
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class AcronymInformation extends TokenInformation {
    private final List<Result> resultList;
    private boolean isCorrect;
    private boolean isKnownAcronym; // is this not implied??
    private boolean isCorrectTypography; // typography tested elsewhere
    
    public AcronymInformation( final List<Result> resultList ) {
        super( InformationClassification.ACRONYM );
        this.resultList = resultList;
        this.isCorrectTypography = false; // see AcronymTypographyInformation
        for ( Result result : this.resultList ) {
            if ( result.isCorrect() ) {
                this.isCorrect = true;
                this.isKnownAcronym = true;
            }
        }
    }
    
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
    public boolean isKnownAcronym() {
        return this.isKnownAcronym;
    }
    
    /**
     * Always returns false as acronym typography is checked elsewhere.
     * @return {@code false}
     */
    public boolean isCorrectTypography() {
        return this.isCorrectTypography;
    }
    
}
