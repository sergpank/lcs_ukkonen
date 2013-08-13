package stree;

public class ActivePoint {
    Vertex    activeNode;
    Edge activeEdge;
    int       activeLength;

    public ActivePoint(Vertex activeNode, Edge activeEdge, int activeLength) {
        this.activeNode   = activeNode;
        this.activeEdge   = activeEdge;
        this.activeLength = activeLength;
    }

    public Vertex getActiveNode() {
        return activeNode;
    }

    public void setActiveNode(Vertex activeNode) {
        this.activeNode = activeNode;
    }

    public Edge getActiveEdge() {
        return activeEdge;
    }

    public void setActiveEdge(Edge activeEdge) {
        this.activeEdge = activeEdge;
    }

    public int getActiveLength() {
        return activeLength;
    }

    public void setActiveLength(int activeLength) {
        this.activeLength = activeLength;
    }
}
