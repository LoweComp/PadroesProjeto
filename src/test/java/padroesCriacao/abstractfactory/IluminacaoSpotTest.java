package padroesCriacao.abstractfactory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IluminacaoSpotTest {

    private static final int VOLTAGEM_SUCESSO = 220;
    private static final int VOLTAGEM_FALHA = 110;

    // SUCESSO
    @Test
    void deveConfigurarLuzesComVoltagemCorreta() {
        IluminacaoSpot iluminacao = new IluminacaoSpot(VOLTAGEM_SUCESSO);
        String esperado = "Iluminação com Spots de cores quentes e fumaça para rock. (Voltagem: 220V)";
        assertEquals(esperado, iluminacao.configurarLuzes());
    }

    // FALHA (lança exceção)
    @Test
    void deveLancarExcecaoPorVoltagemInvalida() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new IluminacaoSpot(VOLTAGEM_FALHA);
        });
        String expectedMessage = "ERRO: Iluminação Spot requer 220V, mas encontrou 110V.";
        assertEquals(expectedMessage, exception.getMessage());
    }
}