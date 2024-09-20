package app.gui;

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

import app.Controller.Action_TrangChu;
import app.Controller.Action_TrangDangNhap;
import app.init_font.CustomFont;
import app.init_font.ShadowButton;

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

    public Color white = new Color(255, 255, 255);
    public Color brandeisBlue = new Color(0, 112, 255);
    public Color lightBlue = new Color(66, 186, 255);
    public int charSize = 14;
    public int doCaoNut = 50;
    public int doRongNut = 160;
    public CustomFont customFont = new CustomFont();
    public Border lightLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(lightBlue.getRGB()));
    public Border darkLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(brandeisBlue.getRGB()));

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

        this.ac = new Action_TrangChu(this);
        this.mouse = new Action_TrangChu(this);

        createNavBar();
        createContentPage();
    }

    public void createNavBar() {
        JPanel navBar = new JPanel();
        navBar.setPreferredSize(new Dimension(1200, doCaoNut));
        navBar.setBackground(new Color(white.getRGB()));
        // navBar.setBackground(Color.RED);
        navBar.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        navBar.setBorder(this.darkLineBorder);

        // Tạo Nút dẫn đến trang chủ
        nutTrangChu = new ShadowButton("Trang chủ");
        nutTrangChu.setPreferredSize(new Dimension(doRongNut, doCaoNut));
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

        // Tạo Nút đến trang bán hàng
        nutVe = new ShadowButton("Đặt vé");
        nutVe.setPreferredSize(new Dimension(doRongNut, doCaoNut));
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

        // Tạo Nút đến trang hóa đơn
        nutHoaDon = new ShadowButton("Hóa đơn");
        nutHoaDon.setPreferredSize(new Dimension(doRongNut, doCaoNut));
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

        // Tạo Nút đến trang khách hàng
        nutKhachHang = new ShadowButton("Khuyến mại");
        nutKhachHang.setPreferredSize(new Dimension(doRongNut, doCaoNut));
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

        // Tạo Nút đến trang thống kê
        nutThongKe = new ShadowButton("Thống kê");
        nutThongKe.setPreferredSize(new Dimension(doRongNut, doCaoNut));
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

        // Tạo Nút đến trang sản phẩm
        nutGioiThieu = new ShadowButton("Giới thiệu");
        nutGioiThieu.setPreferredSize(new Dimension(doRongNut, doCaoNut));
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

        JPanel userPanel = new JPanel();
        userPanel.setPreferredSize(new Dimension(100, doCaoNut));
        userPanel.setBackground(new Color(white.getRGB()));
        userPanel.setBorder(this.darkLineBorder);
        userPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 5));

        double doCaoTK = doCaoNut * 0.8;

        // Tạo Nút đến trang nhân viên
        nutNhanVien = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                //String imagePath = "train_ticket_management_app/assets/icon.png"; // Cho vscode
                String imagePath = "assets/icon.png"; // Cho intelJ, eclipse

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
        nutNhanVien.setFont(customFont.getRobotoMonoRegFont(Font.PLAIN, 12));
        nutNhanVien.setForeground(new Color(brandeisBlue.getRGB()));
        nutNhanVien.setBackground(new Color(white.getRGB()));

        // Bỏ viền và focus của nút
        nutNhanVien.setBorderPainted(false); // Bỏ viền của nút
        nutNhanVien.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutNhanVien.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)

        nutNhanVien.addActionListener(ac);
        userPanel.add(nutNhanVien);

        navBar.add(userPanel);

        add(navBar, BorderLayout.NORTH);
    }

    public void createContentPage() {
        // Khởi tạo trang chứa
        this.trangChua = new JPanel();
        this.trangChua.setPreferredSize(new Dimension(200, 200));
        this.trangChua.setLayout(new CardLayout());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           TrangChu trangChu = new TrangChu();
            trangChu.setVisible(true);
        });
    }
}
