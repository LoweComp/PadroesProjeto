package padroesComportamentais.chainofresponsability;

public class ResultadoVerificacao {
    private final boolean podeEntrar;
    private final String motivo;

    public ResultadoVerificacao(boolean podeEntrar, String motivo) {
        this.podeEntrar = podeEntrar;
        this.motivo = motivo;
    }

    public boolean getPodeEntrar() { return podeEntrar; }
    public String getMotivo() { return motivo; }
}