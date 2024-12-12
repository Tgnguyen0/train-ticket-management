package app.dieu_khien;

import app.giao_dien.TrangThongKeTienThuong;
import app.phan_tu_tuy_chinh.GanAmThanh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HanhDong_TrangThongKeTienThuong implements ActionListener {
    TrangThongKeTienThuong trangThongKeTienThuong;

    public HanhDong_TrangThongKeTienThuong(TrangThongKeTienThuong trangThongKeTienThuong) {
        this.trangThongKeTienThuong = trangThongKeTienThuong;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GanAmThanh.playSound();

        if(e.getSource()  == this.trangThongKeTienThuong.button_InBanThongKe){
            this.trangThongKeTienThuong.xuatFileExcel();
        }
    }
}
