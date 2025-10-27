package dinamic_programming.back_pack;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        BackPackOptimizer backPackOptimizer = new BackPackOptimizer(4, List.of(
                new Item("Гитара", 1, 1500),
                new Item("Магнитофон", 4, 3000),
                new Item("Ноутбук", 3, 2000),
                new Item("iPhone", 1, 2000)
        ));
        System.out.println(backPackOptimizer.getOptimalKit());
        System.out.println(backPackOptimizer.priceForOptimalKit());
    }
}
