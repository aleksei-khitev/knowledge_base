package dijkstra_algo;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<EdgeCost> costs = List.of(
                new EdgeCost("a", "начало", 6),
                new EdgeCost("конец", "a", 1),
                new EdgeCost("b", "начало", 2),
                new EdgeCost("a", "b", 3),
                new EdgeCost("конец", "b", 5)
        );
        DijkstraPathFinder pathFinder = new DijkstraPathFinder(costs);
        System.out.println(pathFinder.findPath("начало", "конец"));
        System.out.println(pathFinder.getCost("конец"));
    }
}
