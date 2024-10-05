package app.giao_dien;

import app.phong_chu_moi.PhongChuMoi;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TrangSoDoGiuong6 extends JFrame {

    /* Khoi Tao Phong Chu Mau Sac */
    public int kichThuocChu = 13;
    public int chieuDaiNut = 50;
    public int chieuRongNut = 50;
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public Color trang = new Color(255, 255, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Border vienNhat = BorderFactory.createLineBorder(xanhNhat);
    public Border vienDam = BorderFactory.createLineBorder(xanhBrandeis);
    public Border gachChanNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhNhat);
    public Border gachChanDam = BorderFactory.createMatteBorder(5, 5, 5, 5, xanhBrandeis);


    public TrangSoDoGiuong6() {
        ImageIcon icon = new ImageIcon("assets/icon.png");

        setSize(new Dimension(800, 400));
        setIconImage(icon.getImage());
        setBackground(trang);
        setLocationRelativeTo(null);
        setTitle("Sơ đồ ghế");
        setLayout(new BorderLayout());
        setResizable(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            TrangSoDoGiuong6 trangMoi = new TrangSoDoGiuong6();
            trangMoi.setVisible(true);
        });
    }
}
