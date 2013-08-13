package stree;

import java.util.Map;

public class Edge {
    private Map<Integer, String> wordMap;
    private Index startIndex;
    private Index endIndex;
    private int wordIndex;
    private Vertex startVertex;
    private Vertex endVertex;

    public Edge(Map<Integer, String> wordMap, int wordIndex, Index startIndex, Index endIndex, Vertex startVertex, Vertex endVertex) {
        this.wordMap = wordMap;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.wordIndex = wordIndex;
        this.startVertex = startVertex;
        this.endVertex = endVertex;
    }

    public Index getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Index startIndex) {
        this.startIndex = startIndex;
    }

    public Index getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Index endIndex) {
        this.endIndex = endIndex;
    }

    public int getWordIndex() {
        return wordIndex;
    }

    public void setWordIndex(int wordIndex) {
        this.wordIndex = wordIndex;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(Vertex endVertex) {
        this.endVertex = endVertex;
    }

    public char getFirstChar() {
        return wordMap.get(wordIndex).charAt(0);
    }

    @Override
    public String toString() {
        return wordMap.get(wordIndex).substring(startIndex.index, endIndex.index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (endIndex != edge.endIndex) return false;
        if (startIndex != edge.startIndex) return false;
        if (wordIndex != edge.wordIndex) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = startIndex.index;
        result = 31 * result + endIndex.index;
        result = 31 * result + wordIndex;
        return result;
    }

}
