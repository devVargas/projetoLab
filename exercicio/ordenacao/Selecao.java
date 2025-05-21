package exercicio.ordenacao;

public class Selecao {
    private String nomePais;
    private int numParticipacoes;
    private int numTitulos;

    public Selecao(String nomePais, int numParticipacoes, int numTitulos) {
        this.nomePais = nomePais;
        this.numParticipacoes = numParticipacoes;
        this.numTitulos = numTitulos;
    }

    public String getNomePais() {
        return nomePais;
    }

    public int getNumParticipacoes() {
        return numParticipacoes;
    }

    public int getNumTitulos() {
        return numTitulos;
    }
    
    @Override
    public String toString() {
        String corAzul = "\u001B[34m"; 
        String corVerde = "\u001B[32m";  
        String corReset = "\u001B[0m";   

        return String.format(
            "%s=== INFORMAÇÕES DA SELEÇÃO ===%s%n" +
            "País: %s%s%s%n" +                 
            "Participações: %s%d%s%n" +        
            "Títulos: %s%d%s%n" +              
            "===============================%n",
            corAzul, corReset,                 
            corReset, nomePais, corReset,      
            corVerde, numParticipacoes, corReset, 
            corVerde, numTitulos, corReset          
        );
    }
}
