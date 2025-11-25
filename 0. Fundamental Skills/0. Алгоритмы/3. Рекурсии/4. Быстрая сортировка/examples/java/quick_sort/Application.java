package quick_sort;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println(new QuickSorter<Integer>().sort(List.of(3, 5, 2, 1, 4)));
    }
}
