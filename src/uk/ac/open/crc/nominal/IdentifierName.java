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
 * 
 * <p>The results of specific tests can be recovered using the {@code boolean} 
 * methods provided by the class. 
 * </p.
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
    
    /**
     * Creates an instance of {@code IdentifierName}.
     * @param tokenisedName
     * @param typeName
     * @param species
     * @param modifiers
     * @param argumentCount
     * @param superTypes
     * @param isArrayDeclaration
     * @param isLoopControlVariable 
     */
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
    
    /**
     * Retrieves the text of the name as found in the source code.
     * @return the original name
     */
    public final String nameString() {
        return this.tokenisedName.nameString();
    }
    
    /**
     * Recovers the list of component words or tokens recovered from the name. 
     * The tokens are normalised to lower case.
     * @return a {@code List} of tokens 
     */
    public List<String> componentWords() {
        return this.tokenisedName.normalisedTokensAsText();
    }
    
    /**
     * Retrieves the list of tagged tokens. 
     * @return A {@code List} of {@code TaggedToken} objects.
     */
    public List<TaggedToken> taggedTokens() {
        return this.tokenisedName.taggedTokens();
    }
    
    /**
     * The summary of the phrasal structure of the name in Penn Treebank 
     * chunk notation. For example, a noun phrase is NP.
     * @return a phrase summary of  the name
     */
    public String phraseSummary() {
        return this.tokenisedName.phraseSummary();
    }
    
    /**
     * Retrieves the first token of the name. NB this is the first alphanumeric 
     * token. 
     * @return The first alphanumeric token or {@code null} if there
     * are no aplhanumeric tokens, e.g. {@code _} is a legal identifier name in 
     * Java
     */
    public Token firstToken() {
        if ( this.tokenisedName.taggedTokens().isEmpty() ) {
            return null;
        }
        else {
            return this.tokenisedName.taggedTokens().get( 0 );
        }
    }
    
    /**
     * Retrieves the last, or rightmost token of the name. NB for single token 
     * names the first and last tokens are identical.
     * 
     * @return the last alphnumeric token of the name, or {@code null} if there
     * are no alphanumeric tokens.
     */
    public Token lastToken() {
        if ( this.tokenisedName.taggedTokens().isEmpty() ) {
            return null;
        }
        else {
            return this.tokenisedName.taggedTokens()
                    .get( this.tokenisedName.taggedTokens().size() - 1 );
        }
    }
    
    /**
     * Recovers the PoS tags as a list.
     * @return a list of the PoS tags
     */
    public List<String> posTags() {
        return this.tokenisedName.posTags();
    }
    
    
    /**
     * Retrieves a list of the tokens where the original capitalisation is 
     * retained.
     * @return a {@code List} of {@code Token}s capitalised in the
     * identifier name.
     */
    public List<TaggedToken> unnormalisedTokens() {
        return this.tokenisedName.taggedTokens();
    }
    
    /**
     * Recovers a unique identifier for the parent program entity.
     * @return an empty string - functionality not implemented
     */
    public String containerUid() {
        return this.containerUid;
    }
    
    /**
     * Recovers a unique identifier for the named program entity. 
     * @return an empty string -- functionality not implemented
     */
    public String entityUid() {
        return this.entityUid;
    }
    
    /**
     * The type the name is declared with. 
     * 
     * @return a type name string
     */
    public final String type() {
        return this.typeName.identifierName();
    }
    
    /**
     * The species of the identifier name. 
     * @return 
     */
    public Species species() {
        return this.species;
    }
    
    /**
     * A list of the modifiers used in the declaration. NB the list may be empty.
     * @return a {@code List} pf modifiers.
     */
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
     * @return the number of arguments to the method, or -1 if the name is not  
     * that of a  method or constructor.
     */
    public int argumentCount() {
        return this.argumentCount;
    }
    
    /**
     * Add information. Used to add implementations of  
     * {@code IdentifierInformation} to annotate the object.
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
    public List<IdentifierInformation> 
        getInformationList( InformationClassification informationClass ) {
        List<IdentifierInformation> classifiedInformationList = new ArrayList<>();
        
        this.informationList.stream().filter( 
                (information) -> 
                        ( information.classification() == informationClass ) )
                .forEach( (information) -> { 
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
            List<IdentifierInformation> list = 
                    this.getInformationList(InformationClassification.CIPHER );
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

    /**
     * Indicates if the declaration is an array.
     * @return {@code true} if declared as an array.
     */
    public boolean isArrayDeclaration() {
        return this.isArrayDeclaration;
    }
    
    /**
     * Indicates if the name is used as a loop control variable.
     * @return {@code true} for any name declared on the LHS of a for loop.
     */
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
            List<IdentifierInformation> list = 
                    this.getInformationList(InformationClassification.CIPHER );
            if ( ! list.isEmpty() ) {
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
    
    /**
     * Indicates the typographical correctness of the name other than the 
     * first character.
     * @return {@code true} iff the name excluding the first character is correct
     */
    public boolean isBodyTypographyCorrect() {
        List<IdentifierInformation> list = 
                this.getInformationList(InformationClassification.CAPITALISATION_INTERNAL_SUMMARY );
        
        if ( list.isEmpty() ) {
            LOGGER.error( "No body capitalisation information present" );
            throw new IllegalStateException( "Missing body capitalisation information" );
        }
        BodyCapitalisationSummaryInformation information = 
                (BodyCapitalisationSummaryInformation) list.get( 0 ); 
        
        return information.isCorrect();
    }
    
    /**
     * Indicates the correctness of the first character of the name.
     * @return {@code true} if the first character of the name meets the 
     * given typographical convention.
     */
    public boolean isFirstCharTypographyCorrect() {
        List<IdentifierInformation> list = 
                this.getInformationList(InformationClassification.CAPITALISATION_LEADING );
        
        if ( list.isEmpty() ) {
            LOGGER.error( "First character capitalisation information present" );
            throw new IllegalStateException( "Missing first character capitalisation information" );
        }
        FirstCharacterCapitalisationInformation information = 
                (FirstCharacterCapitalisationInformation) list.get( 0 ); 
        
        return information.isCorrect();
    }
    
    /**
     * Indicates if the name is a type acronym.
     * @return {@code true} iff the name is a full type acronym.
     */
    public boolean isTypeAcronym() {
        List<IdentifierInformation> list = 
                this.getInformationList(InformationClassification.TYPE_ACRONYM );
        if ( list.isEmpty() ) {
            LOGGER.error( "No type acronym information present" );
            throw new IllegalStateException( "Missing type acronym information" );
        }
        
        TypeAcronymInformation information = (TypeAcronymInformation) list.get( 0 );
        
        return information.isTyepAcronym();
    }
    
    /**
     * Indicates if the name is a type acronym and its use is permitted. 
     * @return {@code true} iff the name is a single token and that token is a 
     * full type acronym and the conventions permit the use of type acronyms.
     */
    public boolean isTypeAcronymCorrect() {
        List<IdentifierInformation> list = 
                this.getInformationList(InformationClassification.TYPE_ACRONYM );
        if ( list.isEmpty() ) {
            LOGGER.error( "No type acronym information present" );
            throw new IllegalStateException( "Missing type acronym information" );
        }
        
        TypeAcronymInformation information = (TypeAcronymInformation) list.get( 0 );
        
        return information.isCorrect();
    }
    
    /**
     * Indicates if a leading underscore is present.
     * @return {@code true} if there is one or more leading underscores
     */
    public boolean hasLeadingUnderscore() {
        List<IdentifierInformation> list = 
                this.getInformationList(InformationClassification.UNDERSCORE_LEADING );
        if ( list.isEmpty() ) {
            LOGGER.error( "No leading underscore information present" );
            throw new IllegalStateException( "missing leading underscore information" );
        }
        IdentifierInformation information = list.get( 0 );
        
        return information.isCorrect();
    }
    
    /**
     * Indicates the presence of one or more trailing underscore(s).
     * @return {@code true} if there is one or more trailing underscore(s)
     */
    public boolean hasTrailingUnderscore() {
        List<IdentifierInformation> list = 
                this.getInformationList(InformationClassification.UNDERSCORE_TRAILING );
        if ( list.isEmpty() ) {
            LOGGER.error( "No trailing underscore information present" );
            throw new IllegalStateException( "missing trailing underscore information" );
        }
        IdentifierInformation information = list.get( 0 );
        
        return information.isCorrect();
    }
    
    /**
     * Indicates if separator characters have been used according to convention.
     * In practice this means single separators between each token identified by 
     * intt where the convention permits, or none at all.
     * @return {@code true} iff separator characters are used according to the
     * rule definition.
     */
    public boolean isSeparatorUseCorrect() {
        List<IdentifierInformation> list = 
                this.getInformationList(InformationClassification.SEPARATOR );
        if ( list.isEmpty() ) {
            LOGGER.error( "No separator information present" );
            throw new IllegalStateException( "missing separator information" );
        }
        IdentifierInformation information = list.get( 0 );
        
        return information.isCorrect();
    }
    
    /**
     * Indicates if a specified prefix has been used according to the defined 
     * convention.
     * @return {@code true} if prefix used as expected 
     */
    public boolean isPrefixUseCorrect() {
        Token firstToken = this.firstToken();
        
        if ( firstToken == null ) {
            LOGGER.warn(  "No first token for identifier name \"{}\"", this.nameString() );
            return false;
        }
        else {
            List<TokenInformation> list = 
                    this.firstToken().getInformationList(InformationClassification.PREFIX );
            if ( list.isEmpty() ) {
                LOGGER.error( "No prefix information present" );
                throw new IllegalStateException( "missing prefix information" );
            }
            TokenInformation information = list.get( 0 );

            return information.isCorrect();
        }
    }
    
    /**
     * Indicates if the phrasal summary of the name matches one of those
     * on the list of expected phrase(s).
     * @return {@code true} if the phrase is expected.
     */
    public boolean isPhraseCorrect() {
        List<IdentifierInformation> list = 
                this.getInformationList(InformationClassification.PHRASE );
        if ( list.isEmpty() ) {
            LOGGER.error( "No phrase information present" );
            throw new IllegalStateException( "missing phrase information" );
        }
        
        boolean isPhraseCorrect = false;

        // iterate over the phrases
        for ( IdentifierInformation information :  list ) {
            if ( information.isCorrect() ) {
                isPhraseCorrect = true;
            }
        }
        
        return isPhraseCorrect;
    }
    

    // candidate for deletion?
    // 
    /**
     * Recovers the phrase assigned to the name.
     * @return the phrase assigned to the name. 
     */
    public String phraseFound() {
        // look for the correct phrase and return that
        List<IdentifierInformation> list = 
                this.getInformationList(InformationClassification.PHRASE );
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
        List<IdentifierInformation> list = 
                this.getInformationList(InformationClassification.SPELLING_SUMMARY );
        if ( list.isEmpty() ) {
            LOGGER.error( "No spelling summary information present" );
            throw new IllegalStateException( "missing spelling summary information" );
        }
        
        SpellingSummaryInformation information = 
                (SpellingSummaryInformation) list.get( 0 );
        
        return information.isCorrect();
    }
    
    /**
     * Indicates whether one of known redundant prefixes is used.
     * @return {@code true} if a know redundant prefix is used.
     */
    public boolean isStandardPrefixPresent() {
        List<IdentifierInformation> list = 
                this.getInformationList(InformationClassification.STANDARD_PREFIX );
        if ( list.isEmpty() ) {
            return false;
        }
        
        StandardPrefixInformation information = 
                (StandardPrefixInformation) list.get( 0 );
        
        return information.hasPrefix();
    }
    
    /**
     * Indicates if known redundant prefix has been used correctly.
     * @return {@code true} iff the name has a redundant prefix and 
     * the prefix is used correctly
     */
    public boolean isStandardPrefixUseCorrect() {
        List<IdentifierInformation> list = 
                this.getInformationList(InformationClassification.STANDARD_PREFIX );
        if ( list.isEmpty() ) {
            return false;
        }
        
        StandardPrefixInformation information = (StandardPrefixInformation) list.get( 0 );
        
        return information.isCorrect();
    }
    
    /**
     * Indicates if the name is a known abbreviation used as a single token.
     * @return {@code true} iff a single token name and that name is a 
     * known abbreviation.
     */
    public boolean isStandaloneAbbreviation() {
        List<IdentifierInformation> list = 
                this.getInformationList( InformationClassification.STANDALONE_ABBREVIATION );
        if ( list.isEmpty() ) {
            return false;
        }
        
        StandaloneAbbreviationInformation information = 
                (StandaloneAbbreviationInformation) list.get( 0 );
        
        return information.isPresent();
    }
    
    /**
     * Indicates if the name is a known abbreviation used as a single token and 
     * the current convention permits this.
     * @return {@code true} iff a single token name and that name is a 
     * known abbreviation and the convention permits the use of standalone
     * abbreviations.
     */
    public boolean isStandaloneAbbreviationCorrect() {
        List<IdentifierInformation> list = 
                this.getInformationList( InformationClassification.STANDALONE_ABBREVIATION );
        if ( list.isEmpty() ) {
            return false;
        }
        
        StandaloneAbbreviationInformation information = 
                (StandaloneAbbreviationInformation) list.get( 0 );
        
        return information.isCorrect();
    }
    
    // try to find a good home for this and other similar utility methods
    // if they could be more widely used.
    private String simplifyTypeName( String typeName ) {
        // strip everything to the left of the rightmost dot, including the dot
        int lastDotIndex = typeName.lastIndexOf( "." );
        String s = lastDotIndex == -1 ? typeName : typeName.substring( lastDotIndex + 1 );
        
        // strip everything to the right of the first left angle bracket, including the bracket. 
        int lAngleIndex = s.indexOf( "<" );
        return lAngleIndex == -1 ? s : s.substring( 0, lAngleIndex );
    }

}
