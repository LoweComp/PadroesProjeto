package padroesComportamentais.iterator;

import java.util.ArrayList;

public class IteradorSetlistEncore implements IIteradorDeMusicas {
    private ArrayList<String> musicas;
    private int posicao = 0;

    public IteradorSetlistEncore(ArrayList<String> musicas) {
        this.musicas = musicas;
    }

    @Override
    public boolean hasNext() {
        return posicao < musicas.size();
    }

    @Override
    public String next() {
        String musica = musicas.get(posicao);
        posicao++;
        return musica;
    }
}