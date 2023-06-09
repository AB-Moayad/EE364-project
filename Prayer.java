
public class Prayer extends Visitor {
    
    //Constructor takes pathway
    Prayer(Pathway pathway) {
        super(pathway);
        
    }


    
    @Override
    public String returnStatus() {
        return String.format("Prayer#%d in %s", getId(), getCurrentLocation().toString());
    }

    public void updateStatus() {
        if (getCurrentLocation() instanceof Pathway || getCurrentLocation() instanceof Building) {
            setStatus(VisitorStatus.commuting);
        }
        else if (getCurrentLocation() instanceof PrayLocation) {
            setStatus(VisitorStatus.praying);
        }
        
        if (completedPurpose) {
            setStatus(VisitorStatus.exiting);
        }
    }
}
