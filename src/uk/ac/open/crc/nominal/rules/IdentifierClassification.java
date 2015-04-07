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

import java.util.HashMap;
import java.util.List;
import uk.ac.open.crc.idtk.Modifier;
import uk.ac.open.crc.idtk.Species;
import uk.ac.open.crc.nominal.IdentifierName;
import uk.ac.open.crc.nominal.util.GuiActionReference;

/**
 * A set of classifiers for identifier names. The classifiers reflect 
 * groups of identifier names that may have specific typographical and 
 * linguistic rules.
 * <p>NB: this is not an exhaustive or complete list. The intention is that 
 * the classifications are <strong>useful</strong> and will be expanded as necessary.</p>
 * @author Simon Butler <simon@facetus.org.uk>
 * @version $Id: IdentifierClassification.java 56 2015-04-02 18:43:02Z simon $
 */
public enum IdentifierClassification {
    
    // Class and interface
    CLASS ( "class" ),
    INTERFACE ( "interface" ), 
    INTERFACE_MIX_IN ( "interface-mix-in" ),
    CLASS_GUI_ACTION ( "class-gui-action" ),
    CLASS_STATIC_SERVICES ( "class-static-services" ),
    CONSTRUCTOR ( "constructor" ),  // note that this is never tested
    
    // Enumerations and annotations -- not used ATM, but in for completeness and expansion
    ANNOTATION ( "annotation" ),
    ANNOTATION_MEMBER ( "annotation-member" ),
    ENUMERATION ( "enumeration" ),
    ENUMERATION_CONSTANT ( "enumeration-constant" ), 
    
    // Generic method
    METHOD ( "method" ),
    // Methods -- return type and argument count
    METHOD_BOOLEAN_ARGS  ( "method-boolean-args" ),
    METHOD_BOOLEAN_NOARGS ( "method-boolean-noargs" ),
    METHOD_NON_BOOLEAN_ARGS ( "method-nonboolean-args" ),
    METHOD_NON_BOOLEAN_NOARGS ( "method-nonboolean-noargs" ),
    METHOD_VOID_ARGS ( "method-void-args" ),
    METHOD_VOID_NOARGS ( "method-void-noargs" ),
    
    // Fields
    // generic
    FIELD ( "field" ),
    FIELD_CONSTANT ( "field-constant" ),
    FIELD_VARIABLE ( "field-variable" ),
    // specific
    FIELD_CONSTANT_BOOLEAN ( "field-constant-boolean" ),  
//    @Deprecated  // no significant evidence found during survey to show a difference between numeric and other references.
//    FIELD_CONSTANT_NUMERIC ( "field-constant-numeric" ),  
    FIELD_CONSTANT_COLLECTION_REFERENCE ( "field-constant-collection-reference" ),
    FIELD_CONSTANT_OTHER ( "field-constant-other" ),
    FIELD_CONSTANT_STRING ( "field-constant-string" ),
    FIELD_CONSTANT_STRING_I18N ( "field-constant-string-i18n" ),  // not yet used -- need to develop mechanism for classifying identifier names
    // consider revision so that there is a final-static-mutable 
    // and final-static-immutable division
    // difficult to see how that might work and be understood.
    
    FIELD_VARIABLE_ACTION ( "field-variable-action" ),
    FIELD_VARIABLE_BOOLEAN ( "field-variable-boolean" ),
    FIELD_VARIABLE_COLLECTION_REFERENCE ( "field-variable-collection-reference" ),
    FIELD_VARIABLE_OTHER ( "field-variable-other" ),
    
    // Formal arguments
    FORMAL_ARGUMENT ( "formal-argument" ),
    FORMAL_ACTION ( "formal-argument-action" ),
    FORMAL_BOOLEAN ( "formal-argument-boolean" ),
    FORMAL_COLLECTION_REFERENCE ( "formal-argument-collection-reference" ),
    FORMAL_OTHER ( "formal-argument-other" ),
    
    // Local variable
    LOCAL_VARIABLE ( "local-variable" ),
    LOCAL_ACTION ( "local-variable-action" ),
    LOCAL_BOOLEAN  ( "local-variable-boolean" ),
    LOCAL_COLLECTION_REFERENCE ( "local-variable-collection-reference" ), // i.e. should be plural
    LOCAL_LOOP_CONTROL ( "local-variable-loop-control" ), 
    LOCAL_OTHER ( "local-variable-other" ),
    
    LABEL ( "label" );  // never used

    // --------------------
    // set up the hierarchy
    private static final HashMap<IdentifierClassification,IdentifierClassification> hierarchy;
    
    static {
        hierarchy = new HashMap<>();
        hierarchy.put( CLASS_GUI_ACTION, CLASS );
        hierarchy.put( INTERFACE, CLASS );
        hierarchy.put( INTERFACE_MIX_IN, CLASS );
        hierarchy.put( CLASS_STATIC_SERVICES, CLASS );
        hierarchy.put( CONSTRUCTOR, CLASS );
        // --
        hierarchy.put( METHOD_BOOLEAN_ARGS, METHOD );
        hierarchy.put( METHOD_BOOLEAN_NOARGS, METHOD );
        hierarchy.put( METHOD_NON_BOOLEAN_ARGS, METHOD );
        hierarchy.put( METHOD_NON_BOOLEAN_NOARGS, METHOD );
        hierarchy.put( METHOD_VOID_ARGS, METHOD );
        hierarchy.put( METHOD_VOID_NOARGS, METHOD );
        // --
        hierarchy.put( FIELD_CONSTANT_BOOLEAN, FIELD_CONSTANT  );
        hierarchy.put( FIELD_CONSTANT_COLLECTION_REFERENCE, FIELD_CONSTANT  );
        hierarchy.put( FIELD_CONSTANT_OTHER, FIELD_CONSTANT  );
        hierarchy.put( FIELD_CONSTANT_STRING, FIELD_CONSTANT  );
        // --
        hierarchy.put( FIELD_CONSTANT_STRING_I18N, FIELD_CONSTANT_STRING );
        // --
        hierarchy.put( FIELD_VARIABLE_ACTION, FIELD_VARIABLE);
        hierarchy.put( FIELD_VARIABLE_BOOLEAN, FIELD_VARIABLE);
        hierarchy.put( FIELD_VARIABLE_COLLECTION_REFERENCE, FIELD_VARIABLE);
        hierarchy.put( FIELD_VARIABLE_OTHER, FIELD_VARIABLE);
        // -- 
        hierarchy.put( FIELD_CONSTANT, FIELD );
        hierarchy.put( FIELD_VARIABLE, FIELD );
        // --
        hierarchy.put( FORMAL_ACTION, FORMAL_ARGUMENT );
        hierarchy.put( FORMAL_BOOLEAN, FORMAL_ARGUMENT );
        hierarchy.put( FORMAL_COLLECTION_REFERENCE, FORMAL_ARGUMENT );
        hierarchy.put( FORMAL_OTHER, FORMAL_ARGUMENT );
        // --
        hierarchy.put( LOCAL_ACTION, LOCAL_VARIABLE );
        hierarchy.put( LOCAL_BOOLEAN, LOCAL_VARIABLE );
        hierarchy.put( LOCAL_COLLECTION_REFERENCE, LOCAL_VARIABLE );
        hierarchy.put( LOCAL_OTHER, LOCAL_VARIABLE );
        hierarchy.put( LOCAL_LOOP_CONTROL, LOCAL_VARIABLE );
    }
    
    // --------------------
    private final String description;
    
    private IdentifierClassification( String description ) {
        this.description = description;
    }
    
    private boolean hasDescription( String description ) {
        return this.description.equals( description );
    }
   
    public String description() {
        return this.description;
    }
    /**
     * Returns an {@code IdentifierClassification} for a given textual description. 
     * The textual description corresponds to the classification identifiers used
     * in the rule files.
     * @param description a known textual label for an identifier classification. 
     * Method throws {@code IllegalArgumentException} if textual description is 
     * unrecognised.
     * @return 
     */
    public static IdentifierClassification getClassificationFor( String description ) {
        if ( description == null || description.isEmpty() ) {
            throw new IllegalArgumentException( 
                    "null reference or empty String passed to getClassificationFor()" );
        }
        
        // O(n) -- surely there is an easier solution?
        for ( IdentifierClassification classification : IdentifierClassification.values() ) {
            if ( classification.hasDescription( description ) ) {
                return classification;
            }
        }
        
        throw new IllegalArgumentException( 
                "No classification found with name: \"" + description + "\"" );
    }
    
    /**
     * Classifies an instance of {@code IdentifierName}, the classification is 
     * added to the identifier name and returned as a convenience.
     * 
     * @param identifierName
     * @return 
     */
    public static IdentifierClassification getClassificationFor( IdentifierName identifierName ) {
        Species species = identifierName.species();
        
        if ( species.isClassOrInterface() ) {
            return classifyClassOrInterface( identifierName );
        }
        else if ( species.isConstructor() ) {
            return classifyConstructor( identifierName );
        }
        else if ( species.isMethod() ) { 
            return classifyMethod( identifierName );
        }
        else if ( species.isReference() ) {
            return classifyReference( identifierName );
        }
        else {
            return classifyRemainder( identifierName );
        }
    }
    
    
    /**
     * Recovers the parent classification. If there is no parent, the 
     * the classification is returned.
     * @return an instance of {@code IdentifierClassification}
     */
    public IdentifierClassification parent() {
        IdentifierClassification parent = hierarchy.get( this );
        if ( parent == null ) {
            return this;
        }
        
        return parent;
    }
    
    
    private static IdentifierClassification classifyMethod( IdentifierName identifierName ) {
        boolean hasArguments = identifierName.argumentCount() > 0;
        boolean isVoid = isVoid( identifierName );
        boolean isBoolean = isBoolean( identifierName );
        // boolean, non-boolean & void vs # of arguments
        IdentifierClassification classification;
        
        if (isVoid ) {
            classification = hasArguments ? METHOD_VOID_ARGS : METHOD_VOID_NOARGS;
        }
        else if ( isBoolean ) {
            classification = hasArguments ? METHOD_BOOLEAN_ARGS : METHOD_BOOLEAN_NOARGS;
        }
        else {
            classification = hasArguments ? METHOD_NON_BOOLEAN_ARGS : METHOD_NON_BOOLEAN_NOARGS;
        }
        
        return classification;
    }
    
    private static IdentifierClassification classifyClassOrInterface( IdentifierName identifierName ) {
        IdentifierClassification classification;
        
        if ( identifierName.species().isClass() ) {
            if ( isGuiAction( identifierName ) ) {
                classification = CLASS_GUI_ACTION;
            }
            else {
                classification = CLASS;
            }
        }
        else {
            if ( isMixInInterface( identifierName ) ) {
                classification = INTERFACE_MIX_IN;
            }
            else {
                classification = INTERFACE;
            }
        }
        
        return classification;
    }
    
    
    // boolean|collection|other & species
    // treat fields separately
    // candidate for refactoring
    private static IdentifierClassification classifyReference( IdentifierName identifierName ) {
        if ( identifierName.species() == Species.FIELD ) {
            return classifyField( identifierName );
        }
            
        IdentifierClassification classification;
        // is boolean
        if ( isBoolean( identifierName ) ) {
            if ( identifierName.species() == Species.FORMAL_ARGUMENT ) {
                classification = FORMAL_BOOLEAN;
            }
            else {
                classification = LOCAL_BOOLEAN;
            }
        }
        else if ( isCollection( identifierName ) ) {
            if ( identifierName.species() == Species.FORMAL_ARGUMENT ) {
                classification = FORMAL_COLLECTION_REFERENCE;
            }
            else {
                classification = LOCAL_COLLECTION_REFERENCE;
            }
        }
        else {
            if ( identifierName.species() == Species.FORMAL_ARGUMENT ) {
                classification = FORMAL_OTHER;
            }
            else {
                classification = LOCAL_OTHER;
            }

        }
        
        return classification;
    }
    
    private static IdentifierClassification classifyField( IdentifierName identifierName ) {
        boolean isBoolean = isBoolean( identifierName );
        boolean isCollection = isCollection( identifierName );
        boolean isString = isString( identifierName );
        
        IdentifierClassification classification;
        List<Modifier> modifiers = identifierName.modifiers();
        
        if ( modifiers.contains(Modifier.FINAL ) 
                && modifiers.contains(Modifier.STATIC )  ) {
            if ( isString ) {
                classification = FIELD_CONSTANT_STRING;
            }
            else if ( isBoolean ) {
                classification = FIELD_CONSTANT_BOOLEAN;
            }
            else if ( isCollection ) {
                classification = FIELD_CONSTANT_COLLECTION_REFERENCE;
            }
            else {
                classification = FIELD_CONSTANT_OTHER;
            }
        }
        else {
            if ( isBoolean ) {
                classification = FIELD_VARIABLE_BOOLEAN;
            }
            else if ( isCollection ) {
                classification = FIELD_VARIABLE_COLLECTION_REFERENCE;
            }
            else {
                classification = FIELD_VARIABLE_OTHER;
            }
        }
        
        return classification;
    }

    
    private static IdentifierClassification classifyRemainder( IdentifierName identifierName ) {
        IdentifierClassification classification;
        
        switch ( identifierName.species() ) {
            // annotation
            case ANNOTATION:
                classification = ANNOTATION;
                break;
            case ANNOTATION_MEMBER:
                classification = ANNOTATION_MEMBER;
                break;
            case ENUMERATION:
                classification = ENUMERATION;
                break;
            case ENUMERATION_CONSTANT:
                classification = ENUMERATION_CONSTANT;
                break;
            case LABEL: 
                classification = LABEL;
                break;
            default:
                throw new IllegalStateException( 
                        "Unexpected species of identifier name found "
                                + "in classifyRemainder" );
        }
        
        return classification;
    }
    
    // created for consistent representation of abstraction
    // and, who knows, we may wish to create a finer-grained 
    // classification of constructors one day.
    private static IdentifierClassification classifyConstructor( IdentifierName identifierName ) {
        return CONSTRUCTOR;
    }
    
    private static boolean isBoolean( IdentifierName identifierName ) {
        return isBoolean( identifierName.type() );
    }
    
    // is this a realistic test? Review
    private static boolean isBoolean( String typeName ) {
        return typeName.equalsIgnoreCase( 
                "boolean" ) 
                || typeName.matches( "(?i).*boolean$" );
    }
    
    
    // crude!! -- waiting for javaref
    public static boolean isCollection( IdentifierName identifierName ) {
        return identifierName.isArrayDeclaration() 
                || identifierName.isCollectionReference();
        // needs the javaref
    }
    
    // crude!! -- waiting for javaref
    private static boolean isMixInInterface( IdentifierName identifierName ) {
        return identifierName.species().isInterface() 
                && identifierName.nameString().endsWith( "able" );

        // needs javaref
//        throw new UnsupportedOperationException();
    }
    
    private static boolean isString( IdentifierName identifierName ) {
        return "String".equals(  identifierName.type() ) 
                || "java.lang.String".equals( identifierName.type() );
    }
    
    private static boolean isVoid( IdentifierName identifierName ) {
        return isVoid( identifierName.type() );
    }
    
    private static boolean isVoid( String returnType ) {
        return "void".equals( returnType );
    }
    
    // crude !! -- waiting for javaref
    private static boolean isGuiAction( IdentifierName identifierName ) {
        String nameString = identifierName.nameString();
        String typeName = identifierName.type();
                
        return ( GuiActionReference.isAction( typeName )
                || nameString.endsWith( "Action" ) 
                || nameString.endsWith( "Event" )
                || nameString.endsWith( "Listener" ) 
                || typeName.endsWith( "Action")  
                || typeName.endsWith( "Event")  
                || typeName.endsWith( "Listener") );
//        throw new UnsupportedOperationException();
        // needs javaref
    }
}
