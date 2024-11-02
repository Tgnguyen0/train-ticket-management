package app.dieu_khien;

import app.giao_dien.TrangSoDoGiuong2;
import app.thuc_the.Ghe;
import app.thuc_the.TRANG_THAI_GHE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class HanhDong_TrangSoDoGiuong2 implements ActionListener, MouseListener {
    TrangSoDoGiuong2 trangSoDoGiuong2;

    public HanhDong_TrangSoDoGiuong2(TrangSoDoGiuong2 trangSoDoGiuong2) {
        this.trangSoDoGiuong2 = trangSoDoGiuong2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton nutGhe = (JButton) e.getSource();
        int soGhe = Integer.parseInt(nutGhe.getText()) - 1; // -1 để chuyển từ ghế số sang chỉ số mảng
        Ghe ghe = this.trangSoDoGiuong2.dsGiuong.get(soGhe);

        // Nếu ghế đang trống, cho phép chọn hoặc bỏ chọn
        if (ghe.getTrangThai() == TRANG_THAI_GHE.Trong) {
            // Nếu ghế đã chọn rồi, bỏ chọn (xóa khỏi Set và đổi màu lại)
            if (this.trangSoDoGiuong2.giuongDao.layDSGheDat().contains(ghe)) {
                this.trangSoDoGiuong2.giuongDao.xoaGhe(ghe);
                nutGhe.setBackground(this.trangSoDoGiuong2.xanhBrandeis);
            }
            // Nếu ghế chưa chọn, thêm vào Set và đổi màu thành đỏ (giới hạn 10 ghế)
            else {
                if (this.trangSoDoGiuong2.giuongDao.layDSGheDat().size() < 10) {
                    this.trangSoDoGiuong2.giuongDao.themGhe(ghe);
                    nutGhe.setBackground(this.trangSoDoGiuong2.doDo);
                } else {
                    hienThiThongBao("Bạn chỉ có thể chọn tối đa 10 ghế.");
                }
            }
        } else {
            hienThiThongBao("Ghế đã đặt.");
        }

        // In ra danh sách mã ghế đã chọn
        System.out.println("Danh sách mã ghế đã chọn:");
        for (Ghe g : this.trangSoDoGiuong2.giuongDao.layDSGheDat()) {
            System.out.print(" Mã ghế: " + g.getMaGhe());
        }
        System.out.println(); // Để ngắt dòng sau danh sách mã ghế

        System.out.println(ghe);
    }

    // Phương thức hiển thị thông báo lỗi chung
    private void hienThiThongBao(String noiDung) {
        JLabel thongBao = new JLabel(noiDung);
        thongBao.setFont(this.trangSoDoGiuong2.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        JOptionPane hienThiLoi = new JOptionPane(thongBao, JOptionPane.ERROR_MESSAGE);
        hienThiLoi.setForeground(this.trangSoDoGiuong2.xanhBrandeis);

        JDialog hoiThoai = hienThiLoi.createDialog("Thông báo");
        ImageIcon bieuTuongTau = new ImageIcon("assets/icon.png");
        hoiThoai.setIconImage(bieuTuongTau.getImage());
        hoiThoai.setVisible(true);
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
        enteredButton.setBackground(new Color(this.trangSoDoGiuong2.xanhNhat.getRGB())); // Thay đổi màu khi hover
        enteredButton.setBorder(this.trangSoDoGiuong2.vienNhat);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton exitedButton = (JButton) e.getComponent();
        exitedButton.setBackground(new Color(this.trangSoDoGiuong2.xanhBrandeis.getRGB())); // Khôi phục màu ban đầu khi di chuột ra khỏi nút
        exitedButton.setBorder(this.trangSoDoGiuong2.vienDam);
    }
}
