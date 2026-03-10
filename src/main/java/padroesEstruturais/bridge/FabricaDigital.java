package padroesEstruturais.bridge;

public class FabricaDigital implements FabricaTech {

    @Override
    public Exibicao criarTecnologia(String tipoDispositivo) {
        // Streaming SÓ pode usar PlayerDigital para Mobile/TV
        if (tipoDispositivo.equalsIgnoreCase("Mobile") || tipoDispositivo.equalsIgnoreCase("SmartTV")) {
            return new PlayerDigital();
        }

        else {
            throw new IllegalArgumentException("Dispositivo de cinema não suportado para Streaming.");
        }
    }
}
