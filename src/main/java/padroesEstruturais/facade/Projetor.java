package padroesEstruturais.facade;

public class Projetor {
    public String ligar() {
        return "Projetor: Ligado e aquecido.";
    }
    public String carregarFilme(String titulo) {
        return "Projetor: Arquivo '" + titulo + "' carregado e focado.";
    }
    public String desligar() {
        return "Projetor: Desligado e resfriando.";
    }
}