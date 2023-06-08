import java.util.ArrayList;

public class Restaurant extends HaramTarget{
    private int capacity;
    private int wait_time;
    private int eating_time;
    
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getWait_time() {
        return wait_time;
    }
    public void setWait_time(int wait_time) {
        this.wait_time = wait_time;
    }
    public int getEating_time() {
        return eating_time;
    }
    public void setEating_time(int eating_time) {
        this.eating_time = eating_time;
    }
    public int getDuration() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDuration'");
    }
    public ArrayList<Commutable> getIntersections() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIntersections'");
    }

    public int setDuration() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDuration'");
    }
    public int setCapacity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCapacity'");
    }
    @Override
    public void setIntersections(ArrayList<Commutable> intersections) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIntersections'");
    }
       
}
