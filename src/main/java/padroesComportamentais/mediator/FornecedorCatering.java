package padroesComportamentais.mediator;

public class FornecedorCatering extends FornecedorComponente {
    private String status = "ESPERANDO";

    public FornecedorCatering(ICoordenadorDeShow mediator) { super(mediator); }

    public void entregarRefeicaoStaff() {
        this.status = "REFEICAO ENTREGUE";
    }

    @Override
    public String getStatus() { return "Catering: " + status; }
}
