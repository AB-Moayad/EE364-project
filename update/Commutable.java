import java.util.ArrayList;

public interface Commutable {
    
    public int getDuration();
    public int setDuration();
    public int getCapacity();
    public int setCapacity();
    public ArrayList<Commutable> getIntersections();
    public void setIntersections(ArrayList<Commutable> intersections);
    public String toString();
    public String getName();
    public boolean hasSpace();
}
