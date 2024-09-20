package app.phong_moi;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.ArrayList;

public class PhongChuMoi {
    private ArrayList<Font> phongRobotoMonoReg;

    public PhongChuMoi() {
        this.phongRobotoMonoReg = new ArrayList<>();

        try {
            /* For vscode */
            File[] taiLieuPhong = {
                    new File("train_ticket_management_app/font/RobotoMono-Regular.ttf"),
                    new File("train_ticket_management_app/font/RobotoMono-Bold.ttf"),
                    new File("train_ticket_management_app/font/RobotoMono-BoldItalic.ttf"),
                    new File("train_ticket_management_app/font/RobotoMono-Italic.ttf")
            };

            /* For eclipse, intelJ */
            /*
             * File[] taiLieuPhong = {
             * new File("train_ticket_management_app/font/RobotoMono-Regular.ttf"),
             * new File("train_ticket_management_app/font/RobotoMono-Bold.ttf"),
             * new File("train_ticket_management_app/font/RobotoMono-BoldItalic.ttf"),
             * new File("train_ticket_management_app/font/RobotoMono-Italic.ttf")
             * };
             */

            for (int i = 0; i < taiLieuPhong.length; i++) {
                Font phong = Font.createFont(Font.TRUETYPE_FONT, taiLieuPhong[i]);

                // Register the font with the graphics environment
                GraphicsEnvironment moiTruong = GraphicsEnvironment.getLocalGraphicsEnvironment();
                moiTruong.registerFont(phong);

                this.phongRobotoMonoReg.add(phong);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // this.phongRobotoMonoReg = new Font("Arial", Font.PLAIN, 12);
        }
    }

<<<<<<< HEAD:src/main/java/app/init_font/PhongChuMoi.java
    public Font layPhongRobotoMonoReg(int style, float size) {
        Font font = new Font("Arial", style, (int) size);
=======
    public Font getRobotoMonoRegFont(int style, float size) {
        Font font = new Font("Serif", style, (int) size);
>>>>>>> ab244a938eef000bb1e9e3d6e79e7031c9455586:src/main/java/app/init_font/CustomFont.java

        if (style >= 0 && style < phongRobotoMonoReg.size()) {
            font = phongRobotoMonoReg.get(style).deriveFont(style, size);
        }

        return font;
    }
}
