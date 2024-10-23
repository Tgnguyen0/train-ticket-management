package app.giao_dien;

import app.dao.Ghe_DAO;
import app.dieu_khien.HanhDong_TrangSoDoGiuong6;
import app.phong_chu_moi.PhongChuMoi;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class TrangSoDoGiuong6 extends JPanel {
    JPanel trangChuaTieuDeVaSoDo;
    public JPanel trangChuaSoDoGiuong;
    public JComboBox<String> thanhCacToa;

    int soNut = 28;
    String[] muc = {"D1", "A1"};

    /* Khoi Tao Phong Chu Mau Sac */
    public int kichThuocChu = 13;
    public int chieuDaiNut = 50;
    public int chieuRongNut = 50;
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public Color trang = new Color(255, 255, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Color doDo = new Color(220, 53, 69);
    public Border vienNhat = BorderFactory.createLineBorder(xanhNhat);
    public Border vienDam = BorderFactory.createLineBorder(xanhBrandeis);
    public Border gachChanNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhNhat);
    public Border gachChanDam = BorderFactory.createMatteBorder(0, 1, 0, 1, xanhBrandeis);

    private ActionListener hanhDong;
    private MouseListener thaoTacChuot;

    public Ghe_DAO gheDao;

    public TrangSoDoGiuong6() {
        ImageIcon icon = new ImageIcon("assets/icon.png");

        setSize(new Dimension(1000, 420));
        //setIconImage(icon.getImage());
        setBackground(trang);
        //setLocationRelativeTo(null);
        //setTitle("Sơ đồ ghế");
        setLayout(new BorderLayout());
        //setResizable(true);

        hanhDong = new HanhDong_TrangSoDoGiuong6(this);
        thaoTacChuot = new HanhDong_TrangSoDoGiuong6(this);

        taoTrangTieuDe();

        trangChuaTieuDeVaSoDo = new JPanel();
        trangChuaTieuDeVaSoDo.setBackground(trang);
        trangChuaTieuDeVaSoDo.setPreferredSize(new Dimension(1000, 300));
        trangChuaTieuDeVaSoDo.setLayout(new FlowLayout(FlowLayout.CENTER));

        taoTieuDeTang();
        taoTrangChuaSoDoGhe();
        taoTrangHuongDan();

        add(trangChuaTieuDeVaSoDo, BorderLayout.CENTER);
    }

    public void datGiuongDao(Ghe_DAO giuongDao) {
        this.gheDao = giuongDao;
    }

    public void taoTrangTieuDe() {
        JPanel trangTieuDe = new JPanel();
        trangTieuDe.setLayout(new FlowLayout(FlowLayout.CENTER));
        trangTieuDe.setPreferredSize(new Dimension(1000, 40));
        trangTieuDe.setBackground(trang);

        JLabel tieuDe = new JLabel("Sơ đồ toa giường 3 tầng", SwingConstants.CENTER);
        tieuDe.setPreferredSize(new Dimension(900, 40));
        tieuDe.setForeground(xanhBrandeis);
        tieuDe.setBackground(trang);
        tieuDe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 18));
        trangTieuDe.add(tieuDe);

        add(trangTieuDe, BorderLayout.NORTH);
    }

    public void taoTieuDeTang() {
        JPanel trangChuaTieuDe = new JPanel();
        trangChuaTieuDe.setPreferredSize(new Dimension(80, 280));
        trangChuaTieuDe.setForeground(xanhBrandeis);
        trangChuaTieuDe.setBackground(trang);
        trangChuaTieuDe.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));

        JPanel trangTrong = new JPanel();
        trangTrong.setPreferredSize(new Dimension(80, 40));
        trangTrong.setBackground(trang);
        trangChuaTieuDe.add(trangTrong);

        JLabel tieuDeTangTren = new JLabel("Tầng Trên");
        tieuDeTangTren.setForeground(xanhBrandeis);
        tieuDeTangTren.setBackground(trang);
        tieuDeTangTren.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu + 1));
        tieuDeTangTren.setPreferredSize(new Dimension(80, 30));
        trangChuaTieuDe.add(tieuDeTangTren);

        JLabel tieuDeTangGiua = new JLabel("Tầng Giữa");
        tieuDeTangGiua.setForeground(xanhBrandeis);
        tieuDeTangGiua.setBackground(trang);
        tieuDeTangGiua.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu + 1));
        tieuDeTangGiua.setPreferredSize(new Dimension(80, 30));
        trangChuaTieuDe.add(tieuDeTangGiua);

        JLabel tieuDeTangDuoi = new JLabel("Tầng Dưới");
        tieuDeTangDuoi.setForeground(xanhBrandeis);
        tieuDeTangDuoi.setBackground(trang);
        tieuDeTangDuoi.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu + 1));
        tieuDeTangDuoi.setPreferredSize(new Dimension(80, 30));
        trangChuaTieuDe.add(tieuDeTangDuoi);

        trangChuaTieuDeVaSoDo.add(trangChuaTieuDe);
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

        JPanel trangSoDoGiuong = new JPanel();
        trangSoDoGiuong.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        trangSoDoGiuong.setPreferredSize(new Dimension(850, 280));
        trangSoDoGiuong.setBackground(trang);

        for (int i = 0 ; i < 7; i++) {
            JPanel trangChuaKhoang = new JPanel();
            trangChuaKhoang.setBackground(trang);
            trangChuaKhoang.setPreferredSize(new Dimension(110, 280));

            JLabel tieuDeKhoang = new JLabel("Khoang " + String.valueOf(i + 1), SwingConstants.CENTER);
            tieuDeKhoang.setPreferredSize(new Dimension(110, 30));
            tieuDeKhoang.setBackground(trang);
            tieuDeKhoang.setForeground(xanhBrandeis);
            tieuDeKhoang.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
            trangChuaKhoang.add(tieuDeKhoang);

            JPanel benGiuongChan = new JPanel();
            benGiuongChan.setPreferredSize(new Dimension(50, 180));
            benGiuongChan.setBackground(trang);

            JPanel benGiuongLe = new JPanel();
            benGiuongLe.setPreferredSize(new Dimension(50, 180));
            benGiuongLe.setBackground(trang);

            for (int j = 6 ; j >= 1; j--) {
                JButton giuong = new JButton(String.valueOf(j + doTang * 6));
                giuong.setPreferredSize(new Dimension(chieuDaiNut,chieuRongNut));
                giuong.setBackground(xanhBrandeis);
                giuong.setForeground(trang);
                giuong.setFocusPainted(false); // Bỏ viền khi click (focus)
                giuong.setBorderPainted(false);
                giuong.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
                giuong.addActionListener(hanhDong);

                if (j % 2 != 0) {
                    benGiuongLe.add(giuong);
                }

                if (j % 2 == 0) {
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
        trangHuongDan.setPreferredSize(new Dimension(1200, 140));
        trangHuongDan.setBackground(trang);

        themBieuTuongVaTieuDe(trangHuongDan, "Giường Trống", xanhBrandeis);
        themBieuTuongVaTieuDe(trangHuongDan, "Giường đã mua", doDo);

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            TrangSoDoGiuong6 trangMoi = new TrangSoDoGiuong6();
            trangMoi.setVisible(true);
        });
    }
}
