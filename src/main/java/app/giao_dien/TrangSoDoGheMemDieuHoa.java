package app.giao_dien;

import app.phong_chu_moi.PhongChuMoi;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TrangSoDoGheMem extends JFrame {
    int gheSo;
    int soGhe;

    /* Khoi Tao Phong Chu Mau Sac */
    public int kichThuocChu = 12;
    public int chieuDaiNut = 210;
    public int chieuRongNut = 30;
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public Color trang = new Color(255, 255, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Border vienNhat = BorderFactory.createLineBorder(xanhNhat);
    public Border vienDam = BorderFactory.createLineBorder(xanhBrandeis);
    public Border gachChanNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhNhat);
    public Border gachChanDam = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis);

    public TrangSoDoGheMem() {
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        taoHangGheBenPhai();
        taoHangGheBenTrai();
    }

    public void taoHangGheBenPhai() {
        JPanel trangHangGheMemBenPhai = new JPanel();
        trangHangGheMemBenPhai.setPreferredSize(new Dimension(800, 300));
        trangHangGheMemBenPhai.setBackground(trang);
        trangHangGheMemBenPhai.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

        taoNutGhe(trangHangGheMemBenPhai);

        add(trangHangGheMemBenPhai, BorderLayout.NORTH);
    }

    public void taoHangGheBenTrai() {
        JPanel trangHangGheMemBenTrai = new JPanel();
        trangHangGheMemBenTrai.setPreferredSize(new Dimension(800, 300));
        trangHangGheMemBenTrai.setBackground(xanhBrandeis);
        trangHangGheMemBenTrai.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

        taoNutGhe(trangHangGheMemBenTrai);

        add(trangHangGheMemBenTrai, BorderLayout.CENTER);
    }

    public void taoNutGhe(JPanel trangDung) {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrangSoDoGheMem trangSoDoGheMem = new TrangSoDoGheMem();
            trangSoDoGheMem.setVisible(true);
        });
    }
}
