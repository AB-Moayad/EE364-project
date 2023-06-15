import java.util.ArrayList;

public class Pathway implements Commutable {
    //Instances
    private String name;
    private int length;
    private int capacity;
    private int numberOfCurrentVisitors;
    private ArrayList<Commutable> intersections = new ArrayList<>();
    
    
    //Constructor takes name of the pathway and max capacity 
    public Pathway(String name, int capacity) {
        setName(name);
        setCapacity(capacity);

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
        length = 50; //based on the legnth of the pathway , the pathways has 50 length so the visitor would move 1 length unit per duration 
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


    public ArrayList<Commutable> getIntersections() {
        return intersections;
    }

    public void setIntersections(ArrayList<Commutable> intersections) {
        this.intersections = intersections;
    }


    public int getNumberOfCurrentVisitors() {
        return numberOfCurrentVisitors;
    }

    public void setNumberOfCurrentVisitors(int currentVisitors) {
        this.numberOfCurrentVisitors = currentVisitors;
    }

  @Override
   public void setDuration(int duration) {
       setDuration(duration);
   }


    public String toString() {
        return this.name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}