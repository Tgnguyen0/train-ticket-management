package app.dieu_khien;

import app.giao_dien.TrangSoDoGiuong4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class HanhDong_TrangSoDoGiuong4 implements ActionListener, MouseListener {
    TrangSoDoGiuong4 trangSoDoGiuong4;
    ArrayList<String> soGiuong = new ArrayList<String>();

    public HanhDong_TrangSoDoGiuong4(TrangSoDoGiuong4 TrangSoDoGiuong4) {
        this.trangSoDoGiuong4 = TrangSoDoGiuong4;
    }

    public void actionPerformed(ActionEvent e) {
        JButton nutGiuong = (JButton) e.getSource();
        String ghe = nutGiuong.getText();

        // Nếu ghế đã chọn rồi, bỏ chọn (xóa khỏi Set và đổi màu lại)
        if (this.trangSoDoGiuong4.gheDao.layDsGhe().contains(ghe)) {
            this.trangSoDoGiuong4.gheDao.xoaGhe(ghe);
            nutGiuong.setBackground(this.trangSoDoGiuong4.xanhBrandeis);
        }
        // Nếu ghế chưa chọn, thêm vào Set và đổi màu thành đỏ (giới hạn 10 ghế)
        else {
            if (this.trangSoDoGiuong4.gheDao.layDsGhe().size() < 10) {
                this.trangSoDoGiuong4.gheDao.themGhe(ghe);
                nutGiuong.setBackground(this.trangSoDoGiuong4.doDo);
            } else {
                JLabel thongBao = new JLabel("Bạn chỉ có thể chọn tối đa 10 ghế.");
                thongBao.setFont(this.trangSoDoGiuong4.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));

                JOptionPane hienThiLoi = new JOptionPane(thongBao, JOptionPane.ERROR_MESSAGE);
                hienThiLoi.setForeground(this.trangSoDoGiuong4.xanhBrandeis);

                JDialog hoiThoai = hienThiLoi.createDialog("Lỗi chọn ghế");
                ImageIcon bieuTuongTau = new ImageIcon("assets/icon.png"); // Đường dẫn đến biểu tượng
                hoiThoai.setIconImage(bieuTuongTau.getImage());
                hoiThoai.setVisible(true);
            }
        }

        System.out.println("Ghe da chon (Giuong 4): " + this.trangSoDoGiuong4.gheDao.layDsGhe());
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
        enteredButton.setBackground(new Color(this.trangSoDoGiuong4.xanhNhat.getRGB())); // Thay đổi màu khi hover
        enteredButton.setBorder(this.trangSoDoGiuong4.vienNhat);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton exitedButton = (JButton) e.getComponent();
        exitedButton.setBackground(new Color(this.trangSoDoGiuong4.xanhBrandeis.getRGB())); // Khôi phục màu ban đầu khi di chuột ra khỏi nút
        exitedButton.setBorder(this.trangSoDoGiuong4.vienDam);
    }
}
