import java.util.ArrayList;

public class PrayLocation extends HaramTarget {

    public PrayLocation(String targetName, int capacity) {
        setTargetName(targetName);
        setCapacity(capacity);
    }

    @Override
    public int getDuration() {
        return 50;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDuration'");
    }

    @Override
    public int setCapacity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCapacity'");
    }
    
}
