package app.dieu_khien;

import app.dao.KhachHang_DAO;
import app.giao_dien.TrangKhachHang;
import app.thuc_the.GIOI_TINH;
import app.thuc_the.KhachHang;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Locale;


public class HanhDong_TrangKhachHang implements ActionListener, MouseListener {
    private TrangKhachHang trangKhachHang;

    public HanhDong_TrangKhachHang(TrangKhachHang trangKhachHang) {
        this.trangKhachHang = trangKhachHang;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Tìm")) {
            this.tim();
        } else if (e.getActionCommand().equals("Làm mới")) {
            this.lamMoi();
        } else if (e.getActionCommand().equals("Cập nhật")) {
            this.capNhat();
        } else if (e.getActionCommand().equals("Làm mới danh sách")) {
            this.lamMoiDanhSach();
        } else if (e.getActionCommand().equals("Thêm khách hàng")){
            this.themKH();
        }
    }

    private void themKH() {
        String ten = trangKhachHang.textField_HoTen.getText();
        String sdt = trangKhachHang.textField_SDT.getText();
        String diaChi = trangKhachHang.textArea_diaChi.getText();
        String gioiTinh = trangKhachHang.comboBox_gioiTinh.getSelectedItem().toString();
        if(gioiTinh.equals("Nữ")){
            gioiTinh ="NU";
        } else {
            gioiTinh ="NAM";
        }
        GIOI_TINH gt = GIOI_TINH.valueOf(gioiTinh);
        String email = trangKhachHang.textField_email.getText();
        KhachHang khachHang = new KhachHang(ten, diaChi, sdt, email, gt); System.out.println(khachHang.toString());
        if(KhachHang_DAO.themKhachHang(khachHang) > 0){
            JOptionPane.showMessageDialog(null, "Thêm khách hàng mới thành công!");
        } else {
            JOptionPane.showMessageDialog(null, "Thêm khách hàng mới thất bại!");
        }
        lamMoiDanhSach();
    }

    private void lamMoiDanhSach() {
        trangKhachHang.layToanBoKhachHang();
        trangKhachHang.textField_timTen.setText("");
        trangKhachHang.textField_timSDT.setText("");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.trangKhachHang.table) {
            int row = this.trangKhachHang.table.getSelectedRow();
            String maKH = this.trangKhachHang.table.getValueAt(row, 1).toString();
            String tenKH = this.trangKhachHang.table.getValueAt(row, 2).toString();
            String soDT = this.trangKhachHang.table.getValueAt(row, 3).toString();
            String gioiTinh = this.trangKhachHang.table.getValueAt(row, 4).toString();
            String email = this.trangKhachHang.table.getValueAt(row, 5).toString();
            String diaChi = this.trangKhachHang.table.getValueAt(row, 6).toString();
            if (gioiTinh.equals(GIOI_TINH.NAM.getValue())) {
                this.trangKhachHang.comboBox_gioiTinh.setSelectedIndex(0);
            } else {
                this.trangKhachHang.comboBox_gioiTinh.setSelectedIndex(1);
            }
            this.trangKhachHang.label_hienThiMaKH.setText(maKH);
            this.trangKhachHang.textField_HoTen.setText(tenKH);
            this.trangKhachHang.textArea_diaChi.setText(diaChi);
            this.trangKhachHang.textField_SDT.setText(soDT);
            this.trangKhachHang.textField_email.setText(email);

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

    public void lamMoi() {
        trangKhachHang.label_hienThiMaKH.setText("<mã khách hàng>");
        trangKhachHang.textField_HoTen.setText("");
        trangKhachHang.textField_SDT.setText("");
        trangKhachHang.textField_email.setText("");
        trangKhachHang.textField_email.setText("");
        trangKhachHang.textArea_diaChi.setText("");
    }

    public void capNhat() {
        String maKH = trangKhachHang.label_hienThiMaKH.getText();
        String tenKH = trangKhachHang.textField_HoTen.getText();
        tenKH = tenKH.trim().replaceAll("\\s+", " ");
        String[] words = tenKH.split(" ");
        StringBuilder tenKhachHangTuInHoa = new StringBuilder();

        // Lặp qua từng từ trong chuỗi
        for (String word : words) {
            if (word.length() > 0) {
                // In hoa chữ cái đầu và nối phần còn lại
                tenKhachHangTuInHoa.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase()).append(" ");
            }
        }
        String diaChi = trangKhachHang.textArea_diaChi.getText();
        String soDT = trangKhachHang.textField_SDT.getText();
        String email = trangKhachHang.textField_email.getText();
        GIOI_TINH gioiTinh = GIOI_TINH.NAM;
        if (trangKhachHang.comboBox_gioiTinh.getSelectedIndex() == 1) {
            gioiTinh = GIOI_TINH.NU;
        }
        if (!trangKhachHang.regexTen(tenKH) || !trangKhachHang.regexDiaChi(diaChi) || !trangKhachHang.regexSDT(soDT) || !trangKhachHang.regexEmail(email)) {
            return;
        }
        int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn cập nhật?", "Xác nhận cập nhật", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.NO_OPTION) {
            return;
        }
        KhachHang kh = new KhachHang(maKH, tenKhachHangTuInHoa.toString().trim(), diaChi, soDT, email, gioiTinh);
        KhachHang_DAO khachHang_dao = new KhachHang_DAO();
        khachHang_dao.capNhatKhachHang_KhangVersion(kh);
        trangKhachHang.layToanBoKhachHang();
    }

    public void tim() {
        KhachHang_DAO khachHang_dao = new KhachHang_DAO();
        trangKhachHang.dsKH = new ArrayList<>();
        String timTen = trangKhachHang.textField_timTen.getText();

        String timSDT = trangKhachHang.textField_timSDT.getText();
        if (timTen.isEmpty() && timSDT.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên hoặc số điện thoại để tìm kiếm");
            return;
        } else if (timSDT.isEmpty()) {
            if (!trangKhachHang.regexTimTen(timTen)) {
                return;
            }
            trangKhachHang.dsKH = khachHang_dao.timTheoTen_KhangVersion(timTen);
        } else if (timTen.isEmpty()) {
            if (!trangKhachHang.regexSDT(timSDT)) {
                return;
            }
            trangKhachHang.dsKH = khachHang_dao.timTheoSDT_KhangVersion(timSDT);
        } else {
            if (!trangKhachHang.regexTimTen(timTen) || !trangKhachHang.regexSDT(timSDT)) {
                return;
            }
            trangKhachHang.dsKH = khachHang_dao.timTheoTenVaSDT_KhangVersion(timTen, timSDT);
        }

        trangKhachHang.hienDanhSachKhachHangRaBang(trangKhachHang.dsKH);
    }
}
