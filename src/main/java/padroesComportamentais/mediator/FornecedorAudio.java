package padroesComportamentais.mediator;

public class FornecedorAudio extends FornecedorComponente {
    private String status = "ESPERANDO";

    public FornecedorAudio(ICoordenadorDeShow mediator) { super(mediator); }

    public void iniciarInstalacao() {
        this.status = "INSTALACAO CABEAMENTO";
    }

    public void notificarInstalacaoConcluida() {
        enviarEvento("INSTALACAO_AUDIO_CONCLUIDA");
    }

    @Override
    public String getStatus() { return "Áudio: " + status; }
}