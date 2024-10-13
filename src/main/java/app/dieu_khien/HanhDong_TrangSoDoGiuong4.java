package app.dieu_khien;

import app.giao_dien.TrangSoDoGiuong4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HanhDong_TrangSoDoGiuong4 implements ItemListener, ActionListener, MouseListener {
    TrangSoDoGiuong4 TrangSoDoGiuong4;

    public HanhDong_TrangSoDoGiuong4(TrangSoDoGiuong4 TrangSoDoGiuong4) {
        this.TrangSoDoGiuong4 = TrangSoDoGiuong4;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        CardLayout cardLayout = (CardLayout) this.TrangSoDoGiuong4.trangChuaSoDoGiuong.getLayout();

        if (e.getStateChange() == ItemEvent.SELECTED) {
            String loaiGheDaChon = (String) e.getItem();
            System.out.println("Selected item: " + loaiGheDaChon);

            switch (loaiGheDaChon) {
                case "D1":
                    cardLayout.show(this.TrangSoDoGiuong4.trangChuaSoDoGiuong, "D1");
                    break;
                case "A1":
                    cardLayout.show(this.TrangSoDoGiuong4.trangChuaSoDoGiuong, "A1");
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
