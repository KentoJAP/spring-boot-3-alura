package med.voll.api.medico;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DadosListagemMedico {

    Long id;
    String nome;
    String email;
    String crm;
    Especialidade especialidade;

    public DadosListagemMedico(Medico medico) {

        //this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
        this.id = medico.getId();
        this.nome = medico.getNome();
        this.email = medico.getEmail();
        this.crm = medico.getCrm();
        this.especialidade = medico.getEspecialidade();
    }
}
