package breadth_first_search;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, List<String>> starSystems = Map.of(
                "Земля", List.of("Проксима", "Бета Дюрани"),
                "Бета Дюрани", List.of("Вега", "Тау Кита"),
                "Проксима", List.of("Эпсилон Эридани", "Альфа Центавр")
        );
        System.out.println(new BfsSearcher().search(starSystems, "Земля", "Эпсилон Эридани"));
    }
}
