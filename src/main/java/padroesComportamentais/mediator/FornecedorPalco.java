package padroesComportamentais.mediator;

public class FornecedorPalco extends FornecedorComponente {
    private String status = "ESPERANDO";

    public FornecedorPalco(ICoordenadorDeShow mediator) { super(mediator); }

    public void iniciarMontagem() {
        this.status = "MONTAGEM ESTRUTURAL";
        enviarEvento("MONTAGEM_PALCO_CONCLUIDA");
    }

    public void iniciarDecoracao() {
        this.status = "DECORACAO FINALIZANDO";
    }

    @Override
    public String getStatus() { return "Palco: " + status; }
}
