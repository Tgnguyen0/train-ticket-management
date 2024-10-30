package app.giao_dien;

import app.dao.Ghe_DAO;
import app.dao.Toa_DAO;
import app.dieu_khien.HanhDong_TrangCacTau;
import app.phan_tu_tuy_chinh.NutAnh;
import app.phong_chu_moi.PhongChuMoi;
import app.thuc_the.Ghe;
import app.thuc_the.LichCapBenGa;
import app.thuc_the.Tau;
import app.thuc_the.Toa;

import java.awt.event.*;
import java.util.List;
import java.util.Set;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TrangCacTau extends JFrame {
    public JPanel trangChua;
    public NutAnh nutTau1;
    public NutAnh nutTau2;
    public NutAnh nutTau3;
    public NutAnh nutTau4;

    public TrangCacToa trangCacToa1;
    public TrangCacToa trangCacToa2;
    public TrangCacToa trangCacToa3;
    public TrangCacToa trangCacToa4;

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
    private WindowListener hanhDongTrang;

    public Toa_DAO toaDao;
    public Ghe_DAO gheDao;

    public List<Tau> dsTau;
    public List<Toa> dsToa1;
    public List<Toa> dsToa2;
    public List<Toa> dsToa3;
    public List<Toa> dsToa4;
    public List<LichCapBenGa> dsLichTau;
    public String soHieuTauChon;

    public boolean daDongChua = false;
    public boolean coQuaGaTau1 = false;
    public boolean coQuaGaTau2 = false;
    public boolean coQuaGaTau3 = false;
    public boolean coQuaGaTau4 = false;

    // Function tạo GUI chính
    public TrangCacTau(List<Tau> dsTau, Ghe_DAO gheDao, List<LichCapBenGa> dsLichTau) {
        this.toaDao = new Toa_DAO();

        this.dsTau = dsTau;
        this.dsToa1 = toaDao.ChonTheoSoHieuTatCa(this.dsTau.get(0).getSoHieu());
        this.dsToa2 = toaDao.ChonTheoSoHieuTatCa(this.dsTau.get(1).getSoHieu());
        this.dsToa3 = toaDao.ChonTheoSoHieuTatCa(this.dsTau.get(2).getSoHieu());
        this.dsToa4 = toaDao.ChonTheoSoHieuTatCa(this.dsTau.get(3).getSoHieu());
        this.gheDao = gheDao;

        this.dsLichTau = dsLichTau;

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
        this.hanhDongTrang = new HanhDong_TrangCacTau(this);

        addWindowListener(hanhDongTrang);

        taoThanhDinhHuongToa();
        taoTrangChua();
    }

    public boolean kiemDaDongChua() {
        return daDongChua;
    }

    public void datDaDongChua(boolean daDong) {
        this.daDongChua = daDong;
    }

    public void taoThanhDinhHuongToa() {
        JPanel thanhDinhHuong = new JPanel();
        thanhDinhHuong.setPreferredSize(new Dimension(1200, chieuRongNut + 40));
        thanhDinhHuong.setBackground(trang);
        thanhDinhHuong.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));

        for (int i = 0 ; i < this.dsLichTau.size() ; i++) {
            if (dsLichTau.get(i).getMaTau().equals("VN5234")) {
                coQuaGaTau1 = true;
            }

            if (dsLichTau.get(i).getMaTau().equals("VN5947")) {
                coQuaGaTau2 = true;
            }

            if (dsLichTau.get(i).getMaTau().equals("VN7283")) {
                coQuaGaTau3 = true;
            }

            if (dsLichTau.get(i).getMaTau().equals("VN9029")) {
                coQuaGaTau4 = true;
            }
        }

        // Tạo Nút dẫn đến trang chủ
        /* Tạo nút ảnh với việc truyền đừờng dẫn ảnh chính, ảnh đang chọn,
        chiều dài ảnh, chiều rộng ảnh,chiều dài của chữ và chữ và vị trí x của chữ */
        this.nutTau1 = new NutAnh(
                "assets/tau.png",             // Đường dẫn ảnh không được chọn
                "assets/tau-dang-chon.png",                  // Đường dẫn ảnh khi được chọn
                chieuDaiNut,                                 // Chiều dài của nút
                chieuRongNut,                                // Chiều rộng của nút
                viTriChu,                                    // Vị trí của chữ trên nút
                "<html><br>Số Hiệu: " + this.dsTau.get(0).getSoHieu() +  // Thông tin số hiệu tàu
                        "<br>Số Lượng: " + this.dsTau.get(0).getSoLuongToiDa() + "</html>", // Số lượng ghế tối đa
                40                                           // Kích thước chữ (hoặc tham số tùy chỉnh khác)
        );

        nutTau1.setActionCommand(this.dsTau.get(0).getSoHieu());
        nutTau1.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        nutTau1.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutTau1.setForeground(trang);
        nutTau1.setBackground(trang);
        nutTau1.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutTau1.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutTau1.setBorder(null);
        nutTau1.setEnabled(coQuaGaTau1);
        nutTau1.addMouseListener(this.thaoTacChuot);
        nutTau1.addActionListener(this.hanhDong);
        thanhDinhHuong.add(nutTau1);

        // Tạo Nút đến trang bán hàng
        /* Tạo nút ảnh với việc truyền đừờng dẫn ảnh chính, ảnh đang chọn,
        chiều dài ảnh, chiều rộng ảnh,chiều dài của chữ và chữ và vị trí x của chữ */
        this.nutTau2 = new NutAnh(
                "assets/tau.png",             // Đường dẫn ảnh không được chọn
                "assets/tau-dang-chon.png",                  // Đường dẫn ảnh khi được chọn
                chieuDaiNut,                                 // Chiều dài của nút
                chieuRongNut,                                // Chiều rộng của nút
                viTriChu,                                    // Vị trí của chữ trên nút
                "<html><br>Số Hiệu: " + this.dsTau.get(1).getSoHieu() +  // Thông tin số hiệu tàu
                        "<br>Số Lượng: " + this.dsTau.get(1).getSoLuongToiDa() + "</html>", // Số lượng ghế tối đa
                40                                           // Kích thước chữ (hoặc tham số tùy chỉnh khác)
        );

        nutTau2.setActionCommand(this.dsTau.get(1).getSoHieu());
        nutTau2.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        nutTau2.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutTau2.setForeground(trang);
        nutTau2.setBackground(trang);
        nutTau2.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutTau2.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutTau2.setBorder(null);
        nutTau2.setEnabled(coQuaGaTau2);
        nutTau2.addMouseListener(this.thaoTacChuot);
        nutTau2.addActionListener(this.hanhDong);
        thanhDinhHuong.add(nutTau2);

        // Tạo Nút đến trang bán hàng
        /* Tạo nút ảnh với việc truyền đừờng dẫn ảnh chính, ảnh đang chọn,
        chiều dài ảnh, chiều rộng ảnh,chiều dài của chữ và chữ và vị trí x của chữ */
        this.nutTau3 = new NutAnh(
                "assets/tau.png",             // Đường dẫn ảnh không được chọn
                "assets/tau-dang-chon.png",                  // Đường dẫn ảnh khi được chọn
                chieuDaiNut,                                 // Chiều dài của nút
                chieuRongNut,                                // Chiều rộng của nút
                viTriChu,                                    // Vị trí của chữ trên nút
                "<html><br>Số Hiệu: " + this.dsTau.get(2).getSoHieu() +  // Thông tin số hiệu tàu
                        "<br>Số Lượng: " + this.dsTau.get(2).getSoLuongToiDa() + "</html>", // Số lượng ghế tối đa
                40                                           // Kích thước chữ (hoặc tham số tùy chỉnh khác)
        );

        nutTau3.setActionCommand(this.dsTau.get(2).getSoHieu());
        nutTau3.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        nutTau3.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutTau3.setForeground(trang);
        nutTau3.setBackground(trang);
        nutTau3.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutTau3.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutTau3.setBorder(null);
        nutTau3.setEnabled(coQuaGaTau3);
        nutTau3.addMouseListener(this.thaoTacChuot);
        nutTau3.addActionListener(this.hanhDong);
        //nutTau3.setEnabled(false);
        thanhDinhHuong.add(nutTau3);

        // Tạo Nút đến trang bán hàng
        /* Tạo nút ảnh với việc truyền đừờng dẫn ảnh chính, ảnh đang chọn,
        chiều dài ảnh, chiều rộng ảnh,chiều dài của chữ và chữ và vị trí x của chữ */
        this.nutTau4 = new NutAnh(
                "assets/tau.png",             // Đường dẫn ảnh không được chọn
                "assets/tau-dang-chon.png",                  // Đường dẫn ảnh khi được chọn
                chieuDaiNut,                                 // Chiều dài của nút
                chieuRongNut,                                // Chiều rộng của nút
                viTriChu,                                    // Vị trí của chữ trên nút
                "<html><br>Số Hiệu: " + this.dsTau.get(3).getSoHieu() +  // Thông tin số hiệu tàu
                        "<br>Số Lượng: " + this.dsTau.get(3).getSoLuongToiDa() + "</html>", // Số lượng ghế tối đa
                40                                           // Kích thước chữ (hoặc tham số tùy chỉnh khác)
        );

        nutTau4.setActionCommand(this.dsTau.get(3).getSoHieu());
        nutTau4.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        nutTau4.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutTau4.setForeground(trang);
        nutTau4.setBackground(trang);
        nutTau4.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutTau4.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutTau4.setBorder(null);
        nutTau4.setEnabled(coQuaGaTau4);
        nutTau4.addMouseListener(this.thaoTacChuot);
        nutTau4.addActionListener(this.hanhDong);
        //nutTau4.setEnabled(false);
        thanhDinhHuong.add(nutTau4);

        add(thanhDinhHuong, BorderLayout.NORTH);
    }

    public void taoTrangChua() {
        // Khởi tạo trang chứa các trang khác
        this.trangChua = new JPanel();
        this.trangChua.setPreferredSize(new Dimension(1200, 600));
        this.trangChua.setLayout(new CardLayout());

        this.trangCacToa1 = new TrangCacToa(1, this.dsTau.get(0).getSoHieu(), this.dsToa1, this.gheDao);
        this.trangCacToa2 = new TrangCacToa(2, this.dsTau.get(1).getSoHieu(), this.dsToa2, this.gheDao);
        this.trangCacToa3 = new TrangCacToa(1, this.dsTau.get(0).getSoHieu(), this.dsToa3, this.gheDao);
        this.trangCacToa4 = new TrangCacToa(2, this.dsTau.get(1).getSoHieu(), this.dsToa4, this.gheDao);

        this.trangChua.add(trangCacToa1, "Cac toa cua tau 1");
        this.trangChua.add(trangCacToa2, "Cac toa cua tau 2");
        this.trangChua.add(trangCacToa3, "Cac toa cua tau 3");
        this.trangChua.add(trangCacToa4, "Cac toa cua tau 4");

        add(this.trangChua);
    }

    public String laySoHieuTauChon() {
        return this.soHieuTauChon;
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            TrangCacTau trangMoi = new TrangCacTau();
            trangMoi.setVisible(true);
        });
    }*/
}
