package padroesComportamentais.strategy;

public class PrecoMeiaEntrada implements EstrategiaDePreco {
    @Override
    public double calcular(double precoBase) { return precoBase * 0.50; }
}
