package padroesComportamentais.memento;

import java.util.ArrayList;
import java.util.List;

// Caretaker: Gerencia o histórico de Mementos
public class HistoricoMixagem {
    private final List<ConfiguracaoMixagemMemento> historico = new ArrayList<>();

    public void adicionar(ConfiguracaoMixagemMemento memento) {
        historico.add(memento);
    }

    public ConfiguracaoMixagemMemento desfazer(int index) {
        if (index >= 0 && index < historico.size()) {
            return historico.get(index);
        }
        return null;
    }

    public ConfiguracaoMixagemMemento getUltimo() {
        if (historico.isEmpty()) return null;
        return historico.get(historico.size() - 1);
    }

    public int getTamanhoHistorico() {
        return historico.size();
    }
}
