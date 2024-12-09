package app.dieu_khien;

import app.dao.NhanVien_DAO;
import app.giao_dien.TrangLichSuTruc;
import app.giao_dien.TrangQuanLyNhanVien;
import app.giao_dien.TrangXacNhanThuHoiTaiKhoan;
import app.thuc_the.GIOI_TINH;
import app.thuc_the.NhanVien;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.Date;

public class HanhDong_TrangQuanLyNhanVien implements ActionListener, MouseListener {
    private TrangQuanLyNhanVien trangQuanLyNhanVien;

    public HanhDong_TrangQuanLyNhanVien(TrangQuanLyNhanVien trangQuanLyNhanVien) {
        this.trangQuanLyNhanVien = trangQuanLyNhanVien;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == trangQuanLyNhanVien.btn_xemLichSuTruc) {
            this.xemLichSuTruc();
        } else if (o == trangQuanLyNhanVien.btn_themNV) {
            this.themNhanVien();
        } else if (o == trangQuanLyNhanVien.btn_xemToanBo) {
            this.xemToanBo();
        } else if (o == trangQuanLyNhanVien.btn_lamMoi) {
            this.lamMoi();
        } else if (o == trangQuanLyNhanVien.btn_lamTrongDanhSach) {
            this.lamTrongDanhSach();
        } else if (o == trangQuanLyNhanVien.btn_tim) {
            this.timKiem();
        } else if (o == trangQuanLyNhanVien.btn_capNhat) {
            this.capNhat();
        } else if (o == trangQuanLyNhanVien.btn_thuHoiTK) {
            this.thuHoi();
        }

    }

    private void thuHoi() {
        String maNV = TrangQuanLyNhanVien.label_hienThiMaNV.getText();
        String regexMaNV = "NV\\d{4}";
        if (!maNV.matches(regexMaNV)) {
            JOptionPane.showMessageDialog(trangQuanLyNhanVien, "Vui lòng chọn nhân viên cần thu hồi");
            return;
        }
        JOptionPane.showMessageDialog(trangQuanLyNhanVien, "SAU KHI THU HỒI TÀI KHOẢN, TÀI KHOẢN SẼ BỊ KHÓA VÀ KHÔNG THỂ SỬ DỤNG LẠI");
        int luaChon = JOptionPane.showConfirmDialog(trangQuanLyNhanVien, "BẠN CÓ CHẮC CHẮN MUỐN THU HỒI TÀI KHOẢN NÀY KHÔNG?", "THÔNG BÁO", JOptionPane.YES_NO_OPTION);
        if (luaChon == JOptionPane.NO_OPTION) {
            return;
        }
        TrangXacNhanThuHoiTaiKhoan trangXacNhanThuHoiTaiKhoan = new TrangXacNhanThuHoiTaiKhoan();
        trangXacNhanThuHoiTaiKhoan.setVisible(true);
    }

    private void capNhat() {
        String maNV = TrangQuanLyNhanVien.label_hienThiMaNV.getText();
        if (maNV.equals("<mã nhân viên>")){
            JOptionPane.showMessageDialog(trangQuanLyNhanVien, "Vui lòng chọn nhân viên cần cập nhật");
            return;
        }
        String ten = this.trangQuanLyNhanVien.textField_HoTen.getText();
        ten = ten.trim();
        if (!TrangQuanLyNhanVien.regexTen(ten)) {
            return;
        }
        ten = ten.trim().replaceAll("\\s+", " ");
        String[] words = ten.split(" ");
        StringBuilder tenTuInHoa = new StringBuilder();
        // Lặp qua từng từ trong chuỗi
        for (String word : words) {
            if (word.length() > 0) {
                // In hoa chữ cái đầu và nối phần còn lại
                tenTuInHoa.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase()).append(" ");
            }
        }

        String soDienThoai = this.trangQuanLyNhanVien.textField_SDT.getText();
        soDienThoai = soDienThoai.trim();
        if (!TrangQuanLyNhanVien.regexSDT(soDienThoai)) {
            return;
        }
        String diaChi = this.trangQuanLyNhanVien.textArea_diaChi.getText();
        diaChi = diaChi.trim();
        if (!TrangQuanLyNhanVien.regexDiaChi(diaChi)) {
            return;
        }
        Date ngaySinh = this.trangQuanLyNhanVien.dateChooser.getDate();
        if(!trangQuanLyNhanVien.regex_birthDay()){
            return;
        }
        LocalDate ngaySinhLocalDate = ngaySinh.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        GIOI_TINH gioiTinh = GIOI_TINH.NAM;
        if (this.trangQuanLyNhanVien.comboBox_gioiTinh.getSelectedIndex() == 1) {
            gioiTinh = GIOI_TINH.NU;
        }
        String vaiTro = "employee";
        if (this.trangQuanLyNhanVien.comboBox_vaiTro.getSelectedIndex() == 1) {
            vaiTro = "manager";
        }
        NhanVien nv = new NhanVien(maNV, tenTuInHoa.toString(), ngaySinhLocalDate, diaChi, soDienThoai, gioiTinh, vaiTro);
        NhanVien_DAO.capNhatChiTietNhanVien(nv);
        JOptionPane.showMessageDialog(trangQuanLyNhanVien, "Cập nhật thành công");
        trangQuanLyNhanVien.hienMotNhanVien(nv);
    }

    private void timKiem() {
        String ten = trangQuanLyNhanVien.textField_timTen.getText();
        String soDienThoai = trangQuanLyNhanVien.textField_timSDT.getText();

        if (ten.equals("") && soDienThoai.equals("")) {
            JOptionPane.showMessageDialog(trangQuanLyNhanVien, "Vui lòng nhập tên hoặc số điện thoại");
            return;
        }
        if (soDienThoai.equals("")) {
            trangQuanLyNhanVien.hienDanhSachNhanVien(NhanVien_DAO.timTenNhanVien(ten));
        } else if (ten.equals("")) {
            trangQuanLyNhanVien.hienDanhSachNhanVien(NhanVien_DAO.timKiemTheoSDT(soDienThoai));
        } else {
            trangQuanLyNhanVien.hienDanhSachNhanVien(NhanVien_DAO.timKiemTheoTenVaSDT(ten, soDienThoai));
        }
    }

    private void lamTrongDanhSach() {
        trangQuanLyNhanVien.lamTrongDS();
    }

    private void lamMoi() {
        this.trangQuanLyNhanVien.lamMoi();
    }

    private void xemToanBo() {
        trangQuanLyNhanVien.hienDanhSachNhanVien(NhanVien_DAO.layDSNV());
    }

    private void themNhanVien() {
        String ten = this.trangQuanLyNhanVien.textField_HoTen.getText();
        ten = ten.trim().replaceAll("\\s+", " ");
        String[] words = ten.split(" ");
        StringBuilder tenTuInHoa = new StringBuilder();

        // Lặp qua từng từ trong chuỗi
        for (String word : words) {
            if (word.length() > 0) {
                // In hoa chữ cái đầu và nối phần còn lại
                tenTuInHoa.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase()).append(" ");
            }
        }
        if (!TrangQuanLyNhanVien.regexTen(ten)) {
            return;
        }
        String soDienThoai = this.trangQuanLyNhanVien.textField_SDT.getText();
        if (!TrangQuanLyNhanVien.regexSDT(soDienThoai)) {
            return;
        }
        String diaChi = this.trangQuanLyNhanVien.textArea_diaChi.getText();
        if (!TrangQuanLyNhanVien.regexDiaChi(diaChi)) {
            return;
        }
        Date ngaySinh = this.trangQuanLyNhanVien.dateChooser.getDate();
        if(!trangQuanLyNhanVien.regex_birthDay()){
            return;
        }
        LocalDate ngaySinhLocalDate = ngaySinh.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        GIOI_TINH gioiTinh = GIOI_TINH.NAM;
        if (this.trangQuanLyNhanVien.comboBox_gioiTinh.getSelectedIndex() == 1) {
            gioiTinh = GIOI_TINH.NU;
        }
        String vaiTro = "employee";
        if (this.trangQuanLyNhanVien.comboBox_vaiTro.getSelectedIndex() == 1) {
            vaiTro = "manager";
        }
        NhanVien nv = new NhanVien(tenTuInHoa.toString(), ngaySinhLocalDate, diaChi, soDienThoai, gioiTinh, vaiTro);
        NhanVien_DAO.themNhanVien(nv);
        JOptionPane.showMessageDialog(trangQuanLyNhanVien, "Thêm nhân viên thành công");

    }

    private void xemLichSuTruc() {
        if(TrangQuanLyNhanVien.label_hienThiMaNV.getText().equals("<mã nhân viên>")){
            JOptionPane.showMessageDialog(trangQuanLyNhanVien, "Vui lòng chọn nhân viên cần xem lịch sử trực");
            return;
        }
        TrangQuanLyNhanVien.maNV = TrangQuanLyNhanVien.label_hienThiMaNV.getText();
        TrangLichSuTruc trangLichSuTruc = new TrangLichSuTruc();
        trangLichSuTruc.hienDanhSachTruc(TrangQuanLyNhanVien.maNV);
        trangLichSuTruc.datMaVaTenNhanVien(TrangQuanLyNhanVien.maNV, trangQuanLyNhanVien.textField_HoTen.getText());
        trangLichSuTruc.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == trangQuanLyNhanVien.table) {
            int row = trangQuanLyNhanVien.table.getSelectedRow();
            String maNV = (String) trangQuanLyNhanVien.table.getValueAt(row, 1);
            NhanVien nv = NhanVien_DAO.layThongTinNV(maNV);
            if(nv.getTenDangNhap().equals("Đã thu hồi")){
                TrangQuanLyNhanVien.label_hienThiMaNV.setText(nv.getMaNV() + " (Đã thu hồi)");
            } else {
                TrangQuanLyNhanVien.label_hienThiMaNV.setText(nv.getMaNV());
            }
            trangQuanLyNhanVien.textField_HoTen.setText(nv.getTenNV());
            trangQuanLyNhanVien.textField_SDT.setText(nv.getSoDT());
            trangQuanLyNhanVien.textArea_diaChi.setText(nv.getDiaChi());
            trangQuanLyNhanVien.dateChooser.setDate(Date.from(nv.getNgaySinh().atStartOfDay(java.time.ZoneId.systemDefault()).toInstant()));
            if (nv.getGioiTinh() == GIOI_TINH.NAM) {
                trangQuanLyNhanVien.comboBox_gioiTinh.setSelectedIndex(0);
            } else {
                trangQuanLyNhanVien.comboBox_gioiTinh.setSelectedIndex(1);
            }
            if (nv.getVaiTro().equals("employee")) {
                trangQuanLyNhanVien.comboBox_vaiTro.setSelectedIndex(0);
            } else {
                trangQuanLyNhanVien.comboBox_vaiTro.setSelectedIndex(1);
            }
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