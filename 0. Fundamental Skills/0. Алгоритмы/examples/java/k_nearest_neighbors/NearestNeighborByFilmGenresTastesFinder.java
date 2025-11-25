package k_nearest_neighbors;

import java.util.*;

public class NearestNeighborByFilmGenresTastesFinder {
    private final List<Neighbor> otherPeople;

    public NearestNeighborByFilmGenresTastesFinder(List<Neighbor> otherPeople) {
        this.otherPeople = otherPeople;
    }

    public String findNearestNeighbor(Neighbor person) {
        SortedMap<Double, Neighbor> neighborDistance = new TreeMap<>();
        for (Neighbor neighbor : otherPeople) {
            double vector = 0;
            for (Genres genre : Genres.values()) {
                vector += Math.pow(person.moviesPreferences().get(genre) - neighbor.moviesPreferences().get(genre), 2);
            }
            try {
                vector = Math.sqrt(vector);
                neighborDistance.put(vector, neighbor);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return neighborDistance.pollFirstEntry().getValue().name();
    }
}
