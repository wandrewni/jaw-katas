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
        assertOrientation("N");
        assertEquals(0, pathTraveler.getX());
        assertEquals(0, pathTraveler.getY());
    }

    @Test
    public void travelingAnEmptyPathResultsInNoCoordinatesChange() {
        pathTraveler.travel("");
        assertOrientation("N");
        assertEquals(0, pathTraveler.getX());
        assertEquals(0, pathTraveler.getY());
    }

    private void assertOrientation(String direction) {
        assertEquals(ChristmasCoordinates.Direction.valueOf(direction), pathTraveler.getOrientation());
    }
}
