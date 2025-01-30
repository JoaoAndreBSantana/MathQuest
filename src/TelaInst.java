import javax.swing.*;
import java.awt.*;

public class TelaInst extends JFrame {
    public TelaInst() {
        ImageIcon fundoIcon = new ImageIcon(getClass().getResource(Constantes.CAMINHO_FUNDO));
        setTitle("MathQuest - Instruções");
        setSize(fundoIcon.getIconWidth(), fundoIcon.getIconHeight());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel fundo = new JLabel(fundoIcon);
        fundo.setLayout(null);
        add(fundo);

        JTextArea instrucoes = new JTextArea(
                "Bem-vindo ao MathQuest!\n\n" +
                        "Regras do Jogo:\n" +
                        "1.Cada fase tem um número específico de perguntas.\n" +
                        "2.Você precisa acertar um certo número de perguntas para avançar.\n" +
                        "3.Se errar muitas perguntas, é Game Over!\n" +
                        "4.Boa sorte e divirta-se!"
        );
        instrucoes.setFont(new Font("Arial", Font.PLAIN, 20));
        instrucoes.setForeground(Constantes.AMARELO_BRILHANTE);
        instrucoes.setBackground(new Color(0, 0, 0, 0));
        instrucoes.setEditable(false);
        instrucoes.setBounds(50, 100, 700, 300);
        fundo.add(instrucoes);

        JButton botaoContinuar = new JButton("Continuar");
        botaoContinuar.setBackground(new Color(30, 100, 200));
        botaoContinuar.setForeground(new Color(255, 215, 0));
        botaoContinuar.setFont(Constantes.FONTE_BOTAO);
        botaoContinuar.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 3));
        botaoContinuar.setFocusPainted(false);

        int botaoX = (fundoIcon.getIconWidth() - 200) / 2;
        botaoContinuar.setBounds(botaoX, 450, 200, 50);

        fundo.add(botaoContinuar);
        setVisible(true);
    }
}
