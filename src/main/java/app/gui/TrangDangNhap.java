package app.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import app.init_font.CustomFont;

public class TrangDangNhap extends JFrame {
    private JTextField nameField;
    private JTextField password;
    private CustomFont customFont = new CustomFont();

    public TrangDangNhap() {
        ImageIcon icon = new ImageIcon("train_ticket_management_app/assets/icon.png"); // For vscode
        setTitle("Đăng Nhập");
        setSize(new Dimension(750, 535));

        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setBackground(new Color(96, 69, 113));
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

        String imagePath = "train_ticket_management_app/assets/rua.png";

        // Create an ImageIcon from the original image
        ImageIcon imageIcon = new ImageIcon(imagePath);

        // Get the original image from the ImageIcon
        Image originalImage = imageIcon.getImage();

        // Scale the image to the desired size
        Image scaledImage = originalImage.getScaledInstance(238, 500, Image.SCALE_SMOOTH);

        // Create a new ImageIcon with the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Create a JLabel with the scaled image
        JLabel imageLabel = new JLabel(scaledIcon);

        // Add the imageLabel to the banner panel
        bannerE.add(imageLabel);
        return bannerE;
    }

    // Login Panel
    public JPanel createLoginPanel() {
        JPanel center = new JPanel();
        center.setBackground(new Color(255, 255, 255));
        center.setPreferredSize(new Dimension(550, 500));
        center.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel programLabel = new JLabel("Quản lý bán vé tại ga", SwingConstants.CENTER);
        programLabel.setForeground(new Color(0, 112, 255));
        programLabel.setPreferredSize(new Dimension(550, 100));
        programLabel.setFont(customFont.getRobotoMonoRegFont(20));
        center.add(programLabel);

        JLabel nameLabel = new JLabel("Tên: ");
        nameLabel.setForeground(new Color(0, 112, 255));
        nameLabel.setPreferredSize(new Dimension(150, 60));
        nameLabel.setFont(customFont.getRobotoMonoRegFont(12));
        center.add(nameLabel);

        nameField = new JTextField();
        nameField.setForeground(new Color(255, 255, 255));
        nameField.setBackground(new Color(0, 112, 255));
        nameField.setBorder(null);
        nameField.setPreferredSize(new Dimension(250, 50));
        nameField.setFont(customFont.getRobotoMonoRegFont(12));
        center.add(nameField);

        JLabel passLabel = new JLabel("Mật Khẩu: ");
        passLabel.setForeground(new Color(0, 112, 255));
        passLabel.setPreferredSize(new Dimension(150, 60));
        passLabel.setFont(customFont.getRobotoMonoRegFont(12));
        center.add(passLabel);

        password = new JTextField();
        password.setForeground(new Color(255, 255, 255));
        password.setBackground(new Color(0, 112, 255));
        password.setBorder(null);
        password.setPreferredSize(new Dimension(250, 50));
        password.setFont(customFont.getRobotoMonoRegFont(12));
        center.add(password);

        return center;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrangDangNhap loginPage = new TrangDangNhap();
            loginPage.setVisible(true);
        });
    }
}
