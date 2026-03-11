package padroesCriacao.abstractfactory;

public class FabricaEletro implements FabricaProducao {
    public Iluminacao criarIluminacao() {
        return new IluminacaoLaser();
    }

    public EstruturaPalco criarEstruturaPalco() {
        return new EstruturaTech();
    }
}
