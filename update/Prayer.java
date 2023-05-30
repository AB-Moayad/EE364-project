import java.util.ArrayList;

public class Prayer extends Visitor {
    
    Prayer(Pathway pathway) {
        super(pathway);
        //TODO Auto-generated constructor stub

        // ArrayList<HaramTarget> designatedPrayLocation = new ArrayList<>();
        // designatedPrayLocation.add(Haram.findVacantPrayLocation());
        // setTargets(designatedPrayLocation);
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
