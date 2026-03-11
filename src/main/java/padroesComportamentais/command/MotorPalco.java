package padroesComportamentais.command;

public class MotorPalco {
    private String posicao = "RECOLHIDA";

    public String subirPlataforma(int nivel) {
        this.posicao = "PLATAFORMA NÍVEL " + nivel;
        return "Motor Palco: Plataforma subiu para NÍVEL " + nivel;
    }

    public String descerPlataforma() {
        this.posicao = "RECOLHIDA";
        return "Motor Palco: Plataforma desceu e está RECOLHIDA";
    }

    public String getPosicao() {
        return posicao;
    }
}
