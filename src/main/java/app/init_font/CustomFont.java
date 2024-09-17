package app.init_font;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.ArrayList;

public class CustomFont {
    private ArrayList<Font> RobotoMonoRegFont;

    public CustomFont() {
        this.RobotoMonoRegFont = new ArrayList<>();

        try {
            // Load the font file (assuming it's in the project directory)
            // CSFONT-TwistyPixel
            // FVF Fernando 08
            File[] fontFile = {
                    new File("train_ticket_management_app/font/RobotoMono-Regular.ttf"),
                    new File("train_ticket_management_app/font/RobotoMono-Bold.ttf"),
                    new File("train_ticket_management_app/font/RobotoMono-BoldItalic.ttf"),
                    new File("train_ticket_management_app/font/RobotoMono-Italic.ttf")
            };

            // File fontFile = new File("font/FVF Fernando 08.ttf"); // for eclipse, intelj
            for (int i = 0; i < fontFile.length; i++) {
                Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile[i]);

                // Register the font with the graphics environment
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(font);

                this.RobotoMonoRegFont.add(font);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // this.RobotoMonoRegFont = new Font("Arial", Font.PLAIN, 12);
        }
    }

    public Font getRobotoMonoRegFont(int style, float size) {
        Font font = new Font("Arial", style, (int) size);

        if (style >= 0 && style < RobotoMonoRegFont.size()) {
            font = RobotoMonoRegFont.get(style).deriveFont(style, size);
        }

        return font;
    }
}
