package med.voll.api.domain.consulta;

import med.voll.api.domain.ValidacaoNegada;
import med.voll.api.domain.consulta.validacoes.Validador;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private List<Validador> validadores;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados){

        if(!pacienteRepository.existsById(dados.getIdPaciente())){
            throw new ValidacaoNegada("Não existe paciente com esse ID.");
        }
        if(dados.getIdMedico()!=null && !medicoRepository.existsById(dados.getIdMedico())){
            throw new ValidacaoNegada("Não existe médico com esse ID.");
        }

        validadores.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository.getReferenceById(dados.getIdPaciente());
        //var medico = medicoRepository.findById(dados.getIdMedico()).get();
        var medico = escolherMedico(dados);

        if(medico == null){
            throw new ValidacaoNegada("Não existe médico disponível na data.");
        }
        var consulta = new Consulta(null, paciente, medico, dados.getData(), null);
        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {

        if(dados.getIdMedico()!=null){
            return medicoRepository.getReferenceById(dados.getIdMedico());
        }
        if(dados.getEspecialidade() == null){
            throw new ValidacaoNegada("A especialidade é obrigatória quando não há médico");
        }
        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.getEspecialidade(), dados.getData());
    }

    public void cancelar(DadosCancelamentoConsulta dados) {

        if(!consultaRepository.existsById(dados.getIdConsulta())){
            throw new ValidacaoNegada("O id da consulta não existe.");
        }

        var consulta = consultaRepository.getReferenceById(dados.getIdConsulta());
        consulta.cancelar(dados.getMotivo());
    }
}
