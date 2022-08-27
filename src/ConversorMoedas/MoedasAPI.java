package ConversorMoedas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public abstract class MoedasAPI {

    public static Double getCotacao(String moeda1, String moeda2) throws IOException, InterruptedException {

        String URLBase = "https://api.invertexto.com/v1/currency/";

        String token = "?token=XsUOdWPyU1xnK5M3hCOZJgZ4L7bqioNR";
         HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URLBase + moeda1 + "_" + moeda2 + token))
                .build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        String dadosApi = response.body();

        //extraindo o valor da cotação do item "price"
        String[] values = dadosApi.split(":|,");
        return Double.parseDouble(values[2]);
    }

    public MoedasAPI() throws IOException, InterruptedException {
    }
}
