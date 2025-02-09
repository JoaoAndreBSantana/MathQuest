import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInst extends JPanel {
    public TelaInst(CardLayout cardLayout, JPanel cardPanel) {
        // Configura o layout do painel como nulo para posicionar os componentes manualmente
        setLayout(null);

        // Carrega a imagem de fundo
        ImageIcon fundoIcon = new ImageIcon(getClass().getResource(Constantes.CAMINHO_FUNDO));
        JLabel fundo = new JLabel(fundoIcon);
        fundo.setBounds(0, 0, fundoIcon.getIconWidth(), fundoIcon.getIconHeight());
        add(fundo);

        // Texto das instruções
        JTextArea instrucoes = new JTextArea(
                "Bem-vindo ao MathQuest!\n\n" +
                        "Regras do Jogo:\n" +
                        "1. Cada fase tem um número específico de perguntas.\n" +
                        "2. Você precisa acertar um certo número de perguntas para avançar.\n" +
                        "3. Se errar muitas perguntas, é Game Over!\n" +
                        "4. Boa sorte e divirta-se!"
        );
        instrucoes.setFont(Constantes.FONTE_BOTAO);
        instrucoes.setForeground(new Color(200, 230, 255)); // Branco azulado (tom leve de azul)
        instrucoes.setOpaque(false); // Fundo transparente
        instrucoes.setBackground(new Color(0, 0, 0, 0)); // Fundo invisível
        instrucoes.setEditable(false);
        instrucoes.setBounds(50, 100, 700, 300);
        fundo.add(instrucoes);


        // Botão "Continuar"
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
                // Aqui você pode adicionar a lógica para continuar para a próxima tela
                System.out.println("Continuar para o jogo...");
            }
        });

        fundo.add(botaoContinuar);
    }
}