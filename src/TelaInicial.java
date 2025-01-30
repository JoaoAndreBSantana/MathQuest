import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame {
    public TelaInicial() {
        ImageIcon fundoIcon = new ImageIcon(getClass().getResource(Constantes.CAMINHO_FUNDO));
        setTitle("MathQuest");
        setSize(fundoIcon.getIconWidth(), fundoIcon.getIconHeight());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel fundo = new JLabel(fundoIcon);
        fundo.setLayout(null);
        add(fundo);

        ImageIcon logoIcon = new ImageIcon(getClass().getResource(Constantes.CAMINHO_LOGO));
        JLabel logo = new JLabel(logoIcon);
        int logoX = (fundoIcon.getIconWidth() - logoIcon.getIconWidth()) / 2;
        logo.setBounds(logoX, 50, logoIcon.getIconWidth(), logoIcon.getIconHeight());
        fundo.add(logo);

        JButton botaoIniciar = new JButton("Iniciar Jogo");
        botaoIniciar.setBackground(new Color(30, 100, 200));
        botaoIniciar.setForeground(new Color(255, 215, 0));
        botaoIniciar.setFont(Constantes.FONTE_BOTAO);
        botaoIniciar.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 3));
        botaoIniciar.setFocusPainted(false);

        int botaoX = (fundoIcon.getIconWidth() - 200) / 2;
        botaoIniciar.setBounds(botaoX, 400, 200, 50);
        botaoIniciar.addActionListener(e -> {
            dispose();
            new TelaInst();
        });

        fundo.add(botaoIniciar);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaInicial());
    }
}
