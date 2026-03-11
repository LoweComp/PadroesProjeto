package padroesComportamentais.visitor;

public class Guitarra implements InstrumentoElement {

    private String marca;
    private int cordasRuins = 0;

    public Guitarra(String marca) { this.marca = marca; }

    public String getMarca() { return marca; }
    public int getCordasQuebradas() { return cordasRuins; }

    @Override
    public void aceitar(AfinadorVisitor visitor) {
        visitor.visitar(this);
    }
}
