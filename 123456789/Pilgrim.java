public class Pilgrim extends Visitor {

    //Constructor takes pathway 
    Pilgrim(Pathway pathway) {
        super(pathway);
    }

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
    
    // To make Pligrim do the duty depends on his location 
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
