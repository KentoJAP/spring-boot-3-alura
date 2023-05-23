package med.voll.api.domain.consulta;

import med.voll.api.domain.ValidacaoNegada;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public void agendar(DadosAgendamentoConsulta dados){

        if(!pacienteRepository.existsById(dados.getIdPaciente())){
            throw new ValidacaoNegada("Não existe paciente com esse ID.");
        }
        if(dados.getIdMedico()!=null && !medicoRepository.existsById(dados.getIdMedico())){
            throw new ValidacaoNegada("Não existe médico com esse ID.");
        }

        var paciente = pacienteRepository.getReferenceById(dados.getIdPaciente());
        //var medico = medicoRepository.findById(dados.getIdMedico()).get();
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null, paciente, medico, dados.getData(), null);

        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {

        if(dados.getIdMedico()==null){
            return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.getEspecialidade(), dados.getData());
        }
        if(dados.getEspecialidade() == null){
            throw new ValidacaoNegada("A especialidade é obrigatória quando não há médico");
        }
        return medicoRepository.getReferenceById(dados.getIdMedico());
    }

    public void cancelar(DadosCancelamentoConsulta dados) {

        if(!consultaRepository.existsById(dados.getIdConsulta())){
            throw new ValidacaoNegada("O id da consulta não existe.");
        }

        var consulta = consultaRepository.getReferenceById(dados.getIdConsulta());
        consulta.cancelar(dados.getMotivo());
    }
}
