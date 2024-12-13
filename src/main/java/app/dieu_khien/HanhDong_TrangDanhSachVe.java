package app.dieu_khien;

import app.dao.*;
import app.giao_dien.TrangDanhSachVeTau;
import app.giao_dien.TrangDinhHuong;
import app.giao_dien.TrangThongTinChiTietVeTau;
import app.phan_tu_tuy_chinh.GanAmThanh;
import app.phan_tu_tuy_chinh.TaoVeBangFilePDF;
import app.thuc_the.Ghe;
import app.thuc_the.KhachHang;
import app.thuc_the.Toa;
import app.thuc_the.Ve;
//import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
//@Slf4j
public class HanhDong_TrangDanhSachVe implements ActionListener, MouseListener {
    public Ve veChiTiet;
    public TrangThongTinChiTietVeTau trang;

    String Message_Not_Found = "Không Thể Tìm Thấy Đúng Mã Vé Đã Cung Cấp";
    Logger logger = LoggerFactory.getLogger(TrangDanhSachVeTau.class);
    TrangDanhSachVeTau trangDanhSachVeTau ;
    public HanhDong_TrangDanhSachVe(TrangDanhSachVeTau trangDanhSachVeTau){
        this.trangDanhSachVeTau = trangDanhSachVeTau;

//        List<Ve> dsVe = null;
//        try {
//            dsVe = databaseVe.layToanBoVe();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        trangDanhSachVeTau.dayDuLieuVaoBang(dsVe);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GanAmThanh.playSound();

        if (e.getSource() == this.trangDanhSachVeTau.buttonLamMoi) {
            this.trangDanhSachVeTau.lamMoiCacThanh();
            //this.trangDanhSachVeTau.dayDuLieuVaoBang();
        }
        else if (e.getSource() == this.trangDanhSachVeTau.timKiem) {
            String maVe = this.trangDanhSachVeTau.thanhTimKiem.getText();
            this.trangDanhSachVeTau.timKiem_ThemMaVe(maVe);
        }
        else if(e.getSource() == this.trangDanhSachVeTau.buttonHuyVe){
            String maVe = this.trangDanhSachVeTau.textFieldMaVe.getText();
            this.trangDanhSachVeTau.huyVe_TheoMa(maVe);
        }
        else if(e.getSource() == this.trangDanhSachVeTau.buttonInVe){
            String maVe = this.trangDanhSachVeTau.textFieldMaVe.getText();
            String maKhachHang = this.trangDanhSachVeTau.textFieldMaKhachHang.getText();
            KhachHang_DAO khachHangDao = new KhachHang_DAO();
            KhachHang khachHang= new KhachHang();
            khachHang = khachHangDao.layKhachHangMuaVeTheoMaKhachHang(maKhachHang);
            String tenKhachHang = khachHang.getTenKH();
            String maGhe = this.trangDanhSachVeTau.textFieldMaGhe.getText();

            Ghe_DAO gheDao = new Ghe_DAO();
            String maToa = gheDao.ChonTheoMa(maGhe).getMaToa();

            Toa_DAO toaDao = new Toa_DAO();
            Toa toa = toaDao.ChonTheoMa(maToa);

            String soHieu = toa.getSoHieu();
            String tenToa = toa.getTenToa();
            String diemDi = this.trangDanhSachVeTau.textFieldDiemDi.getText();
            String diemDen = this.trangDanhSachVeTau.textFieldDiemDen.getText();
            String loaiVe = this.trangDanhSachVeTau.textFieldLoaiVe.getText();
            String doiTuong = this.trangDanhSachVeTau.textFieldDoiTuong.getText();
            String ngayDatVe = this.trangDanhSachVeTau.ngayDatVe.getText();
            String giaVe = this.trangDanhSachVeTau.giaVe.getText();

            //  Lấy ngày giờ cụ thể
            Ve ve = (Ve_DAO.layVe_DuaVaoMaVe(maVe)).get(0);
//            String ngayKhoiHanh = STR."\{ve.getNgayKhoiHanh().getYear()}-\{ve.getNgayKhoiHanh().getMonth().getValue()}-\{ve.getNgayKhoiHanh().getDayOfMonth()}";
//            String gioKhoiHanh = STR."\{ve.getNgayKhoiHanh().getHour()}:\{ve.getNgayKhoiHanh().getMinute()}";
            String ngayKhoiHanh = ve.getNgayKhoiHanh().getYear() + "-" +
                    ve.getNgayKhoiHanh().getMonth().getValue() + "-" +
                    ve.getNgayKhoiHanh().getDayOfMonth();

            String gioKhoiHanh = ve.getNgayKhoiHanh().getHour() + ":" +
                    ve.getNgayKhoiHanh().getMinute();

            if(JOptionPane.showConfirmDialog(null, "Xác Nhận In Vé ") == JOptionPane.YES_OPTION){
                TaoVeBangFilePDF taoVeBangFilePDF = new TaoVeBangFilePDF();

                taoVeBangFilePDF.generateTicketPDF(
                        maVe + ".pdf",
                        maVe,
                        soHieu,
                        tenToa,
                        tenKhachHang,
                        diemDi,
                        diemDen,
                        ngayDatVe,
                        ngayKhoiHanh,
                        gioKhoiHanh,
                        loaiVe,
                        maGhe,
                        doiTuong,
                        giaVe
                );

                JOptionPane.showMessageDialog(null, "In Vé Thành Công");
            }
        }
        else if(e.getSource() == this.trangDanhSachVeTau.buttonThongTinChiTiet) {
            //logger.info("Đã chọn nút thông tin chi tiết ");
            String maVe = this.trangDanhSachVeTau.textFieldMaVe.getText();

            if (this.trangDanhSachVeTau.table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Chưa chọn vé !");
            }

            if (this.trangDanhSachVeTau.table.getSelectedRow() != -1 && maVe.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Hãy nhấn để chọn lại vé");
            }

            String maKhachHang = this.trangDanhSachVeTau.textFieldMaKhachHang.getText();
            KhachHang_DAO khachHangDao = new KhachHang_DAO();
            KhachHang khachHang = khachHangDao.layKhachHangMuaVeTheoMaKhachHang(maKhachHang);
            String tenKhachHang = khachHang.getTenKH();
            String maGhe = this.trangDanhSachVeTau.textFieldMaGhe.getText();
            String diemDi = this.trangDanhSachVeTau.textFieldDiemDi.getText();
            String diemDen = this.trangDanhSachVeTau.textFieldDiemDen.getText();
            String loaiVe = this.trangDanhSachVeTau.textFieldLoaiVe.getText();
            String doiTuong = this.trangDanhSachVeTau.textFieldDoiTuong.getText();
            String giaVe = this.trangDanhSachVeTau.giaVe.getText();

            /*
                lấy vị trí ghế ngồi
             */
                // Nhớ thay bằng cái maGhe đã định sẵn
                Ghe ghe = Ghe_DAO.layGheTheoMaGhe(maGhe);
            /*
                lấy tên toa và lấy số hiệu
             */
                Toa toa = Toa_DAO.layToaTheoMaToa(ghe.getMaToa());

                List<Ve> danhSachVe = new ArrayList<>();

                // Lấy ngày khởi hành để tìm lịch tàu
                danhSachVe = Ve_DAO.layVe_DuaVaoMaVe(maVe);
                Ve ve = danhSachVe.get(0);

                new TrangThongTinChiTietVeTau(this.trangDanhSachVeTau, maVe, loaiVe, diemDi, diemDen, ve.getNgayKhoiHanh(),
                        "", tenKhachHang,toa.getMaTau(), toa.getTenToa(), ghe, ve.getNgayDatVe(), doiTuong, giaVe).setVisible(true);
        }
        else if(e.getSource() == this.trangDanhSachVeTau.buttonToanBoDanhSachVe){
            this.trangDanhSachVeTau.dayDuLieuVaoBang();
            this.trangDanhSachVeTau.lamMoiCacThanh();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.trangDanhSachVeTau.hienThiThongTinVe_TrenCacThanhJtextField();
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
