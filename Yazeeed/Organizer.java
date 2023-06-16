/**
 * the class organizer reprent the orginzer in haram 
 * who makes the decision for visitors' action
 */
public class Organizer {
    //Instances
    private int organizerID;
    private Pathway pathway;
    private static int numberOfOrganizers = 0;
    
    /**
     * Upon creating an organizer, increment the total number of organizers,
     * and assign the current number as an ID for this organizer.
     * E.g. the fifth oragnizer gets organizerID
     * @param organizerID ID of the organizer
     * @param pathway the pathway that the organizer responsible for
     */
    public Organizer(Pathway pathway) {
        numberOfOrganizers++;
        organizerID = numberOfOrganizers;
        this.pathway = pathway;
    }

    /**
     * To get organizer ID 
     * @return organizer ID 
     */
    public int getOrganizerID() {
        return organizerID;
    }

    /**
     * Get number of organizer 
     * @return numberOfOrganizers
     */
    public static int getNumberOfOrganizers() {
        return numberOfOrganizers;
    }

    /**
     * to get pathway 
     * @return pathway
     */
    public Pathway getPathway(){
        return pathway;
    }
       
}
