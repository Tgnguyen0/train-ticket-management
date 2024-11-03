package app.dieu_khien;

import app.giao_dien.TrangDatVe;
import app.giao_dien.TrangDinhHuong;
import app.giao_dien.TrangHoaDon;
import app.giao_dien.TrangThanhToan;
import app.thuc_the.DaiNgo;
import app.thuc_the.HoaDon;
import app.thuc_the.Ve;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class HanhDong_TrangThanhToan implements ActionListener, MouseListener {
    TrangThanhToan trangThanhToan;
    Double tongTien;

    public HanhDong_TrangThanhToan(TrangThanhToan trangThanhToan) { this.trangThanhToan = trangThanhToan; }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.trangThanhToan.radioTienMat) {
            this.trangThanhToan.radioChuyenKhoan.setSelected(false);
        }

        if (e.getSource() == this.trangThanhToan.radioChuyenKhoan) {
            this.trangThanhToan.radioTienMat.setSelected(false);
        }

        if (e.getSource() == this.trangThanhToan.ButtonThanhToan && this.trangThanhToan.radioTienMat.isSelected()) {
            double thanhTien = Double.parseDouble(this.trangThanhToan.tfThanhTien.getText());
            double tienNhan = Double.parseDouble(this.trangThanhToan.thanhTienNhan.getText());

            double tienTra = tienNhan - thanhTien;

            this.trangThanhToan.tfTraLai.setText(String.valueOf(tienTra));

            double tongTien = 0;
            for (int i = 0 ; i < this.trangThanhToan.danhSachVe.size() ; i++) {
                tongTien += this.trangThanhToan.danhSachVe.get(i).getGiaVe() * (1 - (this.trangThanhToan.danhSachVe.get(i).getLoaiDoiTuong().equals("Người Lớn") ? 0.0 : 0.025));
            }

            String maNV = this.trangThanhToan.layMaNV();

            HoaDon hd = new HoaDon(
                    LocalDate.now(),
                    thanhTien,
                    this.trangThanhToan.dsKh.get(0).getMaKH(),
                    maNV,
                    this.trangThanhToan.danhSachVe.size(),
                    tongTien,
                    "Chưa In",
                    this.trangThanhToan.daiNgo,
                    0
            );

            this.trangThanhToan.hdDao.LuuHoaDon(hd);

            ((TrangHoaDon) TrangDinhHuong.getTrangChua().getComponent(2)).datHoaDonDTao(hd);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Ve ve = this.trangThanhToan.danhSachVe.get(this.trangThanhToan.danhSachVeThanhToan.getSelectedRow());

        if (ve.getLoaiDoiTuong().equals("Người Lớn")) {
            this.trangThanhToan.tfVAT.setText("2.5%");
        } else {
            this.trangThanhToan.tfVAT.setText("0%");
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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
