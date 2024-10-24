package app.dieu_khien;

import app.giao_dien.TrangCacTau;
import app.giao_dien.TrangCacToa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class HanhDong_TrangCacToa implements ActionListener, MouseListener {
    TrangCacToa trangCacToa;

    public HanhDong_TrangCacToa(TrangCacToa trangCacToa) {
        this.trangCacToa = trangCacToa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) this.trangCacToa.trangChua.getLayout();
        String command = e.getActionCommand();

        switch (command) {
            case "1":
                cardLayout.show(this.trangCacToa.trangChua, "Trang Ghe Mem 1");
                break;
            case "2":
                cardLayout.show(this.trangCacToa.trangChua, "Trang Ghe Mem 2");
                break;
            case "3":
                cardLayout.show(this.trangCacToa.trangChua, "Trang Ghe Mem 3");
                break;
            case "4":
                cardLayout.show(this.trangCacToa.trangChua, "Trang Ghe Mem 4");
                break;
            case "5":
                cardLayout.show(this.trangCacToa.trangChua, "Trang Giuong 6 So 1");
                break;
            case "6":
                cardLayout.show(this.trangCacToa.trangChua, "Trang Giuong 6 So 2");
                break;
            case "7":
                cardLayout.show(this.trangCacToa.trangChua, "Trang Giuong 6 So 3");
                break;
            case "8":
                cardLayout.show(this.trangCacToa.trangChua, "Trang Giuong 4 So 1");
                break;
            case "9":
                cardLayout.show(this.trangCacToa.trangChua, "Trang Giuong 4 So 2");
                break;
            case "10":
                cardLayout.show(this.trangCacToa.trangChua, "Trang Giuong 4 So 3");
                break;
            case "11":
                cardLayout.show(this.trangCacToa.trangChua, "Trang Giuong 2 So 1");
                break;
            case "12":
                cardLayout.show(this.trangCacToa.trangChua, "Trang Giuong 2 So 2");
                break;
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();

        if (source == this.trangCacToa.nutToa1) {
            // Đặt ảnh cho nút tau1 và đặt lại ảnh gốc cho các nút còn lại
            this.trangCacToa.nutToa1.datAnhDangChon();
            this.trangCacToa.nutToa2.datAnhMacDinh();
            this.trangCacToa.nutToa3.datAnhMacDinh();
            this.trangCacToa.nutToa4.datAnhMacDinh();
            this.trangCacToa.nutToa5.datAnhMacDinh();
            this.trangCacToa.nutToa6.datAnhMacDinh();
            this.trangCacToa.nutToa7.datAnhMacDinh();
            this.trangCacToa.nutToa8.datAnhMacDinh();
            this.trangCacToa.nutToa9.datAnhMacDinh();
            this.trangCacToa.nutToa10.datAnhMacDinh();
            this.trangCacToa.nutToa11.datAnhMacDinh();
            this.trangCacToa.nutToa12.datAnhMacDinh();
        }

        if (source == this.trangCacToa.nutToa2) {
            // Đặt ảnh cho nút tau2 và đặt lại ảnh gốc cho các nút còn lại
            this.trangCacToa.nutToa2.datAnhDangChon();
            this.trangCacToa.nutToa1.datAnhMacDinh();
            this.trangCacToa.nutToa3.datAnhMacDinh();
            this.trangCacToa.nutToa4.datAnhMacDinh();
            this.trangCacToa.nutToa5.datAnhMacDinh();
            this.trangCacToa.nutToa6.datAnhMacDinh();
            this.trangCacToa.nutToa7.datAnhMacDinh();
            this.trangCacToa.nutToa8.datAnhMacDinh();
            this.trangCacToa.nutToa9.datAnhMacDinh();
            this.trangCacToa.nutToa10.datAnhMacDinh();
            this.trangCacToa.nutToa11.datAnhMacDinh();
            this.trangCacToa.nutToa12.datAnhMacDinh();
        }

        if (source == this.trangCacToa.nutToa3) {
            // Đặt ảnh cho nút tau2 và đặt lại ảnh gốc cho các nút còn lại
            this.trangCacToa.nutToa3.datAnhDangChon();
            this.trangCacToa.nutToa1.datAnhMacDinh();
            this.trangCacToa.nutToa2.datAnhMacDinh();
            this.trangCacToa.nutToa4.datAnhMacDinh();
            this.trangCacToa.nutToa5.datAnhMacDinh();
            this.trangCacToa.nutToa6.datAnhMacDinh();
            this.trangCacToa.nutToa7.datAnhMacDinh();
            this.trangCacToa.nutToa8.datAnhMacDinh();
            this.trangCacToa.nutToa9.datAnhMacDinh();
            this.trangCacToa.nutToa10.datAnhMacDinh();
            this.trangCacToa.nutToa11.datAnhMacDinh();
            this.trangCacToa.nutToa12.datAnhMacDinh();
        }

        if (source == this.trangCacToa.nutToa4) {
            // Đặt ảnh cho nút tau2 và đặt lại ảnh gốc cho các nút còn lại
            this.trangCacToa.nutToa4.datAnhDangChon();
            this.trangCacToa.nutToa1.datAnhMacDinh();
            this.trangCacToa.nutToa2.datAnhMacDinh();
            this.trangCacToa.nutToa3.datAnhMacDinh();
            this.trangCacToa.nutToa5.datAnhMacDinh();
            this.trangCacToa.nutToa6.datAnhMacDinh();
            this.trangCacToa.nutToa7.datAnhMacDinh();
            this.trangCacToa.nutToa8.datAnhMacDinh();
            this.trangCacToa.nutToa9.datAnhMacDinh();
            this.trangCacToa.nutToa10.datAnhMacDinh();
            this.trangCacToa.nutToa11.datAnhMacDinh();
            this.trangCacToa.nutToa12.datAnhMacDinh();
        }

        if (source == this.trangCacToa.nutToa5) {
            // Đặt ảnh cho nút tau2 và đặt lại ảnh gốc cho các nút còn lại
            this.trangCacToa.nutToa5.datAnhDangChon();
            this.trangCacToa.nutToa1.datAnhMacDinh();
            this.trangCacToa.nutToa2.datAnhMacDinh();
            this.trangCacToa.nutToa3.datAnhMacDinh();
            this.trangCacToa.nutToa4.datAnhMacDinh();
            this.trangCacToa.nutToa6.datAnhMacDinh();
            this.trangCacToa.nutToa7.datAnhMacDinh();
            this.trangCacToa.nutToa8.datAnhMacDinh();
            this.trangCacToa.nutToa9.datAnhMacDinh();
            this.trangCacToa.nutToa10.datAnhMacDinh();
            this.trangCacToa.nutToa11.datAnhMacDinh();
            this.trangCacToa.nutToa12.datAnhMacDinh();
        }

        if (source == this.trangCacToa.nutToa6) {
            // Đặt ảnh cho nút tau2 và đặt lại ảnh gốc cho các nút còn lại
            this.trangCacToa.nutToa6.datAnhDangChon();
            this.trangCacToa.nutToa1.datAnhMacDinh();
            this.trangCacToa.nutToa2.datAnhMacDinh();
            this.trangCacToa.nutToa3.datAnhMacDinh();
            this.trangCacToa.nutToa4.datAnhMacDinh();
            this.trangCacToa.nutToa5.datAnhMacDinh();
            this.trangCacToa.nutToa7.datAnhMacDinh();
            this.trangCacToa.nutToa8.datAnhMacDinh();
            this.trangCacToa.nutToa9.datAnhMacDinh();
            this.trangCacToa.nutToa10.datAnhMacDinh();
            this.trangCacToa.nutToa11.datAnhMacDinh();
            this.trangCacToa.nutToa12.datAnhMacDinh();
        }

        if (source == this.trangCacToa.nutToa7) {
            // Đặt ảnh cho nút tau2 và đặt lại ảnh gốc cho các nút còn lại
            this.trangCacToa.nutToa7.datAnhDangChon();
            this.trangCacToa.nutToa1.datAnhMacDinh();
            this.trangCacToa.nutToa2.datAnhMacDinh();
            this.trangCacToa.nutToa3.datAnhMacDinh();
            this.trangCacToa.nutToa4.datAnhMacDinh();
            this.trangCacToa.nutToa5.datAnhMacDinh();
            this.trangCacToa.nutToa6.datAnhMacDinh();
            this.trangCacToa.nutToa8.datAnhMacDinh();
            this.trangCacToa.nutToa9.datAnhMacDinh();
            this.trangCacToa.nutToa10.datAnhMacDinh();
            this.trangCacToa.nutToa11.datAnhMacDinh();
            this.trangCacToa.nutToa12.datAnhMacDinh();
        }

        if (source == this.trangCacToa.nutToa8) {
            // Đặt ảnh cho nút tau2 và đặt lại ảnh gốc cho các nút còn lại
            this.trangCacToa.nutToa8.datAnhDangChon();
            this.trangCacToa.nutToa1.datAnhMacDinh();
            this.trangCacToa.nutToa2.datAnhMacDinh();
            this.trangCacToa.nutToa3.datAnhMacDinh();
            this.trangCacToa.nutToa4.datAnhMacDinh();
            this.trangCacToa.nutToa5.datAnhMacDinh();
            this.trangCacToa.nutToa6.datAnhMacDinh();
            this.trangCacToa.nutToa7.datAnhMacDinh();
            this.trangCacToa.nutToa9.datAnhMacDinh();
            this.trangCacToa.nutToa10.datAnhMacDinh();
            this.trangCacToa.nutToa11.datAnhMacDinh();
            this.trangCacToa.nutToa12.datAnhMacDinh();
        }

        if (source == this.trangCacToa.nutToa9) {
            // Đặt ảnh cho nút tau2 và đặt lại ảnh gốc cho các nút còn lại
            this.trangCacToa.nutToa9.datAnhDangChon();
            this.trangCacToa.nutToa1.datAnhMacDinh();
            this.trangCacToa.nutToa2.datAnhMacDinh();
            this.trangCacToa.nutToa3.datAnhMacDinh();
            this.trangCacToa.nutToa4.datAnhMacDinh();
            this.trangCacToa.nutToa5.datAnhMacDinh();
            this.trangCacToa.nutToa6.datAnhMacDinh();
            this.trangCacToa.nutToa7.datAnhMacDinh();
            this.trangCacToa.nutToa8.datAnhMacDinh();
            this.trangCacToa.nutToa10.datAnhMacDinh();
            this.trangCacToa.nutToa11.datAnhMacDinh();
            this.trangCacToa.nutToa12.datAnhMacDinh();
        }

        if (source == this.trangCacToa.nutToa10) {
            // Đặt ảnh cho nút tau2 và đặt lại ảnh gốc cho các nút còn lại
            this.trangCacToa.nutToa10.datAnhDangChon();
            this.trangCacToa.nutToa1.datAnhMacDinh();
            this.trangCacToa.nutToa2.datAnhMacDinh();
            this.trangCacToa.nutToa3.datAnhMacDinh();
            this.trangCacToa.nutToa4.datAnhMacDinh();
            this.trangCacToa.nutToa5.datAnhMacDinh();
            this.trangCacToa.nutToa6.datAnhMacDinh();
            this.trangCacToa.nutToa7.datAnhMacDinh();
            this.trangCacToa.nutToa8.datAnhMacDinh();
            this.trangCacToa.nutToa9.datAnhMacDinh();
            this.trangCacToa.nutToa11.datAnhMacDinh();
            this.trangCacToa.nutToa12.datAnhMacDinh();
        }

        if (source == this.trangCacToa.nutToa11) {
            // Đặt ảnh cho nút tau2 và đặt lại ảnh gốc cho các nút còn lại
            this.trangCacToa.nutToa11.datAnhDangChon();
            this.trangCacToa.nutToa1.datAnhMacDinh();
            this.trangCacToa.nutToa2.datAnhMacDinh();
            this.trangCacToa.nutToa3.datAnhMacDinh();
            this.trangCacToa.nutToa4.datAnhMacDinh();
            this.trangCacToa.nutToa5.datAnhMacDinh();
            this.trangCacToa.nutToa6.datAnhMacDinh();
            this.trangCacToa.nutToa7.datAnhMacDinh();
            this.trangCacToa.nutToa8.datAnhMacDinh();
            this.trangCacToa.nutToa9.datAnhMacDinh();
            this.trangCacToa.nutToa10.datAnhMacDinh();
            this.trangCacToa.nutToa12.datAnhMacDinh();
        }

        if (source == this.trangCacToa.nutToa12) {
            // Đặt ảnh cho nút tau2 và đặt lại ảnh gốc cho các nút còn lại
            this.trangCacToa.nutToa12.datAnhDangChon();
            this.trangCacToa.nutToa1.datAnhMacDinh();
            this.trangCacToa.nutToa2.datAnhMacDinh();
            this.trangCacToa.nutToa3.datAnhMacDinh();
            this.trangCacToa.nutToa4.datAnhMacDinh();
            this.trangCacToa.nutToa5.datAnhMacDinh();
            this.trangCacToa.nutToa6.datAnhMacDinh();
            this.trangCacToa.nutToa7.datAnhMacDinh();
            this.trangCacToa.nutToa8.datAnhMacDinh();
            this.trangCacToa.nutToa9.datAnhMacDinh();
            this.trangCacToa.nutToa10.datAnhMacDinh();
            this.trangCacToa.nutToa11.datAnhMacDinh();
        }
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
