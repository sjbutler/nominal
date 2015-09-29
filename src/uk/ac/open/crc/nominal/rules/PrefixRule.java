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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.detectors.BrandingDictionary;
import uk.ac.open.crc.nominal.detectors.PrefixDictionary;
import uk.ac.open.crc.nominal.information.PrefixInformation;
import uk.ac.open.crc.nominal.Token;

/**
 * Implements a test for a prefix string on an identifier name. This can be 
 * a single character or a more complex string. The test is case sensitive. 
 * 
 * <p>NB: do not instantiate this class in an attempt to implement a 'no prefix' 
 * test -- it cannot test the negative. </p> THIS IS CHANGING
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class PrefixRule extends AbstractRule {

    private static final String EXPLANATION_PREFIX_PRESENT = "Expected prefix found";
    private static final String EXPLANATION_PREFIX_ABSENT = "Expected prefix not found";
    
    private static final PrefixDictionary prefixDictionary;
    private static final BrandingDictionary brandingDictionary;
    
    static {
        prefixDictionary = PrefixDictionary.getInstance();
        brandingDictionary = BrandingDictionary.getInstance();
    }
    
    private final List<String> prefixes;
    private String explanation;
    
    private final boolean prefixesExpected;
    
    public PrefixRule( List<String> prefixes ) {
        super( RuleType.PREFIX );
        this.prefixes = new ArrayList<>( prefixes );
        this.explanation = "";
        this.prefixesExpected = ! this.prefixes.isEmpty();
    }
    
    /**
     * Creates a prefix rule that does not permit the use of prefixes,
     */
    public PrefixRule() {
        this( new ArrayList<>() );
    }
    
  
    /**
     * The result of this test is only valid for the first non-separator token
     * in the identifier name, and is not valid for single token identifier 
     * names. 
     * @param identifierName an identifier name.
     * @return a {@code PrefixInformation} instance, or null where the 
     * test cannot be applied &ndash; i.e. a single token name or a separator only.
     */
    @Override
    public PrefixInformation test( IdentifierName identifierName ) {
        PrefixInformation information = null;
        if (identifierName.tokenCount() != 1 ) {
            if ( this.prefixesExpected ) {
                information = prefixesExpectedTest( identifierName );
            }
            else {
                information = prefixesNotExpectedTest( identifierName );
            }
        }
        
        return information;
    }
    
    
    private PrefixInformation prefixesExpectedTest( IdentifierName identifierName ) {
        Token firstToken = identifierName.firstToken();
        String text;
        boolean isCorrect;
        if ( firstToken != null ) {
            text = identifierName.firstToken().text();
            isCorrect = this.prefixes.contains( text );
        }
        else {
            text="";
            isCorrect = false;
        }
        PrefixInformation information = new PrefixInformation( 
                isCorrect,
                prefixDictionary.isPrefix( text ), 
                prefixDictionary.isPrefixIgnoreCase( text ));
        
        information.setBranding( brandingDictionary.isBrand( text ) );
        information.setBrandingIgnoreCase( 
                brandingDictionary.isBrandIgnoreCase( text.toLowerCase() ) );

        if ( firstToken != null ) {
            information.addExplanation( 
                    isCorrect 
                            ? EXPLANATION_PREFIX_PRESENT 
                            : EXPLANATION_PREFIX_ABSENT );
            identifierName.firstToken().add( information );
        }
        else {
            information.addExplanation( "non alphanumeric identifier name" );
            // don't add to anything -- so this else is redundant.
        }
        
        return information;
    }

    private PrefixInformation prefixesNotExpectedTest( IdentifierName identifierName ) {
        Token firstToken = identifierName.firstToken();
        if ( firstToken != null ) {
            String text = identifierName.firstToken().text();
            boolean isCorrect = ! prefixDictionary.isPrefix( text );
            PrefixInformation information = new PrefixInformation( 
                    isCorrect,
                    prefixDictionary.isPrefix( text ), 
                    prefixDictionary.isPrefixIgnoreCase( text ));

            information.setBranding( brandingDictionary.isBrand( text ) );
            information.setBrandingIgnoreCase( 
                    brandingDictionary.isBrandIgnoreCase( text.toLowerCase() ) );

            information.addExplanation( 
                    isCorrect 
                            ? EXPLANATION_PREFIX_ABSENT 
                            : EXPLANATION_PREFIX_PRESENT );

            identifierName.firstToken().add( information );

            return information;
        }
        else {
            return null; // I don't think this is ever assigned to anything.
        }
    }
    
    /**
     * Returns the prefixes used to define the rule.
     * 
     * @return the prefixes defined in the rule.
     */
    @Override
    public String toString() {
        return this.prefixes.stream().
                sorted().collect( Collectors.joining( ", ", "Prefix set {", "}" ) );
    }
}
