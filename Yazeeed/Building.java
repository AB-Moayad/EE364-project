import java.util.ArrayList;
/**
 * The class Bulding represnt the haram's buildings 
 * 
 * child clas of HaramTarget
 */
public class Building extends HaramTarget {

    /**
     * Constructor takes targetname and max capacity
     * 
     * @param name bulding name
     * @param capacity the maxmium capacity
     *
     */
    public Building(String name, int capacity) {
        this.setTargetName(name);
        this.setCapacity(capacity);
    }
    
    /**
     *  Set duration time spent in the bulding
     * 50 is the estimated number of the duration 
     * @return the duration 
     */
    @Override
    public int getDuration() {
        return 50;
    }

    /**
     * Set duration time spent in the bulding
     * @param intersections Set duration 
     */
    public void setDuration(ArrayList<Commutable> intersections) {
        setIntersections(intersections);
    }


     /**  
      * Exception for not setting duration
      */
    @Override
    public int setDuration() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDuration'");
    }

    
    
}
