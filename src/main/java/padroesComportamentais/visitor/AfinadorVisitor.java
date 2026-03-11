package padroesComportamentais.visitor;

public interface AfinadorVisitor {
    String visitar(Guitarra guitarra);
    String visitar(Baixo baixo);
    String visitar(Bateria bateria); // Checagem na vdd né, ñ tem o que afinar
}
