package app.dieu_khien;

import app.dao.HoaDon_DAO;
import app.giao_dien.TrangChuaThongKeDoanhThuNhaGa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HanhDong_TrangThongKeDoanhThuNhaGa implements ActionListener, MouseListener {
    TrangChuaThongKeDoanhThuNhaGa trangChuaThongKeDoanhThuNhaGa ;
    HoaDon_DAO  hoaDonDao ;
    public HanhDong_TrangThongKeDoanhThuNhaGa(TrangChuaThongKeDoanhThuNhaGa trangChuaThongKeDoanhThuNhaGa){
        this.trangChuaThongKeDoanhThuNhaGa = trangChuaThongKeDoanhThuNhaGa;
        this.hoaDonDao = new HoaDon_DAO();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.trangChuaThongKeDoanhThuNhaGa.buttonThongKeThang){
            this.trangChuaThongKeDoanhThuNhaGa.tinhDoanhThuNhaGaTrongThang();
            this.trangChuaThongKeDoanhThuNhaGa.taoBieuDoTronCuaDoanhThang();
        } else if(e.getSource() == this.trangChuaThongKeDoanhThuNhaGa.buttonThongKeNam){

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
