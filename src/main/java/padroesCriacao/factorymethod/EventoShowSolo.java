package padroesCriacao.factorymethod;

public class EventoShowSolo implements IEvento {

    public EventoShowSolo() { }

    @Override
    public String iniciarPromocao() {
        return "Promoção de Show Musical iniciada: Venda de ingressos e produção de palco agendadas.";
    }

    @Override
    public String cancelarEvento() {
        return "Show Musical cancelado: Reembolso de ingressos iniciado.";
    }
}
