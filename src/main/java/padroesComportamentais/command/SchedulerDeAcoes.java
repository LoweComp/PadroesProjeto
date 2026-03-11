package padroesComportamentais.command;

import java.util.ArrayList;
import java.util.List;

// Invoker: Enfileira e executa
public class SchedulerDeAcoes {
    private final List<IComandoPalco> comandosAgendados = new ArrayList<>();

    public void agendarComando(IComandoPalco comando) {
        comandosAgendados.add(comando);
    }

    public String executarSetlist() {
        StringBuilder log = new StringBuilder();
        log.append("--- INICIANDO EXECUÇÃO DA SETLIST DE COMANDOS ---\n");

        for (IComandoPalco comando : comandosAgendados) {
            log.append(comando.executar()).append("\n");
        }

        log.append("--- SETLIST FINALIZADA ---");
        return log.toString();
    }
}
