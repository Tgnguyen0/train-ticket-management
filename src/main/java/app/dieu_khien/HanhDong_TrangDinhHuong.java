package app.dieu_khien;

import app.giao_dien.TrangDinhHuong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HanhDong_TrangDinhHuong implements ActionListener, MouseListener {

        TrangDinhHuong trangDinhHuong;

        public HanhDong_TrangDinhHuong(TrangDinhHuong trangDinhHuong) {
            this.trangDinhHuong = trangDinhHuong;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            CardLayout cardLayout = (CardLayout) this.trangDinhHuong.trangChua.getLayout();
            String command = e.getActionCommand();

            switch (command) {
                case "Trang Chủ":
                    cardLayout.show(this.trangDinhHuong.trangChua, "Home Page");
                    break;
                case "Bán Hàng":
                    cardLayout.show(this.trangDinhHuong.trangChua, "Sell Page");
                    break;
                case "Hóa Đơn":
                    cardLayout.show(this.trangDinhHuong.trangChua, "Receipt Page");
                    break;
                case "Sản Phẩm":
                    cardLayout.show(this.trangDinhHuong.trangChua, "Product Page");
                    break;
                case "Khuyến Mại":
                    cardLayout.show(this.trangDinhHuong.trangChua, "Promotion Page");
                    break;
                case "Thống Kê":
                    cardLayout.show(this.trangDinhHuong.trangChua, "Statistic Page");
                    break;
                case "Nhân Viên":
                    cardLayout.show(this.trangDinhHuong.trangChua, "Employee Page");
                    break;
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton enteredButton = (JButton) e.getComponent();
            enteredButton.setForeground(new Color(this.trangDinhHuong.xanhNhat.getRGB())); // Thay đổi màu khi hover
            enteredButton.setBorder(this.trangDinhHuong.vienNhat);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton exitedButton = (JButton) e.getComponent();
            exitedButton.setForeground(new Color(this.trangDinhHuong.xanhBrandeis.getRGB())); // Khôi phục màu ban đầu khi di chuột ra khỏi nút
            exitedButton.setBorder(this.trangDinhHuong.vienDam);
        }
}
