package app.giao_dien;

import lombok.extern.slf4j.Slf4j;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Map;

@Slf4j

public class BarChartExample extends JPanel {
    public BarChartExample(Map<Integer, Double> danhSachDoanhThu) {
        // Tạo dataset
        DefaultCategoryDataset dataset = createDataset(danhSachDoanhThu);

        // Tạo biểu đồ
        JFreeChart chart = ChartFactory.createBarChart(
                "Tổng Quan Doanh Thu Theo Biểu Đồ Cột", // tiêu đề
                "", // trục hoành
                "Doanh Thu", // trục tung
                dataset, // dataset
                PlotOrientation.VERTICAL,
                true, // hiển thị legend
                true, // hiển thị tooltips
                false // hiển thị URLs
        );

        // Tùy chỉnh cho trục y để hiển thị dấu phẩy
        CategoryPlot plot = chart.getCategoryPlot();
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setNumberFormatOverride(new DecimalFormat("#,###"));

        BarRenderer renderer = new BarRenderer();
        renderer.setSeriesPaint(0, Color.BLUE); // Màu cho chuỗi đầu tiên
        plot.setRenderer(renderer);

        // Tạo ChartPanel và thêm vào JPanel (BarChartExample)
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new java.awt.Dimension(800, 400));
        panel.setMouseWheelEnabled(false); // Vô hiệu hóa zoom bằng bánh xe chuột
        panel.setDomainZoomable(false); // Vô hiệu hóa panning trên trục hoành
        panel.setRangeZoomable(false); // Vô hiệu hóa panning trên trục tung

        // Thêm ChartPanel vào JPanel (BarChartExample)
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
    }

    private DefaultCategoryDataset createDataset(Map<Integer, Double> danhSachDoanhThu) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Integer i : danhSachDoanhThu.keySet()) {
            Double doanhThu = danhSachDoanhThu.get(i); // Lấy giá trị từ bản đồ
            // Kiểm tra nếu giá trị không null
            if (doanhThu != null) {
                dataset.addValue(doanhThu, "doanh thu", i.toString());
            }
        }
        return dataset;
    }
}
