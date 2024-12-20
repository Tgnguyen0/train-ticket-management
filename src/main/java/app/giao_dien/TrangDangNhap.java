package app.giao_dien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.Border;

import app.dieu_khien.HanhDong_TrangDangNhap;
import app.phong_chu_moi.PhongChuMoi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrangDangNhap extends JFrame {
    public JTextField truongTen;
    public JPasswordField truongMatKhau;
    public JButton nutDangNhap;
    public JButton nutDangXuat;
    public JLabel nhanQuenMatKhau;
    public PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public boolean matKhauDung = false;
    public static String tenDangNhap;
    public Color trang = new Color(255, 255, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    public Border duongVien = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(xanhBrandeis.getRGB()));
    public Border duongVienPhai = BorderFactory.createMatteBorder(0, 0, 0, 5, new Color(xanhBrandeis.getRGB()));
    public static String username;
    /*
     * chứa các toàn bộ tham số hanhDongtion controller để xử lý actionlistener và
     * mouselistener
     */
    private ActionListener hanhDong;
    private MouseListener thaoTacChuot;

    public TrangDangNhap() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/assets/icon.png"));
        setTitle("Đăng Nhập");
        setSize(new Dimension(750, 535));
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(trang.getRGB()));
        setLayout(new BorderLayout());

        // Thêm ActionListener và MouseListener cho các nút
        this.hanhDong = new HanhDong_TrangDangNhap(this);
        this.thaoTacChuot = new HanhDong_TrangDangNhap(this);

        createLoginPanel();
        createBannerPanel();
    }

    // Banner Panel
    public void createBannerPanel() {
        JPanel bieuNgu = new JPanel();
        bieuNgu.setOpaque(false);
        bieuNgu.setPreferredSize(new Dimension(238, 500));
        bieuNgu.setLayout(new BoxLayout(bieuNgu, BoxLayout.Y_AXIS));

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/assets/rua.png"));
        Image originalImage = imageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(238, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        bieuNgu.add(imageLabel);
        add(bieuNgu, BorderLayout.EAST);
    }

    // Login Panel
    public void createLoginPanel() {
        JPanel giua = new JPanel();
        giua.setBackground(new Color(trang.getRGB()));
        giua.setPreferredSize(new Dimension(550, 500));
        giua.setLayout(new FlowLayout(FlowLayout.CENTER));
        giua.setBorder(duongVienPhai);

        JPanel cachDong1 = new JPanel();
        cachDong1.setPreferredSize(new Dimension(550, 50));
        cachDong1.setOpaque(false);
        giua.add(cachDong1);

        // Tạo tiêu đề tieuDeChuongTrinh
        JLabel tieuDeChuongTrinh = new JLabel("Quản lý bán vé tại ga", SwingConstants.CENTER);
        tieuDeChuongTrinh.setForeground(new Color(xanhBrandeis.getRGB()));
        tieuDeChuongTrinh.setPreferredSize(new Dimension(550, 100));
        tieuDeChuongTrinh.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 20));
        giua.add(tieuDeChuongTrinh);

        // Tạo tiêu đề tieuDeTen
        JLabel tieuDeTen = new JLabel("Tên Đăng Nhập: ");
        tieuDeTen.setForeground(new Color(xanhBrandeis.getRGB()));
        tieuDeTen.setPreferredSize(new Dimension(150, 30));
        tieuDeTen.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        giua.add(tieuDeTen);

        // Tạo thanh tên người dùng truongTen
        truongTen = new JTextField();
        truongTen.setForeground(new Color(xanhBrandeis.getRGB()));
        truongTen.setBackground(new Color(trang.getRGB()));
        truongTen.setPreferredSize(new Dimension(250, 30));
        truongTen.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        truongTen.setBorder(duongVien);
        giua.add(truongTen);

        // Cách dòng hoàn chỉnh
        JPanel cachDong2 = new JPanel();
        cachDong2.setPreferredSize(new Dimension(550, 10));
        cachDong2.setOpaque(false);
        giua.add(cachDong2);

        // Tạo tiêu đề passLabel
        JLabel passLabel = new JLabel("Mật Khẩu: ");
        passLabel.setForeground(new Color(xanhBrandeis.getRGB()));
        passLabel.setPreferredSize(new Dimension(150, 30));
        passLabel.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        giua.add(passLabel);

        // Tạo thanh mật khẩu truongMatKhau
        truongMatKhau = new JPasswordField();
        truongMatKhau.setForeground(new Color(xanhBrandeis.getRGB()));
        truongMatKhau.setBackground(new Color(trang.getRGB()));
        truongMatKhau.setPreferredSize(new Dimension(250, 31));
        truongMatKhau.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        truongMatKhau.setBorder(duongVien);
        giua.add(truongMatKhau);
        truongMatKhau.addActionListener(hanhDong);
        
        // Cách dòng hoàn chỉnh
        JPanel cachDong3 = new JPanel();
        cachDong3.setPreferredSize(new Dimension(550, 15));
        cachDong3.setOpaque(false);
        giua.add(cachDong3);

        // Tạo nút nutDangNhap
        nutDangNhap = new JButton("Đăng Nhập");
        nutDangNhap.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        nutDangNhap.setPreferredSize(new Dimension(100, 30));
        nutDangNhap.setForeground(new Color(trang.getRGB()));
        nutDangNhap.setBackground(new Color(xanhBrandeis.getRGB()));
        nutDangNhap.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutDangNhap.setBorderPainted(false); // Bỏ viền của nút
        nutDangNhap.addActionListener(hanhDong);
        nutDangNhap.addMouseListener(thaoTacChuot);

        KeyStroke toHopPhim = KeyStroke.getKeyStroke("enter");
        InputMap inputMap = nutDangNhap.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = nutDangNhap.getActionMap();

        inputMap.put(toHopPhim, "clickButton");
        actionMap.put("clickButton", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        giua.add(nutDangNhap);

        // Tạo nút nutDangXuat
        nutDangXuat = new JButton("Thoát");
        nutDangXuat.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        nutDangXuat.setPreferredSize(new Dimension(100, 30));
        nutDangXuat.setForeground(new Color(trang.getRGB()));
        nutDangXuat.setBackground(new Color(xanhBrandeis.getRGB()));
        nutDangXuat.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutDangXuat.setBorderPainted(false); // Bỏ viền của nút
        nutDangXuat.addActionListener(hanhDong);
        nutDangXuat.addMouseListener(thaoTacChuot);
        giua.add(nutDangXuat);

        // Cách dòng hoàn chỉnh
        JPanel cachDong4 = new JPanel();
        cachDong4.setPreferredSize(new Dimension(550, 20));
        cachDong4.setOpaque(false);
        giua.add(cachDong4);

        // Tạo tiêu đề nhanQuenMatKhau
        nhanQuenMatKhau = new JLabel("Quên Mật Khẩu ?", SwingConstants.CENTER);
        nhanQuenMatKhau.setForeground(new Color(xanhBrandeis.getRGB()));
        nhanQuenMatKhau.setPreferredSize(new Dimension(550, 30));
        nhanQuenMatKhau.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.ITALIC, 14));
        nhanQuenMatKhau.addMouseListener(thaoTacChuot);
        giua.add(nhanQuenMatKhau);

        add(giua, BorderLayout.CENTER);
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

        SwingUtilities.invokeLater(() -> {
            TrangDangNhap trangDangNhap = new TrangDangNhap();
            trangDangNhap.setVisible(true);

        });
    }
}