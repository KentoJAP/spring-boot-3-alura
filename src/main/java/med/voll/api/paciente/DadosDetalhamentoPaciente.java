package med.voll.api.paciente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

import javax.persistence.Embedded;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DadosDetalhamentoPaciente {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Endereco endereco;
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.email = paciente.getEmail();
        this.telefone = paciente.getTelefone();
        this.cpf = paciente.getCpf();
        this.endereco = paciente.getEndereco();
    }
}
