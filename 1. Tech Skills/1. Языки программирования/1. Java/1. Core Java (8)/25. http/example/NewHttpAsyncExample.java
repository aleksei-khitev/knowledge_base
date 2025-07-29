import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.concurrent.CompletableFuture;

public class NewHttpAsyncExample {
    public static String GOOGLE_URL = "https://www.google.com";

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        var client = HttpClient.newBuilder().build();
        var request = HttpRequest.newBuilder(prepareUri()).build();
        var bodyHandler = HttpResponse.BodyHandlers.ofString(Charset.defaultCharset());
        CompletableFuture.allOf(
            client.sendAsync(request, bodyHandler)
                .thenAccept((resp) -> System.out.println(resp.body())),
            client.sendAsync(request, bodyHandler)
                .thenAccept((resp) -> System.out.println(resp.body())),
            client.sendAsync(request, bodyHandler)
                .thenAccept((resp) -> System.out.println(resp.body()))
        ).join();
        // С помощью join-а можно дождаться, пока все 3 запроса выполнятся
    }

    private static URI prepareUri() throws URISyntaxException {
        return new URI(GOOGLE_URL);
    }
}
