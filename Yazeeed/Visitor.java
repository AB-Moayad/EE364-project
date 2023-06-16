import java.util.ArrayList;
import java.util.Collections;

public abstract class Visitor {
    //Instances 
    private int id; // id of the visitor
    private static int numberOfVisitors; // total number of visitors
    private ArrayList<HaramTarget> targets = new ArrayList<>(); // list of Haram targets
    private ArrayList<Commutable> routeComponents = new ArrayList<>(); // list of route components
    private Commutable currentLocation; // current location of the visitor
    private int currentRouteComponentIndex; // index of the current route component in the list
    private int progressInCurrentLocation; // current progress
    private double progressRatio; // current progress ratio
    private VisitorStatus status; // current status of the visitor
    private boolean completedPurpose; // flag indicating whether the visitor has completed their purpose
    private int secondsSpentInHaram; // total seconds spent in the Haram


    /**
     * Constructs a Visitor object with the given Pathway as the starting location.
     * @param pathway pathway name
     */
    Visitor(Pathway pathway) {
        this.currentLocation = pathway;
        this.completedPurpose = false;
        this.status = VisitorStatus.commuting;

        id = ++numberOfVisitors;
    }
    
    /**
     * Moves the visitor by the given multiplier. 
     * If the current location is a Pathway, PrayLocation, or Building, the progress in current location increases by 1*multiplier.
     * If the progress in the current location equals or exceeds the duration of the current location, calls continueRoute().
     * @param multiplier
     */
    public void move(int multiplier) {
        if (currentLocation instanceof Pathway) {
            if ((progressInCurrentLocation + 1) < currentLocation.getDuration()) {
                progressInCurrentLocation += 1 * multiplier;
            } else continueRoute();
        }
        else if (currentLocation instanceof PrayLocation) {
            if ((progressInCurrentLocation + 1) < currentLocation.getDuration()) {
                progressInCurrentLocation += 1 * multiplier;
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
    
    /**
    * Continues the current route by setting the current location to the next route component in the list.
    * If there are no more route components, calls arrangeExit().
    */
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

    /**
    * Checks if there is a next route component in the list.
    * @return true if there is a next route component, false otherwise
    */
    protected boolean hasNextRouteComponent() {
        return currentRouteComponentIndex < (routeComponents.size() - 1);
    }
    
    /**
    * Assigns a route to the visitor from the current location to the given target location.
    * 
    * @param targetLocation the target location for the route
    */
    public boolean arrangeExit() {
        // currently, this compels visitors to return from the same entry route
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

    /**
    * Assigns a route to the visitor from the current location to the given target location.
    * 
    * @param targetLocation the target location for the route
    */
    public void assignRoute(Commutable targetLocation) {
        this.routeComponents = findRoute(targetLocation);
    }
    
    /**
     * Returns a list of route components from the current location to the given target location.
    * 
    * @param target the target location for the route
    * @return the list of route components from the current location to the target location
    */
    public ArrayList<Commutable> findRoute(Commutable target) {
        ArrayList<Commutable> route = new ArrayList<>();
        ArrayList<Commutable> visited = new ArrayList<>(); // control ArrayList for the DFS function

        routeDFS(currentLocation, target, route, visited);
        Collections.reverse(route);
        
        return route;
    }
    
    /** 
     * Returns a list of route components from the current location to the given target location and current location.
    * @param location current location 
    * @param target the target location for the route
    * @return the list of route components from the current location to the target location
    */
    public ArrayList<Commutable> findRoute(Commutable location, Commutable target) {
        ArrayList<Commutable> route = new ArrayList<>();
        ArrayList<Commutable> visited = new ArrayList<>(); // control ArrayList for the DFS function

        routeDFS2(location, target, route, visited);
        Collections.reverse(route);
        
        return route;
    }
    
    /**
    * find a route from the current location to the given target location.
    * 
    * @param current the current location 
    * @param target the target location 
    * @param route the current route found 
    * @param visited the list of visited locations 
    * @param tempRoute the temporary route used in the search
    * @return true if the target location is found, false otherwise
    */
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
    
    /**
     *  find a route from the current location to the given target location & target location , route and visited location .
     * 
     * @param currentLocation the current location
     * @param targetLocation  the target location
     * @param route the current route found 
     * @param visited the list of visited locations 
     * @return true if the target location is found, false otherwise
     */
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

    // Getters and Setters
    public ArrayList<Commutable> getRouteComponents() {
        return routeComponents;
    }

    public void setRouteComponents(ArrayList<Commutable> routeComponents) {
        this.routeComponents = routeComponents;
    }

   
    public void addToRoute(Commutable component) {
        this.routeComponents.add(component);
    }

    public void removeFromRoute(Commutable component) {

    }

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

    public int getProgressInCurrentLocation() {
        return progressInCurrentLocation;
    }

    public boolean hasCompletedPurpose() {
        return completedPurpose;
    }

    public int getSecondsSpentInHaram() {
        return secondsSpentInHaram;
    }

    public void incrementSecondsSpent() {
        secondsSpentInHaram++;
    }


}