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
 * Abstract class implemented by all information classes
 * used to annotate {@code IdentifierName} instances.
 */
public abstract class IdentifierInformation implements Information {
    private final InformationClassification classification;
    private final List<String> explanations;
    
    protected IdentifierInformation( InformationClassification classification ) {
        this.classification = classification;
        this.explanations = new ArrayList<>();
    }
    
    @Override
    public InformationClassification classification() {
        return this.classification;
    }
    
    /**
     * Retrieves the list of explanations.
     * @return a {@code List} of messages
     */
    @Override
    public List<String> explanations() {
        return this.explanations;
    }
    
    /**
     * Adds a (terse) message explaining the classification made by 
     * a given rule.
     * @param explanation a brief message
     */
    public final void addExplanation( String explanation ) {
        this.explanations.add( explanation );
    }
    
}
