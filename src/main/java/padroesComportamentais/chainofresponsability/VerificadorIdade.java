package padroesComportamentais.chainofresponsability;

public class VerificadorIdade extends VerificadorBase {
    @Override
    public ResultadoVerificacao verificar(Cliente cliente, int classificacaoFilme) {
        if (cliente.getIdade() >= classificacaoFilme) {
            return new ResultadoVerificacao(true, "Idade OK (" + cliente.getIdade() + " anos). Entrada permitida.");
        }
        return passarParaOProximo(cliente, classificacaoFilme);
    }
}
