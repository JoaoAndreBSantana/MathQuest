import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JPanel {
    public TelaInicial(CardLayout cardLayout, JPanel cardPanel) {

        setLayout(null);


        ImageIcon fundoIcon = new ImageIcon(getClass().getResource(Constantes.CAMINHO_FUNDO));
        JLabel fundo = new JLabel(fundoIcon);
        fundo.setBounds(0, 0, fundoIcon.getIconWidth(), fundoIcon.getIconHeight());
        add(fundo);


        ImageIcon logoIcon = new ImageIcon(getClass().getResource(Constantes.CAMINHO_LOGO));
        JLabel logo = new JLabel(logoIcon);
        int logoX = (fundoIcon.getIconWidth() - logoIcon.getIconWidth()) / 2;
        logo.setBounds(logoX, 50, logoIcon.getIconWidth(), logoIcon.getIconHeight());
        fundo.add(logo);


        JButton botaoIniciar = new JButton("Iniciar Jogo");
        botaoIniciar.setBackground(Constantes.AZUL_ESCURO);
        botaoIniciar.setForeground(Constantes.AMARELO_BRILHANTE);
        botaoIniciar.setFont(Constantes.FONTE_BOTAO);
        botaoIniciar.setBorder(BorderFactory.createLineBorder(Constantes.AMARELO_BRILHANTE, 3));
        botaoIniciar.setFocusPainted(false);

        int botaoX = (fundoIcon.getIconWidth() - 200) / 2;
        botaoIniciar.setBounds(botaoX, 400, 200, 50);
        botaoIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.show(cardPanel, "TelaInst");
            }
        });

        fundo.add(botaoIniciar);
    }
}