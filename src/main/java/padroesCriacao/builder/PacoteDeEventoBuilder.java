package padroesCriacao.builder;

public class PacoteDeEventoBuilder {
    private PacoteDeEvento pacote;
    public PacoteDeEventoBuilder() {
        pacote = new PacoteDeEvento();
    }

    public PacoteDeEvento build() {
        if (pacote.getNomeCliente() == null || pacote.getNomeCliente().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do Cliente é obrigatório para o pacote.");
        }
        if (pacote.getCustoBase() == 0.0) {
            throw new IllegalArgumentException("Custo Base deve ser definido.");
        }
        return pacote;
    }

    public PacoteDeEventoBuilder setNomeCliente(String nomeCliente) {
        pacote.setNomeCliente(nomeCliente);
        return this;
    }

    public PacoteDeEventoBuilder setCustoBase(double custoBase) {
        pacote.setCustoBase(custoBase);
        return this;
    }

    public PacoteDeEventoBuilder setTipoPalco(String tipoPalco) {
        pacote.setTipoPalco(tipoPalco);
        return this;
    }

    public PacoteDeEventoBuilder setSistemaAudio(String sistemaAudio) {
        pacote.setSistemaAudio(sistemaAudio);
        return this;
    }

    public PacoteDeEventoBuilder setEquipeTecnica(int equipeTecnica) {
        pacote.setEquipeTecnica(equipeTecnica);
        return this;
    }

    public PacoteDeEventoBuilder setLicencaMusical(String licencaMusical) {
        pacote.setLicencaMusical(licencaMusical);
        return this;
    }

    public PacoteDeEventoBuilder setCatering(String Catering) {
        pacote.setCatering(Catering);
        return this;
    }

    public PacoteDeEventoBuilder setSeguranca(boolean Seguranca) {
        pacote.setInclusaoSeguranca(Seguranca);
        return this;
    }

}
