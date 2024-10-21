package app.phan_tu_tuy_chinh;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class NutAnh extends JButton {
    private Image anhMacDinh;
    private Image anhDangChon;
    private Image anhHienTai;
    private double doCao;
    private double doRong;
    private JLabel label;

    public NutAnh(String duongDanMacDinh, String duongDanDangChon, double doCao, double doRong, String textLabel) {
        this.doCao = doCao;
        this.doRong = doRong;
        this.label = new JLabel(textLabel);

        // Đặt layout là null để có thể đặt vị trí tùy chỉnh cho các thành phần
        this.setLayout(null);

        try {
            // Tải trước cả hai hình ảnh
            this.anhMacDinh = ImageIO.read(new File(duongDanMacDinh))
                    .getScaledInstance((int) doRong, (int) doCao, Image.SCALE_SMOOTH);
            this.anhDangChon = ImageIO.read(new File(duongDanDangChon))
                    .getScaledInstance((int) doRong, (int) doCao, Image.SCALE_SMOOTH);
            this.anhHienTai = this.anhMacDinh;
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Đặt kích thước và vị trí của label
        label.setBounds(0, (int)doCao - 20, (int)doRong, 20);  // Đặt label ở cuối nút
        label.setForeground(Color.WHITE);  // Màu chữ trắng để hiển thị rõ
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Thêm label vào nút
        this.add(label);
    }

    public NutAnh(String duongDanMacDinh, double doCao, double doRong, String textLabel) {
        this.doCao = doCao;
        this.doRong = doRong;
        this.label = new JLabel(textLabel);

        // Đặt layout là null để có thể đặt vị trí tùy chỉnh cho các thành phần
        this.setLayout(null);

        try {
            // Tải trước cả hai hình ảnh
            this.anhMacDinh = ImageIO.read(new File(duongDanMacDinh))
                    .getScaledInstance((int) doRong, (int) doCao, Image.SCALE_SMOOTH);
            this.anhHienTai = this.anhMacDinh;
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Đặt kích thước và vị trí của label
        label.setBounds(0, (int)doCao - 20, (int)doRong, 100);  // Đặt label ở cuối nút
        label.setForeground(Color.WHITE);  // Màu chữ trắng để hiển thị rõ
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Thêm label vào nút
        this.add(label);
    }

    public void datAnhDangChon() {
        this.anhHienTai = this.anhDangChon;
        repaint();
    }

    public void datAnhMacDinh() {
        this.anhHienTai = this.anhMacDinh;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(anhHienTai, 0, 0, null);
    }

    public void datTextLabel(String text) {
        this.label.setText(text);
    }
}
