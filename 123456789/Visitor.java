import java.util.ArrayList;
import java.util.Collections;

public abstract class Visitor {
    //Instances 
    private int id;
    private static int numberOfVisitors;
    private ArrayList<HaramTarget> targets = new ArrayList<>();
    protected ArrayList<Commutable> routeComponents = new ArrayList<>();
    private Commutable currentLocation;
    private int currentRouteComponentIndex;
    protected int progressInCurrentLocation; // range [0, 100], 100 for completion
    private double progressRatio; // range [0.0, 1.0]
    protected VisitorStatus status;
    protected boolean completedPurpose;

    //Constructor takes pathway
    Visitor(Pathway pathway) {
        this.currentLocation = pathway;
        this.completedPurpose = false;
        this.status = VisitorStatus.commuting;

        id = ++numberOfVisitors;
    }
    
    public void move(int multiplier) {
        if (currentLocation instanceof Pathway) {
            if ((progressInCurrentLocation + 1) < currentLocation.getDuration()) {
                progressInCurrentLocation += 1 * multiplier;
            } else continueRoute();
        }
        else if (currentLocation instanceof PrayLocation) {
            if ((progressInCurrentLocation + 1) < currentLocation.getDuration()) {
                progressInCurrentLocation += 2 * multiplier;
            } else continueRoute();
        } 
        else if (currentLocation instanceof Building) {
            if ((progressInCurrentLocation + 1) < currentLocation.getDuration()) {
                progressInCurrentLocation += 1 * multiplier;
            } else continueRoute();
        }
        else {
            if ((progressInCurrentLocation + 1) < currentLocation.getDuration()) {
                progressInCurrentLocation += 1 * multiplier;
            } else continueRoute();
        }
        updateStatus();
    }

    //making the visitor complete his route component 
    public void continueRoute() {
        if (hasNextRouteComponent()) {
            currentLocation.decrementCurrentVisitors();
            currentRouteComponentIndex++;
            this.currentLocation = routeComponents.get(currentRouteComponentIndex);
            currentLocation.incrementCurrentVisitors();
            progressInCurrentLocation = 0;
        }
        else {
            arrangeExit();
        }
    }

    //check the list of route componenet (the places that the visitor need to attend to) if the visitor is still hasn't finished his list
    protected boolean hasNextRouteComponent() {
        return currentRouteComponentIndex < (routeComponents.size() - 1);
    }

    public boolean arrangeExit() {
        if (completedPurpose) {
            return true;
        } 
        else {
            Collections.reverse(routeComponents);
            this.currentRouteComponentIndex = 0;
            this.completedPurpose = true;
            return false;
        }
    }

    public void assignRoute(Commutable targetLocation) {
        this.routeComponents = findRoute(targetLocation);
    }

    public ArrayList<Commutable> findRoute(Commutable target) {
        ArrayList<Commutable> route = new ArrayList<>();
        ArrayList<Commutable> visited = new ArrayList<>(); // control ArrayList for the DFS function

        routeDFS(currentLocation, target, route, visited);

        Collections.reverse(route);
        
        return route;
    }
    
    public ArrayList<Commutable> findRoute(Commutable location, Commutable target) {
        ArrayList<Commutable> route = new ArrayList<>();
        ArrayList<Commutable> visited = new ArrayList<>(); // control ArrayList for the DFS function

        routeDFS2(location, target, route, visited);
        // System.out.println(visited);
        Collections.reverse(route);
        
        return route;
    }

    private boolean routeDFS (Commutable currentLocation, Commutable targetLocation,
    ArrayList<Commutable> route, ArrayList<Commutable> visited) {
        // Mark the current location as visited
        visited.add(currentLocation);

        // Check if the current location is the destination location
        if (currentLocation == targetLocation) {
            route.add(currentLocation);
            return true;
        }
        
        // Iterate through the intersections of the current location
        for (Commutable intersection: currentLocation.getIntersections()) {
            // Check if the intersection road is not visited
            if (!visited.contains(intersection)) {
                // Recursively perform DFS on the intersection location
                boolean foundLocation = routeDFS(intersection, targetLocation, route, visited);

                if (foundLocation) {
                    // If a location is found, add the current location to the route and return true
                    route.add(currentLocation);
                    return true;
                }
            }
        }

        return false;

    }

    private boolean routeDFS2 (Commutable currentLocation, Commutable targetLocation,
    ArrayList<Commutable> route, ArrayList<Commutable> visited) {
        // this version of routeDFS shuffles intersections before 

        // Mark the current location as visited
        visited.add(currentLocation);

        // Check if the current location is the destination location
        if (currentLocation == targetLocation) {
            route.add(currentLocation);
            return true;
        }
        
        // Iterate through the intersections of the current location
        
        ArrayList<Commutable> shuffledIntersections = currentLocation.getIntersections();
        Collections.shuffle(shuffledIntersections);

        for (Commutable intersection: shuffledIntersections) {
            // Check if the intersection road is not visited
            if (!visited.contains(intersection)) {
                // Recursively perform DFS on the intersection location
                boolean foundLocation = routeDFS2(intersection, targetLocation, route, visited);

                if (foundLocation) {
                    // If a location is found, add the current location to the route and return true
                    route.add(currentLocation);
                    return true;
                }
            }
        }

        return false;

    }

    public ArrayList<Commutable> getRouteComponents() {
        return routeComponents;
    }

   
    public void addToRoute(Commutable component) {
        this.routeComponents.add(component);
    }

    public void removeFromRoute(Commutable component) {

    }

    //getters & setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ArrayList<HaramTarget> getTargets() {
        return targets;
    }
    public void setTargets(ArrayList<HaramTarget> targets) {
        for (HaramTarget target: targets) {
            this.targets.add(target);
        }
    }
    public Commutable getCurrentLocation() {
        return currentLocation;
    }
    public void setCurrentPathway(Pathway currentPathway) {
        this.currentLocation = currentPathway;
    }
    public double getCurrenProgressRatio() {
        return progressInCurrentLocation / currentLocation.getDuration();
    }
    public void setProgressRatio(double ratio) {
        this.progressRatio = ratio;
    }

    public VisitorStatus getStatus() {
        return status;
    }

    public void setStatus(VisitorStatus status) {
        this.status = status;
    }

    public void setProgressRatio(Double progressRatio){
        this.progressRatio = progressRatio;
    }
    
    public double getProgressRatio(){
        return progressRatio;
    }

    public abstract String returnStatus();
    public abstract void updateStatus();



}