package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoNegada;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements Validador{

    @Autowired
    MedicoRepository repository;
    @Override
    public void validar(DadosAgendamentoConsulta dados) {

        if(dados.getIdMedico() == null){
            return;
        }
        var medicoEstaAtivo = repository.findAtivoById(dados.getIdMedico());

        if(!medicoEstaAtivo){
            throw new ValidacaoNegada("Este médico está inativo.");
        }
    }
}
