package sort.selection;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Integer[] elements = new Integer[]{5, 10, 8, 6, 111, 5, 7, 4, 12};
        Integer[] sortedElements = new SelectionSorter<Integer>().sort(elements);
        System.out.println(Arrays.toString(sortedElements));
    }
}
