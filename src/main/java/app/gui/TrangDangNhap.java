package app.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import app.init_font.CustomFont;

public class TrangDangNhap extends JFrame implements MouseListener, ActionListener {
    private JTextField nameField;
    private JPasswordField passwordField; // Changed to JPasswordField
    private JButton loginButton;
    private JButton logoutButton;
    private JLabel forgetPassLabel;
    private boolean isCorrect = false;
    private CustomFont customFont = new CustomFont();

    public TrangDangNhap() {
        //ImageIcon icon = new ImageIcon("train_ticket_management_app/assets/icon.png"); // For vscode
        ImageIcon icon = new ImageIcon("D:/PhamV.Hinh/HocKi1_2024-2025/PTUD/train_ticket_management_app/assets/icon.png"); // for eclipse, Intelj
        setTitle("Đăng Nhập");
        setSize(new Dimension(750, 535));
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(255, 255, 255));
        setLayout(new BorderLayout());

        add(createLoginPanel(), BorderLayout.CENTER);
        add(createBannerPanel(), BorderLayout.EAST);
    }

    // Banner Panel
    public JPanel createBannerPanel() {
        JPanel bannerE = new JPanel();
        bannerE.setOpaque(false);
        bannerE.setPreferredSize(new Dimension(238, 500));
        bannerE.setLayout(new BoxLayout(bannerE, BoxLayout.Y_AXIS));

        //String imagePath = "train_ticket_management_app/assets/rua.png";
        String imagePath = "assets/rua.png";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image originalImage = imageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(238, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        bannerE.add(imageLabel);
        return bannerE;
    }

    // Login Panel
    public JPanel createLoginPanel() {
        Border lineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 112, 255));
        Border rightLineBorder = BorderFactory.createMatteBorder(0, 0, 0, 5, new Color(0, 112, 255));

        JPanel center = new JPanel();
        center.setBackground(new Color(255, 255, 255));
        center.setPreferredSize(new Dimension(550, 500));
        center.setLayout(new FlowLayout(FlowLayout.CENTER));
        center.setBorder(rightLineBorder);

        JPanel emptyL1 = new JPanel();
        emptyL1.setPreferredSize(new Dimension(550, 50));
        emptyL1.setOpaque(false);
        center.add(emptyL1);

        JLabel programLabel = new JLabel("Quản lý bán vé tại ga", SwingConstants.CENTER);
        programLabel.setForeground(new Color(0, 112, 255));
        programLabel.setPreferredSize(new Dimension(550, 100));
        programLabel.setFont(customFont.getRobotoMonoRegFont(Font.BOLD, 20));
        center.add(programLabel);

        JLabel nameLabel = new JLabel("Tên Đăng Nhập: ");
        nameLabel.setForeground(new Color(0, 112, 255));
        nameLabel.setPreferredSize(new Dimension(150, 30));
        nameLabel.setFont(customFont.getRobotoMonoRegFont(Font.PLAIN, 12));
        center.add(nameLabel);

        nameField = new JTextField();
        nameField.setForeground(new Color(0, 112, 255));
        nameField.setBackground(new Color(255, 255, 255));
        nameField.setPreferredSize(new Dimension(250, 30));
        nameField.setFont(customFont.getRobotoMonoRegFont(Font.PLAIN, 12));
        nameField.setBorder(lineBorder);
        center.add(nameField);

        JPanel emptyL2 = new JPanel();
        emptyL2.setPreferredSize(new Dimension(550, 10));
        emptyL2.setOpaque(false);
        center.add(emptyL2);

        JLabel passLabel = new JLabel("Mật Khẩu: ");
        passLabel.setForeground(new Color(0, 112, 255));
        passLabel.setPreferredSize(new Dimension(150, 30));
        passLabel.setFont(customFont.getRobotoMonoRegFont(Font.PLAIN, 12));
        center.add(passLabel);

        passwordField = new JPasswordField(); // Changed to JPasswordField
        passwordField.setForeground(new Color(0, 112, 255));
        passwordField.setBackground(new Color(255, 255, 255));
        passwordField.setPreferredSize(new Dimension(250, 31));
        passwordField.setFont(customFont.getRobotoMonoRegFont(Font.PLAIN, 12));
        passwordField.setBorder(lineBorder);
        center.add(passwordField);

        JPanel emptyL3 = new JPanel();
        emptyL3.setPreferredSize(new Dimension(550, 15));
        emptyL3.setOpaque(false);
        center.add(emptyL3);

        loginButton = new JButton("Đăng Nhập");
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setBackground(new Color(0, 112, 255));
        loginButton.setFont(customFont.getRobotoMonoRegFont(Font.PLAIN, 12));
        loginButton.setPreferredSize(new Dimension(100, 30));
        loginButton.addMouseListener(this);
        loginButton.addActionListener(this);
        center.add(loginButton);

        logoutButton = new JButton("Thoát");
        logoutButton.setForeground(new Color(255, 255, 255));
        logoutButton.setBackground(new Color(0, 112, 255));
        logoutButton.setFont(customFont.getRobotoMonoRegFont(Font.PLAIN, 12));
        logoutButton.setPreferredSize(new Dimension(100, 30));
        logoutButton.addMouseListener(this);
        center.add(logoutButton);

        JPanel emptyL4 = new JPanel();
        emptyL4.setPreferredSize(new Dimension(550, 20));
        emptyL4.setOpaque(false);
        center.add(emptyL4);

        forgetPassLabel = new JLabel("Quên Mật Khẩu ?", SwingConstants.CENTER);
        forgetPassLabel.setForeground(new Color(0, 112, 255));
        forgetPassLabel.setPreferredSize(new Dimension(550, 30));
        forgetPassLabel.setFont(customFont.getRobotoMonoRegFont(Font.ITALIC, 14));
        forgetPassLabel.addMouseListener(this);
        center.add(forgetPassLabel);

        return center;
    }

    public Boolean successfulLogin() {
        return isCorrect;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrangDangNhap loginPage = new TrangDangNhap();
            loginPage.setVisible(true);
        });
    }

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
        Object source = e.getSource();

        if (source == loginButton) {
            loginButton.setBackground(new Color(66, 186, 255));
        }

        if (source == logoutButton) {
            logoutButton.setBackground(new Color(66, 186, 255));
        }

        if (source == forgetPassLabel) {
            forgetPassLabel.setForeground(new Color(66, 186, 255));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();

        if (source == loginButton) {
            loginButton.setBackground(new Color(0, 112, 255));
        }

        if (source == logoutButton) {
            logoutButton.setBackground(new Color(0, 112, 255));
        }

        if (source == forgetPassLabel) {
            forgetPassLabel.setForeground(new Color(0, 112, 255));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == loginButton) {
            String username = nameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("Admin") && password.equals("123")) {
                isCorrect = true;
                this.setVisible(false);
                TrangChu page = new TrangChu();
                page.setVisible(true);
            } else {
                isCorrect = false;
            }
        }

        if (source == logoutButton) {
            System.exit(0);
        }
    }
}