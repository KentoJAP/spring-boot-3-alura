package med.voll.api.domain.consulta;

import lombok.*;
import med.voll.api.domain.medico.Especialidade;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DadosAgendamentoConsulta {

    @NotNull
    Long idPaciente;
    Long idMedico;
    @NotNull
    @Future
    LocalDateTime data;
    Especialidade especialidade;
}
