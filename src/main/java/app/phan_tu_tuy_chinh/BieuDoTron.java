package app.phan_tu_tuy_chinh;

import javax.swing.*;
import java.awt.*;

public class BieuDoTron extends JPanel {
    // Mảng chứa các giá trị phần trăm cho các phần của biểu đồ
    private double[] values;
    private Color[] colors;

    public BieuDoTron(double[] values, Color[] colors) {
        this.values = values;
        this.colors = colors;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPie((Graphics2D) g, getBounds(), values, colors);
    }

    // Phương thức vẽ biểu đồ hình tròn
    private void drawPie(Graphics2D g, Rectangle area, double[] values, Color[] colors) {
        double total = 0.0;
        for (double value : values) {
            total += value;
        }

        // Kiểm tra nếu tổng là 0 để tránh chia cho 0
        if (total == 0) {
            return;
        }

        double[] normalizedValues = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            normalizedValues[i] = values[i] / total;
        }

        double curValue = 0.0;
        int startAngle = 90; // Bắt đầu từ phía trên

        for (int i = 0; i < normalizedValues.length; i++) {
            int arcAngle = (int) Math.round(normalizedValues[i] * 360);

            g.setColor(colors[i]);
            g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
            startAngle += arcAngle;
        }
    }
}
