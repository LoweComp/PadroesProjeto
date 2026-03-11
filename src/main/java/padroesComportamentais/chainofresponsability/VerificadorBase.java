package padroesComportamentais.chainofresponsability;

public abstract class VerificadorBase implements IVerificador {
    private IVerificador proximo;

    @Override
    public IVerificador setProximo(IVerificador proximo) {
        this.proximo = proximo;
        return proximo;
    }

    protected ResultadoVerificacao passarParaOProximo(Cliente cliente, int classificacaoFilme) {
        if (this.proximo != null) {
            return this.proximo.verificar(cliente, classificacaoFilme);
        }
        return new ResultadoVerificacao(false, "Cadeia de verificação esgotada. Requisitos não atendidos.");
    }
}