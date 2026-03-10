package padroesEstruturais.bridge;

public class Lancamento extends Conteudo {
    public Lancamento(Exibicao tecnologia, String titulo) {
        super(tecnologia, titulo);
    }

    @Override
    public String exibirConteudo() {
        String statusCarga = this.tecnologia.carregarConteudo(titulo);
        String statusExibicao = this.tecnologia.iniciarExibicao();
        return titulo + " - Status: " + statusCarga + " | " + statusExibicao + " (DRM de cinema ativo)";
    }

    public String aplicarBloqueioDRM() {
        return "Bloqueio de cópia ativado via " + this.tecnologia.getClass().getSimpleName();
    }
}

