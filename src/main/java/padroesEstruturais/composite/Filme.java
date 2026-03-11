package padroesEstruturais.composite;

public class Filme implements IItemAcervo {
    private String titulo;
    private int duracao; // mins

    public Filme(String titulo, int duracao) {
        this.titulo = titulo;
        this.duracao = duracao;
    }

    @Override
    public String exibirDetalhes() {
        return " - Filme: " + titulo + " (" + duracao + " min)";
    }

    @Override
    public int getDuracaoEmMinutos() {
        return duracao;
    }

    public String getTitulo() { return titulo; }
}
