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
 * Reports whether a token is a standalone abbreviation and 
 * its use conforms with the specified rules.
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class StandaloneAbbreviationInformation extends IdentifierInformation {
    private final boolean isCorrect;
    private final boolean isPresent;
    private final boolean isPermitted;
    
    public StandaloneAbbreviationInformation( 
            boolean isCorrect, 
            boolean isPresent,
            boolean isPermitted ) {
        super( InformationClassification.STANDALONE_ABBREVIATION );
        this.isCorrect = isCorrect;
        this.isPresent = isPresent;
        this.isPermitted = isPermitted;
    }
    
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
    public boolean isPresent() {
        return this.isPresent;
    }
    
    public boolean isPermitted() {
        return this.isPermitted;
    }
    
}
