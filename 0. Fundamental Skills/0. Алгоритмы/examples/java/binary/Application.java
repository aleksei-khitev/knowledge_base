package binary;

public class Application {
    public static void main(String[] args) {
        Integer[] elements = new Integer[]{1, 4, 7, 9, 10, 14, 16, 20, 90, 101};
        int index = BinarySearcher.newInstance().find(elements, 9);
        System.out.println(index);
    }
}
