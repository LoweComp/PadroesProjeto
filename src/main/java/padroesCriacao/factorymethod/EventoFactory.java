package padroesCriacao.factorymethod;

import java.lang.reflect.InvocationTargetException;

public class EventoFactory {

    public static IEvento criarEvento(String tipoEvento) {
        Class classe = null;
        Object objeto = null;

        try {
            classe = Class.forName("com.factoryjvw." + tipoEvento);
            objeto = classe.getDeclaredConstructor().newInstance();

        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Tipo de Evento inexistente: " + tipoEvento);

    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
        throw new IllegalArgumentException("Erro ao instanciar o Evento");
    }

        if (objeto == null || !(objeto instanceof IEvento)) {
            throw new IllegalArgumentException("Classe do evento não implementa IEvento");
        }

        return (IEvento) objeto;
    }

}