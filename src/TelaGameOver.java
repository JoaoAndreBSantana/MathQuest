/*

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaGameOver extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public TelaGameOver(CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;

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

        // Texto "Game Over"
        JLabel gameOverLabel = new JLabel("Game Over");
        gameOverLabel.setFont(Constantes.FONTE_TITULO);
        gameOverLabel.setForeground(Constantes.AMARELO_BRILHANTE);
        gameOverLabel.setBounds(300, 200, 200, 50);
        componentesPanel.add(gameOverLabel);

        // Botão "Reiniciar"
        JButton botaoReiniciar = new JButton("Reiniciar");
        botaoReiniciar.setBackground(Constantes.AZUL_ESCURO);
        botaoReiniciar.setForeground(Constantes.AMARELO_BRILHANTE);
        botaoReiniciar.setFont(Constantes.FONTE_BOTAO);
        botaoReiniciar.setBorder(BorderFactory.createLineBorder(Constantes.AMARELO_BRILHANTE, 3));
        botaoReiniciar.setFocusPainted(false);

        int botaoX = (fundoIcon.getIconWidth() - 200) / 2;
        botaoReiniciar.setBounds(botaoX, 400, 200, 50);

        botaoReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Volta para a tela inicial
                cardLayout.show(cardPanel, "TelaInicial");
            }
        });

        componentesPanel.add(botaoReiniciar);
    }
}*/