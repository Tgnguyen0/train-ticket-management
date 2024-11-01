package app.dieu_khien;

import app.dao.Ghe_DAO;
import app.dao.KhachHang_DAO;
import app.dao.Toa_DAO;
import app.dao.Ve_DAO;
import app.giao_dien.TrangThongTinChiTietVeTau;
import app.phan_tu_tuy_chinh.TaoVeBangFilePDF;
import app.thuc_the.Ghe;
import app.thuc_the.KhachHang;
import app.thuc_the.Toa;
import app.thuc_the.Ve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;

public class HanhDong_TrangThongTinChiTietVeTau implements ActionListener, MouseListener {
    TrangThongTinChiTietVeTau trangThongTinChiTietVeTau ;

    Logger logger = LoggerFactory.getLogger(TrangThongTinChiTietVeTau.class);
    public HanhDong_TrangThongTinChiTietVeTau(TrangThongTinChiTietVeTau trangThongTinChiTietVeTau){
        this.trangThongTinChiTietVeTau = trangThongTinChiTietVeTau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.trangThongTinChiTietVeTau.buttonCapNhat){
            if(JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn cập nhật?") == JOptionPane.YES_OPTION){
                this.trangThongTinChiTietVeTau.choPhepCapNhat();
            }
        }
        else if (e.getSource() == this.trangThongTinChiTietVeTau.buttonXacNhan){
           if(JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xác nhận không?\n Sau Khi xác nhận sẽ cập nhật lại thông tin vé ") == JOptionPane.YES_OPTION){
                String maVe = this.trangThongTinChiTietVeTau.textFieldMaVe.getText();
                logger.info(maVe);
                String ngayDatVe = this.trangThongTinChiTietVeTau.textFieldNgayDatVe.getText();
                String ngayKhoiHanh = this.trangThongTinChiTietVeTau.textFieldNgayKhoiHanh.getText();
                String giaVe = this.trangThongTinChiTietVeTau.textFieldGiaVe.getText();
                String viTriGhe = this.trangThongTinChiTietVeTau.textFieldGhe.getText();
                String soHieu = this.trangThongTinChiTietVeTau.textFieldSoHieu.getText();
                String tenToa = this.trangThongTinChiTietVeTau.textFieldToa.getText();
                Toa toa = Toa_DAO.layToaTheoMaTau_TenToa(tenToa, soHieu);
                Ghe ghe = Ghe_DAO.layGheTheoMaToa_SoGhe(toa.getMaToa(), viTriGhe);
                Ve_DAO veDao = new Ve_DAO();
                logger.info((new Ve(maVe,LocalDateTime.parse(ngayKhoiHanh),LocalDateTime.parse(ngayDatVe),
                      Double.parseDouble(giaVe), ghe.getMaGhe()).toString()));
                veDao.capNhatVeTau(new Ve(maVe,LocalDateTime.parse(ngayKhoiHanh),LocalDateTime.parse(ngayDatVe),
                        Double.parseDouble(giaVe), ghe.getMaGhe()));
            }
        }
        else if(e.getSource() == this.trangThongTinChiTietVeTau.buttonViTriGhe){

            /*
                vị trí ghế
             */

        }
        else if(e.getSource() == this.trangThongTinChiTietVeTau.buttonInVe){
            String maVe = this.trangThongTinChiTietVeTau.textFieldMaVe.getText();
            String tenKhachHang = this.trangThongTinChiTietVeTau.textFieldTenKhachHang.getText();
            String diemDi = this.trangThongTinChiTietVeTau.textFieldDiemDi.getText();
            String diemDen = this.trangThongTinChiTietVeTau.textFieldDiemDen.getText();
            String loaiVe = this.trangThongTinChiTietVeTau.textFieldLoaiVe.getText();
            String doiTuong = this.trangThongTinChiTietVeTau.textFieldLoaiDoiTuong.getText();
            String ngayDatVe = this.trangThongTinChiTietVeTau.textFieldNgayDatVe.getText();
            String ngayKhoiHanh = this.trangThongTinChiTietVeTau.textFieldNgayKhoiHanh.getText();
            String giaVe = this.trangThongTinChiTietVeTau.textFieldGiaVe.getText();
            String viTriGhe = this.trangThongTinChiTietVeTau.textFieldGhe.getText();
            if(JOptionPane.showConfirmDialog(null, "Xác Nhận In Vé ") == JOptionPane.YES_OPTION){
                TaoVeBangFilePDF taoVeBangFilePDF = new TaoVeBangFilePDF();
                taoVeBangFilePDF.generateTicketPDF("D:\\vetau.pdf", maVe,tenKhachHang, diemDi, diemDen, ngayDatVe,
                        ngayKhoiHanh, loaiVe, viTriGhe, doiTuong, giaVe);
                JOptionPane.showMessageDialog(null, "In Vé Thành Công");
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
