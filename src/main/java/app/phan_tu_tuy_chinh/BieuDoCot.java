package app.phan_tu_tuy_chinh;

import app.giao_dien.TrangChuaThongKeDoanhThuNhaGa;
import app.giao_dien.TrangChuaThongKeNhanVienTheoNam;
import app.giao_dien.TrangChuaThongKeNhanVienTheoThang;
import lombok.extern.slf4j.Slf4j;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map;

@Slf4j

public class BieuDoCot extends JPanel {
    private JFreeChart chart; // Lưu biểu đồ để dùng lại

    public BieuDoCot(Map<String, Double> danhSachDoanhThu, Object object) {
        // Tạo dataset
        DefaultCategoryDataset dataset = createDataset(danhSachDoanhThu);

        // Tạo biểu đồ
        chart = ChartFactory.createBarChart(
                "Tổng Quan Doanh Thu Theo Biểu Đồ Cột", // tiêu đề
                "", // trục hoành
                "Doanh Thu", // trục tung
                dataset, // dataset
                PlotOrientation.VERTICAL,
                true, // hiển thị legend
                true, // hiển thị tooltips
                false // hiển thị URLs
        );

        // Tùy chỉnh biểu đồ
        CategoryPlot plot = chart.getCategoryPlot();
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setNumberFormatOverride(new DecimalFormat("#,###"));

        // chỉnh sửa các chữ nghiêng khi gặp các chữ dài
        CategoryAxis domainAxis = plot.getDomainAxis();
        for (String key : danhSachDoanhThu.keySet()) {
            if (key.length() > 7) { // Kiểm tra nếu tên dài hơn 15 ký tự
                domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
                break; // Chỉ cần một lần để xác định trạng thái
            } else {
                domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);
            }
        }


        BarRenderer renderer = new BarRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        plot.setRenderer(renderer);

        // Tạo ChartPanel và thêm vào JPanel
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new java.awt.Dimension(800, 400));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int option = JOptionPane.showConfirmDialog(
                        null,
                        "Bạn Có Muốn Xuất Hình Biểu Đồ Và Dữ Liệu Ra File Excel?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION
                );
                if (option == JOptionPane.YES_OPTION) {
                    try {
                        if(object == TrangChuaThongKeDoanhThuNhaGa.class){
                            TaoFileExcelDoanhThuNhaGaBieuDoCot taoFileExcelDoanhThuNhaGa = new TaoFileExcelDoanhThuNhaGaBieuDoCot();
                            String filePath = "ThongKe/DoanhThuNhaGa_BieuDoCot.xlsx";
                            taoFileExcelDoanhThuNhaGa.TaoFileExcelDoanhThuNhaGa(danhSachDoanhThu, getChartImage(), filePath);

                        }
                        else if(object == TrangChuaThongKeNhanVienTheoNam.class){
                            log.info("xuất file trang chứa thống kê nhân viên theo năm");
                            TaoFileExcelDoanhThuNhanVienTheoNam taoFileExcelDoanhThuNhanVienTheoNam = new TaoFileExcelDoanhThuNhanVienTheoNam();
                            String filePath = "ThongKe/DoanhThu_NhanVienTheoNam.xlsx";
                            taoFileExcelDoanhThuNhanVienTheoNam.TaoFileExcelDoanhThuNhanVienTheoNam(danhSachDoanhThu, getChartImage(), filePath);
                        }
                        else if(object == TrangChuaThongKeNhanVienTheoThang.class){
                            log.info("xuất file trang chứa thống kê nhân viên theo tháng");
                            String filePath = "ThongKe/DoanhThu_NhanVienTheoThang.xlsx";
                            TaoFileExcelDoanhThuNhanVienTheoThang taoFileExcelDoanhThuNhanVienTheoThang = new TaoFileExcelDoanhThuNhanVienTheoThang();
                            taoFileExcelDoanhThuNhanVienTheoThang.TaoFileExcelDoanhThuNhanVienTheoThang(danhSachDoanhThu, getChartImage(), filePath);

                        }
                        // Xuất file Excel
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
    }

    private DefaultCategoryDataset createDataset(Map<String, Double> danhSachDoanhThu) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String key : danhSachDoanhThu.keySet()) {
            Double value = danhSachDoanhThu.get(key);
            if (value != null) {
                dataset.addValue(value, "Doanh Thu", key);
            }
        }
        return dataset;
    }

    public byte[] getChartImage() throws IOException {
        BufferedImage bufferedImage = chart.createBufferedImage(800, 400);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);
        return baos.toByteArray();
    }
}
