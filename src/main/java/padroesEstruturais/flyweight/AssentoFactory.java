package padroesEstruturais.flyweight;

import java.util.HashMap;
import java.util.Map;

public class AssentoFactory {
    private static final Map<String, TipoDeAssento> cache = new HashMap<>();

    public static TipoDeAssento getTipoDeAssento(String nome) {
        TipoDeAssento tipo = cache.get(nome);

        if (tipo == null) {
            double preco = 0.0;
            String material = "Padrão";

            if (nome.equalsIgnoreCase("VIP")) {
                preco = 45.00;
                material = "Couro Sintético";
            } else if (nome.equalsIgnoreCase("STANDARD")) {
                preco = 25.00;
                material = "Tecido Comum";
            } else {
                throw new IllegalArgumentException("Tipo de assento desconhecido.");
            }

            tipo = new TipoDeAssento(nome, material, preco);
            cache.put(nome, tipo);
        }

        return tipo;
    }

    public static int getNumeroDeFlyweightsCriados() {
        return cache.size();
    }
}
