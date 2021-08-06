//
//  Copyright (C) 2013-2015 The Open University
// 
//  SPDX-FileCopyrightText: 2013-2015 The Open University
//  SPDX-License-Identifier: Apache-2.0
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
//     http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

grammar Nominal;

//@header {
//    package uk.ac.open.crc.nominal.rules.parser;
//}

file 
    : 
        subspeciesRule+ listDefinition globalRules EOF
    ;

subspeciesRule
    :
     typeRule
    | methodRule
    | referenceRule
    | labelRule
    ;


typeRule
    :
     TYPE_SELECTOR
     '{'
     typeRuleDefinition+
     '}'
    ;


methodRule
    :
     METHOD_SELECTOR   
     '{'
     methodRuleDefinition+
     '}'
    ;

referenceRule 
    :
     REFERENCE_SELECTOR
     '{'
     referenceRuleDefinition+
     '}'
    ;

labelRule 
    :
    LABEL_SELECTOR
     '{'   
        labelRuleDefinition+
     '}'
    ;

typeRuleDefinition
    :
     typographyDefinition
         | pluralDefinition 
         | typeContentDefinition
    ;

methodRuleDefinition
    :
        typographyDefinition
         | pluralDefinition 
         | methodContentDefinition
    ;

referenceRuleDefinition
    :
    typographyDefinition
         | pluralDefinition 
         | referenceContentDefinition
    ;

labelRuleDefinition
    :
    typographyDefinition
     | labelContentDefinition
    ;

typographyDefinition
    :
        bodyDefinition
	 | firstCharDefinition
	 | prefixDefinition
	 | separatorDefinition
    ;
	
bodyDefinition
	:
	'body' ':' bodyValue ';'
	;
	
firstCharDefinition
	:
	'first-char' ':' firstCharValue ';'
	;
	
prefixDefinition
	:
	'prefix' ':' prefixValue ';'
	;

separatorDefinition
	:
	'separator' ':'  separatorValue ';'
	;


//sigilDefinition
//    :
//        'sigil' ':' SIGIL_VALUE ';'
//    ;

pluralDefinition
    :
        'plural' ':' BooleanValue ';'
    ;

cipherDefinition
    :
     'cipher' ListIdentifier?
    ;

lengthTokenDefinition
    :
     'length-token' ':'   Number ';' 
    ;

lengthCharacterDefinition
    :
     'length-char' ':' Number ';'   
    ;

typeContentDefinition
    :
     'content' ':' typeContentSetting (',' typeContentSetting)* ';'    
    ;

methodContentDefinition
    :
     'content' ':' methodContentSetting (',' methodContentSetting)* ';'    
    ;

referenceContentDefinition
    :
     'content' ':' referenceContentSetting (',' referenceContentSetting)* ';'    
    ;

labelContentDefinition
    :
     'content' ':' labelContentSetting (',' labelContentSetting)* ';'    
    ;

typeContentSetting
    :
     phraseValue
    ;

methodContentSetting
    :
    phraseValue
    ;

referenceContentSetting
    :
     cipherDefinition
    | phraseValue
    | standaloneAbbreviation
    | typeAcronym
    ;

labelContentSetting
    :
    phraseValue
    | standaloneAbbreviation
    ;

bodyValue
    : 
	'mixed'	
        | 'lower'	
        | 'upper'
    ;


firstCharValue
    : 
       'lower'	
        | 'upper'
    ;

standaloneAbbreviation
    :
        STANDALONE_ABBREVIATION
    ;

typeAcronym
    :
        TYPE_ACRONYM
    ;

phraseValue 
	:
        COMPOUND_PHRASE_NAME
	;

prefixValue
    :
    PREFIX_VALUE (',' PREFIX_VALUE)*
    ;

separatorValue
    :
    SEPARATOR_CHARACTER (',' SEPARATOR_CHARACTER)*  MULTIPLIER?   
    ;


// list definitions
listDefinition
    :
       cipherListDefinition* //prefixListDefinition* brandingListDefinition*
    ;

// cipher lists

cipherListDefinition
    :
    'cipher-list' (DEFAULT|ListIdentifier)
    '{'
    cipherDeclaration+
    '}'
    ;

cipherDeclaration 
    :  
    CipherName (',' CipherName)* ':' javaTypeName (',' javaTypeName)* ';'
    ;  

javaTypeName
    :
     classOrInterfaceType
    | PRIMITIVE_TYPE
    | typeWildcardName
    ;

typeWildcardName
    :
     WILDCARD JavaIdentifier?   
    ;

classOrInterfaceType
    :   JavaIdentifier*
    ;


prefixListDefinition
    :
       'prefix-list' ListIdentifier       
       '{'
        prefixDeclaration+   // review and redefine!!
       '}'
    ;

// review this as it seems wrong.
prefixDeclaration
    :
        JavaIdentifier ':' javaTypeName(',' javaTypeName)* ';'
    ;

brandingListDefinition
:
       'branding-list' (DEFAULT|ListIdentifier)
       '{'
        brandingDefinition+ 
       '}'
;


brandingDefinition 
    :
       'brand' ':' JavaIdentifier ';' 
        
    ;

globalRules
    :
     globalRulesDefinition?   
    ;

// review
globalRulesDefinition
    :
       'global' 
       '{'
       acronymTypographyRule
       '}'
    ;

acronymTypographyRule
    :
    'acronyms' ':' acronymTypography ';'
    ;



acronymTypography
    :
    'mixed'
    | 'upper'
    ;

// lexer

TYPE_SELECTOR
    :
     'class'
    | 'class-gui-action'
    | 'class-static-services'
    | 'interface'
    | 'interface-mix-in'
    | 'annotation'
    | 'enumeration'
    ;


METHOD_SELECTOR
    :
    'method'
    | 'method-boolean-args'
    | 'method-boolean-noargs'
    | 'method-nonboolean-args'
    | 'method-nonboolean-noargs'
    | 'method-void-args'
    | 'method-void-noargs'
    ;


REFERENCE_SELECTOR
    :
        'annotation-member'
	| 'enumeration-constant'
        | 'field'
        | 'field-constant'
        | 'field-variable'
	| 'field-constant-boolean'
	| 'field-constant-other'
	| 'field-constant-string'
        | 'field-constant-collection-reference'
	| 'field-variable-action'
	| 'field-variable-boolean'
	| 'field-variable-collection-reference'
	| 'field-variable-other'
        | 'formal-argument'
        | 'formal-argument-action'
	| 'formal-argument-boolean'
	| 'formal-argument-collection-reference'
	| 'formal-argument-other'
        | 'local-variable'
        | 'local-variable-action'
	| 'local-variable-boolean'
	| 'local-variable-collection-reference'
	| 'local-variable-loop-control'
	| 'local-variable-other'
    ;

LABEL_SELECTOR
    :
        'label'
    ;

GENERIC_RULE_NAME
    :
    'branding'
    | 'ciphers'
    ;


ABBREVIATION: 'standalone-abbreviation';
ACRONYMS: 'acronyms';
BRANDING_LIST: 'branding-list';
BODY : 'body' ;
BRAND : 'brand' ;
CIPHER: 'cipher';
CONTENT: 'content';
DEFAULT: 'default';
GLOBAL: 'global';
PLURAL : 'plural' ;
FIRST_CHAR : 'first-char' ;
LENGTH_CHARACTERS : 'length-char' ;
LENGTH_TOKEN : 'length-token' ;
PHRASE : 'phrase' ;
PREFIX : 'prefix' ;
PREFIX_LIST : 'prefix-list' ;
SEPARATOR : 'separator' ;
STANDALONE_ABBREVIATION:  'abbreviation';
TYPE_ACRONYM: 'type-acronym';


COMPOUND_PHRASE_NAME
    : 
    NONE   // is this still necessary
    | COMPLEX
    | PHRASE_NAME+
    ;

PHRASE_NAME
    :
    'AdjP' 
    | 'AdvP'
    | 'NP' 
    | 'PP' 
    | 'VP'
    ;


SEPARATOR_CHARACTER
    :
        JAVA_SEPARATOR_CHARACTER
        | HYPHEN
        | FULL_STOP
    ;

JAVA_SEPARATOR_CHARACTER
    :
    UNDER_SCORE
    | DOLLAR_SIGN
    ;
// in for general solution -- not of practical value for Java
// may be reinstated if there is a serious need for it. 
//SIGIL_NAME
//    :
//        'sigil'
//    ;

// list may not be comprehensive
//SIGIL_VALUE
//    :
//        NONE    // default
//        | '$'
//        | '@'
//        | '%'
//    ;




PRIMITIVE_TYPE
    :   'boolean'
    |   'char'
    |   'byte'
    |   'short'
    |   'int'
    |   'long'
    |   'float'
    |   'double'
    ;

CIPHER_LIST : 'cipher-list';

BooleanValue
    :
    'true'
    | 'false'
    ;

GRAMMATICAL_NUMBER_VALUE
    :
        'singular'
        | 'plural'
        | 'unspecified'
    ;

MIXED : 'mixed' ;

LOWER : 'lower' ;

UPPER : 'upper' ;

NONE : 'none' ;
COMPLEX : 'complex' ;

COLON : ':';
SEMI_COLON : ';';
COMMA : ',';

UNDER_SCORE : '_';
DOLLAR_SIGN : '$';
HYPHEN : '-';
FULL_STOP : '.'; 

BLOCK_OPEN : '{' ;
BLOCK_CLOSE : '}' ;

MULTIPLIER : '+';

WILDCARD: '*';

CipherName
    :
        LOWER_CASE_LETTER
    ;

ListIdentifier :
                LOWER_CASE_LETTER+('-'LOWER_CASE_LETTER+)*[0-9]*   
                ;

// give consideration to including Java separators
JavaIdentifier
    :   LETTER LETTER_OR_DIGIT*
    ;

// define branding separately
PREFIX_VALUE 
	:
    LETTER+ UNDER_SCORE?
	;

Number: DIGIT+ ;

fragment
LETTER: 
    LOWER_CASE_LETTER
    | UPPER_CASE_LETTER
    ;

fragment
LETTER_OR_DIGIT:
    LOWER_CASE_LETTER
    | UPPER_CASE_LETTER
    | DIGIT               
    ;

fragment
LOWER_CASE_LETTER:   [a-z];

fragment
UPPER_CASE_LETTER:   [A-Z];

fragment
DIGIT: [0-9];



// Whitespace and comments
//

WS  :  [ \t\r\n]+ -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;

