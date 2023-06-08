import java.util.ArrayList;

public interface Commutable {
    
    public int getDuration();
    public int setDuration();
    public int getCapacity();
    public void setCapacity(int capacity);
    public ArrayList<Commutable> getIntersections();
    public void setIntersections(ArrayList<Commutable> intersections);
    public String toString();
    public String getName();
    public boolean hasSpace();
    public int getAvailableCapacity();
    public double getAvailableCapacityRatio();
    public void incrementCurrentVisitors();
    public void decrementCurrentVisitors();
}
