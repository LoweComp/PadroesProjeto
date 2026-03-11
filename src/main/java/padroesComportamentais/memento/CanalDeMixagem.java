package padroesComportamentais.memento;

// Originator: Sabe criar e restaurar o próprio estado
public class CanalDeMixagem {
    private int nivelEQ = 0;
    private int nivelCompressor = 0;

    public void setConfiguracao(int novoEQ, int novoCompressor) {
        this.nivelEQ = novoEQ;
        this.nivelCompressor = novoCompressor;
    }

    public ConfiguracaoMixagemMemento salvarEstado() {
        return new ConfiguracaoMixagemMemento(nivelEQ, nivelCompressor);
    }

    public void restaurarEstado(ConfiguracaoMixagemMemento memento) {
        this.nivelEQ = memento.getNivelEQ();
        this.nivelCompressor = memento.getNivelCompressor();
    }

    public String getStatus() {
        return "EQ: " + nivelEQ + ", Compressor: " + nivelCompressor;
    }
    public int getNivelEQ() { return nivelEQ; }
}
