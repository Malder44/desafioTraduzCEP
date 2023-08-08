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
            //retorna exceção se caractere inserido for apenas "enter"
            throw new IllegalArgumentException("Entrada inválida");
        for(int i = 0; i < busca.length(); i++) {
            if(busca.charAt(i) < '0' || busca.charAt(i) > '9') {
                //retorna exceção se algum caractere inserido não for um número de 0 a 9
                throw new IllegalArgumentException("CEP inválido");
            }
        }
        if(busca.length() != 8)
            //retorna exceção se o número de caracteres não for 8
            throw new IllegalArgumentException("Número de dígitos incorreto.");
        busca = "https://viacep.com.br/ws/" + busca + "/json/";
        request = HttpRequest.newBuilder().uri(URI.create(busca)).build();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException e) {
            //retorna exceção caso ocorra um erro de entrada ou interrupção de execução do método send()
            throw new RuntimeException("Ocorreu um erro inesperado.");
        }
        return response.body();
    }
}
