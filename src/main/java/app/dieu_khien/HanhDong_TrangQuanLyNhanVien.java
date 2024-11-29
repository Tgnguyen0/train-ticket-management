package app.dieu_khien;

import app.giao_dien.TrangLichSuTruc;
import app.giao_dien.TrangQuanLyNhanVien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HanhDong_TrangQuanLyNhanVien implements ActionListener {
    private TrangQuanLyNhanVien trangQuanLyNhanVien;

    public HanhDong_TrangQuanLyNhanVien(TrangQuanLyNhanVien trangQuanLyNhanVien) {
        this.trangQuanLyNhanVien = trangQuanLyNhanVien;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == trangQuanLyNhanVien.btn_xemLichSuTruc){
            this.xemLichSuTruc();
        }
    }

    private void xemLichSuTruc() {
        TrangLichSuTruc trangLichSuTruc = new TrangLichSuTruc();
        trangLichSuTruc.setVisible(true);
    }
}
