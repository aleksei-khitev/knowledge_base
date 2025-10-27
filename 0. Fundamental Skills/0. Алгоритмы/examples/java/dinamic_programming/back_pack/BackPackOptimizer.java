package dinamic_programming.back_pack;

import java.util.ArrayList;
import java.util.List;

public class BackPackOptimizer {
    private final static Cell EMPTY_CELL = new Cell(0, List.of());
    private final List<Item> items;
    private final int backPackCapacity;
    private Cell optimalCell;

    public BackPackOptimizer(int backPackCapacity, List<Item> items) {
        this.items = items;
        this.backPackCapacity = backPackCapacity;
    }

    public List<Item> getOptimalKit() {
        int tableColumnCount = backPackCapacity;
        int tableRowCount = items.size();
        Cell[][] tableForCalculation = new Cell[tableRowCount][tableColumnCount];
        optimalCell = EMPTY_CELL;
        for (int row = 0; row < tableRowCount; row++) {
            for (int column = 0; column < tableColumnCount; column++) {
                Item item = items.get(row);
                int currentWeight = column + 1;
                Cell cellToCompare = (row > 0) ? tableForCalculation[row - 1][column] : EMPTY_CELL;
                if (item.weight() == currentWeight) {
                    if (item.price() > cellToCompare.price()) {
                        tableForCalculation[row][column] = new Cell(item.price(), List.of(item));
                    } else {
                        tableForCalculation[row][column] = cellToCompare;
                    }
                } else if (item.weight() > currentWeight) {
                    if (row > 0) {
                        tableForCalculation[row][column] = cellToCompare;
                    } else {
                        tableForCalculation[row][column] = EMPTY_CELL;
                    }
                } else {
                    int remainingWeight = currentWeight - item.weight();
                    int combinedPrice = item.price();
                    List<Item> combinedItems = new ArrayList<>();
                    combinedItems.add(item);
                    if (row > 0) {
                        combinedPrice += tableForCalculation[row - 1][remainingWeight - 1].price();
                        combinedItems.addAll(tableForCalculation[row - 1][remainingWeight - 1].items());
                    }
                    if (combinedPrice > cellToCompare.price()) {
                        tableForCalculation[row][column] = new Cell(combinedPrice, combinedItems);
                    } else {
                        tableForCalculation[row][column] = cellToCompare;
                    }
                }
                if (tableForCalculation[row][column].price() > optimalCell.price()) {
                    optimalCell = tableForCalculation[row][column];
                }
            }
        }
        return optimalCell.items();
    }

    public int priceForOptimalKit() {
        return optimalCell.price();
    }

    private int getPriceToCompare(int[][] tableForCalculation, int row, int column) {
        if (row == 0) {
            return 0;
        } else {
            return tableForCalculation[row - 1][column];
        }
    }
}
