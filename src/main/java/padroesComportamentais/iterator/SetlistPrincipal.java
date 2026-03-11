package padroesComportamentais.iterator;

public class SetlistPrincipal implements ISetlist {
    private String[] musicas;
    private int proximaPosicao = 0;

    public SetlistPrincipal(int tamanhoMaximo) {
        this.musicas = new String[tamanhoMaximo];
    }

    public void adicionarMusica(String nomeMusica) {
        if (proximaPosicao < musicas.length) {
            musicas[proximaPosicao] = nomeMusica;
            proximaPosicao++;
        }
    }

    public String[] getMusicas() {
        return musicas;
    }

    @Override
    public IIteradorDeMusicas criarIterador() {
        return new IteradorSetlistPrincipal(this.musicas);
    }
}
