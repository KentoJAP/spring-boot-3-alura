package med.voll.api.endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable //a classe é separada, mas pode ser acoplada a outras tabelas
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro;
        this.bairro = dados.bairro;
        this.cep = dados.cep;
        this.cidade = dados.cidade;
        this.uf = dados.uf;
        this.numero = dados.numero;
        this.complemento = dados.complemento;
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if(dados.logradouro != null){
            this.logradouro = dados.getLogradouro();
        }
        if(dados.bairro != null){
            this.bairro = dados.getBairro();
        }
        if(dados.cep != null){
            this.cep = dados.getCep();
        }
        if(dados.cidade != null){
            this.cidade = dados.getCidade();
        }
        if(dados.uf != null){
            this.uf = dados.getUf();
        }
        if(dados.numero != null){
            this.numero = dados.getNumero();
        }
        if(dados.complemento != null){
            this.complemento = dados.getComplemento();
        }
    }
}
