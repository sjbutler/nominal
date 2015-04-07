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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.open.crc.idtk.Modifier;
import uk.ac.open.crc.idtk.Species;
import uk.ac.open.crc.idtk.TypeName;
import uk.ac.open.crc.nominal.information.AbbreviationInformation;
import uk.ac.open.crc.nominal.information.AcronymInformation;
import uk.ac.open.crc.nominal.information.BodyCapitalisationSummaryInformation;
import uk.ac.open.crc.nominal.information.CipherInformation;
import uk.ac.open.crc.nominal.information.FirstCharacterCapitalisationInformation;
import uk.ac.open.crc.nominal.information.IdentifierInformation;
import uk.ac.open.crc.nominal.information.InformationClassification;
import uk.ac.open.crc.nominal.information.PhraseInformation;
import uk.ac.open.crc.nominal.information.SpellingSummaryInformation;
import uk.ac.open.crc.nominal.information.StandaloneAbbreviationInformation;
import uk.ac.open.crc.nominal.information.StandardPrefixInformation;
import uk.ac.open.crc.nominal.information.TokenInformation;
import uk.ac.open.crc.nominal.information.TypeAcronymInformation;
import uk.ac.open.crc.nominal.rules.IdentifierClassification;
import uk.ac.open.crc.nominal.util.CollectionReference;

/**
 * Represents an identifier name and its metadata and is annotated with 
 * information objects when tested by nominal. 
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class IdentifierName {

    private static final Logger LOGGER = LoggerFactory.getLogger( IdentifierName.class );
    
    
    private final TokenisedName tokenisedName;
    
    private final TypeName typeName;
    
    private final Species species;
    
    private final List<Modifier> modifiers;
    
    private final List<IdentifierInformation> informationList;
    
    private IdentifierClassification identiferClassification;
    
    private final int argumentCount;
    
    private final boolean isArrayDeclaration;
    private final boolean isCollectionReference;
    private final boolean isLoopControlVariable;
    
    private final String entityUid = "";
    private final String containerUid = "";
    
    public IdentifierName( 
            TokenisedName tokenisedName,
            TypeName typeName,
            Species species,
            List<Modifier> modifiers,
            int argumentCount,
            List<TypeName> superTypes,
            boolean isArrayDeclaration,
            boolean isLoopControlVariable ) {
        this.tokenisedName = tokenisedName;
        
        this.typeName = typeName;
        this.species = species;
        this.modifiers = modifiers;
        this.argumentCount = argumentCount;
        
        this.informationList = new ArrayList<>();
        this.identiferClassification = null; // use lazy instantiation rather than a leaky constructor.
        this.isCollectionReference = this.species.isReference()
                && CollectionReference.isCollection( simplifyTypeName( this.type() ) );
        this.isArrayDeclaration = isArrayDeclaration;
        this.isLoopControlVariable = isLoopControlVariable;
    }
    
    public final String nameString() {
        return this.tokenisedName.nameString();
    }
    
    
    public List<String> componentWords() {
        return this.tokenisedName.normalisedTokensAsText();
    }
    
    public List<TaggedToken> taggedTokens() {
        return this.tokenisedName.taggedTokens();
    }
    
    public String phraseSummary() {
        return this.tokenisedName.phraseSummary();
    }
    
    public Token firstToken() {
        if ( this.tokenisedName.taggedTokens().isEmpty() ) {
            return null;
        }
        else {
            return this.tokenisedName.taggedTokens().get( 0 );
        }
    }
    
    public Token lastToken() {
        if ( this.tokenisedName.taggedTokens().isEmpty() ) {
            return null;
        }
        else {
            return this.tokenisedName.taggedTokens()
                    .get( this.tokenisedName.taggedTokens().size() - 1 );
        }
    }
    
    
    public List<String> posTags() {
        return this.tokenisedName.posTags();
    }
    
    
    /**
     * Retrieves a list of the tokens where the original capitalisation is 
     * retained.
     * @return a @{code List} of {@code Token}s capitalised in the
     * identifier name.
     */
    public List<TaggedToken> unnormalisedTokens() {
        return this.tokenisedName.taggedTokens();
    }
    
    public String containerUid() {
        return this.containerUid;
    }
    
    public String entityUid() {
        return this.entityUid;
    }
    
    public final String type() {
        return this.typeName.identifierName();
    }
    
    public Species species() {
        return this.species;
    }
    
    public List<Modifier> modifiers() {
        return this.modifiers;
    }
    
    /**
     * The number of normalised tokens following splitting by intt.
     * @return the number of tokens
     */
    public int tokenCount() {
        return this.tokenisedName.taggedTokens().size();
    }
    
    /**
     * The number of arguments to the method.
     * 
     * @return the number of arguments to the method, or -1 if this 
     * is not a  method or constructor.
     */
    public int argumentCount() {
        return this.argumentCount;
    }
    
    /**
     * Add information.
     * @param information an instance of {@code IdentifierInformation}
     */
    public void add( IdentifierInformation information ) {
        this.informationList.add( information );
    }
    
    /**
     * Retrieve all the information attached to the token.
     * @return a list of information items attached to the token.
     */
    public List<IdentifierInformation> getInformationList() {
        return this.informationList;
    }
    
    /**
     * Retrieve specific information about an identifier name.
     * @param informationClass An enum constant that identifies the type of 
     * information.
     * @return a list of information items attached to the identifier name 
     */
    public List<IdentifierInformation> getInformationList( InformationClassification informationClass ) {
        List<IdentifierInformation> classifiedInformationList = new ArrayList<>();
        
        this.informationList.stream().filter( (information) -> ( information.classification() == informationClass ) ).forEach( (information) -> {
            classifiedInformationList.add( information );
        } );
        
        return classifiedInformationList;
    }
    
    /**
     * Retrieves the classification.
     * 
     * @return a classification of this identifier name.
     */
    public IdentifierClassification classification() {
        if ( this.identiferClassification == null ) {
            this.identiferClassification = 
                    IdentifierClassification.getClassificationFor( this );
        }
        
        return this.identiferClassification;
    }
    
    
    // modal expansion
    public ArrayList<Token> expandedTokens() {
        throw new UnsupportedOperationException();
    }
    
    
    // abbreviation expansion plus modals, plus recombination
    public ArrayList<Token> fullyExpandedTokens() {
        throw new UnsupportedOperationException();
    }
    
    
    public boolean isCollectionReference() {
        return this.isCollectionReference;
    }
    
    
    /**
     * Indicates whether the identifier name contains a known abbreviation.
     * @return a boolean
     */
    public boolean containsAbbreviation() {
//       AbbreviationInformation
        boolean containsAbbreviation = false;
        
        for ( Token token : this.tokenisedName.taggedTokens() ) {
            for ( TokenInformation information : token.getInformationList(InformationClassification.ABBREVIATION ) ) {
                if ( ((AbbreviationInformation) information).isKnownAbbreviation() ) {
                    containsAbbreviation = true;
                }
            }
        }
               
        return containsAbbreviation;
    }

    /**
     * Indicates whether the identifier name contains a known acronym.
     * @return a boolean
     */
    public boolean containsAcronym() {
        boolean containsAcronym = false;
        
        
        for ( Token token : this.tokenisedName.taggedTokens() ) {
            for (TokenInformation information : token.getInformationList(InformationClassification.ACRONYM )) {
                if (  ((AcronymInformation) information).isKnownAcronym() ) {
                    containsAcronym = true;
                }
            }
        }
        
        return containsAcronym;
    }
    
    /**
     * Reports whether the identifier name is a correctly used cipher.
     * @return {@code true} when a known cipher is correctly used.
     */
    public boolean isCipherCorrect() {
        boolean isCipher;
        
        if ( this.tokenisedName.taggedTokens().size() == 1 ) {
            List<IdentifierInformation> list = this.getInformationList(InformationClassification.CIPHER );
            if ( !list.isEmpty() ) {
                CipherInformation information = (CipherInformation) list.get( 0 );
                isCipher = information.isCorrect();
            }
            else {
                isCipher = false;                
            }
        }
        else {
            isCipher = false;
        }
        
        return isCipher;
    }
    
    public boolean isArrayDeclaration() {
        return this.isArrayDeclaration;
    }
    
    public boolean isLoopControlVariable() {
        return this.isLoopControlVariable;
    }
    
    /**
     * Indicates whether the identifier name is a known cipher.
     * @return {@code true} if a single token identifier name and a known cipher.
     */
    public boolean isKnownCipher() {
        boolean isKnownCipher;
        
        if ( this.tokenisedName.taggedTokens().size() == 1 ) {
            List<IdentifierInformation> list = this.getInformationList(InformationClassification.CIPHER );
            if ( !list.isEmpty() ) {
                CipherInformation information = (CipherInformation) list.get( 0 );
                isKnownCipher = information.isKnownCipher();
            }
            else {
                isKnownCipher = false;                
            }
        }
        else {
            isKnownCipher = false;
        }
        
        return isKnownCipher;
    }
    
    public boolean isBodyTypographyCorrect() {
        List<IdentifierInformation> list = this.getInformationList(InformationClassification.CAPITALISATION_INTERNAL_SUMMARY );
        
        if ( list.isEmpty() ) {
            LOGGER.error( "No body capitalisation information present" );
            throw new IllegalStateException( "Missing body capitalisation information" );
        }
        BodyCapitalisationSummaryInformation information = (BodyCapitalisationSummaryInformation) list.get( 0 ); 
        
        return information.isCorrect();
    }
    
    
    public boolean isFirstCharTypographyCorrect() {
        List<IdentifierInformation> list = this.getInformationList(InformationClassification.CAPITALISATION_LEADING );
        
        if ( list.isEmpty() ) {
            LOGGER.error( "No body capitalisation information present" );
            throw new IllegalStateException( "Missing body capitalisation information" );
        }
        FirstCharacterCapitalisationInformation information = (FirstCharacterCapitalisationInformation) list.get( 0 ); 
        
        return information.isCorrect();
    }
    
    public boolean isTypeAcronym() {
        List<IdentifierInformation> list = this.getInformationList(InformationClassification.TYPE_ACRONYM );
        if ( list.isEmpty() ) {
            LOGGER.error( "No type acronym information present" );
            throw new IllegalStateException( "Missing type acronym information" );
        }
        
        TypeAcronymInformation information = (TypeAcronymInformation) list.get( 0 );
        
        return information.isTyepAcronym();
    }
    
    public boolean isTypeAcronymCorrect() {
        List<IdentifierInformation> list = this.getInformationList(InformationClassification.TYPE_ACRONYM );
        if ( list.isEmpty() ) {
            LOGGER.error( "No type acronym information present" );
            throw new IllegalStateException( "Missing type acronym information" );
        }
        
        TypeAcronymInformation information = (TypeAcronymInformation) list.get( 0 );
        
        return information.isCorrect();
    }
    
    public boolean hasLeadingUnderscore() {
        List<IdentifierInformation> list = this.getInformationList(InformationClassification.UNDERSCORE_LEADING );
        if ( list.isEmpty() ) {
            LOGGER.error( "No leading underscore information present" );
            throw new IllegalStateException( "missing leading underscore information" );
        }
        IdentifierInformation information = list.get( 0 );
        
        return information.isCorrect();
    }
    
    public boolean hasTrailingUnderscore() {
        List<IdentifierInformation> list = this.getInformationList(InformationClassification.UNDERSCORE_TRAILING );
        if ( list.isEmpty() ) {
            LOGGER.error( "No trailing underscore information present" );
            throw new IllegalStateException( "missing trailing underscore information" );
        }
        IdentifierInformation information = list.get( 0 );
        
        return information.isCorrect();
    }
    
    public boolean isSeparatorUseCorrect() {
        List<IdentifierInformation> list = this.getInformationList(InformationClassification.SEPARATOR );
        if ( list.isEmpty() ) {
            LOGGER.error( "No separator information present" );
            throw new IllegalStateException( "missing separator information" );
        }
        IdentifierInformation information = list.get( 0 );
        
        return information.isCorrect();
    }
    
    public boolean isPrefixUseCorrect() {
        Token firstToken = this.firstToken();
        
        if ( firstToken == null ) {
            LOGGER.warn(  "No first token for identifier name \"{}\"", this.nameString() );
            return false;
        }
        else {
            List<TokenInformation> list = this.firstToken().getInformationList(InformationClassification.PREFIX );
            if ( list.isEmpty() ) {
                LOGGER.error( "No prefix information present" );
                throw new IllegalStateException( "missing prefix information" );
            }
            TokenInformation information = list.get( 0 );

            return information.isCorrect();
        }
    }
    
    public boolean isPhraseCorrect() {
        List<IdentifierInformation> list = this.getInformationList(InformationClassification.PHRASE );
        if ( list.isEmpty() ) {
            LOGGER.error( "No phrase information present" );
            throw new IllegalStateException( "missing phrase information" );
        }
        
        boolean isPhraseCorrect = false;
        IdentifierInformation correctInformation = null;
        // iterate over the phrases

        for ( IdentifierInformation information :  list ) {
            if ( information.isCorrect() ) {
                isPhraseCorrect = true;
            }
        }
        
        return isPhraseCorrect;
    }
    
    
    public String phraseFound() {
        // look for the correct phrase and return that
        List<IdentifierInformation> list = this.getInformationList(InformationClassification.PHRASE );
        if ( list.isEmpty() ) {
            LOGGER.error( "No phrase information present" );
            throw new IllegalStateException( "missing phrase information" );
        }
        
        PhraseInformation correctInformation = null;
        // iterate over the phrases

        for ( IdentifierInformation information :  list ) {
            if ( information.isCorrect() ) {
                correctInformation = (PhraseInformation) information;
                break;
            }
        }
        
        String phrase;
        if ( correctInformation != null ) {
            phrase = correctInformation.phraseSummary();
        }
        else {
            // if phrase is incorrect return the default tagger's rendition of the phrase
            phrase = ( (PhraseInformation) list.get( 0 )).phraseSummary();
        }
        
        return phrase;
    }
    
    /**
     * Relies on the {@code SpellingSummaryInformation} object.
     * @return {@code true} if the identifier name is spelt correctly, i.e. iff
     * any prefix or branding is correctly used, and all words are correctly 
     * spelled or are acronyms or byte code mnemonics.
     */
    public boolean isSpellingCorrect() {
        List<IdentifierInformation> list = this.getInformationList(InformationClassification.SPELLING_SUMMARY );
        if ( list.isEmpty() ) {
            LOGGER.error( "No spelling summary information present" );
            throw new IllegalStateException( "missing spelling summary information" );
        }
        
        SpellingSummaryInformation information = (SpellingSummaryInformation) list.get( 0 );
        
        return information.isCorrect();
    }
    
    public boolean isStandardPrefixPresent() {
        List<IdentifierInformation> list = 
                this.getInformationList(InformationClassification.STANDARD_PREFIX );
        if ( list.isEmpty() ) {
            return false;
        }
        
        StandardPrefixInformation information = (StandardPrefixInformation) list.get( 0 );
        
        return information.hasPrefix();
    }
    
    public boolean isStandardPrefixUseCorrect() {
        List<IdentifierInformation> list = 
                this.getInformationList(InformationClassification.STANDARD_PREFIX );
        if ( list.isEmpty() ) {
            return false;
        }
        
        StandardPrefixInformation information = (StandardPrefixInformation) list.get( 0 );
        
        return information.isCorrect();
    }
    
    public boolean isStandaloneAbbreviation() {
        List<IdentifierInformation> list = 
                this.getInformationList(InformationClassification.STANDALONE_ABBREVIATION );
        if ( list.isEmpty() ) {
            return false;
        }
        
        StandaloneAbbreviationInformation information = 
                (StandaloneAbbreviationInformation) list.get( 0 );
        
        return information.isPresent();
    }
    
    public boolean isStandaloneAbbreviationCorrect() {
        List<IdentifierInformation> list = 
                this.getInformationList(InformationClassification.STANDALONE_ABBREVIATION );
        if ( list.isEmpty() ) {
            return false;
        }
        
        StandaloneAbbreviationInformation information = 
                (StandaloneAbbreviationInformation) list.get( 0 );
        
        return information.isCorrect();
    }
    
    
    
    
    // desparation clone -- try to find a good home for this and other similar utility methods
    private String simplifyTypeName( String typeName ) {
        // strip everything to the left of the rightmost dot, including the dot
        int lastDotIndex = typeName.lastIndexOf( "." );
        String s = lastDotIndex == -1 ? typeName : typeName.substring( lastDotIndex + 1 );
        
        // strip everything to the right of the first left angle bracket, including the bracket. 
        int lAngleIndex = s.indexOf( "<" );
        return lAngleIndex == -1 ? s : s.substring( 0, lAngleIndex );
    }

}
