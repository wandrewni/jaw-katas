package advent_of_code;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PathTravelerTest {
    @Test
    public void pathTraveler() {
        PathTraveler pathTraveler = new PathTraveler();
        assertEquals(ChristmasCoordinates.Direction.N, pathTraveler.getOrientation());
        assertEquals(0, pathTraveler.getX());
        assertEquals(0, pathTraveler.getY());
    }
}
