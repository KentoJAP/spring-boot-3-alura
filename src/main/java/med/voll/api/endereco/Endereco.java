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
}
