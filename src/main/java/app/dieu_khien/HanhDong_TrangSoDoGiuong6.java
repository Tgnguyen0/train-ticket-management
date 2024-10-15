package app.dieu_khien;

import app.giao_dien.TrangSoDoGiuong6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HanhDong_TrangSoDoGiuong6 implements ItemListener, ActionListener, MouseListener {
    TrangSoDoGiuong6 trangSoDoGiuong6;

    public HanhDong_TrangSoDoGiuong6(TrangSoDoGiuong6 TrangSoDoGiuong6) {
        this.trangSoDoGiuong6 = TrangSoDoGiuong6;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        CardLayout cardLayout = (CardLayout) this.trangSoDoGiuong6.trangChuaSoDoGiuong.getLayout();

        if (e.getStateChange() == ItemEvent.SELECTED) {
            String loaiGheDaChon = (String) e.getItem();
            System.out.println("Selected item: " + loaiGheDaChon);

            switch (loaiGheDaChon) {
                case "D1":
                    cardLayout.show(this.trangSoDoGiuong6.trangChuaSoDoGiuong, "D1");
                    break;
                case "A1":
                    cardLayout.show(this.trangSoDoGiuong6.trangChuaSoDoGiuong, "A1");
                    break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton gheSo = (JButton) e.getSource();
        gheSo.setEnabled(false);
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
