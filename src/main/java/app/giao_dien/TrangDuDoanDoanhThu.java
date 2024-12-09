package app.giao_dien;

import org.apache.commons.math3.stat.regression.SimpleRegression;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class TrangDuDoanDoanhThu {

    public static void thietLapDuDoanDoanhThu(Map<Integer, Double> doanhThuNhaGa) {
        int[] years = new int[doanhThuNhaGa.size()];
        double[] revenues = new double[doanhThuNhaGa.size()];
        // Dữ liệu doanh thu lịch sử
        int index = 0;
        for(Integer key: doanhThuNhaGa.keySet()){
            years[index] = key;
            revenues[index] = doanhThuNhaGa.get(key);
            System.out.println(years[index]+"");
            index += 1;
        }

        // Tạo mô hình hồi quy tuyến tính
        SimpleRegression regression = new SimpleRegression();
        for (int i = 0; i < years.length; i++) {
            regression.addData(years[i], revenues[i]);
        }

        // Dự đoán doanh thu năm tiếp theo (2023)
        int nextYear = years[index-1] + 1;
        double predictedRevenue = regression.predict(nextYear);

        // Hiển thị kết quả
        SwingUtilities.invokeLater(() -> createAndShowGUI(years, revenues, nextYear, predictedRevenue));
    }

    // Tạo giao diện hiển thị biểu đồ và kết quả
    private static void createAndShowGUI(int[] years, double[] revenues, int nextYear, double predictedRevenue) {
        JFrame frame = new JFrame("Dự đoán doanh thu nhà ga");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Define margin here
                final int margin = 50;
                int width = getWidth() - 2 * margin;
                int height = getHeight() - 2 * margin;

                Locale vietnamLocale = new Locale("vi", "VN");

                // Tạo đối tượng NumberFormat để định dạng tiền tệ
                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnamLocale);

                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Vẽ nền
                g2d.setColor(new Color(153, 204, 255));
                g2d.fillRect(margin, margin, width, height);

                // Vẽ lưới
                g2d.setColor(Color.LIGHT_GRAY);
                for (int i = 1; i <= 10; i++) {
                    int y = margin + i * (height / 10);
                    g2d.drawLine(margin, y, width + margin, y);
                }
                for (int i = 1; i <= 10; i++) {
                    int x = margin + i * (width / 10);
                    g2d.drawLine(x, margin, x, height + margin);
                }

                // Tìm min/max
                final int minYear = years[0];
                final int maxYear = nextYear;
                double maxRevenue = Math.max(predictedRevenue, getMax(revenues));

                // Vẽ trục và nhãn
                g2d.setColor(Color.BLACK);
                g2d.drawLine(margin, height + margin, width + margin, height + margin); // Trục X
                g2d.drawLine(margin, margin, margin, height + margin); // Trục Y
                g2d.drawString("Doanh thu (triệu VND)", width / 2, margin - 10);
                g2d.drawString("Năm", width + margin + 10, height + margin + 5);

                Font font = new Font("Arial", Font.BOLD, 14);
                g2d.setFont(font);

                // Vẽ doanh thu
                for (int i = 0; i < years.length; i++) {
                    int x = margin + (int) ((years[i] - minYear) / (double) (maxYear - minYear) * width);
                    int y = height + margin - (int) (revenues[i] / maxRevenue * height);
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(x - 5, y - 5, 10, 10);

                    g2d.drawString(String.valueOf(years[i]), x - 10, height + margin + 20);
                    // Hiển thị doanh thu ngay dưới nút
                    g2d.drawString(currencyFormatter.format(revenues[i]), x - 30, y + 20);
                }

                // Vẽ dự đoán
                int predX = margin + (int) ((nextYear - minYear) / (double) (maxYear - minYear) * width);
                int predY = height + margin - (int) (predictedRevenue / maxRevenue * height);
                g2d.setColor(Color.RED);
                g2d.fillOval(predX - 5, predY - 5, 10, 10);
                g2d.drawString(String.valueOf(nextYear), predX - 10, height + margin + 20);
                // Hiển thị doanh thu dự đoán ngay dưới nút
                g2d.drawString(currencyFormatter.format(predictedRevenue), predX - 30, predY + 20);

                // Kẻ đường nối
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(2));
                for (int i = 0; i < years.length - 1; i++) {
                    int x1 = margin + (int) ((years[i] - minYear) / (double) (maxYear - minYear) * width);
                    int y1 = height + margin - (int) (revenues[i] / maxRevenue * height);
                    int x2 = margin + (int) ((years[i + 1] - minYear) / (double) (maxYear - minYear) * width);
                    int y2 = height + margin - (int) (revenues[i + 1] / maxRevenue * height);
                    g2d.drawLine(x1, y1, x2, y2);
                }

                // Đường dự đoán
                g2d.drawLine(margin + (int) ((years[years.length - 1] - minYear) / (double) (maxYear - minYear) * width),
                        height + margin - (int) (revenues[years.length - 1] / maxRevenue * height), predX, predY);
            }
        };

        // Thêm sự kiện chuột
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                // Kiểm tra xem chuột đang nằm gần nút nào
                final int margin = 50;
                final int width = panel.getWidth() - 2 * margin;
                final int height = panel.getHeight() - 2 * margin;
                final int minYear = years[0];
                final int maxYear = nextYear;
                double maxRevenue = Math.max(predictedRevenue, getMax(revenues));
                for (int i = 0; i < years.length; i++) {
                    int x = margin + (int) ((years[i] - minYear) / (double) (maxYear - minYear) * width);
                    int y = height + margin - (int) (revenues[i] / maxRevenue * height);

                    if (Math.abs(mouseX - x) <= 10 && Math.abs(mouseY - y) <= 10) {
                        // Kiểm tra doanh thu tăng hoặc giảm so với năm trước
                        String note = "";
                        if (i > 0) { // Không có năm trước cho năm đầu tiên
                            if (revenues[i] < revenues[i - 1]) {
                                note = "⬇ Giảm so với năm trước";
                            } else if (revenues[i] > revenues[i - 1]) {
                                note = "⬆ Tăng so với năm trước";
                            } else {
                                note = "Không thay đổi";
                            }
                        }

                        // Hiển thị ghi chú tại vị trí chuột
                        panel.setToolTipText("Năm " + years[i] + ": " + String.format("%.2f", revenues[i]) + " triệu VND (" + note + ")");
                        return;
                    }
                }

                // Không hiển thị ghi chú nếu chuột không trỏ vào nút nào
                panel.setToolTipText(null);
            }
        });

        frame.add(panel);
        frame.setVisible(true);

        // Hiển thị thông báo kết quả
        JOptionPane.showMessageDialog(frame,
                "Dự đoán doanh thu năm " + nextYear + ": " + String.format("%.2f", predictedRevenue) + " triệu VND",
                "Kết quả dự đoán",
                JOptionPane.INFORMATION_MESSAGE);
    }


    private static double getMax(double[] array) {
        double max = array[0];
        for (double v : array) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

}
