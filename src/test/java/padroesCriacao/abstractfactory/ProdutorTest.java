package padroesCriacao.abstractfactory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProdutorTest {
    // 2. Família ROCK
    @Test
    void deveCriarFamiliaRockCorretamente() {
        Produtor produtor = new Produtor("Leo Jaime", "Rock", new FabricaRock());

        assertEquals("Leo Jaime", produtor.getNomeProdutor());
        assertEquals("Rock", produtor.getTipoFestival());

        // Iluminação correta
        String iluminacaoEsperada = "Iluminação com Spots de cores quentes e fumaça para rock. (Voltagem: 220V)";
        assertEquals(iluminacaoEsperada, produtor.configurarIluminacao());

        // Estrutura de Palco correta
        String estruturaEsperada = "Estrutura de palco treliçada, alta e robusta.";
        assertEquals(estruturaEsperada, produtor.montarEstrutura());

        // Método Extra
        assertEquals("Leo Jaime iniciou a produção do festival de Rock.", produtor.iniciarProducao());
    }

    // 2. Família ELETRÔNICA
    @Test
    void deveCriarFamiliaEletronicaCorretamente() {
        Produtor produtor = new Produtor("Charlotte de Witte", "Eletrônica", new FabricaEletro());

        assertEquals("Charlotte de Witte", produtor.getNomeProdutor());

        // Iluminação correta (Laser)
        String iluminacaoEsperada = "Animaçao com VFX em 3d e lasers que seguem o ritmo para o dj.";
        assertEquals(iluminacaoEsperada, produtor.configurarIluminacao());

        // Estrutura correta (Tech)
        String estruturaEsperada = "Estrutura de palco com telão 3d, mesa grande com 2 cdjs e mixer central.";
        assertEquals(estruturaEsperada, produtor.montarEstrutura());

        // Método Extra
        assertEquals("Charlotte de Witte iniciou a produção do festival de Eletrônica.", produtor.iniciarProducao());
    }
}