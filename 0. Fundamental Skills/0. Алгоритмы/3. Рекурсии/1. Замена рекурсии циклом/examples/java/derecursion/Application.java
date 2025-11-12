package derecursion;

public class Application {
    public static void main(String[] args) {
        Box box = new Box(
                false,
                new Box(
                        false,
                        new Box(false),
                        new Box(
                                false,
                                new Box(true))));
        System.out.println(new Derecursion().hasKey(box));
    }
}