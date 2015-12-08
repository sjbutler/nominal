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
 * for the presence of separators. This class will evolve when the language 
 * is updated to allow the specification of separator use.
 */
public class SeparatorInformation extends IdentifierInformation {

    private final boolean hasSeparators;
    private final boolean hasUnderscores;
    private final boolean hasDollarSigns;
    private boolean hasContiguousUnderscores;
    private final boolean isCorrect;
    private boolean areTokenBoundariesMarked;
    
    /**
     * Constructor.
     * @param isCorrect indicates whether separator use follows the user 
     * specified rules
     * @param hasUnderscores indicates whether the name contains underscores
     * @param hasDollarSigns indicates whether the name contains dollar signs
     */
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
        this.areTokenBoundariesMarked = false;
    }
    
    /**
     * Indicates whether separator use follows the user specified rules.
     * @return true if the separator use rules have been followed
     */
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
    
    /** 
     * Indicates whether the name contains underscores.
     * @return true iff the name contains one or more underscores
     */
    public boolean hasUndercores() {
        return this.hasUnderscores;
    }
    
    /**
     * Indicates whether the name contains dollar signs.
     * @return true iff the name contains one or more dollar sign
     */
    public boolean hasDollarSigns() {
        return this.hasDollarSigns;
    }
    
    /**
     * Sets a field to indicate whether the name contains contiguous underscores.
     * @param hasContiguousUnderscores true if contiguous underscores 
     * are found in the name
     */
    public void hasContiguousUnderscores( boolean hasContiguousUnderscores ) {
        this.hasContiguousUnderscores = hasContiguousUnderscores;
    }
    
    /**
     * Sets a field to indicate whether the name contains contiguous separators.
     * @return true iff contiguous separators are found in the name
     */
    public boolean hasContiguousSeparators() {
        return this.hasContiguousUnderscores;
    }
    
    /**
     * Sets a field to indicate whether word/token boundaries are marked with 
     * separators.
     * @param areTokenBoundariesMarked true iff a separator is found between 
     * each token
     */
    public void areTokenBoundariesMarked( boolean areTokenBoundariesMarked ) {
        this.areTokenBoundariesMarked = areTokenBoundariesMarked;
    }
    
    /**
     * Indicates whether underscores mark all the token boundaries. The definition
     * of a token boundary is that determined by intt, which may find fewer or 
     * more token boundaries than the developer inserted.
     * @return {@code true} if intt and the developer agree on the number and 
     * placement of underscores.
     */
    public boolean areTokenBoundariesMarked( ) {
        return this.areTokenBoundariesMarked;
    }
    
}
