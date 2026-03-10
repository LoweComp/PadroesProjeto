package padroesComportamentais.templatemethod;

public class ExibicaoPadrao extends ExibicaoFilmeTemplate {
    @Override
    protected void prepararSala() {
        passosExecutados.add("Preparação Padrão: Limpeza e ajuste do ar.");
    }

    @Override
    protected void venderLanches() {
        passosExecutados.add("Lanches Padrão: Venda no saguão.");
    }
}