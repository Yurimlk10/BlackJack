import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Laço de repetição do menu
        while (true) {
            // Solicitando o que o usuário quer fazer
            String msg = ("""
                    ================
                            BLACK
                                      JACK
                    ================
                    \s
                    [1] - Jogar
                    [2] - Pontuações
                    [3] - Sair
                    \s
                    Escolha uma opção, meu nobre.
                    """);
            String opcao = JOptionPane.showInputDialog(null, msg);

            // Verificando a opção do usuário
            switch (opcao) {
                case "1" -> jogar();
                case "2" -> sistemaPontuacao();
                case "3" -> {
                    return;
                }
                default -> JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        }
    }

    public static void jogar() {
        // Criando o jogador
        Jogador jogador = new Jogador("Yuri");
        Jogador computador = new Jogador("Bot");

        // Criando um jogo
        Jogo jogo = new Jogo(jogador, computador);
        jogo.iniciarJogo();

        // Laçõ de repetição
        while (true) {
            // Msg de exibição
            String msg = String.format("""
                    ========================
                    Pontos: %d
                    Mão: %s
                    ========================
                    \s
                    [1] - Pescar
                    [2] - Parar
                    \s
                    Escolha uma opção, patrão!
                    """, jogador.getPontos(), jogador.getMao());

            // Verificando se o jogador ainda está no jogo para solicitar a ação
            if (jogador.isNoJogo()) {
                // Solicitando a ação
                String acao = JOptionPane.showInputDialog(null, msg);

                // Realizando a ação desejada
                if (acao.equals("2")) {
                    jogador.sairJogo();
                } else {
                    jogo.pescar(jogador);
                }
            }

            // Verificando se tem alguem no jogo
            if (!jogador.isNoJogo() && !computador.isNoJogo()) {
                JOptionPane.showMessageDialog(null, jogo.verificarVencedor());
                return;
            }

            if (!computador.pescar()) {
                computador.sairJogo();
            }

            // Jogador dois pescando
            jogo.pescar(computador);
        }
    }

    public static void sistemaPontuacao() {
        // Mensagem de exibição
        String msg = ("""
                ================
                        BLACK
                                  JACK
                ================
                \s
                As cartas de valores númericos correspondem a valor padrão, já as
                cartas J (cavalo/valete), Q (dama) e K (rei) valem 10 pontos, e o A (as)
                vale 1 ponto.
                \s
                Nesse black jack, o A (as) vale 1 ponto em todas as circuntancias,
                enquanto no padrão, o A (as) pode valer 1 ou 11, como se encaixar
                melhor no momento.
                \s
                Segue abaixo as tabelas das pontuações:
                [2 = 2 pontos]
                [3 = 3 pontos]
                [4 = 4 pontos]
                [5 = 5 pontos]
                [6 = 6 pontos]
                [7 = 7 pontos]
                [8 = 8 pontos]
                [9 = 9 pontos]
                [10 = 10 pontos]
                [J, Q, K = 10 pontos]
                [A = 1 ponto]
                """);

        // Exibindo a mensagem
        JOptionPane.showMessageDialog(null, msg);
    }
}