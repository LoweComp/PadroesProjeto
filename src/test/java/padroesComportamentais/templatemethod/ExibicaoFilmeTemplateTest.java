package padroesComportamentais.templatemethod;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExibicaoFilmeTemplateTest {

    @Test
    void deveExecutarFluxoCompletoParaExibicaoPadrao() {
        ExibicaoFilmeTemplate padrao = new ExibicaoPadrao();

        List<String> fluxoEsperado = Arrays.asList(
                "Preparação Padrão: Limpeza e ajuste do ar.",
                "Iniciando Projeção: Trailer e Filme Principal.",
                "Lanches Padrão: Venda no saguão.",
                "Fim da Exibição. Limpeza da sala."
        );

        List<String> fluxoAtual = padrao.exibir();

        assertEquals(fluxoEsperado.size(), fluxoAtual.size(), "O número de passos executados está incorreto.");
        assertEquals(fluxoEsperado, fluxoAtual, "A sequência ou o conteúdo dos passos da Exibição Padrão está incorreto.");
    }

    @Test
    void deveExecutarFluxoCompletoParaExibicaoVIP() {
        ExibicaoFilmeTemplate vip = new ExibicaoVIP();

        List<String> fluxoEsperado = Arrays.asList(
                "Preparação VIP: Limpeza de poltronas reclináveis e óculos 3D.",
                "Iniciando Projeção: Trailer e Filme Principal.",
                "Lanches VIP: Serviço de garçom e cardápio de pizzas.",
                "Fim da Exibição. Limpeza da sala."
        );

        List<String> fluxoAtual = vip.exibir();

        assertEquals(fluxoEsperado.size(), fluxoAtual.size(), "O número de passos executados está incorreto.");
        assertEquals(fluxoEsperado, fluxoAtual, "A sequência ou o conteúdo dos passos da Exibição VIP está incorreto.");
    }

    @Test
    void deveGarantirQuePassosFixosSaoMantidos() {
        ExibicaoFilmeTemplate padrao = new ExibicaoPadrao();
        ExibicaoFilmeTemplate vip = new ExibicaoVIP();

        List<String> fluxoPadrao = padrao.exibir();
        List<String> fluxoVip = vip.exibir();

        String passoFixo = "Iniciando Projeção: Trailer e Filme Principal.";
        assertEquals(passoFixo, fluxoPadrao.get(1), "O passo fixo (início) está incorreto no Padrão.");
        assertEquals(passoFixo, fluxoVip.get(1), "O passo fixo (início) está incorreto no VIP.");
    }
}