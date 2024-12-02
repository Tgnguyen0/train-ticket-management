package app.giao_dien;

import app.dao.NhanVien_DAO;
import app.dieu_khien.HanhDong_TrangDangNhap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TrangXacNhanThuHoiTaiKhoan extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField passwordField;
    public static int ketQuaXacNhan ;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TrangXacNhanThuHoiTaiKhoan frame = new TrangXacNhanThuHoiTaiKhoan();
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
    public TrangXacNhanThuHoiTaiKhoan() {
        setBounds(100, 100, 524, 455);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLabel lable_xacNhanThuHoi = new JLabel("Xác nhận thu hồi tài khoản");
        lable_xacNhanThuHoi.setHorizontalAlignment(SwingConstants.CENTER);
        lable_xacNhanThuHoi.setFont(new Font("Tahoma", Font.PLAIN, 30));
        contentPane.add(lable_xacNhanThuHoi, BorderLayout.NORTH);

        JPanel panel_doiMK = new JPanel();
        contentPane.add(panel_doiMK, BorderLayout.CENTER);
        panel_doiMK.setLayout(null);

        JPanel panel_nhapMK = new JPanel();
        panel_nhapMK.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_nhapMK.setBounds(10, 35, 479, 239);
        panel_doiMK.add(panel_nhapMK);
        panel_nhapMK.setLayout(null);

        JLabel label_nhapMatKhau = new JLabel("Nhập mật khẩu của bạn:");
        label_nhapMatKhau.setBounds(10, 61, 219, 25);
        panel_nhapMK.add(label_nhapMatKhau);
        label_nhapMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));

        passwordField = new JPasswordField();
        passwordField.setBounds(10, 96, 459, 25);
        panel_nhapMK.add(passwordField);

        JButton btn_xacNhan = new JButton("Xác nhận");
        btn_xacNhan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_xacNhan.setBounds(348, 303, 115, 33);
        panel_doiMK.add(btn_xacNhan);

        //-----------------------------------------ADD ACTION LISTENER-----------------------------------------
        btn_xacNhan.addActionListener(e -> {
            this.xacNhan();
        });
    }

    private void xacNhan() {
        String maNV = HanhDong_TrangDangNhap.maNV;
        String matKhau = String.valueOf(passwordField.getPassword());
        if(matKhau.equals(NhanVien_DAO.layMatKhau(maNV))){
            JOptionPane.showMessageDialog(this, "Xác nhận thành công");
            if(NhanVien_DAO.thuHoiTaiKhoan(TrangQuanLyNhanVien.label_hienThiMaNV.getText()) > 0){
                JOptionPane.showMessageDialog(this, "Thu hồi tài khoản thành công");
                this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(this, "Thu hồi tài khoản thất bại");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Xác nhận thất bại");
        }
    }

}
