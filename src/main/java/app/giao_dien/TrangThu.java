package app.giao_dien;

import app.phong_chu_moi.PhongChuMoi;

import javax.swing.*;
import java.awt.*;

public class TrangThu extends JPanel {
    public int kichThuocChu = 12;
    public int chieuDaiNut = 210;
    public int chieuRongNut = 30;
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public Color trang = new Color(255, 255, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);

    public TrangThu() {
        setPreferredSize(new Dimension(1200, 600));
        setLayout(new BorderLayout());
        setFont(this.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 13));
        setBackground(Color.LIGHT_GRAY);
    }
}
