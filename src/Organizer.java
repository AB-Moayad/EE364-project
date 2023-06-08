public class Organizer {
    private int organizerID;
    private static int numberOfOrganizers = 0;

    public Organizer() {
        /* Upon creating an organizer, increment the total number of organizers,
         * and assign the current number as an ID for this organizer.
         * E.g. the fifth oragnizer gets organizerID 5. */
        numberOfOrganizers++;
        organizerID = numberOfOrganizers;
    }


    public void makeDecision(Visitor visitor) {
        // make a decision affecting the passed visitor
    }

    public int getOrganizerID() {
        return organizerID;
    }

    public void setOrganizerID(int organizerID) {
        this.organizerID = organizerID;
    }

    public static int getNumberOfOrganizers() {
        return numberOfOrganizers;
    }
       
}
