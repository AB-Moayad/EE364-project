public class Pathway {
    private double length;
    private int capacity;
    private HaramTarget[] r_locations;
    private HaramTarget[] l_locations;
    private Pathway[] intersections;
    private Organizer[] organizers;
    private Direction direction;
    private int floor;
    private String pathwayName;

    public Pathway(String pathwayName) {
        setPathwayName(pathwayName);
    }

    public void setPathwayName(String pathwayName) {
        this.pathwayName = pathwayName;
    }

    public String getPathwayName() {
        return pathwayName;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = 100;
        if (capacity >= 100) {
            System.out.println("The place is full");
        }

        else {
            int room = 0;
            int space = 100 / room;
            System.out.println("The place has:" + space + "capacity out of 50");
        }
    }

    public HaramTarget[] getRLocations() {
        return r_locations;
    }

    public void setRLocations(HaramTarget[] r_locations) {
        this.r_locations = r_locations;
    }

    public HaramTarget[] getLLocations() {
        return l_locations;
    }

    public void setLLocations(HaramTarget[] l_locations) {
        this.l_locations = l_locations;
    }

    public Pathway[] getIntersections() {
        return intersections;
    }

    public void setIntersections(Pathway[] intersections) {
        this.intersections = intersections;
    }

    public Organizer[] getOrganizers() {
        return organizers;
    }

    public void setOrganizers(Organizer[] organizers) {
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

    @Override
    public String toString() {
        return  getPathwayName();
    }
}
