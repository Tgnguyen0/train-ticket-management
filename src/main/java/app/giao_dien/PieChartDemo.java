package app.giao_dien;

import javax.swing.*;
import java.awt.*;

public class PieChartDemo extends JFrame {
    public PieChartDemo() {
        setTitle("Pie Chart Demo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Giá trị phần trăm của các phần
        double[] values = {70, 20, 10};

        // Màu sắc tương ứng với các phần
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};

        // Thêm biểu đồ vào khung
        PieChartPanel chartPanel = new PieChartPanel(values, colors);
        add(chartPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PieChartDemo();
        });
    }
}
