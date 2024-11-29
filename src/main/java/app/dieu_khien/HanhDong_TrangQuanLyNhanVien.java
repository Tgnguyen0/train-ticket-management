package app.dieu_khien;

import app.dao.NhanVien_DAO;
import app.giao_dien.TrangLichSuTruc;
import app.giao_dien.TrangNhanVien;
import app.giao_dien.TrangQuanLyNhanVien;
import app.thuc_the.GIOI_TINH;
import app.thuc_the.NhanVien;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class HanhDong_TrangQuanLyNhanVien implements ActionListener {
    private TrangQuanLyNhanVien trangQuanLyNhanVien;

    public HanhDong_TrangQuanLyNhanVien(TrangQuanLyNhanVien trangQuanLyNhanVien) {
        this.trangQuanLyNhanVien = trangQuanLyNhanVien;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == trangQuanLyNhanVien.btn_xemLichSuTruc){
            this.xemLichSuTruc();
        } else if (o == trangQuanLyNhanVien.btn_themNV){
            this.themNhanVien();
        } else if (o == trangQuanLyNhanVien.btn_xemToanBo) {
            this.xemToanBo();
        } else if (o == trangQuanLyNhanVien.btn_lamMoi) {
            this.lamMoi();
        }

    }

    private void lamMoi() {
        this.trangQuanLyNhanVien.lamMoi();
    }

    private void xemToanBo() {
        trangQuanLyNhanVien.hienDanhSachNhanVien(NhanVien_DAO.layDSNV());
    }

    private void themNhanVien() {
        String ten = this.trangQuanLyNhanVien.textField_HoTen.getText();
        if(!TrangQuanLyNhanVien.regexTen(ten)){
            return;
        }
        String soDienThoai = this.trangQuanLyNhanVien.textField_SDT.getText();
        if(!TrangQuanLyNhanVien.regexSDT(soDienThoai)){
            return;
        }
        String diaChi = this.trangQuanLyNhanVien.textArea_diaChi.getText();
        if(!TrangQuanLyNhanVien.regexDiaChi(diaChi)){
            return;
        }
        Date ngaySinh = this.trangQuanLyNhanVien.dateChooser.getDate();
        LocalDate ngaySinhLocalDate = ngaySinh.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        GIOI_TINH gioiTinh = GIOI_TINH.NAM;
        if(this.trangQuanLyNhanVien.comboBox_gioiTinh.getSelectedIndex() == 1){
            gioiTinh = GIOI_TINH.NU;
        }
        String vaiTro = "employee";
        if (this.trangQuanLyNhanVien.comboBox_vaiTro.getSelectedIndex() == 1){
            vaiTro = "manager";
        }
        NhanVien nv = new NhanVien(ten, ngaySinhLocalDate, diaChi, soDienThoai, gioiTinh, vaiTro);
        if(NhanVien_DAO.themNhanVien(nv) > 0 ){
            JOptionPane.showMessageDialog(trangQuanLyNhanVien, "Thêm nhân viên thành công");
        } else {
            JOptionPane.showMessageDialog(trangQuanLyNhanVien, "Thêm nhân viên thất bại");
        }
    }

    private void xemLichSuTruc() {
        TrangLichSuTruc trangLichSuTruc = new TrangLichSuTruc();
        trangLichSuTruc.setVisible(true);
    }
}
