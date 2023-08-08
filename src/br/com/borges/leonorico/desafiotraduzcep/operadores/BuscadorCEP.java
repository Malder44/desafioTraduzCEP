package br.com.borges.leonorico.desafiotraduzcep.operadores;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscadorCEP {

    HttpClient client;
    HttpRequest request;
    HttpResponse<String> response;

    public BuscadorCEP() {
        client = HttpClient.newHttpClient();
    }

    public String consultaCEP(String busca) {
        if(busca.charAt(0) == '\n')
            throw new IllegalArgumentException("Entrada inválida");
        for(int i = 0; i < busca.length(); i++) {
            if(busca.charAt(i) < '0' || busca.charAt(i) > '9') {
                throw new IllegalArgumentException("CEP inválido");
            }
        }
        if(busca.length() != 8)
            throw new IllegalArgumentException("Número de dígitos incorreto.");
        busca = "https://viacep.com.br/ws/" + busca + "/json/";
        request = HttpRequest.newBuilder().uri(URI.create(busca)).build();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException("Ocorreu um erro inesperado.");
        }
        return response.body();
    }
}
