package euclidean_algorithm;

public class EuclideanProcessor {
    public int getMinimalQuadrantCount(int height, int width) {
        int minimalQuadrantLength = extractUnprocessedPart(height, width);
        return (height / minimalQuadrantLength) * (width / minimalQuadrantLength);
    }

    private int extractUnprocessedPart(int height, int width) {
        int biggerNumber = Math.max(height, width);
        int smallerNumber = Math.min(height, width);
        int remainingPart = calculateLengthOfRemainingPart(biggerNumber, smallerNumber);
        if (remainingPart == 0) {
            return smallerNumber;
        } else {
            return extractUnprocessedPart(remainingPart, smallerNumber);
        }
    }

    private int calculateLengthOfRemainingPart(int biggerNumber, int smallerNumber) {
        // Сколько может поместиться квадратов с длинной, как меньшая сторона
        int smallerQuadrantCount = biggerNumber / smallerNumber;
        // сколько осталось неразмеченным
        return biggerNumber - smallerQuadrantCount * smallerNumber;
    }
}
