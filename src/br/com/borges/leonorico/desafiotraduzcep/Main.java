/*
Desenvolvido em agosto de 2023 por Leonorico Borges.
- Email: leonorico.borges@gmail.com
- LinkedIn: https://www.linkedin.com/in/leonorico-borges-dev/
- Github: https://github.com/Malder44
 */

package br.com.borges.leonorico.desafiotraduzcep;

import br.com.borges.leonorico.desafiotraduzcep.enderecos.Endereco;
import br.com.borges.leonorico.desafiotraduzcep.operadores.BuscadorCEP;
import br.com.borges.leonorico.desafiotraduzcep.operadores.Desserializador;
import br.com.borges.leonorico.desafiotraduzcep.operadores.Serializador;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String busca, enderecoJson;
        Endereco endereco;
        BuscadorCEP buscador = new BuscadorCEP();
        Desserializador desserializador = new Desserializador();
        Serializador serializador = new Serializador();
        List<Endereco> enderecos = new ArrayList<>();

        System.out.println("Informe o CEP para busca: ");
        busca = teclado.nextLine();

        while(!busca.equalsIgnoreCase("sair")) {
            try {
                enderecoJson = buscador.consultaCEP(busca);
                endereco = desserializador.converteJsonParaEndereco(enderecoJson);
                endereco.adicionaComplemento();
                enderecos.add(endereco);
            } catch(IllegalArgumentException | NoSuchElementException e) {
                //tratamento de exceção caso seja inserido um valor errado
                //ou o retorno de um CEP inexistente
                System.out.println(e.getMessage());
            } catch(RuntimeException e) {
                //resposta a um erro inesperado
                System.out.println(e.getMessage());
            }
            System.out.println("Informe o CEP para busca: ");
            busca = teclado.nextLine();
        }

        try {
            serializador.converteListaEnderecosParaJson(enderecos);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
