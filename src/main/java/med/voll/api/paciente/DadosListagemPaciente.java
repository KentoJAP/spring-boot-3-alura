package med.voll.api.paciente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import med.voll.api.medico.DadosListagemMedico;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DadosListagemPaciente {
    String nome;
    String email;
    String cpf;

    public DadosListagemPaciente(Paciente paciente){
        this.nome = paciente.getNome();
        this.email = paciente.getEmail();
        this.cpf = paciente.getCpf();
    }
}
