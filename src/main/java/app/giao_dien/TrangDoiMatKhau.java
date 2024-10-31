package app.giao_dien;

import app.dao.NhanVien_DAO;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrangDoiMatKhau extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField passwordField_mkCu;
    private JPasswordField passwordField_mkMoi;
    private JPasswordField passwordField_xacNhanMK;
    public String mkCu;
    public String mkMoi;
    public String xacNhanMK;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TrangDoiMatKhau frame = new TrangDoiMatKhau();
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
    public TrangDoiMatKhau() {

        setTitle("Đổi mật khẩu");
        setSize(524, 660);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLabel lable_doiMK = new JLabel("Đổi mật khẩu");
        lable_doiMK.setHorizontalAlignment(SwingConstants.CENTER);
        lable_doiMK.setFont(new Font("Tahoma", Font.PLAIN, 30));
        contentPane.add(lable_doiMK, BorderLayout.NORTH);

        JPanel panel_doiMK = new JPanel();
        contentPane.add(panel_doiMK, BorderLayout.CENTER);
        panel_doiMK.setLayout(null);

        JPanel panel_nhapMK = new JPanel();
        panel_nhapMK.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_nhapMK.setBounds(10, 35, 479, 239);
        panel_doiMK.add(panel_nhapMK);
        panel_nhapMK.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nhập mật khẩu cũ:");
        lblNewLabel.setBounds(18, 15, 170, 25);
        panel_nhapMK.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        passwordField_mkCu = new JPasswordField();
        passwordField_mkCu.setBounds(235, 19, 231, 25);
        panel_nhapMK.add(passwordField_mkCu);

        JLabel label_nhapMKMoi = new JLabel("Nhập mật khẩu mới:");
        label_nhapMKMoi.setBounds(6, 104, 182, 25);
        panel_nhapMK.add(label_nhapMKMoi);
        label_nhapMKMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));

        passwordField_mkMoi = new JPasswordField();
        passwordField_mkMoi.setBounds(235, 108, 231, 25);
        panel_nhapMK.add(passwordField_mkMoi);

        JLabel label_xacNhanMK = new JLabel("Xác nhận mật khẩu:");
        label_xacNhanMK.setBounds(10, 195, 178, 25);
        panel_nhapMK.add(label_xacNhanMK);
        label_xacNhanMK.setFont(new Font("Tahoma", Font.PLAIN, 20));

        passwordField_xacNhanMK = new JPasswordField();
        passwordField_xacNhanMK.setBounds(235, 199, 231, 25);
        panel_nhapMK.add(passwordField_xacNhanMK);

        JButton btn_xacNhan = new JButton("Xác nhận");
        btn_xacNhan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_xacNhan.setBounds(348, 303, 115, 33);
        panel_doiMK.add(btn_xacNhan);

        btn_xacNhan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mkCu = new String(passwordField_mkCu.getPassword());
                mkCu.trim();
                mkMoi = new String(passwordField_mkMoi.getPassword());
                xacNhanMK = new String(passwordField_xacNhanMK.getPassword());
                System.out.printf(TrangDangNhap.tenDangNhap);
                if (mkCu.equals("") || mkMoi.equals("") || xacNhanMK.equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (!mkMoi.equals(xacNhanMK)) {
                    JOptionPane.showMessageDialog(null, "Mật khẩu mới không trùng khớp", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (!mkCu.equals(NhanVien_DAO.layMatKhau(TrangDangNhap.tenDangNhap))) {
                    JOptionPane.showMessageDialog(null, "Mật khẩu cũ không đúng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (NhanVien_DAO.doiMatKhau(mkMoi, TrangDangNhap.tenDangNhap)) {
                    JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Đổi mật khẩu thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

    }


}
