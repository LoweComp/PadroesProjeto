package padroesCriacao.abstractfactory;

public class Produtor {
    private String nomeProdutor;
    private String tipoFestival;

    private Iluminacao iluminacao;
    private EstruturaPalco estrutura;

    public Produtor(String nomeProdutor, String tipoFestival, FabricaProducao fabrica) {
        this.nomeProdutor = nomeProdutor;
        this.tipoFestival = tipoFestival;

        this.iluminacao = fabrica.criarIluminacao();
        this.estrutura = fabrica.criarEstruturaPalco();
    }

    public String getNomeProdutor() {
        return nomeProdutor;
    }
    public String getTipoFestival() {
        return tipoFestival;
    }

    public String configurarIluminacao() {
        return this.iluminacao.configurarLuzes();
    }
    public String montarEstrutura() {
        return this.estrutura.montar();
    }

    public String iniciarProducao() {
        return nomeProdutor + " iniciou a produção do festival de " + tipoFestival + ".";
    }
}
