package dinamic_programming.autocorrection;

import java.util.*;

public class PossibleCorrectWordFinder {
    private final List<String> wordsForComparing;

    public PossibleCorrectWordFinder(List<String> wordsForComparing) {
        this.wordsForComparing = wordsForComparing;
    }

    public String findMostPossibleCorrectWord(String word) {
        SortedMap<Integer, String> possibleWords = new TreeMap<>();
        for (String wordForComparing : wordsForComparing) {
            possibleWords.put(getCommonPartLength(word, wordForComparing), wordForComparing);
        }
        return possibleWords.pollLastEntry().getValue();
    }

    private int getCommonPartLength(String word, String wordForComparing) {
        int commonPartLength = 0;
        int columnCount = word.length();
        int rowCount = wordForComparing.length();
        int[][] table = new int[rowCount][columnCount];
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                if (wordForComparing.charAt(row) == word.charAt(column)) {
                    if (row == 0) {
                        table[row][column] = 1;
                    } else {
                        if (column == 0) {
                            table[row][column] = 1;
                        } else {
                            table[row][column] = 1 + table[row - 1][column - 1];
                            commonPartLength = Integer.max(commonPartLength, table[row][column]);
                        }
                    }
                } else {
                    if (row == 0 && column == 0) {
                        table[row][column] = 0;
                    } else if (row == 0 && column > 0) {
                        table[row][column] = table[row][column - 1];
                    } else if (row > 0 && column == 0) {
                        table[row][column] = table[row - 1][column];
                    } else {
                        table[row][column] = Integer.max(table[row - 1][column], table[row][column - 1]);
                    }
                }
            }
        }
        return commonPartLength;
    }
}
