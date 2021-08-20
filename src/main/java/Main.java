import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException, InterruptedException {
        String from;
        String to;
        String translatedWord;
        Scanner scanner = new Scanner(System.in);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://google-translate20.p.rapidapi.com/languages"))
                .header("x-rapidapi-host", "google-translate20.p.rapidapi.com")
                .header("x-rapidapi-key", "155af4bc40mshbdd0885dd7016a6p158c7ejsn441590d326d8")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        System.out.println("Language From: ");
        from = scanner.nextLine();
        System.out.println("Language To: ");
        to = scanner.nextLine();
        System.out.println("Sentence/Word to Translate");
        translatedWord = scanner.nextLine();

        // Translate Text with POST
        HttpRequest requestTranslate = HttpRequest.newBuilder()
                .uri(URI.create("https://google-translate20.p.rapidapi.com/translate"))
                .header("content-type", "application/x-www-form-urlencoded")
                .header("x-rapidapi-host", "google-translate20.p.rapidapi.com")
                .header("x-rapidapi-key", "155af4bc40mshbdd0885dd7016a6p158c7ejsn441590d326d8")
                .method("POST", HttpRequest.BodyPublishers.ofString("text="+translatedWord+"&tl="+to+"&sl="+from))
                .build();
        HttpResponse<String> responseTranslate = HttpClient.newHttpClient().send(requestTranslate, HttpResponse.BodyHandlers.ofString());
        System.out.println(responseTranslate.body());


    }
}
