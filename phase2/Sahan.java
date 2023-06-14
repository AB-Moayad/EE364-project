import java.util.ArrayList;

public class Sahan extends HaramTarget {
    
    //Instance 
    ArrayList<Pathway> tawafPaths = new ArrayList<>();

    //Constructor takes pathway name and capacity 
    public Sahan(String name, int capacity) {
        super();
        setTargetName(name);
        setCapacity(capacity);

        int numberOfTawafPaths = 7;
        for (int i = 0; i < numberOfTawafPaths; i++) {
            tawafPaths.add(new Pathway("SahanPath#" + (i + 1), capacity / numberOfTawafPaths ));
        }
    }

    //Getters and Setters
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
        return 80;
    }

    public int setDuration() {
        throw new UnsupportedOperationException("Unimplemented method 'setDuration'");
    }

    public int setCapacity() {
        throw new UnsupportedOperationException("Unimplemented method 'setCapacity'");
    }
    
}
