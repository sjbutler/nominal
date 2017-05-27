/*
    Copyright (C) 2013-2015 The Open University
    Copyright (C) 2017 Simon Butler

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

package uk.ac.open.crc.nominal.rules;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.information.SeparatorInformation;

/**
 * Implements a rule where a single separator character is used to mark a word 
 * boundary in an identifier
 * name. Successive repetition of the separator character in an identifier name
 * is considered to be unconventional, i.e. {@code X_Y} is accepted by default, but 
 * {@code X__Y} and so on are not. The constructor has a second argument that 
 * controls testing for consecutive use of separator characters. 
 *
 * Predicates for this rule and its variants are:
 * <ul>
 *  <li>programming languages rarely allow consecutive separator characters, 
 * and languages that do, like Java, generally only approve of the use of one, 
 * by convention, sometimes reserving the other for the language/library.</li>
 *  <li>the use of consecutive separator characters is generally discouraged</li>
 *  <li>In Java, separators are generally specified for use in the names of 
 * constants which are defined as static and final. In practice, constant strings 
 * are often named using mixed case and underscores. </li>
 * </ul>
 */
public class SeparatorRule extends AbstractRule {

    private static final String DOLLAR_SIGN = "$";
    private static final String UNDERSCORE = "_";
    private static final String TWO_UNDERSCORES = UNDERSCORE + UNDERSCORE;
    private static final String FULL_STOP = ".";
    private static final String HYPHEN = "-";
    
    private static final Set<String> STANDARD_SEPARATOR_SET;
    private static final Set<String> JAVA_SEPARATOR_SET;
    
    static {
        STANDARD_SEPARATOR_SET = new HashSet<>();
        STANDARD_SEPARATOR_SET.add( DOLLAR_SIGN );
        STANDARD_SEPARATOR_SET.add( UNDERSCORE );
        STANDARD_SEPARATOR_SET.add( FULL_STOP );
        STANDARD_SEPARATOR_SET.add( HYPHEN );
        
        JAVA_SEPARATOR_SET = new HashSet<>();
        JAVA_SEPARATOR_SET.add( UNDERSCORE );
        JAVA_SEPARATOR_SET.add( DOLLAR_SIGN );
    }
    
    private static final String EXPLANATION_SEPARATOR_NOT_FOUND = 
            "No separator characters found.";
    private static final String EXPLANATION_SEPARATOR_FOUND = 
            "Separators characters found.";
    
    
    private final Set<String> separatorSet;
    private final boolean hasMultiplier;
    private String explanation;
    
    /**
     * Creates a rule for the use of separators. A set of separator characters may be
     * passed, and a separate argument defines whether single or multiple separator 
     * character may be used between component words. An empty set means that no
     * separators are permitted.
     * @param separators a set of characters that may be used as separators (an empty )
     * @param multiplier a {@code boolean} that indicates whether contiguous
     * separator characters are permitted.
     */
    public SeparatorRule( Set<String> separators, boolean multiplier ) {
        super( RuleType.SEPARATOR );
        if ( separators == null ) {
            throw new IllegalArgumentException( 
                    "null argument passed to SeparatorRule constructor." );
        }
        this.separatorSet = new HashSet<>( separators );
        this.hasMultiplier = multiplier;
        this.explanation = "";
    }
            
    /**
     * A default constructor that creates a rule that does not allow the use 
     * of separators.
     */
    public SeparatorRule() {
        this( new HashSet<>(), false );
    }
    
    @Override
    public SeparatorInformation test( IdentifierName identifierName ) {
        SeparatorInformation information;
        // first check that we don't have the special case of 
        // an identifier name composed only of separators
        if ( identifierName.nameString().matches( "^[\\$_]+$" ) ) {
            information = new SeparatorInformation( false, false, false); // need to review this idea of state, particularly the contains underscores and dollar signs
            information.addExplanation( 
                    "identifier name composed solely of separator characters" );
        }
        else {
            // the test is against a regex built with normalised tokens
            // leading or trailing underscores means the test will fail
            String identifierNameString = 
                    stripLeadingAndTrailingNonAlphaNumericCharacters( identifierName.nameString() );
            boolean isCorrect;
            // for many identifier names we do not expect separators to be used
            // So many will be defined with empty separator character sets.
            // so make sure that we test according to the rule
            if ( identifierName.tokenCount() == 1 ) { // ignore single word as they must be correct regardless of the rule
                isCorrect = true;
                this.explanation = "single word identifier name";
            } 
            else if ( areSeparatorsExpected() ) {
                String analogueRegex = 
                        buildIdealisedIdentifierNameRegex( identifierName.componentWords() );
                isCorrect = identifierNameString.toLowerCase().matches( analogueRegex );
                // set up explanation 
                this.explanation = 
                        isCorrect ? EXPLANATION_SEPARATOR_FOUND : EXPLANATION_SEPARATOR_NOT_FOUND;
            }
            else {
                // now check there are no separators present
                isCorrect = ! ( containsUserSpecifiedSeparator( identifierNameString )
                        || containsJavaSeparator( identifierNameString ) );

                // set up explanation
                this.explanation = isCorrect 
                        ? EXPLANATION_SEPARATOR_NOT_FOUND 
                        : EXPLANATION_SEPARATOR_FOUND;
            }

            // Java specifics
            boolean containsDollarSign = this.separatorSet.contains( DOLLAR_SIGN ) 
                    && identifierNameString.contains( DOLLAR_SIGN );

            boolean containsUnderscore = this.separatorSet.contains( UNDERSCORE ) 
                    && identifierNameString.contains( UNDERSCORE );

            information = new SeparatorInformation( 
                    isCorrect, containsUnderscore, containsDollarSign );
            information.addExplanation( explanation );
            // this is a minimal test for contiguous underscores.
            information.hasContiguousUnderscores( 
                    identifierNameString.contains( TWO_UNDERSCORES) );
        }

        identifierName.add( information );
        
        return information;
    }
    
    
    /**
     * {@inheritDoc }
     * @return {@inheritDoc }
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder( "Separator Set: ");
        if ( ! this.separatorSet.isEmpty() ) {
            this.separatorSet.stream()
                    .forEach( separator -> output.append( separator ) );
            output.append( System.getProperty( "line.separator" ) );
            output.append( "Multiplier: " );
            output.append( this.hasMultiplier ? "on" : "off" );
        }
        else {
            output.append( "empty. Separators not permitted." );
        }
        output.append( System.getProperty( "line.separator" ) );
        
        return output.toString();
    }
    

    /**
     * Classifies an identifier name according to whether it is expected to 
     * contain a separator character.
     * 
     * @return {@code true} if the rule defines some separator characters.
     */
    private boolean areSeparatorsExpected() {
        return ! this.separatorSet.isEmpty();
    }
    
    // NB see the alternative version!!
    /**
     * Creates a lower case analogue of an idealised version of the identifier 
     * name with separator characters inserted between each component word. 
     * The resulting regular expression is permissive in that combinations of 
     * separators provided  tot he rule are permitted. If the multiplier is 
     * set then contiguous runs of separator characters are permitted. For
     * example if the separator set '$_' is supplied and the component word list 
     * contains a and b then the regular expression 'a[\\$_]+b' will be created.
     * @param componentWords a {@code List} of the component words found in the 
     * identifier name. 
     * @return a regular expression containing an idealised form of the identifier
     * name based on the component word split created by intt and the 
     * supplied separator character set.
     */
    private String buildIdealisedIdentifierNameRegex( List<String> componentWords ) {
        StringBuilder regex = new StringBuilder( componentWords.get( 0 ) );
        String separatorSetElement = 
                separatorSetRegexElement() 
                + (this.hasMultiplier ? "+" : "");
        
        for ( int i = 1; i < componentWords.size(); i++ ) {
            regex.append( separatorSetElement );
            regex.append( componentWords.get( i ) ); 
        }
        
        return regex.toString();
    }
    
    
    private String alternativeBuildIdealisedIdentifierNameRegex( List<String> componentWords ) {
        String separatorSetElement = 
                separatorSetRegexElement() 
                + (this.hasMultiplier ? "+" : "");
        return componentWords.stream().collect( Collectors.joining( separatorSetElement ) );
    }
    
    
    private String separatorSetRegexElement() {
        StringBuilder regex = new StringBuilder( "[" );
        for ( String separatorCharacter : this.separatorSet ) {
            if ( ".".equals( separatorCharacter ) 
                    || "-".equals( separatorCharacter ) 
                    || "$".equals( separatorCharacter ) ) {
                regex.append( "\\" );
            }
            regex.append( separatorCharacter );
        }
        regex.append( "]" );
        
        return regex.toString();
    }
    
    /**
     * Checks for the presence of any member of the set of separator characters
     * in the identifier name being examined. 
     * @param string A string to check for separator characters.
     * @return {@code true} if the identifier name contains a separator character.
     */
    private boolean containsUserSpecifiedSeparator( String string ) {
        return containsSeparator( string, this.separatorSet );
    }
    
    private boolean containsSeparator( String string, Set<String> separators ) {
        boolean containsSeparator = false; 
        
        for ( String separatorCharacter : separators ) {
            if ( string.contains( separatorCharacter ) ) {
                containsSeparator = true;
                break; // any true is good enough
            }
        }
        
        return containsSeparator;
    }
    
    private boolean containsJavaSeparator( String s ) {
        return JAVA_SEPARATOR_SET
                .stream().anyMatch( separator ->  s.contains(separator) );
    }
    
    private boolean containsStandardSeparator( String s ) {
        return STANDARD_SEPARATOR_SET
                .stream().anyMatch( separator ->  s.contains(separator) );
    }
    
}
