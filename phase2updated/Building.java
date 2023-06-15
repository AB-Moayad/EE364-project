import java.util.ArrayList;

public class Building extends HaramTarget {

    //Constructor
    public Building(String name, int capacity) {
        this.setTargetName(name);
        this.setCapacity(capacity);
    }

    @Override
    public int getDuration() {
        return 50;
    }


    public void setDuration(ArrayList<Commutable> intersections) {
        setIntersections(intersections);
    }



    @Override
    public int setDuration() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDuration'");
    }

    
    
}
