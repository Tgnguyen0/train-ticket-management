package app.giao_dien;

import javax.swing.*;
import java.awt.*;

public class PieChartPanel extends JPanel {
    // Mảng chứa các giá trị phần trăm cho các phần của biểu đồ
    private double[] values;
    private Color[] colors;

    public PieChartPanel(double[] values, Color[] colors) {
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

        double curValue = 0.0;
        int startAngle = -270; // Bắt đầu từ phía trên (góc -90 độ)
        for (int i = 0; i < values.length; i++) {
            int arcAngle = (int) (values[i] * 360 / total);

            g.setColor(colors[i]);
            g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
            startAngle += arcAngle; // Cập nhật góc bắt đầu cho phần tiếp theo
        }

    }
}
