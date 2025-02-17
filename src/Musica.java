import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Musica {
    private Clip clip;

    public void tocar(String caminho) {
        new Thread(() -> { // Executa em uma thread separada
            try {
                URL url = getClass().getResource(caminho);
                if (url == null) {
                    System.err.println("Arquivo de áudio não encontrado: " + caminho);
                    return;
                }

                AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY); // Música em loop
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void parar() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}
