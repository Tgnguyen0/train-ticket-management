package app.giao_dien;

import app.dao.Ghe_DAO;
import app.dieu_khien.HanhDong_TrangCacToa;
import app.phan_tu_tuy_chinh.NutAnh;
import app.phong_chu_moi.PhongChuMoi;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class TrangCacToa extends JPanel {
    public String soHieu;

    public JPanel trangChua;
    public NutAnh nutToa1;
    public NutAnh nutToa2;
    public NutAnh nutToa3;
    public NutAnh nutToa4;
    public NutAnh nutToa5;
    public NutAnh nutToa6;
    public NutAnh nutToa7;
    public NutAnh nutToa8;
    public NutAnh nutToa9;
    public NutAnh nutToa10;
    public NutAnh nutToa11;
    public NutAnh nutToa12;

    public TrangSoDoGheMem trangSoDoGheMem1;
    public TrangSoDoGheMem trangSoDoGheMem2;
    public TrangSoDoGheMem trangSoDoGheMem3;

    public TrangSoDoGiuong4 trangSoDoGiuong4So1;
    public TrangSoDoGiuong4 trangSoDoGiuong4So2;
    public TrangSoDoGiuong4 trangSoDoGiuong4So3;
    public TrangSoDoGiuong4 trangSoDoGiuong4So4;

    public TrangSoDoGiuong6 trangSoDoGiuong6So1;
    public TrangSoDoGiuong6 trangSoDoGiuong6So2;
    public TrangSoDoGiuong6 trangSoDoGiuong6So3;
    public TrangSoDoGiuong6 trangSoDoGiuong6So4;

    public TrangSoDoGiuong2 trangSoDoGiuong2;

    /* Khởi tạo phông chữ màu sắc */
    public Color trang = new Color(255, 255, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    public Color doDo = new Color(220, 53, 69);
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public int charSize = 13;
    public int chieuDaiNut = 60;
    public int chieuRongNut = 36;
    public int viTriChu = 36;
    public Border vienNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(xanhNhat.getRGB()));
    public Border vienDam = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(xanhBrandeis.getRGB()));

    private ActionListener hanhDong;
    private MouseListener thaoTacChuot;
    public Ghe_DAO gheDao;

    public TrangCacToa(String soHieu, Ghe_DAO gheDao) {
        this.soHieu = soHieu;
        this.gheDao = gheDao;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1200, 800));

        // Thêm ActionListener và MouseListener cho các nút
        this.hanhDong = new HanhDong_TrangCacToa(this);
        this.thaoTacChuot = new HanhDong_TrangCacToa(this);

        taoThanhDinhHuongTau();
        taoTrangHuongDan();
        taoTrangChua();
    }

    public void datGheDao(Ghe_DAO gheDao) {
        this.gheDao = gheDao;
    }

    public void taoThanhDinhHuongTau() {
        JPanel thanhDinhHuong = new JPanel();
        thanhDinhHuong.setPreferredSize(new Dimension(1200, chieuRongNut + 40));
        thanhDinhHuong.setBackground(trang);
        thanhDinhHuong.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

        this.nutToa12 = taoNutToa(12);
        this.nutToa12.setActionCommand("12");
        thanhDinhHuong.add(nutToa12);

        this.nutToa11 = taoNutToa(11);
        this.nutToa11.setActionCommand("11");
        thanhDinhHuong.add(nutToa11);

        this.nutToa10 = taoNutToa(10);
        this.nutToa10.setActionCommand("10");
        thanhDinhHuong.add(nutToa10);

        this.nutToa9 = taoNutToa(9);
        this.nutToa9.setActionCommand("9");
        thanhDinhHuong.add(nutToa9);

        this.nutToa8 = taoNutToa(8);
        this.nutToa8.setActionCommand("8");
        thanhDinhHuong.add(nutToa8);

        this.nutToa7 = taoNutToa(7);
        this.nutToa7.setActionCommand("7");
        thanhDinhHuong.add(nutToa7);

        this.nutToa6 = taoNutToa(6);
        this.nutToa6.setActionCommand("6");
        thanhDinhHuong.add(nutToa6);

        this.nutToa5 = taoNutToa(5);
        this.nutToa5.setActionCommand("5");
        thanhDinhHuong.add(nutToa5);

        this.nutToa4 = taoNutToa(4);
        this.nutToa4.setActionCommand("4");
        thanhDinhHuong.add(nutToa4);

        this.nutToa3 = taoNutToa(3);
        this.nutToa3.setActionCommand("3");
        thanhDinhHuong.add(nutToa3);

        this.nutToa2 = taoNutToa(2);
        this.nutToa2.setActionCommand("2");
        thanhDinhHuong.add(nutToa2);

        this.nutToa1 = taoNutToa(1);
        this.nutToa1.setActionCommand("1");
        thanhDinhHuong.add(nutToa1);

        /* Tạo nút ảnh với việc truyền đừờng dẫn ảnh chính, ảnh đang chọn,
        chiều dài ảnh, chiều rộng ảnh,chiều dài của chữ và chữ và vị trí x của chữ */
        NutAnh nutTau = new NutAnh("assets/tau-nho.png",
                                  "assets/tau-nho.png",
                                                   chieuDaiNut, chieuRongNut,
                                                   viTriChu, this.soHieu, 6);

        nutTau.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut + 100));
        nutTau.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutTau.setForeground(xanhBrandeis);
        nutTau.setBackground(trang);
        nutTau.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutTau.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutTau.setBorder(null);
        nutTau.datViTriChu(SwingConstants.LEFT);
        nutTau.addMouseListener(this.thaoTacChuot);
        nutTau.addActionListener(this.hanhDong);
        thanhDinhHuong.add(nutTau);

        add(thanhDinhHuong, BorderLayout.NORTH);
    }

    public NutAnh taoNutToa(int position) {
        /* Tạo nút ảnh với việc truyền đừờng dẫn ảnh chính, ảnh đang chọn,
        chiều dài ảnh, chiều rộng ảnh,chiều dài của chữ và chữ và vị trí x của chữ*/
        NutAnh nutToa = new NutAnh("assets/toa-tau-con-ve.png",
                                  "assets/toa-dang-chon.png", chieuDaiNut,
                                                   chieuRongNut, viTriChu, String.valueOf(position), 10);

        nutToa.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut + 100));
        nutToa.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutToa.setForeground(xanhBrandeis);
        nutToa.setBackground(trang);
        nutToa.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutToa.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutToa.setBorder(null);
        nutToa.datViTriChu(SwingConstants.CENTER);
        nutToa.addMouseListener(this.thaoTacChuot);
        nutToa.addActionListener(this.hanhDong);

        return nutToa;
    }

    public void taoTrangHuongDan() {
        JPanel trangHuongDan = new JPanel();
        trangHuongDan.setLayout(new FlowLayout(FlowLayout.CENTER));
        trangHuongDan.setPreferredSize(new Dimension(1200, 40));
        trangHuongDan.setBackground(trang);

        String[] duongDanAnh = {
                "assets/toa-tau-con-ve.png",
                "assets/toa-tau-dang-chon.png",
                "assets/toa-tau-het-ve.png"
        };

        try {
            Image anhToaTauConVe, anhToaTauDangChon, anhToaTauHetVe;

            // Tải trước cả hai hình ảnh
            anhToaTauConVe = ImageIO.read(new File("assets/toa-tau-con-ve.png"))
                    .getScaledInstance((int) chieuDaiNut, (int) chieuRongNut, Image.SCALE_SMOOTH);
            anhToaTauDangChon = ImageIO.read(new File("assets/toa-dang-chon.png"))
                    .getScaledInstance((int) chieuDaiNut, (int) chieuRongNut, Image.SCALE_SMOOTH);
            anhToaTauHetVe = ImageIO.read(new File("assets/toa-tau-het-ve.png"))
                    .getScaledInstance((int) chieuDaiNut, (int) chieuRongNut, Image.SCALE_SMOOTH);

            ImageIcon bieuTuongTauConVe = new ImageIcon(anhToaTauConVe);
            ImageIcon bieuTuongTauDangChon = new ImageIcon(anhToaTauDangChon);
            ImageIcon bieuTuongTauHetVe = new ImageIcon(anhToaTauHetVe);

            themBieuTuongVaTieuDe(trangHuongDan, bieuTuongTauConVe, "Toa tàu còn vé");
            themBieuTuongVaTieuDe(trangHuongDan, bieuTuongTauDangChon, "Toa tàu đang chọn");
            themBieuTuongVaTieuDe(trangHuongDan, bieuTuongTauHetVe, "Toa tàu hết vé");

            add(trangHuongDan, BorderLayout.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void themBieuTuongVaTieuDe(JPanel trangHienTai, ImageIcon bieuTuong, String cau) {
        JPanel trangChuaTieuDeVaBieuTuong = new JPanel();
        trangChuaTieuDeVaBieuTuong.setPreferredSize(new Dimension(250, 40));
        trangChuaTieuDeVaBieuTuong.setBackground(trang);
        trangChuaTieuDeVaBieuTuong.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        JLabel chuaBieuTuong = new JLabel(bieuTuong);
        JLabel tieuDe = new JLabel(cau, SwingConstants.LEFT);
        tieuDe.setPreferredSize(new Dimension(140, 40));
        tieuDe.setForeground(xanhBrandeis);
        tieuDe.setBackground(trang);
        tieuDe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 12));

        trangChuaTieuDeVaBieuTuong.add(chuaBieuTuong);
        trangChuaTieuDeVaBieuTuong.add(tieuDe);

        trangHienTai.add(trangChuaTieuDeVaBieuTuong);
    }

    public void taoTrangChua() {
        // Khởi tạo trang chứa các trang khác
        this.trangChua = new JPanel();
        this.trangChua.setPreferredSize(new Dimension(1200, 425));
        this.trangChua.setLayout(new CardLayout());

        // Khởi tạo trang Trang Sơ đồ Ghế Mềm
        this.trangSoDoGheMem1 = new TrangSoDoGheMem();
        this.trangSoDoGheMem2 = new TrangSoDoGheMem();
        this.trangSoDoGheMem3 = new TrangSoDoGheMem();

        // Thiết lập cho gheDaoTest của mỗi phần tử của TrangSoDoGheMem là cùng 1 danh sách
        trangSoDoGheMem1.datGheDao(gheDao);
        trangSoDoGheMem2.datGheDao(gheDao);
        trangSoDoGheMem3.datGheDao(gheDao);

        // Khởi tạo trang Trang Sơ đồ Giường 4
        this.trangSoDoGiuong4So1 = new TrangSoDoGiuong4();
        this.trangSoDoGiuong4So2 = new TrangSoDoGiuong4();
        this.trangSoDoGiuong4So3 = new TrangSoDoGiuong4();
        this.trangSoDoGiuong4So4 = new TrangSoDoGiuong4();

        // Thiết lập cho gheDaoTest của mỗi phần tử của TrangSoDoGuong4 là cùng 1 danh sách
        trangSoDoGiuong4So1.datGiuongDao(gheDao);
        trangSoDoGiuong4So2.datGiuongDao(gheDao);
        trangSoDoGiuong4So3.datGiuongDao(gheDao);
        trangSoDoGiuong4So4.datGiuongDao(gheDao);

        // Khởi tạo trang Trang Sơ đồ Giường 6
        this.trangSoDoGiuong6So1 = new TrangSoDoGiuong6();
        this.trangSoDoGiuong6So2 = new TrangSoDoGiuong6();
        this.trangSoDoGiuong6So3 = new TrangSoDoGiuong6();
        this.trangSoDoGiuong6So4 = new TrangSoDoGiuong6();

        // Thiết lập cho gheDaoTest của mỗi phần tử của TrangSoDoGiuong6 là cùng 1 danh sách
        trangSoDoGiuong6So1.datGiuongDao(gheDao);
        trangSoDoGiuong6So2.datGiuongDao(gheDao);
        trangSoDoGiuong6So3.datGiuongDao(gheDao);
        trangSoDoGiuong6So4.datGiuongDao(gheDao);

        // Khởi tạo trang Trang Sơ đồ Giường 2
        this.trangSoDoGiuong2 = new TrangSoDoGiuong2();

        // Thiết lập cho gheDaoTest của mỗi phần tử của TrangSoDoGiuong2 là cùng 1 danh sách
        trangSoDoGiuong2.datGiuongDao(gheDao);;

        // Thêm vào trangChua
        this.trangChua.add(trangSoDoGheMem1, "Trang Ghe Mem 1");
        this.trangChua.add(trangSoDoGheMem2, "Trang Ghe Mem 2");
        this.trangChua.add(trangSoDoGheMem3, "Trang Ghe Mem 3");

        // Thêm vào trangChua
        this.trangChua.add(trangSoDoGiuong6So1, "Trang Giuong 6 So 1");
        this.trangChua.add(trangSoDoGiuong6So2, "Trang Giuong 6 So 2");
        this.trangChua.add(trangSoDoGiuong6So3, "Trang Giuong 6 So 3");
        this.trangChua.add(trangSoDoGiuong6So4, "Trang Giuong 6 So 4");

        // Thêm vào trangChua
        this.trangChua.add(trangSoDoGiuong4So1,"Trang Giuong 4 So 1");
        this.trangChua.add(trangSoDoGiuong4So2,"Trang Giuong 4 So 2");
        this.trangChua.add(trangSoDoGiuong4So3,"Trang Giuong 4 So 3");
        this.trangChua.add(trangSoDoGiuong4So4,"Trang Giuong 4 So 4");

        // Thêm vào trangChua
        this.trangChua.add(trangSoDoGiuong2,"Trang Giuong 2");

        add(this.trangChua, BorderLayout.SOUTH);
    }
}
