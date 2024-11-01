package app.dieu_khien;

import app.giao_dien.TrangChuaThongKeNhanVienTheoThang;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HanhDong_TrangThongKeNhanVienTheoThang implements ActionListener, MouseListener {
    TrangChuaThongKeNhanVienTheoThang trangChuaThongKeNhanVienTheoThang ;

    public HanhDong_TrangThongKeNhanVienTheoThang(TrangChuaThongKeNhanVienTheoThang trangChuaThongKeNhanVienTheoThang) {
        this.trangChuaThongKeNhanVienTheoThang = trangChuaThongKeNhanVienTheoThang;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.trangChuaThongKeNhanVienTheoThang.buttonThongKeDoanhThu){
            CardLayout cardLayout = (CardLayout) this.trangChuaThongKeNhanVienTheoThang.trangDinhHuong.getTrangChua().getLayout();
            cardLayout.show(this.trangChuaThongKeNhanVienTheoThang.trangDinhHuong.getTrangChua(), "ThongKeDoanhThuNhaGa");
        }
        else if(e.getSource() == this.trangChuaThongKeNhanVienTheoThang.buttonThongKeTheoNamNhanVien){
            CardLayout cardLayout = (CardLayout) this.trangChuaThongKeNhanVienTheoThang.trangDinhHuong.getTrangChua().getLayout();
            cardLayout.show(this.trangChuaThongKeNhanVienTheoThang.trangDinhHuong.getTrangChua(), "ThongKeDoanhThuTheoNam");
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