package dinamic_programming.tour_rout;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        var tourPlanner = new TourPlanner(2, List.of(
                new InterestingPlace("Вестминстерское Аббатство", 0.5, 7),
                new InterestingPlace("Театр Глобус", 1.5, 6),
                new InterestingPlace("Национальная галерея", 1, 9),
                new InterestingPlace("Британский музей", 2, 9),
                new InterestingPlace("Собор св. Павла", 0.2, 8)
        ));
        System.out.println(tourPlanner.optimize());
        System.out.println(tourPlanner.wantToVisitForceCoveredByOptimalTout());
    }
}
