package sort.selection;

/**
 * Сортировка выбором
 * @param <T>
 */
public class SelectionSorter<T extends Comparable<T>> {

    public T[] sort(T[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int smallestElementIndex = findIndexOfSmallestElement(elements, i);
            T smallestElement = elements[smallestElementIndex];
            elements[smallestElementIndex] = elements[i];
            elements[i] = smallestElement;
        }
        return elements;
    }

    /**
     * Находим следующий минимальный элемент
     * @param elements
     * @param fromIndex
     * @return
     */
    private int findIndexOfSmallestElement(T[] elements, int fromIndex) {
        T smallest = elements[fromIndex];
        int smallestElementIndex = fromIndex;
        for (int i = fromIndex; i < elements.length; i++) {
            if (elements[i].compareTo(smallest) < 0) {
                smallest = elements[i];
                smallestElementIndex = i;
            }
        }
        return smallestElementIndex;
    }
}
