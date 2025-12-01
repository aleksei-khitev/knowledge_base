package breadth_first_search;

import java.util.*;

public class BfsSearcher {
    public String search(Map<String, List<String>> tree, String initNode, String targetNode) {
        Queue<PathNode> nodesToBeProcessed = new LinkedList<>();
        Set<String> alreadyProcessedNodes = new HashSet<>();
        nodesToBeProcessed.offer(new PathNode(initNode, List.of(initNode)));
        while(!nodesToBeProcessed.isEmpty()) {
            PathNode currentNode = nodesToBeProcessed.poll();
            if (alreadyProcessedNodes.contains(currentNode.value())) {
                continue;
            }
            if (currentNode.value().equals(targetNode)) {
                return String.join(" - ", currentNode.path());
            } else {
                alreadyProcessedNodes.add(currentNode.value());
                if (tree.containsKey(currentNode.value())) {
                    tree.get(currentNode.value()).forEach(node -> {
                        List<String> path = new ArrayList<>(currentNode.path());
                        path.add(node);
                        nodesToBeProcessed.offer(new PathNode(node, path));
                    });
                }
            }
        }
        return "";
    }
}
