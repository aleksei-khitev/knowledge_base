package threads.completable_future.coordination;

import java.util.concurrent.CompletableFuture;

public class PreparingScienceArticle {
    public static void main(String[] args) {
        Article printedArticle = CompletableFuture
                .supplyAsync(() -> {
                    Article article = new Article();
                    article.theme = "Важная проблема";
                    System.out.println("Оговорена тема с научным руководителем");
                    return article;
                })
                .thenApply((article) -> {
                    article.magazine = "Журнал ПИ";
                    System.out.println("Найден подходящий журнал");
                    return article;
                })
                .thenApply((article) -> {
                    article.text = "Много умных идей";
                    System.out.println("Статья написана");
                    return article;
                })
                .thenApply((article) -> {
                    article.recommendations = "Поправить тут и там";
                    System.out.println("Научный руководитель составил рекоммендации");
                    return article;
                })
                .thenApply((article) -> {
                    article.text = "Правильно изложенный умные мысли";
                    System.out.println("Проблемы в статье устранены");
                    return article;
                })
                .thenApply((article) -> {
                    System.out.println("Статья отправлена в печать");
                    return article;
                })
                .join();
        System.out.println(printedArticle);
    }

    private static class Article {
        private String theme;
        private String magazine;
        private String text;
        private String recommendations;

        @Override
        public String toString() {
            return "Article{ theme='" + theme + '\'' +
                    ", magazine='" + magazine + '\'' +
                    ", text='" + text + '\'' +
                    ", recommendations='" + recommendations + '\'' +
                    '}';
        }
    }
}
