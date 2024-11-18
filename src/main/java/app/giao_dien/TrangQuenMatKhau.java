package app.giao_dien;

import app.dieu_khien.HanhDong_TrangQuenMatKhau;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TrangQuenMatKhau extends JFrame {

    private static final long serialVersionUID = 1L;
    public final JButton btn_xacNhan;
    private JPanel contentPane;
    public JPasswordField passwordField_mkMoi;
    public JPasswordField passwordField_xacNhanMK;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TrangQuenMatKhau frame = new TrangQuenMatKhau();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TrangQuenMatKhau() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(240, 248, 255)); // Light blue background

        setTitle("Đổi mật khẩu");
        setIconImage(Toolkit.getDefaultToolkit().getImage("assets/icon.png"));
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label_nhapMKMoi = new JLabel("Nhập mật khẩu mới:");
        label_nhapMKMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_nhapMKMoi.setForeground(new Color(0x0070FF)); // Blue text
        label_nhapMKMoi.setBounds(10, 10, 300, 25);
        contentPane.add(label_nhapMKMoi);

        passwordField_mkMoi = new JPasswordField();
        passwordField_mkMoi.setBounds(10, 45, 416, 30);
        passwordField_mkMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPane.add(passwordField_mkMoi);

        JLabel label_xacNhanMatKhauMoi = new JLabel("Xác nhận mật khẩu:");
        label_xacNhanMatKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_xacNhanMatKhauMoi.setForeground(new Color(0x0070FF)); // Blue text
        label_xacNhanMatKhauMoi.setBounds(10, 85, 300, 25);
        contentPane.add(label_xacNhanMatKhauMoi);

        passwordField_xacNhanMK = new JPasswordField();
        passwordField_xacNhanMK.setBounds(10, 120, 416, 30);
        passwordField_xacNhanMK.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPane.add(passwordField_xacNhanMK);

        btn_xacNhan = new JButton("Xác nhận");
        btn_xacNhan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_xacNhan.setForeground(Color.WHITE);
        btn_xacNhan.setBackground(new Color(0x0070FF)); // Blue background
        btn_xacNhan.setBounds(291, 180, 135, 33);
        btn_xacNhan.setBorderPainted(false); // Remove button border
        contentPane.add(btn_xacNhan);

        ActionListener hanhDong = new HanhDong_TrangQuenMatKhau(this);
        MouseListener thaoTacChuot = new HanhDong_TrangQuenMatKhau(this);
        btn_xacNhan.addActionListener(hanhDong);
        btn_xacNhan.addMouseListener(thaoTacChuot);
    }

}
