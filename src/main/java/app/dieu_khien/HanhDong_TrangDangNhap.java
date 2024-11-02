package app.dieu_khien;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import app.dao.NhanVien_DAO;
import app.giao_dien.TrangDinhHuong;
import app.giao_dien.TrangDangNhap;

import javax.swing.*;

public class HanhDong_TrangDangNhap implements ActionListener, MouseListener {
    TrangDangNhap trangDangNhap;

    public HanhDong_TrangDangNhap(TrangDangNhap trangDangNhap) {
        this.trangDangNhap = trangDangNhap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == this.trangDangNhap.nutDangNhap) {
            String username = this.trangDangNhap.truongTen.getText();
            String password = new String(this.trangDangNhap.truongMatKhau.getPassword());
            if(NhanVien_DAO.login(username, password)) {
                this.trangDangNhap.setVisible(false);
                TrangDinhHuong trangDinhHuong = new TrangDinhHuong();
                trangDinhHuong.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this.trangDangNhap, "Sai tên đăng nhập hoặc mật khẩu", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (source == this.trangDangNhap.nutDangXuat) {
            System.exit(0);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();

        if (source == this.trangDangNhap.nutDangNhap) {
            this.trangDangNhap.nutDangNhap.setBackground(new Color(this.trangDangNhap.xanhNhat.getRGB()));
        }

        if (source == this.trangDangNhap.nutDangXuat) {
            this.trangDangNhap.nutDangXuat.setBackground(new Color(this.trangDangNhap.xanhNhat.getRGB()));
        }

        if (source == this.trangDangNhap.nhanQuenMatKhau) {
            this.trangDangNhap.nhanQuenMatKhau.setForeground(new Color(this.trangDangNhap.xanhNhat.getRGB()));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();

        if (source == this.trangDangNhap.nutDangNhap) {
            this.trangDangNhap.nutDangNhap.setBackground(new Color(this.trangDangNhap.xanhBrandeis.getRGB()));
        }

        if (source == this.trangDangNhap.nutDangXuat) {
            this.trangDangNhap.nutDangXuat.setBackground(new Color(this.trangDangNhap.xanhBrandeis.getRGB()));
        }

        if (source == this.trangDangNhap.nhanQuenMatKhau) {
            this.trangDangNhap.nhanQuenMatKhau.setForeground(new Color(this.trangDangNhap.xanhBrandeis.getRGB()));
        }
    }
}
