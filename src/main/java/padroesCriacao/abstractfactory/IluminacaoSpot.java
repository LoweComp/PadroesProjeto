package padroesCriacao.abstractfactory;

public class IluminacaoSpot implements Iluminacao {
    private int voltagemRecebida;

    public IluminacaoSpot(int voltagem) { // Construtor recebe a voltagem
        this.voltagemRecebida = voltagem;

        if (voltagem < 200) {
            throw new IllegalArgumentException("ERRO: Iluminação Spot requer 220V, mas encontrou " + voltagem + "V.");
        }
    }
    public int getVoltagemRecebida() {
        return voltagemRecebida;
    }

    @Override
    public String configurarLuzes() {
        return "Iluminação com Spots de cores quentes e fumaça para rock. (Voltagem: " + voltagemRecebida + "V)";
    }


}
