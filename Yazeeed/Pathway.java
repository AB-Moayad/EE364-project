import java.util.ArrayList;
/**
 * the class pathway represnt the pathways in the haram 
 * pathway implemnts commutable interface 
 */
public class Pathway implements Commutable {
    //Instances
    private String name;
    private int length;
    private int capacity;
    private int numberOfCurrentVisitors;
    private ArrayList<Commutable> intersections = new ArrayList<>();
    private ArrayList<Organizer> organizers = new ArrayList<>();
    
    /**
     * Constructor takes name of the pathway and max capacity 
     * @param name pathway name
     * @param capacity maximum capacity
     */
    public Pathway(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;

    }

    /**
     * the method called when visitor will enter an area
     *  to check if the current location has space if true -> there is a space
     *  the current capacity will increment 
     */
    public void incrementCurrentVisitors() {
        if ((numberOfCurrentVisitors + 1) <= capacity) {
            this.numberOfCurrentVisitors++;
        }
    }
    
    /**
     * the method called when visitor will leave an area
     *  to check if the current location is not empty ( to avoid minus capacity )
     * if true -> the current capacity will decremnt 
     */
    public void decrementCurrentVisitors() {
        if ((numberOfCurrentVisitors - 1) >= 0) {
            this.numberOfCurrentVisitors--;
        }
    }


    /**
     * To get duration time spent in pathway 
     * 50 is the estimated number of the duration 
     * @param length the length of the pathway 
     * @return length which is the length of the pathway 
     */
    @Override
    public int getDuration() {
        length = 50;
        return length;
    }

    /**
     * to get pathway capacity 
     * @return pathway capacity
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
     * Set the capacity of the pathway
     * @param capacity the capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

     /**
     * To check if the pathway has space 
     * @return if the target has space return true , if not return false 
     */
    public boolean hasSpace() {
        return (numberOfCurrentVisitors < capacity);
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

    /**
     * To get the organizer who's responsible for the pathway
     * @return organizer id
     */
    public ArrayList<Organizer> getOrganizers() {
        return organizers;
    }

    /**
     * To set the organizer who's responsible for the pathway
     * @param organizers organizer id
     */
    public void setOrganizers(ArrayList<Organizer> organizers) {
        this.organizers = organizers;
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
    public void setNumberOfCurrentVisitors(int currentVisitors) {
        this.numberOfCurrentVisitors = currentVisitors;
    }

     /**  
      * Exception for not setting duration
      */
    public int setDuration() {
        throw new UnsupportedOperationException("Unimplemented method 'setDuration'");
    }

    /**
     * To print pathway name 
     * @return pathway name 
     */
    public String toString() {
        return this.name;
    }

    /**
     * To print pathway name 
     * @return pathway name 
     */
    @Override
    public String getName() {
        return name;
    }
}