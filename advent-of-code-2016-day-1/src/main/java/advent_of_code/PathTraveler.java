package advent_of_code;

import static advent_of_code.ChristmasCoordinates.Direction.*;

public class PathTraveler {
    private static final ChristmasCoordinates.Direction[] directions = new ChristmasCoordinates.Direction[] {N, W, S, E};
    private int orientation = 0;
    private int x;
    private int y;

    public ChristmasCoordinates.Direction getOrientation() {
        return directions[orientation];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void travel(String directions) {
        if ("".equals(directions)) return;

        if (directions.startsWith("R"))
            orientation--;
        else
            orientation++;

        if (orientation == 4)
            orientation = 0;
        else if (orientation == -1)
            orientation = 3;
    }
}
