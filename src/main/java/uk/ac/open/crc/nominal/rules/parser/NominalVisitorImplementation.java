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

package uk.ac.open.crc.nominal.rules.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.open.crc.nominal.rules.AcronymTypographyRule;
import uk.ac.open.crc.nominal.rules.BodyTypographyRule;
import uk.ac.open.crc.nominal.rules.CaseType;
import uk.ac.open.crc.nominal.rules.CipherMap;
import uk.ac.open.crc.nominal.rules.CipherMapStore;
import uk.ac.open.crc.nominal.rules.CipherRule;
import uk.ac.open.crc.nominal.rules.FirstCharacterTypographyRule;
import uk.ac.open.crc.nominal.rules.IdentifierClassification;
import uk.ac.open.crc.nominal.rules.PhraseRule;
import uk.ac.open.crc.nominal.rules.PluralRule;
import uk.ac.open.crc.nominal.rules.Ruleset;
import uk.ac.open.crc.nominal.rules.RulesetGroup;
import uk.ac.open.crc.nominal.rules.SeparatorRule;
import uk.ac.open.crc.nominal.rules.StandaloneAbbreviationRule;
import uk.ac.open.crc.nominal.rules.TypeAcronymRule;

/**
 * Visitor that creates rules defined in .nom files.
 */
public class NominalVisitorImplementation extends NominalBaseVisitor<String> {
    private static final Logger LOGGER 
            = LoggerFactory.getLogger( NominalVisitorImplementation.class );
    private final RulesetGroup rulesetGroup;
    private Ruleset currentRuleset;
    
    private final HashMap<String,ArrayList<CipherRule>> cipherRules;
    
    private Set<String> phrases;
    
    /**
     * Creates a visitor and injects a rule set group instance to be 
     * populated from the rules in the .nom file being parsed.
     * 
     * @param ruleSetGroup a rule set group
     */
    public NominalVisitorImplementation( RulesetGroup ruleSetGroup ) {
        super();
        this.rulesetGroup = ruleSetGroup;
        this.cipherRules = new HashMap<>();
    }
    
    
    @Override
    public String visitTypeRule( NominalParser.TypeRuleContext context ) {
        String ruleName = context.TYPE_SELECTOR().toString();
        IdentifierClassification classification = 
                IdentifierClassification.getClassificationFor( ruleName );
	
	this.currentRuleset = this.rulesetGroup.get( classification );
	
        if ( this.currentRuleset == null ) {
            this.currentRuleset = new Ruleset( classification );
            this.rulesetGroup.add( currentRuleset );
        }
        
        visitChildren( context ); // now traverse the definitions and collect the rules.
        
        return "";
    }
    
    
    @Override
    public String visitMethodRule( NominalParser.MethodRuleContext context ) {
        String ruleName = context.METHOD_SELECTOR().toString();
        IdentifierClassification classification = 
                IdentifierClassification.getClassificationFor( ruleName );
        this.currentRuleset = this.rulesetGroup.get( classification );
        
        if ( this.currentRuleset == null ) {
            this.currentRuleset = new Ruleset( classification );
            this.rulesetGroup.add( currentRuleset );
        }
        
        visitChildren( context ); // now traverse the definitions and collect the rules.
        
        return "";
    }
    
    
    @Override
    public String visitReferenceRule( NominalParser.ReferenceRuleContext context ) {
        String ruleName = context.REFERENCE_SELECTOR().toString();
        IdentifierClassification classification = 
                IdentifierClassification.getClassificationFor( ruleName );
        this.currentRuleset = this.rulesetGroup.get( classification );
        
        if ( this.currentRuleset == null ) {
            this.currentRuleset = new Ruleset( classification );
            this.rulesetGroup.add( currentRuleset );
        }
        
        visitChildren( context ); // now traverse the definitions and collect the rules.
        
        return "";
    }
    
    
    @Override
    public String visitLabelRule( NominalParser.LabelRuleContext context ) {
        String ruleName = context.LABEL_SELECTOR().toString();
        IdentifierClassification classification = 
                IdentifierClassification.getClassificationFor( ruleName );
        this.currentRuleset = this.rulesetGroup.get( classification );
        
        if ( this.currentRuleset == null ) {
            this.currentRuleset = new Ruleset( classification );
            this.rulesetGroup.add( currentRuleset );
        }
        
        visitChildren( context ); // now traverse the definitions and collect the rules.
        
        return "";
    }
    
    @Override
    public String visitCipherDefinition( NominalParser.CipherDefinitionContext context ) {
        
        String listIdentifier;
        
        if ( context.ListIdentifier() != null ) {
            listIdentifier = context.ListIdentifier().getText();
        }
        else {
            listIdentifier = "default";
        }
        
        this.currentRuleset.add( new CipherRule( listIdentifier ) );
        
        return "";
    }
    
    
    // this is defined or not and off by default
    // so when defined this allows standalone abbreviations
    @Override
    public String visitStandaloneAbbreviation( 
            NominalParser.StandaloneAbbreviationContext context ) {
        
        this.currentRuleset.add( new StandaloneAbbreviationRule( true ) );
        
        // there are no children to visit!
        
        return "";
    }
    
    
    @Override
    public String visitTypeAcronym( NominalParser.TypeAcronymContext context ) {
        
        this.currentRuleset.add( new TypeAcronymRule( true ) );
        // no children to visit
        
        return "";
    }
    
    @Override
    public String visitBodyDefinition( NominalParser.BodyDefinitionContext context ) {
        String value = context.bodyValue().getText();
        CaseType caseType = CaseType.getCaseTypeFor( value );
        this.currentRuleset.add(new BodyTypographyRule( caseType ) );
        
        visitChildren( context );  // Is this necessary??
        
        return "";
    }
    
    
    @Override
    public String visitFirstCharDefinition( 
            NominalParser.FirstCharDefinitionContext context ) {
        String value = context.firstCharValue().getText();
        CaseType caseType = CaseType.getCaseTypeFor( value );
        this.currentRuleset.add(new FirstCharacterTypographyRule( caseType ) );
        
        visitChildren( context );  // Is this necessary??
        
        return "";
    } 
    
    
    // use this to put the set in place for the phrase rules
    // and to create and add phrase rules following 
    // visit to children
    @Override
    public String visitTypeContentDefinition( 
            NominalParser.TypeContentDefinitionContext context ) {
        this.phrases = new HashSet<>();
        
        visitChildren( context );
        
        this.currentRuleset.add( new PhraseRule( phrases ) );
        
        this.phrases = null; // unnecessary, but will cause NPE if misused
        
        return "";
    }
    
    @Override
    public String visitMethodContentDefinition( 
            NominalParser.MethodContentDefinitionContext context ) {
        this.phrases = new HashSet<>();
        
        visitChildren( context );
        
        this.currentRuleset.add( new PhraseRule( phrases ) );
        
        this.phrases = null; // unnecessary, but will cause NPE if misused
        
        return "";
    }
    
    
    
    @Override
    public String visitReferenceContentDefinition( NominalParser.ReferenceContentDefinitionContext context ) {
        this.phrases = new HashSet<>();
        
        visitChildren( context );
        
        this.currentRuleset.add( new PhraseRule( phrases ) );
        
        this.phrases = null; // unnecessary, but will cause NPE if misused
        
        return "";
    }
    
    
    
    @Override
    public String visitLabelContentDefinition( 
            NominalParser.LabelContentDefinitionContext context ) {
        this.phrases = new HashSet<>();
        
        visitChildren( context );
        
        this.currentRuleset.add( new PhraseRule( phrases ) );
        
        this.phrases = null; // unnecessary, but will cause NPE if misused
        
        return "";
    }
    
    // there may be multiple phrase value definitions
    // in a given content declaration
    @Override
    public String visitPhraseValue( NominalParser.PhraseValueContext context ) {
        
        String specifiedPhrase = context.COMPOUND_PHRASE_NAME().getText();
        
        boolean isDuplicate = ! this.phrases.add( specifiedPhrase );
        
        if ( isDuplicate ) {
            LOGGER.warn( 
                    "duplicate declaration of \"{}\" found at line {} column {}", 
                    specifiedPhrase, 
                    context.start.getLine(), 
                    context.start.getCharPositionInLine() );
        }
        
        return "";
    }
    
    @Override
    public String visitSeparatorDefinition( 
            NominalParser.SeparatorDefinitionContext context ) {
        Set<String> separators = new HashSet<>();
        context.separatorValue().SEPARATOR_CHARACTER()
                .stream().forEach( separatorCharacter -> {
            separators.add( separatorCharacter.getText() );
        } );
        boolean hasMultiplier = context.separatorValue().MULTIPLIER() != null; // as multiplier has only one possible meaning ATM
        this.currentRuleset.add( new SeparatorRule( separators, hasMultiplier ) );

        visitChildren( context );  // Is this necessary??
        
        return "";
    }

    
    
    @Override
    public String visitPluralDefinition( NominalParser.PluralDefinitionContext context ) {
        boolean isPlural = Boolean.valueOf( context.BooleanValue().getText() );
        this.currentRuleset.add(new PluralRule( isPlural ) );
        
        return "";
    }
    
    
    @Override
    public String visitCipherListDefinition( NominalParser.CipherListDefinitionContext context ) {
        CipherMapStore store = CipherMapStore.getInstance();
        
        String listIdentifier;
        if ( context.DEFAULT() != null ) {
            listIdentifier = "default";
        }
        else {
            listIdentifier = context.ListIdentifier().getText();
        }
        CipherMap map = new CipherMap( listIdentifier );
        store.store( listIdentifier, map );
        
        // iterate over each line of the cipher definitions
        // and add to the map
        context.cipherDeclaration()
                .stream()
                .forEach( declaration -> {
                    Set<String> types = new HashSet<>();
                    declaration.javaTypeName()
                            .stream()
                            .forEach( typeName -> {
                                boolean isDuplicate = ! types.add( typeName.getText() );
                                if ( isDuplicate ) {
                                    LOGGER.warn( 
                                            "Duplicate type declaration in "
                                                    + "cipher list \"{}\" "
                                                    + "at line:{} column:{}", 
                                            listIdentifier, 
                                            context.start.getLine(), 
                                            context.start.getCharPositionInLine() );
                                }
                            } );
                    declaration.CipherName()
                            .stream()
                            .forEach( cipherName -> map.put( cipherName.getText(), types ) );
                } );
        
        return "";
    }
    
    
    @Override
    public String visitAcronymTypographyRule( 
            NominalParser.AcronymTypographyRuleContext context ) {
        CaseType caseType = 
                CaseType.getCaseTypeFor( context.acronymTypography().getText() );
        
        AcronymTypographyRule rule = new AcronymTypographyRule( caseType );
        this.rulesetGroup.add( rule );
        
        return "";
    }
}
