/*
    Copyright (C) 2013-2015 The Open University

    SPDX-FileCopyrightText: 2013-2015 The Open University
    SPDX-License-Identifier: Apache-2.0

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
 * Classes that describe and implement rules for identifier naming.
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
 * {@link RulesetGroupFactory} is used to create instances of {@link RulesetGroup}
 * constructed from text files of rules either stored in a jar file, on the 
 * filesystem. {@code RulesetGroup}s are then used to 
 * test instances of {@code IdentifierName}, which need to be instantiated by 
 * the caller. 
 * </p>
 * 
 * <p>
 * Rule sets are created for a particular sub-species or type of identifier name, 
 * e.g. a method that takes no arguments and returns a boolean. Each {@link Ruleset} 
 * contains {@link Rule}s for typography and phrase structure. 
 * </p>
 * 
 * <p>
 * The grammar for .nom files defining rules is available from the 
 * package {@code uk.ac.open.crc.nominal.rules.parser}.
 * </p>
 * 
 * 
 * 
 */
package uk.ac.open.crc.nominal.rules;
