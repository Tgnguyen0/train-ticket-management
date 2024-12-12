package app.dieu_khien;

import app.giao_dien.TrangChiTietHoaDon;
import app.phan_tu_tuy_chinh.GanAmThanh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HanhDong_TrangChiTietHoaDon implements ActionListener {
    TrangChiTietHoaDon trangChiTietHoaDon;

    public HanhDong_TrangChiTietHoaDon(TrangChiTietHoaDon trangChiTietHoaDon) {
        this.trangChiTietHoaDon = trangChiTietHoaDon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GanAmThanh.playSound();

        if(e.getSource() == this.trangChiTietHoaDon.button_XacNhan){
            this.trangChiTietHoaDon.capNhatHoaDon();
            this.trangChiTietHoaDon.dongGiaoDien();
        }
    }
}
