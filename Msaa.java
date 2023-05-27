import java.util.Random;

public class Msaa extends Pathway {
    private int stage;

    public Msaa(String msaa){
        super(msaa);
    }
    public int getStage() {
        
        Random random = new Random();
        this.stage = random.nextInt(7); // Generates a random stage between 0 and 6
        System.out.println("now the Pilgrim is perfoming Saai and he is now in Stage " + stage);
        return stage;

    }

    public void selectFloor(Visitor visitor, int floor) {
        // assign floor to visitor
        if (visitor.getDirection() == 1){
            getCapacity();
        }
    }
}
