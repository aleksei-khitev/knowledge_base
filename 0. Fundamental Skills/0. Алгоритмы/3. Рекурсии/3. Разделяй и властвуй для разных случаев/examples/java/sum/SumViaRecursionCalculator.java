package sum;

public class SumViaRecursionCalculator {
    public int calculate(int... numbers) {
        return recursiveSumCalculator(numbers);
    }

    private int recursiveSumCalculator(int... numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        } else {
            int[] newNumbers = new int[numbers.length - 1];
            System.arraycopy(numbers, 1, newNumbers, 0, numbers.length - 1);
            return numbers[0] + recursiveSumCalculator(newNumbers);
        }
    }
}
