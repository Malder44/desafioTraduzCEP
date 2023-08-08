package br.com.borges.leonorico.desafiotraduzcep.operadores;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {

    link = "https://viacep.com.br/ws/" + busca + "/json/";
            System.out.println(link);
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(link))
            .build();
    HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
}
