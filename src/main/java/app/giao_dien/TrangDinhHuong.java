package app.giao_dien;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import app.phan_tu_tuy_chinh.*;
import app.phong_chu_moi.*;
import app.dieu_khien.*;

// @important
// Brandeis Blue: 0, 112, 255
// Light Blue: 66, 186, 255
// White: 255, 255, 255

public class TrangDinhHuong extends JFrame {
    /* Khởi tạo */
    public JPanel trangChua;
    public JButton nutTrangChu;
    public JButton nutVe;
    public JButton nutHoaDon;
    public JButton nutGioiThieu;
    public JButton nutKhachHang;
    public JButton nutThongKe;
    public JButton nutNhanVien;

    /* Các trang được khởi tạo */
    public TrangChu trangChu;

    /* Khởi tạo phông chữ màu sắc */
    private Color trang = new Color(255, 255, 255);
    private Color xanhBrandeis = new Color(0, 112, 255);
    private Color xanhNhat = new Color(66, 186, 255);
    private int charSize = 13;
    private int chieuDaiNut = 160;
    private int chieuRongNut = 50;
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();
    private Border vienNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(xanhNhat.getRGB()));
    private Border vienDam = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(xanhBrandeis.getRGB()));

    public ActionListener hanhDong;
    public MouseListener thaoTacChuot;

    // Function tạo GUI chính
    public TrangDinhHuong() {
        ImageIcon icon = new ImageIcon("assets/icon.png"); // Cho vscode
        // ImageIcon icon = new ImageIcon("asset/icon.png"); // Cho eclipse, Intelj
        setTitle("Quản lý bán vé tại ga");
        setSize(new Dimension(1200, 700));

        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(true);
        setLayout(new BorderLayout());

        taoThanhDinhHuong();
        taoTrangChua();

        // this.hanhDong = new HanhDong_TrangChu(this);
        // this.thaoTacChuot = new HanhDong_TrangChu(this);
    }

    public void taoThanhDinhHuong() {
        JPanel thanhDinhHuong = new JPanel();
        thanhDinhHuong.setPreferredSize(new Dimension(1200, chieuRongNut));
        thanhDinhHuong.setBackground(new Color(trang.getRGB()));
        // thanhDinhHuong.setBackground(Color.RED);
        thanhDinhHuong.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        thanhDinhHuong.setBorder(this.vienDam);

        // Tạo Nút dẫn đến trang chủ
        nutTrangChu = new BongCuaChu("Trang Chủ");
        nutTrangChu.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        nutTrangChu.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutTrangChu.setForeground(new Color(xanhBrandeis.getRGB()));
        nutTrangChu.setBackground(new Color(trang.getRGB()));
        nutTrangChu.setBorder(this.vienDam);
        nutTrangChu.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutTrangChu.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutTrangChu.addMouseListener(this.thaoTacChuot);
        nutTrangChu.addActionListener(this.hanhDong);
        thanhDinhHuong.add(nutTrangChu);

        // Tạo Nút đến trang bán hàng
        nutVe = new BongCuaChu("Đặt Vé");
        nutVe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        nutVe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutVe.setForeground(new Color(xanhBrandeis.getRGB()));
        nutVe.setBackground(new Color(trang.getRGB()));
        nutVe.setBorder(this.vienDam);
        nutVe.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutVe.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutVe.addMouseListener(this.thaoTacChuot);
        nutVe.addActionListener(this.hanhDong);
        thanhDinhHuong.add(nutVe);

        // Tạo Nút đến trang hóa đơn
        nutHoaDon = new BongCuaChu("Hóa Đơn");
        nutHoaDon.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        nutHoaDon.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutHoaDon.setForeground(new Color(xanhBrandeis.getRGB()));
        nutHoaDon.setBackground(new Color(trang.getRGB()));
        nutHoaDon.setBorder(this.vienDam);
        nutHoaDon.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutHoaDon.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutHoaDon.setEnabled(false);
        nutHoaDon.addMouseListener(this.thaoTacChuot);
        nutHoaDon.addActionListener(this.hanhDong);
        thanhDinhHuong.add(nutHoaDon);

        // Tạo Nút đến trang khách hàng
        nutKhachHang = new BongCuaChu("Khuyến Mại");
        nutKhachHang.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        nutKhachHang.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutKhachHang.setForeground(new Color(xanhBrandeis.getRGB()));
        nutKhachHang.setBackground(new Color(trang.getRGB()));
        nutKhachHang.setBorder(this.vienDam);
        nutKhachHang.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutKhachHang.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutKhachHang.addMouseListener(this.thaoTacChuot);
        nutKhachHang.addActionListener(this.hanhDong);
        thanhDinhHuong.add(nutKhachHang);

        // Tạo Nút đến trang thống kê
        nutThongKe = new BongCuaChu("Thống Kê");
        nutThongKe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        nutThongKe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutThongKe.setForeground(new Color(xanhBrandeis.getRGB()));
        nutThongKe.setBackground(new Color(trang.getRGB()));
        nutThongKe.setBorder(this.vienDam);
        nutThongKe.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutThongKe.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutThongKe.addMouseListener(this.thaoTacChuot);
        nutThongKe.addActionListener(this.hanhDong);
        thanhDinhHuong.add(nutThongKe);

        // Tạo Nút đến trang sản phẩm
        nutGioiThieu = new BongCuaChu("Giới Thiệu");
        nutGioiThieu.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        nutGioiThieu.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutGioiThieu.setForeground(new Color(xanhBrandeis.getRGB()));
        nutGioiThieu.setBackground(new Color(trang.getRGB()));
        nutGioiThieu.setBorder(vienDam);
        nutGioiThieu.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutGioiThieu.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutGioiThieu.addMouseListener(this.thaoTacChuot);
        nutGioiThieu.addActionListener(this.hanhDong);
        thanhDinhHuong.add(nutGioiThieu);

        // Tạo Trang người dùng
        JPanel thanhNguoiDung = new JPanel();
        thanhNguoiDung.setPreferredSize(new Dimension(1200, chieuRongNut));
        thanhNguoiDung.setBackground(new Color(trang.getRGB()));
        thanhNguoiDung.setBorder(this.vienDam);
        thanhNguoiDung.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 5));

        double doCaoTK = chieuRongNut * 0.8;

        // Tạo Nút đến trang nhân viên
        nutNhanVien = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                String imagePath = "assets/icon.png"; // Cho vscode
                // String imagePath = "assets/icon.png"; // Cho intelJ, eclipse

                File imageFile = new File(imagePath);

                try {
                    Image avatar = ImageIO.read(imageFile);
                    double newWidth = doCaoTK; // Lấy độ rộng của nút
                    double newHeight = doCaoTK; // Lấy độ cao của nút
                    // Chỉnh kích thước ảnh phù hợp
                    avatar = avatar.getScaledInstance((int) newWidth, (int) newHeight, Image.SCALE_SMOOTH);

                    g.drawImage(avatar, 0, 0, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        nutNhanVien.setPreferredSize(new Dimension((int) doCaoTK, (int) doCaoTK));
        nutNhanVien.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        nutNhanVien.setForeground(new Color(xanhBrandeis.getRGB()));
        nutNhanVien.setBackground(new Color(trang.getRGB()));

        // Bỏ viền và focus của nút
        nutNhanVien.setBorderPainted(false); // Bỏ viền của nút
        nutNhanVien.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutNhanVien.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)

        nutNhanVien.addActionListener(this.hanhDong);
        thanhNguoiDung.add(nutNhanVien);

        thanhDinhHuong.add(thanhNguoiDung);

        add(thanhDinhHuong, BorderLayout.NORTH);
    }

    public void taoTrangChua() {
        // Khởi tạo trang chứa các trang khác
        this.trangChua = new JPanel();
        this.trangChua.setPreferredSize(new Dimension(1200, 600));
        this.trangChua.setBackground(Color.red);
        this.trangChua.setLayout(new BorderLayout());

        // Khởi tạo trang Trang chủ
        this.trangChu = new TrangChu();
        this.trangChua.add(trangChu, BorderLayout.CENTER);

        add(this.trangChua);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrangDinhHuong trangDinhHuong = new TrangDinhHuong();
            trangDinhHuong.setVisible(true);
        });
    }
}
