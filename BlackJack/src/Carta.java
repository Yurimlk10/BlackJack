public class Carta {
    // Atributos
    private final String valor;
    private final String naipe;

    // Construtor
    Carta(String valor, String naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    // Getters
    public String getValor() {
        return valor;
    }

    public String getNaipe() {
        return naipe;
    }

    // Retorna o valor da carta em inteiro
    public int getPontos() {
        if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
            return 10;
        }

        if (valor.equals("AS")) {
            return 1;
        }

        return Integer.parseInt(valor);
    }
}
