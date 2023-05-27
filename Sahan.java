import java.util.Random;

public class Sahan extends Pathway {
    private int stage;
    
    public Sahan(String Sahan){
        super(Sahan);
    }

    public int getStage() {
        Random random = new Random();
        this.stage = random.nextInt(7); // Generates a random stage between 0 and 6
        System.out.println("now the Pilgrim is perfoming Tawaf and he is now in Stage " + stage);
        return stage;
    }

    public void selectFloor(Visitor visitor, int floor) {
        if (visitor.getDirection() == 1){
            getCapacity();
        }    }
}
