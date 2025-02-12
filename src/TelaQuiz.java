import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TelaQuiz extends JFrame implements ActionListener {
    private int fase;
    private int acertos = 0;
    private int erros = 0;
    private int perguntaAtual = 0; // Controla a pergunta atual
    private JLabel perguntaLabel;
    private JButton[] botoesRespostas;
    private JButton botaoAjuda; // Botão de ajuda
    private List<Pergunta> perguntas; // Lista de perguntas
    private boolean ajudaUsada = false; // Controla se a ajuda foi usada na pergunta atual

    public TelaQuiz(int fase) {
        this.fase = fase;

        // Configura a janela
        setTitle("MathQuest Quiz");
        setSize(749, 562); // Tamanho da janela ajustado
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Usar layout nulo para posicionamento manual
        getContentPane().setBackground(Constantes.AZUL_ESCURO); // Azul claro

        // Inicializa as perguntas e respostas
        inicializarPerguntasERespostas();

        // Adiciona componentes do quiz
        adicionarComponentesQuiz();

        // Centraliza a janela na tela
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void inicializarPerguntasERespostas() {
        perguntas = new ArrayList<>();

        // Perguntas e respostas para a fase 1 (adição e subtração)
        perguntas.add(new Pergunta("1 + 2 = ?", "3", new String[]{"2", "4", "5"}));
        perguntas.add(new Pergunta("5 - 3 = ?", "2", new String[]{"1", "0", "3"}));
        perguntas.add(new Pergunta("8 + 6 = ?", "14", new String[]{"12", "16", "10"}));
        perguntas.add(new Pergunta("10 - 4 = ?", "6", new String[]{"5", "7", "8"}));
        perguntas.add(new Pergunta("7 + 9 = ?", "16", new String[]{"14", "15", "18"}));
        perguntas.add(new Pergunta("2 - 11 = ?", "-9", new String[]{"-8", "-10", "-7"}));
        perguntas.add(new Pergunta("6 + 7 = ?", "13", new String[]{"12", "14", "15"}));
        perguntas.add(new Pergunta("9 - 3 = ?", "6", new String[]{"5", "4", "7"}));
        perguntas.add(new Pergunta("4 + 5 = ?", "9", new String[]{"8", "10", "7"}));
        perguntas.add(new Pergunta("3 - 8 = ?", "-5", new String[]{"-4", "-6", "-3"}));
        perguntas.add(new Pergunta("12 + 7 = ?", "19", new String[]{"18", "20", "21"}));
        perguntas.add(new Pergunta("15 - 5 = ?", "10", new String[]{"9", "11", "12"}));
        perguntas.add(new Pergunta("11 + 2 = ?", "13", new String[]{"12", "14", "15"}));
        perguntas.add(new Pergunta("14 - 3 = ?", "11", new String[]{"10", "12", "13"}));
        perguntas.add(new Pergunta("13 + 6 = ?", "19", new String[]{"18", "20", "21"}));
        perguntas.add(new Pergunta("10 - 2 = ?", "8", new String[]{"7", "6", "9"}));
        perguntas.add(new Pergunta("7 + 3 = ?", "10", new String[]{"9", "11", "12"}));
        perguntas.add(new Pergunta("15 - 5 = ?", "10", new String[]{"9", "11", "12"}));
        perguntas.add(new Pergunta("8 + 4 = ?", "12", new String[]{"11", "13", "14"}));
        perguntas.add(new Pergunta("9 - 6 = ?", "3", new String[]{"2", "4", "5"}));
        perguntas.add(new Pergunta("12 - 7 = ?", "5", new String[]{"4", "6", "7"}));
        perguntas.add(new Pergunta("18 + 9 = ?", "27", new String[]{"26", "28", "25"}));
        perguntas.add(new Pergunta("14 - 8 = ?", "6", new String[]{"5", "7", "8"}));
        perguntas.add(new Pergunta("11 - 5 = ?", "6", new String[]{"5", "7", "8"}));
        perguntas.add(new Pergunta("20 + 10 = ?", "30", new String[]{"29", "31", "32"}));
        perguntas.add(new Pergunta("17 - 7 = ?", "10", new String[]{"9", "11", "12"}));
        perguntas.add(new Pergunta("13 - 4 = ?", "9", new String[]{"8", "10", "11"}));
        perguntas.add(new Pergunta("16 - 8 = ?", "8", new String[]{"7", "9", "10"}));
        perguntas.add(new Pergunta("19 + 9 = ?", "28", new String[]{"27", "29", "30"}));
        perguntas.add(new Pergunta("21 - 11 = ?", "10", new String[]{"9", "11", "12"}));


        perguntas.add(new Pergunta("2 * 3 = ?", "6", new String[]{"5", "7", "8"}));
        perguntas.add(new Pergunta("4 * 2 = ?", "8", new String[]{"7", "9", "10"}));
        perguntas.add(new Pergunta("5 * 2 = ?", "10", new String[]{"9", "11", "12"}));
        perguntas.add(new Pergunta("3 * 3 = ?", "9", new String[]{"8", "10", "11"}));
        perguntas.add(new Pergunta("6 * 2 = ?", "12", new String[]{"11", "13", "14"}));
        perguntas.add(new Pergunta("8 / 2 = ?", "4", new String[]{"3", "5", "6"}));
        perguntas.add(new Pergunta("9 / 3 = ?", "3", new String[]{"2", "4", "5"}));
        perguntas.add(new Pergunta("6 / 2 = ?", "3", new String[]{"2", "4", "5"}));
        perguntas.add(new Pergunta("10 / 2 = ?", "5", new String[]{"4", "6", "7"}));
        perguntas.add(new Pergunta("12 / 3 = ?", "4", new String[]{"3", "5", "6"}));
        perguntas.add(new Pergunta("4 * 3 = ?", "12", new String[]{"11", "13", "14"}));
        perguntas.add(new Pergunta("7 * 2 = ?", "14", new String[]{"12", "16", "18"}));
        perguntas.add(new Pergunta("8 * 1 = ?", "8", new String[]{"7", "9", "10"}));
        perguntas.add(new Pergunta("9 * 2 = ?", "18", new String[]{"16", "20", "22"}));
        perguntas.add(new Pergunta("5 * 3 = ?", "15", new String[]{"14", "16", "18"}));
        perguntas.add(new Pergunta("10 / 5 = ?", "2", new String[]{"1", "3", "4"}));
        perguntas.add(new Pergunta("8 / 4 = ?", "2", new String[]{"1", "3", "4"}));
        perguntas.add(new Pergunta("6 / 3 = ?", "2", new String[]{"1", "3", "4"}));
        perguntas.add(new Pergunta("12 / 4 = ?", "3", new String[]{"2", "4", "5"}));
        perguntas.add(new Pergunta("15 / 3 = ?", "5", new String[]{"4", "6", "7"}));
    }

    private void adicionarComponentesQuiz() {
        // Label para a pergunta
        perguntaLabel = new JLabel(perguntas.get(perguntaAtual).getPergunta(), SwingConstants.CENTER);
        perguntaLabel.setFont(Constantes.FONTE_TITULO); // Fonte maior e em negrito
        perguntaLabel.setForeground(Constantes.AMARELO_BRILHANTE); // Cor da pergunta
        perguntaLabel.setBounds(0, 40, 749, 50); // Centraliza a pergunta
        add(perguntaLabel);

// Botões para as respostas (centralizados)
        botoesRespostas = new JButton[4];
        List<String> alternativas = new ArrayList<>(List.of(perguntas.get(perguntaAtual).getAlternativas()));
        alternativas.add(perguntas.get(perguntaAtual).getRespostaCorreta());
        Collections.shuffle(alternativas);

        int larguraBotao = 400;
        int alturaBotao = 50;
        int espacamento = 20; // Espaçamento entre os botões
        int x = (749 - larguraBotao) / 2; // Centraliza horizontalmente

        for (int i = 0; i < botoesRespostas.length; i++) {
            botoesRespostas[i] = new JButton(alternativas.get(i)); // Distribui as respostas
            botoesRespostas[i].setBackground(Color.WHITE); // Fundo branco
            botoesRespostas[i].setForeground(Constantes.AZUL_CLARO); // Texto preto
            botoesRespostas[i].setFont(Constantes.FONTE_BOTAO); // Fonte do botão
            botoesRespostas[i].setBorder(BorderFactory.createLineBorder(Constantes.AMARELO_BRILHANTE, 3));
            botoesRespostas[i].setBounds(x, 100 + (i * (alturaBotao + espacamento)), larguraBotao, alturaBotao); // Posiciona as alternativas
            botoesRespostas[i].addActionListener(this);
            add(botoesRespostas[i]);
        }

        // Botão de ajuda (canto inferior direito)
        botaoAjuda = new JButton("AJUDA");
        botaoAjuda.setFont(new Font("Arial", Font.PLAIN, 14)); // Fonte menor
        botaoAjuda.setBounds(480, 20, 80, 30); // Canto superior direito
        botaoAjuda.setBackground(Color.WHITE); // Cor de fundo do botão
        botaoAjuda.setForeground(Constantes.VERDE_ESCOLA); // Define a cor do texto como azul


        botaoAjuda.addActionListener(this);
        add(botaoAjuda);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoAjuda) {
            // Lógica do botão de ajuda
            if (!ajudaUsada) {
                eliminarAlternativaErrada();
                ajudaUsada = true; // Marca que a ajuda foi usada nesta pergunta
                botaoAjuda.setEnabled(false); // Desabilita o botão de ajuda
            }
        } else {
            // Lógica dos botões de resposta
            JButton botaoClicado = (JButton) e.getSource();
            String resposta = botaoClicado.getText();

            // Verifica se a resposta está correta
            if (resposta.equals(perguntas.get(perguntaAtual).getRespostaCorreta())) {
                acertos++;
                botaoClicado.setBackground(Color.GREEN); // Feedback visual para resposta correta
            } else {
                erros++;
                botaoClicado.setBackground(Color.RED); // Feedback visual para resposta incorreta
            }

            // Aguarda um pouco antes de avançar
            Timer timer = new Timer(300, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Avança para a próxima pergunta
                    perguntaAtual++;
                    if (perguntaAtual < perguntas.size()) {
                        atualizarPergunta();
                    } else {
                        verificarFimDoJogo();
                    }
                }
            });
            timer.setRepeats(false); // O timer só executa uma vez
            timer.start();
        }
    }

    private void eliminarAlternativaErrada() {
        List<JButton> botoesErrados = new ArrayList<>();
        String respostaCorreta = perguntas.get(perguntaAtual).getRespostaCorreta();

        // Encontra todos os botões com respostas erradas
        for (JButton botao : botoesRespostas) {
            if (!botao.getText().equals(respostaCorreta)) {
                botoesErrados.add(botao);
            }
        }

        // Escolhe um botão errado aleatoriamente e o desabilita
        if (!botoesErrados.isEmpty()) {
            Random random = new Random();
            int indice = random.nextInt(botoesErrados.size());
            JButton botaoErrado = botoesErrados.get(indice);
            botaoErrado.setEnabled(false); // Desabilita o botão
            botaoErrado.setText(botaoErrado.getText() + " (X)"); // Adiciona um "X" ao texto
        }
    }

    private void atualizarPergunta() {
        perguntaLabel.setText(perguntas.get(perguntaAtual).getPergunta());
        List<String> alternativas = new ArrayList<>(List.of(perguntas.get(perguntaAtual).getAlternativas()));
        alternativas.add(perguntas.get(perguntaAtual).getRespostaCorreta());
        Collections.shuffle(alternativas);

        for (int i = 0; i < botoesRespostas.length; i++) {
            botoesRespostas[i].setText(alternativas.get(i));
            botoesRespostas[i].setBackground(Color.WHITE); // Reseta a cor do botão
            botoesRespostas[i].setEnabled(true); // Reabilita todos os botões
        }

        // Redefine o botão de ajuda para a nova pergunta
        ajudaUsada = false;
        botaoAjuda.setEnabled(true);
    }

    private void verificarFimDoJogo() {
        if (fase == 1) {
            if (acertos >= 5) {
                JOptionPane.showMessageDialog(this, "Você avançou para a Fase 2!");
                // Aqui você pode adicionar a lógica para avançar para a próxima tela
            } else if (erros >= 5) {
                JOptionPane.showMessageDialog(this, "Game Over!");
                // Aqui você pode adicionar a lógica para voltar ao menu ou encerrar o jogo
            }
        } else if (fase == 2) {
            if (acertos >= 10) {
                JOptionPane.showMessageDialog(this, "Parabéns, você venceu MathQuest!");
                // Aqui você pode adicionar a lógica para finalizar o jogo
            } else if (erros >= 3) {
                JOptionPane.showMessageDialog(this, "Game Over!");
                // Aqui você pode adicionar a lógica para voltar ao menu ou encerrar o jogo
            }
        }
    }

    private class Pergunta {
        private String pergunta;
        private String respostaCorreta;
        private String[] alternativas;

        public Pergunta(String pergunta, String respostaCorreta, String[] alternativas) {
            this.pergunta = pergunta;
            this.respostaCorreta = respostaCorreta;
            this.alternativas = alternativas;
        }

        public String getPergunta() {
            return pergunta;
        }

        public String getRespostaCorreta() {
            return respostaCorreta;
        }

        public String[] getAlternativas() {
            return alternativas;
        }
    }

    public static void main(String[] args) {
        new TelaQuiz(1); // Inicia o quiz na fase 1
    }
}