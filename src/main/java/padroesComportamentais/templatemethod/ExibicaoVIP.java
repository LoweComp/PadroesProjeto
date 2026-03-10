package padroesComportamentais.templatemethod;

public class ExibicaoVIP extends ExibicaoFilmeTemplate {
    @Override
    protected void prepararSala() {
        passosExecutados.add("Preparação VIP: Limpeza de poltronas reclináveis e óculos 3D.");
    }

    @Override
    protected void venderLanches() {
        passosExecutados.add("Lanches VIP: Serviço de garçom e cardápio de pizzas.");
    }
}
