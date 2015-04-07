package uk.ac.open.crc.nominal.information;

/**
 *
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
    
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }
    
    
}
