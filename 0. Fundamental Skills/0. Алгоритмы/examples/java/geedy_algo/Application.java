package geedy_algo;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println(new RadioCoverageCalculator().calcualte(List.of(
                new RadioStation("One", List.of("id", "nv", "ut")),
                new RadioStation("Two", List.of("wa", "id", "mt")),
                new RadioStation("Three", List.of("or", "nv", "ca")),
                new RadioStation("Four", List.of("nv", "ut")),
                new RadioStation("Five", List.of("ca", "az"))
        )));
    }
}
