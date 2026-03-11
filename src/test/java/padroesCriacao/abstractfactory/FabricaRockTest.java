package padroesCriacao.abstractfactory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FabricaRockTest {
    private FabricaRock fabrica = new FabricaRock();

    @Test
    void deveCriarProdutoIluminacaoSpotComVoltagemCorreta() {
        Iluminacao produto = fabrica.criarIluminacao();
        assertInstanceOf(IluminacaoSpot.class, produto);
        IluminacaoSpot iluminacaoSpot = (IluminacaoSpot) produto;
        assertEquals(220, iluminacaoSpot.getVoltagemRecebida());
    }

    @Test
    void deveCriarProdutoEstruturaRobusta() {
        EstruturaPalco produto = fabrica.criarEstruturaPalco();
        assertInstanceOf(EstruturaRobusta.class, produto);
        assertTrue(produto instanceof EstruturaPalco);
    }
}