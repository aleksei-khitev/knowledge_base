package graph.tree.dijkstra_algo;

import java.util.*;

public class DijkstraPathFinder {
    private final List<EdgeCost> costs;
    private final Map<String, EdgeCost> optimalPathCosts;
    private final List<String> processedNodes;

    public DijkstraPathFinder(List<EdgeCost> costs) {
        this.costs = costs;
        optimalPathCosts = new HashMap<>();
        processedNodes = new ArrayList<>();
    }

    public List<String> findPath(String start, String target) {
        EdgeCost lowestCostEdge = findLowestCostEdge(start);
        while(lowestCostEdge != null) {
            int totalCost = calcTotalCost(lowestCostEdge);
            if (optimalPathCosts.containsKey(lowestCostEdge.getNode())) {
                if (optimalPathCosts.get(lowestCostEdge.getNode()).getCost() < totalCost) {
                    optimalPathCosts.put(lowestCostEdge.getNode(),
                            new EdgeCost(lowestCostEdge.getNode(), lowestCostEdge.getParent(), totalCost));
                }
            } else {
                optimalPathCosts.put(lowestCostEdge.getNode(),
                        new EdgeCost(lowestCostEdge.getNode(), lowestCostEdge.getParent(), totalCost));
            }
            processedNodes.add(lowestCostEdge.getNode());
            lowestCostEdge = findLowestCostEdge(lowestCostEdge.getNode());
        }
        return calcPath(start, target);
    }

    public int getCost(String target) {
        return optimalPathCosts.get(target).getCost();
    }

    private EdgeCost findLowestCostEdge(String parent) {
        Optional<EdgeCost> min = costs.stream()
                .filter(e -> e.getParent().equals(parent))
                .filter(e -> !processedNodes.contains(e.getNode()))
                .min(Comparator.comparingInt(EdgeCost::getCost));
        if (min.isPresent()) {
            return min.get();
        } else {
            return null;
        }

    }

    private int calcTotalCost(EdgeCost edgeCost) {
        int cost = edgeCost.getCost();
        String parent = edgeCost.getParent();
        if (optimalPathCosts.containsKey(parent)) {
            cost += optimalPathCosts.get(parent).getCost();
        }
        return cost;
    }

    private List<String> calcPath(String start, String target) {
        List<String> path = new ArrayList<>();
        String currentNode = target;
        while(currentNode != start) {
            path.add(currentNode);
            currentNode = optimalPathCosts.get(currentNode).getParent();
        }
        path.add(start);
        return path;
    }
}
