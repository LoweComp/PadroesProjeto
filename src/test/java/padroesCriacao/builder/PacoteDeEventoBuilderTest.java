package padroesCriacao.builder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PacoteBuilderTest {

    private static final double CUSTO_BASE = 50000.00;
    private static final String CLIENTE = "Wayne Enterprises";
    private static final int EQUIPE_TEC_PADRAO = 15;

    // SUCESSO
    @Test
    void deveConstruirPacoteCompletoComEncadeamento() {
        PacoteDeEvento pacote = new PacoteDeEventoBuilder()
                .setNomeCliente(CLIENTE)
                .setCustoBase(CUSTO_BASE)
                .setSeguranca(true)
                .setTipoPalco("Palco Principal Gigante")
                .setEquipeTecnica(EQUIPE_TEC_PADRAO)
                .setLicencaMusical("Licença Global 2025")
                .build();

        assertNotNull(pacote, "O pacote não deve ser nulo após a construção.");
        assertEquals(CLIENTE, pacote.getNomeCliente());

        assertEquals("Palco Principal Gigante", pacote.getTipoPalco());
        assertEquals(EQUIPE_TEC_PADRAO, pacote.getEquipeTecnica());
        assertTrue(pacote.getInclusaoSeguranca(), "A segurança deve ser TRUE.");
    }

    @Test
    void deveIncluirSegurancaCorretamente() {
        PacoteDeEvento pacote = new PacoteDeEventoBuilder()
                .setNomeCliente(CLIENTE)
                .setCustoBase(CUSTO_BASE)
                .setSeguranca(true)
                .build();
        assertTrue(pacote.getInclusaoSeguranca(), "A inclusão de segurança deve ser TRUE.");
    }

    // FALHA
    @Test
    void deveLancarExcecaoSeNaoTiverNomeCliente() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PacoteDeEventoBuilder()
                    .setCustoBase(CUSTO_BASE)
                    .build();
        }, "Deve lançar exceção se o nome do cliente não for fornecido.");
    }

    @Test
    void deveLancarExcecaoSeCustoBaseForZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PacoteDeEventoBuilder()
                    .setNomeCliente(CLIENTE)
                    .build();
        }, "Deve lançar exceção se o Custo Base não for definido.");
    }

    @Test
    void deveLancarExcecaoSeNomeClienteForVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PacoteDeEventoBuilder()
                    .setNomeCliente("")
                    .setCustoBase(CUSTO_BASE)
                    .build();
        }, "Deve lançar exceção se o nome do cliente for vazio.");
    }
}