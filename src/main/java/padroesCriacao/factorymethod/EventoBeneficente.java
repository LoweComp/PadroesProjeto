package padroesCriacao.factorymethod;

public class EventoBeneficente implements IEvento {

    public EventoBeneficente() { }

    @Override
    public String iniciarPromocao() {
        return "Promoção de Evento Beneficente iniciada: ONGs e Movimentos Sociais contatados";
    }

    @Override
    public String cancelarEvento() {
        return "Evento Beneficente cancelado e doações destinadas aos colaboradores";
    }
}
