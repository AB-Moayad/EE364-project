import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Haram {
    public ArrayList<PrayLocation> prayLocations = new ArrayList<>();
    public ArrayList<Pathway> pathways = new ArrayList<>();
    public ArrayList<Pathway> outerPathways = new ArrayList<>();
    public Sahan sahan;
    public ArrayList<Masaa> masaaLanes = new ArrayList<>();
    public ArrayList<Building> buildings = new ArrayList<>();
    public ArrayList<Visitor> visitors = new ArrayList<>();
    public ArrayList<Gate> gates = new ArrayList<>();
    public ArrayList<HaramFacility> facilities = new ArrayList<>();
    public int timeElapsedSecs;

    static Random random = new Random();

    public static boolean stopLoop;
    


    Haram() {
        String[] defaultPrayLocationsNames = { "Area 1", "Area 2", "Area 3", "Area 4", "Area 5",
                "Area 6", "Area 7", "Area 8", "Area 9", "Area 10", };
        String[] defaultOuterPathways = { "Pathway 1", "Pathway 2", "Pathway 3", "Pathway 4",
                "Pathway 5", "Pathway 6" };
        String[] defaultInnerPathways = { "Pathway 7", "Pathway 8", "Pathway 9", "Pathway 10",
                "Pathway 11", "Pathway 12", "Pathway 13" };
        String[] defaultGateNames = { "King Fahd", "Umra", "Fateh", "King Abdulaziz" };
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
         * ***** NOTES *****
         * The class 'Gate' has not been used yet.
         * 
         * 
         * To set the number of visitors to be simulated, adjust the variable
         * "maxNumVisitors" within main.
         * To determine the type of visitors to be spawned, adjust the determinator in
         * the switch statement in the method "spawnVisitor"
         */

        /*
         * For the following initializatoins refer to the Mosque diagram; 'Mosque
         * Map.pptx'
         */
        

        // initialize pray locations
        for (String prayLocationName : defaultPrayLocationsNames) {
            prayLocations.add(new PrayLocation(prayLocationName, 2)); 
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

        Commutable[] masaaIntersections = { masaaLanes.get(0), masaaLanes.get(1) };
        buildings.get(2).setIntersections(new ArrayList<Commutable>(Arrays.asList(masaaIntersections)));

        // Massa lanes intersections initialization
        Commutable[] massaLane1Intersections = {masaaLanes.get(1), pathways.get(6) };
        masaaLanes.get(0).setIntersections(new ArrayList<Commutable>(Arrays.asList(massaLane1Intersections)));

        Commutable[] massaLane2Intersections = { buildings.get(2), masaaLanes.get(0),
                pathways.get(6) };
        masaaLanes.get(1).setIntersections(new ArrayList<Commutable>(Arrays.asList(massaLane2Intersections)));
    }

    public static void main(String[] args, MyApp myApp) {
        Thread loopThread = new Thread(() -> {
            Haram haram = new Haram();
            MyApp gui = myApp;

            
            
            // boolean maxNumReached = false;
            int maxNumVisitors = Integer.parseInt(args[0]); // Determine the number of visitors simulated
            int visitorsSpawned = 0;
            int prayersSpawned = 0;
            int pilgrimsSpawned = 0;

            while (true) {
                
                // spawn new visitors; prayers and pilgrims
                for (Pathway pathway : haram.outerPathways) {
                    if ((haram.visitors.size() < maxNumVisitors) && (visitorsSpawned < maxNumVisitors)) {
                        haram.visitors.add(haram.spawnVisitor(pathway));
                        haram.visitors.get(haram.visitors.size() - 1).getCurrentLocation().incrementCurrentVisitors();
                        if (haram.visitors.get(haram.visitors.size() - 1) instanceof Prayer)
                            prayersSpawned++;
                        else
                            pilgrimsSpawned++;
                        visitorsSpawned++;
                        // pathway.incrementCurrentVisitors();
                    }
                }

                // move visitors
                haram.moveVisitors(15); // argument is visitor speed, in 'duration units per second', default is 1

                // TODO: organizers make decisions

                System.out.println(String.format("---- Time: %02d:%02d | Visitors: %d ----", haram.timeElapsedSecs / 60,
                    haram.timeElapsedSecs % 60, haram.visitors.size()));
                System.out.print(" ");
                haram.printVisitorsStatus();
                haram.printCapacities();
                haram.timeElapsedSecs++;
                
                Platform.runLater(() -> gui.setTimeElapsedLabelValue(String.format("%02d:%02d", haram.timeElapsedSecs / 60,
                haram.timeElapsedSecs % 60)));
                
                
                haram.updateGUI(gui.getPrayLocationsViews(), gui.getPathwaysViews(), gui.getMasaaViews(), gui.getSahanView());
                
                // Control the speed of the simulation
                try {
                    Thread.sleep(Long.parseLong(args[1])); // adjust argument to control simulation speed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                if ((visitorsSpawned >= maxNumVisitors) && (haram.visitors.isEmpty())) {
                    System.out.println(String.format(
                            "Finished - Time: %02d:%02d | All %d visitors have exited.\n %d prayers\n %d pilgrims",
                            haram.timeElapsedSecs / 60, haram.timeElapsedSecs % 60, maxNumVisitors, prayersSpawned,
                            pilgrimsSpawned));
                    break;
                }

                if (stopLoop) {
                    System.out.println(String.format(
                            "Interrupted - Time: %02d:%02d | current visitors %d",
                            haram.timeElapsedSecs / 60, haram.timeElapsedSecs % 60, haram.visitors.size()));
                    break;
                }
                
            }
        });

        loopThread.start();
    }

    public void terminate() {
        Haram.stopLoop = true;
    }

    private void updateGUI(ArrayList<ImageView> prayLocationViews, ArrayList<ImageView> pathwayViews, ArrayList<ImageView> masaaViews, ImageView sahanView) {
        // System.out.println("updateGUI called");

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


    // private static void updateColor(ImageView image) {
    //     ColorAdjust colorAdjust = new ColorAdjust();
    //     Haram haram = new Haram();
    //     for (Pathway pathway : haram.pathways){
    //         if (pathway.getAvailableCapacityRatio() >= 100){
    //             colorAdjust.setHue(0.0);
    //         }else if (pathway.getAvailableCapacityRatio() >= 50){
    //             colorAdjust.setHue(-0.66); //blue
    //         }else {
    //         colorAdjust.setHue(-0.16); //Yellow
    //     }
    //     }
    //     image.setEffect(colorAdjust);
    // }

    // public static void fx_updateElapsedTime(Label label, String time) {
    //     label.setText(time);
    //     System.out.println("updataElapsed CALLED");
    // }

    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    // public void exitVisitor(Visitor visitor) {
    // if (visitor.arrangeExit()) {
    // visitors.remove(visitor);
    // }
    // }

    public void moveVisitors(int speed) {
        for (Visitor visitor : visitors) {
            visitor.move(speed); // argument is a movement speed multiplier; default: 1
        }

        // The two loops below are responsible for removing visitors
        ArrayList<Visitor> toBeRemoved = new ArrayList<>();
        for (Visitor visitor : visitors) {
            if (visitor.completedPurpose && !toBeRemoved.contains(visitor)) {
                toBeRemoved.add(visitor);
            }
        }

        for (int i = 0; !toBeRemoved.isEmpty() && (i < toBeRemoved.size()); i++) {
            if (toBeRemoved.get(i).completedPurpose && !toBeRemoved.get(i).hasNextRouteComponent()) {
                toBeRemoved.get(i).getCurrentLocation().decrementCurrentVisitors();
                visitors.remove(toBeRemoved.get(i));
                System.out.println("    -removed visitor#" + toBeRemoved.get(i).getId());
                toBeRemoved.remove(toBeRemoved.get(i));
            }
        }

    }

    public PrayLocation findVacantPrayLocation() {
        // for (PrayLocation location : prayLocations) {
        //     if (location.hasSpace()) {
        //         return location;
        //     }
        // }
        // return null;

        PrayLocation vacantLocationCandidate = prayLocations.get(random.nextInt(prayLocations.size()));
        while (true) {
            vacantLocationCandidate = prayLocations.get(random.nextInt(prayLocations.size()));
            if (vacantLocationCandidate.hasSpace()) {
                return vacantLocationCandidate;
            }
        }
    }

    public void printVisitorsStatus() {
        for (Visitor visitor : visitors) {
            System.out.println(visitor.returnStatus() + " - Destination: " +
                    visitor.routeComponents
                            .get(visitor.routeComponents.isEmpty() ? 0 : visitor.routeComponents.size() - 1));
            System.out.print(String.format("    Progress: %d/%d", visitor.progressInCurrentLocation,
                    visitor.getCurrentLocation().getDuration()));
            System.out.println(String.format("    Status: %s", visitor.getStatus().toString()));
            System.out.print("    Route: ");
            for (Commutable routeComponent : visitor.routeComponents) {
                System.out.print(routeComponent.getName() + ", ");
            }
            System.out.println("");
        }
    }

    public void printCapacities() {
        System.out.print("Current outter pathways capacities\n\t");
        for (Commutable outerPathway : outerPathways) {
            System.out
                    .print(String.format("%s: %f; ", outerPathway.getName(), outerPathway.getAvailableCapacityRatio()));
        }

        System.out.print("\nCurrent building capacities\n\t");
        for (Commutable building : buildings) {
            System.out.print(String.format("%s: %f; ", building.getName(), building.getAvailableCapacityRatio()));
        }

        System.out.print("\nCurrent PrayLocation capacities\n\t");
        for (Commutable praylocation : prayLocations) {
            System.out
                    .print(String.format("%s: %f; ", praylocation.getName(), praylocation.getAvailableCapacityRatio()));
        }

        System.out.print("\nCurrent inner Pathway capacities\n\t");
        for (Commutable innerPathway : pathways) {
            System.out
                    .print(String.format("%s: %f; ", innerPathway.getName(), innerPathway.getAvailableCapacityRatio()));
        }

        System.out.print("\nCurrent Sahan capacities\n\t");
        System.out.print(String.format("%s: %f; ", sahan.getName(), sahan.getAvailableCapacityRatio()));

        System.out.print("\nCurrent Massa lanes capacities\n\t");
        for (Commutable lane : masaaLanes) {
            System.out.print(String.format("%s: %f; ", lane.getName(), lane.getAvailableCapacityRatio()));
        }

        System.out.println();
    }

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
        // System.out.println(routeToTawaf.get(routeToTawaf.size() - 1));
        // System.out.println(findVacantPrayLocation());
        // System.out.println(routeToPrayLocation);
        routeToMasaa = pilgrim.findRoute(routeToPrayLocation.get(routeToPrayLocation.size() - 1), masaaLanes.get(0));

        exitRoute = pilgrim.findRoute(routeToMasaa.get(routeToMasaa.size() - 1), outerPathways.get(0));
        // System.out.println("###Exit Route" + exitRoute);

        ArrayList<Commutable> assembledRoute = new ArrayList<>();
        assembledRoute.addAll(routeToTawaf);

        routeToPrayLocation.remove(0); // remove duplication
        assembledRoute.addAll(routeToPrayLocation);

        routeToMasaa.remove(0);
        assembledRoute.addAll(routeToMasaa);

        exitRoute.remove(0);
        assembledRoute.addAll(exitRoute);

        pilgrim.routeComponents = assembledRoute;
    }

}
