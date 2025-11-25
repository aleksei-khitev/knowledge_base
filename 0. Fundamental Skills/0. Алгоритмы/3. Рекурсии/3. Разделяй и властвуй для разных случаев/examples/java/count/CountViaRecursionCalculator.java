package count;

public class CountViaRecursionCalculator {
    public int calculate(int... numbers) {
        return recursiveCountCalculator(numbers);
    }

    private int recursiveCountCalculator(int... numbers) {
        if (numbers.length == 1) {
            return 1;
        } else {
            int[] newNumbers = new int[numbers.length - 1];
            System.arraycopy(numbers, 1, newNumbers, 0, numbers.length - 1);
            return 1 + recursiveCountCalculator(newNumbers);
        }
    }
}
