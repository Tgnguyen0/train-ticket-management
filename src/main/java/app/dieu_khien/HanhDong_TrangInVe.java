package app.dieu_khien;

import app.giao_dien.TrangInVe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HanhDong_TrangInVe implements ActionListener, MouseListener {
    public TrangInVe trangInVe;

    public HanhDong_TrangInVe(TrangInVe trangInVe) {
        this.trangInVe = trangInVe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.trangInVe.nutXacNhanIn) {
            /*String maVe = this.ve.getMaVe();
            String tenKhachHang = this.khachHang.getTenKH();
            String maGhe = this.ve.getMaGhe();
            String diemDi = this.ve.getGaKhoiHanh();
            String diemDen = this.ve.getGaKetThuc();
            String loaiVe = this.ve.getLoaiVe();
            String doiTuong = this.ve.getLoaiDoiTuong();
            String ngayDatVe = this.ve.getNgayDatVe().toString();
            String ngayKhoiHanh = this.ve.getNgayKhoiHanh().toString();
            String giaVe = String.valueOf(this.ve.getGiaVe());

            TaoVeBangFilePDF taoVeBangFilePDF = new TaoVeBangFilePDF();
            taoVeBangFilePDF.generateTicketPDF("vé được tạo/VeTau.pdf", maVe, tenKhachHang, diemDi, diemDen, ngayDatVe,
                    ngayKhoiHanh, loaiVe, maGhe,doiTuong, giaVe);*/
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
