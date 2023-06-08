import java.util.ArrayList;

public class Building extends HaramTarget {

    public Building(String name, int capacity) {
        this.setTargetName(name);
        this.setCapacity(capacity);
    }

    @Override
    public int getDuration() {
        return 50;
    }


    public ArrayList<Commutable> getIntersections() {
        return intersections;
    }

    public void setDuration(ArrayList<Commutable> intersections) {
        setIntersections(intersections);
    }



    @Override
    public void setIntersections(ArrayList<Commutable> intersections) {
        this.intersections = intersections;
    }


    @Override
    public int setDuration() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDuration'");
    }

    
    
}
