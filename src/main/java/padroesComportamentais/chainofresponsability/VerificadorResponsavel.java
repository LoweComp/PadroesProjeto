package padroesComportamentais.chainofresponsability;

public class VerificadorResponsavel extends VerificadorBase {
    @Override
    public ResultadoVerificacao verificar(Cliente cliente, int classificacaoFilme) {
        if (cliente.getResponsavelLegal()) {
            return new ResultadoVerificacao(true, "Aceito com restrição: Menor de idade acompanhado por responsável.");
        }
        return new ResultadoVerificacao(false, "Rejeição final: Cliente menor de idade não acompanhado.");
    }
}