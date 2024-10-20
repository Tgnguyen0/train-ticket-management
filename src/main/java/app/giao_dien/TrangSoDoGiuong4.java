package app.giao_dien;

import app.dieu_khien.HanhDong_TrangSoDoGiuong4;
import app.phong_chu_moi.PhongChuMoi;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ItemListener;

public class TrangSoDoGiuong4 extends JPanel {
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
    public Border vienNhat = BorderFactory.createLineBorder(xanhNhat);
    public Border vienDam = BorderFactory.createLineBorder(xanhBrandeis);
    public Border gachChanNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhNhat);
    public Border gachChanDam = BorderFactory.createMatteBorder(0, 1, 0, 1, xanhBrandeis);

    private ItemListener mucDaChon;

    public TrangSoDoGiuong4() {
        ImageIcon icon = new ImageIcon("assets/icon.png");

        setSize(new Dimension(1000, 420));
        //setIconImage(icon.getImage());
        setBackground(trang);
        //setLocationRelativeTo(null);
        //setTitle("Sơ đồ ghế");
        setLayout(new BorderLayout());
        //setResizable(false);

        mucDaChon = new HanhDong_TrangSoDoGiuong4(this);

        taoTrangTieuDe();
        taoTrangCacToa();

        trangChuaTieuDeVaSoDo = new JPanel();
        trangChuaTieuDeVaSoDo.setBackground(trang);
        trangChuaTieuDeVaSoDo.setPreferredSize(new Dimension(1000, 300));
        trangChuaTieuDeVaSoDo.setLayout(new FlowLayout(FlowLayout.CENTER));

        taoTieuDeTang();
        taoTrangChuaSoDoGhe();

        add(trangChuaTieuDeVaSoDo, BorderLayout.SOUTH);
    }

    public void taoTrangTieuDe() {
        JPanel trangTieuDe = new JPanel();
        trangTieuDe.setLayout(new FlowLayout(FlowLayout.CENTER));
        trangTieuDe.setPreferredSize(new Dimension(1000, 40));
        trangTieuDe.setBackground(trang);

        JLabel tieuDe = new JLabel("Sơ đồ toa giường 2 tầng", SwingConstants.CENTER);
        tieuDe.setPreferredSize(new Dimension(900, 40));
        tieuDe.setForeground(xanhBrandeis);
        tieuDe.setBackground(trang);
        tieuDe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 18));
        trangTieuDe.add(tieuDe);

        add(trangTieuDe, BorderLayout.NORTH);
    }

    public void taoTrangCacToa() {
        JPanel trangChuaCacToa = new JPanel();
        trangChuaCacToa.setLayout(new FlowLayout(FlowLayout.CENTER));
        trangChuaCacToa.setPreferredSize(new Dimension(1000, 30));
        trangChuaCacToa.setBackground(trang);

        thanhCacToa = new JComboBox<>(muc);
        thanhCacToa.setForeground(xanhBrandeis);
        thanhCacToa.setBackground(trang);
        thanhCacToa.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhCacToa.setBorder(vienDam);
        thanhCacToa.setFocusable(false);
        thanhCacToa.setPreferredSize(new Dimension(210, 30));
        thanhCacToa.addItemListener(mucDaChon);
        trangChuaCacToa.add(thanhCacToa);

        add(trangChuaCacToa, BorderLayout.CENTER);
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

        JPanel soDoGiuongToaD1 = taoTrangSoDoGhe();

        JPanel soDoGiuongToaA1 = taoTrangSoDoGhe();
        soDoGiuongToaA1.setBackground(Color.RED);

        trangChuaSoDoGiuong.add(soDoGiuongToaD1, "D1");
        trangChuaSoDoGiuong.add(soDoGiuongToaA1, "A1");

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
            benGiuongLe.setPreferredSize(new Dimension(50, 110 ));
            benGiuongLe.setBackground(trang);

            for (int j = 4 ; j >= 1; j--) {
                JButton giuong = new JButton(String.valueOf(j + doTang * 4));
                giuong.setPreferredSize(new Dimension(chieuDaiNut,chieuRongNut));
                giuong.setBackground(xanhBrandeis);
                giuong.setForeground(trang);
                giuong.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            TrangSoDoGiuong4 trangMoi = new TrangSoDoGiuong4();
            trangMoi.setVisible(true);
        });
    }
}
