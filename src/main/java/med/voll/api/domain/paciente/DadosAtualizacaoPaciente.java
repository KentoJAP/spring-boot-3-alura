package med.voll.api.domain.paciente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import med.voll.api.domain.endereco.DadosEndereco;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DadosAtualizacaoPaciente {

    @NotNull
    Long id;
    String nome;
    String telefone;
    @Valid DadosEndereco endereco;

}
