package app.giao_dien;

import app.dao.Ghe_DAO;
import app.dieu_khien.HanhDong_TrangSoDoGheMemDieuHoa;
import app.phong_chu_moi.PhongChuMoi;
import app.thuc_the.Ghe;
import app.thuc_the.TRANG_THAI_GHE;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TrangSoDoGheMem extends JPanel {
    public JPanel trangChua;
    public JComboBox<String> thanhCacToa;
    public int kichThuocChu = 13;
    public int chieuDaiNut = 50;
    public int chieuRongNut = 50;
    public PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public Color trang = new Color(255, 255, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Color camNhuomDen = new Color(253, 126, 20);
    public Color doDo = new Color(220, 53, 69);
    public Border vienNhat = BorderFactory.createLineBorder(xanhNhat);
    public Border vienDam = BorderFactory.createLineBorder(xanhBrandeis);

    public ActionListener hanhDong;
    public MouseListener thaoTacChuot;

    public Ghe_DAO gheDao;
    public Set<Ghe> gheDaDat;
    public List<Ghe> dsGhe;
    public String tenToa;
    public String maToa;

    public TrangSoDoGheMem(List<Ghe> dsGhe, Ghe_DAO gheDao, String tenToa, String maToa) {
        this.dsGhe = dsGhe;
        this.tenToa = tenToa;
        this.gheDao = gheDao;
        this.maToa = maToa;

        setSize(new Dimension(800, 300));
        setBackground(trang);
        setLayout(new BorderLayout());

        this.hanhDong = new HanhDong_TrangSoDoGheMemDieuHoa(this);
        this.thaoTacChuot = new HanhDong_TrangSoDoGheMemDieuHoa(this);

        taoTrangTieuDe();
        taoTrangChuaCacSoDoGhe();
        taoTrangHuongDan();
    }

    public void taoTrangTieuDe() {
        JPanel trangTieuDe = new JPanel(new FlowLayout(FlowLayout.CENTER));
        trangTieuDe.setPreferredSize(new Dimension(800, 40));
        trangTieuDe.setBackground(trang);

        JLabel tieuDe = new JLabel("Sơ đồ toa ghế mềm " + this.tenToa, SwingConstants.CENTER);
        tieuDe.setPreferredSize(new Dimension(800, 40));
        tieuDe.setForeground(xanhBrandeis);
        tieuDe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 18));
        trangTieuDe.add(tieuDe);

        add(trangTieuDe, BorderLayout.NORTH);
    }

    public void taoTrangChuaCacSoDoGhe() {
        JPanel trangChuaCacSoDoGhe = new JPanel(new FlowLayout(FlowLayout.CENTER));
        trangChuaCacSoDoGhe.setPreferredSize(new Dimension(800, 100));
        trangChuaCacSoDoGhe.setBackground(trang);

        trangChuaCacSoDoGhe.add(taoTrangSoDoGhe());
        add(trangChuaCacSoDoGhe, BorderLayout.CENTER);
    }

    public JPanel taoTrangSoDoGhe() {
        JPanel trangSoDoGhe = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        trangSoDoGhe.setPreferredSize(new Dimension(810, 400));
        trangSoDoGhe.setBackground(trang);
        xepNutGhe(trangSoDoGhe);
        return trangSoDoGhe;
    }

    private void xepNutGhe(JPanel trangDung) {
        int soGhe = dsGhe.size();
        List<Ghe> dsGheDaDat = new ArrayList<>(gheDao.layDSGheDat());

        for (int j = 1; j <= soGhe; j++) {
            JPanel chuaGheDoc = new JPanel(new GridLayout(2, 1, 5, 10));
            JPanel chua2GheDocTren = new JPanel(new GridLayout(2, 1, 0, 1));
            JPanel chua2GheDocDuoi = new JPanel(new GridLayout(2, 1, 0, 1));

            for (int i = 0; i <= 3 && 4 * (j - 1) < soGhe; i++) {
                JButton ghe = taoNutGhe(j, i, dsGheDaDat);

                if (i <= 1) {
                    chua2GheDocTren.add(ghe);
                } else {
                    chua2GheDocDuoi.add(ghe);
                }
            }

            if (j % 2 == 0) {
                chuaGheDoc.add(chua2GheDocDuoi);
                chuaGheDoc.add(chua2GheDocTren);
            } else {
                chuaGheDoc.add(chua2GheDocTren);
                chuaGheDoc.add(chua2GheDocDuoi);
            }

            trangDung.add(chuaGheDoc);
        }
    }

    private JButton taoNutGhe(int j, int i, List<Ghe> dsGheDaDat) {
        JButton ghe = new JButton(String.valueOf(4 * (j - 1) + i + 1));
        ghe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        ghe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        ghe.setForeground(trang);
        ghe.setBackground(datMauGhe(j, i, dsGheDaDat));
        ghe.setFocusPainted(false);
        ghe.setBorderPainted(false);
        ghe.addActionListener(this.hanhDong);
        return ghe;
    }

    private Color datMauGhe(int j, int i, List<Ghe> dsGheDaDat) {
        Ghe gheHienTai = dsGhe.get(4 * (j - 1) + i);
        if (gheHienTai.getTrangThai() == TRANG_THAI_GHE.Da_dat) {
            return doDo;
        }
        for (Ghe gheDaDat : dsGheDaDat) {
            if (gheDaDat.getSoGhe().equals(gheHienTai.getSoGhe()) && gheDaDat.getMaToa().equals(this.maToa)) {
                return camNhuomDen;
            }
        }
        return xanhBrandeis;
    }

    public void taoTrangHuongDan() {
        JPanel trangHuongDan = new JPanel(new FlowLayout(FlowLayout.CENTER));
        trangHuongDan.setPreferredSize(new Dimension(800, 140));
        trangHuongDan.setBackground(trang);

        themBieuTuongVaTieuDe(trangHuongDan, "Ghế trống", xanhBrandeis);
        themBieuTuongVaTieuDe(trangHuongDan, "Ghế đã mua", doDo);
        themBieuTuongVaTieuDe(trangHuongDan, "Ghế chọn", camNhuomDen);

        add(trangHuongDan, BorderLayout.SOUTH);
    }

    private void themBieuTuongVaTieuDe(JPanel trangHienTai, String cau, Color mau) {
        JPanel trangChuaTieuDeVaBieuTuong = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        trangChuaTieuDeVaBieuTuong.setPreferredSize(new Dimension(250, chieuRongNut));
        trangChuaTieuDeVaBieuTuong.setBackground(trang);

        JButton nutBieuTuong = new JButton("");
        nutBieuTuong.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        nutBieuTuong.setBackground(mau);
        nutBieuTuong.setForeground(trang);
        nutBieuTuong.setFocusPainted(false);
        nutBieuTuong.setBorderPainted(false);

        JLabel tieuDe = new JLabel(cau, SwingConstants.LEFT);
        tieuDe.setPreferredSize(new Dimension(140, chieuRongNut));
        tieuDe.setForeground(xanhBrandeis);
        tieuDe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));

        trangChuaTieuDeVaBieuTuong.add(nutBieuTuong);
        trangChuaTieuDeVaBieuTuong.add(tieuDe);

        trangHienTai.add(trangChuaTieuDeVaBieuTuong);
    }
}