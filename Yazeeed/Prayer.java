
/**
 * the class prayer represent the visitros who came to al-haram,
 * to pray
 * 
 * child class of vistor 
 */
public class Prayer extends Visitor {
    
    /**
     * Constructor takes pathway 
     * @param pathway pathway number 
     */
    Prayer(Pathway pathway) {
        super(pathway);
        
    }

    /**
     * to display the status of the pligrim
     * @return print the status of the Pligrim 
     */
    @Override
    public String returnStatus() {
        return String.format("\t--- Prayer #%d ---\nCurrent Location: %s", getId(), getCurrentLocation().toString());
    }

    /**
     * To make Prayer do the duty depends on his location
     * 
     * if Prayer in Building or pathway -> Prayer is Commuting
     * if Prayer in PrayLocation        -> Prayer is Praying
     * if else                          -> Prayer is leaving
     */
    public void updateStatus() {
        if (getCurrentLocation() instanceof Pathway || getCurrentLocation() instanceof Building) {
            setStatus(VisitorStatus.commuting);
        }
        else if (getCurrentLocation() instanceof PrayLocation) {
            setStatus(VisitorStatus.praying);
        }
        
        if (hasCompletedPurpose()) {
            setStatus(VisitorStatus.exiting);
        }
    }
}
