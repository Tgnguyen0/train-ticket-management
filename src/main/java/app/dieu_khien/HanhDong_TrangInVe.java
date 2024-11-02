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
import java.time.LocalDateTime;

public class HanhDong_TrangInVe implements ActionListener, MouseListener {
    public TrangInVe trangInVe;

    public HanhDong_TrangInVe(TrangInVe trangInVe) {
        this.trangInVe = trangInVe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.trangInVe.nutXacNhanIn) {
            for (Ve ve : this.trangInVe.dsVe) {

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


                /*ve.getMaVe(),
                        soHieu,
                        kh.getTenKH(),
                        ve.getGaKhoiHanh(),
                        kh.getSoDT(),
                        ve.getGaKetThuc(),
                        kh.getEmail(),
                        ve.getNgayKhoiHanh().getYear() + "-" + ve.getNgayKhoiHanh().getMonth().getValue() + "-" + ve.getNgayKhoiHanh().getDayOfMonth(),
                        ve.getNgayDatVe().getYear() + "-" + ve.getNgayDatVe().getMonth().getValue() + "-" + ve.getNgayDatVe().getDayOfMonth(),
                        ve.getNgayKhoiHanh().getHour() + ":" + ve.getNgayKhoiHanh().getMinute(),
                        ve.getLoaiVe(),
                        toa.getTenToa(),
                        ghe.getSoGhe(),
                        ve.getGiaVe()*/
                String maVe = ve.getMaVe();
                String soHieu = toa.getSoHieu();
                String tenKH = kh.getTenKH();
                String diemDi = ve.getGaKhoiHanh();
                String sdtKH = kh.getSoDT();
                String diemDen = ve.getGaKetThuc();
                String emailKH = kh.getEmail();
                String ngayKhoiHanh = ve.getNgayKhoiHanh().getYear() + "-" + ve.getNgayKhoiHanh().getMonth().getValue() + "-" + ve.getNgayKhoiHanh().getDayOfMonth();
                String ngayDatVe = ve.getNgayDatVe().getYear() + "-" + ve.getNgayDatVe().getMonth().getValue() + "-" + ve.getNgayDatVe().getDayOfMonth();
                String gioKhoiHanh = ve.getNgayKhoiHanh().getHour() + ":" + ve.getNgayKhoiHanh().getMinute();
                String loaiVe = ve.getLoaiVe();
                String soGhe = String.valueOf(ghe.getSoGhe());
                String giaVe = String.valueOf(ve.getGiaVe());

                TaoVeBangFilePDF taoVeBangFilePDF = new TaoVeBangFilePDF();
                taoVeBangFilePDF.generateTicketPDF("vé được tạo/" + maVe + ".pdf", maVe, kh.getTenKH(), diemDi, diemDen, ngayDatVe,
                        ngayKhoiHanh, loaiVe, ghe.getMaGhe(), "Người Lớn", giaVe);
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
