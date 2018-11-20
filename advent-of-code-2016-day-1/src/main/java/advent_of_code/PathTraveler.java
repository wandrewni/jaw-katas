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

    public void travel(String step) {
        if ("".equals(step)) return;

        adjustOrientation(step);

        x -= Integer.valueOf(step.substring(1));
    }

    private void adjustOrientation(String step) {
        if (step.startsWith("R")) {
            turnRight();
        } else {
            turnLeft();
        }
    }

    private void turnLeft() {
        orientation++;
        if (orientation == directions.length) {
            orientation = 0;
        }
    }

    private void turnRight() {
        orientation--;
        if (orientation < 0) {
            orientation = 3;
        }
    }

}
