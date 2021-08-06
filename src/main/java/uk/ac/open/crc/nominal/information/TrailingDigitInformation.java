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

/**
 * Carries information about the use of one or more trailing digits in 
 * an identifier name. This object should only be used to annotate the 
 * last or final token of an identifier name.
 */
public class TrailingDigitInformation extends TokenInformation {
    private final boolean isTrailingDigit;
    private boolean isKnownAbbreviation;
    private boolean isAcceptableUsage;
    private boolean isKnownPattern;
    
    /**
     * Constructs the information object.
     * @param isTrailingDigit indicates whether the token has a trailing digit
     */
    public TrailingDigitInformation( boolean isTrailingDigit ) {
        super( InformationClassification.TRAILING_DIGIT );
        this.isTrailingDigit = isTrailingDigit;
        this.isKnownAbbreviation = false;
        this.isAcceptableUsage = false;
        this.isKnownPattern = false;
    }
    
    /**
     * Indicates whether the use of a trailing digit is acceptable.
     * @return true if the trailing digit is used in an acceptable way
     */
    public boolean isAcceptable() {
        return this.isAcceptableUsage;
    }
    
    /**
     * Sets a field indicating whether the use of the trailing digit is acceptable.
     * @param isAcceptableUsage true if the trailing digit is used in an acceptable way
     */
    public void setIsAcceptable( boolean isAcceptableUsage ) {
        this.isAcceptableUsage = isAcceptableUsage;
    }
    
    /**
     * Indicates whether a trailing digit is present.
     * @return true if the final token has a trailing digit
     */
    public boolean isTrailingDigit() {
        return this.isTrailingDigit;
    }
    
    /**
     * Indicates whether the token is a known abbreviation.
     * @return true is the token is a recognised abbreviation
     */
    public boolean isKnownAbbreviation() {
        return this.isKnownAbbreviation;
    }
    
    /**
     * Sets whether the token is a recognised abbreviation.
     * @param isKnown whether the token is a recognised abbreviation.
     */
    public void setKnownAbbreviation( boolean isKnown ) {
        this.isKnownAbbreviation = isKnown;
    }
    
    /**
     * Indicates whether the token follows a known pattern such as an ISO or RFC
     * reference, or a hexadecimal number.
     * @return true if the token follows a recognised pattern
     */
    public boolean isKnownPattern() {
        return this.isKnownPattern;
    }
    
    /**
     * Sets whether the token follows a recognised patter.
     * @param isKnownPattern whether the token follows a recognised pattern
     */
    public void setKnownPattern( boolean isKnownPattern ) {
        this.isKnownPattern = isKnownPattern;
    }
    
    
    // UGLY -- may need to rethink this. Perhaps a clearer definition of 
    // correctness is required
    /**
     * Indicates whether the use of the trailing digit is considered correct.
     * @return true if the trailing digit is considered correct.
     */
    @Override
    public boolean isCorrect() {
        return this.isAcceptableUsage;
    }
}
