package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoNegada;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;
import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements Validador{

    @Override
    public void validar(DadosAgendamentoConsulta dados){

        var domingo = dados.getData().getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var horarioAbertura = dados.getData().getHour() < 7;
        var horarioFechamento = dados.getData().getHour() > 18;

        if(domingo || horarioAbertura || horarioFechamento){
            throw new ValidacaoNegada("Horário fora do horário de funcionamento da clínica");
        }
    }
}
