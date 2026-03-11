package padroesCriacao.factorymethod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EventoFactoryTest {

    // SUCESSO
    @Test
    void deveObterSucessoNaCriacaoEvento() {
        IEvento evento = EventoFactory.criarEvento("EventoShowSolo");
        assertInstanceOf(EventoShowSolo.class, evento);
        assertEquals("Promoção de Show Musical iniciada: Venda de ingressos e produção de palco agendadas.", evento.iniciarPromocao());
    }

    @Test
    void deveLancarExcecaoEventoInexistente() {
        try {
            IEvento evento = EventoFactory.criarEvento("Conferencia");
            fail();
        } catch (IllegalArgumentException e) {
            String expectedMessage = "Tipo de Evento inexistente: Conferencia";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    void deveLancarExcecaoClasseInvalida() {
        try {
            IEvento evento = EventoFactory.criarEvento("EventoFactoryTest$EventoClasseInvalida");
            fail();
        } catch (IllegalArgumentException e) {
            String expectedMessage = "Classe do evento não implementa IEvento";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    // EXCEÇÃO - INSTANCIAÇÃO/CONSTRUTOR
    @Test
    void deveLancarExcecaoInstanciacao() {
        try {
            IEvento evento = EventoFactory.criarEvento("EventoFactoryTest$EventoConstrutorPrivado");
            fail();
        } catch (IllegalArgumentException e) {
            String expectedMessage = "Erro ao instanciar o Evento";
            assertEquals(expectedMessage, e.getMessage());
        }
    }



    // CLASSES DE TESTE
    private static class EventoConstrutorPrivado implements IEvento {
        private EventoConstrutorPrivado() {}
        public String iniciarPromocao() { return "ok"; }
        public String cancelarEvento() { return "ok"; }
    }

    private static class EventoClasseInvalida {
        public EventoClasseInvalida() {}
    }




}