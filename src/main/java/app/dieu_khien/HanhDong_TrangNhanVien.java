package app.dieu_khien;

import app.dao.NhanVien_DAO;
import app.giao_dien.TrangDoiMatKhau;
import app.giao_dien.TrangNhanVien;
import app.thuc_the.GIOI_TINH;
import app.thuc_the.NhanVien;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDate;
import java.util.Date;

public class HanhDong_TrangNhanVien implements ActionListener {
    private TrangNhanVien trangNhanVien;

    public HanhDong_TrangNhanVien(TrangNhanVien trangNhanVien) {
        this.trangNhanVien = trangNhanVien;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Cập nhật thông tin")) {
            this.capNhatThongTin();
        } else if (e.getActionCommand().equals("Đổi mật khẩu")) {
            this.doiMatKhau();
        }
    }

    private void doiMatKhau() {
        TrangDoiMatKhau trangDoiMatKhau = new TrangDoiMatKhau();
        trangDoiMatKhau.setVisible(true);
    }

    private void capNhatThongTin() {
        String ten = trangNhanVien.textField_hoTen.getText();
        String sdt = trangNhanVien.textField_sdt.getText();
        String diaChi = trangNhanVien.textArea_diaChi.getText();
        trangNhanVien.regexCapNhat(ten, sdt, diaChi);
        int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn cập nhật thông tin?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(luaChon == JOptionPane.NO_OPTION) {
            return;
        }
        String ma = trangNhanVien.lable_hienMaNV.getText();
        Date date = trangNhanVien.dateChooser_ngaySinh.getDate();
        LocalDate ngaySinh = LocalDate.of(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
        GIOI_TINH gt = GIOI_TINH.NAM;
        if(trangNhanVien.comboBox_gt.getSelectedItem().equals("Nữ")) {
            gt = GIOI_TINH.NU;
        }
        NhanVien nv = new NhanVien(ma, ten, ngaySinh, diaChi, sdt, gt);
        if(NhanVien_DAO.update(nv)) {
            JOptionPane.showMessageDialog(null, "Cập nhật thông tin thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thông tin thất bại");
        }
    }
}
