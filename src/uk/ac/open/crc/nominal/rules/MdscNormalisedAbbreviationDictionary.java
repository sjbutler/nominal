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

import uk.ac.open.crc.mdsc.DictionarySet;
import uk.ac.open.crc.mdsc.NormalisedAbbreviationDictionaryManager;

/**
 * ENSURE THIS CLASS IS DEPRECATED AND CALLERS ARE USING THE POOL.
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
@Deprecated
public class MdscNormalisedAbbreviationDictionary {

    private static MdscNormalisedAbbreviationDictionary instance = null;
    
    public static MdscNormalisedAbbreviationDictionary getInstance() {
        if ( instance == null ) {
            instance = new MdscNormalisedAbbreviationDictionary();
        }
        
        return instance;
    }
    
    
    // ----------------------------
    
    private final NormalisedAbbreviationDictionaryManager dictionaryManager;
    
    private MdscNormalisedAbbreviationDictionary() {
        this.dictionaryManager = new NormalisedAbbreviationDictionaryManager();
    }
    
    public DictionarySet getDictionaries() {
        return this.dictionaryManager.dictionarySet();
    }
}
