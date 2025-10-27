package geedy_algo;

import java.util.*;
import java.util.stream.Collectors;

public class RadioCoverageCalculator {
    public List<RadioStation> calcualte(List<RadioStation> allStations) {
        Set<String> uncoveredStates = allStations.stream().map(RadioStation::statesCovered).flatMap(List::stream).collect(Collectors.toSet());
        Set<String> coveredStates = new HashSet<>();
        List<RadioStation> processedStations = new ArrayList<>();
        while(!uncoveredStates.isEmpty()) {
            Optional<RadioStation> nextOptimalStation = allStations.stream()
                    .filter(station -> !processedStations.contains(station))
                    .max((st1, st2) -> {
                        List<String> newStatesCoveredBySt1 = st1.statesCovered().stream()
                                .filter(state -> !coveredStates.contains(state)).toList();
                        List<String> newStatesCoveredBySt2 = st2.statesCovered().stream()
                                .filter(state -> !coveredStates.contains(state)).toList();
                        return Integer.compare(newStatesCoveredBySt1.size(), newStatesCoveredBySt2.size());
                    });
            if (nextOptimalStation.isPresent()) {
                processedStations.add(nextOptimalStation.get());
                coveredStates.addAll(nextOptimalStation.get().statesCovered());
                nextOptimalStation.get().statesCovered().forEach(uncoveredStates::remove);
            } else {
                break;
            }

        }
        return processedStations;
    }
}
