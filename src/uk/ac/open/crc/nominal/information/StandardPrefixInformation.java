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
 * Records the use or not of redundant prefixes.
 */
public class StandardPrefixInformation extends IdentifierInformation {

    private final boolean isCorrect;
    private final boolean hasPrefix;
    
    /**
     * Creates an information object.
     * @param isCorrect indicates whether a prefix is correctly used 
     * @param hasPrefix indicates whether a known prefix is present
     */
    public StandardPrefixInformation( final boolean isCorrect, final boolean hasPrefix ) {
        super( InformationClassification.STANDARD_PREFIX );
        this.isCorrect = isCorrect;
        this.hasPrefix = hasPrefix;
    }
    
    /**
     * Indicates whether a prefix is correctly used.
     * @return true if the prefix is correctly used
     */
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
    /**
     * Indicates whether a prefix is present.
     * @return true is a know prefix is present
     */
    public boolean hasPrefix() {
        return this.hasPrefix;
    }
    
}
