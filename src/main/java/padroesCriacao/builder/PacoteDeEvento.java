package padroesCriacao.builder;

public class PacoteDeEvento {
    private String nomeCliente;
    private double custoBase = 0.0;

    private String tipoPalco = "";
    private String sistemaAudio = "";
    private String catering = "";
    private boolean inclusaoSeguranca = false;
    private int equipeTecnica = 0;
    private String licencaMusical = "";

    PacoteDeEvento() {}

    void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    void setCustoBase(double custoBase) { this.custoBase = custoBase; }
    void setTipoPalco(String tipoPalco) { this.tipoPalco = tipoPalco; }
    void setSistemaAudio(String sistemaAudio) { this.sistemaAudio = sistemaAudio; }
    void setCatering(String catering) { this.catering = catering; }
    void setInclusaoSeguranca(boolean inclusaoSeguranca) { this.inclusaoSeguranca = inclusaoSeguranca; }
    void setEquipeTecnica(int equipeTecnica) { this.equipeTecnica = equipeTecnica; }
    void setLicencaMusical(String licencaMusical) { this.licencaMusical = licencaMusical; }

    public String getNomeCliente() { return nomeCliente; }
    public double getCustoBase() { return custoBase; }
    public String getTipoPalco() { return tipoPalco; }
    public int getEquipeTecnica() { return equipeTecnica; }
    public boolean getInclusaoSeguranca() { return inclusaoSeguranca; }

}
