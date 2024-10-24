package app.phan_tu_tuy_chinh;

import app.phong_chu_moi.PhongChuMoi;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class NutAnh extends JButton {
    private Image anhMacDinh;
    private Image anhDangChon;
    private Image anhHienTai;
    private double doDai;
    private double doRong;
    private JLabel label;
    private Color xanhBrandeis = new Color(0, 112, 255);
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();

    public NutAnh(String duongDanMacDinh, String duongDanDangChon, double doDai, double doRong, double viTriChu, String textLabel, int x) {
        this.doDai = doDai;
        this.doRong = doRong;
        this.label = new JLabel(textLabel);

        // Đặt layout là null để có thể đặt vị trí tùy chỉnh cho các thành phần
        this.setLayout(null);

        try {
            // Tải trước cả hai hình ảnh
            this.anhMacDinh = ImageIO.read(new File(duongDanMacDinh))
                    .getScaledInstance((int) doDai, (int) doRong, Image.SCALE_SMOOTH);
            this.anhDangChon = ImageIO.read(new File(duongDanDangChon))
                    .getScaledInstance((int) doDai, (int) doRong, Image.SCALE_SMOOTH);
            this.anhHienTai = this.anhMacDinh;
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Đặt kích thước và vị trí của label
        int labelHeight = 100; // Chiều cao của label (bạn có thể thay đổi nếu cần)
        int labelY = ((int) doDai - labelHeight) / 20; // Tính vị trí Y để label nằm ở giữa

        label.setBounds(x, labelY, (int) viTriChu, labelHeight); // Đặt label ở giữa nút
        label.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        label.setForeground(xanhBrandeis);  // Màu chữ trắng để hiển thị rõ
        label.setHorizontalAlignment(SwingConstants.LEFT); // Căn giữa theo chiều ngang

        // Thêm label vào nút
        this.add(label);
    }

    public NutAnh(String duongDanMacDinh, double doCao, double doRong, String textLabel) {
        this.doDai = doCao;
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
        label.setBounds(100, (int)doCao - 20, (int)doRong, 100);  // Đặt label ở cuối nút
        label.setForeground(xanhBrandeis);  // Màu chữ trắng để hiển thị rõ
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Thêm label vào nút
        this.add(label);
    }

    public void datViTriChu(int position) {
        label.setHorizontalAlignment(position);
    }

    public void datAnhDangChon() {
        this.anhHienTai = this.anhDangChon;
        revalidate();
        repaint();
    }

    public void datAnhMacDinh() {
        this.anhHienTai = this.anhMacDinh;
        revalidate();
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
