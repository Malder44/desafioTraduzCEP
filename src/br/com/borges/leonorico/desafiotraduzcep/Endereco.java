package br.com.borges.leonorico.desafiotraduzcep;

import java.util.Scanner;

public class Endereco {

    private int cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String municipio;
    private String estado;
    private Scanner scanner;

    public Endereco(EnderecoViaCep enderecoViaCep) {
        //recebe a classe intermediaria que abriga em seus atributos os dados vindos do JSON
        this.cep = Integer.valueOf(enderecoViaCep.cep().replace("-",""));
        this.rua = enderecoViaCep.logradouro();
        this.complemento = enderecoViaCep.complemento();
        this.bairro = enderecoViaCep.bairro();
        this.municipio = enderecoViaCep.localidade();
        this.estado = enderecoViaCep.uf();
    }

    @Override
    public String toString() {
        return "(" +
                "CEP = \"" + cep + "\"" +
                ", Rua = \"" + rua + "\"" +
                ", Complemento = \"" + complemento + "\"" +
                ", Bairro = \"" + bairro + "\"" +
                ", Municipio = \"" + municipio + "\"" +
                ", Estado = \"" + estado + "\"" +
                ')';
    }

    public void adicionaComplemento() {
        scanner = new Scanner(System.in);
        String resposta;

        if(verificaComplemento()) {
            System.out.println("Não há complemento para o determinado endereço. Deseja adicionar complemento ao endereço?");
            resposta = scanner.nextLine();
            if(resposta.equalsIgnoreCase("sim")) {
                System.out.println("Informe o complemento para ser inserido");
                resposta = scanner.nextLine();
                this.complemento = resposta;
            }
        }
    }

    public boolean verificaComplemento() {
        return this.complemento.equalsIgnoreCase("");
    }
}
