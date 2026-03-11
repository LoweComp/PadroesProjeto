package padroesComportamentais.strategy;

public class PrecoPromocaoFidelidade implements EstrategiaDePreco {
    @Override
    public double calcular(double precoBase) {
        return precoBase * 0.80;
    }
}