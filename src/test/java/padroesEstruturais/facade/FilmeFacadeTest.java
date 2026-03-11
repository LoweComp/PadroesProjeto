package padroesEstruturais.facade;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FilmeFacadeTest {

    private final ExecucaoFilmeFacade facade = new ExecucaoFilmeFacade();
    private final String TITULO = "O Código da Façade";

    @Test
    void deveIniciarSessaoExecutandoTodosOsPassosDoSubsistema() {

        // O cliente chama APENAS a Façade.
        String log = facade.iniciarSessao(TITULO);

        assertTrue(log.contains("--- INICIANDO SESSÃO: " + TITULO + " ---"));
        assertTrue(log.contains("Luzes: Reduzidas para 5%."));

        assertTrue(log.contains("Projetor: Ligado e aquecido."));
        assertTrue(log.contains("Projetor: Arquivo 'O Código da Façade' carregado e focado."));

        assertTrue(log.contains("Áudio: Amplificadores ligados."));
        assertTrue(log.contains("Áudio: Volume calibrado para 7.1 Surround."));

        assertTrue(log.contains("--- SESSÃO PRONTA! ---"));

        // A Classe de teste (cliente) nunca instancia Projetor, Luzes ou Audio se der tudo certinho
    }

    @Test
    void deveFinalizarSessaoComOrdemDeDesligamentoCorreta() {
        String log = facade.finalizarSessao();

        // Verifica a ordem de desligamento
        assertTrue(log.contains("Projetor: Desligado e resfriando."));
        assertTrue(log.contains("Luzes: Aceso o ambiente principal."));
    }
}