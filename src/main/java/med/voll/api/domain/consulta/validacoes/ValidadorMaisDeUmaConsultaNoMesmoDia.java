package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoNegada;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMaisDeUmaConsultaNoMesmoDia implements Validador{

    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validar(DadosAgendamentoConsulta dados) {

        var primeiroHorario = dados.getData().withHour(7);
        var ultimoHorario = dados.getData().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.getIdPaciente(), primeiroHorario, ultimoHorario);
        if (pacientePossuiOutraConsultaNoDia) {
            throw new ValidacaoNegada("Paciente já possui uma consulta agendada nesse dia");
        }
    }
}
