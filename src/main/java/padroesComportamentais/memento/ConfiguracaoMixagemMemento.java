package padroesComportamentais.memento;

// O Memento: Armazena o estado, Imutável
public class ConfiguracaoMixagemMemento {
    private final int nivelEQ;
    private final int nivelCompressor;

    public ConfiguracaoMixagemMemento(int nivelEQ, int nivelCompressor) {
        this.nivelEQ = nivelEQ;
        this.nivelCompressor = nivelCompressor;
    }

    int getNivelEQ() {
        return nivelEQ;
    }
    int getNivelCompressor() {
        return nivelCompressor;
    }
}
