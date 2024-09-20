package app.phan_tu_tuy_chinh;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.border.Border;

public class RoundedBorder implements Border {
    private int radius;

    public RoundedBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        // Vẽ đường viền bo tròn
        g.setColor(Color.GRAY); // Bạn có thể thay đổi màu viền
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        // Cung cấp khoảng cách của đường viền từ các cạnh của thành phần
        return new Insets(this.radius, this.radius, this.radius, this.radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
