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
import java.util.HashSet;
import java.util.Set;

/**
 * A {@code Ruleset} is relatively costly to instantiate and should be 
 * instantiated and potentially cached by another object. 
 * 
 * @author Simon Butler (simon@facetus.org.uk)
 * 
 */
public class Ruleset { // class needs to be public as it will be used outside the package

    private final HashMap<RuleType,Rule> rules;
    private final IdentifierClassification classification;
    
    /**
     * Creates an instance of {@code RuleSet} for the given classification.
     * @param classification sub-species of identifier name the rule set applies to.
     */
    public Ruleset ( IdentifierClassification classification ) {
        this.classification = classification;
        this.rules = new HashMap<>();
        this.rules.put( RuleType.SEPARATOR, new SeparatorRule() ); // default rule is no separators and declared alternatives will override the default
        this.rules.put( RuleType.PREFIX, new PrefixRule() ); // default rule of no prefixes -- this will be overwritten if defined by user
    }

    
    // maybe revise package structure so that parsers are in the same package
    // and this method can be made package private. 
    /**
     * Mechanism to add rules to the rule set. If you find yourself using this 
     * through the API as part of your code, you probably shouldn't be using it, 
     * it is intended for internal use only. 
     * @param rule an instance of {@code Rule}
     */
    public void add( Rule rule ) {
        this.rules.put( rule.ruleType(), rule );
    }
    
 
    /**
     * Retrieves the sub-species of identifier name for which the {@code Ruleset} 
     * is defined.
     * @return 
     */
    public IdentifierClassification getClassification() {
        return this.classification;
    }
    
    
    public Rule getRule( RuleType ruleType ) {
        return this.rules.get( ruleType );
    }
    

    // FOR TESTING ONLY. REVIEW DESIGN IF THERE IS ANY TEMPTATION 
    // TO USE THIS METHOD FOR ANY PURPOSE OTHER THAN TESTING.
    //
    final Set<Rule> rules() {
        return new HashSet<>( this.rules.values() );
    }
    
}
