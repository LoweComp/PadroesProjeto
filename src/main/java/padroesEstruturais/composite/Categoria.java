package padroesEstruturais.composite;

import java.util.ArrayList;
import java.util.List;

public class Categoria implements IItemAcervo {
    private String nome;
    private List<IItemAcervo> itens;

    public Categoria(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public void adicionar(IItemAcervo item) {
        itens.add(item);
    }

    public String getNome() { return nome; }

    @Override
    public String exibirDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCategoria: ").append(nome).append(" (Total: ").append(getDuracaoEmMinutos()).append(" min)");

        for (IItemAcervo item : itens) {
            sb.append("\n  ").append(item.exibirDetalhes().replace("\n", "\n  "));
        }
        return sb.toString();
    }

    @Override
    public int getDuracaoEmMinutos() {
        int duracaoTotal = 0;
        for (IItemAcervo item : itens) {
            duracaoTotal += item.getDuracaoEmMinutos();
        }
        return duracaoTotal;
    }
}
