package advent_of_code;

import static advent_of_code.ChristmasCoordinates.Direction.*;

public class PathTraveler {
    private static final ChristmasCoordinates.Direction[] directions = new ChristmasCoordinates.Direction[]{N, W, S, E};
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

        final String[] steps = directions.replaceAll(" ", "").split(",");
        for (String step : steps) {
            adjustOrientation(step);

            travelDistance(Integer.valueOf(step.substring(1)));
        }
    }

    private void adjustOrientation(String step) {
        if (step.startsWith("R")) {
            turnRight();
        } else {
            turnLeft();
        }
    }

    private void travelDistance(Integer distance) {
        final ChristmasCoordinates.Direction orientation = getOrientation();
        if (orientation == W) x -= distance;
        else if (orientation == S) y -= distance;
        else if (orientation == E) x += distance;
        else y += distance;
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
