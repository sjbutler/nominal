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

package uk.ac.open.crc.nominal;


/**
 * Represents a single token in a tokenised identifier name with 
 * its associated PoS tag.
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class TaggedToken extends Token {

    private final String normalisedText;
    private final String tag;
    
    public TaggedToken( String text, String tag ) {
        super( text );
        this.normalisedText = text.toLowerCase();
        this.tag = tag;
    }
    
    public String tag() {
        return this.tag;
    }
    
    public String normalisedText() {
        return this.normalisedText;
    }
}
