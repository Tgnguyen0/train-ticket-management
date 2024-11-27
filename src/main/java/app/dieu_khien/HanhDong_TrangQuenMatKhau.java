package app.dieu_khien;

import app.dao.NhanVien_DAO;
import app.giao_dien.TrangDangNhap;
import app.giao_dien.TrangQuenMatKhau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HanhDong_TrangQuenMatKhau implements ActionListener, MouseListener {
    private TrangQuenMatKhau trangQuenMatKhau;

    public HanhDong_TrangQuenMatKhau(TrangQuenMatKhau trangQuenMatKhau) {
        this.trangQuenMatKhau = trangQuenMatKhau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Code here
        Object source = e.getSource();
        if(source == trangQuenMatKhau.btn_xacNhan) {
            String mkMoi = new String(trangQuenMatKhau.passwordField_mkMoi.getPassword());
            String xacNhanMK = new String(trangQuenMatKhau.passwordField_xacNhanMK.getPassword());
            if(mkMoi.equals("") || xacNhanMK.equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(mkMoi.equals(xacNhanMK)) {
                System.out.println(HanhDong_TrangOTP.maNV);
                NhanVien_DAO.doiMatKhau(mkMoi, HanhDong_TrangOTP.maNV);
                JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công", "Đổi mật khẩu", JOptionPane.INFORMATION_MESSAGE);
                trangQuenMatKhau.dispose();
                SwingUtilities.invokeLater(() -> {
                    TrangDangNhap trangDangNhap = new TrangDangNhap();
                    trangDangNhap.setVisible(true);
                });
            } else {
                JOptionPane.showMessageDialog(null, "Mật khẩu không khớp", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if(source == trangQuenMatKhau.btn_xacNhan) {
            trangQuenMatKhau.btn_xacNhan.setBackground(new Color( 0x0051D2));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        if(source == trangQuenMatKhau.btn_xacNhan) {
            trangQuenMatKhau.btn_xacNhan.setBackground(new Color( 0x0070FF));
        }
    }
}
