package binary_search;

public class Application {
    public static void main(String[] args) {
        System.out.println(new BinarySearcherViaRecursion<Integer>().find(10, 1, 2, 4, 6, 9, 10, 13, 14));
    }
}
