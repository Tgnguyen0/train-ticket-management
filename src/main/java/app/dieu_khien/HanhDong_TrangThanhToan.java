package app.dieu_khien;

import app.giao_dien.TrangThanhToan;
import app.thuc_the.DaiNgo;
import app.thuc_the.Ve;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HanhDong_TrangThanhToan implements ActionListener, MouseListener {
    TrangThanhToan trangThanhToan;
    Double tongTien;

    public HanhDong_TrangThanhToan(TrangThanhToan trangThanhToan) { this.trangThanhToan = trangThanhToan; }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.trangThanhToan.radioTienMat) {
            this.trangThanhToan.radioChuyenKhoan.setSelected(false);
        }

        if (e.getSource() == this.trangThanhToan.radioChuyenKhoan) {
            this.trangThanhToan.radioTienMat.setSelected(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        /*for (int i = 0 ; i < this.trangThanhToan.danhSachVe.size() ; i++) {
            tongTien += this.trangThanhToan.danhSachVe.get(i).getGiaVe();
        }*/

        Ve ve = this.trangThanhToan.danhSachVe.get(this.trangThanhToan.danhSachVeThanhToan.getSelectedRow());
        int soLuong = this.trangThanhToan.danhSachVe.size();
        DaiNgo daiNgo = DaiNgo.GIAMGIAKHONGPHANTRAM;

        if (4 <= soLuong && soLuong < 10) {
            daiNgo = DaiNgo.GIAMGIANAMPHANTRAM;
        }

        if (10 <= soLuong && soLuong < 15) {
            daiNgo = DaiNgo.GIAMGIAMUOIPHANTRAM;
        }

        if (15 <= soLuong) {
            daiNgo = DaiNgo.GIAMGIAHAIMUOIPHANTRAM;
        }

        this.trangThanhToan.tfThanhTien.setText(String.valueOf(ve.getGiaVe()));

        this.trangThanhToan.tfKhuyenMai.setText(daiNgo.toString());

        if (ve.getLoaiDoiTuong().equals("Người Lớn")) {
            this.trangThanhToan.tfVAT.setText("2.5%");
        } else {
            this.trangThanhToan.tfVAT.setText("0%");
        }
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
