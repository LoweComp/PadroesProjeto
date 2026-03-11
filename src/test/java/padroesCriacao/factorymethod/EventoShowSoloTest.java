package padroesCriacao.factorymethod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EventoShowSoloTest {
    @Test
    void devePromoverShowSolo() {
        IEvento evento = EventoFactory.criarEvento("EventoShowSolo");
        assertEquals("Promoção de Show Musical iniciada: Venda de ingressos e produção de palco agendadas.", evento.iniciarPromocao());
    }
    @Test
    void deveCancelarShowSolo() {
        IEvento evento = EventoFactory.criarEvento("EventoShowSolo");
        assertEquals("Show Musical cancelado: Reembolso de ingressos iniciado.", evento.cancelarEvento());
    }

}