package med.voll.api.domain.consulta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.medico.DadosDetalhamentoMedico;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DadosDetalhamentoConsulta {

    private Long id;
    private Long paciente;
    private Long medico;
    private LocalDateTime data;

    public DadosDetalhamentoConsulta(Consulta consulta){
        this.id = consulta.getId();
        this.paciente = consulta.getPaciente().getId();
        this.medico = consulta.getMedico().getId();
        this.data = consulta.getData();
    }

}
