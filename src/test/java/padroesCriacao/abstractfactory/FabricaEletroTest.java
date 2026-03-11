package padroesCriacao.abstractfactory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FabricaEletroTest {

    private FabricaEletro fabrica = new FabricaEletro();

    @Test
    void deveCriarProdutoIluminacaoLaser() {
        Iluminacao produto = fabrica.criarIluminacao();
        assertInstanceOf(IluminacaoLaser.class, produto);

        assertTrue(produto instanceof Iluminacao);
    }

    @Test
    void deveCriarProdutoEstruturaTech() {
        EstruturaPalco produto = fabrica.criarEstruturaPalco();
        assertInstanceOf(EstruturaTech.class, produto);

        assertTrue(produto instanceof EstruturaPalco);
    }
}