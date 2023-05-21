public class HaramFacility extends HaramTarget{

    private int BathroomCapacity = 0;
    private int TotalWatingTime;
  
    public HaramFacility(String BathroomNumber) {
        super(BathroomNumber);
    }

//Calculate total waiting time in bathroom 
public int BathroomWaitingTime(int NumOfPeople, int AverageTime){

    int NumOfStalls = 20;

    int TotalTimePerPerson = AverageTime + 3;

    int maxPeopleAtOnce = NumOfStalls/2 + 1;

    int totalBathroomTime = (int) Math.ceil((double)NumOfPeople / maxPeopleAtOnce) * TotalTimePerPerson;

     this.TotalWatingTime = totalBathroomTime - NumOfPeople * TotalTimePerPerson;

    return TotalWatingTime;
}


//Get bathroom capacoty
public int GetBathroomCapacity(){
    return BathroomCapacity;
}

// set bathroom capacity if the is someone enter bathroom "in = true" -> capacity = +1
public void SetBathroomCapacity(Visitor visitor){
    
    if (visitor.getDirection() == 1){
        ++BathroomCapacity;
    }
        
    else if (visitor.getDirection() == 0){
        --BathroomCapacity;

    }
 }

}


