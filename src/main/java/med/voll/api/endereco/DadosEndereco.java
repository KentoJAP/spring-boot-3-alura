package med.voll.api.endereco;

import lombok.Builder;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Builder
@ToString
public class DadosEndereco {

    @NotBlank
    String logradouro;
    @NotBlank
    String bairro;
    @NotBlank
    @Pattern(regexp ="\\d{8}")
    String cep;
    @NotBlank
    String cidade;
    @NotBlank
    String uf;
    String numero;
    String complemento;

}
