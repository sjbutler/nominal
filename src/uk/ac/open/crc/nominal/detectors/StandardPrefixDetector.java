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

package uk.ac.open.crc.nominal.detectors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import uk.ac.open.crc.idtk.Species;
import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.TaggedToken;
import uk.ac.open.crc.nominal.information.StandardPrefixInformation;
import uk.ac.open.crc.nominal.rules.RulesetGroup;

/**
 * Detects a range of standard prefixes recognising them as such and 
 * determining the correctness of their use. 
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class StandardPrefixDetector implements Detector {

    // two sets of standard prefixes that intersect
    // species/role: {f,m,p}
    // type: {b,c,d,f,i,l,o} = boolean/byte,char, double, float, int, long, object
    
    private final static HashMap<String,List<String>> prefixMap;
    
    static {
        prefixMap = new HashMap<>();
        List<String> types = new ArrayList<>();
        types.add( "boolean" );
        types.add( "Boolean" );
        types.add( "byte" );
        types.add( "Byte" );
        prefixMap.put(  "b" ,  types );
        types = new ArrayList<>();
        types.add( "char" );
        types.add( "Character" );
        prefixMap.put(  "c" ,  types );
        types = new ArrayList<>();
        types.add(  "double" );
        types.add( "Double" );
        prefixMap.put( "d", types );
        types = new ArrayList<>();
        types.add( "float" );
        types.add( "Float" );
        prefixMap.put( "f", types );
        types = new ArrayList<>();
        types.add( "int" );
        types.add( "Integer" );
        prefixMap.put( "i", types );
        types = new ArrayList<>();
        types.add( "long" );
        types.add( "Long" );
        prefixMap.put( "l", types );
        types = new ArrayList<>();
        types.add( "Object" );
        prefixMap.put( "o", types );
    }
    
    private final RulesetGroup ruleSetGroup;
    
    public StandardPrefixDetector( RulesetGroup ruleSetGroup ) {
        this.ruleSetGroup = ruleSetGroup;
    }
    
    @Override
    public StandardPrefixInformation test(IdentifierName identifierName ) {
        boolean isCorrect = false;
        boolean hasPrefix = false;
        List<TaggedToken> tokens = identifierName.taggedTokens(); // so we test the token used, not the normalised
        
        if ( tokens != null && !tokens.isEmpty() && tokens.size() != 1 ) {
            String firstTokenText = tokens.get( 0 ).text();
            if ( firstTokenText.length() == 1 ) {
                if ( isSpeciesPrefix( firstTokenText ) ) {
                    hasPrefix = true;
                    isCorrect = isCorrectSpeciesPrefix( firstTokenText, identifierName.species() );
                }
                
                if ( !isCorrect && isTypedPrefix( firstTokenText ) ) {
                    hasPrefix = true;
                    isCorrect = prefixMatchesType( firstTokenText, identifierName.type() );
                }
            }
        }
        
        StandardPrefixInformation information = 
                new StandardPrefixInformation( isCorrect, hasPrefix );
        
        identifierName.add( information );
        return information;
    }
    
    private boolean isSpeciesPrefix( final String prefix ) {
        return "f".equals( prefix ) 
                || "m".equals( prefix ) 
                || "p".equals( prefix );
    }
    
    private boolean isCorrectSpeciesPrefix( 
            final String prefix, 
            final Species species ) {
        
        return ( species == Species.FIELD 
                        && ( "m".equals( prefix ) || "f".equals( prefix ) ) 
                || ( species == Species.FORMAL_ARGUMENT 
                && "p".equals( prefix ) ) );
    }
    
    private boolean isTypedPrefix( final String prefix ) {
        return prefixMap.keySet().contains( prefix );
    }
    
    private boolean prefixMatchesType( final String prefix, final String type ) {
        return prefixMap.get( prefix ).contains( type );
    }
}
