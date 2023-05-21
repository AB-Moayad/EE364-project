public enum Direction {
    in(1),
    out(0),
    inAndOut(2);

    private final int key;

    Direction(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    
}

