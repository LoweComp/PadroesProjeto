package padroesEstruturais.proxy;

public interface IArtistaContrato {
    String getDetalhesPublicos();
    double getCustoContratacao(String permissao);
    String getDetalhesConfidenciais(String permissao);
}
