package padroesComportamentais.chainofresponsability;

public class VerificadorDocumento extends VerificadorBase {
    @Override
    public ResultadoVerificacao verificar(Cliente cliente, int classificacaoFilme) {
        if (!cliente.getPossuiRG()) {
            return new ResultadoVerificacao(false, "Falha na verificação de documento: Cliente sem RG.");
        }
        return passarParaOProximo(cliente, classificacaoFilme);
    }
}