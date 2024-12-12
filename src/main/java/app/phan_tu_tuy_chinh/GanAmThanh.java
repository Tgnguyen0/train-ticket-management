package app.phan_tu_tuy_chinh;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class GanAmThanh {
    // Phương thức phát âm thanh
    public static void playSound() {
        try {
            // Đọc file âm thanh
            File file = new File("AmThanh/770203__yuugfr1a__modern-ui-hover.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Phát âm thanh
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
}
