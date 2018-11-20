package advent_of_code;

public class PathTraveler {
    private ChristmasCoordinates.Direction orientation = ChristmasCoordinates.Direction.N;
    private int x;
    private int y;

    public ChristmasCoordinates.Direction getOrientation() {
        return orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void travel(String directions) {
        if ("".equals(directions)) return;

        switch (orientation) {
            case W:
                orientation = ChristmasCoordinates.Direction.S;
                break;
            case S:
                orientation = ChristmasCoordinates.Direction.E;
                break;
            case E:
                orientation = ChristmasCoordinates.Direction.N;
                break;
            default:
                orientation = ChristmasCoordinates.Direction.W;
                break;
        }
    }
}
