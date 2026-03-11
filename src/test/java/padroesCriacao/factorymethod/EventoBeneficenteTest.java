package padroesCriacao.factorymethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventoBeneficenteTest {

    @Test
    void devePromoverEventoBeneficente() {
        IEvento evento = EventoFactory.criarEvento("EventoBeneficente");
        assertEquals("Promoção de Evento Beneficente iniciada: ONGs e Movimentos Sociais contatados", evento.iniciarPromocao());
    }
    @Test
    void deveCancelarShowSolo() {
        IEvento evento = EventoFactory.criarEvento("EventoBeneficente");
        assertEquals("Evento Beneficente cancelado e doações destinadas aos colaboradores", evento.cancelarEvento());
    }

}