package app.dieu_khien;

import app.giao_dien.TrangInVe;
import app.phan_tu_tuy_chinh.TaoVeBangFilePDF;
import app.thuc_the.Ghe;
import app.thuc_the.KhachHang;
import app.thuc_the.Toa;
import app.thuc_the.Ve;

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
            for (Ve ve : this.trangInVe.dsVe) {
                String maVe = ve.getMaVe();

                Ghe ghe = null;
                for (int j = 0 ; j < this.trangInVe.dsGhe.size() ; j++) {
                    if (this.trangInVe.dsGhe.get(j).getMaGhe().equals(ve.getMaGhe())) {
                        ghe = this.trangInVe.dsGhe.get(j);
                    }
                }

                KhachHang kh = null;
                for (int j = 0 ; j < this.trangInVe.dsKH.size() ; j++) {
                    if (this.trangInVe.dsKH.get(j).getMaKH().equals(ve.getMaKhachHang())) {
                        kh = this.trangInVe.dsKH.get(j);
                    }
                }

                Toa toa = this.trangInVe.toaDao.ChonTheoMa(ghe.getMaToa());
                String soHieu = toa.getSoHieu();

                String diemDi = ve.getGaKhoiHanh();
                String diemDen = ve.getGaKetThuc();
                String loaiVe = ve.getLoaiVe();
                String doiTuong = ve.getLoaiDoiTuong();
                String ngayDatVe = ve.getNgayDatVe().toString();
                String ngayKhoiHanh = ve.getNgayKhoiHanh().toString();
                String giaVe = String.valueOf(ve.getGiaVe());

                TaoVeBangFilePDF taoVeBangFilePDF = new TaoVeBangFilePDF();
                taoVeBangFilePDF.generateTicketPDF("vé được tạo/VeTau.pdf", maVe, kh.getTenKH(), diemDi, diemDen, ngayDatVe,
                        ngayKhoiHanh, loaiVe, ghe.getMaGhe(), doiTuong, giaVe);
            }
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
