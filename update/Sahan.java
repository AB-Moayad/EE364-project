import java.util.ArrayList;

public class Sahan extends HaramTarget {

    ArrayList<Pathway> tawafPaths = new ArrayList<>();
    
    public Sahan(String name, int capacity) {
        super();
        setTargetName(name);
        setCapacity(capacity);

        int numberOfTawafPaths = 7;
        for (int i = 0; i < numberOfTawafPaths; i++) {
            tawafPaths.add(new Pathway("SahanPath#" + (i + 1), capacity / numberOfTawafPaths ));
        }
    }

    @Override
    public int getAvailableCapacity() {
        int aggregatedAvailableCapacity = getCapacity();

        for (Pathway tawafPath: tawafPaths) {
            aggregatedAvailableCapacity -= tawafPath.getNumberOfCurrentVisitors();
        }
        return aggregatedAvailableCapacity;
    }

    @Override
    public double getAvailableCapacityRatio() {
        int aggregatedNumberOfCurrentVisitors = 0;
        for (Pathway tawafPath: tawafPaths) {
            aggregatedNumberOfCurrentVisitors += tawafPath.getNumberOfCurrentVisitors();
        }
        return (double) aggregatedNumberOfCurrentVisitors / getCapacity();
    }


    public Commutable findVacantTawafPath() {
        for (Commutable tawafPath: tawafPaths) {
            if (tawafPath.hasSpace()) {
                return tawafPath;
            }
            
        }
        return null;
    }

    public int getDuration() {
        return 50;
    }

    public int setDuration() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDuration'");
    }

    public int setCapacity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCapacity'");
    }

    public ArrayList<Commutable> getIntersections() {
        return intersections;
    }

    public void setIntersections(ArrayList<Commutable> intersections) {
        this.intersections = intersections;
    }

    
}
