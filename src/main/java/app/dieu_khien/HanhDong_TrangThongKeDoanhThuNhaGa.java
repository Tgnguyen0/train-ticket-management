package app.dieu_khien;

import app.dao.HoaDon_DAO;
import app.giao_dien.TrangChuaThongKeDoanhThuNhaGa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.event.*;

public class HanhDong_TrangThongKeDoanhThuNhaGa extends MouseAdapter implements ActionListener, MouseListener {
    TrangChuaThongKeDoanhThuNhaGa trangChuaThongKeDoanhThuNhaGa ;
    HoaDon_DAO  hoaDonDao ;

    Logger logger = LoggerFactory.getLogger(TrangChuaThongKeDoanhThuNhaGa.class);
    public HanhDong_TrangThongKeDoanhThuNhaGa(TrangChuaThongKeDoanhThuNhaGa trangChuaThongKeDoanhThuNhaGa){
        this.trangChuaThongKeDoanhThuNhaGa = trangChuaThongKeDoanhThuNhaGa;
        this.hoaDonDao = new HoaDon_DAO();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.trangChuaThongKeDoanhThuNhaGa.buttonThongKeThang){
            this.trangChuaThongKeDoanhThuNhaGa.tinhDoanhThuNhaGaTrongThang();
            this.trangChuaThongKeDoanhThuNhaGa.taoBieuDoTronCuaDoanhThang();
            logger.info("Đã click vào biểu đồ cột");
            this.trangChuaThongKeDoanhThuNhaGa.trangChuaBieuDoTron.revalidate();
            this.trangChuaThongKeDoanhThuNhaGa.trangChuaBieuDoTron.repaint();

        } else if(e.getSource() == this.trangChuaThongKeDoanhThuNhaGa.buttonThongKeNam){
            this.trangChuaThongKeDoanhThuNhaGa.tinhDoanhThuNhaGaTrongCacNam();
            this.trangChuaThongKeDoanhThuNhaGa.taoBieuDoCotDoanhThuCacNam();

            this.trangChuaThongKeDoanhThuNhaGa.trangChuaBieuDoCot.revalidate();
            this.trangChuaThongKeDoanhThuNhaGa.trangChuaBieuDoCot.repaint();
        }
        else if(e.getSource() == this.trangChuaThongKeDoanhThuNhaGa.buttonThongKeDoanhThuThangCuaNhanVien){
            CardLayout cardLayout = (CardLayout) this.trangChuaThongKeDoanhThuNhaGa.trangDinhHuong.getTrangChua().getLayout();
            cardLayout.show(this.trangChuaThongKeDoanhThuNhaGa.trangDinhHuong.getTrangChua(), "ThongKeDoanhThuTheoThang");
        }
        else if(e.getSource() == this.trangChuaThongKeDoanhThuNhaGa.buttonThongKeDoanhThuNamCuaNhanVien){
            CardLayout cardLayout = (CardLayout) this.trangChuaThongKeDoanhThuNhaGa.trangDinhHuong.getTrangChua().getLayout();
            cardLayout.show(this.trangChuaThongKeDoanhThuNhaGa.trangDinhHuong.getTrangChua(), "ThongKeDoanhThuTheoNam");
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
        if (e.getSource() == this.trangChuaThongKeDoanhThuNhaGa.trangChuaBieuDoCot){
            logger.info("Đã di chuyển vào biểu đồ cột");
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
