package app.dieu_khien;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import app.giao_dien.TrangDinhHuong;
import app.giao_dien.TrangDangNhap;

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

            if (username.equals("Admin") && password.equals("123")) {
                this.trangDangNhap.matKhauDung = true;
                this.trangDangNhap.setVisible(false);
                TrangDinhHuong page = new TrangDinhHuong();
                page.setVisible(true);
            } else {
                this.trangDangNhap.matKhauDung = false;
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
