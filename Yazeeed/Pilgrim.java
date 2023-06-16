/**
 * the class pilgrim represent the visitros who came to al-haram,
 * to do omraa duty
 * 
 * child class of vistor 
 */
public class Pilgrim extends Visitor {

    /**
     * Constructor takes pathway 
     * @param pathway pathway number 
     */ 
    Pilgrim(Pathway pathway) {
        super(pathway);
    }

    /**
     * to perform Sai duty 
     * @return True ->  performing
     */
    public boolean performSai() {
        return true;
    }
    
    /**
     * to perform Tawaf duty 
     * @return True ->  performing
     */
    public boolean performTawaf() {
        return true;
    }

    /**
     * 
     * @param vacantTawafLane
     */
    public void pray(Commutable vacantTawafLane) {
        assignRoute(vacantTawafLane);
    }

    /**
     * to display the status of the pligrim
     * @return print the status of the Pligrim 
     */
    @Override
    public String returnStatus() {
        return String.format("\t--- Pilgrim #%d ---\nCurrent Location: %s", getId(), getCurrentLocation().toString());
    }

    /**
     * To make Pligrim do the duty depends on his location
     * 
     * if Pligrim in Building or pathway -> Pligrim is Commuting
     * if Pligrim in PrayLocation        -> Pligrim is Praying
     * if Pligrim in Masaa               -> Pligrim is Perfoming saii
     * if Pligrim in Sahan               -> Pligrim is Perfoming tawaf
     * if else                           -> Pligrim is leaving haram
     */
    public void updateStatus() {
        if (getCurrentLocation() instanceof Pathway || getCurrentLocation() instanceof Building) {
            setStatus(VisitorStatus.commuting);
        }
        else if (getCurrentLocation() instanceof PrayLocation) {
            setStatus(VisitorStatus.praying);
        }
        else if (getCurrentLocation() instanceof Masaa) {
            setStatus(VisitorStatus.saii);
        }
        else if (getCurrentLocation() instanceof Sahan) {
            setStatus(VisitorStatus.tawaf);
        }
        
        if (hasCompletedPurpose()) {
            setStatus(VisitorStatus.exiting);
        }
    }
}
