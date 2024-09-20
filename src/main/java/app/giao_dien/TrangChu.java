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

<<<<<<< HEAD:src/main/java/app/giao_dien/TrangChu.java
import app.custom_component.RoundedBorder;
import app.init_font.PhongChuMoi;
=======
import app.Controller.Action_TrangChu;
import app.Controller.Action_TrangDangNhap;
import app.init_font.CustomFont;
import app.init_font.ShadowButton;
>>>>>>> ab244a938eef000bb1e9e3d6e79e7031c9455586:src/main/java/app/gui/TrangChu.java

// @important
// old Color: 161, 103, 37
// old OnClick Color: 196, 125, 44

public class TrangChu extends JFrame {
    public JPanel trangChua;
    public JButton nutTrangChu;
    public JButton nutVe;
    public JButton nutHoaDon;
    public JButton nutGioiThieu;
    public JButton nutKhachHang;
    public JButton nutThongKe;
    public JButton nutNhanVien;

<<<<<<< HEAD:src/main/java/app/giao_dien/TrangChu.java
    private Color white = new Color(255, 255, 255);
    private Color brandeisBlue = new Color(0, 112, 255);
    private Color lightBlue = new Color(66, 186, 255);
    private int charSize = 13;
    private int doCaoNut = 50;
    private int doRongNut = 160;
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();
    private Border vienNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(lightBlue.getRGB()));
    private Border vienDam = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(brandeisBlue.getRGB()));
=======
    public Color white = new Color(255, 255, 255);
    public Color brandeisBlue = new Color(0, 112, 255);
    public Color lightBlue = new Color(66, 186, 255);
    public int charSize = 14;
    public int doCaoNut = 50;
    public int doRongNut = 160;
    public CustomFont customFont = new CustomFont();
    public Border lightLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(lightBlue.getRGB()));
    public Border darkLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(brandeisBlue.getRGB()));
>>>>>>> ab244a938eef000bb1e9e3d6e79e7031c9455586:src/main/java/app/gui/TrangChu.java

    public ActionListener ac;
    public  MouseListener mouse;
    // Function tạo GUI chính
    public TrangChu() {
        ImageIcon icon = new ImageIcon("train_ticket_management_app/assets/icon.png"); // Cho vscode
        // ImageIcon icon = new ImageIcon("asset/icon.png"); // Cho eclipse, Intelj
        setTitle("Quản lý bán vé tại ga");
        setSize(new Dimension(1200, 700));

        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(true);
        setLayout(new BorderLayout());

<<<<<<< HEAD:src/main/java/app/giao_dien/TrangChu.java
        taoThanhDinhHuong();
        taoTrangChua();
=======
        this.ac = new Action_TrangChu(this);
        this.mouse = new Action_TrangChu(this);

        createNavBar();
        createContentPage();
>>>>>>> ab244a938eef000bb1e9e3d6e79e7031c9455586:src/main/java/app/gui/TrangChu.java
    }

    public void taoThanhDinhHuong() {
        JPanel thanhDinhHuong = new JPanel();
        thanhDinhHuong.setPreferredSize(new Dimension(1200, doCaoNut));
        thanhDinhHuong.setBackground(new Color(white.getRGB()));
        // thanhDinhHuong.setBackground(Color.RED);
        thanhDinhHuong.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        thanhDinhHuong.setBorder(this.vienDam);

        // Tạo Nút dẫn đến trang chủ
        nutTrangChu = new ShadowButton("Trang Chủ");
        nutTrangChu.setPreferredSize(new Dimension(doRongNut, doCaoNut));
<<<<<<< HEAD:src/main/java/app/giao_dien/TrangChu.java
        nutTrangChu.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutTrangChu.setForeground(new Color(brandeisBlue.getRGB()));
        nutTrangChu.setBackground(new Color(white.getRGB()));
        nutTrangChu.setBorder(this.vienDam);
        nutTrangChu.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutTrangChu.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutTrangChu.addMouseListener(this);
        nutTrangChu.addActionListener(this);
        thanhDinhHuong.add(nutTrangChu);
=======
        nutTrangChu.setFont(customFont.getRobotoMonoRegFont(Font.BOLD , charSize));
        nutTrangChu.setForeground(new Color(brandeisBlue.getRGB()));
        nutTrangChu.setBackground(new Color(white.getRGB()));
        nutTrangChu.setBorder(this.darkLineBorder);
        nutTrangChu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nutTrangChu.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutTrangChu.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutTrangChu.addMouseListener(mouse);
        nutTrangChu.addActionListener(ac);
        navBar.add(nutTrangChu);
>>>>>>> ab244a938eef000bb1e9e3d6e79e7031c9455586:src/main/java/app/gui/TrangChu.java

        // Tạo Nút đến trang bán hàng
        nutVe = new ShadowButton("Đặt Vé");
        nutVe.setPreferredSize(new Dimension(doRongNut, doCaoNut));
<<<<<<< HEAD:src/main/java/app/giao_dien/TrangChu.java
        nutVe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutVe.setForeground(new Color(brandeisBlue.getRGB()));
        nutVe.setBackground(new Color(white.getRGB()));
        nutVe.setBorder(this.vienDam);
        nutVe.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutVe.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutVe.addMouseListener(this);
        nutVe.addActionListener(this);
        thanhDinhHuong.add(nutVe);
=======
        nutVe.setFont(customFont.getRobotoMonoRegFont(Font.BOLD , charSize));
        nutVe.setForeground(new Color(brandeisBlue.getRGB()));
        nutVe.setBackground(new Color(white.getRGB()));
        nutVe.setBorder(this.darkLineBorder);
        nutVe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nutVe.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutVe.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutVe.addMouseListener(mouse);
        nutVe.addActionListener(ac);
        navBar.add(nutVe);
>>>>>>> ab244a938eef000bb1e9e3d6e79e7031c9455586:src/main/java/app/gui/TrangChu.java

        // Tạo Nút đến trang hóa đơn
        nutHoaDon = new ShadowButton("Hóa Đơn");
        nutHoaDon.setPreferredSize(new Dimension(doRongNut, doCaoNut));
<<<<<<< HEAD:src/main/java/app/giao_dien/TrangChu.java
        nutHoaDon.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutHoaDon.setForeground(new Color(brandeisBlue.getRGB()));
        nutHoaDon.setBackground(new Color(white.getRGB()));
        nutHoaDon.setBorder(this.vienDam);
        nutHoaDon.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutHoaDon.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutHoaDon.setEnabled(false);
        nutHoaDon.addMouseListener(this);
        thanhDinhHuong.add(nutHoaDon);
=======
        nutHoaDon.setFont(customFont.getRobotoMonoRegFont(Font.BOLD , charSize));
        nutHoaDon.setForeground(new Color(brandeisBlue.getRGB()));
        nutHoaDon.setBackground(new Color(white.getRGB()));
        nutHoaDon.setBorder(this.darkLineBorder);
        nutHoaDon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nutHoaDon.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutHoaDon.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutHoaDon.setEnabled(false);
        nutHoaDon.addMouseListener(mouse);
        navBar.add(nutHoaDon);
>>>>>>> ab244a938eef000bb1e9e3d6e79e7031c9455586:src/main/java/app/gui/TrangChu.java

        // Tạo Nút đến trang khách hàng
        nutKhachHang = new ShadowButton("Khuyến Mại");
        nutKhachHang.setPreferredSize(new Dimension(doRongNut, doCaoNut));
<<<<<<< HEAD:src/main/java/app/giao_dien/TrangChu.java
        nutKhachHang.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutKhachHang.setForeground(new Color(brandeisBlue.getRGB()));
        nutKhachHang.setBackground(new Color(white.getRGB()));
        nutKhachHang.setBorder(this.vienDam);
        nutKhachHang.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutKhachHang.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutKhachHang.addMouseListener(this);
        nutKhachHang.addActionListener(this);
        thanhDinhHuong.add(nutKhachHang);
=======
        nutKhachHang.setFont(customFont.getRobotoMonoRegFont(Font.BOLD , charSize));
        nutKhachHang.setForeground(new Color(brandeisBlue.getRGB()));
        nutKhachHang.setBackground(new Color(white.getRGB()));
        nutKhachHang.setBorder(this.darkLineBorder);
        nutKhachHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nutKhachHang.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutKhachHang.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutKhachHang.addMouseListener(mouse);
        nutKhachHang.addActionListener(ac);
        navBar.add(nutKhachHang);
>>>>>>> ab244a938eef000bb1e9e3d6e79e7031c9455586:src/main/java/app/gui/TrangChu.java

        // Tạo Nút đến trang thống kê
        nutThongKe = new ShadowButton("Thống Kê");
        nutThongKe.setPreferredSize(new Dimension(doRongNut, doCaoNut));
<<<<<<< HEAD:src/main/java/app/giao_dien/TrangChu.java
        nutThongKe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutThongKe.setForeground(new Color(brandeisBlue.getRGB()));
        nutThongKe.setBackground(new Color(white.getRGB()));
        nutThongKe.setBorder(this.vienDam);
        nutThongKe.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutThongKe.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutThongKe.addMouseListener(this);
        nutThongKe.addActionListener(this);
        thanhDinhHuong.add(nutThongKe);
=======
        nutThongKe.setFont(customFont.getRobotoMonoRegFont(Font.BOLD  , charSize));
        nutThongKe.setForeground(new Color(brandeisBlue.getRGB()));
        nutThongKe.setBackground(new Color(white.getRGB()));
        nutThongKe.setBorder(this.darkLineBorder);
        nutThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nutThongKe.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutThongKe.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutThongKe.addMouseListener(mouse);
        nutThongKe.addActionListener(ac);
        navBar.add(nutThongKe);
>>>>>>> ab244a938eef000bb1e9e3d6e79e7031c9455586:src/main/java/app/gui/TrangChu.java

        // Tạo Nút đến trang sản phẩm
        nutGioiThieu = new ShadowButton("Giới Thiệu");
        nutGioiThieu.setPreferredSize(new Dimension(doRongNut, doCaoNut));
<<<<<<< HEAD:src/main/java/app/giao_dien/TrangChu.java
        nutGioiThieu.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutGioiThieu.setForeground(new Color(brandeisBlue.getRGB()));
        nutGioiThieu.setBackground(new Color(white.getRGB()));
        nutGioiThieu.setBorder(vienDam);
        nutGioiThieu.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutGioiThieu.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutGioiThieu.addMouseListener(this);
        nutGioiThieu.addActionListener(this);
        thanhDinhHuong.add(nutGioiThieu);
=======
        nutGioiThieu.setFont(customFont.getRobotoMonoRegFont(Font.BOLD , charSize));
        nutGioiThieu.setForeground(new Color(brandeisBlue.getRGB()));
        nutGioiThieu.setBackground(new Color(white.getRGB()));
        nutGioiThieu.setBorder(this.darkLineBorder);
        nutGioiThieu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nutGioiThieu.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutGioiThieu.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutGioiThieu.addMouseListener(mouse);
        nutGioiThieu.addActionListener(ac);
        navBar.add(nutGioiThieu);
>>>>>>> ab244a938eef000bb1e9e3d6e79e7031c9455586:src/main/java/app/gui/TrangChu.java

        JPanel userPanel = new JPanel();
        userPanel.setPreferredSize(new Dimension(100, doCaoNut));
        userPanel.setBackground(new Color(white.getRGB()));
        userPanel.setBorder(this.vienDam);
        userPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 5));

        double doCaoTK = doCaoNut * 0.8;

        // Tạo Nút đến trang nhân viên
        nutNhanVien = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                String imagePath = "train_ticket_management_app/assets/icon.png"; // Cho vscode
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
        nutNhanVien.setForeground(new Color(brandeisBlue.getRGB()));
        nutNhanVien.setBackground(new Color(white.getRGB()));

        // Bỏ viền và focus của nút
        nutNhanVien.setBorderPainted(false); // Bỏ viền của nút
        nutNhanVien.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutNhanVien.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)

        nutNhanVien.addActionListener(ac);
        userPanel.add(nutNhanVien);

        thanhDinhHuong.add(userPanel);

        add(thanhDinhHuong, BorderLayout.NORTH);
    }

    public void taoTrangChua() {
        // Khởi tạo trang chứa
        this.trangChua = new JPanel();
        this.trangChua.setPreferredSize(new Dimension(200, 200));
        this.trangChua.setLayout(new CardLayout());
    }

<<<<<<< HEAD:src/main/java/app/giao_dien/TrangChu.java
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {

        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton enteredButton = (JButton) e.getComponent();
        enteredButton.setForeground(new Color(lightBlue.getRGB())); // Thay đổi màu khi hover
        enteredButton.setBorder(this.vienNhat);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton exitedButton = (JButton) e.getComponent();
        exitedButton.setForeground(new Color(brandeisBlue.getRGB())); // Khôi phục màu ban đầu khi di chuột ra khỏi nút
        exitedButton.setBorder(this.vienDam);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) trangChua.getLayout();
        String command = e.getActionCommand();

        switch (command) {
            case "Trang Chủ":
                cardLayout.show(trangChua, "Home Page");
                break;
            case "Bán Hàng":
                cardLayout.show(trangChua, "Trang Đặt Vé");
                break;
            case "Hóa Đơn":
                cardLayout.show(trangChua, "Trang Hóa Đơn");
                break;
            case "Sản Phẩm":
                cardLayout.show(trangChua, "Trang Khách Hàng");
                break;
            case "Khuyến Mại":
                cardLayout.show(trangChua, "Trang Thống Kê");
                break;
            case "Thống Kê":
                cardLayout.show(trangChua, "Trang Giới Thiệu");
                break;
            case "Nhân Viên":
                cardLayout.show(trangChua, "Employee Page");
                break;
        }
=======
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           TrangChu trangChu = new TrangChu();
            trangChu.setVisible(true);
        });
>>>>>>> ab244a938eef000bb1e9e3d6e79e7031c9455586:src/main/java/app/gui/TrangChu.java
    }
}
