package padroesComportamentais.mediator;

public class CoordenadorDeShow implements ICoordenadorDeShow {

    private FornecedorPalco fornecedorPalco;
    private FornecedorAudio fornecedorAudio;
    private FornecedorCatering fornecedorCatering;

    public void setFornecedorPalco(FornecedorPalco p) { this.fornecedorPalco = p; }
    public void setFornecedorAudio(FornecedorAudio a) { this.fornecedorAudio = a; }
    public void setFornecedorCatering(FornecedorCatering c) { this.fornecedorCatering = c; }

    @Override
    public void notificar(FornecedorComponente emissor, String evento) {
        if (emissor == fornecedorPalco) {
            if (evento.equals("MONTAGEM_PALCO_CONCLUIDA")) {
                // Se o palco terminou, o áudio pode começar e o catering pode entregar
                fornecedorAudio.iniciarInstalacao();
                fornecedorCatering.entregarRefeicaoStaff();
            }
        } else if (emissor == fornecedorAudio) {
            if (evento.equals("INSTALACAO_AUDIO_CONCLUIDA")) {
                fornecedorPalco.iniciarDecoracao();
            }
        }
    }
}
