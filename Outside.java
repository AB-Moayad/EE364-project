public class Outside extends HaramTarget {

    private int GoingOutTime;

    public Outside(String target) {
        super(target);
    }

    // Generate a random integer between 25 and 35 mintues for order time
    public int GoingOutTime() {
        this.GoingOutTime = (int) (Math.random() * 11) + 20;
        return GoingOutTime;
    }

}
