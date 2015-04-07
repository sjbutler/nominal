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
 *
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 * @version $Id: TrailingUnderscoreInformation.java 56 2015-04-02 18:43:02Z simon $
 */
public class TrailingUnderscoreInformation extends IdentifierInformation {
    private final boolean hasTrailingUnderscore;
    
    public TrailingUnderscoreInformation( final boolean hasTrailingUnderscore ) {
        super( InformationClassification.UNDERSCORE_TRAILING );
        this.hasTrailingUnderscore = hasTrailingUnderscore;
    }
    
    
    public boolean hasTrailingUnderscore() {
        return this.hasTrailingUnderscore;
    }
    
    
    @Override
    public boolean isCorrect() {
        return !this.hasTrailingUnderscore;
    }
}
