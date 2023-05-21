import java.util.ArrayList;
import java.util.Random;

public class PrayLocation extends HaramTarget {
    private int Capacity;
    private int Floor;
    private boolean Inside;
    private ArrayList<String> Name = new ArrayList<String>();
    private int Time_of_prayer;
    private double PrayerTime;
    int seats = 0;
    
    Random random = new Random();


    public PrayLocation(String mousqe_name) {
        super(mousqe_name);
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(ArrayList<String> name ) {
        
        this.Capacity = 50;
        if (Capacity >=50){
            System.out.println("The place is full");
        }

        else{
            int space = 50/seats;
            System.out.println("The place has:" + space + "capacity out of 50");
        }
        
    }
// when we do phase 2 
    public int getFloor() {
        return Floor;
    }
// when we do phase 2 
    public void setFloor(int floor) {
        this.Floor = floor;
    }

    public void setInside(Visitor visitor) {
        if (visitor.getDirection() == 1) {
            ++seats;
            this.Inside = true;
        } else if (visitor.getDirection() == 0) {
            --seats;
            this.Inside = false;
        }
    }

    public boolean getInside(boolean inside) {
        return Inside;
    }

    public String getName() {
        int randomIndex = random.nextInt(Name.size());
        return Name.get(randomIndex);
    }

    public void setName(ArrayList<String> name) {
        for (int i = 1;i<8;i++){
            Name.add("Pray Location #"+i);
            System.out.println(Name.get(i-1));
        }    
    }

    public int getTime_of_prayer() {
        return Time_of_prayer;
    }

    public void setTime_of_prayer(String PrayerName) {

        switch (PrayerName) {
            case "Fajir":
                this.Time_of_prayer =  random.nextInt(10,21);
            case "Duhr":
            case "Asur":
                this.Time_of_prayer =  random.nextInt(15,21);
            case "Magreeb":
                this.Time_of_prayer =  random.nextInt(10,21);
            case "Ashia":
                this.Time_of_prayer =  random.nextInt(15,25);
            default:
            this.Time_of_prayer =  random.nextInt(10,20);
        }
    }

    //need JavaFX
    public double getPrayerTime() {
        return PrayerTime;
    }

    public void setPrayerTime(double prayerTime) {
        PrayerTime = prayerTime;
    }

}