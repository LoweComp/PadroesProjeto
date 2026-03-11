package padroesComportamentais.command;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PalcoCommandTest {
    private final int NIVEL_PLATAFORMA = 5;

    @Test
    void deveAgendarEExecutarComandosDeDiferentesReceiversNaOrdemCorreta() {
        IluminacaoCenica luzes = new IluminacaoCenica();
        MotorPalco motor = new MotorPalco();
        SchedulerDeAcoes scheduler = new SchedulerDeAcoes();

        assertEquals("DESLIGADO", luzes.getStatus(), "Luzes devem começar desligadas.");
        assertEquals("RECOLHIDA", motor.getPosicao(), "Plataforma deve começar recolhida.");

        IComandoPalco comandoA = new ComandoLigarLuzes(luzes);
        IComandoPalco comandoB = new ComandoSubirPlataforma(motor, NIVEL_PLATAFORMA);

        scheduler.agendarComando(comandoA);
        scheduler.agendarComando(comandoB);

        String logExecucao = scheduler.executarSetlist();

        assertTrue(logExecucao.contains("ACENSO BRILHO TOTAL"));
        assertTrue(logExecucao.contains("Plataforma subiu para NÍVEL 5"));

        assertEquals("ACENSO BRILHO TOTAL", luzes.getStatus(),
                "As luzes devem estar ACESAS após o scheduler executar o Comando A.");
        assertEquals("PLATAFORMA NÍVEL 5", motor.getPosicao(),
                "A plataforma deve estar no NÍVEL 5 após o scheduler executar o Comando B.");
    }
}