import java.util.ArrayList;

public class Gate extends HaramTarget {
  private ArrayList<Organizer> organizers = new ArrayList<>();
  private ArrayList<Pathway> pathways = new ArrayList<>();
  private ArrayList<Pathway> pathwaysOut = new ArrayList<>();
  private Pathway connectedPathway;


    // Constructor
    public Gate(String gateName) {
      // Since the parent class HaramTarget has the attribute targetName and its constructor sets the target name,
      //we may call that constructor here
       
        super(gateName);
        //this.gateName = gateName;
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

  public void setConnectedPathway(Pathway pathway) {
    this.connectedPathway = pathway;
}

  public Pathway getConnectedPathway() {
  return connectedPathway;
} 


////public String getGateName() {
//  return gateName;
//}
 //public void setGateName(String gateName) {
 //  this.gateName = gateName;
 //}
 @Override
 public String toString() {
     return getTargetName();
 }

}
