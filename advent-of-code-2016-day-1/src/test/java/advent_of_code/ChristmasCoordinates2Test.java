package advent_of_code;

import org.junit.Ignore;
import org.junit.Test;

import static advent_of_code.ChristmasCoordinates2.calcShortestPath;
import static org.junit.Assert.assertEquals;

public class ChristmasCoordinates2Test {
	
	@Test
	public void calcShortestPathForNoInput(){
		assertEquals(0, calcShortestPath(""));
	}

	@Test
	public void shortestPathForOneStepIsOne() {
		assertEquals(1, calcShortestPath("L1"));
		assertEquals(1, calcShortestPath("R1"));
	}
	
	@Test
	public void shortestPathForSinglePathIsLengthOfPath() {
		assertEquals(3, calcShortestPath("L3"));
		assertEquals(3, calcShortestPath("R3"));
	}
	
	@Test
	public void shortestForTwoOneStepsIsTwo() {
		assertEquals(2, calcShortestPath("L1, L1"));
	}
	
	@Test
	public void severalTwoStepCases() throws Exception {
		assertEquals(10, calcShortestPath("L4, L6"));
		assertEquals(103, calcShortestPath("R41, L62"));
	}
	
	@Test
	public void threeSingleLengthStepsInOneDirectionIsOne() {
		assertEquals(1, calcShortestPath("L1, L1, L1"));
	}
}
