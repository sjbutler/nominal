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
 * Represents the results of a number of tests performed on the identifier name
 * for prefixes.
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class SeparatorInformation extends IdentifierInformation {

    private final boolean hasSeparators;
    private final boolean hasUnderscores;
    private final boolean hasDollarSigns;
    private boolean hasContiguousUnderscores;
    private final boolean isCorrect;
    private boolean areWordBoundariesMarked;
    
    public SeparatorInformation( 
            boolean isCorrect, 
            boolean hasUnderscores, 
            boolean hasDollarSigns ) {
        super( InformationClassification.SEPARATOR );
        this.isCorrect = isCorrect;
        this.hasSeparators = hasUnderscores || hasDollarSigns;
        this.hasDollarSigns = hasDollarSigns;
        this.hasUnderscores = hasUnderscores;
        this.hasContiguousUnderscores = false;
        this.areWordBoundariesMarked = false;
    }
    
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
    /**
     * Indicates whether separator characters have been used in an identifier
     * name.
     * @return {@code true} if there is at least one underscore or dollar sign 
     * found in the identifier name. 
     */
    public boolean hasSeparators() {
        return this.hasSeparators;
    }
    
    public boolean hasUndercores() {
        return this.hasUnderscores;
    }
    
    public boolean hasDollarSigns() {
        return this.hasDollarSigns;
    }
    
    public void hasContiguousUnderscores( boolean hasContiguousUnderscores ) {
        this.hasContiguousUnderscores = hasContiguousUnderscores;
    }
    
    public boolean hasContiguousSeparators() {
        return this.hasContiguousUnderscores;
    }
    
    public void areWordBoundariesMarked( boolean areWordBoundariesMarked ) {
        this.areWordBoundariesMarked = areWordBoundariesMarked;
    }
    
    /**
     * Indicates whether underscores mark all the word boundaries. The definition
     * of a word boundary is that determined by intt, which may find fewer or 
     * more word boundaries than the developer inserted.
     * @return {@code true} if intt and the developer agree on the number and 
     * placement of underscores.
     */
    public boolean areWordBoundariesMarked( ) {
        return this.areWordBoundariesMarked;
    }
    
    
    
}
