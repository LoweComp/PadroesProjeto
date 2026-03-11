package padroesCriacao.abstractfactory;

public class FabricaRock implements FabricaProducao {
    private static final int VOLTAGEM_IDEAL = 220;

    public Iluminacao criarIluminacao() {
        return new IluminacaoSpot(VOLTAGEM_IDEAL);
    }
    public EstruturaPalco criarEstruturaPalco() {
        return new EstruturaRobusta();
    }
}
