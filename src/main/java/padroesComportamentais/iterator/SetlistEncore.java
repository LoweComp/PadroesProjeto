package padroesComportamentais.iterator;

import java.util.ArrayList;

public class SetlistEncore implements ISetlist {
    private ArrayList<String> musicas;

    public SetlistEncore() {
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(String nomeMusica) {
        musicas.add(nomeMusica);
    }

    public ArrayList<String> getMusicas() {
        return musicas;
    }

    @Override
    public IIteradorDeMusicas criarIterador() {
        return new IteradorSetlistEncore(this.musicas);
    }
}
