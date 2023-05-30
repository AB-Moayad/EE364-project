import java.util.ArrayList;

public class Pathway implements Commutable {
    private String name;
    private int length;
    private int capacity;
    private int currentVisitors;
    private ArrayList<HaramTarget> r_locations = new ArrayList<>();
    private ArrayList<HaramTarget> l_locations = new ArrayList<>();
    private ArrayList<Commutable> intersections = new ArrayList<>();
    private ArrayList<Organizer> organizers = new ArrayList<>();
    private Direction direction;
    private int floor;

    public Pathway(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;

    }

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

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean hasSpace() {
        return (currentVisitors < capacity);
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

    public int getCurrentVisitors() {
        return currentVisitors;
    }

    public void setCurrentVisitors(int currentVisitors) {
        this.currentVisitors = currentVisitors;
    }

    public boolean incrementCurrentVisitors() {
        if ((currentVisitors + 1) <= capacity) {
            this.currentVisitors++;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean decrementCurrentVisitors() {
        if ((currentVisitors - 1) >= 0) {
            this.currentVisitors--;
            return true;
        }
        else {
            return false;
        }
    }

    public int setDuration() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDuration'");
    }

    public int setCapacity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCapacity'");
    }

    public String toString() {
        return this.name;
    }

    @Override
    public String getName() {
        return name;
    }
}