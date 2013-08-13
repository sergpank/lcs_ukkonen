package stree;

import java.util.*;

public class Vertex {

    private Vertex parent;
    private Set<Integer> indexes = new HashSet<Integer>();
    private List<Edge> edges = new ArrayList<Edge>();

    public Vertex(Set<Integer> indexes) {
        this.indexes.addAll(indexes);
    }

    public void addWordIndex(Integer wordIndex) {
        indexes.add(wordIndex);
    }

    public Set<Integer> getIndexes() {
        return indexes;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
        indexes.add(edge.getWordIndex());
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Edge findEdgeStartingWith(char startChar, Map<Integer, String> words) {
        Edge result = null;
        for (Edge edge : edges) {
            if(edge.getFirstChar() == startChar){
                result = edge;
                break;
            }
        }
        return result;
    }
}
