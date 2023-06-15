import java.util.ArrayList;

public class Building extends HaramTarget {

    //Constructor
    public Building(String name, int capacity) {
        this.setTargetName(name);
        this.setCapacity(capacity);
    }

    @Override
    public int getDuration() {
        return 50;
    }


    public ArrayList<Commutable> getIntersections() {
        return intersections;
    }

    @Override
   public void setDuration(int duration) {
       setDuration(duration);
   }



    @Override
    public void setIntersections(ArrayList<Commutable> intersections) {
        this.intersections = intersections;
    }

  





    
    
}
