package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoNegada;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAgendadoNoMesmoHorario implements Validador{

    @Autowired
    ConsultaRepository repository;

    @Override
    public void validar(DadosAgendamentoConsulta dados) {

        var medicoPossuiOutraConsultaNoMesmoHorario =
                repository.existsByMedicoIdAndDataAndMotivoIsNull(dados.getIdMedico(), dados.getData());

        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoNegada("Médico já possui outra consulta agendada nesse mesmo horário");
        }
    }
}
