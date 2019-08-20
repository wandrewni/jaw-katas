package advent_of_code;

import advent_of_code.PathTraveler.Compass.Direction;

import static advent_of_code.PathTraveler.Compass.Direction.*;

public class PathTraveler {
    private final Compass compass = new Compass();
    private int x;
    private int y;

    public Direction getOrientation() {
        return compass.getOrientation();
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
            compass.adjustOrientation(step.charAt(0));
            final Integer distance = Integer.valueOf(step.substring(1));
            travel(distance, compass.getOrientation());
        }
    }

    private void travel(Integer distance, Direction direction) {
        if (direction == W) x -= distance;
        else if (direction == S) y -= distance;
        else if (direction == E) x += distance;
        else y += distance;
    }

    int getTravelDistance() {
        return Math.abs(x) + Math.abs(y);
    }

    public static class Compass {
        private static final Direction[] directions = new Direction[]{N, W, S, E};
        private int orientation = 0;

        private void adjustOrientation(char direction) {
            if (direction == 'R') turnRight();
            else turnLeft();
        }

        private void turnLeft() {
            orientation++;
            if (orientation == directions.length) orientation = 0;
        }

        private void turnRight() {
            orientation--;
            if (orientation < 0) orientation = 3;
        }

        Direction getOrientation() {
            return directions[orientation];
        }
        public enum Direction{N, E, S, W}
    }
}
