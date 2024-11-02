package app.dieu_khien;

import app.giao_dien.TrangChuaThongKeNhanVienTheoNam;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HanhDong_TrangThongKeNhanVienTheoNam implements ActionListener, MouseListener {
    TrangChuaThongKeNhanVienTheoNam trangChuaThongKeNhanVienTheoNam;

    public HanhDong_TrangThongKeNhanVienTheoNam(TrangChuaThongKeNhanVienTheoNam trangChuaThongKeNhanVienTheoNam) {
        this.trangChuaThongKeNhanVienTheoNam = trangChuaThongKeNhanVienTheoNam;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.trangChuaThongKeNhanVienTheoNam.buttonThongKe){
            this.trangChuaThongKeNhanVienTheoNam.taoBieuDoCotThongKeDoanhThuNhanVien();
            this.trangChuaThongKeNhanVienTheoNam.tinhTongDoanhThu();
            this.trangChuaThongKeNhanVienTheoNam.layCacNhanVienUuTu();
            this.trangChuaThongKeNhanVienTheoNam.trangChuaBieuDo.revalidate();
            this.trangChuaThongKeNhanVienTheoNam.trangChuaBieuDo.repaint();
        }
        else if(e.getSource() == this.trangChuaThongKeNhanVienTheoNam.buttonThongKeTheoThangCuaNhanVien){
            CardLayout cardLayout = (CardLayout) this.trangChuaThongKeNhanVienTheoNam.trangDinhHuong.getTrangChua().getLayout();
            cardLayout.show(this.trangChuaThongKeNhanVienTheoNam.trangDinhHuong.getTrangChua(), "ThongKeDoanhThuTheoThang");
        }
        else if(e.getSource() == this.trangChuaThongKeNhanVienTheoNam.buttonThongKeDoanhThu){
            CardLayout cardLayout = (CardLayout) this.trangChuaThongKeNhanVienTheoNam.trangDinhHuong.getTrangChua().getLayout();
            cardLayout.show(this.trangChuaThongKeNhanVienTheoNam.trangDinhHuong.getTrangChua(), "Trang Thong Ke");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int index = this.trangChuaThongKeNhanVienTheoNam.danhSachNhanVienUuTu.getSelectedRow();
        this.trangChuaThongKeNhanVienTheoNam.xacDinhNhanVienDuocChon(index);
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
