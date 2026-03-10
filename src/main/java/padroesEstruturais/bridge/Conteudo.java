package padroesEstruturais.bridge;

public abstract class Conteudo {
    protected Exibicao tecnologia;
    protected String titulo;

    public Conteudo(Exibicao tecnologia, String titulo) {
        this.tecnologia = tecnologia;
        this.titulo = titulo;
    }

    public abstract String exibirConteudo();
}
