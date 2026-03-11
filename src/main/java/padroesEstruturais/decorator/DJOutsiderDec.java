package padroesEstruturais.decorator;

public class DJOutsiderDec extends ServicoExtraDecorator {
    private int horasContratadas;
    private static final double CUSTO_POR_HORA = 600.00;

    public DJOutsiderDec(IFesta festa, int horas) {
        super(festa);
        this.horasContratadas = horas;
    }

    @Override
    public String getDescricao() {
        return festaDecorada.getDescricao() +
                String.format(", DJ LoweZera (%d horas)", horasContratadas);
    }

    @Override
    public double getCusto() {
        return festaDecorada.getCusto() + (CUSTO_POR_HORA * horasContratadas);
    }
}
