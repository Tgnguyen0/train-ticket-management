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

    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) this.trangDinhHuong.trangChua.getLayout();
        String command = e.getActionCommand();

        switch (command) {
            case "Trang Chủ":
                cardLayout.show(this.trangDinhHuong.trangChua, "Trang Chu");
                break;
            case "Đặt Vé":
                cardLayout.show(this.trangDinhHuong.trangChua, "Trang Dat Ve");
                break;
            case "Giới Thiệu":
                cardLayout.show(this.trangDinhHuong.trangChua, "Trang Gioi Thieu");
                break;
        }
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    public void mouseEntered(MouseEvent e) {
        if (e.getComponent() instanceof JButton) {
            JButton enteredButton = (JButton) e.getComponent();
            enteredButton.setForeground(new Color(this.trangDinhHuong.xanhNhat.getRGB())); // Thay đổi màu khi hover
            enteredButton.setBorder(this.trangDinhHuong.vienNhat);
        }

        if (e.getComponent() instanceof JTextField) {
            JTextField enteredTextField = (JTextField) e.getComponent();
            enteredTextField.setBorder(this.trangDinhHuong.vienNhat); // Thay đổi màu khi hover
        }

    }

    public void mouseExited(MouseEvent e) {
        if (e.getComponent() instanceof JButton) {
            JButton exitedButton = (JButton) e.getComponent();
            exitedButton.setForeground(new Color(this.trangDinhHuong.xanhBrandeis.getRGB())); // Khôi phục màu ban đầu khi di chuột ra khỏi nút
            exitedButton.setBorder(this.trangDinhHuong.vienDam);
        }

        if (e.getComponent() instanceof JTextField) {
            JTextField exitedTextField = (JTextField) e.getComponent();
            exitedTextField.setBorder(this.trangDinhHuong.vienDam); // Khôi phục màu ban đầu khi di chuột ra khỏi nút
        }
    }
}