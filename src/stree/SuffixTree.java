package stree;

import java.util.*;

public class SuffixTree {

    private Vertex rootVertex;
    private Map<Integer, String> wordMap = new HashMap<Integer, String>();
    private ActivePoint activePoint;
    private Index currentPosition = new Index(0);
    private Integer remainder = 0;

    public SuffixTree() {
        rootVertex = new Vertex(new HashSet<Integer>());
    }

    public void addWord(String word) {
        activePoint = new ActivePoint(rootVertex, null, 0);
        wordMap.put(wordMap.size(), word);
        int wordIndex = wordMap.size() - 1;
        currentPosition.index = 0;
        remainder = 0;
        while (currentPosition.index < word.length()) {
            ++currentPosition.index;
            ++remainder;
            addSuffix(word, wordIndex);
        }
    }

    public void addSuffix(String suffix, int wordIndex) {
        addSuffix(suffix, wordIndex, rootVertex);
    }

    private void addSuffix(String suffix, int wordIndex, Vertex parent) {
        while (remainder > 0) {
            String subsuffix = suffix.substring(currentPosition.index - remainder, currentPosition.index);
            if (remainder == 1) {
                if (activePoint.getActiveNode().equals(rootVertex) && activePoint.getActiveEdge() == null) {
                    Edge edge = activePoint.getActiveNode().findEdgeStartingWith(subsuffix.charAt(0), wordMap);
                    if (edge == null) {
                        rootVertex.addEdge(new Edge(wordMap, wordIndex, new Index(currentPosition.index - remainder), currentPosition, rootVertex, null));
                        rootVertex.addWordIndex(wordIndex);
                        --remainder;
                        return;
                    }
                }
            }
        }
    }

    private boolean vertexIsPrefix(String vertexString, int prefixLength) {
        return vertexString.length() <= prefixLength;
    }

    private int calcPrefixLength(String suffix, String vertexString, int shift) {
        int cnt = 0;
        int length = Math.min(suffix.length() - shift, vertexString.length());
        for (int i = 0; i < length; i++) {
            if (suffix.charAt(i + shift) == vertexString.charAt(i)) {
                ++cnt;
            } else {
                break;
            }
        }
        return cnt;
    }

    private String getVertexString(Edge edge) {
        return wordMap.get(edge.getWordIndex()).substring(edge.getStartIndex().index, edge.getEndIndex().index);
    }

    public String getLongestSubstring() {
        Set<String> subSet = Collections.synchronizedSet(new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String string1, String string2) {
                return string2.length() - string1.length();
            }
        }));
        getSubstrings(rootVertex, subSet, "");

        return subSet.iterator().next();
    }

    private void getSubstrings(Vertex node, Set<String> strings, String substring) {
        int commonSubstringsCounter = 0;
        if (node != null) {
            for (Edge edge : node.getEdges()) {
                if (edge.getStartVertex().getIndexes().size() == wordMap.size()) {
                    int startIndex = edge.getStartIndex().index;
                    int endIndex = edge.getEndIndex().index;
                    String vertexString = wordMap.get(edge.getWordIndex()).substring(startIndex, endIndex);
                    Vertex endVertex = edge.getEndVertex();
                    getSubstrings(endVertex, strings, substring + vertexString);
                    commonSubstringsCounter++;
                }
            }
        }
        if (commonSubstringsCounter == 0) {
            strings.add(substring);
        }
    }
}
