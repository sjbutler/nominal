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
 * Information concerning the capitalisation of the first character of the 
 * first alphanumeric token of a name. NB where a 
 * name begins with an underscore, for example, the first alphanumeric 
 * character may be a digit.
 */
public class FirstCharacterCapitalisationInformation extends IdentifierInformation {

    private final boolean isUpperCase;
    private final boolean isCorrect;
    private final boolean isDigit;
    
    /**
     * Encapsulates information about the capitalisation of the first 
     * alphanumeric (or non-separator) character found in a name.
     * @param isCorrect indicates if the typography of the first character 
     * matches the user specified rule
     * @param isUpperCase indicates if the first character is upper case
     * @param isDigit indicates if the first character is a digit
     * @param explanation a string explaining the output
     */
    public FirstCharacterCapitalisationInformation( 
            boolean isCorrect, 
            boolean isUpperCase, 
            boolean isDigit,
            String explanation ) {
        super( InformationClassification.CAPITALISATION_LEADING );
        this.isUpperCase = isUpperCase;
        this.isCorrect = isCorrect;
        this.isDigit = isDigit;
        addExplanation( explanation );
    }
    
    /**
     * Indicates if the first character is upper case.
     * @return {@code true} if first character is upper case
     */
    public boolean isUpperCase() {
        return this.isUpperCase;
    }
    
    /**
     * Indicates if first character has correct typography.
     * @return {@code true} iff the first non-separator character has the 
     * correct typography
     */
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
    /**
     * Indicates if first non-separator character is a digit.
     * @return {@code true} if first character is a digit.
     */
    public boolean isDigit() {
        return this.isDigit;
    }
    
}
