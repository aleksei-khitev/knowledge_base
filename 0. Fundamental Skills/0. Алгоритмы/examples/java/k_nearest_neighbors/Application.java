package k_nearest_neighbors;

import java.util.List;
import java.util.Map;

import static k_nearest_neighbors.Genres.*;

public class Application {
    public static void main(String[] args) {
        System.out.println(new NearestNeighborByFilmGenresTastesFinder(List.of(
                new Neighbor("Джастин",
                        Map.of(
                                COMEDY, 4,
                                ACTION, 3,
                                DRAMA, 5,
                                SCREAMER, 1,
                                MELODRAMA, 5
                        )),
                new Neighbor("Морфеус",
                        Map.of(
                                COMEDY, 2,
                                ACTION, 5,
                                DRAMA, 1,
                                SCREAMER, 3,
                                MELODRAMA, 1
                        ))
        )).findNearestNeighbor(new Neighbor("Прянка",
                Map.of(
                        COMEDY, 3,
                        ACTION, 4,
                        DRAMA, 4,
                        SCREAMER, 1,
                        MELODRAMA, 4
                ))));
    }
}
