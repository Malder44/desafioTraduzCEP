package br.com.borges.leonorico.desafiotraduzcep.operadores;

import br.com.borges.leonorico.desafiotraduzcep.Endereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Serializador {

    Gson gson;

    public Serializador() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void converteListaEnderecosParaJson(List<Endereco> lista) {
        try {
            FileWriter writer = new FileWriter("enderecos.json");
            writer.write(gson.toJson(lista));
            writer.close();
        } catch(IOException e) {
            //retorna exceção caso tenha ocorrida algum erro de entrada
            throw new RuntimeException("Não foi possível gravar os dados em arquivo.");
        }
    }
}
