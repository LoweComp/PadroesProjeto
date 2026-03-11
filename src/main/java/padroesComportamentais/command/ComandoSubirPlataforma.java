package padroesComportamentais.command;

public class ComandoSubirPlataforma implements IComandoPalco {

    private final MotorPalco receiver; // O Receiver
    private final int nivel;

    public ComandoSubirPlataforma(MotorPalco receiver, int nivel) {
        this.receiver = receiver;
        this.nivel = nivel;
    }

    @Override
    public String executar() {
        return receiver.subirPlataforma(nivel);
    }
}
