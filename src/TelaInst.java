import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInst extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public TelaInst(CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;


        setLayout(null);


        ImageIcon fundoIcon = new ImageIcon(getClass().getResource(Constantes.CAMINHO_FUNDO));
        JLabel fundo = new JLabel(fundoIcon);
        fundo.setBounds(0, 0, fundoIcon.getIconWidth(), fundoIcon.getIconHeight());
        add(fundo);


        JTextArea instrucoes = new JTextArea(
                "Regras do MathQuest:\n\n" +
                        "Fase 1:\n" +
                        "- Acerte 7 perguntas para avançar.\n" +
                        "- Erre 5 e é Game Over.\n" +
                        "- Usa adição e subtração.\n" +
                        "Fase 2:\n" +
                        "- Acerte 10 para vencer.\n" +
                        "- Erre 3 e perde.\n" +
                        "- Usa multiplicação e divisão.\n" +
                        "AJUDA:\n" +
                        "- Você pode eliminar 1 alternativa errada por pergunta."
        );


        instrucoes.setFont(Constantes.FONTE_BOTAO);
        instrucoes.setForeground(new Color(240, 248, 255));
        instrucoes.setOpaque(false); // Fundo transparente
        instrucoes.setBackground(new Color(0, 0, 0, 0));
        instrucoes.setEditable(false);
        instrucoes.setBounds(50, 100, 700, 300);
        fundo.add(instrucoes);


        JButton botaoContinuar = new JButton("Continuar");
        botaoContinuar.setBackground(Constantes.AZUL_ESCURO);
        botaoContinuar.setForeground(Constantes.AMARELO_BRILHANTE);
        botaoContinuar.setFont(Constantes.FONTE_BOTAO);
        botaoContinuar.setBorder(BorderFactory.createLineBorder(Constantes.AMARELO_BRILHANTE, 3));
        botaoContinuar.setFocusPainted(false);

        int botaoX = (fundoIcon.getIconWidth() - 200) / 2;
        botaoContinuar.setBounds(botaoX, 450, 200, 50);
        botaoContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(TelaInst.this);
                if (frame != null) {
                    frame.dispose();
                }

                new TelaQuiz(1);
            }
        });

        fundo.add(botaoContinuar);
    }
}