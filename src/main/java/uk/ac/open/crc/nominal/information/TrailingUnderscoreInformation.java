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

// to be revised when user define rules on trailing underscores are introduced
/**
 * Used to annotate a name and records the presence of trailing underscores
 * and their correctness.
 */
public class TrailingUnderscoreInformation extends IdentifierInformation {
    private final boolean hasTrailingUnderscore;
    
    /**
     * Creates an information object.
     * @param hasTrailingUnderscore true if one or more trailing underscores 
     * are present
     */
    public TrailingUnderscoreInformation( final boolean hasTrailingUnderscore ) {
        super( InformationClassification.UNDERSCORE_TRAILING );
        this.hasTrailingUnderscore = hasTrailingUnderscore;
    }
    
    /**
     * Indicates whether one or more trailing underscores have been found.
     * @return true if the name has a trailing underscore
     */
    public boolean hasTrailingUnderscore() {
        return this.hasTrailingUnderscore;
    }
    
    /**
     * Indicates whether the use of trailing underscores is correct.
     * @return false as the use of trailing underscores currently considered 
     * incorrect
     */
    @Override
    public boolean isCorrect() {
        return !this.hasTrailingUnderscore;
    }
}
