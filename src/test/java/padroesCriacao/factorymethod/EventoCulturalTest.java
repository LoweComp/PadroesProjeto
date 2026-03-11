package padroesCriacao.factorymethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventoCulturalTest {
    @Test
    void devePromoverEventoCultural() {
        IEvento evento = EventoFactory.criarEvento("EventoCultural");
        assertEquals("Promoção de Evento Cultural iniciada e entidades participantes confirmadas", evento.iniciarPromocao());
    }
    @Test
    void deveCancelarEventoCultural() {
        IEvento evento = EventoFactory.criarEvento("EventoCultural");
        assertEquals("Evento cultural cancelado e atividades reprogramadas", evento.cancelarEvento());
    }
}