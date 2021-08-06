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


// to be revised when language allows specification of redundant prefixes
/**
 * Records whether a redundant prefix is present and if so, whether it 
 * has been used 'correctly'.
 */
public class RedundantPrefixInformation extends IdentifierInformation {
    
    private final boolean isCorrect;
    private final boolean isRedundantPrefix;
    private final boolean isTypePrefix;
    private final boolean isSpeciesPrefix;
    private final boolean isCaseSensitivePrefix;
    
    /**
     * Creates an information object.
     * @param isCorrect whether the token conforms to the user specified rule 
     * for redundant prefix use
     * @param isTypePrefix indicates whether the token is a type prefix
     * @param isSpeciesPrefix indicates whether the token is a species prefix
     * @param isCaseSensitivePrefix the result of a case sensitive
     */
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
    
    /**
     * Indicates whether a redundant prefix has been used according to the 
     * rule specified by the user.
     * @return true if the redundant prefix is correctly used
     */
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
    /**
     * Indicates whether the token is a recognised redundant prefix.
     * @return true if the token is a known redundant prefix
     */
    public boolean isRedundantPrefix() {
        return this.isRedundantPrefix;
    }
    
    /**
     * Indicates whether the token is a type prefix.
     * @return true if the token is a type prefix
     */
    public boolean isTypePrefix() {
        return this.isTypePrefix;
    }
    
    /**
     * Indicates whether the token is a species prefix.
     * @return true if the token is a species prefix
     */
    public boolean isSpeciesPrefix() {
        return this.isSpeciesPrefix;
    }
    
    /**
     * Indicates whether the token is a redundant prefix and has the 
     * expected case.
     * @return true if the token is a prefix and has the expected case
     */
    public boolean isCaseSensitivePrefix() {
        return this.isCaseSensitivePrefix;
    }
}
