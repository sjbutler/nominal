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

package uk.ac.open.crc.nominal.information;

/**
 * This information is only attached to single token identifier names. 
 * It identifier whether the cipher is known, whether it is of 
 * the correct type and whether it is correctly used.
 *
 * <p>
 * NB: an unknown cipher can never be correct. The test is whether the 
 * cipher is known and correctly used. Any other single character identifier 
 * name cannot be a cipher because it is not in the list of known ciphers.
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class CipherInformation extends IdentifierInformation {

    private final boolean isCorrect;
    private final boolean isKnownCipher;
    private final boolean isCorrectType;
    
    public CipherInformation( 
            final boolean isCorrect, 
            final boolean isKnownCipher,
            final boolean isCorrectType ) {
        super( InformationClassification.CIPHER );
        this.isCorrect = isCorrect;
        this.isKnownCipher = isKnownCipher;
        this.isCorrectType = isCorrectType;
    }
    
    /**
     * Indicates whether the cipher has been correctly used, i{.}e{.} the 
     * cipher is known, and is of the correct type. An example would be the 
     * use of {@code i} as a loop control variable where it has been 
     * declared as an {@code int}.
     * @return {@code true} if the cipher has been correctly used.
     */
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
    /**
     * Indicates if the cipher is one of the set of ciphers stated in 
     * the relevant rule. The cipher may be known and incorrectly used.
     * @return {@code true} if the cipher has been defined in the rules.
     */
    public boolean isKnownCipher() {
        return this.isKnownCipher;
    }
    
    public boolean isCorrectType() {
        return this.isCorrectType;
    }
    
}
