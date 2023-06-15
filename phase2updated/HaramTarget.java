import java.util.ArrayList;

public abstract class HaramTarget implements Commutable {
    //Attributes 
    private String TargetName;
    private int capacity;
    private int numberOfCurrentVisitors;
    private ArrayList<Commutable> intersections = new ArrayList<>();       
    
    public HaramTarget() {}

    //getters & setters
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

    public String getTargetName() {
        return TargetName;
    }
  
    public void setTargetName(String targetName) {
        this.TargetName = targetName;
    }

    public boolean hasSpace() {
        return (numberOfCurrentVisitors < capacity);
    }

    public String getName() {
        // for the interface
        return TargetName;
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

    public String toString() {
        return this.TargetName;
    }

    public int getNumberOfCurrentVisitors() {
        return numberOfCurrentVisitors;
    }

    public void setNumberOfCurrentVisitors(int numberOfCurrentVisitors) {
        this.numberOfCurrentVisitors = numberOfCurrentVisitors;
    }

    public ArrayList<Commutable> getIntersections() {
        return intersections;
    }

    public void setIntersections(ArrayList<Commutable> intersections) {
        this.intersections = intersections;
    }

    
  }