package app.dieu_khien;

import app.giao_dien.TrangCacTau;
import app.phan_tu_tuy_chinh.NutAnh;
import app.thuc_the.Ghe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HanhDong_TrangCacTau implements ActionListener, MouseListener, WindowListener {
    TrangCacTau trangSoDoChung;

    public HanhDong_TrangCacTau(TrangCacTau trangSoDoChung) {
        this.trangSoDoChung = trangSoDoChung;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) this.trangSoDoChung.trangChua.getLayout();
        String command = e.getActionCommand();

        switch (command) {
            case "VN5234":
                cardLayout.show(this.trangSoDoChung.trangChua, "Cac toa cua tau 1");
                break;
            case "VN5947":
                cardLayout.show(this.trangSoDoChung.trangChua, "Cac toa cua tau 2");
                break;
        }

        if (e.getSource() == this.trangSoDoChung.nutTau1) {
            this.trangSoDoChung.soHieuTauChon = this.trangSoDoChung.nutTau1.getActionCommand();
        }

        if (e.getSource() == this.trangSoDoChung.nutTau2) {
            this.trangSoDoChung.soHieuTauChon = this.trangSoDoChung.nutTau2.getActionCommand();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();

        if (source == this.trangSoDoChung.nutTau1) {
            // Đặt ảnh cho nút tau1 và đặt lại ảnh gốc cho các nút còn lại
            this.trangSoDoChung.nutTau1.datAnhDangChon();
            this.trangSoDoChung.nutTau2.datAnhMacDinh();
            //this.trangSoDoChung.nutTau3.datAnhMacDinh();
            //this.trangSoDoChung.nutTau4.datAnhMacDinh();


        }

        if (source == this.trangSoDoChung.nutTau2) {
            // Đặt ảnh cho nút tau2 và đặt lại ảnh gốc cho các nút còn lại
            this.trangSoDoChung.nutTau2.datAnhDangChon();
            this.trangSoDoChung.nutTau1.datAnhMacDinh();
            //this.trangSoDoChung.nutTau3.datAnhMacDinh();
            //this.trangSoDoChung.nutTau4.datAnhMacDinh();
        }

        /*if (source == this.trangSoDoChung.nutTau3) {
            // Đặt ảnh cho nút tau3 và đặt lại ảnh gốc cho các nút còn lại
            this.trangSoDoChung.nutTau3.datAnhDangChon();
            this.trangSoDoChung.nutTau1.datAnhMacDinh();
            this.trangSoDoChung.nutTau2.datAnhMacDinh();
            this.trangSoDoChung.nutTau4.datAnhMacDinh();
        }

        if (source == this.trangSoDoChung.nutTau4) {
            // Đặt ảnh cho nút tau4 và đặt lại ảnh gốc cho các nút còn lại
            this.trangSoDoChung.nutTau4.datAnhDangChon();
            this.trangSoDoChung.nutTau1.datAnhMacDinh();
            this.trangSoDoChung.nutTau2.datAnhMacDinh();
            this.trangSoDoChung.nutTau3.datAnhMacDinh();
        }*/
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Không sử dụng
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Không sử dụng
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Không sử dụng
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Không sử dụng
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        if (e.getSource() instanceof TrangCacTau) {
            TrangCacTau trangCacTau = (TrangCacTau) e.getSource();
            trangCacTau.datDaDongChua(true); // Phương thức này sẽ đặt trạng thái "đã đóng"
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
