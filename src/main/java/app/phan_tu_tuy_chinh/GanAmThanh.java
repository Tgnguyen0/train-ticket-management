package app.phan_tu_tuy_chinh;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class GanAmThanh {
    // Phương thức phát âm thanh
    public static void playSound() {
        try {
            // Sử dụng class loader để lấy file âm thanh
            InputStream inputStream = GanAmThanh.class.getResourceAsStream("/AmThanh/770203__yuugfr1a__modern-ui-hover.wav");

            if (inputStream == null) {
                throw new RuntimeException("File âm thanh không được tìm thấy!");
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Phát âm thanh
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
}
