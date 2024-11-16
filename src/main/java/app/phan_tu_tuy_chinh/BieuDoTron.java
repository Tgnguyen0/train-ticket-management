package app.phan_tu_tuy_chinh;

import app.dao.HoaDon_DAO;
import app.thuc_the.HoaDon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BieuDoTron extends JPanel {
    // Mảng chứa các giá trị phần trăm cho các phần của biểu đồ
    private double[] values;
    private Color[] colors;

    public BieuDoTron(double[] values, Color[] colors, String month, String year, String soVe, String DoanhThu) {
        this.values = values;
        this.colors = colors;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int option = JOptionPane.showConfirmDialog(
                        null,
                        "Bạn Có Muốn Xuất Hình Biểu Đồ Và Dữ Liệu Ra File Excel?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION
                );
                if(option == JOptionPane.YES_OPTION){
                    ArrayList<HoaDon> danhSachHoaDon = HoaDon_DAO.danhSachHoaDonTrongThang_Nam(Integer.parseInt(year),Integer.parseInt(month));
                    TaoFileExcelDoanhThuNhaGaBieuDoTron taoFileExcelDoanhThuNhaGaBieuDoTron = new TaoFileExcelDoanhThuNhaGaBieuDoTron();
                    taoFileExcelDoanhThuNhaGaBieuDoTron.TaoFileExcelDoanhThuNhaGaBieuDoTron(month, year, soVe, DoanhThu, danhSachHoaDon, createImage());
                }
            }
        });
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
    public BufferedImage createImage() {
        int width = getWidth();
        int height = getHeight();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        paint(g2d);
        g2d.dispose();
        return bufferedImage;
    }
}
