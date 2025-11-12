package euclidean_algorithm;

public class Application {
    public static void main(String[] args) {
        int quardantCount = new EuclideanProcessor().getMinimalQuadrantCount(1680, 640);
        System.out.println(quardantCount);
    }
}
