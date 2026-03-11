package padroesEstruturais.flyweight;

public class TipoDeAssento {

    // Dados caros
    private final String nome;
    private final String descricaoMaterial;
    private final double precoBase;

    public TipoDeAssento(String nome, String descricaoMaterial, double precoBase) {
        this.nome = nome;
        this.descricaoMaterial = descricaoMaterial;
        this.precoBase = precoBase;
    }

    public String getNome() { return nome; }
    public double getPrecoBase() { return precoBase; }
}
