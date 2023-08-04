package br.com.borges.leonorico.desafiotraduzcep;

public class Endereco {

    private int cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String municipio;
    private String estado;

    public Endereco(EnderecoViaCep enderecoViaCep) {
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
}
