package app.giao_dien;

import app.dao.Ghe_DAO;
import app.dieu_khien.HanhDong_TrangCacTau;
import app.dieu_khien.HanhDong_TrangCacToa;
import app.phan_tu_tuy_chinh.NutAnh;
import app.phong_chu_moi.PhongChuMoi;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class TrangCacTau extends JFrame {
    public JPanel trangChua;
    public NutAnh nutTau1;
    public NutAnh nutTau2;

    public TrangCacToa trangCacToa1;
    public TrangCacToa trangCacToa2;

    /* Khởi tạo phông chữ màu sắc */
    public Color trang = new Color(255, 255, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public int charSize = 13;
    public int chieuDaiNut = 200;
    public int chieuRongNut = 200;
    public int viTriChu = chieuRongNut + 100;
    public Border vienNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(xanhNhat.getRGB()));
    public Border vienDam = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(xanhBrandeis.getRGB()));

    private ActionListener hanhDong;
    private MouseListener thaoTacChuot;
    public Ghe_DAO gheDao;

    // Function tạo GUI chính
    public TrangCacTau(Ghe_DAO gheDao) {
        this.gheDao = gheDao;

        ImageIcon icon = new ImageIcon("assets/icon.png");
        setTitle("Sơ đồ chung");
        //setSize(new Dimension(1200, 800));
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(true);
        setLayout(new BorderLayout());

        // Thêm ActionListener và MouseListener cho các nút
        this.hanhDong = new HanhDong_TrangCacTau(this);
        this.thaoTacChuot = new HanhDong_TrangCacTau(this);

        taoThanhDinhHuongToa();
        taoTrangChua();
    }

    public void datGheDao(Ghe_DAO gheDao) {
        this.gheDao = gheDao;
    }

    public void taoThanhDinhHuongToa() {
        JPanel thanhDinhHuong = new JPanel();
        thanhDinhHuong.setPreferredSize(new Dimension(1200, chieuRongNut + 40));
        thanhDinhHuong.setBackground(trang);
        thanhDinhHuong.setLayout(new FlowLayout(FlowLayout.CENTER, 400, 20));

        // Tạo Nút dẫn đến trang chủ
        /* Tạo nút ảnh với việc truyền đừờng dẫn ảnh chính, ảnh đang chọn,
        chiều dài ảnh, chiều rộng ảnh,chiều dài của chữ và chữ và vị trí x của chữ */
        this.nutTau1 = new NutAnh("assets/tau.png",
                                 "assets/tau-dang-chon.png",
                                                  chieuDaiNut, chieuRongNut,
                                                  viTriChu, "Tàu 1",40);

        nutTau1.setActionCommand("Tau 1");
        nutTau1.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        nutTau1.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutTau1.setForeground(trang);
        nutTau1.setBackground(trang);
        nutTau1.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutTau1.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutTau1.setBorder(null);
        nutTau1.addMouseListener(this.thaoTacChuot);
        nutTau1.addActionListener(this.hanhDong);
        thanhDinhHuong.add(nutTau1);

        // Tạo Nút đến trang bán hàng
        /* Tạo nút ảnh với việc truyền đừờng dẫn ảnh chính, ảnh đang chọn,
        chiều dài ảnh, chiều rộng ảnh,chiều dài của chữ và chữ và vị trí x của chữ */
        this.nutTau2 = new NutAnh("assets/tau.png",
                "assets/tau-dang-chon.png",
                chieuDaiNut, chieuRongNut,
                viTriChu, "Tàu 2",40);

        nutTau2.setActionCommand("Tau 2");
        nutTau2.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        nutTau2.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutTau2.setForeground(trang);
        nutTau2.setBackground(trang);
        nutTau2.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutTau2.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutTau2.setBorder(null);
        nutTau2.addMouseListener(this.thaoTacChuot);
        nutTau2.addActionListener(this.hanhDong);
        thanhDinhHuong.add(nutTau2);

        // Tạo Nút đến trang hóa đơn
        //nutTau3 = new NutAnh(anhTau, chieuDaiNut, chieuRongNut);
        /*this.nutTau3 = new NutAnh("assets/tau.png", "assets/tau-dang-chon.png", chieuDaiNut, chieuRongNut, "Tàu 3");
        nutTau3.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        nutTau3.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutTau3.setForeground(new Color(xanhBrandeis.getRGB()));
        nutTau3.setBackground(new Color(trang.getRGB()));
        nutTau3.setBorder(null);
        nutTau3.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutTau3.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        //nutTau3.setEnabled(false);
        nutTau3.addMouseListener(this.thaoTacChuot);
        nutTau3.addActionListener(this.hanhDong);
        thanhDinhHuong.add(nutTau3);

        // Tạo Nút đến trang khách hàng
        //nutTau4 = new NutAnh(anhTau, chieuDaiNut, chieuRongNut);
        this.nutTau4 = new NutAnh("assets/tau.png", "assets/tau-dang-chon.png", chieuDaiNut, chieuRongNut, "Tàu 4");
        nutTau4.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        nutTau4.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutTau4.setForeground(new Color(xanhBrandeis.getRGB()));
        nutTau4.setBackground(new Color(trang.getRGB()));
        nutTau4.setBorder(null);
        nutTau4.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutTau4.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutTau4.addMouseListener(this.thaoTacChuot);
        nutTau4.addActionListener(this.hanhDong);
        thanhDinhHuong.add(nutTau4);*/

        add(thanhDinhHuong, BorderLayout.NORTH);
    }

    public void taoTrangChua() {
        // Khởi tạo trang chứa các trang khác
        this.trangChua = new JPanel();
        this.trangChua.setPreferredSize(new Dimension(1200, 600));
        this.trangChua.setLayout(new CardLayout());

        System.out.println(String.valueOf(gheDao.layDsGhe().size()));

        this.trangCacToa1 = new TrangCacToa("Tàu 1", this.gheDao);
        this.trangCacToa2 = new TrangCacToa("Tàu 2", this.gheDao);

        this.trangChua.add(trangCacToa1, "Cac toa cua tau 1");
        this.trangChua.add(trangCacToa2, "Cac toa cua tau 2");

        add(this.trangChua);
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            TrangCacTau trangMoi = new TrangCacTau();
            trangMoi.setVisible(true);
        });
    }*/
}
