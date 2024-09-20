package app.phong_moi;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class ShadowButton extends JButton {
    public ShadowButton(String text) {
        super(text);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        // Bật chế độ khử răng cưa
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Vẽ bóng cho văn bản
        g2d.setFont(getFont());
        FontMetrics fm = g2d.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();

        // Màu bóng xám nhạt với độ trong suốt
        g2d.setColor(new Color(128, 128, 128, 100)); // Màu xám nhạt, alpha 100 để bóng nhạt hơn
        g2d.drawString(getText(), x + 2, y + 2); // Dịch chuyển bóng 2px

        // Vẽ văn bản chính
        g2d.setColor(getForeground()); // Màu văn bản chính
        g2d.drawString(getText(), x, y); // Vẽ văn bản tại vị trí chuẩn

        g2d.dispose();
    }
}
