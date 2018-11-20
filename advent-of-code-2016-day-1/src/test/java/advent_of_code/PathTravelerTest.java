package advent_of_code;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PathTravelerTest {

    private PathTraveler pathTraveler;

    @Before
    public void setUp() {
        pathTraveler = new PathTraveler();
    }

    @Test
    public void pathTraveler() {
        assertOrientation("N");
        assertCoordinates(0, 0);
    }

    @Test
    public void initialPositioning() {
        pathTraveler.travel("");
        assertOrientation("N");
        assertCoordinates(0, 0);
    }

    @Test
    public void orientationAfterSingleLeftTurn() {
        pathTraveler.travel("L1");
        assertOrientation("W");
        pathTraveler.travel("L1");
        assertOrientation("S");
        pathTraveler.travel("L1");
        assertOrientation("E");
        pathTraveler.travel("L1");
        assertOrientation("N");
    }

    private void assertOrientation(String direction) {
        assertEquals(ChristmasCoordinates.Direction.valueOf(direction), pathTraveler.getOrientation());
    }

    private void assertCoordinates(int expectedX, int expectedY) {
        assertEquals(expectedX, pathTraveler.getX());
        assertEquals(expectedY, pathTraveler.getY());
    }
}
