package app.custom_component;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class RoundedBorder implements Border {
    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        throw new UnsupportedOperationException("Unimplemented method 'getBorderInsets'");
    }

    @Override
    public boolean isBorderOpaque() {
        throw new UnsupportedOperationException("Unimplemented method 'isBorderOpaque'");
    }

}
