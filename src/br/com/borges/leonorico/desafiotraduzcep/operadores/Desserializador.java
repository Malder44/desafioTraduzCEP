package br.com.borges.leonorico.desafiotraduzcep.operadores;

import br.com.borges.leonorico.desafiotraduzcep.Endereco;
import br.com.borges.leonorico.desafiotraduzcep.EnderecoViaCep;
import com.google.gson.Gson;

import java.util.NoSuchElementException;

public class Desserializador {

    Gson gson;
    EnderecoViaCep enderecoViaCep;
    Endereco endereco;

    public Desserializador() {
        gson = new Gson();
    }

    public Endereco converteJsonParaEndereco(String json) {
        enderecoViaCep = gson.fromJson(json, EnderecoViaCep.class);
        if(enderecoViaCep.erro()) {
            throw new NoSuchElementException("Esse CEP não existe.");
        }
        endereco = new Endereco(enderecoViaCep);
        System.out.println(endereco.toString());
        return endereco;
    }
}
