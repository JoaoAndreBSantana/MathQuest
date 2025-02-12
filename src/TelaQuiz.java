import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private String[] perguntas;
    private String[] respostas;
    private boolean ajudaUsada = false; // Controla se a ajuda foi usada na pergunta atual

    public TelaQuiz(int fase) {
        this.fase = fase;

        // Configura a janela
        setTitle("MathQuest Quiz");
        setSize(749, 562); // Tamanho da janela ajustado
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Usar layout nulo para posicionamento manual
        getContentPane().setBackground(Constantes.AZUL_CLARO); // Azul claro

        // Inicializa as perguntas e respostas
        inicializarPerguntasERespostas();

        // Adiciona componentes do quiz
        adicionarComponentesQuiz();

        // Centraliza a janela na tela
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void inicializarPerguntasERespostas() {
        // Perguntas e respostas para a fase 1 (adição e subtração)
        String[] perguntasFase1 = {
                "1 + 2 = ?", "5 - 3 = ?", "8 + 6 = ?", "10 - 4 = ?", "7 + 9 = ?",
                "2 - 11 = ?", "6 + 7 = ?", "9 - 3 = ?", "4 + 5 = ?", "3 - 8 = ?",
                "12 + 7 = ?", "15 - 5 = ?", "11 + 2 = ?", "14 - 3 = ?", "13 + 6 = ?",
                "10 - 2 = ?", "7 + 3 = ?", "15 - 5 = ?", "8 + 4 = ?", "9 - 6 = ?",
                "12 - 7 = ?", "18 + 9 = ?", "14 - 8 = ?", "11 - 5 = ?", "20 + 10 = ?",
                "17 - 7 = ?", "13 - 4 = ?", "16 - 8 = ?", "19 + 9 = ?", "21 - 11 = ?"
        };

        String[] respostasFase1 = {
                "3", "2", "14", "6", "16", "-9", "13", "6", "9", "-5",
                "19", "10", "13", "11", "19", "8", "10", "10", "12", "3",
                "5", "27", "6", "6", "30", "10", "9", "8", "28", "10"
        };

        // Perguntas e respostas para a fase 2 (multiplicação e divisão fáceis)
        String[] perguntasFase2 = {
                "2 * 3 = ?", "4 * 2 = ?", "5 * 2 = ?", "3 * 3 = ?", "6 * 2 = ?",
                "8 / 2 = ?", "9 / 3 = ?", "6 / 2 = ?", "10 / 2 = ?", "12 / 3 = ?",
                "4 * 3 = ?", "7 * 2 = ?", "8 * 1 = ?", "9 * 2 = ?", "5 * 3 = ?",
                "10 / 5 = ?", "8 / 4 = ?", "6 / 3 = ?", "12 / 4 = ?", "15 / 3 = ?"
        };

        String[] respostasFase2 = {
                "6", "8", "10", "9", "12", "4", "3", "3", "5", "4",
                "12", "14", "8", "18", "15", "2", "2", "2", "3", "5"
        };

        // Define as perguntas e respostas com base na fase
        perguntas = fase == 1 ? perguntasFase1 : perguntasFase2;
        respostas = fase == 1 ? respostasFase1 : respostasFase2;
    }

    private void adicionarComponentesQuiz() {
        // Label para a pergunta
        perguntaLabel = new JLabel(perguntas[perguntaAtual], SwingConstants.CENTER);
        perguntaLabel.setFont(new Font("Arial", Font.BOLD, 26)); // Fonte maior e em negrito
        perguntaLabel.setForeground(Constantes.AMARELO_BRILHANTE); // Cor da pergunta
        perguntaLabel.setBounds(0, 40, 600, 50); // Posiciona a pergunta
        add(perguntaLabel);

        // Botões para as respostas (centralizados)
        botoesRespostas = new JButton[4];
        int larguraBotao = 400;
        int alturaBotao = 50;
        int espacamento = 20; // Menor espaçamento entre os botões
        int x = (600 - larguraBotao) / 2; // Centraliza horizontalmente

        // Resposta correta
        String respostaCorreta = respostas[perguntaAtual * 4]; // Resposta correta da pergunta atual

        // Adiciona a resposta correta
        List<String> alternativas = new ArrayList<>();
        alternativas.add(respostaCorreta);

        // Adiciona alternativas erradas
        while (alternativas.size() < 4) {
            String alternativaErrada = gerarAlternativaErrada(respostaCorreta);
            if (!alternativas.contains(alternativaErrada)) {
                alternativas.add(alternativaErrada);
            }
        }

        // Embaralha as alternativas
        java.util.Collections.shuffle(alternativas);

        // Cria os botões de resposta
        for (int i = 0; i < botoesRespostas.length; i++) {
            botoesRespostas[i] = new JButton(alternativas.get(i)); // Distribui as respostas
            botoesRespostas[i].setBackground(Color.WHITE); // Fundo branco
            botoesRespostas[i].setForeground(Color.BLACK); // Texto preto
            botoesRespostas[i].setFont(new Font("Arial", Font.PLAIN, 20)); // Fonte menor
            botoesRespostas[i].setBounds(x, 100 + (i * (alturaBotao + espacamento)), larguraBotao, alturaBotao); // Posiciona as alternativas
            botoesRespostas[i].addActionListener(this);
            add(botoesRespostas[i]);
        }

        // Botão de ajuda (canto inferior direito)
        botaoAjuda = new JButton("AJUDA");
        botaoAjuda.setFont(new Font("Arial", Font.PLAIN, 14)); // Fonte menor
        botaoAjuda.setBounds(480, 20, 80, 30); // Canto superior direito
        botaoAjuda.addActionListener(this);
        add(botaoAjuda);

        // Garante que todos os componentes sejam renderizados corretamente
        revalidate();
        repaint();
    }


    private String gerarAlternativaErrada(String respostaCorreta) {
        Random random = new Random();
        int resposta = Integer.parseInt(respostaCorreta);
        // Gera uma alternativa errada aleatória (exemplo simples)
        return String.valueOf(resposta + random.nextInt(10) + 1); // Gera um número entre 1 e 10 a mais que a resposta correta
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
            if (resposta.equals(respostas[perguntaAtual * 4])) {
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
                    if (perguntaAtual < perguntas.length) {
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
        String respostaCorreta = respostas[perguntaAtual * 4];

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
        perguntaLabel.setText(perguntas[perguntaAtual]);
        for (int i = 0; i < botoesRespostas.length; i++) {
            botoesRespostas[i].setText(respostas[perguntaAtual * 4 + i]);
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
    } }
