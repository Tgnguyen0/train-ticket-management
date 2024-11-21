package app.giao_dien;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import app.phan_tu_tuy_chinh.*;
import app.phong_chu_moi.*;
import app.dieu_khien.*;

// @important
// Brandeis Blue: 0, 112, 255
// Light Blue: 66, 186, 255
// White: 255, 255, 255

public class TrangDinhHuong extends JFrame {
    /* Khởi tạo */
    public static JPanel trangChua;
    public JButton nutTrangChu;
    public JButton nutVe;
    public JButton nutHoaDon;
    public JButton nutGioiThieu;
    public JButton nutKhachHang;
    public JButton nutThongKe;
    public JButton nutNhanVien;

    /* Các trang được khởi tạo */
    public TrangChu trangChu;
    public TrangDatVe trangDatVe;
    public TrangHoaDon trangHoaDon;
    public TrangGioiThieu trangGioiThieu;
    public TrangKhachHang trangKhachHang;
    public TrangChuaThongKeNhanVienTheoNam trangChuaThongKeTheoNam;
    public TrangNhanVien trangNhanVien;
    public TrangChuaThongKeNhanVienTheoThang trangChuaThongKeNhanVienTheoThang;
    public TrangChuaThongKeDoanhThuNhaGa trangChuaThongKeDoanhThuNhaGa;
    public TrangChuaThongKeNhanVienTheoNam trangChuaThongKeNhanVienTheoNam;
    /* Khởi tạo phông chữ màu sắc */
    public Color trang = new Color(255, 255, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public int charSize = 13;
    public int chieuDaiNut = 160;
    public int chieuRongNut = 50;
    public Border vienNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(xanhNhat.getRGB()));
    public Border vienDam = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(xanhBrandeis.getRGB()));
    public Image anhDaiDien;

    private ActionListener hanhDong;
    private MouseListener thaoTacChuot;

    // Function tạo GUI chính
    public TrangDinhHuong() {
        ImageIcon icon = new ImageIcon("assets/icon.png");
        setTitle("Quản lý bán vé tại ga");
        //setSize(new Dimension(1200, 800));
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            File imageFile = new File("assets/icon.png");
            anhDaiDien = ImageIO.read(imageFile);
            anhDaiDien = anhDaiDien.getScaledInstance((int) chieuDaiNut, (int) chieuRongNut, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        setResizable(true);
        setLayout(new BorderLayout());

        // SET GIAO DIỆN TRỰC TIẾP KHÔNG QUA MAIN
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());

                    // Cấu hình thuộc tính Nimbus
                    UIManager.put("control", new javax.swing.plaf.ColorUIResource(255, 255, 255)); // Màu nền
                    UIManager.put("nimbusBase", new javax.swing.plaf.ColorUIResource(255, 255, 255)); // Màu cơ bản
                    UIManager.put("nimbusBorder", new javax.swing.plaf.ColorUIResource(0, 112, 255)); // Màu viền
                    UIManager.put("nimbusLightBackground", new javax.swing.plaf.ColorUIResource(255, 255, 255)); // Màu nền sáng
                    UIManager.put("nimbusFocus", new javax.swing.plaf.ColorUIResource(0, 112, 255)); // Màu focus
                    UIManager.put("textForeground", new Color(0, 112, 255)); // Màu chữ
                    UIManager.put("ComboBox.foreground", new Color(0, 112, 255)); // Màu chữ cho JComboBox
                    UIManager.put("ComboBox.background", new Color(255, 255, 255));
                    UIManager.put("JCalendar.border", new Color(255, 255, 255));

                    // Đặt màu nền và màu chữ khi chọn cho JTextField
                    UIManager.put("TextField.selectionBackground", new Color(0, 112, 255)); // Màu nền khi chọn
                    UIManager.put("TextField.selectionForeground", new Color(255, 255, 255)); // Màu chữ khi chọncho JComboBox

                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        // Thêm ActionListener và MouseListener cho các nút
        this.hanhDong = new HanhDong_TrangDinhHuong(this);
        this.thaoTacChuot = new HanhDong_TrangDinhHuong(this);

        taoThanhDinhHuong();
        taoTrangChua();
    }

    public void taoThanhDinhHuong() {
        JPanel thanhDinhHuong = new JPanel();
        thanhDinhHuong.setPreferredSize(new Dimension(1200, chieuRongNut));
        thanhDinhHuong.setBackground(new Color(trang.getRGB()));
        thanhDinhHuong.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
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
        //nutHoaDon.setEnabled(false);
        nutHoaDon.addMouseListener(this.thaoTacChuot);
        nutHoaDon.addActionListener(this.hanhDong);
        thanhDinhHuong.add(nutHoaDon);

        // Tạo Nút đến trang khách hàng
        nutKhachHang = new BongCuaChu("Khách Hàng");
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
        nutThongKe.setForeground(xanhBrandeis);
        nutThongKe.setBackground(trang);
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

        //Tạo nut đến trang nhân viên
        nutNhanVien = new BongCuaChu("Nhân Viên");
        nutNhanVien.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        nutNhanVien.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutNhanVien.setForeground(new Color(xanhBrandeis.getRGB()));
        nutNhanVien.setBackground(new Color(trang.getRGB()));
        nutNhanVien.setBorder(this.vienDam);
        nutNhanVien.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutNhanVien.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutNhanVien.addMouseListener(this.thaoTacChuot);
        nutNhanVien.addActionListener(this.hanhDong);
        thanhDinhHuong.add(nutNhanVien);

        // Tạo Trang người dùng
        JPanel thanhNguoiDung = new JPanel();
        thanhNguoiDung.setPreferredSize(new Dimension(550, chieuRongNut));
        thanhNguoiDung.setBackground(trang);
        thanhNguoiDung.setBorder(this.vienDam);
        thanhNguoiDung.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 5));

        double doCaoTK = chieuRongNut * 0.8;

        thanhDinhHuong.add(thanhNguoiDung);

        add(thanhDinhHuong, BorderLayout.NORTH);
    }

    public void taoTrangChua() {
        // Khởi tạo trang chứa các trang khác
        this.trangChua = new JPanel();
        this.trangChua.setPreferredSize(new Dimension(1200, 600));
        this.trangChua.setLayout(new CardLayout());

        this.trangChu = new TrangChu(); // Khởi tạo trang Trang chủ
        this.trangDatVe = new TrangDatVe(); // Khởi tạo trang Trang Đặt Vé
        this.trangHoaDon = new TrangHoaDon(); // Khởi tạo trang Trang Hóa Đơn
        this.trangGioiThieu = new TrangGioiThieu(); // Khởi tạo trang Giới Thiệu
        this.trangKhachHang = new TrangKhachHang(); // Khởi tạo trang Trang Khách Hàng
        //this.trangChuaThongKeTheoNam = new TrangChuaThongKeNhanVienTheoNam();
        this.trangNhanVien = new TrangNhanVien(); // Khởi tạo trang Trang Nhân Viên
        this.trangChuaThongKeNhanVienTheoThang = new TrangChuaThongKeNhanVienTheoThang(this);
        this.trangChuaThongKeDoanhThuNhaGa = new TrangChuaThongKeDoanhThuNhaGa(this);
        this.trangChuaThongKeNhanVienTheoNam = new TrangChuaThongKeNhanVienTheoNam( this);
        // kiểm tra trang thống kê
        this.trangChua.add(trangChu, "Trang Chu");
        this.trangChua.add(trangDatVe, "Trang Dat Ve");
        this.trangChua.add(trangHoaDon,"Trang Hoa Don");
        this.trangChua.add(trangGioiThieu,"Trang Gioi Thieu");
        this.trangChua.add(trangKhachHang, "Trang Khach Hang");
        this.trangChua.add(trangChuaThongKeDoanhThuNhaGa, "Trang Thong Ke");
        this.trangChua.add(trangChuaThongKeNhanVienTheoThang, "ThongKeDoanhThuTheoThang");
        this.trangChua.add(trangChuaThongKeNhanVienTheoNam, "ThongKeDoanhThuTheoNam");
        this.trangChua.add(trangNhanVien, "Trang Nhan Vien");

        add(this.trangChua);
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());

                    // Cấu hình thuộc tính Nimbus
                    UIManager.put("control", new javax.swing.plaf.ColorUIResource(255, 255, 255)); // Màu nền
                    UIManager.put("nimbusBase", new javax.swing.plaf.ColorUIResource(255, 255, 255)); // Màu cơ bản
                    UIManager.put("nimbusBorder", new javax.swing.plaf.ColorUIResource(0, 112, 255)); // Màu viền
                    UIManager.put("nimbusLightBackground", new javax.swing.plaf.ColorUIResource(255, 255, 255)); // Màu nền sáng
                    UIManager.put("nimbusFocus", new javax.swing.plaf.ColorUIResource(0, 112, 255)); // Màu focus
                    UIManager.put("textForeground", new Color(0, 112, 255)); // Màu chữ
                    UIManager.put("ComboBox.foreground", new Color(0, 112, 255)); // Màu chữ cho JComboBox
                    UIManager.put("ComboBox.background", new Color(255, 255, 255));
                    UIManager.put("JCalendar.border", new Color(255, 255, 255));

                    // Đặt màu nền và màu chữ khi chọn cho JTextField
                    UIManager.put("TextField.selectionBackground", new Color(0, 112, 255)); // Màu nền khi chọn
                    UIManager.put("TextField.selectionForeground", new Color(255, 255, 255)); // Màu chữ khi chọncho JComboBox
                    
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Sau đó, khởi chạy giao diện của bạn
        java.awt.EventQueue.invokeLater(() -> {
            TrangDinhHuong trangDinhHuong = new TrangDinhHuong();
            trangDinhHuong.setVisible(true);
        });
    }

    public static JPanel getTrangChua() {
        return trangChua;
    }
}
