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
 * Carries information about the use of one or more trailing digits in 
 * an identifier name. This object should only be used to annotate the 
 * last or final token of an identifier name.
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class TrailingDigitInformation extends TokenInformation {
    private final boolean isTrailingDigit;
    private boolean isKnownAbbreviation;
    private boolean isAcceptableUsage;
    private boolean isKnownPattern;
    
    public TrailingDigitInformation( boolean isTrailingDigit ) {
        super( InformationClassification.TRAILING_DIGIT );
        this.isTrailingDigit = isTrailingDigit;
        this.isKnownAbbreviation = false;
        this.isAcceptableUsage = false;
        this.isKnownPattern = false;
    }
    
    public boolean isAcceptable() {
        return this.isAcceptableUsage;
    }
    
    public void setIsAcceptable( boolean isAcceptableUsage ) {
        this.isAcceptableUsage = isAcceptableUsage;
    }
    
    public boolean isTrailingDigit() {
        return this.isTrailingDigit;
    }
    
    public boolean isKnownAbbreviation() {
        return this.isKnownAbbreviation;
    }
    
    public void setKnownAbbreviation( boolean isKnown ) {
        this.isKnownAbbreviation = isKnown;
    }
    
    public boolean isKnownPattern() {
        return this.isKnownPattern;
    }
    
    public void setKnownPattern( boolean isKnownPattern ) {
        this.isKnownPattern = isKnownPattern;
    }
    
    
    // UGLY -- may need to rethink this. Perhaps a clearer definition of correctness is required
    @Override
    public boolean isCorrect() {
        return this.isAcceptableUsage;
    }
}
