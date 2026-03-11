package padroesComportamentais.mediator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShowMediatorTest {

    @Test
    void deveCoordenarMontagemDoShowEmSequenciaCorreta() {
        CoordenadorDeShow coordenador = new CoordenadorDeShow();

        // injeta o mesmo Mediator
        FornecedorPalco palco = new FornecedorPalco(coordenador);
        FornecedorAudio audio = new FornecedorAudio(coordenador);
        FornecedorCatering catering = new FornecedorCatering(coordenador);

        // Injeta as referências dos Colleagues
        coordenador.setFornecedorPalco(palco);
        coordenador.setFornecedorAudio(audio);
        coordenador.setFornecedorCatering(catering);

        // Todos em espera
        assertEquals("Palco: ESPERANDO", palco.getStatus(), "O Palco deve começar esperando.");
        assertEquals("Áudio: ESPERANDO", audio.getStatus(), "O Áudio deve começar esperando.");
        assertEquals("Catering: ESPERANDO", catering.getStatus(), "O Catering deve começar esperando.");

        palco.iniciarMontagem();

        assertEquals("Palco: MONTAGEM ESTRUTURAL", palco.getStatus(), "O Palco deve estar em fase de montagem.");
        // Áudio e Catering liberados pelo Coordenador
        assertEquals("Áudio: INSTALACAO CABEAMENTO", audio.getStatus(),
                "O Áudio deve iniciar a instalação APÓS o Palco notificar.");
        assertEquals("Catering: REFEICAO ENTREGUE", catering.getStatus(),
                "O Catering deve entregar as refeições APÓS o Palco notificar.");

        audio.notificarInstalacaoConcluida();

        assertEquals("Palco: DECORACAO FINALIZANDO", palco.getStatus(),
                "O Palco deve iniciar a decoração APÓS o Áudio notificar que terminou.");
    }
}