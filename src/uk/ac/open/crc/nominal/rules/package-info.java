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

/**
 * Classes used to describe and implement rules for identifier naming.
 * 
 * <p>
 * The classes may be divided into two groups. There are infrastructure classes
 * that provide a means of aggregating rules into rule sets, and groups of 
 * rule sets. There are also classes that are components of the rule sets and 
 * represent an individual rule. 
 * </p>
 * 
 * 
 * <p>
 * {@link RuleSetGroupFactory} is used to create instances of {@link RuleSetGroup}
 * constructed from text files of rules either stored in a jar file, on the 
 * filesystem, or injected as a string. {@code RuleSetGroup}s are then used to 
 * test identifier names that are passed in using instances of the 
 * {@code ProgramEntity} class (transfer object) returned by many of the methods 
 * in the {@code jimdb} package. The user should classify the {@code ProgramEntity} 
 * and extract the appropriate rule to test it against.
 * </p>
 * 
 * <p>
 * {@link ruleSetGroupSynthesiser} is a class that supports the derivation of 
 * rule sets (and rule set groups) from surveys of source code. Generating 
 * new rule set groups by this method can be time consuming. NB this functionality
 * has not been developed.
 * </p>
 * 
 * <p>
 * Rule sets are created for a particular sub-species or type of identifier name, 
 * e.g. a method that takes no arguments and returns a boolean. Each {@link RuleSet} 
 * contains {@link Rule}s for typography and phrase structure. 
 * </p>
 * 
 * <p>
 * The grammar for .nom files defining rules is available from &hellip;
 * </p>
 * 
 * <p>
 * Copyright (C) 2013-2015 The Open University
 * </p>
 * 
 * 
 */
// $Id: package-info.java 56 2015-04-02 18:43:02Z simon $
package uk.ac.open.crc.idris.rules;
