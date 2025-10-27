package dinamic_programming.tour_rout;

import java.util.*;

public class TourPlanner {
    private static final Cell EMPTY_CELL = new Cell(0, Collections.emptyList());
    private final List<InterestingPlace> places;
    private final double timeLimit;
    private Cell optimalCell;

    public TourPlanner(double timeLimit, List<InterestingPlace> places) {
        this.timeLimit = timeLimit;
        this.places = places;
        optimalCell = EMPTY_CELL;
    }

    public List<InterestingPlace> optimize() {
        Map<Integer, Double> indexToTimeMapping = prepareColumnIndexToTimeMapping();
        int rowCount = places.size();
        int columnCount = indexToTimeMapping.size();
        Cell[][] variantTable = new Cell[rowCount][columnCount];
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                InterestingPlace place = places.get(row);
                double timeToVisit = indexToTimeMapping.get(column);
                Cell cellToCompare = (row > 0) ? variantTable[row - 1][column] : EMPTY_CELL;
                if (place.timeToVisit() == timeToVisit) {
                    if (place.wantToVisitForce() > cellToCompare.wantToVisitForce()) {
                        variantTable[row][column] = new Cell(place.wantToVisitForce(), List.of(place));
                    } else {
                        variantTable[row][column] = cellToCompare;
                    }
                } else if (place.timeToVisit() > timeToVisit) {
                    if (row > 0) {
                        variantTable[row][column] = cellToCompare;
                    } else {
                        variantTable[row][column] = EMPTY_CELL;
                    }
                } else {
                    double remainingTime = timeToVisit - place.timeToVisit();
                    int combinedWantToVisitForce = place.wantToVisitForce();
                    List<InterestingPlace> combinedInterestingPlaces = new ArrayList<>();
                    combinedInterestingPlaces.add(place);
                    if (row > 0) {
                        Optional<Map.Entry<Integer, Double>> colunmTimeMappingEntry = indexToTimeMapping.entrySet().stream()
                                .filter((entry) -> entry.getValue() <= remainingTime)
                                .max(Comparator.comparingDouble(Map.Entry::getValue));
                        if (colunmTimeMappingEntry.isPresent()) {
                            combinedWantToVisitForce += variantTable[row - 1][colunmTimeMappingEntry.get().getKey()].wantToVisitForce();
                            combinedInterestingPlaces.addAll(variantTable[row - 1][colunmTimeMappingEntry.get().getKey()].places());
                        }

                    }
                    if (combinedWantToVisitForce > cellToCompare.wantToVisitForce()) {
                        variantTable[row][column] = new Cell(combinedWantToVisitForce, combinedInterestingPlaces);
                    } else {
                        variantTable[row][column] = cellToCompare;
                    }
                }
                if (variantTable[row][column].wantToVisitForce() > optimalCell.wantToVisitForce()) {
                    optimalCell = variantTable[row][column];
                }
            }
        }
        return optimalCell.places();
    }

    public int wantToVisitForceCoveredByOptimalTout() {
        return optimalCell.wantToVisitForce();
    }

    private Map<Integer, Double> prepareColumnIndexToTimeMapping() {
        Map<Integer, Double> mapping = new HashMap<>();
        List<Double> times = places.stream().map(InterestingPlace::timeToVisit)
                .filter(timeToVisit -> timeToVisit <= timeLimit).sorted(Double::compareTo).toList();
        for (int i = 0; i < times.size(); i++) {
            mapping.put(i, times.get(i));
        }
        return mapping;
    }
}
