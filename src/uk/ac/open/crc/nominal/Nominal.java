package uk.ac.open.crc.nominal;

import java.io.File;
import java.io.IOException;
import java.util.List;
import uk.ac.open.crc.nominal.detectors.DetectorManager;
import uk.ac.open.crc.nominal.information.Information;
import uk.ac.open.crc.nominal.rules.RulesetGroup;
import uk.ac.open.crc.nominal.rules.RulesetGroupFactory;

/**
 *
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class Nominal {
    
    /**
     * Creates an instance of {@code Nominal} using the default "AJC" conventions.
     * @return an instance of {@code Nominal}
     * @throws IOException 
     */
    public static Nominal create() throws IOException {
        return new Nominal( "ajc" );
    }
    
    /**
     * Creates an instance of {@code Nominal} using the specified conventions.
     * @param conventionsName one of 'ajc','ejs' or 'jls'
     * @return an instance of {@code Nominal}
     * @throws IOException 
     */
    public static Nominal create( String conventionsName ) throws IOException {
        return new Nominal( conventionsName );
    }
    
    /**
     * Creates an instance of {@code Nominal} from the specified file in 
     * nominal's language.
     * @param file a file containing conventions definition
     * @return an instance of {@code Nominal}
     * @throws IOException 
     */
    public static Nominal create( File file ) throws IOException {
        return new Nominal( file, false );
    }
    
    /**
     * Creates an instance of {@code Nominal} based on the default ruleset
     * and modified using the partial definitions from the specified file in 
     * nominal's language.
     * @param file a file containing partial conventions definition
     * @return an instance of {@code Nominal}
     * @throws IOException 
     */
    public static Nominal createWithDefaults( File file ) throws IOException {
        return new Nominal( file, true );
    }
    
    
    // -------------------------------
    private final DetectorManager detectorManager;
    
    private Nominal( String conventionsName ) throws IOException {
        RulesetGroup rg = 
                RulesetGroupFactory.createDefaultRulesetGroup( conventionsName );
        
        this.detectorManager = new DetectorManager( rg );
    }
    
    
    private Nominal( File conventionsDefinitionFile, boolean withDefaults ) throws IOException {
        RulesetGroup rg;
        
        if ( withDefaults ) { 
            rg = RulesetGroupFactory.createRulesetGroup( conventionsDefinitionFile );
        }
        else {
            rg = RulesetGroupFactory.createRulesetGroupWithDefaults( conventionsDefinitionFile );
        }
        
        this.detectorManager = new DetectorManager( rg );
    }
    

    /**
     * Tests the name against the conventions specified.
     * @param identifierName a name to be tested.
     * @return a reference to the name tested
     */
    public IdentifierName test( IdentifierName identifierName ) {
        return detectorManager.test( identifierName );
    }
}
