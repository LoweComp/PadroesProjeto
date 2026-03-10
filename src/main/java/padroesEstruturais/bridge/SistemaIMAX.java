package padroesEstruturais.bridge;

public class SistemaIMAX implements Exibicao {
    @Override
    public String carregarConteudo(String titulo) {
        return "Preparando " + titulo + " para tela expandida.";
    }

    @Override
    public String iniciarExibicao() {
        return "Exibição iniciada (Tela IMAX e Áudio Imersivo).";
    }
}
