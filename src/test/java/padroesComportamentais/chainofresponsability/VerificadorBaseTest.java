package padroesComportamentais.chainofresponsability;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VerificadorBaseTest {
        private final int CLASSIFICACAO_FILME = 16;

        private IVerificador montarCadeia() {
            IVerificador doc = new VerificadorDocumento();
            IVerificador idade = new VerificadorIdade();
            IVerificador resp = new VerificadorResponsavel();

            // Configuração da Cadeia: Documento -> Idade -> Responsável
            doc.setProximo(idade).setProximo(resp);
            return doc;
        }

        @Test
        public void ClienteAdulto_InterrupcaoNoMeio() {
            IVerificador cadeia = montarCadeia();
            Cliente cliente = new Cliente("Marta", 30, true, false);

            ResultadoVerificacao resultado = cadeia.verificar(cliente, CLASSIFICACAO_FILME);

            Assertions.assertTrue(resultado.getPodeEntrar(), "Deve ser aceito por ser adulto.");
            Assertions.assertTrue(resultado.getMotivo().contains("Idade OK"), "Motivo deve indicar que a idade foi suficiente.");
        }

        @Test
        public void ClienteSemRG_InterrupcaoNoInicio() {
            IVerificador cadeia = montarCadeia();
            Cliente cliente = new Cliente("João", 25, false, true);

            ResultadoVerificacao resultado = cadeia.verificar(cliente, CLASSIFICACAO_FILME);

            Assertions.assertFalse(resultado.getPodeEntrar(), "Deve ser rejeitado por falta de RG.");
            Assertions.assertTrue(resultado.getMotivo().contains("sem RG"), "Motivo deve ser 'Falha na verificação de documento'.");
        }

        @Test
        public void MenorAcompanhado_AceiteNoUltimo() {
            IVerificador cadeia = montarCadeia();
            Cliente cliente = new Cliente("Ana", 14, true, true); // Menor (14 < 16), mas acompanhada

            ResultadoVerificacao resultado = cadeia.verificar(cliente, CLASSIFICACAO_FILME);

            Assertions.assertTrue(resultado.getPodeEntrar(), "Deve ser aceito por estar acompanhada.");
            Assertions.assertTrue(resultado.getMotivo().contains("acompanhado por responsável"), "Motivo deve ser 'Aceito com restrição'.");
        }

        @Test
        public void MenorSozinho_RejeicaoFinal() {
            IVerificador cadeia = montarCadeia();
            Cliente cliente = new Cliente("Pedro", 14, true, false);

            ResultadoVerificacao resultado = cadeia.verificar(cliente, CLASSIFICACAO_FILME);

            Assertions.assertFalse(resultado.getPodeEntrar(), "Deve ser rejeitado por ser menor e estar sozinho.");
            Assertions.assertTrue(resultado.getMotivo().contains("não acompanhado"), "Motivo deve ser 'Rejeição final'.");
        }

}