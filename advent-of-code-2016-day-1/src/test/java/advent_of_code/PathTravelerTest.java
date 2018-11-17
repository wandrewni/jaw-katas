package advent_of_code;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PathTravelerTest {

    private PathTraveler pathTraveler;

    @Before
    public void setUp() throws Exception {
        pathTraveler = new PathTraveler();
    }

    @Test
    public void pathTraveler() {
        assertEquals(ChristmasCoordinates.Direction.N, pathTraveler.getOrientation());
        assertEquals(0, pathTraveler.getX());
        assertEquals(0, pathTraveler.getY());
    }

    @Test
    public void initialPositioning() {
        pathTraveler.travel("");
        assertEquals(ChristmasCoordinates.Direction.N, pathTraveler.getOrientation());
        assertEquals(0, pathTraveler.getX());
        assertEquals(0, pathTraveler.getY());
    }
}
