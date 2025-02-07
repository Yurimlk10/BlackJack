import java.util.ArrayList;

public class Jogador {
    // Atributos
    private boolean noJogo = true;
    private final String nome;

    // Lista de cartas na mao
    private final ArrayList<Carta> mao = new ArrayList<>();

    // Pontuação do jogador
    private int pontos;

    // Construtor
    Jogador(String nome) {
        this.nome = nome;
    }

    // Mão do jogador
    public String getMao() {
        StringBuilder maoJogador = new StringBuilder();

        for (Carta carta : mao) {
            maoJogador.append(String.format("[%s de %s] - ", carta.getValor(), carta.getNaipe()));
        }

        return maoJogador.toString();
    }

    // Adicionar carta a mao
    public void adicionarCarta(Carta carta) {
        mao.add(carta);
        calcularPontos();
    }

    // Calcular os pontos
    public void calcularPontos() {
        pontos = 0;
        for (Carta carta : mao) {
            pontos += carta.getPontos();
        }
    }

    // Sair do jogo
    public void sairJogo() {
        noJogo = false;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public boolean isNoJogo() {
        return noJogo;
    }

    // Computador
    public boolean pescar() {
        return pontos <= 16;
    }
}