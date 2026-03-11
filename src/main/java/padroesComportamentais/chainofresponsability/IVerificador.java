package padroesComportamentais.chainofresponsability;

public interface IVerificador {
    IVerificador setProximo(IVerificador proximo);

    ResultadoVerificacao verificar(Cliente cliente, int classificacaoFilme);
}