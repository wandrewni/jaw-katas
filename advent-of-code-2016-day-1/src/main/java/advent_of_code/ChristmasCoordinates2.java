package advent_of_code;

public class ChristmasCoordinates2 {
    public static int calcShortestPath(String path) {
        if (path.length() == 0)
            return 0;
        String steps[] = path.replace(",","").split(" ");
        int totalLength = 0;
        for (String step : steps)
            totalLength += Integer.parseInt(step.substring(1));
        return totalLength;
    }
}
