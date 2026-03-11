package padroesComportamentais.state;

public interface EstadoPlayer {
    String apertarPlay(Player player);
    String apertarPause(Player player);
    String apertarStop(Player player);
}
