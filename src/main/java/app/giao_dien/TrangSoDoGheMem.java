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
import java.util.Set;
import java.util.List;

public class TrangSoDoGheMem extends JPanel {
    /**/
    public JPanel trangChua;
    public JComboBox<String> thanhCacToa;

    int soGhe;

    /* Khoi Tao Phong Chu Mau Sac */
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
    public Border gachChanNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhNhat);
    public Border gachChanDam = BorderFactory.createMatteBorder(5, 5, 5, 5, xanhBrandeis);

    /**/
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
        JPanel trangTieuDe = new JPanel();
        trangTieuDe.setLayout(new FlowLayout(FlowLayout.CENTER));
        trangTieuDe.setPreferredSize(new Dimension(800, 40));
        trangTieuDe.setBackground(trang);

        JLabel tieuDe = new JLabel("Sơ đồ toa ghế mềm " + this.tenToa, SwingConstants.CENTER);
        tieuDe.setPreferredSize(new Dimension(800, 40));
        tieuDe.setForeground(xanhBrandeis);
        tieuDe.setBackground(trang);
        tieuDe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 18));
        trangTieuDe.add(tieuDe);

        add(trangTieuDe, BorderLayout.NORTH);
    }

    public void taoTrangChuaCacSoDoGhe() {
        JPanel trangChuaCacSoDoGhe = new JPanel();
        trangChuaCacSoDoGhe.setLayout(new FlowLayout(FlowLayout.CENTER));
        trangChuaCacSoDoGhe.setPreferredSize(new Dimension(800, 100));
        trangChuaCacSoDoGhe.setBackground(trang);

        JPanel soDoGheToa = taoTrangSoDoGhe();
        trangChuaCacSoDoGhe.add(soDoGheToa);

        add(trangChuaCacSoDoGhe, BorderLayout.CENTER);
    }

    public JPanel taoTrangSoDoGhe() {
        JPanel trangSoDoGhe = new JPanel();
        trangSoDoGhe.setBackground(trang);
        trangSoDoGhe.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

        xepNutGhe(trangSoDoGhe);

        return trangSoDoGhe;
    }

    public void xepNutGhe(JPanel trangDung) {
        int soGhe = dsGhe.size();
        List<Ghe> dsGheDaDat = new ArrayList<>(gheDao.layDSGheDat());

        dsGhe.get(0).setTrangThai(TRANG_THAI_GHE.Da_dat);
        dsGhe.get(7).setTrangThai(TRANG_THAI_GHE.Da_dat);
        for (int j = 1; j <= soGhe; j++) {
            JPanel chuaGheDoc = new JPanel();
            chuaGheDoc.setLayout(new GridLayout(2, 1, 5, 10));

            JPanel chua2GheDocTren = new JPanel();
            chua2GheDocTren.setLayout(new GridLayout(2, 1, 0, 1));

            JPanel chua2GheDocDuoi = new JPanel();
            chua2GheDocDuoi.setLayout(new GridLayout(2, 1, 0, 1));

            if (j % 2 != 0) {
                for (int i = 0; i <= 3 && 4 * (j - 1) < soGhe; i++) {
                    JButton ghe = new JButton(String.valueOf(4 * (j - 1) + i + 1)); // Tạo nút với tên ghế
                    ghe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut)); // Thiết lập kích thước nút
                    ghe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
                    ghe.setForeground(trang); // Đặt màu chữ

                    if (dsGhe.get(4 * (j - 1) + i).getTrangThai() == TRANG_THAI_GHE.Trong) {
                        ghe.setBackground(xanhBrandeis);
                    } else {
                        ghe.setBackground(doDo);
                    }

                    if (!gheDao.layDSGheDat().isEmpty()) {
                        for (int k = 0 ; k < dsGheDaDat.size() ; k++) {
                            if (dsGheDaDat.get(k).getSoGhe().equals(String.valueOf(4 * (j - 1) + i + 1)) &&
                            dsGheDaDat.get(k).getMaToa().equals(this.maToa)) {
                                ghe.setBackground(camNhuomDen);
                            }
                        }
                    }

                    //ghe.setBackground(datMauNenTheoDSGhe(j, i));
                    //ghe.setBackground(datMauNenTheoGheDaDat(j, i));
                    ghe.setFocusPainted(false); // Bỏ viền khi click (focus)
                    ghe.setBorderPainted(false);
                    ghe.addActionListener(this.hanhDong);

                    if (i <= 1) {
                        chua2GheDocTren.add(ghe);
                    }

                    if (i > 1) {
                        chua2GheDocDuoi.add(ghe);
                    }

                    chuaGheDoc.add(chua2GheDocTren, 0);
                    chuaGheDoc.add(chua2GheDocDuoi, 1);
                }
            }

            if (j % 2 == 0) {
                for (int i = 3; i >= 0 && 4 * (j - 1) < soGhe; i--) {
                    JButton ghe = new JButton(String.valueOf(4 * (j - 1) + i + 1)); // Tạo nút với tên ghế
                    ghe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut)); // Thiết lập kích thước nút
                    ghe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));

                    if (dsGhe.get(4 * (j - 1) + i).getTrangThai() == TRANG_THAI_GHE.Trong) {
                        ghe.setBackground(xanhBrandeis);
                    } else {
                        ghe.setBackground(doDo);
                    }

                    if (!gheDao.layDSGheDat().isEmpty()) {
                        for (int k = 0 ; k < dsGheDaDat.size() ; k++) {
                            if (dsGheDaDat.get(k).getSoGhe().equals(String.valueOf(4 * (j - 1) + i + 1)) &&
                             this.maToa.equals(dsGheDaDat.get(k).getMaToa())) {
                                ghe.setBackground(camNhuomDen);
                            }
                        }
                    }

                    //ghe.setBackground(datMauNenTheoDSGhe(j, i));
                    //ghe.setBackground(datMauNenTheoGheDaDat(j, i));
                    ghe.setForeground(trang); // Đặt màu chữ
                    ghe.setFocusPainted(false); // Bỏ viền khi click (focus)
                    ghe.setBorderPainted(false);
                    ghe.addActionListener(this.hanhDong);

                    if (i <= 1) {
                        chua2GheDocTren.add(ghe);
                    }

                    if (i > 1) {
                        chua2GheDocDuoi.add(ghe);
                    }

                    chuaGheDoc.add(chua2GheDocDuoi, 0);
                    chuaGheDoc.add(chua2GheDocTren, 1);
                }
            }

            trangDung.add(chuaGheDoc);
        }
    }

    public void taoTrangHuongDan() {
        JPanel trangHuongDan = new JPanel();
        trangHuongDan.setLayout(new FlowLayout(FlowLayout.CENTER));
        trangHuongDan.setPreferredSize(new Dimension(800, 140));
        trangHuongDan.setBackground(trang);

        themBieuTuongVaTieuDe(trangHuongDan, "Ghế trống", xanhBrandeis);
        themBieuTuongVaTieuDe(trangHuongDan, "Ghế đã mua", doDo);
        themBieuTuongVaTieuDe(trangHuongDan, "Ghế chọn", camNhuomDen);

        add(trangHuongDan, BorderLayout.SOUTH);
    }

    /*private Color datMauNenTheoGheDaDat(int soGhe, int soGheTrongHangDoc) {
        if (!gheDao.layDSGheDat().isEmpty()) {
            List<Ghe> dsGheDaDat = new ArrayList<>(gheDao.layDSGheDat());

            for (int k = 0 ; k < dsGheDaDat.size() ; k++) {
                if (dsGheDaDat.get(k).getSoGhe().equals(String.valueOf(4 * (soGhe - 1) + soGheTrongHangDoc + 1)) &&
                ) {
                    return doDo;
                }
            }
        }

        return xanhBrandeis;
    }

    private Color datMauNenTheoDSGhe(int soGhe, int soGheTrongHangDoc) {
        if (dsGhe.get(4 * (soGhe - 1) + soGheTrongHangDoc).getTrangThai() == TRANG_THAI_GHE.Trong) {
            return xanhBrandeis; // Đặt màu nền
        }

        return doDo;
    }*/

    private void themBieuTuongVaTieuDe(JPanel trangHienTai, String cau, Color mau) {
        JPanel trangChuaTieuDeVaBieuTuong = new JPanel();
        trangChuaTieuDeVaBieuTuong.setPreferredSize(new Dimension(250, chieuRongNut));
        trangChuaTieuDeVaBieuTuong.setBackground(trang);
        trangChuaTieuDeVaBieuTuong.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        JButton nutBieuTuong = new JButton("");
        nutBieuTuong.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut)); // Thiết lập kích thước nút
        nutBieuTuong.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        nutBieuTuong.setBackground(mau); // Đặt màu nền
        nutBieuTuong.setForeground(trang); // Đặt màu chữ
        nutBieuTuong.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutBieuTuong.setBorderPainted(false);

        JLabel tieuDe = new JLabel(cau, SwingConstants.LEFT);
        tieuDe.setPreferredSize(new Dimension(140, chieuRongNut));
        tieuDe.setForeground(xanhBrandeis);
        tieuDe.setBackground(trang);
        tieuDe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 12));

        trangChuaTieuDeVaBieuTuong.add(nutBieuTuong);
        trangChuaTieuDeVaBieuTuong.add(tieuDe);

        trangHienTai.add(trangChuaTieuDeVaBieuTuong);
    }
}
