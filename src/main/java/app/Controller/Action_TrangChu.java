package app.Controller;

import app.gui.TrangChu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Action_TrangChu implements ActionListener, MouseListener {
    TrangChu trangChu ;

    public Action_TrangChu(TrangChu trangChu) {
        this.trangChu = trangChu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) this.trangChu.trangChua.getLayout();
        String command = e.getActionCommand();

        switch (command) {
            case "Trang Chủ":
                cardLayout.show(this.trangChu.trangChua, "Home Page");
                break;
            case "Bán Hàng":
                cardLayout.show(this.trangChu.trangChua, "Sell Page");
                break;
            case "Hóa Đơn":
                cardLayout.show(this.trangChu.trangChua, "Receipt Page");
                break;
            case "Sản Phẩm":
                cardLayout.show(this.trangChu.trangChua, "Product Page");
                break;
            case "Khuyến Mại":
                cardLayout.show(this.trangChu.trangChua, "Promotion Page");
                break;
            case "Thống Kê":
                cardLayout.show(this.trangChu.trangChua, "Statistic Page");
                break;
            case "Nhân Viên":
                cardLayout.show(this.trangChu.trangChua, "Employee Page");
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
        enteredButton.setForeground(new Color(this.trangChu.lightBlue.getRGB())); // Thay đổi màu khi hover
        enteredButton.setBorder(this.trangChu.lightLineBorder);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton exitedButton = (JButton) e.getComponent();
        exitedButton.setForeground(new Color(this.trangChu.brandeisBlue.getRGB())); // Khôi phục màu ban đầu khi di chuột ra khỏi nút
        exitedButton.setBorder(this.trangChu.darkLineBorder);
    }
}
