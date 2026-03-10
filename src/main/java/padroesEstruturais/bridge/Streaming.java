package padroesEstruturais.bridge;

public class Streaming extends Conteudo {
    public Streaming(Exibicao tecnologia, String titulo) {
        super(tecnologia, titulo);
    }

    public Streaming(FabricaTech fabrica, String tipoDispositivo, String titulo) {
        super(fabrica.criarTecnologia(tipoDispositivo), titulo);
    }

    @Override
    public String exibirConteudo() {
        String statusCarga = this.tecnologia.carregarConteudo(titulo);
        String statusExibicao = this.tecnologia.iniciarExibicao();

        return titulo + " - Status: " + statusCarga + " | " + statusExibicao + " (Controle de banda e licença verificado)";
    }

    public String verificarLicenca() {
        return "Licença de acesso verificada no dispositivo via " + this.tecnologia.getClass().getSimpleName();
    }
}