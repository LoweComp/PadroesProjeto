package padroesEstruturais.decorator;

public class OpenBarDec extends ServicoExtraDecorator{
    public OpenBarDec(IFesta festa) {
        super(festa);
    }

    @Override
    public String getDescricao() {
        return festaDecorada.getDescricao() + ", Open Bar de bebidas alcoolicas, refrigerante, água e sucos";
    }

    @Override
    public double getCusto() {
        return festaDecorada.getCusto() + 2000.00;
    }
}
