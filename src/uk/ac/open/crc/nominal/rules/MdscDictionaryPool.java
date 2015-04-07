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

import uk.ac.open.crc.mdsc.AbbreviationDictionaryManager;
import uk.ac.open.crc.mdsc.AcronymDictionaryManager;
import uk.ac.open.crc.mdsc.DictionaryManager;
import uk.ac.open.crc.mdsc.DictionarySet;
import uk.ac.open.crc.mdsc.NormalisedDictionaryManager;
import uk.ac.open.crc.mdsc.NormalisedIso3166DictionaryManager;

/**
 * Provides mdsc dictionaries for nominal classes.
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class MdscDictionaryPool {
        
    private static MdscDictionaryPool instance = null;
    
    public static MdscDictionaryPool getInstance() {
        if ( instance == null ) {
            instance = new MdscDictionaryPool();
        }
        
        return instance;
    }
    
    
    //---------------------------------------------
    private final DictionaryManager abbreviationDictionaryManager;
    private final DictionarySet abbreviationDictionaries;
    private final DictionaryManager wordDictionaryManager;
    private final DictionarySet wordDictionaries;
    private final DictionaryManager acronymDictionaryManager;
    private final DictionarySet acronymDictionaries;
    private final DictionaryManager iso3166DictionaryManager;
    private final DictionarySet iso3166Dictionaries;
    
    
    
    
    private MdscDictionaryPool() {
        this.abbreviationDictionaryManager = new AbbreviationDictionaryManager();
        this.abbreviationDictionaries = this.abbreviationDictionaryManager.dictionarySet();
        this.wordDictionaryManager = new NormalisedDictionaryManager();
        this.wordDictionaries = this.wordDictionaryManager.dictionarySet();
        this.acronymDictionaryManager = new AcronymDictionaryManager();
        this.acronymDictionaries = this.acronymDictionaryManager.dictionarySet();
        this.iso3166DictionaryManager = new NormalisedIso3166DictionaryManager();
        this.iso3166Dictionaries = this.iso3166DictionaryManager.dictionarySet();
    }
    
    
    
    public DictionarySet abbreviationDictionaries() {
        return this.abbreviationDictionaries;
    }
    
    
    public DictionarySet acronymDictionaries() {
        return this.acronymDictionaries;
    }
    
    
    public DictionarySet wordDictionaries() {
        return this.wordDictionaries;
    }
    
    
    public DictionarySet iso3166Dictionaries() {
        return this.iso3166Dictionaries;
    }
    
}
