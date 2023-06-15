import java.util.ArrayList;

public abstract class HaramTarget implements Commutable {
    //Attributes 
    private String TargetName;
    private int capacity;
    private int numberOfCurrentVisitors;
    protected ArrayList<Commutable> intersections = new ArrayList<>();       
    
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

    
  }