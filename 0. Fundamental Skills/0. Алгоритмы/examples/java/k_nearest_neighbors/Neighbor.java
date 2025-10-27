package k_nearest_neighbors;

import java.util.Map;

public record Neighbor(String name, Map<Genres, Integer> moviesPreferences) {
}
