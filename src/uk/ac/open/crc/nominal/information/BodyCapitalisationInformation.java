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
 * Records the correctness of the typography of a token according 
 * to the rule specified for the body of the name the token is 
 * part of. 
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class BodyCapitalisationInformation extends TokenInformation {

    private final boolean isCorrect;
    
    public BodyCapitalisationInformation( boolean isCorrect ) {
        super( InformationClassification.CAPITALISATION_INTERNAL ); 
        this.isCorrect = isCorrect;
    }
    
    /**
     * Indicates if the token body has the correct typography.
     * @return {@code true} if the token, excluding the first character, has 
     * the correct typography.
     */
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
}
