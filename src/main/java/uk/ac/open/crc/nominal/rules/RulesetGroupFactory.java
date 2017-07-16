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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.open.crc.nominal.rules.parser.NominalLexer;
import uk.ac.open.crc.nominal.rules.parser.NominalParser;
import uk.ac.open.crc.nominal.rules.parser.NominalVisitor;
import uk.ac.open.crc.nominal.rules.parser.NominalVisitorImplementation;

/**
 * A group of static factory methods that create complete 
 * sets of rule sets {@link Ruleset} from various input sources.
 * See each method for the supported type of input.
 */
public class RulesetGroupFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(RulesetGroupFactory.class );
    
    private static final String DEFAULT_RULES_FILE = "ajc-rules.nom";
    private static final String GOSLING_RULES_FILE = "jls-rules.nom";
    private static final String VERMEULEN_RULES_FILE = "ejs-rules.nom";
    
    private RulesetGroupFactory() {}
    
    /**
     * Creates a {@code RulesetGroup} using one of the stored definitions.
     * @param rulesSelector one of "ajc", "jls" or "ejs" to specify one 
     * of the ruleset definitions in nominal. 
     * @return a {@code RulesetGroup} instance.
     * @throws IOException if the file cannot be found in the jar
     */
    public static RulesetGroup createDefaultRulesetGroup( 
            final String rulesSelector ) throws IOException {

        String rulesFileName;
        switch ( rulesSelector ) {
            case "ajc":
                rulesFileName = DEFAULT_RULES_FILE;
                break;
            case "jls":
                rulesFileName = GOSLING_RULES_FILE;
                break;
            case "ejs":
                rulesFileName = VERMEULEN_RULES_FILE;
                break;
            default:
                LOGGER.warn(
                        "Unknown rule set specified with selector \"{}\"\n"
                                + "Loading default rule set",
                        rulesSelector );
                rulesFileName = DEFAULT_RULES_FILE;
                break;
        }
	
        return populateRulesetGroup( new RulesetGroup(), "/rules/" + rulesFileName );
    }

    /**
     * Creates a {@code RulesetGroup} containing the rules specified
     * in an external file.
     * @param definitionFile a file containing conventions defined 
     * in nominal's language
     * @return an instance of {@code RulesetGroup}.
     * @throws IOException if required resource is not found in jar file
     * @throws java.io.FileNotFoundException if specified file is not found.
     */
    public static RulesetGroup createRulesetGroup ( File definitionFile ) 
            throws IOException, FileNotFoundException {
            return populateRulesetGroup( new RulesetGroup(), definitionFile );
    }
    
    /**
     * Creates a <code>RulesetGroup</code> consisting of the default rules
     * overwritten by any rules defined in the specified file.
     * <p>
     * NB the rule is that any defined rule <strong>replaces</strong> the 
     * default rule, it does not refine it.
     * </p>
     * @param definitionFilePath path to a file containing convention 
     * definitions in nominal's language
     * @return an instance of {@code RulesetGroup}
     * @throws java.io.IOException if internal file is not found in jar
     * @throws java.io.FileNotFoundException if external nominal (.nom) file 
     * is not found
     */
    public static RulesetGroup createRulesetGroupWithDefaults( String definitionFilePath ) 
            throws IOException, FileNotFoundException {
        RulesetGroup rulesetGroup;
        try {
            rulesetGroup = createDefaultRulesetGroup( "ajc" );
        }
        catch ( IOException e ) {
            LOGGER.warn(
                    "Unable to access default rules: {}", 
                    e.getMessage());
            throw e;
        }
        
        return populateRulesetGroup(rulesetGroup, definitionFilePath );
    }
    

    /**
     * Creates a <code>RulesetGroup</code> consisting of the default rules
     * overwritten by any rules defined in the specified file.
     * <p>
     * NB the rule is that any defined rule <strong>replaces</strong> the 
     * default rule, it does not refine it.
     * </p>
     * @param definitionFile path to a file containing convention 
     * definitions in nominal's language
     * @return an instance of {@code RulesetGroup}
     * @throws java.io.IOException if internal resource is not found in jar
     * @throws java.io.FileNotFoundException if external nominal (.nom) file 
     * is not found
     */
    public static RulesetGroup createRulesetGroupWithDefaults( File definitionFile ) 
            throws IOException, FileNotFoundException {
        RulesetGroup rulesetGroup;
        try {
            rulesetGroup = createDefaultRulesetGroup( "ajc" );
        }
        catch ( IOException e ) {
            LOGGER.warn(
                    "Unable to access default rules: {}", 
                    e.getMessage());
            throw e;
        }
        
        return populateRulesetGroup(rulesetGroup, definitionFile );
    }
    
    // loads rules from jar file
    private static RulesetGroup populateRulesetGroup( RulesetGroup rulesetGroup, String definitionFilePath ) 
            throws IOException {
        try (InputStream is = RulesetGroupFactory.class.getResourceAsStream( definitionFilePath )) {
	    return parseStream(rulesetGroup, is);
        }
        catch ( FileNotFoundException e ) {
            LOGGER.error( 
                    "Unable to access resource in jar file: \"{}\" : {}", 
                    definitionFilePath, 
                    e.getMessage() );
            throw e; 
        }
    } 
    
    // loads rules from external file
    private static RulesetGroup populateRulesetGroup( RulesetGroup rulesetGroup, File definitionFile ) 
            throws IOException, FileNotFoundException {
        try (InputStream is = new FileInputStream( definitionFile )) {
	    return parseStream(rulesetGroup, is);
        }
        catch ( FileNotFoundException e ) {
            LOGGER.error( 
                    "Unable to access file \"{}\" : {}", 
                    definitionFile, 
                    e.getMessage() );
            throw e; 
        }
    } 
    
    private static RulesetGroup parseStream(RulesetGroup rulesetGroup, InputStream is) 
	    throws IOException {
	CharStream input = CharStreams.fromStream( is );
	NominalLexer nominalLexer = new NominalLexer( input );
	CommonTokenStream tokens = new CommonTokenStream( nominalLexer );
	NominalParser nominalParser = new NominalParser( tokens );
	ParseTree parseTree = nominalParser.file();

	NominalVisitor nominalVisitor = 
		new NominalVisitorImplementation( rulesetGroup );
	nominalVisitor.visit( parseTree );

	addDummyRulesets( rulesetGroup );

	return rulesetGroup;
    }

    // inserts empty rulesets into any gaps in the
    // hierarchy to prevent NPEs during recursive search for rules
    private static void addDummyRulesets( RulesetGroup rulesetGroup ) {
        
        for ( IdentifierClassification ic : IdentifierClassification.values() ) {
            Ruleset rs = rulesetGroup.get( ic );
            if ( rs == null ) {
                rs = new Ruleset( ic );
                rulesetGroup.add( rs );
            }
        }
        
    }
}
