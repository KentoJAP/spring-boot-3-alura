package med.voll.api.medico;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

import javax.persistence.*;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded //acopla a classe Endereco à tabela
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome;
        this.crm = dados.crm;
        this.endereco = new Endereco(dados.endereco);
        this.especialidade = dados.especialidade;
        this.email = dados.email;
        this.telefone = dados.telefone;
    }
}
