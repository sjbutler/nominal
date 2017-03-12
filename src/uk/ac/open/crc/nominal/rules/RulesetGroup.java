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

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Encapsulates a set of {@linkplain Ruleset} objects. {@code RulesetGroup}s
 * may be comprehensive, containing a {@code Ruleset} for each 
 * {@linkplain IdentifierClassification}, or partial with a {@code Ruleset}
 * for only some of the species sub-types.
 */
public class RulesetGroup {
    private static final Logger LOGGER = LoggerFactory.getLogger(RulesetGroup.class );
    private final HashMap<IdentifierClassification, Ruleset> rulesets;
    private final static int HASHMAP_CAPACITY = 
            IdentifierClassification.values().length; // number of terms defined in IdentifierClassification enumeration
    
    private final Map<RuleType,Rule> defaultRules;
    
    
    /**
     * Creates a new instance of {@code RuleSetGroup}.
     */
    RulesetGroup() {
        this.rulesets = new HashMap<>( HASHMAP_CAPACITY );
        this.defaultRules = new HashMap<>();
        // redundant prefixes (none)
        this.defaultRules.put( RuleType.REDUNDANT_PREFIX, new RedundantPrefixRule() );
        // no separators
        this.defaultRules.put( RuleType.SEPARATOR, new SeparatorRule() );
        // plural unspecified
        this.defaultRules.put( RuleType.PLURAL, new PluralRule() );
        // standalone abbreviations -- off
        this.defaultRules.put( 
                RuleType.STANDALONE_ABBREVIATION, 
                new StandaloneAbbreviationRule() );
        // ciphers -- none 
        this.defaultRules.put( RuleType.CIPHER, new CipherRule() );
        this.defaultRules.put(RuleType.TYPE_ACRONYM, new TypeAcronymRule() );
        this.defaultRules.put( RuleType.PREFIX, new PrefixRule() );
    }
    
    /**
     * Retrieves a {@code Ruleset} for the classification.
     * @param classification the name classification of the ruleset
     * @return a {@link Ruleset Ruleset} or {@code null} if none has been specified
     */
    public Ruleset get( IdentifierClassification classification ) {
        
        Ruleset ruleset = null;
        IdentifierClassification parentClassification = classification.parent();
        while ( ruleset == null ) {
            if ( parentClassification == null ) {
                parentClassification = classification;
            }
            ruleset = this.rulesets.get( classification );
            if ( classification == parentClassification ) {
                break;
            }
            else {
                classification = parentClassification;
                parentClassification = classification.parent();
            }
        }
    
        return ruleset;
    } 
    
    /**
     * Retrieves the requested rule. If the requested rule is not available
     * an IllegalStateException will be thrown. This is brutal, but the contract
     * to provide a rule needs to be enforced either here, or in the client 
     * classes.
     * 
     * @param classification the classification of the name
     * @param ruleType a key for the type of rule requested
     * @return an instance of {@code Rule}
     */
    public Rule get( 
            IdentifierClassification classification, 
            RuleType ruleType ) {
        Ruleset ruleset = this.get( classification );
        if ( ruleset == null ) {
            LOGGER.error(
                    "No rule set defined for {} or any of its parents.", 
                    classification.description());
            throw new IllegalStateException(); 
        }
        
        IdentifierClassification parentClassification = classification.parent();
        
        // look for the lowest relevant rule in the hierarchy.
        // switch to the default ruleset if there is no rule
        // otherwise defined.
        Rule rule = ruleset.getRule( ruleType );
        
        if ( rule == null ) {
            // invoke method on parent classification
            if ( classification != parentClassification ) {
                rule = this.get( parentClassification, ruleType );
            }
            else {
                // we're at the top of the user defined tree
                // so we can only check the defaults.
                rule = this.defaultRules.get( ruleType );
            }
            
            if ( rule == null ) {
                LOGGER.error(
                        "Could not retrieve {} rule in rule set for {}", 
                        ruleType.description(), classification.description() );
                throw new IllegalStateException();
            }
        }
        
        return rule;
    }
    
    /**
     * Adds a {@link Ruleset Ruleset} to the group. NB this method overwrites 
     * any pre-existing {@code Ruleset} defined for the same 
     * identifier classification.
     * @param ruleset an instance of {@code Ruleset}
     */
    public void add( Ruleset ruleset ) {
        this.rulesets.put( ruleset.getClassification(), ruleset );
    }
    
    /**
     * Adds a {@code Rule} to the default rules. This mechanism is 
     * for adding global rules. NB default rules can be overridden
     * by declarations in rule sets.
     * @param rule a default rule
     */
    public void add( Rule rule ) {
        this.defaultRules.put( rule.ruleType(), rule);
    }
    
}
