package padroesEstruturais.composite;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AcervoCompositeTest {

    @Test
    void deveCalcularDuracaoTotalDoAcervo() {
        Categoria acervoGeral = new Categoria("ACERVO PRINCIPAL");

        Categoria comedia = new Categoria("Comédia Nacional");
        Filme filme1 = new Filme("O Auto da Compadecida", 120);
        Filme filme2 = new Filme("Lisbela e o Prisioneiro", 108);

        Categoria aventura = new Categoria("Aventura Fantasia");
        Filme filme3 = new Filme("O Mago de Oz", 100);
        // SUB-CATEGORIA TERROR
        Categoria terror = new Categoria("Terror B");
        Filme filme4 = new Filme("O Bicho Papão", 90);
        terror.adicionar(filme4);

        // MONTAGEM
        comedia.adicionar(filme1);
        comedia.adicionar(filme2);
        // Aventura (terror como subcategoria)
        aventura.adicionar(filme3);
        aventura.adicionar(terror);
        // Add categorias à raiz
        acervoGeral.adicionar(comedia);
        acervoGeral.adicionar(aventura);

        // ASSERT: Verificação da Duração Total (Recurso e Delegação)
        assertEquals(418, acervoGeral.getDuracaoEmMinutos(), "A duração total da árvore deve ser 418 minutos.");
        assertEquals(228, comedia.getDuracaoEmMinutos(), "A categoria Comédia deve ter 228 minutos.");
        assertEquals(120, filme1.getDuracaoEmMinutos(), "A duração do filme 1 deve ser 120 minutos.");
    }

    @Test
    void deveExibirEstruturaHierarquicaCorretamente() {
        Categoria acervo = new Categoria("ROOT");
        Categoria sub = new Categoria("SUB");
        Filme filme = new Filme("FILME_TESTE", 60);

        sub.adicionar(filme);
        acervo.adicionar(sub);

        String esperado =
                "\nCategoria: ROOT (Total: 60 min)" +
                        "\n  " +
                        "Categoria: SUB (Total: 60 min)" +
                        "\n    " +
                        "- Filme: FILME_TESTE (60 min)";

        String resultado = acervo.exibirDetalhes();

        assertTrue(resultado.contains("ROOT (Total: 60 min)"), "Deve exibir o total da categoria raiz.");
        assertTrue(resultado.contains("- Filme: FILME_TESTE (60 min)"), "Deve exibir o detalhe do filme (Folha).");
        assertTrue(resultado.contains("Categoria: SUB (Total: 60 min)"), "Deve exibir a subcategoria (Composto).");
    }
}