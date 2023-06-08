public class Pilgrim extends Visitor {
    private int currentSaiiStage;
    private int currentTawafStage;

    private boolean completedTawaf;
    private boolean completedPrayer;
    private boolean completedSaii;
    
    Pilgrim(Pathway pathway) {
        super(pathway);
    }

     
    // public void performUmrah(Commutable vacantTawafLane, Commutable vacantPrayLocation) {
    //     if (this.status == VisitorStatus.commuting
    //     && !completedTawaf
    //     && !completedPrayer
    //     && !completedSaii) {
    //         pray(vacantTawafLane);
    //     }
    //     else if () {

    //     }
    // }
    
    public boolean performSai() {
        return true;
    }

    public boolean performTawaf() {
        return true;
    }

    public void pray(Commutable vacantTawafLane) {
        assignRoute(vacantTawafLane);
    }


    @Override
    public String returnStatus() {
        return String.format("Pilgrim#%d in %s:: %s", getId(), getCurrentLocation().toString(), getStatus().toString());
    }

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
        
        if (completedPurpose) {
            setStatus(VisitorStatus.exiting);
        }
    }
}
