package padroesEstruturais.decorator;

public class BandaDec extends ServicoExtraDecorator {
    private int horasContratadas;
    private static final double CUSTO_POR_HORA = 400.00;

    public BandaDec(IFesta festa, int horas) {
        super(festa);
        this.horasContratadas = horas;
    }

    @Override
    public String getDescricao() {
        return festaDecorada.getDescricao() +
                String.format(", Banda Sertaneja/Pagode (%d horas)", horasContratadas);
    }

    @Override
    public double getCusto() {
        return festaDecorada.getCusto() + (CUSTO_POR_HORA * horasContratadas);
    }
}
