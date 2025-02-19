import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Musica musica = new Musica();
            musica.tocar(Constantes.MUSICA_JOGO);

            ImageIcon fundoIcon = new ImageIcon(Main.class.getResource(Constantes.CAMINHO_FUNDO));
            int largura = fundoIcon.getIconWidth();
            int altura = fundoIcon.getIconHeight();

            JFrame frame = new JFrame("MathQuest");
            frame.setSize(largura, altura);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            CardLayout cardLayout = new CardLayout();
            JPanel cardPanel = new JPanel(cardLayout);
            cardPanel.setPreferredSize(new Dimension(largura, altura));

            cardPanel.add(new TelaInicial(cardLayout, cardPanel), "TelaInicial");
            cardPanel.add(new TelaInst(cardLayout, cardPanel), "TelaInst");

            frame.add(cardPanel);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
