
/**
 * The class PrayLocation represnt the haram's Pray locations  
 * 
 * child clas of HaramTarget
 */
public class PrayLocation extends HaramTarget {

    /**
     * Constructor takes targetname and max capacity
     * 
     * @param targetName praylocation name
     * @param capacity the maxmium capacity
     */
    public PrayLocation(String targetName, int capacity) {
        setTargetName(targetName);
        setCapacity(capacity);
    }
    
    /**
     * Set duration time spent in the pray location
     * 70 is the estimated number of the duration 
     * @return the duration 
     */
    @Override
    public int getDuration() {
        return 70;
    }

    /**  
    * Exception for not setting duration
    */
    @Override
    public int setDuration() {
        throw new UnsupportedOperationException("Unimplemented method 'setDuration'");
    }
    
}
