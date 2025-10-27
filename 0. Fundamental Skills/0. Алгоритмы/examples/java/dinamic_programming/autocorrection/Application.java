package dinamic_programming.autocorrection;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println(new PossibleCorrectWordFinder(List.of(
                "FORT",
                "FISH"
        )).findMostPossibleCorrectWord("FOSH"));
    }
}
