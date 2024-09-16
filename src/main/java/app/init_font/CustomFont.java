package app.init_font;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

public class CustomFont {
    private Font RobotoMonoRegFont;

    public CustomFont() {

        try {
            // Load the font file (assuming it's in the project directory)
            // CSFONT-TwistyPixel
            // FVF Fernando 08
            File fontFile = new File("train_ticket_management_app/font/RobotoMono-Regular.ttf"); // For vscode
            // File fontFile = new File("font/FVF Fernando 08.ttf"); // for eclipse, intelj
            this.RobotoMonoRegFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);

            // Register the font with the graphics environment
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(RobotoMonoRegFont);

            this.RobotoMonoRegFont = this.RobotoMonoRegFont.deriveFont(9.0f);
        } catch (Exception e) {
            e.printStackTrace();
            this.RobotoMonoRegFont = new Font("Arial", Font.PLAIN, 12);
        }
    }

    public Font getRobotoMonoRegFont(float size) {
        return this.RobotoMonoRegFont.deriveFont(size);
    }
}
