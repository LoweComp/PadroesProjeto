package padroesComportamentais.iterator;

public class IteradorSetlistPrincipal implements IIteradorDeMusicas {
    private String[] musicas;
    private int posicao = 0;

    public IteradorSetlistPrincipal(String[] musicas) {
        this.musicas = musicas;
    }

    @Override
    public boolean hasNext() {
        return posicao < musicas.length && musicas[posicao] != null;
    }

    @Override
    public String next() {
        String musica = musicas[posicao];
        posicao++;
        return musica;
    }
}