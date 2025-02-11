/*import javax.swing.*;
import java.awt.*;

public class TelaVitoria extends JPanel {
    public TelaVitoria() {
        // Configura o layout do painel como nulo para posicionar os componentes manualmente
        setLayout(null);

        // Carrega a imagem de fundo
        ImageIcon fundoIcon = new ImageIcon(getClass().getResource(Constantes.CAMINHO_FUNDO));
        JLabel fundo = new JLabel(fundoIcon);
        fundo.setBounds(0, 0, fundoIcon.getIconWidth(), fundoIcon.getIconHeight());
        add(fundo);

        // Painel para os componentes (transparente)
        JPanel componentesPanel = new JPanel();
        componentesPanel.setLayout(null);
        componentesPanel.setBounds(0, 0, fundoIcon.getIconWidth(), fundoIcon.getIconHeight());
        componentesPanel.setOpaque(false); // Torna o painel transparente
        add(componentesPanel);

        // Texto de vitória
        JLabel victoryLabel = new JLabel("Parabéns, você venceu MathQuest!");
        victoryLabel.setFont(Constantes.FONTE_TITULO);
        victoryLabel.setForeground(Constantes.AMARELO_BRILHANTE);
        victoryLabel.setBounds(150, 200, 500, 50);
        componentesPanel.add(victoryLabel);
    }
}*/