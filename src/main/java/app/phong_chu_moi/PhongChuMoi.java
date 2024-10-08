package app.phong_chu_moi;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.ArrayList;

public class PhongChuMoi {
    private ArrayList<Font> phongRobotoMonoReg;

    public PhongChuMoi() {
        this.phongRobotoMonoReg = new ArrayList<>();

        try {
            File[] taiLieuPhong = {
                    new File("font/RobotoMono-Regular.ttf"),
                    new File("font/RobotoMono-Bold.ttf"),
                    new File("font/RobotoMono-BoldItalic.ttf"),
                    new File("font/RobotoMono-Italic.ttf")
            };

            for (int i = 0; i < taiLieuPhong.length; i++) {
                Font phong = Font.createFont(Font.TRUETYPE_FONT, taiLieuPhong[i]);

                // Register the font with the graphics environment
                GraphicsEnvironment moiTruong = GraphicsEnvironment.getLocalGraphicsEnvironment();
                moiTruong.registerFont(phong);

                this.phongRobotoMonoReg.add(phong);
            }
        } catch (Exception e) {
            e.printStackTrace();
//             this.phongRobotoMonoReg = new Font("Arial", Font.PLAIN, 12);
        }
    }

    public Font layPhongRobotoMonoReg(int style, float size) {
        Font phong = new Font("Arial", style, (int) size);

        if (style >= 0 && style < phongRobotoMonoReg.size()) {
            phong = phongRobotoMonoReg.get(style).deriveFont(style, size);
        }

        return phong;
    }
}
