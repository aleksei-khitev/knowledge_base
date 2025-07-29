import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;

public class NewHttpSyncExample {
    public static String GOOGLE_URL = "https://www.google.com";

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        var client = HttpClient.newBuilder().build();
        var request = HttpRequest.newBuilder(prepareUri()).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString(Charset.defaultCharset()));
        System.out.println(response.body());
    }

    private static URI prepareUri() throws URISyntaxException {
        return new URI(GOOGLE_URL);
    }
}
