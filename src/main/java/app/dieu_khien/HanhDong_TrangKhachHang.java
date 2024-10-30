package app.dieu_khien;

import app.dao.KhachHang_DAO;
import app.giao_dien.TrangDatVe;
import app.giao_dien.TrangDinhHuong;
import app.giao_dien.TrangKhachHang;
import app.thuc_the.GIOI_TINH;
import app.thuc_the.KhachHang;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


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
        } else if (e.getActionCommand().equals("Làm trống danh sách")) {
            this.lamMoiDanhSach();
        } else if (e.getActionCommand().equals("Xem toàn bộ")){
            this.trangKhachHang.layToanBoKhachHang();
        } else if (e.getActionCommand().equals("Thêm khách hàng")) {
            this.themKH();
        } else if (e.getActionCommand().equals("Thêm vào hàng chờ")) {
            this.trangKhachHang.themVaoHangCho();
        } else if (e.getActionCommand().equals("Xoá khỏi hàng")) {
            this.xoaKhoiHangCho();
        } else if (e.getActionCommand().equals("Đặt vé")) {
            this.datVe();
        }
    }

    public boolean datVe() {
        int row = this.trangKhachHang.table_hangCho.getRowCount();
        this.trangKhachHang.dsHangCho = new ArrayList<>();
        if(row == 0){
            JOptionPane.showMessageDialog(null, "Hàng chờ trống!");
        } else {
           for (int i = 0; i < row; i++) {
               trangKhachHang.dsHangCho.add(KhachHang_DAO.timTheoMaKH_KhangVersion(this.trangKhachHang.table_hangCho.getValueAt(i, 0).toString()));
           }
           this.trangKhachHang.clearTable(trangKhachHang.table_hangCho);
           this.lamMoi();
           this.lamMoiDanhSach();
           this.trangKhachHang.hide();

           ((TrangDatVe) TrangDinhHuong.getTrangChua().getComponent(1)).datDSKhDatVe(this.trangKhachHang.dsHangCho);

           CardLayout cardLayout = (CardLayout) TrangDinhHuong.getTrangChua().getLayout();
           cardLayout.show(TrangDinhHuong.getTrangChua(), "Trang Dat Ve");

            String hoTen = ((TrangDatVe) TrangDinhHuong.getTrangChua().getComponent(1)).dsKHDatVe.get(0).getTenKH();
            ((TrangDatVe) TrangDinhHuong.getTrangChua().getComponent(1)).thanhNhapHoTen.setText(hoTen);

            String sdt = ((TrangDatVe) TrangDinhHuong.getTrangChua().getComponent(1)).dsKHDatVe.get(0).getSoDT();
            ((TrangDatVe) TrangDinhHuong.getTrangChua().getComponent(1)).thanhNhapDienThoai.setText(sdt);

            String email = ((TrangDatVe) TrangDinhHuong.getTrangChua().getComponent(1)).dsKHDatVe.get(0).getEmail();
            ((TrangDatVe) TrangDinhHuong.getTrangChua().getComponent(1)).thanhNhapThuDienTu.setText(email);

            GIOI_TINH gioiTinh = ((TrangDatVe) TrangDinhHuong.getTrangChua().getComponent(1)).dsKHDatVe.get(0).getGioiTinh();

            if (gioiTinh.getValue().equals("Nam")) {
                ((TrangDatVe) TrangDinhHuong.getTrangChua().getComponent(1)).nutLuaChonNam.setSelected(true);
                ((TrangDatVe) TrangDinhHuong.getTrangChua().getComponent(1)).nutLuaChonNu.setSelected(false);
            } else {
                ((TrangDatVe) TrangDinhHuong.getTrangChua().getComponent(1)).nutLuaChonNam.setSelected(false);
                ((TrangDatVe) TrangDinhHuong.getTrangChua().getComponent(1)).nutLuaChonNu.setSelected(true);
            }

           return true;
        }
        return false;
    }

    public void xoaKhoiHangCho() {
        int row = this.trangKhachHang.table_hangCho.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng trong hàng chờ!");
        } else {
            DefaultTableModel model = (DefaultTableModel) this.trangKhachHang.table_hangCho.getModel();
            model.removeRow(row);
        }
    }

    private void themKH() {
        String ten = trangKhachHang.textField_HoTen.getText();
        ten = ten.trim().replaceAll("\\s+", " ");
        String[] words = ten.split(" ");
        StringBuilder tenKhachHangTuInHoa = new StringBuilder();

        // Lặp qua từng từ trong chuỗi
        for (String word : words) {
            if (word.length() > 0) {
                // In hoa chữ cái đầu và nối phần còn lại
                tenKhachHangTuInHoa.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase()).append(" ");
            }
        }
        String sdt = trangKhachHang.textField_SDT.getText();
        String diaChi = trangKhachHang.textArea_diaChi.getText();
        String email = trangKhachHang.textField_email.getText();
        if(!trangKhachHang.regexTen(ten) || !trangKhachHang.regexDiaChi(diaChi) || !trangKhachHang.regexSDT(sdt) || !trangKhachHang.regexEmail(email)){
            return;
        }
        int luaChon = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn thêm khách hàng này?" , "Xác nhận thêm", JOptionPane.YES_NO_OPTION);
        if (luaChon == JOptionPane.NO_OPTION) {
            return;
        }

        String gioiTinh = trangKhachHang.comboBox_gioiTinh.getSelectedItem().toString();
        GIOI_TINH gt = GIOI_TINH.NAM;
        if(gioiTinh.equals("Nữ")){
            gt = GIOI_TINH.NU;
        }


        KhachHang khachHang = new KhachHang(tenKhachHangTuInHoa.toString().trim(), diaChi, sdt, email, gt);
        System.out.println(khachHang.toString() + " " + khachHang.getGioiTinh().getValue());
        if(KhachHang_DAO.themKhachHang(khachHang) > 0){
            JOptionPane.showMessageDialog(null, "Thêm khách hàng mới thành công!");
            this.lamMoi();
        } else {
            JOptionPane.showMessageDialog(null, "Thêm khách hàng mới thất bại!");
        }
        lamMoiDanhSach();
        this.trangKhachHang.hienKhachHangVuaThem(KhachHang_DAO.layCuoiDanhSach());
    }

    private void lamMoiDanhSach() {
        this.trangKhachHang.clearTable(trangKhachHang.table);
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
        lamMoi();
    }

    public void tim() {
        KhachHang_DAO khachHang_dao = new KhachHang_DAO();
        trangKhachHang.dsKH = new ArrayList<>();
        String timTen = trangKhachHang.textField_timTen.getText();
        String timEmail = trangKhachHang.textField_timEmail.getText();
        String timSDT = trangKhachHang.textField_timSDT.getText();
        if (timTen.isEmpty() && timSDT.isEmpty() && timEmail.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin tìm kiếm!");
            return;
        } else if (timEmail.equals("") && timSDT.equals("")) {
            trangKhachHang.dsKH = khachHang_dao.tim_ten(timTen);
        } else if (timTen.equals("") && timEmail.equals("")) {
            trangKhachHang.dsKH = khachHang_dao.tim_sdt(timSDT);
        } else if (timTen.equals("") && timSDT.equals("")) {
            trangKhachHang.dsKH = khachHang_dao.tim_email(timEmail);
        } else if (timSDT.equals("")){
            trangKhachHang.dsKH = khachHang_dao.tim_ten_email(timTen, timEmail);
        } else if (timTen.equals("")){
            trangKhachHang.dsKH = khachHang_dao.tim_sdt_email(timSDT, timEmail);
        } else if (timEmail.equals("")){
            trangKhachHang.dsKH = khachHang_dao.tim_ten_sdt(timTen, timSDT);
        }
        else {
            trangKhachHang.dsKH = khachHang_dao.tim_ten_sdt_email(timTen, timSDT, timEmail);
        }
        if (trangKhachHang.dsKH.size() == 0) {
            int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm khách hàng mới không?", "Không tìm thấy khách hàng!", JOptionPane.YES_NO_OPTION);
            if (luaChon == JOptionPane.YES_OPTION) {
                trangKhachHang.textField_SDT.setText(timSDT);
                trangKhachHang.textField_email.setText(timEmail);
                trangKhachHang.textField_HoTen.setText(timTen);
                lamMoiTimKiem();
            } else {
                return;
            }
        }

        trangKhachHang.hienDanhSachKhachHangRaBang(trangKhachHang.dsKH);
    }
    public void lamMoiTimKiem(){
        trangKhachHang.textField_timTen.setText("");
        trangKhachHang.textField_timSDT.setText("");
        trangKhachHang.textField_timEmail.setText("");
    }
}
