package padroesEstruturais.decorator;

public class FestaBase implements IFesta {
    @Override
    public String getDescricao() {
        return "Festa Básica com DJ Residente, Segurança e Bar";
    }

    @Override
    public double getCusto() {
        return 4000.00;
    }

}
