package app.dieu_khien;

import app.giao_dien.TrangDatVe;
import app.giao_dien.TrangSoDoGheMem;
import app.giao_dien.TrangSoDoGiuong4;
import app.giao_dien.TrangSoDoGiuong6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
                case "Ghế phụ":
                    break;
                case "Ghế mềm":
                    TrangSoDoGheMem trangSoDoGheMem = new TrangSoDoGheMem();
                    trangSoDoGheMem.setVisible(true);
                    break;
                case "Giường nằm 4 tầng":
                    TrangSoDoGiuong4 trangSoDoGiuong4 = new TrangSoDoGiuong4();
                    trangSoDoGiuong4.setVisible(true);
                    break;
                case "Giường nằm 6 tầng":
                    TrangSoDoGiuong6 trangSoDoGiuong6 = new TrangSoDoGiuong6();
                    trangSoDoGiuong6.setVisible(true);
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
