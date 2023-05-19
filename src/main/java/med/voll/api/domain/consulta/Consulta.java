package med.voll.api.domain.consulta;

import lombok.*;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDateTime;

@Table(name = "consultas")
@Entity(name = "Consulta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;
    private LocalDateTime data;

    public Consulta(DadosAgendamentoConsulta dados){

    }
}