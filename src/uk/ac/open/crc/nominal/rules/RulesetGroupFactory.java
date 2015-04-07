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
package uk.ac.open.crc.nominal.rules;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.antlr.v4.runtime.ANTLRInputStream;
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
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class RulesetGroupFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(RulesetGroupFactory.class );
    
    private static final String DEFAULT_RULES_FILE = "ajc-rules.nom";
    private static final String GOSLING_RULES_FILE = "jls-rules.nom";
    private static final String VERMEULEN_RULES_FILE = "ejs-rules.nom";
  
    
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
        
        InputStream inStream = 
                RulesetGroupFactory.class.getResourceAsStream( rulesFileName );
        ANTLRInputStream input = 
                new ANTLRInputStream( new BufferedReader(new InputStreamReader(inStream)) );
        NominalLexer nominalLexer = new NominalLexer( input );
        CommonTokenStream tokens = new CommonTokenStream( nominalLexer );
        NominalParser nominalParser = new NominalParser( tokens );
        ParseTree parseTree = nominalParser.file();

        // now start the walk with an injected instance of RulesetGroup
        RulesetGroup rulesetGroup = new RulesetGroup();
        NominalVisitor nominalVisitor = new NominalVisitorImplementation( rulesetGroup );
        nominalVisitor.visit( parseTree );
        
        addDummyRulesets( rulesetGroup );
        
        return rulesetGroup;
    }

    /**
     * Creates a {@code RulesetGroup} containing the rules specified
     * in an external file.
     * @param conventionsDefinitionFile a file containing conventions defined 
     * in nominal's language
     * @return an instance of {@code RulesetGroup}.
     * @throws java.io.IOException 
     */
    public static RulesetGroup createRulesetGroup ( File conventionsDefinitionFile ) throws IOException {
        RulesetGroup rulesetGroup = new RulesetGroup();
        
        // read the source file and parse it adding rules
        FileReader fileReader;
        try {
            fileReader = new FileReader( conventionsDefinitionFile );
        }
        catch ( FileNotFoundException e ) {
            LOGGER.error( 
                    "Unable to access file \"{}\" : {}", 
                    conventionsDefinitionFile.getName(), 
                    e.getMessage() );
            throw e; 
        }
        
        ANTLRInputStream input = new ANTLRInputStream( new BufferedReader( fileReader ) );
        NominalLexer nominalLexer = new NominalLexer( input );
        CommonTokenStream tokens = new CommonTokenStream( nominalLexer );
        NominalParser nominalParser = new NominalParser( tokens );
        ParseTree parseTree = nominalParser.file();
        
        // now start the walk with an injected instance of RulesetGroup
        NominalVisitor nominalVisitor = new NominalVisitorImplementation( rulesetGroup );
        nominalVisitor.visit( parseTree );
        
        addDummyRulesets( rulesetGroup );
        
        
        return rulesetGroup;
    }
    
    
    /**
     * Creates a  <code>RulesetGroup</code> consisting of the default rules
     * overwritten by any rules defined in the specified file.
     * <p>
     * NB the rule is that any defined rule <strong>replaces</strong> the 
     * default rule, it does not refine it.
     * </p>
     * @param conventionsDefinitionFile a file containing convention 
     * definitions in nominal's language
     * @return an instance of {@code RulesetGroup}.
     * @throws java.io.IOException 
     */
    public static RulesetGroup createRulesetGroupWithDefaults( File conventionsDefinitionFile ) throws IOException {
        RulesetGroup rulesetGroup;
        try {
            rulesetGroup = createDefaultRulesetGroup( "ajc" );
        }
        catch ( IOException e ) {
            LOGGER.warn(
                    "Unable to access default rules: {}", 
                    e.getMessage());
            return null;
        }
        
        FileReader fileReader;
        try {
            fileReader = new FileReader( conventionsDefinitionFile );
        }
        catch ( FileNotFoundException e ) {
            LOGGER.warn( 
                    "Unable to access file \"{}\" : {}", 
                    conventionsDefinitionFile.getName(), 
                    e.getMessage() );
            throw e; 
        }
        
        ANTLRInputStream input = new ANTLRInputStream( new BufferedReader( fileReader ) );
        NominalLexer nominalLexer = new NominalLexer( input );
        CommonTokenStream tokens = new CommonTokenStream( nominalLexer );
        NominalParser nominalParser = new NominalParser( tokens );
        ParseTree parseTree = nominalParser.file();
        
        // now start the walk with an injected instance of RulesetGroup
        NominalVisitor nominalVisitor = new NominalVisitorImplementation( rulesetGroup );
        nominalVisitor.visit( parseTree );
        
        addDummyRulesets( rulesetGroup );
        
        return rulesetGroup;
    }
    
    
    private static void addDummyRulesets( RulesetGroup rulesetGroup ) {
        // the following block of code inserts dummy rulesets in the 
        // hierarchy to prevent NPEs during the recursion up the tree
        Ruleset fieldRuleSet = rulesetGroup.get( IdentifierClassification.FIELD );
        if ( fieldRuleSet == null  ) {
            fieldRuleSet = new Ruleset( IdentifierClassification.FIELD );
            rulesetGroup.add( fieldRuleSet );
            // may need to insert field-constant and field-variable where only their children are defined to ensure the rule search cascades up to field
            Ruleset fieldConstantRuleSet = rulesetGroup.get( IdentifierClassification.FIELD_CONSTANT );
            if ( fieldConstantRuleSet == null ) {
                fieldConstantRuleSet = new Ruleset( IdentifierClassification.FIELD_CONSTANT );
                // default underscores and capitalisation? Though any child 
                // should have defined those rules
                rulesetGroup.add( fieldConstantRuleSet );
            }
            Ruleset fieldVariableRuleSet = rulesetGroup.get( IdentifierClassification.FIELD_VARIABLE );
            if ( fieldVariableRuleSet == null ) {
                fieldVariableRuleSet = new Ruleset( IdentifierClassification.FIELD_VARIABLE );
                
                rulesetGroup.add( fieldVariableRuleSet );
            }
        }
        
        Ruleset formalRuleSet = rulesetGroup.get( IdentifierClassification.FORMAL_ARGUMENT );
        if ( formalRuleSet == null ) {
            formalRuleSet = new Ruleset( IdentifierClassification.FORMAL_ARGUMENT );
            rulesetGroup.add( formalRuleSet );
        }
        
        Ruleset localRuleSet = rulesetGroup.get( IdentifierClassification.LOCAL_VARIABLE );
        if ( localRuleSet == null ) {
            localRuleSet = new Ruleset( IdentifierClassification.LOCAL_VARIABLE );
            rulesetGroup.add( localRuleSet );
        }
    }
}
