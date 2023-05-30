import java.util.ArrayList;
import java.util.Collections;

public abstract class Visitor {
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

    Visitor(Pathway pathway) {
        this.currentLocation = pathway;
        this.completedPurpose = false;
        this.status = VisitorStatus.commuting;
          
        id = ++numberOfVisitors;
        

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

    public void continueRoute() {
        if (hasNextRouteComponent()) {
            currentRouteComponentIndex++;
            this.currentLocation = routeComponents.get(currentRouteComponentIndex);
            progressInCurrentLocation = 0;
        }
        else {
            arrangeExit();
            System.out.println("###exit arranged");
        }
    }


    protected boolean hasNextRouteComponent() {
        return currentRouteComponentIndex < (routeComponents.size() - 1);
    }

    public boolean arrangeExit() {
        System.out.println("------exit arranged for visitor#" + getId());
        // currently, this compels visitors to return from the same entry route
        if (completedPurpose) {
            // Haram.getVisitors().remove(this);
            // numberOfVisitors--;
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

        routeDFS(location, target, route, visited);
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

    public ArrayList<Commutable> getRouteComponents() {
        return routeComponents;
    }

   
    public void addToRoute(Commutable component) {
        this.routeComponents.add(component);
    }

    public void removeFromRoute(Commutable component) {

    }

    public VisitorStatus getStatus() {
        return status;
    }

    public void setStatus(VisitorStatus status) {
        this.status = status;
    }

    public abstract String returnStatus();
    public abstract void updateStatus();


}
