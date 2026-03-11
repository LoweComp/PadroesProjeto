package padroesComportamentais.memento;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MixagemMementoTest {

    @Test
    void deveSalvarERestaurarCorretamenteOEstadoDoCanalDeMixagem() {
        CanalDeMixagem canal = new CanalDeMixagem();
        HistoricoMixagem historico = new HistoricoMixagem();

        assertEquals(0, canal.getNivelEQ(), "O EQ deve começar em 0.");

        // 1: Salvar Config OG
        // (EQ: 12, Compressor: 5)
        canal.setConfiguracao(12, 5);
        assertEquals(12, canal.getNivelEQ());

        // cria o Memento 1
        historico.adicionar(canal.salvarEstado());
        assertEquals(1, historico.getTamanhoHistorico(), "O histórico deve ter 1 Memento salvo.");

        // 2: Mudar estado e restaurar
        // Config B: (EQ: 2, Compressor: 1 "ERRO" )
        canal.setConfiguracao(2, 1);
        assertEquals(2, canal.getNivelEQ(), "O EQ deve estar em 2 após a mudança.");

        // Caretaker devolve o Memento e o Originator o restaura (Config A)
        canal.restaurarEstado(historico.getUltimo());

        assertEquals(12, canal.getNivelEQ(),
                "O EQ deve ter sido restaurado para o valor salvo (12).");
        assertTrue(canal.getStatus().contains("Compressor: 5"),
                "O Compressor deve ter sido restaurado para o valor salvo (5).");
    }
}