import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
    // Atributo => Cartas
    private final ArrayList<Carta> cartas = new ArrayList<>();

    // Construtor
    Baralho() {
        criarCartas();
    }

    // Criar as cartas
    private void criarCartas() {
        // Lista de valores e naipes
        String[] valores = {"AS", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] naipes = {"COPA", "OURO", "PAUS", "ESPADA"};

        // Laços de repetição para criar as cartas
        for (String valor : valores) {
            for (String naipe : naipes) {
                cartas.add(new Carta(valor, naipe));
            }
        }
    }

    // Métodos
    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta getCarta() {
        return cartas.removeFirst();
    }

}