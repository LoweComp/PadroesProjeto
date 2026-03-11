package padroesEstruturais.flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AssentoFlyweightTest {

    // COMPARTILHAMENTO DE MEMÓRIA
    @Test
    void deveCompartilharInstanciasDeTipoDeAssento() {
        // 4 assentos Criados: 2 VIP e 2 STANDARD armazenados em 2 objetos FlyWeight

        TipoDeAssento tipoVIP1 = AssentoFactory.getTipoDeAssento("VIP");
        Assento assentoA1 = new Assento(1, 1, tipoVIP1);

        TipoDeAssento tipoVIP2 = AssentoFactory.getTipoDeAssento("VIP");
        Assento assentoA2 = new Assento(1, 2, tipoVIP2);

        TipoDeAssento tipoSTANDARD1 = AssentoFactory.getTipoDeAssento("STANDARD");
        Assento assentoB1 = new Assento(2, 1, tipoSTANDARD1);

        TipoDeAssento tipoSTANDARD2 = AssentoFactory.getTipoDeAssento("STANDARD");
        Assento assentoB2 = new Assento(2, 2, tipoSTANDARD2);

        assertSame(tipoVIP1, tipoVIP2, "Objetos VIP devem ser a MESMA instância na memória.");
        assertSame(tipoSTANDARD1, tipoSTANDARD2, "Objetos STANDARD devem ser a MESMA instância na memória.");
        assertNotSame(tipoVIP1, tipoSTANDARD1, "Objetos de tipos diferentes não devem compartilhar a instância.");

        // PROVA DA ECONOMIA (Contagem da Fábrica)
        assertEquals(2, AssentoFactory.getNumeroDeFlyweightsCriados(),
                "A fábrica deve ter criado APENAS 2 Flyweights (VIP e STANDARD), e não 4.");

        // PROVA DO ESTADO Único
        assertNotSame(assentoA1, assentoA2, "Os objetos Assento (Contexto) devem ser instâncias únicas.");
        assertNotEquals(assentoA1.getFila(), assentoB1.getFila(), "As filas devem ser diferentes.");
    }

    // FALHA
    @Test
    void deveLancarExcecaoParaTipoDeAssentoDesconhecido() {
        assertThrows(IllegalArgumentException.class, () -> {
            AssentoFactory.getTipoDeAssento("POLTRONA-GAMER");
        }, "Deve lançar exceção se o tipo de assento não for mapeado na fábrica.");
    }
}