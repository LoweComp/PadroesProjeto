package padroesEstruturais.bridge;

public class PlayerDigital implements Exibicao{
    @Override
    public String carregarConteudo(String titulo) {
        return "Buscando licença digital para " + titulo + ".";
    }

    @Override
    public String iniciarExibicao() {
        return "Reprodução iniciada (Dispositivo Móvel/SmartTV).";
    }
}
