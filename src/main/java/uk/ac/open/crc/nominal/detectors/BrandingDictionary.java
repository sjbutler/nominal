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

package uk.ac.open.crc.nominal.detectors;

import java.util.HashSet;

/**
 * A reference for checking branding.
 */
public class BrandingDictionary {

    private static BrandingDictionary instance = null;
    
    public static final BrandingDictionary getInstance() {
        if ( instance == null ) {
            instance = new BrandingDictionary();
        }
        
        return instance;
    }
    
    // --------------
    private final HashSet<String> brands;
    private final HashSet<String> normalisedBrands;
    
    /**
     * Creates an empty dictionary.
     */
    private BrandingDictionary() {
        this.brands = new HashSet<>();
        this.normalisedBrands = new HashSet<>();
    }
    
    /**
     * Add a term to the dictionary.
     * @param brand a term to add to the dictionary
     */
    public void add( String brand ) {
        this.brands.add( brand );
        this.normalisedBrands.add( brand.toLowerCase() );
    }
    
    /**
     * Case sensitive test of a string.
     * @param token a string to be tested
     * @return {@code true} iff the branding is recognised
     */
    public boolean isBrand( String token ) {
        // log if the dictionary is empty?
        return this.brands.contains( token );
    }
    
    /**
     * Case insensitive test of a string.
     * @param token a string to be tested
     * @return {@code true} iff the branding is recognised
     */
    public boolean isBrandIgnoreCase( String token ) {
        // log if the dictionary is empty?
        return this.normalisedBrands.contains( token.toLowerCase() );
    }
    
    /**
     * Indicates whether the dictionary is unpopulated.
     * <p>
     * See if this is any use. Delete if not.
     * </p>
     * @return {@code true} if the dictionary is empty. 
     */
    public boolean isEmpty() {
        return this.brands.isEmpty();
    }
}
