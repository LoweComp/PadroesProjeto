package padroesComportamentais.visitor;

public class Baixo implements InstrumentoElement {

    private int numeroDeCordasGraves;
    private boolean afinacaoEspecial;  // Drop-D, etc.

    public Baixo(int numeroDeCordasGraves, boolean afinacaoEspecial) {
        this.numeroDeCordasGraves = numeroDeCordasGraves;
        this.afinacaoEspecial = afinacaoEspecial;
    }

    public int getNumeroDeCordasGraves() {
        return numeroDeCordasGraves;
    }
    public boolean isAfinacaoEspecial() {
        return afinacaoEspecial;
    }

    @Override
    public void aceitar(AfinadorVisitor visitor) {
        visitor.visitar(this);
    }
}
