/**
 *  the class Masaa represent the masaa in haram 
 *  sub class of pathway 
 */
public class Masaa extends Pathway {
    private int stage;
    
    /**
     * Constructor takes the name of the pathway(Masaa) and max capacity
     * @param name pathway name 
     * @param capacity maxmium capacity 
     */
    public Masaa(String name, int capacity) {
        super(name, capacity);

    }

    /**
     * To get the stage of the visitor 
     * ( each visitor has duty to finish and stage represent the current stage of the vistor)
     * @return visitor satge 
     */
    public int getStage() {
        return stage;
    }
    
    /**
     * To get duration time spent in masaa 
     * 100 is the estimated number of the duration 
     * @return duration 
     */
    @Override
     public int getDuration() {
        return 100; 
    } 

}
