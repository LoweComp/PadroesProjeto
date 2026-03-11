package padroesComportamentais.chainofresponsability;

public class Cliente {
        private final String nome;
        private final int idade;
        private final boolean possuiRG;
        private final boolean responsavelLegal;

        public Cliente(String nome, int idade, boolean possuiRG, boolean estaAcompanhado) {
            this.nome = nome;
            this.idade = idade;
            this.possuiRG = possuiRG;
            this.responsavelLegal = estaAcompanhado;
        }

        public int getIdade() { return idade; }
        public boolean getPossuiRG() { return possuiRG; }
        public boolean getResponsavelLegal() { return responsavelLegal; }
        public String getNome() { return nome; }
}
