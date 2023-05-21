public class Msaa extends Pathway {
    private int stage;

    public Msaa(){
        super();
    }
    public int getStage() {
        
        for (int visitorStage = 0;visitorStage < 7;visitorStage++){
            System.out.println("The visitor is in" + visitorStage + "Stage");
            ++stage;
        }

        return stage;

    }

    public void selectFloor(Visitor visitor, int floor) {
        // assign floor to visitor
        if (visitor.getDirection() == 1){
            getCapacity();
        }
    }
}
