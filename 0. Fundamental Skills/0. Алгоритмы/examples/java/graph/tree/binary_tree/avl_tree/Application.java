package graph.tree.binary_tree.avl_tree;

public class Application {
    public static void main(String[] args) {
        Node root = new Node(null, 20);
        root.addValue(10);
        root.addValue(30);
        root.addValue(5);
        root.addValue(2);
        System.out.println(root);
    }
}
