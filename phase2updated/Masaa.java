public class Masaa extends Pathway {
    private int stage;
    
    //Constructor takes the name of the pathway(Masaa) and max capacity
    public Masaa(String name, int capacity) {
        super(name, capacity);

    }

    //get satge 
    public int getStage() {
        return stage;
    }

    @Override
     public int getDuration() {
        return 100;
    } 

}
