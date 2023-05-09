package med.voll.api.paciente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import med.voll.api.medico.DadosListagemMedico;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DadosListagemPaciente {

    Long id;
    String nome;
    String email;
    String cpf;

    public DadosListagemPaciente(Paciente paciente){

        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.email = paciente.getEmail();
        this.cpf = paciente.getCpf();
    }
}
