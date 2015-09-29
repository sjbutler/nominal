package uk.ac.open.crc.nominal.information;

/**
 * Information object annotating an acronym token to 
 * indicate the correctness of the typography.
 *
 *
 * @author Simon Butler (simon@facetus.org.uk)
 */
public class AcronymTypographyInformation extends TokenInformation {
    private final boolean isCorrect;
    
    public AcronymTypographyInformation( final boolean isCorrect ) {
        super( InformationClassification.ACRONYM_TYPOGRAPHY );
        this.isCorrect = isCorrect;
    }
    
    /**
     * Indicates if the typography of an acronym is correct.
     * 
     * @return {@code true} if the typography conforms to the 
     * given definition.
     */
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
    
}
