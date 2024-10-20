package app.dieu_khien;

import app.giao_dien.*;

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
            String loaiGhe = (String) this.trangDatVe.thanhCacLoaiGhe.getSelectedItem();

            switch(loaiGhe) {
                case "Ghế mềm":
                    TrangSoDoGheMem trangSoDoGheMem = new TrangSoDoGheMem();
                    trangSoDoGheMem.setVisible(true);
                    break;
                case "Giường nằm 2 tầng":
                    TrangSoDoGiuong4 trangSoDoGiuong4 = new TrangSoDoGiuong4();
                    trangSoDoGiuong4.setVisible(true);
                    break;
                case "Giường nằm 3 tầng":
                    TrangSoDoGiuong6 trangSoDoGiuong6 = new TrangSoDoGiuong6();
                    trangSoDoGiuong6.setVisible(true);
                    break;
                case "Giường nằm 1 tầng":
                    TrangSoDoGiuong2 trangSoDoGiuong2 = new TrangSoDoGiuong2();
                    trangSoDoGiuong2.setVisible(true);
                    break;
            }
        }

        if (source == this.trangDatVe.nutLuaChonKhuHoi) {
            this.trangDatVe.nutLuaChonMotChieu.setSelected(false);
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

        String loaiGheDaChon[] = new String[10];
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String loaiGheDaChon = (String) e.getItem();

            switch (loaiGheDaChon) {
                case "Ghế phụ":
                    this.trangDatVe.nutHienThiSoDoGhe.setEnabled(false);
                    break;
                default:
                    this.trangDatVe.nutHienThiSoDoGhe.setEnabled(true);
                    break;
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

    public void mouseExited(MouseEvent e) {
        JButton exitedButton = (JButton) e.getComponent();
        exitedButton.setBackground(new Color(this.trangDatVe.xanhBrandeis.getRGB())); // Khôi phục màu ban đầu khi di chuột ra khỏi nút
        exitedButton.setBorder(this.trangDatVe.vienDam);
    }
}
