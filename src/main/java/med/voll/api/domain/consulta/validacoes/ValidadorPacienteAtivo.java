package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoNegada;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements Validador{

    @Autowired
    PacienteRepository repository;
    @Override
    public void validar(DadosAgendamentoConsulta dados) {

        var pacienteEstaAtivo = repository.findAtivoById(dados.getIdPaciente());

        if(!pacienteEstaAtivo) {
            throw new ValidacaoNegada("Este paciente está inativo");
        }
    }
}
