package binary_search;

public class BinarySearcherViaRecursion <T extends Comparable<T>> {
    public int find(T element, T... elements) {
        return findRecursively(element, elements, 0, elements.length - 1);
    }

    private int findRecursively(T element, T[] elements, int startPosition, int endPosition) {
        int middleIndex = startPosition + ((endPosition - startPosition) / 2);
        if (element.equals(elements[middleIndex])) {
            return middleIndex;
        } else if (element.compareTo(elements[middleIndex]) > 0) {
            return findRecursively(element, elements, middleIndex + 1, endPosition);
        } else {
            return findRecursively(element, elements, startPosition, middleIndex - 1);
        }
    }
}
