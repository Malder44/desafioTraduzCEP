import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner teclado = new Scanner(System.in);
        String busca = "", link;
        List<Endereco> enderecos = new ArrayList<>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        while(!busca.equalsIgnoreCase("sair")) {
            System.out.println("Informe o CEP para busca: ");
            busca = teclado.nextLine();

            if(busca.equalsIgnoreCase("sair"))
                break;

            //ConsultaCep
            link = "https://viacep.com.br/ws/" + busca + "/json/";
            System.out.println(link);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(link))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            //Desserializador
            EnderecoViaCep enderecoViaCep = gson.fromJson(response.body(), EnderecoViaCep.class);
            System.out.println(enderecoViaCep);
            Endereco endereco = new Endereco(enderecoViaCep);
            System.out.println(endereco.toString());
            //ListaEndereco
            enderecos.add(endereco);
            System.out.println(enderecos);
        }
        //Serializador
        FileWriter writer = new FileWriter("enderecos.json");
        writer.write(gson.toJson(enderecos));
        writer.close();
    }
}
