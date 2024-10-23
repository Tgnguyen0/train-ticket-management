package app.dieu_khien;

import app.giao_dien.TrangSoDoGiuong6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class HanhDong_TrangSoDoGiuong6 implements ActionListener, MouseListener {
    TrangSoDoGiuong6 trangSoDoGiuong6;

    public HanhDong_TrangSoDoGiuong6(TrangSoDoGiuong6 TrangSoDoGiuong6) {
        this.trangSoDoGiuong6 = TrangSoDoGiuong6;
    }

    public void actionPerformed(ActionEvent e) {
        JButton nutGiuong = (JButton) e.getSource();
        String ghe = nutGiuong.getText();

        // Nếu ghế đã chọn rồi, bỏ chọn (xóa khỏi Set và đổi màu lại)
        if (this.trangSoDoGiuong6.gheDao.layDsGhe().contains(ghe)) {
            this.trangSoDoGiuong6.gheDao.xoaGhe(ghe);
            nutGiuong.setBackground(this.trangSoDoGiuong6.xanhBrandeis);
        }
        // Nếu ghế chưa chọn, thêm vào Set và đổi màu thành đỏ (giới hạn 10 ghế)
        else {
            if (this.trangSoDoGiuong6.gheDao.layDsGhe().size() < 10) {
                this.trangSoDoGiuong6.gheDao.themGhe(ghe);
                nutGiuong.setBackground(this.trangSoDoGiuong6.doDo);
            } else {
                JOptionPane.showMessageDialog(this.trangSoDoGiuong6, "Bạn chỉ có thể chọn tối đa 10 ghế.");
            }
        }

        System.out.println("Ghe da chon (Giuong 6): " + this.trangSoDoGiuong6.gheDao.layDsGhe());
        System.out.println(ghe);
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
        JButton enteredButton = (JButton) e.getComponent();
        enteredButton.setBackground(new Color(this.trangSoDoGiuong6.xanhNhat.getRGB())); // Thay đổi màu khi hover
        enteredButton.setBorder(this.trangSoDoGiuong6.vienNhat);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton exitedButton = (JButton) e.getComponent();
        exitedButton.setBackground(new Color(this.trangSoDoGiuong6.xanhBrandeis.getRGB())); // Khôi phục màu ban đầu khi di chuột ra khỏi nút
        exitedButton.setBorder(this.trangSoDoGiuong6.vienDam);
    }
}
