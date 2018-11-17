package advent_of_code;

import org.junit.Assert;
import org.junit.Test;

public class MinPathTest {

    private static final String ANY = null;

    private void assertMinPath(String graph, Integer length, String path) {
        PathFinder pf = new PathFinder(graph);
        if (length != null)
            Assert.assertEquals(length, pf.minLength("A", "Z"));
        if (path != null)
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

    @Test
    public void oneEdge() {
        assertMinPath("A1Z", 1, ANY);
    }

    public static class PathFinder {
        PathFinder(String graph) {
        }

        private Integer minLength(String begin, String end) {
            return 0;
        }

        private String minPath(String begin, String end) {
            return "{}";
        }
    }
}