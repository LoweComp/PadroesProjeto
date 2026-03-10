package padroesEstruturais.bridge;

public class ProjetorLaser implements Exibicao{
    @Override
    public String carregarConteudo(String titulo) {
        return "Carregando " + titulo + " no servidor de projeção 4K.";
    }

    @Override
    public String iniciarExibicao() {
        return "Projeção iniciada (Laser HDR).";
    }
}
