import java.util.ArrayList;

public abstract class Visitor {
private String navigation;
private ArrayList<HaramTarget> Targets;
private Direction direction;

public Visitor(String navigation,ArrayList<HaramTarget> target,Direction direction){
    this.navigation = navigation;
    this.Targets = target;
    this.direction = Direction.in;
}


public void visit() {
    System.out.println("Visitor class");
}

public int getDirection(){
    if (direction == Direction.in){
        return 1;
    }
    else if (direction == Direction.out){
        return 0;
    }
    else{
        return 2;
    }
}

public String getNavigation(Visitor visitor){
    return navigation;
}

public ArrayList<HaramTarget> getHaramTargets(){
    return Targets;
}

public void pray(String mosqueName,String prayerName) {
    PrayLocation salah = new PrayLocation(mosqueName);
    salah.setTime_of_prayer(prayerName);
}

public void performSai(Msaa obj) {
    Msaa msaa = new Msaa();
    msaa.getStage();
}

public void performTawaf(Sahan obj) {
    Sahan sahan = new Sahan();
    sahan.getStage();
}

}
