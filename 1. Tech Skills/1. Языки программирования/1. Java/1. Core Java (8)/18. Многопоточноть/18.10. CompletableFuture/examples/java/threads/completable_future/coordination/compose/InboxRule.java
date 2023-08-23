package threads.completable_future.coordination.compose;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class InboxRule {
    private static String[] almostSpamList = new String[]{"donotreply@usefyl.com", "info@notbad.org"};
    public static void main(String[] args) {
        CompletableFuture<List<Email>> emailsAfterRules = CompletableFuture
                .supplyAsync(InboxRule::readInbox)
                .thenCompose(inbox ->
                        CompletableFuture.supplyAsync(() ->
                                inbox.stream().peek(email -> {
                                    for (String almostSpam : almostSpamList) {
                                        if (email.getFrom().equals(almostSpam)) {
                                            email.setAutoRead(true);
                                        }
                                    }
                                }).filter(Email::isEmailForRead).collect(Collectors.toList())));
        System.out.println(emailsAfterRules.join());
    }

    private static List<Email> readInbox() {
        List<Email> inbox = new ArrayList<>();
        Collections.addAll(inbox,
                new Email("donotreply@usefyl.com"),
                new Email("donotreply@customer.com"),
                new Email("info@notbad.org"),
                new Email("info@work.ru"),
                new Email("chief@work.ru"));
        return inbox;
    }
}
