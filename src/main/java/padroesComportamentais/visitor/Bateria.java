package padroesComportamentais.visitor;

public class Bateria implements InstrumentoElement {

    private String tipoPeles;
    private int tambores;

    public Bateria(String tipoPeles, int tambores) {
        this.tipoPeles = tipoPeles;
        this.tambores = tambores;
    }

    public String getTipoPeles() { return tipoPeles; }

    @Override
    public void aceitar(AfinadorVisitor visitor) {
        visitor.visitar(this);
    }
}