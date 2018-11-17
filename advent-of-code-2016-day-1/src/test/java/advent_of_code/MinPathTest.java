package advent_of_code;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MinPathTest {

    private static final String ANY = null;

    private void assertMinPath(String graph, Integer length, String path) {
        PathFinder pf = makePathFinder(graph);
        if (length != null)
            Assert.assertEquals((int) length, pf.getLength());
        if (path != null)
            Assert.assertEquals(path, pf.getPath().toString());
    }

    private PathFinder makePathFinder(String graph) {
        PathFinder pf = new PathFinder();
        Pattern edgePattern = Pattern.compile("(\\D+)(\\d+)(\\D+)");
        String[] edges = graph.split(",");
        for (String edge : edges) {
            Matcher matcher = edgePattern.matcher(edge);
            if (matcher.matches()) {
                String start = matcher.group(1);
                int length = Integer.parseInt(matcher.group(2));
                String end = matcher.group(3);
                pf.addEdge(start, end, length);
            }
        }
        pf.findPath("A", "Z");
        return pf;
    }

    @Test
    public void degenerateCases() {
        assertMinPath("", 0, "[]");    //empty graph
        assertMinPath("A", 0, "[]");   //one node
        assertMinPath("B1C", 0, "[]"); // no start or end
        assertMinPath("A1C", 0, "[]"); // no end
        assertMinPath("B1Z", 0, "[]"); // no start
    }

    @Test
    public void oneEdge() {
        assertMinPath("A1Z", 1, "[A, Z]");
        assertMinPath("A2Z", 2, "[A, Z]");
    }

    @Test
    public void twoEdges() {
        assertMinPath("A1B,B1Z", 2, ANY);
    }
}

class PathFinder {
    private List<Edge> edges = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    private int length;

    PathFinder() {
    }

    public void addEdge(String start, String end, int length) {
        edges.add(new Edge(start, end, length));
    }

    public void findPath(String begin, String end) {
        //noinspection StatementWithEmptyBody
        if (edges.size() == 0) {}
        else if (edges.size() == 1) {
            Edge edge = edges.get(0);
            if (edge.begin.equals(begin) && edge.end.equals(end)) {
                path.add(edge.begin);
                path.add(edge.end);
                length += edge.length;
            }
        } else {
            for (Edge edge : edges)
                if (edge.begin.equals(begin) || edge.end.equals(end)) {
                    path.add(edge.begin);
                    path.add(edge.end);
                    length += edge.length;
                }
        }
    }

    public int getLength() {
        return length;
    }

    public List<String> getPath() {
        return path;
    }

    private static class Edge {
        final String begin;
        final String end;
        final int length;

        Edge(String begin, String end, int length) {
            this.begin = begin;
            this.end = end;
            this.length = length;
        }
    }
}