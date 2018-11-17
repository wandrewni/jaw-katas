package advent_of_code;

import static advent_of_code.ChristmasCoordinates.calcShortestPath;
import static org.junit.Assert.*;

import org.junit.Test;

public class ChristmasCoordinatesTest {
	
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
		assertEquals(1, calcShortestPath("R1, R1, R1"));
	}
	
	@Test
	public void threeSingleLengthStepsVaryingWaysIsThree() {
		assertEquals(3, calcShortestPath("L1, L1, R1"));
	}

	@Test
	public void puzzleInput() throws Exception {
		String puzzleInput = "L3, R1, L4, L1, L2, R4, L3, L3, R2, R3, L5, R1, R3, L4, L1, L2, R2, R1, L4, L4, R2, L5, R3, R2, R1, L1, L2, R2, R2, L1, L1, R2, R1, L3, L5, R4, L3, R3, R3, L5, L190, L4, R4, R51, L4, R5, R5, R2, L1, L3, R1, R4, L3, R1, R3, L5, L4, R2, R5, R2, L1, L5, L1, L1, R78, L3, R2, L3, R5, L2, R2, R4, L1, L4, R1, R185, R3, L4, L1, L1, L3, R4, L4, L1, R5, L5, L1, R5, L1, R2, L5, L2, R4, R3, L2, R3, R1, L3, L5, L4, R3, L2, L4, L5, L4, R1, L1, R5, L2, R4, R2, R3, L1, L1, L4, L3, R4, L3, L5, R2, L5, L1, L1, R2, R3, L5, L3, L2, L1, L4, R4, R4, L2, R3, R1, L2, R1, L2, L2, R3, R3, L1, R4, L5, L3, R4, R4, R1, L2, L5, L3, R1, R4, L2, R5, R4, R2, L5, L3, R4, R1, L1, R5, L3, R1, R5, L2, R1, L5, L2, R2, L2, L3, R3, R3, R1";
		assertEquals(252, calcShortestPath(puzzleInput));
	}
}
