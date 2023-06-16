import java.util.ArrayList;
/**
 * the class HaramTarget represent the visitors target 
 * Haram target is the super class of (sahan , pray location , building )
 */
public abstract class HaramTarget implements Commutable {
    //Instances  
    private String TargetName;
    private int capacity;
    private int numberOfCurrentVisitors;
    private ArrayList<Commutable> intersections = new ArrayList<>();       
    
    /** 
     * HaramTarget deafualt constructor
     */
    public HaramTarget() {}

    /**
     * To get capacity of the target
     * @return The capacity of the target 
     */
    public int getCapacity() {
        return capacity;
    }
    
    /**
     * To get the availability of the capacity 
     * @return the remaing space
     */
    public int getAvailableCapacity() {
        return (capacity - numberOfCurrentVisitors);
    }
    
    /**
     * To get the availability raito of the capacity 
     * @return the raito of the capacity 
     */
    public double getAvailableCapacityRatio() {
        return (double) numberOfCurrentVisitors / capacity;
    }

    /**
     * Set the capacity of the target
     * @param capacity the capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    /**
     * To set traget name 
     * @param targetName target name
     */
    public void setTargetName(String targetName) {
        this.TargetName = targetName;
    }

    /**
     * To check if the target has space 
     * @return if the target has space return true , if not return false 
     */
    public boolean hasSpace() {
        return (numberOfCurrentVisitors < capacity);
    }
    
    /**
     * To get target name 
     * @return the target name
     */
    public String getName() {
        return TargetName;
    }

    /**
     * 
     */
    public void incrementCurrentVisitors() {
        if ((numberOfCurrentVisitors + 1) <= capacity) {
            this.numberOfCurrentVisitors++;
        }
    }
    
    public void decrementCurrentVisitors() {
        if ((numberOfCurrentVisitors - 1) >= 0) {
            this.numberOfCurrentVisitors--;
        }
    }
    
    /**
     * To print target name 
     * @return target name 
     */
    public String toString() {
        return this.TargetName;
    }

    /**
     * To get vistor number 
     * @return current number of vistor 
     */
    public int getNumberOfCurrentVisitors() {
        return numberOfCurrentVisitors;
    }
    
    /**
     * To set vistor number 
     * @param numberOfCurrentVisitors current number of vistor 
     */
    public void setNumberOfCurrentVisitors(int numberOfCurrentVisitors) {
        this.numberOfCurrentVisitors = numberOfCurrentVisitors;
    }
     
    /**
     * To get intersection 
     * @return intersecions
     */
    public ArrayList<Commutable> getIntersections() {
        return intersections;
    }

    /**
     * to set intersections
     * @return intersectons
     */
    public void setIntersections(ArrayList<Commutable> intersections) {
        this.intersections = intersections;
    }

    
  }