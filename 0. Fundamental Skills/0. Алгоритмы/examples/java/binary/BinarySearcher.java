package binary;

public class BinarySearcher {
    public static BinarySearcher newInstance() {
        return new BinarySearcher();
    }

    /**
     * Сложность алгоритма O(logN)
     *
     * @param elements
     * @param element
     * @return
     * @param <T>
     */
    public <T extends Comparable<T>> int find(T[] elements, T element) {
        int lowIndex = 0; // Нижняя граница
        int highIndex = elements.length - 1; // Верхняя граница
        Integer resultIndex = null;

        while (lowIndex <= highIndex) {
            int middleIndex = (lowIndex + highIndex) / 2; // Берем индекс середины интервала
            T guessElement = elements[middleIndex]; // Берем элемент из середины
            if (guessElement.equals(element)) {
                resultIndex =  middleIndex;
                break;
            } else if (guessElement.compareTo(element) > 0) {
                highIndex = middleIndex - 1;
            } else {
                lowIndex = middleIndex + 1;
            }
        }

        return resultIndex;
    }
}
