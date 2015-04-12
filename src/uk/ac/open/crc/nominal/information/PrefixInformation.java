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
 * Represents the information known about whether the token is a 
 * prefix. This class should only ever be attached to the first token
 * of an identifier name.
 * 
 * 
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class PrefixInformation extends TokenInformation {

    private final boolean isCorrect;
    private final boolean isPrefix;
    private final boolean isPrefixIgnoreCase;
    private boolean isBranding;
    private boolean isBrandingIgnoreCase;
    
    /**
     * Constructor.
     * @param isCorrect indicates if the prefix usage is correct
     * @param isPrefix indicates whether the token has been recognised by the dictionary as a prefix
     * @param isPrefixIgnoreCase indicates the result of a case insensitive test of the token
     */
    public PrefixInformation( boolean isCorrect, boolean isPrefix, boolean isPrefixIgnoreCase ) {
        super( InformationClassification.PREFIX );
        this.isCorrect = isCorrect;
        this.isPrefix = isPrefix;
        this.isPrefixIgnoreCase = isPrefixIgnoreCase;
        this.isBranding = false; // assume not and let the caller decide
    }

    
    /**
     * Indicates if any prefix that is present is correct. NB this does not 
     * indicate whether a prefix is present *and* incorrectly used.
     * @return {@code true} if the first token is a prefix and is used correctly
     */
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
    /**
     * Indicates if this token is a recognised prefix.
     * @return {@code true} if token is a prefix
     */
    public boolean isPrefix() {
        return this.isPrefix;
    }
    
    /**
     * Indicates if this token is a recognised prefix regardless of case.
     * @return {@code true} if token is a prefix (case insensitive)
     */
    public boolean isPrefixIgnoreCase() {
        return this.isPrefixIgnoreCase;
    }
    
    /**
     * Indicates if the prefix is used for branding.
     * @return {@code true} if branding
     */
    public boolean isBranding() {
        return this.isBranding;
    }
    
    /**
     * Used to show that the prefix is used as branding. Generally only 
     * applies to class and interface names.
     * @param isBranding {@code true} if branding prefix
     */
    public void setBranding( boolean isBranding ) {
        this.isBranding = isBranding;
    }
    
    /**
     * Indicates if the prefix is used for branding.
     * @return {@code true} if branding
     */
    public boolean isBrandingIgnoreCase() {
        return this.isBrandingIgnoreCase;
    }
    
    /**
     * Used to show that the prefix is used as branding, though the test 
     * is case insensitive. Generally only 
     * applies to class and interface names.
     * @param isBranding {@code true} if branding prefix
     */
    public void setBrandingIgnoreCase( boolean isBranding ) {
        this.isBrandingIgnoreCase = isBranding;
    }
    
}
