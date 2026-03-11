package padroesCriacao.factorymethod;

public class EventoFestival implements IEvento {

    public EventoFestival() { }

    @Override
    public String iniciarPromocao() {
        return "Promoção de Festival iniciada: Venda de ingressos e equipe de marketing acionada.";
    }

    @Override
    public String cancelarEvento() {
        return "Festival cancelado: Reembolso dos ingressos e nova data anunciados.";
    }
}
