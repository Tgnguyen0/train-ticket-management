package app.dieu_khien;

import app.giao_dien.TrangSoDoGiuong2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class HanhDong_TrangSoDoGiuong2 implements ItemListener, ActionListener, MouseListener {
    TrangSoDoGiuong2 trangSoDoGiuong2;
    ArrayList<String> soGiuong = new ArrayList<String>();

    public HanhDong_TrangSoDoGiuong2(TrangSoDoGiuong2 trangSoDoGiuong2) {
        this.trangSoDoGiuong2 = trangSoDoGiuong2;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        CardLayout cardLayout = (CardLayout) this.trangSoDoGiuong2.trangChuaSoDoGiuong.getLayout();

        if (e.getStateChange() == ItemEvent.SELECTED) {
            String loaiGheDaChon = (String) e.getItem();
            System.out.println("Selected item: " + loaiGheDaChon);

            switch (loaiGheDaChon) {
                case "D1":
                    cardLayout.show(this.trangSoDoGiuong2.trangChuaSoDoGiuong, "D1");
                    break;
                case "A1":
                    cardLayout.show(this.trangSoDoGiuong2.trangChuaSoDoGiuong, "A1");
                    break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (soGiuong.size() < 10) {
            JButton giuongSo = (JButton) e.getSource();
            giuongSo.setEnabled(false);

            soGiuong.add(giuongSo.getText());
        }

        System.out.println(this.trangSoDoGiuong2.thanhCacToa.getSelectedItem() + " " + soGiuong.get(soGiuong.size() - 1));
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
