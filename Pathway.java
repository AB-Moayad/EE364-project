import java.util.ArrayList;

public class Pathway implements Commutable {
    //Instances
    private String name;
    private int length;
    private int capacity;
    private int numberOfCurrentVisitors;
    private ArrayList<HaramTarget> r_locations = new ArrayList<>();
    private ArrayList<HaramTarget> l_locations = new ArrayList<>();
    private ArrayList<Commutable> intersections = new ArrayList<>();
    private ArrayList<Organizer> organizers = new ArrayList<>();
    private Direction direction;
    private int floor;
    
    //Constructor takes name of the pathway and max capacity 
    public Pathway(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;

    }

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


    //Getters & Setters
    @Override
    public int getDuration() {
        length = 50;
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableCapacity() {
        return (capacity - numberOfCurrentVisitors);
    }

    public double getAvailableCapacityRatio() {
        return (double) numberOfCurrentVisitors / capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean hasSpace() {
        return (numberOfCurrentVisitors < capacity);
    }

    public ArrayList<HaramTarget> getRLocations() {
        return r_locations;
    }

    public void setRLocations(ArrayList<HaramTarget> r_locations) {
        this.r_locations = r_locations;
    }

    public ArrayList<HaramTarget> getLLocations() {
        return l_locations;
    }

    public void setLLocations(ArrayList<HaramTarget> l_locations) {
        this.l_locations = l_locations;
    }

    public ArrayList<Commutable> getIntersections() {
        return intersections;
    }

    public void setIntersections(ArrayList<Commutable> intersections) {
        this.intersections = intersections;
    }

    public ArrayList<Organizer> getOrganizers() {
        return organizers;
    }

    public void setOrganizers(ArrayList<Organizer> organizers) {
        this.organizers = organizers;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumberOfCurrentVisitors() {
        return numberOfCurrentVisitors;
    }

    public void setNumberOfCurrentVisitors(int currentVisitors) {
        this.numberOfCurrentVisitors = currentVisitors;
    }

    public int setDuration() {
        throw new UnsupportedOperationException("Unimplemented method 'setDuration'");
    }


    public String toString() {
        return this.name;
    }

    @Override
    public String getName() {
        return name;
    }
}