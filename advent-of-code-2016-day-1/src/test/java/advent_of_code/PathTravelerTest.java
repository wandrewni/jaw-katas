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
    public void orientationAfterLeftTurns() {
        pathTraveler.travel("L0");
        assertOrientation("W");
        pathTraveler.travel("L0");
        assertOrientation("S");
        pathTraveler.travel("L0");
        assertOrientation("E");
        pathTraveler.travel("L0");
        assertOrientation("N");
    }

    @Test
    public void orientationAfterRightTurns() {
        pathTraveler.travel("R0");
        assertOrientation("E");
        pathTraveler.travel("R0");
        assertOrientation("S");
        pathTraveler.travel("R0");
        assertOrientation("W");
        pathTraveler.travel("R0");
        assertOrientation("N");
    }

    @Test
    public void traveling() throws Exception {
        pathTraveler.travel("L2");
        assertCoordinates(-2, 0);
        pathTraveler.travel("L4");
        assertCoordinates(-2, -4);
        pathTraveler.travel("L5");
        assertCoordinates(3, -4);
        pathTraveler.travel("L8");
        assertCoordinates(3, 4);
    }

    @Test
    public void travelingMultipleSteps() throws Exception {
        pathTraveler.travel("L1, L2");
        assertCoordinates(-1, -2);
    }

    private void assertOrientation(String direction) {
        assertEquals(ChristmasCoordinates.Direction.valueOf(direction), pathTraveler.getOrientation());
    }

    private void assertCoordinates(int expectedX, int expectedY) {
        assertEquals(expectedX, pathTraveler.getX());
        assertEquals(expectedY, pathTraveler.getY());
    }
}
