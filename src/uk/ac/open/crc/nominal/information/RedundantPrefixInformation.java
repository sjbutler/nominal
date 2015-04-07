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
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class RedundantPrefixInformation extends IdentifierInformation {
    
    private final boolean isCorrect;
    private final boolean isRedundantPrefix;
    private final boolean isTypePrefix;
    private final boolean isSpeciesPrefix;
    private final boolean isCaseSensitivePrefix;
    
    public RedundantPrefixInformation( 
            final boolean isCorrect, 
            final boolean isTypePrefix, 
            final boolean isSpeciesPrefix,
            final boolean isCaseSensitivePrefix ) {
        super( InformationClassification.REDUNDANT_PREFIX );
        this.isCorrect = isCorrect;
        this.isTypePrefix = isTypePrefix;
        this.isSpeciesPrefix = isSpeciesPrefix;
        this.isRedundantPrefix = this.isSpeciesPrefix || this.isTypePrefix;
        this.isCaseSensitivePrefix = isCaseSensitivePrefix;
    }
    
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
    public boolean isRedundantPrefix() {
        return this.isRedundantPrefix;
    }
    
    public boolean isTypePrefix() {
        return this.isTypePrefix;
    }
    
    public boolean isSpeciesPrefix() {
        return this.isSpeciesPrefix;
    }
    
    public boolean isCaseSensitivePrefix() {
        return this.isCaseSensitivePrefix;
    }
}
