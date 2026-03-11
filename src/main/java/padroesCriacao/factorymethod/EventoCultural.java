package padroesCriacao.factorymethod;

public class EventoCultural implements IEvento {

    public EventoCultural() { }

    @Override
    public String iniciarPromocao() {
        return "Promoção de Evento Cultural iniciada e entidades participantes confirmadas";
    }

    @Override
    public String cancelarEvento() {
        return "Evento cultural cancelado e atividades reprogramadas";
    }
}
