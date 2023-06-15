
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.tools.Tool;

import javafx.application.Platform;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;


public class Haram {
    //Intacnes
    private ArrayList<PrayLocation> prayLocations = new ArrayList<>();
    private ArrayList<Pathway> pathways = new ArrayList<>();
    private ArrayList<Pathway> outerPathways = new ArrayList<>();
    private Sahan sahan;
    private ArrayList<Masaa> masaaLanes = new ArrayList<>();
    private ArrayList<Building> buildings = new ArrayList<>();
    private ArrayList<Visitor> visitors = new ArrayList<>();
    private ArrayList<Visitor> visitorsExited = new ArrayList<>();
    private int timeElapsedSecs;
    
    // genral random varible
    static Random random = new Random();

    private static boolean stopLoop;
    


    Haram() {
        //setting default names of the locations 
        String[] defaultPrayLocationsNames = { "Area 1", "Area 2", "Area 3", "Area 4", "Area 5",
                "Area 6", "Area 7", "Area 8", "Area 9", "Area 10", };
        //from pathway 1 to 6 -> outer pathway
        String[] defaultOuterPathways = { "Pathway 1", "Pathway 2", "Pathway 3", "Pathway 4",
                "Pathway 5", "Pathway 6" };
        //from pathway 7 to 13 -> inner pathway
        String[] defaultInnerPathways = { "Pathway 7", "Pathway 8", "Pathway 9", "Pathway 10",
                "Pathway 11", "Pathway 12", "Pathway 13" };
        //setting deafault names for the buldings 
        String[] defaultBuildingNames = { "King Fahd Extension", "Saudi Portico", "Massa" };
        stopLoop = false;

        /*
         * ****** Naming guide *******:
         * 
         * Building 0 = King Fahd Extension
         * Building 1 = Saudi Portico
         * Building 2 = Masaa building
         * 
         * 
         * Outer pathways are the pathways numbered from 1 to 6; contained in the
         * ArrayList outerPathways; with respective indices 0-5
         * 
         * Innter pathways are the pathways numbered from 7 to 13; contained in the
         * ArrayList pathways; with respective indices 0-6
         * 
         *
         * For the following initializatoins refer to the Mosque diagram; 'Mosque Map.pptx'
         */


        // initialize pray locations
        for (String prayLocationName : defaultPrayLocationsNames) {
            prayLocations.add(new PrayLocation(prayLocationName, 2)); // 100 visitor capacity for testing
        }

        // initialize buildings
        for (String buildingName : defaultBuildingNames) {
            buildings.add(new Building(buildingName, 2));
        }

        // initialize outer pathways
        for (String pathwayName : defaultOuterPathways) {
            outerPathways.add(new Pathway(pathwayName, 2));
        }

        // initialize some inner pathways
        for (String pathwayName : defaultInnerPathways) {
            pathways.add(new Pathway(pathwayName, 2));
        }

        // initialize Massa objects
        for (int floorCount = 1; floorCount <= 1; floorCount++) {
            masaaLanes.add(new Masaa("Safa-Marwa_floor" + floorCount, 2));
            masaaLanes.add(new Masaa("Marwa-Safa_floor" + floorCount, 2));
        }

        // initialize Tawaf Sahan
        sahan = new Sahan("Tawaf Sahan", 7 * 2);

        /* INTERSECTIONS */

        // pray location intesections initialization
        Commutable[] prayLocation1Intersections = { buildings.get(0) };
        prayLocations.get(0).setIntersections(new ArrayList<Commutable>(Arrays.asList(prayLocation1Intersections)));
        
        Commutable[] prayLocation2Intersections = { buildings.get(0) };
        prayLocations.get(1).setIntersections(new ArrayList<Commutable>(Arrays.asList(prayLocation2Intersections)));

        Commutable[] prayLocation3Intersections = { buildings.get(1) };
        prayLocations.get(2).setIntersections(new ArrayList<Commutable>(Arrays.asList(prayLocation3Intersections)));

        Commutable[] prayLocation4Intersections = { buildings.get(1) };
        prayLocations.get(3).setIntersections(new ArrayList<Commutable>(Arrays.asList(prayLocation4Intersections)));

        Commutable[] prayLocation5Intersections = { buildings.get(1) };
        prayLocations.get(4).setIntersections(new ArrayList<Commutable>(Arrays.asList(prayLocation5Intersections)));

        Commutable[] prayLocation6Intersections = { buildings.get(1) };
        prayLocations.get(5).setIntersections(new ArrayList<Commutable>(Arrays.asList(prayLocation6Intersections)));

        Commutable[] prayLocation7Intersections = { buildings.get(1) };
        prayLocations.get(6).setIntersections(new ArrayList<Commutable>(Arrays.asList(prayLocation7Intersections)));

        Commutable[] prayLocation8Intersections = { buildings.get(1) };
        prayLocations.get(7).setIntersections(new ArrayList<Commutable>(Arrays.asList(prayLocation8Intersections)));

        Commutable[] prayLocation9Intersections = { buildings.get(1) };
        prayLocations.get(8).setIntersections(new ArrayList<Commutable>(Arrays.asList(prayLocation9Intersections)));

        Commutable[] prayLocation10Intersections = { buildings.get(1) };
        prayLocations.get(9).setIntersections(new ArrayList<Commutable>(Arrays.asList(prayLocation10Intersections)));

        // outer pathways intersections initialization *****
        Commutable[] pathway1Intersections = { buildings.get(1) };
        outerPathways.get(0).setIntersections(new ArrayList<Commutable>(Arrays.asList(pathway1Intersections)));

        Commutable[] pathway2Intersections = { buildings.get(1) };
        outerPathways.get(1).setIntersections(new ArrayList<Commutable>(Arrays.asList(pathway2Intersections)));

        Commutable[] pathway3Intersections = { buildings.get(0) };
        outerPathways.get(2).setIntersections(new ArrayList<Commutable>(Arrays.asList(pathway3Intersections)));

        Commutable[] pathway4Intersections = { buildings.get(1) };
        outerPathways.get(3).setIntersections(new ArrayList<Commutable>(Arrays.asList(pathway4Intersections)));

        Commutable[] pathway5Intersections = { buildings.get(1) };
        outerPathways.get(4).setIntersections(new ArrayList<Commutable>(Arrays.asList(pathway5Intersections)));

        Commutable[] pathway6Intersections = { buildings.get(1) };
        outerPathways.get(5).setIntersections(new ArrayList<Commutable>(Arrays.asList(pathway6Intersections)));

        // inner pathways intersections initialization *****
        Commutable[] pathway7Intersections = { buildings.get(1), sahan };
        pathways.get(0).setIntersections(new ArrayList<Commutable>(Arrays.asList(pathway7Intersections)));

        Commutable[] pathway8Intersections = { buildings.get(1), sahan };
        pathways.get(1).setIntersections(new ArrayList<Commutable>(Arrays.asList(pathway8Intersections)));

        Commutable[] pathway9Intersections = { buildings.get(1), sahan };
        pathways.get(2).setIntersections(new ArrayList<Commutable>(Arrays.asList(pathway9Intersections)));

        Commutable[] pathway10Intersections = { buildings.get(1), sahan };
        pathways.get(3).setIntersections(new ArrayList<Commutable>(Arrays.asList(pathway10Intersections)));

        Commutable[] pathway11Intersections = { buildings.get(1), sahan };
        pathways.get(4).setIntersections(new ArrayList<Commutable>(Arrays.asList(pathway11Intersections)));

        Commutable[] pathway12Intersections = { buildings.get(1), sahan };
        pathways.get(5).setIntersections(new ArrayList<Commutable>(Arrays.asList(pathway12Intersections)));

        Commutable[] pathway13Intersections = { buildings.get(1), buildings.get(2), sahan }; // , masaaLanes.get(0),
                                                                                             // masaaLanes.get(1)
        pathways.get(6).setIntersections(new ArrayList<Commutable>(Arrays.asList(pathway13Intersections)));

        // Sahan path intersections initialization
        int i = 0;
        ArrayList<Commutable> sahanIntersections = new ArrayList<>();
        for (Pathway tawafPath : sahan.tawafPaths) {
            Commutable[] intersections = { sahan, buildings.get(1) };
            pathways.get(i).setIntersections(new ArrayList<Commutable>(Arrays.asList(intersections)));
            sahanIntersections.add(tawafPath);
            tawafPath.setIntersections(new ArrayList<Commutable>(Arrays.asList(intersections)));
            i++;
        }
        sahan.setIntersections(sahanIntersections);
        for (Pathway pathway : pathways) {
            sahan.getIntersections().add(pathway);
        }

        // building intersections initialization
        Commutable[] kingFahdExtIntersections = { buildings.get(1), prayLocations.get(0), prayLocations.get(1) };
        buildings.get(0).setIntersections(new ArrayList<Commutable>(Arrays.asList(kingFahdExtIntersections)));

        Commutable[] saudiPorticoIntersections = { buildings.get(0), prayLocations.get(2), prayLocations.get(3),
                prayLocations.get(4), prayLocations.get(5),
                prayLocations.get(6), prayLocations.get(7), prayLocations.get(8), prayLocations.get(9),
                outerPathways.get(0), outerPathways.get(1), outerPathways.get(3), outerPathways.get(4),
                outerPathways.get(5),
                pathways.get(0), pathways.get(1), pathways.get(2), pathways.get(3), pathways.get(4), pathways.get(5),
                pathways.get(6), buildings.get(2) };
        buildings.get(1).setIntersections(new ArrayList<Commutable>(Arrays.asList(saudiPorticoIntersections)));

        Commutable[] masaaIntersections = { masaaLanes.get(0), masaaLanes.get(1), buildings.get(1) };
        buildings.get(2).setIntersections(new ArrayList<Commutable>(Arrays.asList(masaaIntersections)));

        // Massa lanes intersections initialization
        Commutable[] massaLane1Intersections = {masaaLanes.get(1), pathways.get(6) };
        masaaLanes.get(0).setIntersections(new ArrayList<Commutable>(Arrays.asList(massaLane1Intersections)));

        Commutable[] massaLane2Intersections = { buildings.get(2), masaaLanes.get(0),
                pathways.get(6) };
        masaaLanes.get(1).setIntersections(new ArrayList<Commutable>(Arrays.asList(massaLane2Intersections)));
    }
    // Main loop
    public static void main(String[] args, MyApp myApp) {
        Thread loopThread = new Thread(() -> {
            Haram haram = new Haram();
            MyApp gui = myApp;
            int maxNumVisitors = Integer.parseInt(args[0]); // Determine the number of visitors simulated
            int visitorsSpawned = 0;
            int prayersSpawned = 0;
            int pilgrimsSpawned = 0;

            while (true) {
                
                // spawn new visitors; prayers and pilgrims
                for (Pathway pathway : haram.outerPathways) {
                    if ((haram.visitors.size() < maxNumVisitors) && (visitorsSpawned < maxNumVisitors)) {
                        haram.visitors.add(haram.spawnVisitor(pathway));
                        pathway.incrementCurrentVisitors();
                        if (haram.visitors.get(haram.visitors.size() - 1) instanceof Prayer)
                            prayersSpawned++;
                        else
                            pilgrimsSpawned++;
                        visitorsSpawned++;
                    }
                }

                // move visitors
                haram.moveVisitors(15); // argument is visitor speed, in 'duration units per second', default is 1
                
                System.out.println(String.format("\n---- Time: %02d:%02d | Visitors: %d ----", haram.timeElapsedSecs / 60,
                    haram.timeElapsedSecs % 60, haram.visitors.size()));

                haram.printVisitorsStatus();
                haram.printCapacities();
                haram.timeElapsedSecs++;
                
                Platform.runLater(() -> gui.setTimeElapsedLabelValue(String.format("%02d:%02d", haram.timeElapsedSecs / 60,
                haram.timeElapsedSecs % 60)));
                
                
                haram.updateGUI(gui.getPrayLocationsViews(), gui.getPathwaysViews(), gui.getMasaaViews(), gui.getSahanView());
                haram.updateTooltips(gui.getPrayLocationTooltips());
                
                // Control the speed of the simulation
                try {
                    Thread.sleep(Long.parseLong(args[1])); // adjust argument to control simulation delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if ((visitorsSpawned >= maxNumVisitors) && (haram.visitors.isEmpty())) {
                    System.out.println(String.format(
                            "Finished - Time: %02d:%02d | All %d visitors have exited.\n %d prayers\n %d pilgrims",
                            haram.timeElapsedSecs / 60, haram.timeElapsedSecs % 60, maxNumVisitors, prayersSpawned,
                            pilgrimsSpawned));
                    haram.printAnalytics();
                    break;
                }

                 if (stopLoop) {
                    System.out.println(String.format(
                            "Interrupted - Time: %02d:%02d | current visitors %d",
                            haram.timeElapsedSecs / 60, haram.timeElapsedSecs % 60, haram.visitors.size()));
                    haram.printAnalytics();
                    break;
                }
            }
        });

        loopThread.start();
    }
    public void terminate() {
        Haram.stopLoop = true;
    }

    private void printAnalytics() {
        // longest staying visitor; duration of stay
        Visitor longestStayingVisitor = visitorsExited.get(0);
        for (Visitor visitor : visitorsExited) {
            if (visitor.getSecondsSpentInHaram() > longestStayingVisitor.getSecondsSpentInHaram()) {
                longestStayingVisitor = visitor;
            }
        }
        System.out.printf("Visitor#%d stayed the longest, total time: %02d:%02d",
        longestStayingVisitor.getId(), longestStayingVisitor.getSecondsSpentInHaram() / 60, longestStayingVisitor.getSecondsSpentInHaram() % 60);

        // average pilgrim stay time
        int totalNumberOfSecondsSpentByPilgrims = 0;
        int numberOfPilgrims = 0;
        for (Visitor visitor : visitorsExited) {
            if (visitor instanceof Pilgrim) {
                totalNumberOfSecondsSpentByPilgrims += visitor.getSecondsSpentInHaram();
                numberOfPilgrims++;
            }
        } 
        int averageNumberOfSeconds = totalNumberOfSecondsSpentByPilgrims / numberOfPilgrims;
        System.out.printf("\nAverage time spent (Pilgrims): %02d:%02d", averageNumberOfSeconds / 60, averageNumberOfSeconds % 60);
        
        // average prayer stay time
        int totalNumberOfSecondsSpentByPrayers = 0;
        int numberOfPrayers = 0;
        for (Visitor visitor : visitorsExited) {
            if (visitor instanceof Prayer) {
                totalNumberOfSecondsSpentByPrayers += visitor.getSecondsSpentInHaram();
                numberOfPrayers++;
            }
        } 
        averageNumberOfSeconds = totalNumberOfSecondsSpentByPrayers / numberOfPrayers;
        System.out.printf("\nAverage time spent (Prayers): %02d:%02d", averageNumberOfSeconds / 60, averageNumberOfSeconds % 60);
        
        // most visited location?
        // duration of time for which locations were completely full
    }

    private void updateTooltips (ArrayList<Tooltip> prayLocationsTooltips) {
        for (int i = 0; i < prayLocationsTooltips.size(); i++) {
            Tooltip locationTooltip = prayLocationsTooltips.get(i);
            PrayLocation location = prayLocations.get(i);
            locationTooltip.setText("-" + location.getName() + "-"
            + "\nCapacity: " + location.getCapacity()
            + "\nCurrent Visitors: " + location.getNumberOfCurrentVisitors());
        }
    }

    private void updateGUI(ArrayList<ImageView> prayLocationViews, ArrayList<ImageView> pathwayViews, ArrayList<ImageView> masaaViews, ImageView sahanView) {

        // outer pathways
        for (int i = 0; i < outerPathways.size(); i++) {
            if (outerPathways.get(i).getAvailableCapacityRatio() > 0.75) {
                adjustColor(pathwayViews.get(i), 1);
            }
            else if (outerPathways.get(i).getAvailableCapacityRatio() > 0.25) {
                adjustColor(pathwayViews.get(i), 2);
            }
            else {
                adjustColor(pathwayViews.get(i), 0);
            }
        }
        
        // inner pathways
        for (int i = 0; i < pathways.size(); i++) {
            if (pathways.get(i).getAvailableCapacityRatio() > 0.75) {
                adjustColor(pathwayViews.get(i + 6), 1);
            }
            else if (pathways.get(i).getAvailableCapacityRatio() > 0.25) {
                adjustColor(pathwayViews.get(i + 6), 2);
            }
            else {
                adjustColor(pathwayViews.get(i + 6), 0);
            }
        }

        // pray locations
        for (int i = 0; i < prayLocations.size(); i++) {
            if (prayLocations.get(i).getAvailableCapacityRatio() > 0.75) {
                adjustColor(prayLocationViews.get(i), 1);
            }
            else if (prayLocations.get(i).getAvailableCapacityRatio() > 0.25) {
                adjustColor(prayLocationViews.get(i), 2);
            }
            else {
                adjustColor(prayLocationViews.get(i), 0);
            }
        }
        
        // masaa
        for (int i = 0; i < masaaLanes.size(); i++) {
            if (masaaLanes.get(i).getAvailableCapacityRatio() > 0.75) {
                adjustColor(masaaViews.get(i), 1);
            }
            else if (masaaLanes.get(i).getAvailableCapacityRatio() > 0.25) {
                adjustColor(masaaViews.get(i), 2);
            }
            else {
                adjustColor(masaaViews.get(i), 0);
            }
        }
        
        // sahan
        if (sahan.getAvailableCapacityRatio() > 0.75) {
            adjustColor(sahanView, 1);
        }
        else if (sahan.getAvailableCapacityRatio() > 0.25) {
            adjustColor(sahanView, 2);
        }
        else {
            adjustColor(sahanView, 0);
        }
    }

    private void adjustColor(ImageView imageView, int colorCode) {
        switch (colorCode) {
            case 0: // -> default; Blue
                ColorAdjust defaultColor = new ColorAdjust();
                defaultColor.setHue(0);
                imageView.setEffect(defaultColor);
                break;
            case 1: // Blue -> Red
                ColorAdjust blueToRed = new ColorAdjust();
                blueToRed.setHue(0.8);
                imageView.setEffect(blueToRed);
                break;
            case 2: // Blue -> Yellow
                ColorAdjust blueToYellow = new ColorAdjust();
                blueToYellow.setHue(0.999);
                imageView.setEffect(blueToYellow);
                break;
        }
    }

    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    public void moveVisitors(int speed) {
        for (Visitor visitor : visitors) {
            visitor.move(speed); // argument is a movement speed multiplier; default: 1
            visitor.incrementSecondsSpent();
        }

        // The two loops below are responsible for removing visitors
        ArrayList<Visitor> toBeRemoved = new ArrayList<>();
        for (Visitor visitor : visitors) {
            if (visitor.hasCompletedPurpose() && !toBeRemoved.contains(visitor)) {
                toBeRemoved.add(visitor);
            }
        }

        for (int i = 0; !toBeRemoved.isEmpty() && (i < toBeRemoved.size()); i++) {
            if (toBeRemoved.get(i).hasCompletedPurpose() && !toBeRemoved.get(i).hasNextRouteComponent()) {
                toBeRemoved.get(i).getCurrentLocation().decrementCurrentVisitors();
                visitorsExited.add(toBeRemoved.get(i));
                visitors.remove(toBeRemoved.get(i));
                System.out.println("visitor#" + toBeRemoved.get(i).getId() + " exit");
                toBeRemoved.remove(toBeRemoved.get(i));
            }
        }

    }

public PrayLocation findVacantPrayLocation() {
        PrayLocation vacantLocationCandidate = prayLocations.get(random.nextInt(prayLocations.size()));
        while (true) {
            vacantLocationCandidate = prayLocations.get(random.nextInt(prayLocations.size()));
            if (vacantLocationCandidate.hasSpace()) {
                return vacantLocationCandidate;
            }
        }
    }

    // Print simulation data
    public void printVisitorsStatus() {
        for (Visitor visitor: visitors) {
            System.out.println((String.format(visitor.returnStatus() + "\nDestination: %s" , 
            visitor.getRouteComponents().get(visitor.getRouteComponents().isEmpty()? 0 : visitor.getRouteComponents().size() - 1))));
            System.out.print(String.format("Progress: %d/%d", visitor.getProgressInCurrentLocation(), visitor.getCurrentLocation().getDuration()));
            System.out.println(String.format("\nStatus: %s", visitor.getStatus().toString()));
            System.out.print("\n\t***Visitor Route***");
            System.out.println("\n ---------------------------------");
            System.out.printf("| No.%6s %-20s |\n","|","Location");
            System.out.println(" ---------------------------------");
            int NumberOfDestination = 1;
            for (Commutable routeComponent: visitor.getRouteComponents()) {
               System.out.printf("| #%-6d %s %-20s |\n",NumberOfDestination,"|",routeComponent.getName());
                NumberOfDestination++;
            }
            System.out.println(" ---------------------------------");
            System.out.println("");
            System.out.println("");
            System.out.println("==================================");
            System.out.println("");
            System.out.println("");
        }
    }

    public void printCapacities() {    
        System.out.println("\n\n=====================================");

        System.out.print("\n***Current outter pathways capacities***\n\n");
        for (Commutable outerPathway : outerPathways) {
     
            System.out.println("--------------------");
            System.out.printf("%s | %f %n", outerPathway.getName(), outerPathway.getAvailableCapacityRatio());

        }
            System.out.println("--------------------");

            System.out.println("\n\n=====================================");

        System.out.print("\n***Current building capacities***\n\n");
        for (Commutable building : buildings) {
             System.out.println("--------------------------------");

            System.out.printf("%-20s %3s %f \n", building.getName(),"|", building.getAvailableCapacityRatio());
        }
             System.out.println("--------------------------------");

            System.out.println("\n\n=====================================");
        System.out.print("\n***Current PrayLocation capacities***\n\n");
        for (Commutable praylocation : prayLocations) {
            System.out.println("--------------------");
            System.out.printf("%-7s %s %f %n", praylocation.getName(),"|", praylocation.getAvailableCapacityRatio());
        }
            System.out.println("-----------------------");

            System.out.println("\n\n=====================================");

        System.out.print("\n***Current inner Pathway capacities***\n\n");
        for (Commutable innerPathway : pathways) {
            System.out.println("-----------------------");
            System.out.printf("%s | %f %n", innerPathway.getName(), innerPathway.getAvailableCapacityRatio());
        }
            System.out.println("--------------------");
            System.out.println("\n\n=====================================");

        System.out.print("\n***Current Sahan capacities***\n\n");
        System.out.println("-----------------------");
        System.out.printf("%s | %f %n", sahan.getName(), sahan.getAvailableCapacityRatio());
        System.out.println("-----------------------");
        System.out.println("\n\n=====================================");

        System.out.print("\n***Current Massa lanes capacities***\n\n");
        for (Commutable lane : masaaLanes) {
            System.out.println("-----------------------------");
            System.out.printf("%s | %f %n", lane.getName(), lane.getAvailableCapacityRatio());
        }
            System.out.println("-----------------------------");
            System.out.println("\n\n=====================================\n");
    }

    // public void printCapacities() {
    //         System.out.println("\n\n=====================================");

    //     System.out.print("\n***Current outter pathways capacities***\n\n");
    //     for (Commutable outerPathway : outerPathways) {
     
    //         System.out.println("--------------------");
    //         System.out.printf("%s | %f %n", outerPathway.getName(), outerPathway.getAvailableCapacityRatio());

    //     }
    //         System.out.println("--------------------");

    //         System.out.println("\n\n=====================================");

    //     System.out.print("\n***Current building capacities***\n\n");
    //     for (Commutable building : buildings) {
    //          System.out.println("--------------------------------");

    //         System.out.printf("%-20s %3s %f \n", building.getName(),"|", building.getAvailableCapacityRatio());
    //     }
    //          System.out.println("--------------------------------");

    //         System.out.println("\n\n=====================================");
    //     System.out.print("\n***Current PrayLocation capacities***\n\n");
    //     for (Commutable praylocation : prayLocations) {
    //         System.out.println("--------------------");
    //         System.out.printf("%-7s %s %f %n", praylocation.getName(),"|", praylocation.getAvailableCapacityRatio());
    //     }
    //         System.out.println("-----------------------");

    //         System.out.println("\n\n=====================================");

    //     System.out.print("\n***Current inner Pathway capacities***\n\n");
    //     for (Commutable innerPathway : pathways) {
    //         System.out.println("-----------------------");
    //         System.out.printf("%s | %f %n", innerPathway.getName(), innerPathway.getAvailableCapacityRatio());
    //     }
    //         System.out.println("--------------------");
    //         System.out.println("\n\n=====================================");

    //     System.out.print("\n***Current Sahan capacities***\n\n");
    //     System.out.println("-----------------------");
    //     System.out.printf("%s | %f %n", sahan.getName(), sahan.getAvailableCapacityRatio());
    //     System.out.println("-----------------------");
    //     System.out.println("\n\n=====================================");

    //     System.out.print("\n***Current Massa lanes capacities***\n\n");
    //     for (Commutable lane : masaaLanes) {
    //         System.out.println("-----------------------------");
    //         System.out.printf("%s | %f %n", lane.getName(), lane.getAvailableCapacityRatio());
    //     }
    //         System.out.println("-----------------------------");
    //         System.out.println("\n\n=====================================\n");

    // }

    public Visitor spawnVisitor(Pathway pathway) {
        int visitorTypeDeterminator = random.nextInt(2); // returns either 0 for prayer, or 1 for pilgrim

        switch (visitorTypeDeterminator) {
            case 0:
                Prayer newPrayer = new Prayer(pathway);
                newPrayer.setCurrentPathway(pathway);
                newPrayer.assignRoute(findVacantPrayLocation());
                return newPrayer;
            case 1:
                Pilgrim newPilgrim = new Pilgrim(pathway);
                assignRouteForPilgrim(newPilgrim);
                return newPilgrim;
        }
        return null;
    }

    public void assignRouteForPilgrim(Pilgrim pilgrim) {
        ArrayList<Commutable> routeToTawaf = new ArrayList<>();
        ArrayList<Commutable> routeToPrayLocation = new ArrayList<>();
        ArrayList<Commutable> routeToMasaa = new ArrayList<>();
        ArrayList<Commutable> exitRoute = new ArrayList<>();

        routeToTawaf = pilgrim.findRoute(pilgrim.getCurrentLocation(), sahan.findVacantTawafPath());
        routeToPrayLocation = pilgrim.findRoute(routeToTawaf.get(routeToTawaf.size() - 1), findVacantPrayLocation());
        routeToMasaa = pilgrim.findRoute(routeToPrayLocation.get(routeToPrayLocation.size() - 1), masaaLanes.get(0));
        exitRoute = pilgrim.findRoute(routeToMasaa.get(routeToMasaa.size() - 1), outerPathways.get(0));

        ArrayList<Commutable> assembledRoute = new ArrayList<>();
        assembledRoute.addAll(routeToTawaf);

        routeToPrayLocation.remove(0); // remove duplication
        assembledRoute.addAll(routeToPrayLocation);

        routeToMasaa.remove(0);
        assembledRoute.addAll(routeToMasaa);

        exitRoute.remove(0);
        assembledRoute.addAll(exitRoute);

        pilgrim.setRouteComponents(assembledRoute);
    }

}