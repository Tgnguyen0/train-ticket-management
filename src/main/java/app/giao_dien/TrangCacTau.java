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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TrangCacTau extends JFrame {
    public JPanel trangGoc;
    public JFrame trangKhung;
    public JPanel trangChua;
    public NutAnh nutTau1;
    public NutAnh nutTau2;
    public NutAnh nutTau3;
    public NutAnh nutTau4;
    public JButton nutXacNhan;

    /*public TrangCacToa trangCacToa1;
    public TrangCacToa trangCacToa2;
    public TrangCacToa trangCacToa3;
    public TrangCacToa trangCacToa4;*/

    private List<TrangCacToa> dsTrangCacToa = new ArrayList<>();
    private List<Boolean> coHieuTauCoQuaGa; // Store the coQuaGa flags dynamically

    /* Khởi tạo phông chữ màu sắc */
    public Color trang = new Color(255, 255, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    public Color camNhuomDen = new Color(253, 126, 20);
    public Color doDo = new Color(220, 53, 69);
    public PhongChuMoi phongTuyChinh = new PhongChuMoi();
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
    /*public List<Toa> dsToa1;
    public List<Toa> dsToa2;
    public List<Toa> dsToa3;
    public List<Toa> dsToa4;*/
    public List<LichCapBenGa> dsLichTau;

    public String soHieuTauChon;
    //public int soLuongKhachDat;
    public String maGa;

    /*public boolean coQuaGaTau1 = false;
    public boolean coQuaGaTau2 = false;
    public boolean coQuaGaTau3 = false;
    public boolean coQuaGaTau4 = false;*/

    // Function tạo GUI chính
    public TrangCacTau(JPanel trang, JFrame trangKhung,List<Tau> dsTau, Ghe_DAO gheDao, List<LichCapBenGa> dsLichTau) {
        this.trangGoc = trang;
        this.trangKhung = trangKhung;
        this.toaDao = new Toa_DAO();
        this.gheDao = gheDao;
        this.coHieuTauCoQuaGa = new ArrayList<>(Collections.nCopies(4, false));

        this.dsTau = dsTau;
        this.dsLichTau = dsLichTau;

        /*for (int i = 0 ; i < this.dsLichTau.size() ; i++) {
            System.out.println(this.dsLichTau.get(i).getMaTau());
        }*/

        /*for (int i = 0 ; i < this.dsToa1.size() ; i++) {
            System.out.println("Tau 1" + this.dsToa1.get(i).getMaToa());
        }

        for (int i = 0 ; i < this.dsToa2.size() ; i++) {
            System.out.println("Tau 2" + this.dsToa2.get(i).getMaToa());
        }

        for (int i = 0 ; i < this.dsToa3.size() ; i++) {
            System.out.println("Tau 3" + this.dsToa3.get(i).getMaToa());
        }

        for (int i = 0 ; i < this.dsToa4.size() ; i++) {
            System.out.println("Tau 4" + this.dsToa4.get(i).getMaToa());
        }*/

        ImageIcon icon = new ImageIcon("assets/icon.png");
        setTitle("Sơ đồ chung");
        //setSize(new Dimension(1200, 800));
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(true);
        setLayout(new FlowLayout(FlowLayout.CENTER));

        // Thêm ActionListener và MouseListener cho các nút
        this.hanhDong = new HanhDong_TrangCacTau(this);
        this.thaoTacChuot = new HanhDong_TrangCacTau(this);
        this.hanhDongTrang = new HanhDong_TrangCacTau(this);

        this.addWindowListener(hanhDongTrang);

        taoThanhDinhHuongToa();
        taoTrangChua();
        taoTrangHuongDan();
        taoThanhXacNhan();
    }

    public void taoThanhDinhHuongToa() {
        JPanel thanhDinhHuong = new JPanel();
        thanhDinhHuong.setPreferredSize(new Dimension(1200, chieuRongNut + 40));
        thanhDinhHuong.setBackground(trang);
        thanhDinhHuong.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));

        for (int i = 0; i < this.dsLichTau.size(); i++) {
            String maTau = dsLichTau.get(i).getMaTau();

            switch (maTau) {
                case "VN5234":
                    coHieuTauCoQuaGa.set(0, true);
                    //this.coQuaGaTau1 = true;
                    break;
                case "VN5947":
                    coHieuTauCoQuaGa.set(1, true);
                    //this.coQuaGaTau2 = true;
                    break;
                case "VN7283":
                    coHieuTauCoQuaGa.set(2, true);
                    //this.coQuaGaTau3 = true;
                    break;
                case "VN9029":
                    coHieuTauCoQuaGa.set(3, true);
                    //this.coQuaGaTau4 = true;
                    break;
            }
        }

        /*System.out.println("Tau VN5234 co qua: " + (coQuaGaTau1 ? "True" : "False"));
        System.out.println("Tau VN5947 co qua: " + (coQuaGaTau2 ? "True" : "False"));
        System.out.println("Tau VN7283 co qua: " + (coQuaGaTau3 ? "True" : "False"));
        System.out.println("Tau VN9029 co qua: " + (coQuaGaTau4 ? "True" : "False"));*/

        // Tạo Nút dẫn đến trang chủ
        /* Tạo nút ảnh với việc truyền đừờng dẫn ảnh chính, ảnh đang chọn,
        chiều dài ảnh, chiều rộng ảnh,chiều dài của chữ và chữ và vị trí x của chữ */
        this.nutTau1 = new NutAnh(
                "assets/tau.png",             // Đường dẫn ảnh không được chọn
                "assets/tau-dang-chon.png",                  // Đường dẫn ảnh khi được chọn
                "assets/tau-vo-hieu.png",                    // Đường dẫn ảnh khi bị vô hiệu
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
        nutTau1.setEnabled(coHieuTauCoQuaGa.get(0));

        if (!nutTau1.isEnabled()) {
            nutTau1.datAnhVoHieu();
        }

        nutTau1.addMouseListener(this.thaoTacChuot);
        nutTau1.addActionListener(this.hanhDong);
        thanhDinhHuong.add(nutTau1);

        // Tạo Nút đến trang bán hàng
        /* Tạo nút ảnh với việc truyền đừờng dẫn ảnh chính, ảnh đang chọn,
        chiều dài ảnh, chiều rộng ảnh,chiều dài của chữ và chữ và vị trí x của chữ */
        this.nutTau2 = new NutAnh(
                "assets/tau.png",             // Đường dẫn ảnh không được chọn
                "assets/tau-dang-chon.png",                  // Đường dẫn ảnh khi được chọn
                "assets/tau-vo-hieu.png",                    // Đường dẫn ảnh khi bị vô hiệu
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
        nutTau2.setEnabled(coHieuTauCoQuaGa.get(1));

        if (!nutTau2.isEnabled()) {
            nutTau2.datAnhVoHieu();
        }

        nutTau2.addMouseListener(this.thaoTacChuot);
        nutTau2.addActionListener(this.hanhDong);
        thanhDinhHuong.add(nutTau2);

        // Tạo Nút đến trang bán hàng
        /* Tạo nút ảnh với việc truyền đừờng dẫn ảnh chính, ảnh đang chọn,
        chiều dài ảnh, chiều rộng ảnh,chiều dài của chữ và chữ và vị trí x của chữ */
        this.nutTau3 = new NutAnh(
                "assets/tau.png",             // Đường dẫn ảnh không được chọn
                "assets/tau-dang-chon.png",                  // Đường dẫn ảnh khi được chọn
                "assets/tau-vo-hieu.png",                    // Đường dẫn ảnh khi bị vô hiệu
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
        nutTau3.setEnabled(coHieuTauCoQuaGa.get(2));

        if (!nutTau3.isEnabled()) {
            nutTau3.datAnhVoHieu();
        }

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
                "assets/tau-vo-hieu.png",                    // Đường dẫn ảnh khi bị vô hiệu
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
        nutTau4.setEnabled(coHieuTauCoQuaGa.get(3));

        if (!nutTau4.isEnabled()) {
            nutTau4.datAnhVoHieu();
        }

        nutTau4.addMouseListener(this.thaoTacChuot);
        nutTau4.addActionListener(this.hanhDong);
        //nutTau4.setEnabled(false);
        thanhDinhHuong.add(nutTau4);

        if (this.gheDao.layDSGheDat() != null || !this.gheDao.layDSGheDat().isEmpty()) {
            Toa_DAO toaDao = new Toa_DAO();

            for (Ghe ghe : this.gheDao.layDSGheDat()) {
                Toa toaDaChon = toaDao.ChonTheoMa(ghe.getMaToa());

                if (nutTau1.getActionCommand().equals(toaDaChon.getMaTau())) {
                    nutTau1.datAnhDangChon();
                }

                if (nutTau2.getActionCommand().equals(toaDaChon.getMaTau())) {
                    nutTau2.datAnhDangChon();
                }

                if (nutTau3.getActionCommand().equals(toaDaChon.getMaTau())) {
                    nutTau3.datAnhDangChon();
                }

                if (nutTau4.getActionCommand().equals(toaDaChon.getMaTau())) {
                    nutTau4.datAnhDangChon();
                }
            }

        }

        add(thanhDinhHuong, BorderLayout.NORTH);
    }

    public void taoTrangChua() {
        // Khởi tạo trang chứa các trang khác
        this.trangChua = new JPanel();
        this.trangChua.setPreferredSize(new Dimension(1200, 390));
        this.trangChua.setLayout(new CardLayout());

        /*this.dsToa1 = toaDao.ChonTheoSoHieuTatCa(this.dsTau.get(0).getSoHieu());
        this.dsToa2 = toaDao.ChonTheoSoHieuTatCa(this.dsTau.get(1).getSoHieu());
        this.dsToa3 = toaDao.ChonTheoSoHieuTatCa(this.dsTau.get(2).getSoHieu());
        this.dsToa4 = toaDao.ChonTheoSoHieuTatCa(this.dsTau.get(3).getSoHieu());

        if (coQuaGaTau1) this.trangCacToa1 = new TrangCacToa(1, this.dsTau.get(0).getSoHieu(), toaDao.ChonTheoSoHieuTatCa(this.dsTau.get(0).getSoHieu()), this.gheDao);
        if (coQuaGaTau2) this.trangCacToa2 = new TrangCacToa(2, this.dsTau.get(1).getSoHieu(), toaDao.ChonTheoSoHieuTatCa(this.dsTau.get(1).getSoHieu()), this.gheDao);
        if (coQuaGaTau3) this.trangCacToa3 = new TrangCacToa(3, this.dsTau.get(2).getSoHieu(), toaDao.ChonTheoSoHieuTatCa(this.dsTau.get(2).getSoHieu()), this.gheDao);
        if (coQuaGaTau4) this.trangCacToa4 = new TrangCacToa(4, this.dsTau.get(3).getSoHieu(), toaDao.ChonTheoSoHieuTatCa(this.dsTau.get(3).getSoHieu()), this.gheDao);

        if (coQuaGaTau1) this.trangChua.add(trangCacToa1, "Cac toa cua tau 1");
        if (coQuaGaTau2) this.trangChua.add(trangCacToa2, "Cac toa cua tau 2");
        if (coQuaGaTau3) this.trangChua.add(trangCacToa3, "Cac toa cua tau 3");
        if (coQuaGaTau4) this.trangChua.add(trangCacToa4, "Cac toa cua tau 4");*/

        khoiTaoTrangCacToa();

        add(this.trangChua);
    }

    /*public String laySoHieuTauChon() {
        return this.soHieuTauChon;
    }*/

    /*public void datSoHieuTauChon(String soHieu) {
        this.soHieuTauChon = soHieu;
    }*/

    /*public String layMaGa() {
        return this.maGa;
    }*/

    public void datMaGa(String maGa) {
        this.maGa = maGa;
    }

    private void khoiTaoTrangCacToa() {
        for (int i = 0; i < coHieuTauCoQuaGa.size(); i++) {
            if (coHieuTauCoQuaGa.get(i)) {
                TrangCacToa trangCacToa = new TrangCacToa(
                        (i + 1),
                        this.dsTau.get(i).getSoHieu(),
                        toaDao.ChonTheoSoHieuTatCa(this.dsTau.get(i).getSoHieu()),
                        this.gheDao
                );

                this.trangChua.add(trangCacToa, "Cac toa cua tau " + (i + 1));
            } else {
                dsTrangCacToa.add(null);
            }
        }
    }

    public void taoTrangHuongDan() {
        JPanel trangHuongDan = new JPanel(new FlowLayout(FlowLayout.CENTER));
        trangHuongDan.setPreferredSize(new Dimension(1200, 60));
        trangHuongDan.setBackground(trang);

        themBieuTuongVaTieuDe(trangHuongDan, "Chỗ còn trống", xanhBrandeis);
        themBieuTuongVaTieuDe(trangHuongDan, "Chỗ đã mua", doDo);
        themBieuTuongVaTieuDe(trangHuongDan, "Chỗ đang chọn", camNhuomDen);

        add(trangHuongDan);
    }

    private void themBieuTuongVaTieuDe(JPanel trangHienTai, String cau, Color mau) {
        JPanel trangChuaTieuDeVaBieuTuong = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        trangChuaTieuDeVaBieuTuong.setPreferredSize(new Dimension(250, 50));
        trangChuaTieuDeVaBieuTuong.setBackground(trang);

        JButton nutBieuTuong = new JButton("");
        nutBieuTuong.setPreferredSize(new Dimension(50, 50));
        nutBieuTuong.setBackground(mau);
        nutBieuTuong.setForeground(trang);
        nutBieuTuong.setFocusPainted(false);
        nutBieuTuong.setBorderPainted(false);

        JLabel tieuDe = new JLabel(cau, SwingConstants.LEFT);
        tieuDe.setPreferredSize(new Dimension(140, 50));
        tieuDe.setForeground(xanhBrandeis);
        tieuDe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));

        trangChuaTieuDeVaBieuTuong.add(nutBieuTuong);
        trangChuaTieuDeVaBieuTuong.add(tieuDe);

        trangHienTai.add(trangChuaTieuDeVaBieuTuong);
    }

    public void taoThanhXacNhan() {
        JPanel thanhXacNhan = new JPanel();
        thanhXacNhan.setPreferredSize(new Dimension(1520, 50));
        thanhXacNhan.setBackground(trang);
        thanhXacNhan.setLayout(new FlowLayout(FlowLayout.RIGHT));

        this.nutXacNhan = new JButton("Xác nhận");
        this.nutXacNhan.setPreferredSize(new Dimension(100, 40));
        this.nutXacNhan.setBackground(xanhBrandeis);
        this.nutXacNhan.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 13));
        this.nutXacNhan.setForeground(trang);
        this.nutXacNhan.setFocusPainted(false);
        this.nutXacNhan.setBorderPainted(false);
        this.nutXacNhan.addActionListener(hanhDong);

        thanhXacNhan.add(nutXacNhan);

        add(thanhXacNhan);
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            TrangCacTau trangMoi = new TrangCacTau();
            trangMoi.setVisible(true);
        });
    }*/
}
