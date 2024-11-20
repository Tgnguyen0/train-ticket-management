package app.dieu_khien;

import app.dao.*;
import app.giao_dien.TrangDanhSachVeTau;
import app.giao_dien.TrangDinhHuong;
import app.giao_dien.TrangThongTinChiTietVeTau;
import app.phan_tu_tuy_chinh.TaoVeBangFilePDF;
import app.thuc_the.Ghe;
import app.thuc_the.KhachHang;
import app.thuc_the.Toa;
import app.thuc_the.Ve;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class HanhDong_TrangDanhSachVe implements ActionListener, MouseListener {
    public Ve veChiTiet;

    String Message_Not_Found = "Không Thể Tìm Thấy Đúng Mã Vé Đã Cung Cấp";
    Logger logger = LoggerFactory.getLogger(TrangDanhSachVeTau.class);
    TrangDanhSachVeTau trangDanhSachVeTau ;
    Ve_DAO databaseVe ;
    public HanhDong_TrangDanhSachVe(TrangDanhSachVeTau trangDanhSachVeTau){
        this.trangDanhSachVeTau = trangDanhSachVeTau;
        this.databaseVe = new Ve_DAO();

//        List<Ve> dsVe = null;
//        try {
//            dsVe = databaseVe.layToanBoVe();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        trangDanhSachVeTau.dayDuLieuVaoBang(dsVe);

    }

    public  void quanLyDanhSachVeTrongBang() throws SQLException {
        List<Ve> dsVe = databaseVe.layToanBoVe();
        trangDanhSachVeTau.dayDuLieuVaoBang(dsVe);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.trangDanhSachVeTau.buttonLamMoi) {
                this.trangDanhSachVeTau.lamMoiCacThanh();
            try {
                this.quanLyDanhSachVeTrongBang();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getSource() == this.trangDanhSachVeTau.timKiem) {
            String maVe = this.trangDanhSachVeTau.thanhTimKiem.getText();

            try {
                List<Ve> danhSachVe = this.databaseVe.layVe_DuaVaoMaVe(maVe);

                // Kiểm tra nếu danhSachVe là null
                if (danhSachVe == null || danhSachVe.isEmpty()) {
                    JOptionPane.showMessageDialog(null, Message_Not_Found);
                    List<Ve> dsVe = databaseVe.layToanBoVe();
                    trangDanhSachVeTau.dayDuLieuVaoBang(dsVe);
                } else {
                    this.trangDanhSachVeTau.dayDuLieuVaoBang(danhSachVe);

                }
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, Message_Not_Found);
                // Bạn có thể thêm logic xử lý lỗi hoặc khôi phục dữ liệu mặc định ở đây

            }
        }
        else if(e.getSource() == this.trangDanhSachVeTau.buttonHuyVe){
            String maVe = this.trangDanhSachVeTau.textFieldMaVe.getText();

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

                LocalDateTime ngayKhoiHanh_Ve = this.databaseVe.getNgayKhoiHanh_DuaVaoMaVe(maVe);


                String maGhe = this.trangDanhSachVeTau.textFieldMaGhe.getText();

                LocalDateTime gioKhoiHanhTau = this.databaseVe.getNgayKhoiHanhCuaTau_DuaVaoMaGhe(maGhe, "Sài Gòn");
                LocalDateTime dateCurrent = LocalDateTime.now();
                if(gioKhoiHanhTau != null){
                    // tính khoảng cách 2 localdatetime
                    Duration duration = Duration.between(ngayKhoiHanh_Ve, gioKhoiHanhTau);

                    if (duration.toHours() >= 24 && ngayKhoiHanh_Ve.isAfter(dateCurrent)) {
                        JOptionPane.showMessageDialog(null, "Hủy Vé Thành Công!");
                        int location = this.trangDanhSachVeTau.table.getSelectedRow();
                        this.trangDanhSachVeTau.model.removeRow(location);
                        this.trangDanhSachVeTau.lamMoiCacThanh();
                    } else {
                        JOptionPane.showMessageDialog(null, "Hủy Vé Không Thành Công!","Cảnh Báo!!!!!" ,JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Hủy Vé Không Thành Công!","Cảnh Báo!!!!!" ,JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Hủy Vé Không Thành Công!","Cảnh Báo!!!!!" ,JOptionPane.ERROR_MESSAGE);
            }

        }
        else if(e.getSource() == this.trangDanhSachVeTau.buttonInVe){
            String maVe = this.trangDanhSachVeTau.textFieldMaVe.getText();
            String maKhachHang = this.trangDanhSachVeTau.textFieldMaKhachHang.getText();
            KhachHang_DAO khachHangDao = new KhachHang_DAO();
            KhachHang khachHang = khachHangDao.layKhachHangMuaVeTheoMaKhachHang(maKhachHang);
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
            String ngayKhoiHanh = this.trangDanhSachVeTau.ngayKhoiHanh.getText();
            String giaVe = this.trangDanhSachVeTau.giaVe.getText();

            if(JOptionPane.showConfirmDialog(null, "Xác Nhận In Vé ") == JOptionPane.YES_OPTION){
                TaoVeBangFilePDF taoVeBangFilePDF = new TaoVeBangFilePDF();

                taoVeBangFilePDF.generateTicketPDF(
                        "vé được tạo/" + maVe + ".pdf",
                        maVe,
                        soHieu,
                        tenToa,
                        tenKhachHang,
                        diemDi,
                        diemDen,
                        ngayDatVe,
                        ngayKhoiHanh,
                        "10:00",
                        loaiVe,
                        maGhe,
                        doiTuong,
                        giaVe
                );
                JOptionPane.showMessageDialog(null, "In Vé Thành Công");
            }
        }
        else if(e.getSource() == this.trangDanhSachVeTau.buttonThongTinChiTiet){
            //logger.info("Đã chọn nút thông tin chi tiết ");
            String maVe = this.trangDanhSachVeTau.textFieldMaVe.getText();
            String maKhachHang = this.trangDanhSachVeTau.textFieldMaKhachHang.getText();
            KhachHang_DAO khachHangDao = new KhachHang_DAO();
            KhachHang khachHang = khachHangDao.layKhachHangMuaVeTheoMaKhachHang(maKhachHang);
            String tenKhachHang = khachHang.getTenKH();
            String maGhe = this.trangDanhSachVeTau.textFieldMaGhe.getText();
            String diemDi = this.trangDanhSachVeTau.textFieldDiemDi.getText();
            String diemDen = this.trangDanhSachVeTau.textFieldDiemDen.getText();
            String loaiVe = this.trangDanhSachVeTau.textFieldLoaiVe.getText();
            String doiTuong = this.trangDanhSachVeTau.textFieldDoiTuong.getText();
            String ngayDatVe = this.trangDanhSachVeTau.ngayDatVe.getText();
            String ngayKhoiHanh = this.trangDanhSachVeTau.ngayKhoiHanh.getText();
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

            try {
                // Lấy ngày khởi hành để tìm lịch tàu
                danhSachVe = databaseVe.layVe_DuaVaoMaVe(maVe);
                Ve ve = danhSachVe.get(0);

                new TrangThongTinChiTietVeTau(maVe, loaiVe, diemDi, diemDen, ve.getNgayKhoiHanh(),
                        "", tenKhachHang,toa.getMaTau(), toa.getTenToa(), ghe, ve.getNgayDatVe(), doiTuong, giaVe).setVisible(true);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int location = this.trangDanhSachVeTau.table.getSelectedRow();
//        logger.info(location+"");
        String maVe = (String) this.trangDanhSachVeTau.model.getValueAt(location, 0);
       // logger.info(maVe);
        List<Ve> danhSachVe = new ArrayList<>();
        try {
            danhSachVe = databaseVe.layVe_DuaVaoMaVe(maVe);
            Ve ve = danhSachVe.get(0);

            this.trangDanhSachVeTau.textFieldMaVe.setText(ve.getMaVe());
            this.trangDanhSachVeTau.textFieldMaVe.setDisabledTextColor(Color.BLUE);
            this.trangDanhSachVeTau.textFieldMaVe.setEnabled(false);

            this.trangDanhSachVeTau.textFieldMaKhachHang.setText(ve.getMaKhachHang());
            this.trangDanhSachVeTau.textFieldMaKhachHang.setDisabledTextColor(Color.BLUE);
            this.trangDanhSachVeTau.textFieldMaKhachHang.setEnabled(false);

            this.trangDanhSachVeTau.textFieldMaGhe.setText(ve.getMaGhe());
            this.trangDanhSachVeTau.textFieldMaGhe.setDisabledTextColor(Color.BLUE);
            this.trangDanhSachVeTau.textFieldMaGhe.setEnabled(false);

            this.trangDanhSachVeTau.textFieldDiemDi.setText(ve.getGaKhoiHanh());
            this.trangDanhSachVeTau.textFieldDiemDi.setDisabledTextColor(Color.BLUE);
            this.trangDanhSachVeTau.textFieldDiemDi.setEnabled(false);

            this.trangDanhSachVeTau.textFieldDiemDen.setText(ve.getGaKetThuc());
            this.trangDanhSachVeTau.textFieldDiemDen.setDisabledTextColor(Color.BLUE);
            this.trangDanhSachVeTau.textFieldDiemDen.setEnabled(false);

            this.trangDanhSachVeTau.textFieldLoaiVe.setText(ve.getLoaiVe());
            this.trangDanhSachVeTau.textFieldLoaiVe.setDisabledTextColor(Color.BLUE);
            this.trangDanhSachVeTau.textFieldLoaiVe.setEnabled(false);

            this.trangDanhSachVeTau.textFieldDoiTuong.setText(ve.getLoaiDoiTuong());
            this.trangDanhSachVeTau.textFieldDoiTuong.setDisabledTextColor(Color.BLUE);
            this.trangDanhSachVeTau.textFieldDoiTuong.setEnabled(false);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            this.trangDanhSachVeTau.ngayDatVe.setText(formatter.format(ve.getNgayDatVe()));

            this.trangDanhSachVeTau.ngayKhoiHanh.setText(formatter.format(ve.getNgayKhoiHanh()));
            DecimalFormat df = new DecimalFormat("#,###.##");
            this.trangDanhSachVeTau.giaVe.setText(df.format(ve.getGiaVe())+" VNĐ");


//            logger.info(ve.toString());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
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
