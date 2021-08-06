/*
    Copyright (C) 2013-2015 The Open University

    SPDX-FileCopyrightText: 2013-2015 The Open University
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

import java.util.List;
import uk.ac.open.crc.mdsc.Result;

/**
 * Identifies a token as an acronym. 
 */
public class AcronymInformation extends TokenInformation {
    private final List<Result> resultList;
    private final boolean isCorrect;
    private final boolean isKnownAcronym; // is this not implied??
    private final boolean isCorrectTypography; // typography tested elsewhere
    
    public AcronymInformation( final List<Result> resultList ) {
        super( InformationClassification.ACRONYM );
        this.resultList = resultList;
        this.isCorrectTypography = false; // see AcronymTypographyInformation
        this.isKnownAcronym =
                this.resultList.stream().anyMatch( result -> result.isCorrect() );
        this.isCorrect = this.isKnownAcronym;
    }
    
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
    /**
     * Indicates whether the token is a known acronym.
     * @return true if the token is a known acronym
     */
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
