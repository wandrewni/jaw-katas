package advent_of_code;

public class ChristmasCoordinates {

	public static int calcShortestPath(String directions) {
		int x = 0;
		int y = 0;
		Direction direction = Direction.N;
		
		if (directions.length() == 0) {
			return 0;
		}
		
		String[] steps = directions.replaceAll(",", "").split(" ");
		for (String step: steps) {
			direction = newDirection(direction, isLeft(step));
			switch(direction) {
			case E:
				x += parseLength(step);
				break;
			case N:
				y += parseLength(step);
				break;
			case S:
				y -= parseLength(step);
				break;
			case W:
				x -= parseLength(step);
				break;
			default:
				break;
			}
		}
		return (Math.abs(x)+Math.abs(y));
	}

	private static int parseLength(String step) {
		return Integer.parseInt(step.substring(1));
	}
	
	private static boolean isLeft(String step) {
		return step.charAt(0) == 'L';
	}
	
	private static Direction newDirection(Direction currentDirection, boolean turningLeft) {
		switch (currentDirection) {
			case N:
				return turningLeft ? Direction.W : Direction.E;
			case E:
				return turningLeft ? Direction.N : Direction.S;
			case S:
				return turningLeft ? Direction.E : Direction.W;
			case W:
				return turningLeft ? Direction.S : Direction.N;
			default:
				return null;
		}
	}
		
	enum Direction{N, E, S, W};
}