package app.dieu_khien;

import app.giao_dien.TrangCacTau;
import app.phan_tu_tuy_chinh.NutAnh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HanhDong_TrangCacTau implements ActionListener, MouseListener {
    TrangCacTau trangSoDoChung;

    public HanhDong_TrangCacTau(TrangCacTau trangSoDoChung) {
        this.trangSoDoChung = trangSoDoChung;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) this.trangSoDoChung.trangChua.getLayout();
        String command = e.getActionCommand();

        switch (command) {
            case "Tau 1":
                cardLayout.show(this.trangSoDoChung.trangChua, "Cac toa cua tau 1");
                break;
            case "Tau 2":
                cardLayout.show(this.trangSoDoChung.trangChua, "Cac toa cua tau 2");
                break;
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
}
