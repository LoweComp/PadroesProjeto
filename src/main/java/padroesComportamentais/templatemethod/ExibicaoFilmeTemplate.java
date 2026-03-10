package padroesComportamentais.templatemethod;

import java.util.ArrayList;
import java.util.List;

public abstract class ExibicaoFilmeTemplate {

    protected final List<String> passosExecutados = new ArrayList<>();

    public final List<String> exibir() {
        passosExecutados.clear();
        prepararSala();
        iniciarProjecao();
        venderLanches();
        finalizarExibicao();
        return passosExecutados;
    }
    // Passos Template
    protected abstract void prepararSala();
    protected abstract void venderLanches();

    // Passos Fixos
    private void iniciarProjecao() {
        passosExecutados.add("Iniciando Projeção: Trailer e Filme Principal.");
    }
    private void finalizarExibicao() {
        passosExecutados.add("Fim da Exibição. Limpeza da sala.");
    }
}

