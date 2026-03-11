package padroesEstruturais.facade;

public class ExecucaoFilmeFacade {
    private Projetor projetor;
    private Audio audio;
    private Luzes luzes;

    public ExecucaoFilmeFacade() {
        this.projetor = new Projetor();
        this.audio = new Audio();
        this.luzes = new Luzes();
    }

    public String iniciarSessao(String titulo) {
        StringBuilder log = new StringBuilder();
        log.append("--- INICIANDO SESSÃO: ").append(titulo).append(" ---\n");

        log.append(luzes.reduzirLuzes(5)).append("\n");

        log.append(projetor.ligar()).append("\n");
        log.append(projetor.carregarFilme(titulo)).append("\n");

        log.append(audio.ligarAmplificadores()).append("\n");
        log.append(audio.calibrarVolume()).append("\n");

        log.append("--- SESSÃO PRONTA! ---");
        return log.toString();
    }

    public String finalizarSessao() {
        StringBuilder log = new StringBuilder();
        log.append("--- FINALIZANDO SESSÃO ---\n");

        log.append(projetor.desligar()).append("\n");
        log.append(luzes.acenderLuzes()).append("\n");

        return log.toString();
    }
}