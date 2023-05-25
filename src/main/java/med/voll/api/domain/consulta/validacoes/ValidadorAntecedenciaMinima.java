package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoNegada;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorAntecedenciaMinima implements Validador{

    @Override
    public void validar(DadosAgendamentoConsulta dados) {

        var horario = dados.getData();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, horario).toMinutes();

        if(diferencaEmMinutos < 30){
            throw new ValidacaoNegada("O agendamento tem que ser feito com pelo" +
                    "menos 30 minutos de antecedência.");
        }
    }
}
