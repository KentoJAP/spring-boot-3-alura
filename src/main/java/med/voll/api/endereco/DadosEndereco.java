package med.voll.api.endereco;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@AllArgsConstructor
@NoArgsConstructor
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
