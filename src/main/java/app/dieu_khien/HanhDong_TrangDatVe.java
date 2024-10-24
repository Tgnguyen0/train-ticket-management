package app.dieu_khien;

import app.giao_dien.*;
import app.thuc_the.GIOI_TINH;
import app.thuc_the.Ghe;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.ZoneId;

public class HanhDong_TrangDatVe implements ActionListener, MouseListener, ItemListener {
    TrangDatVe trangDatVe;

    public HanhDong_TrangDatVe(TrangDatVe trangDatVe) {
        this.trangDatVe = trangDatVe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == this.trangDatVe.nutHienThiSoDoGhe) {
            TrangCacTau trangCacTau = new TrangCacTau(this.trangDatVe.layGheDao());
            trangCacTau.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            trangCacTau.setVisible(true);
        }

        if (source == this.trangDatVe.nutLuaChonMotChieu) {
            this.trangDatVe.nutLuaChonKhuHoi.setSelected(false);
            this.trangDatVe.thanhNhapNgayTroVe.setEnabled(false);
        }

        if (source == this.trangDatVe.nutLuaChonKhuHoi) {
            this.trangDatVe.nutLuaChonMotChieu.setSelected(false);
            this.trangDatVe.thanhNhapNgayTroVe.setEnabled(true);
        }

        if (source == this.trangDatVe.nutLuaChonMotChieu) {
            this.trangDatVe.nutLuaChonKhuHoi.setSelected(false);
        }

        if (source == this.trangDatVe.nutLuaChonNam) {
            this.trangDatVe.nutLuaChonNu.setSelected(false);
        }

        if (source == this.trangDatVe.nutLuaChonNu) {
            this.trangDatVe.nutLuaChonNam.setSelected(false);
        }

        if(source == this.trangDatVe.nutDSVe){
            TrangDanhSachVeTau.moGiaoDienDanhSach();
        }

        String diemDi = (String) trangDatVe.thanhCacDiemDi.getSelectedItem();
        String diemDen = (String) trangDatVe.thanhCacDiemDen.getSelectedItem();
        String loaiVe = trangDatVe.nutLuaChonKhuHoi.isSelected() ? "Khu Hoi" : "Mot Chieu";

        LocalDate ngayKhoiHanh = trangDatVe.thanhNhapNgayDi
                .getDate()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate ngayTroVe = trangDatVe.thanhNhapNgayTroVe
                .getDate()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        int soLuongTreEm = Integer.parseInt(trangDatVe.thanhSoLuongTreEm.getText());
        int soLuongNguoiLon = Integer.parseInt(trangDatVe.thanhSoLuongNguoiLon.getText());

        String hoTen = this.trangDatVe.thanhNhapHoTen.getText();
        String sdt = this.trangDatVe.thanhNhapDienThoai.getText();
        String email = this.trangDatVe.thanhNhapThuDienTu.getText();

        LocalDate ngaySinh = trangDatVe.thanhNhapNgaySinh
                .getDate()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        GIOI_TINH gioiTinh = trangDatVe.nutLuaChonNam.isSelected() ? GIOI_TINH.NAM : GIOI_TINH.NU;

        for (int i = 0 ; i < this.trangDatVe.layGheDao().layDsGhe().size(); i++) {

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String loaiGheDaChon = (String) e.getItem();

            if (this.trangDatVe.thanhCacDiemDen.getSelectedItem().equals(this.trangDatVe.thanhCacDiemDi.getSelectedItem())) {
                JLabel thongBao = new JLabel("Bạn chỉ có thể chọn tối đa 10 ghế.");
                thongBao.setFont(this.trangDatVe.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));

                JOptionPane hienThiLoi = new JOptionPane(thongBao, JOptionPane.ERROR_MESSAGE);
                hienThiLoi.setForeground(this.trangDatVe.xanhBrandeis);

                JDialog hoiThoai = hienThiLoi.createDialog("Lỗi chọn ghế");
                ImageIcon bieuTuongTau = new ImageIcon("assets/icon.png"); // Đường dẫn đến biểu tượng
                hoiThoai.setIconImage(bieuTuongTau.getImage());
                hoiThoai.setVisible(true);
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
        JButton enteredButton = (JButton) e.getComponent();
        enteredButton.setBackground(new Color(this.trangDatVe.xanhNhat.getRGB())); // Thay đổi màu khi hover
        enteredButton.setBorder(this.trangDatVe.vienNhat);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton exitedButton = (JButton) e.getComponent();
        exitedButton.setBackground(new Color(this.trangDatVe.xanhBrandeis.getRGB())); // Khôi phục màu ban đầu khi di chuột ra khỏi nút
        exitedButton.setBorder(this.trangDatVe.vienDam);
    }
}
