package app.dieu_khien;

import app.dao.Ghe_DAO;
import app.giao_dien.TrangSoDoGheMem;
import app.thuc_the.Ghe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class HanhDong_TrangSoDoGheMemDieuHoa implements ItemListener, ActionListener, MouseListener {
    TrangSoDoGheMem trangSoDoGheMemDieuHoa;
    ArrayList<String> soGhe = new ArrayList<String>();

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
        if (soGhe.size() < 10) {
            JButton gheSo = (JButton) e.getSource();
            gheSo.setEnabled(false);

            soGhe.add(gheSo.getText());
        }

        System.out.println(this.trangSoDoGheMemDieuHoa.thanhCacToa.getSelectedItem() + " " + soGhe.get(soGhe.size() - 1));
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
