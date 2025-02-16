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
    private int perguntaAtual = 0;
    private JLabel perguntaLabel;
    private JButton[] botoesRespostas;
    private JButton botaoAjuda;
    private List<Pergunta> perguntasFase1;
    private List<Pergunta> perguntasFase2;
    private List<Pergunta> perguntasAtuais;
    private boolean ajudaUsada = false;

    public TelaQuiz(int fase) {
        this.fase = fase;
        this.acertos = 0; // Reinicia a contagem de acertos
        this.erros = 0; // Reinicia a contagem de erros
        this.perguntaAtual = 0; // Reinicia a pergunta atual
        this.ajudaUsada = false; // Reinicia o uso da ajuda

        // minha janela
        setTitle("MathQuest Quiz");
        setSize(749, 562);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Constantes.AZUL_ESCURO);

        // inicializar as perguntas e respostas
        inicializarPerguntasERespostas();

        // verificar as fases
        perguntasAtuais = (fase == 1) ? perguntasFase1 : perguntasFase2;

        adicionarComponentesQuiz();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void inicializarPerguntasERespostas() {
        perguntasFase1 = new ArrayList<>();
        perguntasFase2 = new ArrayList<>();

        // perguntas da fase 1
        perguntasFase1.add(new Pergunta("1 + 2 = ?", "3", new String[]{"2", "4", "5"}));
        perguntasFase1.add(new Pergunta("5 - 3 = ?", "2", new String[]{"1", "0", "3"}));
        perguntasFase1.add(new Pergunta("8 + 6 = ?", "14", new String[]{"12", "16", "10"}));
        perguntasFase1.add(new Pergunta("10 - 4 = ?", "6", new String[]{"5", "7", "8"}));
        perguntasFase1.add(new Pergunta("7 + 9 = ?", "16", new String[]{"14", "15", "18"}));
        perguntasFase1.add(new Pergunta("2 - 11 = ?", "-9", new String[]{"-8", "-10", "-7"}));
        perguntasFase1.add(new Pergunta("6 + 7 = ?", "13", new String[]{"12", "14", "15"}));
        perguntasFase1.add(new Pergunta("9 - 3 = ?", "6", new String[]{"5", "4", "7"}));
        perguntasFase1.add(new Pergunta("4 + 5 = ?", "9", new String[]{"8", "10", "7"}));
        perguntasFase1.add(new Pergunta("3 - 8 = ?", "-5", new String[]{"-4", "-6", "-3"}));

        // pergguntas da fase 2
        perguntasFase2.add(new Pergunta("2 * 3 = ?", "6", new String[]{"5", "7", "8"}));
        perguntasFase2.add(new Pergunta("4 * 2 = ?", "8", new String[]{"7", "9", "10"}));
        perguntasFase2.add(new Pergunta("5 * 2 = ?", "10", new String[]{"9", "11", "12"}));
        perguntasFase2.add(new Pergunta("3 * 3 = ?", "9", new String[]{"8", "10", "11"}));
        perguntasFase2.add(new Pergunta("6 * 2 = ?", "12", new String[]{"11", "13", "14"}));
        perguntasFase2.add(new Pergunta("8 / 2 = ?", "4", new String[]{"3", "5", "6"}));
        perguntasFase2.add(new Pergunta("9 / 3 = ?", "3", new String[]{"2", "4", "5"}));
        perguntasFase2.add(new Pergunta("6 / 2 = ?", "3", new String[]{"2", "4", "5"}));
        perguntasFase2.add(new Pergunta("10 / 2 = ?", "5", new String[]{"4", "6", "7"}));
        perguntasFase2.add(new Pergunta("12 / 3 = ?", "4", new String[]{"3", "5", "6"}));
    }

    private void adicionarComponentesQuiz() {

        perguntaLabel = new JLabel(perguntasAtuais.get(perguntaAtual).getPergunta(), SwingConstants.CENTER);
        perguntaLabel.setFont(Constantes.FONTE_TITULO);
        perguntaLabel.setForeground(Constantes.AMARELO_BRILHANTE);
        perguntaLabel.setBounds(0, 40, 749, 50);
        add(perguntaLabel);


        botoesRespostas = new JButton[4];
        List<String> alternativas = new ArrayList<>(List.of(perguntasAtuais.get(perguntaAtual).getAlternativas()));
        alternativas.add(perguntasAtuais.get(perguntaAtual).getRespostaCorreta());
        Collections.shuffle(alternativas);

        int larguraBotao = 400;
        int alturaBotao = 50;
        int espacamento = 20;
        int x = (749 - larguraBotao) / 2; // Centraliza horizontalmente

        for (int i = 0; i < botoesRespostas.length; i++) {
            botoesRespostas[i] = new JButton(alternativas.get(i));
            botoesRespostas[i].setBackground(Color.WHITE);
            botoesRespostas[i].setForeground(Constantes.AZUL_CLARO);
            botoesRespostas[i].setFont(Constantes.FONTE_BOTAO);
            botoesRespostas[i].setBorder(BorderFactory.createLineBorder(Constantes.AMARELO_BRILHANTE, 3));
            botoesRespostas[i].setBounds(x, 150 + (i * (alturaBotao + espacamento)), larguraBotao, alturaBotao);
            botoesRespostas[i].addActionListener(this);
            add(botoesRespostas[i]);
        }


        botaoAjuda = new JButton("AJUDA");
        botaoAjuda.setFont(new Font("Arial", Font.PLAIN, 14));
        botaoAjuda.setBounds(630, 20, 80, 30);
        botaoAjuda.setBackground(Color.WHITE);
        botaoAjuda.setForeground(Constantes.VERDE_ESCOLA);
        botaoAjuda.addActionListener(this);
        add(botaoAjuda);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoAjuda) {

            if (!ajudaUsada) {
                eliminarAlternativaErrada();
                ajudaUsada = true;
                botaoAjuda.setEnabled(false);
            }

        } else {
            JButton botaoClicado = (JButton) e.getSource();
            String resposta = botaoClicado.getText();

            // Verificando se a resposta está correta
            if (resposta.equals(perguntasAtuais.get(perguntaAtual).getRespostaCorreta())) {
                acertos++;
                botaoClicado.setBackground(Color.GREEN);
            } else {
                erros++;
                botaoClicado.setBackground(Color.RED);
            }

            // Verifica se o jogo deve terminar após esta resposta
            verificarFimDoJogo();

            // Só avança para a próxima pergunta se o jogo não tiver terminado
            if ((fase == 1 && erros < 5 && acertos < 7) || (fase == 2 && erros < 3 && acertos < 10)) {
                // Aguarda um pouco antes de avançar
                Timer timer = new Timer(300, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        perguntaAtual++; // Avança a pergunta
                        if (perguntaAtual < perguntasAtuais.size()) {
                            atualizarPergunta();
                        } else {
                            verificarFimDoJogo(); // Verifica novamente ao final das perguntas
                        }
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }
    private void eliminarAlternativaErrada() {
        List<JButton> botoesErrados = new ArrayList<>();
        String respostaCorreta = perguntasAtuais.get(perguntaAtual).getRespostaCorreta();


        for (JButton botao : botoesRespostas) {
            if (!botao.getText().equals(respostaCorreta)) {
                botoesErrados.add(botao);
            }
        }

        // escolhendo botao aleatorio e o desabilitando
        if (!botoesErrados.isEmpty()) {

            Random random = new Random();
            int indice = random.nextInt(botoesErrados.size());

            JButton botaoErrado = botoesErrados.get(indice);
            botaoErrado.setEnabled(false);
            botaoErrado.setText(botaoErrado.getText() + " (X)");
        }
    }

    private void atualizarPergunta() {
        perguntaLabel.setText(perguntasAtuais.get(perguntaAtual).getPergunta());
        List<String> alternativas = new ArrayList<>(List.of(perguntasAtuais.get(perguntaAtual).getAlternativas()));
        alternativas.add(perguntasAtuais.get(perguntaAtual).getRespostaCorreta());
        Collections.shuffle(alternativas);

        for (int i = 0; i < botoesRespostas.length; i++) {
            botoesRespostas[i].setText(alternativas.get(i));
            botoesRespostas[i].setBackground(Color.WHITE);
            botoesRespostas[i].setEnabled(true);
        }

        // reedefine o botao de ajuda para a nova pergunta
        ajudaUsada = false;
        botaoAjuda.setEnabled(true);
    }

    private void verificarFimDoJogo() {
        if (fase == 1) {
            if (acertos == 7) {
                JOptionPane.showMessageDialog(this, "Você avançou para a Fase 2!");
                new TelaQuiz(2); // Inicia a Fase 2
                dispose(); // Fecha a janela atual
            } else if (erros == 5) {
                JOptionPane.showMessageDialog(this, "Game Over!");
                System.exit(0); // Fecha o jogo
            }
        } else if (fase == 2) {
            if (acertos == 10) {
                JOptionPane.showMessageDialog(this, "Parabéns, você venceu MathQuest!");
                System.exit(0); // Fecha o jogo
            } else if (erros == 3) {
                JOptionPane.showMessageDialog(this, "Game Over!");
                System.exit(0); // Fecha o jogo
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
    }}

    /*public static void main(String[] args) {
        new TelaQuiz(1);
    }
}*/