package advent_of_code;

import org.junit.Assert;
import org.junit.Test;

public class MinPathTest {

    private void assertMinPath(String graph, int length, String path) {
        PathFinder pf = new PathFinder(graph);
        Assert.assertEquals(length, pf.minLength("A", "Z"));
        Assert.assertEquals(path, pf.minPath("A", "Z"));
    }

    @Test
    public void degenerateCases() {
        assertMinPath("", 0, "{}");    //empty graph
        assertMinPath("A", 0, "{}");   //one node
        assertMinPath("B1C", 0, "{}"); // no start or end
        assertMinPath("A1C", 0, "{}"); // no end
        assertMinPath("B1Z", 0, "{}"); // no start
    }

    public static class PathFinder {
        public PathFinder(String graph) {
        }

        private int minLength(String begin, String end) {
            return 0;
        }

        private String minPath(String begin, String end) {
            return "{}";
        }
    }
}