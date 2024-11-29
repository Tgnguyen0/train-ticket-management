package app.dieu_khien;

import app.dao.CaTruc_DAO;
import app.dao.NhanVien_DAO;
import app.giao_dien.TrangDoiMatKhau;
import app.giao_dien.TrangKetCa;
import app.giao_dien.TrangNhanVien;
import app.giao_dien.TrangQuanLyNhanVien;
import app.thuc_the.CaTruc;
import app.thuc_the.GIOI_TINH;
import app.thuc_the.NhanVien;
import com.lowagie.text.Table;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class HanhDong_TrangNhanVien implements ActionListener, PropertyChangeListener {
    private TrangNhanVien trangNhanVien;

    public HanhDong_TrangNhanVien(TrangNhanVien trangNhanVien) {
        this.trangNhanVien = trangNhanVien;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (e.getActionCommand().equals("Cập nhật thông tin")) {
            this.capNhatThongTin();
        } else if (e.getActionCommand().equals("Đổi mật khẩu")) {
            this.doiMatKhau();
        } else if (e.getActionCommand().equals("Kết ca")) {
            this.ketCa();
        } else if (o == trangNhanVien.btn_quanLyNV) {
            this.quanLyNhanVien();
        }
    }

    private void quanLyNhanVien() {
        TrangQuanLyNhanVien trangQuanLyNhanVien = new TrangQuanLyNhanVien();
        trangQuanLyNhanVien.setVisible(true);
    }


    private void ketCa() {
        int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn kết ca?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (luaChon == JOptionPane.NO_OPTION) {
            return;
        } else if (luaChon == JOptionPane.CLOSED_OPTION) {
            return;
        }
        TrangKetCa trangKetCa = new TrangKetCa();
        trangKetCa.setVisible(true);

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
        if (!trangNhanVien.regex_birthDay()) {
            return;
        }
        int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn cập nhật thông tin?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (luaChon == JOptionPane.NO_OPTION) {
            return;
        } else if (luaChon == JOptionPane.CLOSED_OPTION) {
            return;
        }
        String ma = trangNhanVien.lable_hienMaNV.getText();
        Date date = trangNhanVien.dateChooser_ngaySinh.getDate();
        LocalDate ngaySinh = LocalDate.of(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
        GIOI_TINH gt = GIOI_TINH.NAM;
        if (trangNhanVien.comboBox_gt.getSelectedItem().equals("Nữ")) {
            gt = GIOI_TINH.NU;
        }
        NhanVien nv = new NhanVien(ma, ten, ngaySinh, diaChi, sdt, gt);
        NhanVien_DAO.update(nv);
        JOptionPane.showMessageDialog(null, "Cập nhật thông tin thành công");

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object newValue = evt.getNewValue();
        if (newValue instanceof Date) {
            LocalDateTime date = ((Date) newValue).toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            if (date != null) {
                this.hienLichSuTruc(date, trangNhanVien.lable_hienMaNV.getText());
            }
        }
    }

    private void hienLichSuTruc(LocalDateTime date, String maNV) {
        ArrayList<CaTruc> dsCaTruc = CaTruc_DAO.layCaTrucTheoNgay(date, maNV);
        trangNhanVien.tableModel.setRowCount(0);
        for (CaTruc ct : dsCaTruc) {
            trangNhanVien.tableModel.addRow(new Object[]{ct.getNgayGioBatDau(), ct.getNgayGioKetThuc()});
        }
    }
}
