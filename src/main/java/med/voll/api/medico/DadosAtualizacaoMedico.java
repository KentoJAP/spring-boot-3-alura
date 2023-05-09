package med.voll.api.medico;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.Endereco;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DadosAtualizacaoMedico {

    @NotNull
    Long id;
    String nome;
    String telefone;
    @Valid DadosEndereco endereco;

}
