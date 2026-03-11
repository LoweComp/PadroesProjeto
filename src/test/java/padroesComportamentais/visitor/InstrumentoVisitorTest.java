package padroesComportamentais.visitor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InstrumentoVisitorTest {

    private final AfinarEChecarVisitor afinador = new AfinarEChecarVisitor();
    @Test
    void deveAfinarGuitarraComSucesso() {
        Guitarra guitarra = new Guitarra("Gibson");
        String resultado = afinador.visitar(guitarra);
        assertEquals("Guitarra Gibson: Afinada com sucesso.", resultado);
    }

    @Test
    void deveChecarBateriaCorretamente() {
        Bateria bateria = new Bateria("Hidráulica", 5);
        String resultado = afinador.visitar(bateria);
        assertEquals("Bateria (Hidráulica): Checagem de hardware concluída.", resultado);
    }

    @Test
    void deveAfinarBaixoComAfinacaoPadrao() {
        Baixo baixo = new Baixo(4, false);
        String resultado = afinador.visitar(baixo);
        assertEquals("Baixo: Afinamento padrão (E-A-D-G) concluído.", resultado);
    }

    // BAIXO - AFINAÇÃO ESPECIAL
    @Test
    void deveAfinarBaixoComAfinacaoEspecial() {
        Baixo baixo = new Baixo(5, true);
        String resultado = afinador.visitar(baixo);
        assertEquals("Baixo: Afinamento de afinação especial concluído. Foco em timbre grave.", resultado);
    }
}