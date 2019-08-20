package advent_of_code;

import advent_of_code.PathTraveler.Compass;
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
    public void traveling() {
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
    public void travelingMultipleSteps() {
        pathTraveler.travel("L1, L2");
        assertCoordinates(-1, -2);
    }

    @Test
    public void puzzleInput() {
        String puzzleInput = "L3, R1, L4, L1, L2, R4, L3, L3, R2, R3, L5, R1, R3, L4, L1, L2, R2, R1, L4, L4, R2, L5, R3, R2, R1, L1, L2, R2, R2, L1, L1, R2, R1, L3, L5, R4, L3, R3, R3, L5, L190, L4, R4, R51, L4, R5, R5, R2, L1, L3, R1, R4, L3, R1, R3, L5, L4, R2, R5, R2, L1, L5, L1, L1, R78, L3, R2, L3, R5, L2, R2, R4, L1, L4, R1, R185, R3, L4, L1, L1, L3, R4, L4, L1, R5, L5, L1, R5, L1, R2, L5, L2, R4, R3, L2, R3, R1, L3, L5, L4, R3, L2, L4, L5, L4, R1, L1, R5, L2, R4, R2, R3, L1, L1, L4, L3, R4, L3, L5, R2, L5, L1, L1, R2, R3, L5, L3, L2, L1, L4, R4, R4, L2, R3, R1, L2, R1, L2, L2, R3, R3, L1, R4, L5, L3, R4, R4, R1, L2, L5, L3, R1, R4, L2, R5, R4, R2, L5, L3, R4, R1, L1, R5, L3, R1, R5, L2, R1, L5, L2, R2, L2, L3, R3, R3, R1";
        pathTraveler.travel(puzzleInput);
        assertEquals(252, pathTraveler.getTravelDistance());
    }

    private void assertOrientation(String direction) {
        assertEquals(Compass.Direction.valueOf(direction), pathTraveler.getOrientation());
    }

    private void assertCoordinates(int expectedX, int expectedY) {
        assertEquals(expectedX, pathTraveler.getX());
        assertEquals(expectedY, pathTraveler.getY());
    }
}
