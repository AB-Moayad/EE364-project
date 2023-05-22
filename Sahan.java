public class Sahan extends Pathway {
    private int stage;
    
    public Sahan(){
        super("Sahan");
    }

    public int getStage() {
        for (int visitorStage = 0;visitorStage < 7;visitorStage++){
            System.out.println("The visitor is in" + visitorStage + "Stage");
            ++stage;
        }

        return stage;
    }

    public void selectFloor(Visitor visitor, int floor) {
        if (visitor.getDirection() == 1){
            getCapacity();
        }    }
}
