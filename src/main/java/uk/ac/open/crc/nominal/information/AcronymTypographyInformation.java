package uk.ac.open.crc.nominal.information;

/**
 * Information object annotating an acronym token to 
 * indicate the correctness of the typography.
 */
public class AcronymTypographyInformation extends TokenInformation {
    private final boolean isCorrect;
    
    /** 
     * Creates an information object.
     * @param isCorrect indicates correctness of acronym typography
     */
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
