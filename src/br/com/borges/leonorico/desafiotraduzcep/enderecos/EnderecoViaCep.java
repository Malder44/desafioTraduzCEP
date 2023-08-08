package br.com.borges.leonorico.desafiotraduzcep.enderecos;

//classe intermediária que recebe em seus atributos os dados vindos do JSON retornado pela API
public record EnderecoViaCep(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, boolean erro) {
}
