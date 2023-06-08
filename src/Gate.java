import java.util.ArrayList;

public class Gate extends HaramTarget {
  private ArrayList<Organizer> organizers = new ArrayList<>();
  private ArrayList<Pathway> pathways = new ArrayList<>();
  private ArrayList<Pathway> pathwaysOut = new ArrayList<>();
  // private String gateName
  
    // Constructor
    public Gate(String gateName) {
      /* Since the parent class HaramTarget has the attribute targetName and its constructor sets the target name,
      we may call that constructor here
       */
      setTargetName(gateName);
      // this.gateName = gateName
    }
  
  public ArrayList<Organizer> getOrganizers() {
    return organizers;
  }

  public void setOrganizers(ArrayList<Organizer> organizers) {
    this.organizers = organizers;
  }

  public ArrayList<Pathway> getPathways() {
    return pathways;
  }

  public void setPathways(ArrayList<Pathway> pathways) {
    this.pathways = pathways;
  }

  public ArrayList<Pathway> getPathwaysOut() {
    return pathwaysOut;
  }

  public void setPathwaysOut(ArrayList<Pathway> pathwaysOut) {
    this.pathwaysOut = pathwaysOut;
  }

  // public String getGateName() {
  //   return gateName;
  // }

  // public void setGateName(String gateName) {
  //   this.gateName = gateName;
  // }


  // public boolean arrive(Visitor visitor) {
  //   /* Haram class could have an arraylist of visitors and a getter method 'getVisitors'.
  //   if a visitor is successfully added to the arraylist, the 'add(visitor)' method returns true*/ 
  //   //return Haram.getVisitors().add(visitor);
  // }

  
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
