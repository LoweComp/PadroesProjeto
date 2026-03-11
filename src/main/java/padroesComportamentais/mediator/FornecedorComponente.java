package padroesComportamentais.mediator;

public abstract class FornecedorComponente {
    protected ICoordenadorDeShow mediator;

    public FornecedorComponente(ICoordenadorDeShow mediator) {
        this.mediator = mediator;
    }

    public void enviarEvento(String evento) {
        this.mediator.notificar(this, evento);
    }

    public abstract String getStatus();
}