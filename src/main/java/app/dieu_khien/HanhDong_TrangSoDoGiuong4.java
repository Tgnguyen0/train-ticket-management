package app.dieu_khien;

import app.giao_dien.TrangSoDoGiuong4;
import app.phan_tu_tuy_chinh.GanAmThanh;
import app.thuc_the.Ghe;
import app.thuc_the.TRANG_THAI_GHE;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        GanAmThanh.playSound();

        JButton nutGhe = (JButton) e.getSource();
        int soGhe = Integer.parseInt(nutGhe.getText()) - 1; // -1 để chuyển từ ghế số sang chỉ số mảng
        Ghe ghe = this.trangSoDoGiuong4.dsGiuong.get(soGhe);

        // Nếu ghế đang trống, cho phép chọn hoặc bỏ chọn
        if (ghe.getTrangThai() == TRANG_THAI_GHE.Trong) {
            // Nếu ghế đã chọn rồi, bỏ chọn (xóa khỏi Set và đổi màu lại)
            if (this.trangSoDoGiuong4.giuongDao.layDSGheDat().contains(ghe)) {
                this.trangSoDoGiuong4.giuongDao.xoaGhe(ghe);
                nutGhe.setBackground(this.trangSoDoGiuong4.xanhBrandeis);
            } else {
                if (this.trangSoDoGiuong4.giuongDao.layDSGheDat().size() > this.trangSoDoGiuong4.giuongDao.laySoGheToiDa() - 1) {
                    hienThiThongBao("Không được chọn quá số lượng khách đặt");
                    return;
                }

                this.trangSoDoGiuong4.giuongDao.themGhe(ghe);
                this.trangSoDoGiuong4.giuongDao.datGheChon(ghe);
                nutGhe.setBackground(this.trangSoDoGiuong4.camNhuomDen);
            }
        } else {
            hienThiThongBao("Ghế đã đặt.");
        }

        // In ra danh sách mã ghế đã chọn
        System.out.println("Danh sách mã ghế đã chọn:");
        for (Ghe g : this.trangSoDoGiuong4.giuongDao.layDSGheDat()) {
            System.out.print(" Mã ghế: " + g.getMaGhe());
        }
        System.out.println(); // Để ngắt dòng sau danh sách mã ghế

        System.out.println(ghe);
    }

    // Phương thức hiển thị thông báo lỗi chung
    private void hienThiThongBao(String noiDung) {
        JLabel thongBao = new JLabel(noiDung);
        thongBao.setFont(this.trangSoDoGiuong4.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        JOptionPane hienThiLoi = new JOptionPane(thongBao, JOptionPane.ERROR_MESSAGE);
        hienThiLoi.setForeground(this.trangSoDoGiuong4.xanhBrandeis);

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
