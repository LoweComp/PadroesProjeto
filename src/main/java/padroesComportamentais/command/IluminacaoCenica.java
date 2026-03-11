package padroesComportamentais.command;

public class IluminacaoCenica {
    private String status = "DESLIGADO";

    public String ligarLuzes() {
        this.status = "ACENSO BRILHO TOTAL";
        return "Iluminacao Cenica: ACENSO BRILHO TOTAL";
    }

    public String desligarLuzes() {
        this.status = "DESLIGADO";
        return "Iluminacao Cenica: DESLIGADO";
    }

    public String getStatus() {
        return status;
    }
}