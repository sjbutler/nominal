/*
    Copyright (C) 2013-2015 The Open University
    Copyright (C) 2017 Simon Butler

    SPDX-FileCopyrightText: 2013-2015 The Open University
    SPDX-FileCopyrightText: 2017 Simon Butler
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

package uk.ac.open.crc.nominal.rules;

import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.TaggedToken;
import uk.ac.open.crc.nominal.Token;
import uk.ac.open.crc.nominal.information.CipherInformation;

// NB: instances of this class created by the nominal parser.
// the cipher map is populated by the same parser and
// most likely after this object is instantiated, hence
// the lazy assignment of the reference to the specified cipher map. 
/**
 * Embodies the rules on cipher use.
 */
public class CipherRule extends IdentifierRule {
    private static final Logger LOGGER = LoggerFactory.getLogger( CipherRule.class );
    
    private CipherMap cipherMap;
    private final String cipherMapKey;
    private final boolean isPermitted;
    
    /**
     * Creates a cipher rule based on a set of ciphers and types declared in 
     * a nominal conventions description. 
     * @param cipherMapKey an identifier for a user defined set of 
     * ciphers declared in a nominal file.
     */
    public CipherRule( final String cipherMapKey ) {
        super( RuleType.CIPHER );
        this.cipherMapKey = cipherMapKey;
        this.isPermitted = true;
    }
   
    /**
     * Creates a default cipher rule where ciphers are not permitted
     * and the use of common ciphers is identified and flagged as 
     * incorrect.
     */
    public CipherRule() {
        super( RuleType.CIPHER );
        this.cipherMapKey = "__common_ciphers__";
        this.isPermitted = false;
    }
    
    // needs to be able to look for super type
    /**
     * Determines whether the identifier name is a cipher, if appropriate.
     * Test may be applied to non-reference species, but makes little sense.
     * @param identifierName an identifier name to be evaluated
     * @return a {@code CipherInformation} object, or {@code null} if the 
     * identifier name consists of more than a single token, or is 
     * not a reference
     */
    @Override
    public CipherInformation test( IdentifierName identifierName ) {
        populateCipherMap();        
           
        return evaluateName(identifierName);
    }
    
    private void populateCipherMap() {
        if ( this.cipherMap == null || this.cipherMap.isEmpty() ) {
            this.cipherMap = CipherMapStore.getInstance().get( this.cipherMapKey );
            if ( this.cipherMap == null || this.cipherMap.isEmpty() ) {
                LOGGER.error( 
                        "No ciphers defined for cipher list identifier \"{}\"", 
                        this.cipherMapKey );
                throw new IllegalStateException( 
                        String.format( "Undefined cipher list: %s", 
                        this.cipherMapKey ) );
            }
        }
    }
    
    private CipherInformation evaluateName( IdentifierName identifierName ) {
        if ( identifierName.tokenCount() > 1 ) {
            return null;
        }
        
        List<TaggedToken> originalTokens = identifierName.taggedTokens();
        Token originalToken = originalTokens.get( 0 );
        boolean isKnownCipher = this.cipherMap.isKnownCipher( originalToken.text() );
        boolean isCorrectType = false;
        if ( isKnownCipher ) {
            Set<String> types = this.cipherMap.typeList( originalToken.text() );
            for ( String type : types ) {
                if ( "*".equals( type ) ) {
                    isCorrectType = true;
                }
                else if ( identifierName.type().equals( type ) ) { 
                    isCorrectType = true;
                }
                else if ( type.startsWith( "*" ) ) {
                    String superType = type.substring( 2 );

                    isCorrectType = identifierName.type().equals( superType )  
                                    || identifierName.type().endsWith( superType ) 
                                    //|| // super type check in JavaRef
                                    ;
                }
                if ( isCorrectType ) {
                    break;
                }
            }
        }

        boolean isCorrect = isKnownCipher 
                            && isCorrectType 
                            && this.isPermitted;

        CipherInformation information = 
                new CipherInformation( isCorrect, isKnownCipher, isCorrectType );
        identifierName.add( information );
        return information;
    }
}
