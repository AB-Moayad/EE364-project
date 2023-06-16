import java.util.ArrayList;
/**
 * the clas sahan represnt the sahan in al-haram 
 * child class of haram target 
 */
public class Sahan extends HaramTarget {
    //Instance 
    ArrayList<Pathway> tawafPaths = new ArrayList<>();

    /**
     * Constructor takes targetname and max capacity
     * @param name sahan name
     * @param capacity maxmium capacity 
     * @param numberOfTawafPaths the number of the lines around al kaaba
     */
    public Sahan(String name, int capacity) {
        super();
        setTargetName(name);
        setCapacity(capacity);

        int numberOfTawafPaths = 7;
        for (int i = 0; i < numberOfTawafPaths; i++) {
            tawafPaths.add(new Pathway("SahanPath#" + (i + 1), capacity / numberOfTawafPaths ));
        }
    }

     /**
     * To get the availability of the capacity 
     * @return the remaing space
     */
    @Override
    public int getAvailableCapacity() {
        int aggregatedAvailableCapacity = getCapacity();

        for (Pathway tawafPath: tawafPaths) {
            aggregatedAvailableCapacity -= tawafPath.getNumberOfCurrentVisitors();
        }
        return aggregatedAvailableCapacity;
    }

    /**
     * To get the availability raito of the capacity 
     * @return the raito of the capacity 
     */
    @Override
    public double getAvailableCapacityRatio() {
        int aggregatedNumberOfCurrentVisitors = 0;
        for (Pathway tawafPath: tawafPaths) {
            aggregatedNumberOfCurrentVisitors += tawafPath.getNumberOfCurrentVisitors();
        }
        return (double) aggregatedNumberOfCurrentVisitors / getCapacity();
    }

    /**
    * To check if the sahan has space or no
    * by checking the capcity in each path to see it has space or not

    * @return if the target has space return pathway , if not return null 
    */
    public Commutable findVacantTawafPath() {
        for (Commutable tawafPath: tawafPaths) {
            if (tawafPath.hasSpace()) {
                return tawafPath;
            }
            
        }
        return null;
    }

    /**
     * To get duration time spent in Sahan 
     * 80 is the estimated number of the duration 
     * 
     * @return the duration that the pligirm will spent in sahan
     */
    public int getDuration() {
        return 80;
    }

    
     /**  
      * Exception for not setting duration
      */
    public int setDuration() {
        throw new UnsupportedOperationException("Unimplemented method 'setDuration'");
    }

    /**  
    *Exception for not setting capacity
    */
    public int setCapacity() {
        throw new UnsupportedOperationException("Unimplemented method 'setCapacity'");
    }
    
}
