import java.util.ArrayList;

public abstract class HaramTarget implements Commutable {
    private String TargetName;
    private int capacity;
    private int duration;
    private int numberOfCurrentVisitors;
    protected ArrayList<Commutable> intersections = new ArrayList<>();       
    
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

    public HaramTarget() {
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


    public String toString() {
        return this.TargetName;
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

    
  }