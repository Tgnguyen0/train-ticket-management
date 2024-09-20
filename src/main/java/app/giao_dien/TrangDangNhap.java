package app.giao_dien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import app.dieu_khien.HanhDong_TrangDangNhap;
import app.init_font.PhongChuMoi;

public class TrangDangNhap extends JFrame {
    public JTextField truongTen;
    public JPasswordField truongMatKhau;
    public JButton nutDangNhap;
    public JButton nutDangXuat;
    public JLabel nhanQuenMatKhau;
    public PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public boolean matKhauDung = false;

    public Color trang = new Color(255, 255, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    public Border duongVien = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(xanhBrandeis.getRGB()));
    public Border duongVienPhai = BorderFactory.createMatteBorder(0, 0, 0, 5, new Color(xanhBrandeis.getRGB()));

    /*
     * chứa các toàn bộ tham số action controller để xử lý actionlistener và
     * mouselistener
     */
    private ActionListener ac;
    private MouseListener mouse;

    public TrangDangNhap() {
        ImageIcon icon = new ImageIcon("train_ticket_management_app/assets/icon.png"); // For vscode
        // ImageIcon icon = new ImageIcon("assets/icon.png"); // for eclipse, Intelj
        setTitle("Đăng Nhập");
        setSize(new Dimension(750, 535));
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(trang.getRGB()));
        setLayout(new BorderLayout());

        // add actionlistener và mouselistener cho các button
        this.ac = new HanhDong_TrangDangNhap(this);
        this.mouse = new HanhDong_TrangDangNhap(this);

        createLoginPanel();
        createBannerPanel();

    }

    // Banner Panel
    public void createBannerPanel() {
        JPanel bannerE = new JPanel();
        bannerE.setOpaque(false);
        bannerE.setPreferredSize(new Dimension(238, 500));
        bannerE.setLayout(new BoxLayout(bannerE, BoxLayout.Y_AXIS));

        String imagePath = "train_ticket_management_app/assets/rua.png"; // for vscode
        /* cho elipse, intelj */
        // String imagePath = "assets/rua.png";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image originalImage = imageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(238, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        bannerE.add(imageLabel);
        add(bannerE, BorderLayout.EAST);
    }

    // Login Panel
    public void createLoginPanel() {
        JPanel center = new JPanel();
        center.setBackground(new Color(trang.getRGB()));
        center.setPreferredSize(new Dimension(550, 500));
        center.setLayout(new FlowLayout(FlowLayout.CENTER));
        center.setBorder(duongVienPhai);

        JPanel emptyL1 = new JPanel();
        emptyL1.setPreferredSize(new Dimension(550, 50));
        emptyL1.setOpaque(false);
        center.add(emptyL1);

        // Tạo tiêu đề programLabel
        JLabel programLabel = new JLabel("Quản lý bán vé tại ga", SwingConstants.CENTER);
        programLabel.setForeground(new Color(xanhBrandeis.getRGB()));
        programLabel.setPreferredSize(new Dimension(550, 100));
        programLabel.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 20));
        center.add(programLabel);

        // Tạo tiêu đề nameLabel
        JLabel nameLabel = new JLabel("Tên Đăng Nhập: ");
        nameLabel.setForeground(new Color(xanhBrandeis.getRGB()));
        nameLabel.setPreferredSize(new Dimension(150, 30));
        nameLabel.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        center.add(nameLabel);

        // Tạo thanh tên ngườ dùng truongTen
        truongTen = new JTextField();
        truongTen.setForeground(new Color(xanhBrandeis.getRGB()));
        truongTen.setBackground(new Color(trang.getRGB()));
        truongTen.setPreferredSize(new Dimension(250, 30));
        truongTen.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        truongTen.setBorder(duongVien);
        center.add(truongTen);

        // Cách dòng hoàn chỉnh
        JPanel emptyL2 = new JPanel();
        emptyL2.setPreferredSize(new Dimension(550, 10));
        emptyL2.setOpaque(false);
        center.add(emptyL2);

        // Tạo tiêu đề passLabel
        JLabel passLabel = new JLabel("Mật Khẩu: ");
        passLabel.setForeground(new Color(xanhBrandeis.getRGB()));
        passLabel.setPreferredSize(new Dimension(150, 30));
        passLabel.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        center.add(passLabel);

        // Tạo thanh mật khẩu truongMatKhau
        truongMatKhau = new JPasswordField();
        truongMatKhau.setForeground(new Color(xanhBrandeis.getRGB()));
        truongMatKhau.setBackground(new Color(trang.getRGB()));
        truongMatKhau.setPreferredSize(new Dimension(250, 31));
        truongMatKhau.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        truongMatKhau.setBorder(duongVien);
        center.add(truongMatKhau);

        // Cách dòng hoàn chỉnh
        JPanel emptyL3 = new JPanel();
        emptyL3.setPreferredSize(new Dimension(550, 15));
        emptyL3.setOpaque(false);
        center.add(emptyL3);

        // Tạo nút nutDangNhap
        nutDangNhap = new JButton("Đăng Nhập");
        nutDangNhap.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        nutDangNhap.setPreferredSize(new Dimension(100, 30));
        nutDangNhap.setForeground(new Color(trang.getRGB()));
        nutDangNhap.setBackground(new Color(xanhBrandeis.getRGB()));
        nutDangNhap.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutDangNhap.setBorderPainted(false); // Bỏ viền của nút
        nutDangNhap.addActionListener(ac);
        nutDangNhap.addMouseListener(mouse);
        center.add(nutDangNhap);

        // Tạo nút nutDangXuat
        nutDangXuat = new JButton("Thoát");
        nutDangXuat.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        nutDangXuat.setPreferredSize(new Dimension(100, 30));
        nutDangXuat.setForeground(new Color(trang.getRGB()));
        nutDangXuat.setBackground(new Color(xanhBrandeis.getRGB()));
        nutDangXuat.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutDangXuat.setBorderPainted(false); // Bỏ viền của nút
        nutDangXuat.addActionListener(ac);
        nutDangXuat.addMouseListener(mouse);
        center.add(nutDangXuat);

        // Cách dòng hoàn chỉnh
        JPanel emptyL4 = new JPanel();
        emptyL4.setPreferredSize(new Dimension(550, 20));
        emptyL4.setOpaque(false);
        center.add(emptyL4);

        // Tạo tiêu đề nhanQuenMatKhau
        nhanQuenMatKhau = new JLabel("Quên Mật Khẩu ?", SwingConstants.CENTER);
        nhanQuenMatKhau.setForeground(new Color(xanhBrandeis.getRGB()));
        nhanQuenMatKhau.setPreferredSize(new Dimension(550, 30));
        nhanQuenMatKhau.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.ITALIC, 14));
        nhanQuenMatKhau.addMouseListener(mouse);
        center.add(nhanQuenMatKhau);

        add(center, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrangDangNhap loginPage = new TrangDangNhap();
            loginPage.setVisible(true);
        });
    }
}