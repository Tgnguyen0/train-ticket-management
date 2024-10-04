package app.giao_dien;

import app.dieu_khien.HanhDong_TrangSoDoGheMemDieuHoa;
import app.phong_chu_moi.PhongChuMoi;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class TrangSoDoGheMemDieuHoa extends JFrame {
    /**/
    public JPanel trangChua;

    /**/
    int gheSo;
    int soGhe;
    int soToa;
    ArrayList<Integer> cacGheDaChon;
    String[] muc = {"D1", "A4"};

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

    /**/
    private ItemListener mucDaChon;

    public TrangSoDoGheMemDieuHoa() {
        ImageIcon icon = new ImageIcon("assets/icon.png");

        setSize(new Dimension(800, 400));
        setIconImage(icon.getImage());
        setBackground(trang);
        setLocationRelativeTo(null);
        setTitle("Sơ đồ ghế");
        setLayout(new BorderLayout());
        setResizable(false);

        this.mucDaChon = new HanhDong_TrangSoDoGheMemDieuHoa(this);

        taoTrangTieuDe();
        taoTrangCacToa();
        taoTrangChuaCacSoDoGhe();
    }

    public void taoTrangTieuDe() {
        JPanel trangTieuDe = new JPanel();
        trangTieuDe.setLayout(new FlowLayout(FlowLayout.CENTER));
        trangTieuDe.setPreferredSize(new Dimension(800, 40));
        trangTieuDe.setBackground(trang);

        JLabel tieuDe = new JLabel("Sơ đồ toa ghế mềm", SwingConstants.CENTER);
        tieuDe.setPreferredSize(new Dimension(800, 40));
        tieuDe.setForeground(xanhBrandeis);
        tieuDe.setBackground(trang);
        tieuDe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 18));
        trangTieuDe.add(tieuDe);

        add(trangTieuDe, BorderLayout.NORTH);
    }

    public void taoTrangCacToa() {
        JPanel trangChuaCacToa = new JPanel();
        trangChuaCacToa.setLayout(new FlowLayout(FlowLayout.CENTER));
        trangChuaCacToa.setPreferredSize(new Dimension(800, 30));
        trangChuaCacToa.setBackground(trang);

        JComboBox<String> thanhCacToa = new JComboBox<>(muc);
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

    public void taoTrangChuaCacSoDoGhe() {
        MatteBorder duongVienTuyChinhTren = BorderFactory.createMatteBorder(1, 1, 1, 1, xanhBrandeis);

        // Tạo đường viền có tiêu đề
        TitledBorder duongVienChuTren = BorderFactory.createTitledBorder(
                duongVienTuyChinhTren,
                "  Cửa Sổ    ",
                TitledBorder.TOP,
                TitledBorder.TOP,
                phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 12),
                xanhBrandeis);

        MatteBorder duongVienTuyChinhDuoi = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis);

        // Tạo đường viền có tiêu đề
        TitledBorder duongVienChuDuoi = BorderFactory.createTitledBorder(
                duongVienTuyChinhDuoi,
                "  Cửa Sổ    ",
                TitledBorder.BOTTOM,
                TitledBorder.BOTTOM,
                phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 12),
                xanhBrandeis);

        CompoundBorder duongVienKetHop = BorderFactory.createCompoundBorder(duongVienChuTren, duongVienChuDuoi);

        JPanel trangChuaCacSoDoGhe = new JPanel();
        trangChuaCacSoDoGhe.setLayout(new FlowLayout(FlowLayout.CENTER));
        trangChuaCacSoDoGhe.setPreferredSize(new Dimension(800, 280));
        trangChuaCacSoDoGhe.setBackground(trang);

        this.trangChua = new JPanel();
        trangChua.setPreferredSize(new Dimension(760, 245));
        trangChua.setBackground(trang);
        trangChua.setLayout(new CardLayout());

        JPanel soDoGheToaD1 = taoTrangSoDoGhe();
        soDoGheToaD1.setBorder(duongVienKetHop);

        JPanel soDoGheToaA4 = taoTrangSoDoGhe();
        soDoGheToaA4.setBackground(Color.RED);

        trangChua.add(soDoGheToaD1, "D1");
        trangChua.add(soDoGheToaA4, "A4");
        trangChuaCacSoDoGhe.add(trangChua);

        add(trangChuaCacSoDoGhe, BorderLayout.SOUTH);
    }

    public JPanel taoTrangSoDoGhe() {
        JPanel trangSoDoGhe = new JPanel();
        trangSoDoGhe.setBackground(trang);
        trangSoDoGhe.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

        xepNutGhe(trangSoDoGhe);

        return trangSoDoGhe;
    }

    public void xepNutGhe(JPanel trangDung) {
        soGhe = 50;

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
                    ghe.setBackground(xanhBrandeis); // Đặt màu nền
                    ghe.setForeground(trang); // Đặt màu chữ
                    ghe.setFocusPainted(false); // Bỏ viền khi click (focus)
                    ghe.setBorderPainted(false);

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
                    ghe.setBackground(xanhBrandeis); // Đặt màu nền
                    ghe.setForeground(trang); // Đặt màu chữ
                    ghe.setFocusPainted(false); // Bỏ viền khi click (focus)
                    ghe.setBorderPainted(false);

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrangSoDoGheMemDieuHoa trangSoDoGheMemDieuHoa = new TrangSoDoGheMemDieuHoa();
            trangSoDoGheMemDieuHoa.setVisible(true);
        });
    }
}
