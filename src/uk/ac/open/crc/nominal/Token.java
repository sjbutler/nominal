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

import java.util.ArrayList;
import java.util.List;
import uk.ac.open.crc.nominal.information.InformationClassification;
import uk.ac.open.crc.nominal.information.TokenInformation;

/**
 * Represents a single token in a split identifier name. This class 
 * carries information about any transformations required to correct 
 * the token.
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class Token {

    private final List<TokenInformation> informationList;
    private final String text;
    
    public Token( String text ) {
        this.informationList = new ArrayList<>();
        this.text = text;
    }
    
    /**
     * Retrieves the string that makes up the token. 
     * @return 
     */
    public String text() {
        return this.text;
    }
    
    
    public void add( TokenInformation information ) {
        this.informationList.add( information );
    }
    
    /**
     * Retrieve all the information attached to the token.
     * @return a list of information items attached to the token.
     */
    public List<TokenInformation> getInformationList() {
        return this.informationList;
    }
    
    
    /**
     * Retrieve specific information about a token.
     * @param informationClass An enum constant that identifies the type of 
     * information.
     * @return a list of information items attached to the token 
     */
    public List<TokenInformation> getInformationList( InformationClassification informationClass ) {
        List<TokenInformation> classifiedInformationList = new ArrayList<>();
        
        this.informationList.stream().filter( (information) -> ( information.classification() == informationClass ) ).forEach( (information) -> {
            classifiedInformationList.add( information );
        } );
        
        return classifiedInformationList;
    }
    
    
    
}
