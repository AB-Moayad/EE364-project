import java.util.ArrayList;

public class PrayLocation extends HaramTarget {

    //Constructor takes targetname and max capacity
    public PrayLocation(String targetName, int capacity) {
        setTargetName(targetName);
        setCapacity(capacity);
    }
    
    //getters & setters
    @Override
    public int getDuration() {
        return 70;
    }

    @Override
    public ArrayList<Commutable> getIntersections() {
        return intersections;
    }

    
    public void setIntersections(ArrayList<Commutable> intersections) {
        this.intersections = intersections;
    }

    @Override
    public int setDuration() {
        throw new UnsupportedOperationException("Unimplemented method 'setDuration'");
    }


    
}
