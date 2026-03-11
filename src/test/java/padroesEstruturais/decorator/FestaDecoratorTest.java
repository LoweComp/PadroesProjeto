package padroesEstruturais.decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FestaDecoratorTest {
    private static final double CUSTO_BASE = 4000.00;
    private static final double CUSTO_BUFFET = 3800.00;
    private static final double CUSTO_OPEN_BAR = 2000.00;
    private static final double CUSTO_BANDA_HORA = 400.00;
    private static final double CUSTO_DJ_OUTSIDER_HORA = 600.00;

    private static final int HORAS_BANDA = 3;
    private static final int HORAS_DJ_OUTSIDER = 2;

    // TESTES FESTA BASE + SERVIÇO INDIVIDUAL

    @Test
    void testeSolo_FestaBase() {
        IFesta festa = new FestaBase();
        assertEquals(CUSTO_BASE, festa.getCusto());
        assertEquals("Festa Básica com DJ Residente, Segurança e Bar", festa.getDescricao());
    }

    @Test
    void testeSolo_BuffetPremium() {
        IFesta festa = new BuffetPremiumDec(new FestaBase());
        assertEquals(CUSTO_BASE + CUSTO_BUFFET, festa.getCusto());
        assertEquals("Festa Básica com DJ Residente, Segurança e Bar, Buffet Premium (Jantar Completo, Mesa de Frio & Aperitivos)", festa.getDescricao());
    }

    @Test
    void testeSolo_OpenBar() {
        IFesta festa = new OpenBarDec(new FestaBase());
        assertEquals(CUSTO_BASE + CUSTO_OPEN_BAR, festa.getCusto());
        assertEquals("Festa Básica com DJ Residente, Segurança e Bar, Open Bar de bebidas alcoolicas, refrigerante, água e sucos", festa.getDescricao());
    }

    @Test
    void testeSolo_BandaPorHora() {
        IFesta festa = new BandaDec(new FestaBase(), HORAS_BANDA);

        double custoBandaTotal = CUSTO_BANDA_HORA * HORAS_BANDA;
        assertEquals(CUSTO_BASE + custoBandaTotal, festa.getCusto());

        String expectedDesc = String.format("Festa Básica com DJ Residente, Segurança e Bar, Banda Sertaneja/Pagode (%d horas)", HORAS_BANDA);
        assertEquals(expectedDesc, festa.getDescricao());
    }

    @Test
    void testeSolo_DJOutsiderPorHora() {
        IFesta festa = new DJOutsiderDec(new FestaBase(), HORAS_DJ_OUTSIDER);

        double custoDJTotal = CUSTO_DJ_OUTSIDER_HORA * HORAS_DJ_OUTSIDER;
        assertEquals(CUSTO_BASE + custoDJTotal, festa.getCusto());

        String expectedDesc = String.format("Festa Básica com DJ Residente, Segurança e Bar, DJ LoweZera (%d horas)", HORAS_DJ_OUTSIDER);
        assertEquals(expectedDesc, festa.getDescricao());
    }

    // TESTES EM DUPLA

    @Test
    void testeDupla_BandaEBuffet() {
        IFesta festa = new BuffetPremiumDec(new BandaDec(new FestaBase(), HORAS_BANDA));

        double custoBandaTotal = CUSTO_BANDA_HORA * HORAS_BANDA;
        assertEquals(CUSTO_BASE + CUSTO_BUFFET + custoBandaTotal, festa.getCusto());

        String expectedDesc = String.format("Festa Básica com DJ Residente, Segurança e Bar, Banda Sertaneja/Pagode (%d horas), Buffet Premium (Jantar Completo, Mesa de Frio & Aperitivos)", HORAS_BANDA);
        assertEquals(expectedDesc, festa.getDescricao());
    }

    @Test
    void testeDupla_OpenBarEDJOutsider() {
        IFesta festa = new DJOutsiderDec(new OpenBarDec(new FestaBase()), HORAS_DJ_OUTSIDER);

        double custoDJTotal = CUSTO_DJ_OUTSIDER_HORA * HORAS_DJ_OUTSIDER;
        double custoEsperado = CUSTO_BASE + CUSTO_OPEN_BAR + custoDJTotal;
        assertEquals(custoEsperado, festa.getCusto());

        String expectedDesc = String.format("Festa Básica com DJ Residente, Segurança e Bar, Open Bar de bebidas alcoolicas, refrigerante, água e sucos, DJ LoweZera (%d horas)", HORAS_DJ_OUTSIDER);
        assertEquals(expectedDesc, festa.getDescricao());
    }

    // TESTES DE TRIO E MÁXIMA

    @Test
    void testeTrio_BandaBuffetEOpenBar() {
        IFesta festa = new OpenBarDec(new BuffetPremiumDec(new BandaDec(new FestaBase(), HORAS_BANDA)));

        double custoBandaTotal = CUSTO_BANDA_HORA * HORAS_BANDA;
        double custoEsperado = CUSTO_BASE + custoBandaTotal + CUSTO_BUFFET + CUSTO_OPEN_BAR;
        assertEquals(custoEsperado, festa.getCusto());

        String expectedDesc = String.format("Festa Básica com DJ Residente, Segurança e Bar, Banda Sertaneja/Pagode (%d horas), Buffet Premium (Jantar Completo, Mesa de Frio & Aperitivos), Open Bar de bebidas alcoolicas, refrigerante, água e sucos", HORAS_BANDA);
        assertEquals(expectedDesc, festa.getDescricao());
    }

    @Test
    void testeCombinacaoMaxima() {
        IFesta festa = new OpenBarDec(
                new BuffetPremiumDec(
                        new DJOutsiderDec(
                                new BandaDec(new FestaBase(), HORAS_BANDA), HORAS_DJ_OUTSIDER
                        )
                )
        );

        double custoBandaTotal = CUSTO_BANDA_HORA * HORAS_BANDA;
        double custoDJTotal = CUSTO_DJ_OUTSIDER_HORA * HORAS_DJ_OUTSIDER;
        double custoEsperado = CUSTO_BASE + custoBandaTotal + custoDJTotal + CUSTO_BUFFET + CUSTO_OPEN_BAR;
        assertEquals(custoEsperado, festa.getCusto());

        String expectedDesc = String.format("Festa Básica com DJ Residente, Segurança e Bar, Banda Sertaneja/Pagode (%d horas), DJ LoweZera (%d horas), Buffet Premium (Jantar Completo, Mesa de Frio & Aperitivos), Open Bar de bebidas alcoolicas, refrigerante, água e sucos", HORAS_BANDA, HORAS_DJ_OUTSIDER);
        assertEquals(expectedDesc, festa.getDescricao());
    }
}