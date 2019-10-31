package ru.akhitev.kb.java8.multithreading.completable_future.coordination;

import java.util.concurrent.CompletableFuture;

public class WorkWithProblemTicket {
    public static void main(String[] args) {
        CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("Тут, видимо, неправильное значение приходит из Perl");
                    System.out.println("Проконсультируюсь с Perl-разработчиокм");
                    return "Подскажи, где тут может быть проблема?";
                })
                .thenApply((question) -> {
                    System.out.println("Нашел проблему на вопрос: " + question);
                    return "Проблему тут";
                })
                .thenAccept((replyFromPerlEngineer) -> {
                    System.out.println("Пишу в тикет, что мы уже занимаемся решением проблемы");
                    System.out.println("Добавляю комментарий от Perl-разработчика: " + replyFromPerlEngineer);
                });
    }
}
