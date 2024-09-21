package app.giao_dien;

import app.phong_chu_moi.PhongChuMoi;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class TrangDatVe extends JPanel {
    /* Khoi tao Cac thanh phan */
    public JButton nutDSVe;
    public JComboBox<String> thanhCacDiemDi;
    public JComboBox<String> thanhCacDiemDen;
    public JRadioButton nutLuaChonMotChieu;
    public JRadioButton nutLuaChonKhuHoi;
    public JTextField thanhNhapNgayDi;
    public JTextField thanhNhapNgayDen;
    public JTextField thanhNhapGioDen;
    public JComboBox<String> thanhCacLoaiGhe;
    public JTextField thanhSoLuongTreEm;
    public JTextField thanhSoLuongNguoiLon;
    public JTextField thanhNhapViTriGhe;

    /* Khoi Tao Phong Chu Mau Sac */
    public int chieuDaiNut = 210;
    public int chieuRongNut = 30;
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public Color trang = new Color(255, 255, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    public Border vienNhat = BorderFactory.createMatteBorder(1, 1, 1, 1, xanhNhat);
    public Border vienDam = BorderFactory.createMatteBorder(1, 1, 1, 1, xanhBrandeis);
    public Border gachChanNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhNhat);
    public Border gachChanDam = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis);

    private ActionListener hanhDong;
    private MouseListener thaoTacChuot;

    public TrangDatVe() {
        setPreferredSize(new Dimension(1200, 700));
        setLayout(new BorderLayout());
        setFont(this.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 13));

        taoDonThongTinVe();
        taoTrangThongTinKhachHang();
        taoTrangChuaNutDS();
    }

    private void taoDonThongTinVe() {
        JPanel trangChuaDonDat = new JPanel();
        trangChuaDonDat.setPreferredSize(new Dimension(600, 700));
        trangChuaDonDat.setBackground(trang);
        trangChuaDonDat.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        // Tạo đường viền tùy chỉnh đường
        MatteBorder duongVienTuyChinh = BorderFactory.createMatteBorder(2, 0, 0, 0, xanhBrandeis);

        // Tạo đường viền có tiêu đề
        TitledBorder duongVienChu = BorderFactory.createTitledBorder(
                duongVienTuyChinh,
                "  Thông Tin Vé    ",
                TitledBorder.TOP,
                TitledBorder.TOP,
                phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 14),
                xanhBrandeis);

        JPanel trangChuaTieuDe = new JPanel();
        trangChuaTieuDe.setPreferredSize(new Dimension(500, 40));
        trangChuaTieuDe.setBackground(trang);
        trangChuaTieuDe.setBorder(duongVienChu);
        trangChuaDonDat.setBackground(trang);

        // Tạo đơn đặt vé
        JPanel donDatVe = new JPanel();
        donDatVe.setPreferredSize(new Dimension(500, 600));
        donDatVe.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        donDatVe.setBackground(trang);
        donDatVe.setBorder(vienDam);

        JLabel tieuDeDiemDi = new JLabel("Điểm đi:");
        tieuDeDiemDi.setForeground(xanhBrandeis);
        tieuDeDiemDi.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeDiemDi.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 12));
        donDatVe.add(tieuDeDiemDi);

        thanhCacDiemDi = new JComboBox<>();
        thanhCacDiemDi.setForeground(xanhBrandeis);
        thanhCacDiemDi.setBackground(trang);
        thanhCacDiemDi.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        thanhCacDiemDi.setBorder(vienDam);
        thanhCacDiemDi.setFocusable(false);
        thanhCacDiemDi.addItem("Tất cả");
        thanhCacDiemDi.addItem("Cà phê");
        thanhCacDiemDi.addItem("Soda");
        thanhCacDiemDi.addItem("Kem");
        thanhCacDiemDi.setPreferredSize(new Dimension(chieuDaiNut, 25));
        donDatVe.add(thanhCacDiemDi);

        JLabel tieuDeDiemDen = new JLabel("Điểm đến:");
        tieuDeDiemDen.setForeground(xanhBrandeis);
        tieuDeDiemDen.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeDiemDen.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 12));
        donDatVe.add(tieuDeDiemDen);

        thanhCacDiemDen = new JComboBox<>();
        thanhCacDiemDen.setForeground(xanhBrandeis);
        thanhCacDiemDen.setBackground(trang);
        thanhCacDiemDen.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        thanhCacDiemDen.setBorder(vienDam);
        thanhCacDiemDen.setFocusable(false);
        thanhCacDiemDen.addItem("Tất cả");
        thanhCacDiemDen.addItem("Cà phê");
        thanhCacDiemDen.addItem("Soda");
        thanhCacDiemDen.addItem("Kem");
        thanhCacDiemDen.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        donDatVe.add(thanhCacDiemDen);

        JLabel tieuDeLoaiVe = new JLabel("Loại Vé:");
        tieuDeLoaiVe.setForeground(xanhBrandeis);
        tieuDeLoaiVe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeLoaiVe.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 12));
        donDatVe.add(tieuDeLoaiVe);

        // Tạo nút lựa chọn 1 chiều
        nutLuaChonMotChieu = new JRadioButton("Một Chiều");
        nutLuaChonMotChieu.setPreferredSize(new Dimension(chieuDaiNut / 2 - 10, chieuRongNut));
        nutLuaChonMotChieu.setForeground(xanhBrandeis);
        nutLuaChonMotChieu.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        nutLuaChonMotChieu.setBackground(trang);
        nutLuaChonMotChieu.setFocusPainted(false);
        nutLuaChonMotChieu.setContentAreaFilled(false);
        nutLuaChonMotChieu.setOpaque(false);
        nutLuaChonMotChieu.setBorder(vienDam);
        nutLuaChonMotChieu.setHorizontalTextPosition(SwingConstants.LEFT);
        donDatVe.add(nutLuaChonMotChieu);

        // Tạo nút lựa chọn khứ hồi
        nutLuaChonKhuHoi = new JRadioButton("Khứ Hồi");
        nutLuaChonKhuHoi.setOpaque(false);
        nutLuaChonKhuHoi.setPreferredSize(new Dimension(chieuDaiNut / 2 - 10, chieuRongNut));
        nutLuaChonKhuHoi.setForeground(xanhBrandeis);
        nutLuaChonKhuHoi.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        nutLuaChonKhuHoi.setBackground(trang);
        nutLuaChonKhuHoi.setFocusPainted(false);
        nutLuaChonKhuHoi.setBorder(vienDam);
        nutLuaChonKhuHoi.setContentAreaFilled(false);
        nutLuaChonKhuHoi.setHorizontalTextPosition(SwingConstants.LEFT);
        donDatVe.add(nutLuaChonKhuHoi);

        JLabel tieuDeNgayDi = new JLabel("Ngày đi:");
        tieuDeNgayDi.setForeground(xanhBrandeis);
        tieuDeNgayDi.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeNgayDi.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 12));
        donDatVe.add(tieuDeNgayDi);

        thanhNhapNgayDi = new JTextField();
        thanhNhapNgayDi.setForeground(xanhBrandeis);
        thanhNhapNgayDi.setBackground(trang);
        thanhNhapNgayDi.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        thanhNhapNgayDi.setBorder(gachChanDam);
        thanhNhapNgayDi.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut + 1));
        donDatVe.add(thanhNhapNgayDi);

        JLabel tieuDeNgayDen = new JLabel("Ngày Trở Về:");
        tieuDeNgayDen.setForeground(xanhBrandeis);
        tieuDeNgayDen.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeNgayDen.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 12));
        donDatVe.add(tieuDeNgayDen);

        thanhNhapNgayDen = new JTextField();
        thanhNhapNgayDen.setForeground(xanhBrandeis);
        thanhNhapNgayDen.setBackground(trang);
        thanhNhapNgayDen.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        thanhNhapNgayDen.setBorder(gachChanDam);
        thanhNhapNgayDen.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        donDatVe.add(thanhNhapNgayDen);

        JLabel tieuDeGioDen = new JLabel("Giờ Đến:");
        tieuDeGioDen.setForeground(xanhBrandeis);
        tieuDeGioDen.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeGioDen.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 12));
        donDatVe.add(tieuDeGioDen);

        thanhNhapGioDen = new JTextField();
        thanhNhapGioDen.setForeground(xanhBrandeis);
        thanhNhapGioDen.setBackground(trang);
        thanhNhapGioDen.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        thanhNhapGioDen.setBorder(gachChanDam);
        thanhNhapGioDen.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        donDatVe.add(thanhNhapGioDen);

        JLabel tieuDeLoaiGhe = new JLabel("Loại Ghế:");
        tieuDeLoaiGhe.setForeground(xanhBrandeis);
        tieuDeLoaiGhe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeLoaiGhe.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 12));
        donDatVe.add(tieuDeLoaiGhe);

        thanhCacLoaiGhe = new JComboBox<>();
        thanhCacLoaiGhe.setForeground(xanhBrandeis);
        thanhCacLoaiGhe.setBackground(trang);
        thanhCacLoaiGhe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        thanhCacLoaiGhe.setBorder(vienDam);
        thanhCacLoaiGhe.setFocusable(false);
        thanhCacLoaiGhe.addItem("Tất cả");
        thanhCacLoaiGhe.addItem("Cà phê");
        thanhCacLoaiGhe.addItem("Soda");
        thanhCacLoaiGhe.addItem("Kem");
        thanhCacLoaiGhe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        donDatVe.add(thanhCacLoaiGhe);

        JLabel tieuDeSoLuong = new JLabel("Số Lượng:");
        tieuDeSoLuong.setForeground(xanhBrandeis);
        tieuDeSoLuong.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeSoLuong.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 12));
        tieuDeSoLuong.setBackground(Color.cyan);
        donDatVe.add(tieuDeSoLuong);

        thanhSoLuongTreEm = new JTextField();
        thanhSoLuongTreEm.setForeground(xanhBrandeis);
        thanhSoLuongTreEm.setBackground(trang);
        thanhSoLuongTreEm.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        thanhSoLuongTreEm.setBorder(vienDam);
        thanhSoLuongTreEm.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        donDatVe.add(thanhSoLuongTreEm);

        JLabel tieuDeSoLuongRong = new JLabel();
        tieuDeSoLuongRong.setForeground(xanhBrandeis);
        tieuDeSoLuongRong.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeSoLuongRong.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 12));
        tieuDeSoLuongRong.setBackground(Color.cyan);
        donDatVe.add(tieuDeSoLuongRong);

        thanhSoLuongNguoiLon = new JTextField();
        thanhSoLuongNguoiLon.setForeground(xanhBrandeis);
        thanhSoLuongNguoiLon.setBackground(trang);
        thanhSoLuongNguoiLon.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        thanhSoLuongNguoiLon.setBorder(vienDam);
        thanhSoLuongNguoiLon.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        donDatVe.add(thanhSoLuongNguoiLon);

        JLabel tieuDeViTriGhe = new JLabel("Loại Ghế:");
        tieuDeViTriGhe.setForeground(xanhBrandeis);
        tieuDeViTriGhe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeViTriGhe.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 12));
        donDatVe.add(tieuDeViTriGhe);

        thanhNhapViTriGhe = new JTextField();
        thanhNhapViTriGhe.setForeground(xanhBrandeis);
        thanhNhapViTriGhe.setBackground(trang);
        thanhNhapViTriGhe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        thanhNhapViTriGhe.setBorder(gachChanDam);
        thanhNhapViTriGhe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        donDatVe.add(thanhNhapViTriGhe);

        trangChuaDonDat.add(trangChuaTieuDe);
        trangChuaDonDat.add(donDatVe);
        add(trangChuaDonDat, BorderLayout.WEST);
    }

    private void taoTrangThongTinKhachHang() {
        JPanel trangChuaDonTT = new JPanel();
        trangChuaDonTT.setPreferredSize(new Dimension(600, 700));
        trangChuaDonTT.setLayout(new BorderLayout());

        JPanel donThongTinKH = new JPanel();
        donThongTinKH.setBackground(new Color(100, 255, 255));
        donThongTinKH.setPreferredSize(new Dimension(400, 600));
        trangChuaDonTT.add(donThongTinKH, BorderLayout.WEST);

        JPanel cachBang = new JPanel();
        cachBang.setOpaque(false);
        cachBang.setPreferredSize(new Dimension(200, 600));
        trangChuaDonTT.add(cachBang, BorderLayout.CENTER);

        add(trangChuaDonTT, BorderLayout.CENTER);
    }

    private void taoTrangChuaNutDS() {
        JPanel trangChuaNutDS = new JPanel();
        trangChuaNutDS.setPreferredSize(new Dimension(1200, 40));
        trangChuaNutDS.setBackground(new Color(255, 255, 255));
        trangChuaNutDS.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        this.nutDSVe = new JButton("Danh Sách Vé");
        this.nutDSVe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 14));
        this.nutDSVe.setPreferredSize(new Dimension(150, chieuRongNut));
        this.nutDSVe.setForeground(new Color(trang.getRGB()));
        this.nutDSVe.setBackground(new Color(xanhBrandeis.getRGB()));
        this.nutDSVe.setFocusPainted(false); // Bỏ viền khi click (focus)
        this.nutDSVe.setBorderPainted(false); // Bỏ viền của nút
        // this.nutDSVe.addActionListener(hanhDong);
        // this.nutDSVe.addMouseListener(thaoTacChuot);
        trangChuaNutDS.add(nutDSVe);

        add(trangChuaNutDS, BorderLayout.NORTH);
    }
}
