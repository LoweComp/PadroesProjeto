package padroesEstruturais.decorator;

public class BuffetPremiumDec extends ServicoExtraDecorator {
    public BuffetPremiumDec(IFesta festa) {
        super(festa);
    }

    @Override
    public String getDescricao() {
        return festaDecorada.getDescricao() + ", Buffet Premium (Jantar Completo, Mesa de Frio & Aperitivos)";
    }

    @Override
    public double getCusto() {
        return festaDecorada.getCusto() + 3800.00;
    }
}
