package padroesEstruturais.bridge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExibicaoTest {
    private static final String FILME_TITULO = "Avatar - Fire & Ash";
    private static final String FILME_ACAO = "Trem-Bala";

    private FabricaTech fabricaDigital = new FabricaDigital();
    @Test
    void deveExibirLancamentoComProjetorLaser() {
        Exibicao projetor = new ProjetorLaser();
        Lancamento lancamento = new Lancamento(projetor, FILME_TITULO);

        String statusCarga = "Carregando " + FILME_TITULO + " no servidor de projeção 4K.";
        String statusExibicao = "Projeção iniciada (Laser HDR).";

        String expectedFullOutput = FILME_TITULO
                + " - Status: "
                + statusCarga
                + " | "
                + statusExibicao
                + " (DRM de cinema ativo)";

        assertTrue(lancamento.exibirConteudo().contains(expectedFullOutput));
        assertTrue(lancamento.aplicarBloqueioDRM().contains("ProjetorLaser"));
    }

    @Test
    void deveExibirLancamentoComSistemaIMAX() {
        Exibicao imax = new SistemaIMAX();
        Lancamento lancamento = new Lancamento(imax, FILME_ACAO);

        String statusCarga = "Preparando " + FILME_ACAO + " para tela expandida.";
        String statusExibicao = "Exibição iniciada (Tela IMAX e Áudio Imersivo).";

        String expectedFullOutput = FILME_ACAO
                + " - Status: "
                + statusCarga
                + " | "
                + statusExibicao
                + " (DRM de cinema ativo)";

        assertTrue(lancamento.exibirConteudo().contains(expectedFullOutput));
        assertTrue(lancamento.aplicarBloqueioDRM().contains("SistemaIMAX"));
    }

    @Test
    void deveExibirStreamingComPlayerDigitalViaFactory() {
        Streaming streaming = new Streaming(fabricaDigital, "Mobile", FILME_TITULO);

        assertTrue(streaming.verificarLicenca().contains("PlayerDigital"));

        String expectedLoad = "Buscando licença digital para " + FILME_TITULO + ". | Reprodução iniciada (Dispositivo Móvel/SmartTV).";
        assertTrue(streaming.exibirConteudo().contains(expectedLoad));
    }

    @Test
    void deveLancarExcecaoSeStreamingPedirTecnologiaNaoSuportada() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Streaming(fabricaDigital, "UltraCinema", FILME_ACAO);
        });

        assertTrue(exception.getMessage().contains("Dispositivo de cinema não suportado para Streaming."));
    }
}