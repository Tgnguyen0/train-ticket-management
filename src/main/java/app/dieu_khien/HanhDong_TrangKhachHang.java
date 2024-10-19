package app.dieu_khien;

import app.giao_dien.TrangKhachHang;
import app.thuc_the.GIOI_TINH;
import app.thuc_the.KhachHang;

import javax.swing.event.ListSelectionEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HanhDong_TrangKhachHang implements ActionListener{
    private TrangKhachHang trangKhachHang;

    public HanhDong_TrangKhachHang(TrangKhachHang trangKhachHang) {
        this.trangKhachHang = trangKhachHang;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Chọn")){
            this.trangKhachHang.chonKhachHang();
        } else if (e.getActionCommand().equals("Làm mới")) {
            this.trangKhachHang.lamMoi();
        } else if (e.getActionCommand().equals("Cập nhật")) {
            this.trangKhachHang.capNhat();

        }
    }


}
