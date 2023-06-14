
public class Organizer {
    //Instances
    private int organizerID;
    private Pathway pathway;
    private static int numberOfOrganizers = 0;

    public Organizer(Pathway pathway) {
        /* Upon creating an organizer, increment the total number of organizers,
         * and assign the current number as an ID for this organizer.
         * E.g. the fifth oragnizer gets organizerID 5. */
        numberOfOrganizers++;
        organizerID = numberOfOrganizers;
        this.pathway = pathway;
    }

    //getters
    public int getOrganizerID() {
        return organizerID;
    }
    public static int getNumberOfOrganizers() {
        return numberOfOrganizers;
    }
    public Pathway getPathway(){
        return pathway;
    }
       
}
