import java.util.ArrayList;
import java.util.Random;

public class Haram {

    private ArrayList<PrayLocation> prayLocations = new ArrayList<PrayLocation>();
    private Pathway prayLocationPathway;
    private Pathway[] pathways;
    private Visitor[] visitors;
    private ArrayList<Gate> gates = new ArrayList<Gate>();
    private HaramFacility[] haramFacilities;
    private Outside[] outsides;

    static Random random = new Random();

    public static void main(String[] args) {
        Haram haram = new Haram();
        haram.generateGates();
        haram.generatePathways();
        haram.connectGatesToPathways();
        haram.createPrayLocationPathway();
        haram.createPrayLocations(7);
        haram.simulateVisitors(10);
    }

    private void generateGates() {
        gates.add(new Gate("Gate#1"));
        gates.add(new Gate("Gate#2"));
        gates.add(new Gate("Gate#3"));
        gates.add(new Gate("Gate#4"));
        gates.add(new Gate("Gate#5"));
        gates.add(new Gate("Gate#6"));
        gates.add(new Gate("Gate#7"));
    }

    private Gate getRandomGate() {
        Random random = new Random();
        return gates.get(random.nextInt(gates.size()));
    }

    private void generatePathways() {
        pathways = new Pathway[7];
        for (int i = 0; i < pathways.length; i++) {
            pathways[i] = new Pathway("Pathway of Gate#" + (i + 1));
        }
    }

    private void connectGatesToPathways() {
        for (int i = 0; i < gates.size(); i++) {
            Gate gate = gates.get(i);
            Pathway pathway = pathways[i];
            gate.setConnectedPathway(pathway);
        }
    }

    private void simulateVisitors(int numVisitors) {
        for (int i = 0; i < numVisitors; i++) {
            // Visitor visitor =
            generateRandomVisitor();
            Gate randomGate = getRandomGate();
            Pathway connectedPathway = randomGate.getConnectedPathway();

            PrayLocation prayLocation = getRandomPrayLocation();
            Pathway prayLocationPathway = prayLocation.getPathway();
            System.out.println("Visitor " + (i + 1) + " entered through " + randomGate +
                    " and reached " + connectedPathway + " then moved to " + prayLocationPathway +
                    " and reached " + prayLocation);
        }
    }

    private PrayLocation getRandomPrayLocation() {
        Random random = new Random();
        return prayLocations.get(random.nextInt(prayLocations.size()));
    }

    private Visitor generateRandomVisitor() {
        Random random = new Random();
        int randomNumber = random.nextInt(2); // Generates either 0 or 1

        if (randomNumber == 0) {
            return new Prayer();
        } else {
            return new Pilgram();
        }
    }

    private void createPrayLocations(int numLocations) {
        for (int i = 0; i < numLocations; i++) {
            PrayLocation prayLocation = new PrayLocation("PrayLocation" + (i + 1));
            prayLocations.add(prayLocation);

            Pathway pathwayToPrayLocation = new Pathway("PLPathway" + (i + 1));
            prayLocation.setPathway(pathwayToPrayLocation);
        }
    }

    private void createPrayLocationPathway() {
        prayLocationPathway = new Pathway("PrayLocationPathway");
    }

}
