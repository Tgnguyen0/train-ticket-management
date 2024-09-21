package app.giao_dien;

import app.phong_chu_moi.PhongChuMoi;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class TrangDatVe extends JPanel {
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public Color trang = new Color(255, 255, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    public Border vienNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(xanhNhat.getRGB()));
    public Border vienDam = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(xanhBrandeis.getRGB()));
    private ActionListener hanhDong;
    private MouseListener thaoTacChuot;

    public TrangDatVe() {
        setPreferredSize(new Dimension(1200, 600));
        setLayout(new BorderLayout());
        setFont(this.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 13));

        taoDonThongTinVe();
        taoTrangThongTinKhachHang();
        taoDanhSachVe();
    }

    private void taoDonThongTinVe() {
        JPanel trangChuaDonDat = new JPanel();
        trangChuaDonDat.setPreferredSize(new Dimension(600, 600));
        trangChuaDonDat.setBackground(new Color(0, 255, 255));
        trangChuaDonDat.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

        JPanel donDatVe = new JPanel();
        donDatVe.setPreferredSize(new Dimension(500, 500));
        trangChuaDonDat.add(donDatVe);

        JLabel tieuDeDiemDi = new JLabel();
        tieuDeDiemDi.setForeground(xanhBrandeis);
        tieuDeDiemDi.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        donDatVe.add(tieuDeDiemDi);

        add(trangChuaDonDat, BorderLayout.WEST);
    }

    private void taoTrangThongTinKhachHang() {
        JPanel trangChuaDonTT = new JPanel();
        trangChuaDonTT.setPreferredSize(new Dimension(600, 600));
        trangChuaDonTT.setLayout(new BorderLayout());

        JPanel donThongTinKH = new JPanel();
        donThongTinKH.setBackground(new Color(100, 255, 255));
        donThongTinKH.setPreferredSize(new Dimension(400, 600));
        trangChuaDonTT.add(donThongTinKH, BorderLayout.WEST);

        JPanel cachBang = new JPanel();
        cachBang.setOpaque(false);
        cachBang.setPreferredSize(new Dimension(200, 600));
        trangChuaDonTT.add(cachBang, BorderLayout.CENTER);

        add(trangChuaDonTT, BorderLayout.CENTER);
    }

    private void taoDanhSachVe() {
        JPanel danhSachVe = new JPanel();
        danhSachVe.setPreferredSize(new Dimension(1200, 50));
        danhSachVe.setBackground(new Color(255, 255, 255));

        add(danhSachVe, BorderLayout.NORTH);
    }
}
