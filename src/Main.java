import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Carrega a imagem de fundo para definir o tamanho da janela
            ImageIcon fundoIcon = new ImageIcon(Main.class.getResource(Constantes.CAMINHO_FUNDO));
            int largura = fundoIcon.getIconWidth();
            int altura = fundoIcon.getIconHeight();

            // Cria a janela principal com o tamanho da imagem de fundo
            JFrame frame = new JFrame("MathQuest");
            frame.setSize(largura, altura);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            // Painel principal com CardLayout
            CardLayout cardLayout = new CardLayout();
            JPanel cardPanel = new JPanel(cardLayout);
            cardPanel.setPreferredSize(new Dimension(largura, altura));

            // Adiciona as telas ao painel principal
            cardPanel.add(new TelaInicial(cardLayout, cardPanel), "TelaInicial");
            cardPanel.add(new TelaInst(cardLayout, cardPanel), "TelaInst");

            // Adiciona o painel ao frame e ajusta o tamanho
            frame.add(cardPanel);
            frame.pack(); // Ajusta o tamanho para o conteúdo
            frame.setVisible(true);
        });
    }
}
