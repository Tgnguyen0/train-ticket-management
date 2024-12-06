package app.giao_dien;

import app.dao.Ghe_DAO;
import app.dieu_khien.HanhDong_TrangSoDoGiuong2;
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

public class TrangSoDoGiuong2 extends JPanel {
    JPanel trangChuaTieuDeVaSoDo;
    public JPanel trangChuaSoDoGiuong;

    /* Khoi Tao Phong Chu Mau Sac */
    public static int kichThuocChu = 13;
    public static int chieuDaiNut = 50;
    public static int chieuRongNut = 50;

    public static Color trang = new Color(255, 255, 255);
    public static Color xanhNhat = new Color(66, 186, 255);
    public static Color xanhBrandeis = new Color(0, 112, 255);
    public static Color camNhuomDen = new Color(253, 126, 20);
    public static Color doDo = new Color(220, 53, 69);

    public PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public static Border vienNhat = BorderFactory.createLineBorder(xanhNhat);
    public static Border vienDam = BorderFactory.createLineBorder(xanhBrandeis);
    public static Border gachChanNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhNhat);
    public static Border gachChanDam = BorderFactory.createMatteBorder(0, 1, 0, 1, xanhBrandeis);

    private ActionListener hanhDong;
    private MouseListener thaoTacChuot;

    public Ghe_DAO giuongDao;

    public List<Ghe> dsGiuong;
    public String tenToa;
    public String maToa;

    public TrangSoDoGiuong2(List<Ghe> dsGiuong, Ghe_DAO giuongDao, String tenToa, String maToa) {
        this.dsGiuong = dsGiuong;
        this.tenToa = tenToa;
        this.giuongDao = giuongDao;
        this.maToa = maToa;

        ImageIcon icon = new ImageIcon("assets/icon.png");

        setSize(new Dimension(1000, 420));
        //setIconImage(icon.getImage());
        setBackground(trang);
        //setLocationRelativeTo(null);
        //setTitle("Sơ đồ ghế");
        setLayout(new BorderLayout());
        //setResizable(false);

        hanhDong = new HanhDong_TrangSoDoGiuong2(this);
        thaoTacChuot = new HanhDong_TrangSoDoGiuong2(this);

        taoTrangTieuDe();

        trangChuaTieuDeVaSoDo = new JPanel();
        trangChuaTieuDeVaSoDo.setBackground(trang);
        trangChuaTieuDeVaSoDo.setPreferredSize(new Dimension(1000, 300));
        trangChuaTieuDeVaSoDo.setLayout(new FlowLayout(FlowLayout.CENTER));

        taoTrangChuaSoDoGhe();
        taoTrangHuongDan();

        add(trangChuaTieuDeVaSoDo, BorderLayout.CENTER);
    }

    public void taoTrangTieuDe() {
        JPanel trangTieuDe = new JPanel();
        trangTieuDe.setLayout(new FlowLayout(FlowLayout.CENTER));
        trangTieuDe.setPreferredSize(new Dimension(1000, 40));
        trangTieuDe.setBackground(trang);

        JLabel tieuDe = new JLabel("Sơ đồ toa giường đôi " + this.tenToa , SwingConstants.CENTER);
        tieuDe.setPreferredSize(new Dimension(900, 40));
        tieuDe.setForeground(xanhBrandeis);
        tieuDe.setBackground(trang);
        tieuDe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 18));
        trangTieuDe.add(tieuDe);

        add(trangTieuDe, BorderLayout.NORTH);
    }

    public void taoTrangChuaSoDoGhe() {
        this.trangChuaSoDoGiuong = new JPanel();
        trangChuaSoDoGiuong.setBackground(trang);
        trangChuaSoDoGiuong.setPreferredSize(new Dimension(850, 280));
        trangChuaSoDoGiuong.setLayout(new CardLayout());

        JPanel soDoGiuongToa = taoTrangSoDoGhe();
        trangChuaSoDoGiuong.add(soDoGiuongToa, "A1");
        trangChuaTieuDeVaSoDo.add(trangChuaSoDoGiuong);
    }

    public JPanel taoTrangSoDoGhe() {
        int doTang = 0;
        List<Ghe> dsGiuongDaDat = new ArrayList<>(giuongDao.layDSGheDat());

        JPanel trangSoDoGiuong = new JPanel();
        trangSoDoGiuong.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        trangSoDoGiuong.setPreferredSize(new Dimension(850, 280));
        trangSoDoGiuong.setBackground(trang);

        for (int i = 0; i < 7; i++) {
            JPanel trangChuaKhoang = new JPanel();
            trangChuaKhoang.setBackground(trang);
            trangChuaKhoang.setPreferredSize(new Dimension(110, 150));

            JLabel tieuDeKhoang = new JLabel("Khoang " + String.valueOf(i + 1), SwingConstants.CENTER);
            tieuDeKhoang.setPreferredSize(new Dimension(110, 30));
            tieuDeKhoang.setBackground(trang);
            tieuDeKhoang.setForeground(xanhBrandeis);
            tieuDeKhoang.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
            trangChuaKhoang.add(tieuDeKhoang);

            JPanel benGiuongChan = new JPanel();
            benGiuongChan.setPreferredSize(new Dimension(50, 110));
            benGiuongChan.setBackground(trang);

            JPanel benGiuongLe = new JPanel();
            benGiuongLe.setPreferredSize(new Dimension(50, 110));
            benGiuongLe.setBackground(trang);

            for (int j = 2; j >= 1; j--) {
                JButton giuong = new JButton(String.valueOf(j + doTang * 2));
                giuong.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));

                // Kiểm tra trạng thái ghế và đặt màu tương ứng
                if (dsGiuong.get(j - 1 + doTang * 2).getTrangThai() == TRANG_THAI_GHE.Trong) {
                    giuong.setBackground(xanhBrandeis);
                } else {
                    giuong.setBackground(doDo);
                }

                // Kiểm tra nếu ghế này có trong danh sách đã đặt
                for (Ghe gheDaDat : dsGiuongDaDat) {
                    if (gheDaDat.getSoGhe().equals(String.valueOf(j + doTang * 2)) &&
                            this.maToa.equals(gheDaDat.getMaToa())) {
                        giuong.setBackground(camNhuomDen);
                        break; // Nếu tìm thấy ghế đã đặt, ngừng kiểm tra
                    }
                }

                giuong.setForeground(trang);
                giuong.setFocusPainted(false); // Bỏ viền khi click (focus)
                giuong.setBorderPainted(false);
                giuong.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
                giuong.addActionListener(hanhDong);

                if (j % 2 != 0) {
                    benGiuongLe.add(giuong);
                } else {
                    benGiuongChan.add(giuong);
                }
            }

            trangChuaKhoang.add(benGiuongLe);
            trangChuaKhoang.add(benGiuongChan);

            trangSoDoGiuong.add(trangChuaKhoang);

            doTang++;
        }

        return trangSoDoGiuong;
    }

    public void taoTrangHuongDan() {
        JPanel trangHuongDan = new JPanel();
        trangHuongDan.setLayout(new FlowLayout(FlowLayout.CENTER));
        trangHuongDan.setPreferredSize(new Dimension(800, 140));
        trangHuongDan.setBackground(trang);

        themBieuTuongVaTieuDe(trangHuongDan, "Giường Trống", xanhBrandeis);
        themBieuTuongVaTieuDe(trangHuongDan, "Giường đã mua", doDo);
        themBieuTuongVaTieuDe(trangHuongDan, "Ghế chọn", camNhuomDen);


        add(trangHuongDan, BorderLayout.SOUTH);
    }

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