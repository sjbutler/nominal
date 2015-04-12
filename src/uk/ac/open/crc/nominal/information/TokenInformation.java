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

import java.util.ArrayList;
import java.util.List;

/**
 * Common implementation of the {@code Information} interface to annotate tokens 
 * with the result of token based rule tests.
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public abstract class TokenInformation implements Information {

    private final InformationClassification classification;
    private final List<String> explanations;
    
    protected TokenInformation( InformationClassification classification ) {
        this.classification = classification;
        this.explanations = new ArrayList<>();
    }
    
    /**
     * Retrieves the classification of the information object
     * @return the classification
     */
    @Override
    public InformationClassification classification() {
        return this.classification;
    }
    
    
    @Override
    public List<String> explanations() {
        return this.explanations;
    }
    
    public void addExplanation( String explanation ) {
        this.explanations.add( explanation );
    }
}
