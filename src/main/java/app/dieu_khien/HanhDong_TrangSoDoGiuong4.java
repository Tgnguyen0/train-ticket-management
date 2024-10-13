package app.dieu_khien;

import app.giao_dien.TrangSoDoGheMem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HanhDong_TrangSoDoGheMemDieuHoa implements ItemListener, ActionListener, MouseListener {
    TrangSoDoGheMem trangSoDoGheMemDieuHoa;

    public HanhDong_TrangSoDoGheMemDieuHoa(TrangSoDoGheMem trangSoDoGheMemDieuHoa) {
        this.trangSoDoGheMemDieuHoa = trangSoDoGheMemDieuHoa;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        CardLayout cardLayout = (CardLayout) this.trangSoDoGheMemDieuHoa.trangChua.getLayout();

        if (e.getStateChange() == ItemEvent.SELECTED) {
            String loaiGheDaChon = (String) e.getItem();

            switch (loaiGheDaChon) {
                case "D1":
                    cardLayout.show(this.trangSoDoGheMemDieuHoa.trangChua, "D1");
                    break;
                case "A4":
                    cardLayout.show(this.trangSoDoGheMemDieuHoa.trangChua, "A4");
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
