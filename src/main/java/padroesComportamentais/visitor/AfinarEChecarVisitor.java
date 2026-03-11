package padroesComportamentais.visitor;

public class AfinarEChecarVisitor implements AfinadorVisitor {

    @Override
    public String visitar(Guitarra guitarra) {
        if (guitarra.getCordasQuebradas() > 0) {
            return "Guitarra " + guitarra.getMarca() + ": Cordas quebradas. Não é possível afinar.";
        }
        return "Guitarra " + guitarra.getMarca() + ": Afinada com sucesso.";
    }

    @Override
    public String visitar(Bateria bateria) {
        return "Bateria (" + bateria.getTipoPeles() + "): Checagem de hardware concluída.";
    }

    @Override
    public String visitar(Baixo baixo) {
        if (baixo.isAfinacaoEspecial()) {
            return "Baixo: Afinamento de afinação especial concluído. Foco em timbre grave.";
        }
        return "Baixo: Afinamento padrão (E-A-D-G) concluído.";
    }
}
