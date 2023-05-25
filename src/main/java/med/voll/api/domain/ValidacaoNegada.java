package med.voll.api.domain;

public class ValidacaoNegada extends RuntimeException {
    public ValidacaoNegada(String mensagem) {
        super(mensagem);
    }
}
