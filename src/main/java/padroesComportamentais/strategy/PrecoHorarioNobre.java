package padroesComportamentais.strategy;

public class PrecoHorarioNobre implements EstrategiaDePreco {
    @Override
    public double calcular(double precoBase) { return precoBase; }
}