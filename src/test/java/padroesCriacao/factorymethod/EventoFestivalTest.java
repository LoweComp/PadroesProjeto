package padroesCriacao.factorymethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventoFestivalTest {
    @Test
    void devePromoverFestival() {
        IEvento evento = EventoFactory.criarEvento("EventoFestival");
        assertEquals("Promoção de Festival iniciada: Venda de ingressos e equipe de marketing acionada.", evento.iniciarPromocao());
    }
    @Test
    void deveCancelarFestival() {
        IEvento evento = EventoFactory.criarEvento("EventoFestival");
        assertEquals("Festival cancelado: Reembolso dos ingressos e nova data anunciados.", evento.cancelarEvento());
    }
}