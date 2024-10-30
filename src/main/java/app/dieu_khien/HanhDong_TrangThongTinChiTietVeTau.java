package app.dieu_khien;

import app.giao_dien.TrangThongTinChiTietVeTau;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HanhDong_TrangThongTinChiTietVeTau implements ActionListener, MouseListener {
    TrangThongTinChiTietVeTau trangThongTinChiTietVeTau ;
    public HanhDong_TrangThongTinChiTietVeTau(TrangThongTinChiTietVeTau trangThongTinChiTietVeTau){
        this.trangThongTinChiTietVeTau = trangThongTinChiTietVeTau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.trangThongTinChiTietVeTau.buttonCapNhat){
            if(JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn cập nhật?") == JOptionPane.YES_OPTION){
                this.trangThongTinChiTietVeTau.choPhepCapNhat();
            }
        }
        else if (e.getSource() == this.trangThongTinChiTietVeTau.buttonXacNhan){

        }
        else if(e.getSource() == this.trangThongTinChiTietVeTau.buttonViTriGhe){

        }
        else if(e.getSource() == this.trangThongTinChiTietVeTau.buttonInVe){

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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
