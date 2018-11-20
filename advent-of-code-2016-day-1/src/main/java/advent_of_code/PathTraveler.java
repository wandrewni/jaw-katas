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
        for (String step : steps)
            travel(step.charAt(0), Integer.valueOf(step.substring(1)));
    }

    private void travel(char direction, Integer distance) {
        adjustOrientation(direction);
        travel(distance);
    }

    private void adjustOrientation(char direction) {
        if (direction == 'R') turnRight();
        else turnLeft();
    }

    private void travel(Integer distance) {
        final ChristmasCoordinates.Direction orientation = getOrientation();
        if (orientation == W) x -= distance;
        else if (orientation == S) y -= distance;
        else if (orientation == E) x += distance;
        else y += distance;
    }

    private void turnLeft() {
        orientation++;
        if (orientation == directions.length) orientation = 0;
    }

    private void turnRight() {
        orientation--;
        if (orientation < 0) orientation = 3;
    }

}
