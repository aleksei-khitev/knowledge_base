package depth_first_search;

import java.util.List;
import java.util.Map;

public class DfsSearcher {
    public boolean search(Map<String, List<String>> tree, String initNode, String targetNode) {
        if (initNode.equals(targetNode)) {
            return true;
        }
        if (tree.containsKey(initNode)) {
            List<String> children = tree.get(initNode);
            for (String child : children) {
                if (search(tree, child, targetNode)) {
                    return true;
                }
            }
        }
        return false;
    }
}
