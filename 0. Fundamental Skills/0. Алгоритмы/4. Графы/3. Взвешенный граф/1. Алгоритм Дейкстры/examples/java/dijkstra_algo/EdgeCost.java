package dijkstra_algo;

public class EdgeCost {
    private final String node;
    private String parent;
    private int cost;

    public EdgeCost(String node, String parent, int cost) {
        this.node = node;
        this.parent = parent;
        this.cost = cost;
    }

    public String getNode() {
        return node;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
