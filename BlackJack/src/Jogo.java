import java.util.ArrayList;

public class Jogo {
    // Atributos
    private final ArrayList<Jogador> jogadores = new ArrayList<>();
    private final Baralho baralho = new Baralho();

    // Construtor
    Jogo(Jogador jogador, Jogador computador) {
        jogadores.add(jogador);
        jogadores.add(computador);
    }

    // Iniciar jogo
    public void iniciarJogo() {
        baralho.embaralhar();
        for (Jogador jogador : jogadores) {
            jogador.adicionarCarta(baralho.getCarta());
        }
    }

    // Pesca
    public void pescar(Jogador jogador) {
        if (jogador.isNoJogo()) {
            jogador.adicionarCarta(baralho.getCarta());
        }
    }

    // Verificando vencedor
    public String verificarVencedor() {
        // Criando uma string builder
        StringBuilder msg = new StringBuilder();

        // Iniciando variaveis para ser usada no string buider
        String nomeJogador, maoJogador;
        String nomeComputador, maoComputador;
        int pontosJogador;
        int pontosComputador;

        // Primeiro jogador
        nomeJogador = jogadores.getFirst().getNome();
        pontosJogador = jogadores.getFirst().getPontos();
        maoJogador = jogadores.getFirst().getMao();

        // Constrindo a msg
        msg.append(String.format("""
                =================
                || Jogador: %s
                || Pontos: %d
                || Cartas: %s
                \s
                """, nomeJogador, pontosJogador, maoJogador));

        // Segundo jogador
        nomeComputador = jogadores.getLast().getNome();
        pontosComputador = jogadores.getLast().getPontos();
        maoComputador = jogadores.getLast().getMao();

        // Constrindo a msg
        msg.append(String.format("""
                =================
                || Jogador: %s
                || Pontos: %d
                || Cartas: %s
                \s
                """, nomeComputador, pontosComputador, maoComputador));

        // Condições de vitória
        if (pontosJogador > 21 && pontosComputador > 21) {
            msg.append("================= \nNão houve ganhador");
        } else if (pontosJogador <= 21 && (pontosJogador > pontosComputador || pontosComputador > 21)) {
            msg.append("================= \nGanhador: ").append(nomeJogador);
        } else if (pontosComputador > pontosJogador || pontosJogador > 21) {
            msg.append("================= \nGanhador: ").append(nomeComputador);
        } else {
            msg.append("================= \nEmpate");
        }

        return msg.toString();
    }
}