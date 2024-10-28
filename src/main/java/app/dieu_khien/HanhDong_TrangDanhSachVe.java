package app.dieu_khien;

import app.dao.KhachHang_DAO;
import app.dao.Ve_DAO;
import app.dao.testDataVe;
import app.giao_dien.TrangDanhSachVeTau;
import app.giao_dien.TrangDinhHuong;
import app.phan_tu_tuy_chinh.TaoVeBangFilePDF;
import app.thuc_the.KhachHang;
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
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Slf4j
public class HanhDong_TrangDanhSachVe implements ActionListener, MouseListener {

    String Message_Not_Found = "Không Thể Tìm Thấy Đúng Mã Vé Đã Cung Cấp";
    Logger logger = LoggerFactory.getLogger(TrangDanhSachVeTau.class);
    TrangDanhSachVeTau trangDanhSachVeTau ;
    Ve_DAO databaseVe ;
    public HanhDong_TrangDanhSachVe(TrangDanhSachVeTau trangDanhSachVeTau){
        this.trangDanhSachVeTau = trangDanhSachVeTau;
        this.databaseVe = new Ve_DAO();

        List<Ve> dsVe = null;
        try {
            dsVe = databaseVe.layToanBoVe();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        trangDanhSachVeTau.dayDuLieuVaoBang(dsVe);
        logger.info("lấy thành công");

    }


    public  void quanLyDanhSachVeTrongBang() throws SQLException {
        List<Ve> dsVe = databaseVe.layToanBoVe();
        trangDanhSachVeTau.dayDuLieuVaoBang(dsVe);
        logger.info("lấy thành công");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.trangDanhSachVeTau.buttonLamMoi) {
                this.trangDanhSachVeTau.lamMoiCacThanh();
                logger.info("lấy thành công");
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
//                JOptionPane.showMessageDialog(null, Message_Not_Found);
                // Bạn có thể thêm logic xử lý lỗi hoặc khôi phục dữ liệu mặc định ở đây
                logger.info("Không Thể Kết Nối Database ");
            }
        }
        else if(e.getSource() == this.trangDanhSachVeTau.buttonHuyVe){
            String maVe = this.trangDanhSachVeTau.textFieldMaVe.getText();

            try {
                LocalDate ngayKhoiHanh = this.databaseVe.getNgayKhoiHanh_DuaVaoMaVe(maVe);
                logger.info(ngayKhoiHanh+"");
                logger.info(LocalDate.now()+"");
                Duration duration = Duration.between(LocalDate.now().atStartOfDay(),ngayKhoiHanh.atStartOfDay());
                if(duration.toHours() >= 24){
                    JOptionPane.showMessageDialog(null, "Hủy Vé Thành Công!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Hủy Vé Không Thành Công!");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(e.getSource() == this.trangDanhSachVeTau.buttonInVe){
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

            TaoVeBangFilePDF taoVeBangFilePDF = new TaoVeBangFilePDF();
            taoVeBangFilePDF.generateTicketPDF("D:\\VeTau.pdf", maVe, tenKhachHang, diemDi, diemDen, ngayDatVe,
                    ngayKhoiHanh, loaiVe, maGhe,doiTuong, giaVe);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int location = this.trangDanhSachVeTau.table.getSelectedRow();
        logger.info(location+"");
        String maVe = (String) this.trangDanhSachVeTau.model.getValueAt(location, 0);
        logger.info(maVe);
        List<Ve> danhSachVe = new ArrayList<>();
        try {
            danhSachVe = databaseVe.layVe_DuaVaoMaVe(maVe);
            Ve ve = danhSachVe.get(0);
            this.trangDanhSachVeTau.textFieldMaVe.setText(ve.getMaVe());
            this.trangDanhSachVeTau.textFieldMaVe.setDisabledTextColor(Color.BLUE);
            this.trangDanhSachVeTau.textFieldMaVe.setEnabled(false);

            this.trangDanhSachVeTau.textFieldMaKhachHang.setText(ve.getMaHang());
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

            this.trangDanhSachVeTau.ngayDatVe.setText(ve.getNgayDatVe()+"");

            this.trangDanhSachVeTau.ngayKhoiHanh.setText(ve.getNgayKhoiHanh()+"");

            this.trangDanhSachVeTau.giaVe.setText(ve.getGiaVe()+"");


            logger.info(ve.toString());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

//        this.trangDanhSachVeTau.thanh
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
