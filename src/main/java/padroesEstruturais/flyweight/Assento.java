package padroesEstruturais.flyweight;

public class Assento {

    // Dados únicos
    private final int fila;
    private final int coluna;
    private String statusReserva;

    private final TipoDeAssento tipo;

    public Assento(int fila, int coluna, TipoDeAssento tipo) {
        this.fila = fila;
        this.coluna = coluna;
        this.tipo = tipo;
        this.statusReserva = "DISPONÍVEL";
    }

    public String exibirStatus() {
        return String.format("Assento [%d:%d] - Tipo: %s (R$%.2f) - Status: %s",
                fila, coluna, tipo.getNome(), tipo.getPrecoBase(), statusReserva);
    }

    public TipoDeAssento getTipo() { return tipo; }
    public int getFila() { return fila; }
}
