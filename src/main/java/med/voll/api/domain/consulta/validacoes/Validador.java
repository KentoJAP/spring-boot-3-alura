package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public interface Validador {

    void validar(DadosAgendamentoConsulta dados);
}
