package max;

public class MaxCiaRecursionCalculator {
    public int calculate(int... numbers) {
        return recursiveMaxCalculator(numbers);
    }

    private int recursiveMaxCalculator(int... numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        } else {
            int[] newNumbers = new int[numbers.length - 1];
            System.arraycopy(numbers, 1, newNumbers, 0, numbers.length - 1);
            int recursivedMax = recursiveMaxCalculator(newNumbers);
            return (numbers[0] >= recursivedMax) ? numbers[0] : recursivedMax;
        }
    }
}
