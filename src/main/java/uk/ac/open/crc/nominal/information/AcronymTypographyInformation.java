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
 * Information object annotating an acronym token to 
 * indicate the correctness of the typography.
 */
public class AcronymTypographyInformation extends TokenInformation {
    private final boolean isCorrect;
    
    /** 
     * Creates an information object.
     * @param isCorrect indicates correctness of acronym typography
     */
    public AcronymTypographyInformation( final boolean isCorrect ) {
        super( InformationClassification.ACRONYM_TYPOGRAPHY );
        this.isCorrect = isCorrect;
    }
    
    /**
     * Indicates if the typography of an acronym is correct.
     * 
     * @return {@code true} if the typography conforms to the 
     * given definition.
     */
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
}
