package quick_sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class QuickSorter <T extends Comparable<T>> {
    public List<T> sort(List<T> input) {
        return sortRecursively(input);
    }

    private List<T> sortRecursively(List<T> input) {
        if (input.size() < 1) {
            return input;
        }
        T pivotalElement = input.get(0);
        List<T> leftPart = new ArrayList<>();
        List<T> rightPart = new ArrayList<>();
        for (int i = 1; i < input.size(); i++) {
            T currentElement = input.get(i);
            if (currentElement.compareTo(pivotalElement) <= 0){
                leftPart.add(currentElement);
            } else {
                rightPart.add(currentElement);
            }
        }
        List<T> sortedList = new ArrayList<>(sortRecursively(leftPart));
        sortedList.add(pivotalElement);
        sortedList.addAll(sortRecursively(rightPart));
        return sortedList;
    }

}
