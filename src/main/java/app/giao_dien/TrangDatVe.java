package app.giao_dien;

import app.dao.Ghe_DAO;
import app.dieu_khien.HanhDong_TrangDatVe;
import app.phan_tu_tuy_chinh.CustomComboBoxRenderer;
import app.phong_chu_moi.PhongChuMoi;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;

public class TrangDatVe extends JPanel {
    /* Khoi tao Cac thanh phan */
    public JButton nutDSVe;
    public JComboBox<String> thanhCacDiemDi;
    public JComboBox<String> thanhCacDiemDen;
    public JRadioButton nutLuaChonMotChieu;
    public JRadioButton nutLuaChonKhuHoi;
    public JDateChooser thanhNhapNgayDi;
    public JDateChooser thanhNhapNgayTroVe;
    public JTextField thanhNhapGioDen;
    public JComboBox<String> thanhCacLoaiGhe;
    public JButton nutGiamSoLuongTreEm;
    public JTextField thanhSoLuongTreEm;
    public JButton nutTangSoLuongTreEm;
    public JButton nutGiamSoLuongNguoiLon;
    public JTextField thanhSoLuongNguoiLon;
    public JButton nutTangSoLuongNguoiLon;
    public JButton nutHienThiSoDoGhe;
    public JTextField thanhNhapHoTen;
    public JTextField thanhNhapDienThoai;
    public JRadioButton nutLuaChonNam;
    public JRadioButton nutLuaChonNu;
    public JTextField thanhNhapThuDienTu;
    public JDateChooser thanhNhapNgaySinh;
    public JTextArea thanhNhapGhiChu;
    public JTextField thanhNhapTongTien;
    public JButton nutThanhToan;
    public JPanel trangDonDatVe;

    /* Khoi Tao Phong Chu Mau Sac */
    public int kichThuocChu = 12;
    public int chieuDaiNut = 210;
    public int chieuRongNut = 30;
    public PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public Color trang = new Color(255, 255, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Border vienNhat = BorderFactory.createLineBorder(xanhNhat);
    public Border vienDam = BorderFactory.createLineBorder(xanhBrandeis);
    public Border gachChanNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhNhat);
    public Border gachChanDam = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis);

    private ActionListener hanhDong;
    private MouseListener thaoTacChuot;
    private ItemListener mucDaChon;
    public Ghe_DAO gheDao;

    public TrangDatVe() {
        this.gheDao = new Ghe_DAO();

        setPreferredSize(new Dimension(1200, 600));
        setLayout(new BorderLayout());
        setFont(this.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 13));

        trangDonDatVe = new JPanel();
        trangDonDatVe.setPreferredSize(new Dimension(1200, 700));
        trangDonDatVe.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        trangDonDatVe.setBackground(trang);

        this.hanhDong = new HanhDong_TrangDatVe(this);
        this.thaoTacChuot = new HanhDong_TrangDatVe(this);
        this.mucDaChon = new HanhDong_TrangDatVe(this);

        taoTrangChuaNutDS();
        taoDonThongTinVe();
        taoTrangThongTinKhachHang();

        add(trangDonDatVe, BorderLayout.CENTER);
    }

    public Ghe_DAO layGheDao() {
        return this.gheDao;
    }

    private void taoDonThongTinVe() {
        JPanel trangChuaDonDat = new JPanel();
        trangChuaDonDat.setPreferredSize(new Dimension(580, 700));
        trangChuaDonDat.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        trangChuaDonDat.setBackground(trang);

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
        trangChuaTieuDe.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        trangChuaDonDat.add(trangChuaTieuDe);

        // Tạo đơn đặt vé
        JPanel donDatVe = new JPanel();
        donDatVe.setPreferredSize(new Dimension(500, 560));
        donDatVe.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        donDatVe.setBackground(trang);
        donDatVe.setBorder(vienDam);
        trangChuaDonDat.add(donDatVe);

        JLabel tieuDeDiemDi = new JLabel("Điểm đi:");
        tieuDeDiemDi.setForeground(xanhBrandeis);
        tieuDeDiemDi.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeDiemDi.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        donDatVe.add(tieuDeDiemDi);

        thanhCacDiemDi = new JComboBox<>();
        thanhCacDiemDi.setForeground(xanhBrandeis);
        thanhCacDiemDi.setBackground(trang);
        thanhCacDiemDi.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhCacDiemDi.setFocusable(false);
        thanhCacDiemDi.addItem("Sài Gòn");
        thanhCacDiemDi.addItem("Hà Nội");
        thanhCacDiemDi.addItem("Đông Anh");
        thanhCacDiemDi.addItemListener(mucDaChon);
        thanhCacDiemDi.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        thanhCacDiemDi.setRenderer(new CustomComboBoxRenderer());
        donDatVe.add(thanhCacDiemDi);

        JLabel tieuDeDiemDen = new JLabel("Điểm đến:");
        tieuDeDiemDen.setForeground(xanhBrandeis);
        tieuDeDiemDen.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeDiemDen.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        donDatVe.add(tieuDeDiemDen);

        thanhCacDiemDen = new JComboBox<>();
        thanhCacDiemDen.setForeground(xanhBrandeis);
        thanhCacDiemDen.setBackground(trang);
        thanhCacDiemDen.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhCacDiemDen.setFocusable(false);
        thanhCacDiemDen.addItem("Sài Gòn");
        thanhCacDiemDen.addItem("Hà Nội");
        thanhCacDiemDen.addItem("Đông Anh");
        thanhCacDiemDen.addItemListener(mucDaChon);
        thanhCacDiemDen.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        thanhCacDiemDen.setRenderer(new CustomComboBoxRenderer());
        donDatVe.add(thanhCacDiemDen);

        JLabel tieuDeLoaiVe = new JLabel("Loại Vé:");
        tieuDeLoaiVe.setForeground(xanhBrandeis);
        tieuDeLoaiVe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeLoaiVe.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        donDatVe.add(tieuDeLoaiVe);

        // Tạo nút lựa chọn 1 chiều
        nutLuaChonMotChieu = new JRadioButton("Một Chiều");
        nutLuaChonMotChieu.setPreferredSize(new Dimension(chieuDaiNut / 2 - 10, chieuRongNut));
        nutLuaChonMotChieu.setForeground(xanhBrandeis);
        nutLuaChonMotChieu.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        nutLuaChonMotChieu.setBackground(trang);
        nutLuaChonMotChieu.setFocusPainted(false);
        nutLuaChonMotChieu.setContentAreaFilled(false);
        nutLuaChonMotChieu.setOpaque(false);
        nutLuaChonMotChieu.setHorizontalTextPosition(SwingConstants.LEFT);
        nutLuaChonMotChieu.addActionListener(hanhDong);
        donDatVe.add(nutLuaChonMotChieu);

        // Tạo nút lựa chọn khứ hồi
        nutLuaChonKhuHoi = new JRadioButton("Khứ Hồi");
        nutLuaChonKhuHoi.setOpaque(false);
        nutLuaChonKhuHoi.setPreferredSize(new Dimension(chieuDaiNut / 2 - 10, chieuRongNut));
        nutLuaChonKhuHoi.setForeground(xanhBrandeis);
        nutLuaChonKhuHoi.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        nutLuaChonKhuHoi.setBackground(trang);
        nutLuaChonKhuHoi.setFocusPainted(false);
        nutLuaChonKhuHoi.setContentAreaFilled(false);
        nutLuaChonKhuHoi.setHorizontalTextPosition(SwingConstants.LEFT);
        nutLuaChonKhuHoi.addActionListener(hanhDong);
        donDatVe.add(nutLuaChonKhuHoi);

        JLabel tieuDeNgayDi = new JLabel("Ngày Xuất Phát:");
        tieuDeNgayDi.setForeground(xanhBrandeis);
        tieuDeNgayDi.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeNgayDi.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        donDatVe.add(tieuDeNgayDi);

        thanhNhapNgayDi = new JDateChooser();
        thanhNhapNgayDi.setForeground(xanhBrandeis);
        thanhNhapNgayDi.setBackground(trang);
        thanhNhapNgayDi.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhNhapNgayDi.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut + 1));
        thanhNhapNgayDi.setFocusable(false);
        donDatVe.add(thanhNhapNgayDi);

        JLabel tieuDeNgayTroVe = new JLabel("Ngày Trở Về:");
        tieuDeNgayTroVe.setForeground(xanhBrandeis);
        tieuDeNgayTroVe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeNgayTroVe.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        donDatVe.add(tieuDeNgayTroVe);

        thanhNhapNgayTroVe = new JDateChooser();
        thanhNhapNgayTroVe.setForeground(xanhBrandeis);
        thanhNhapNgayTroVe.setBackground(trang);
        thanhNhapNgayTroVe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhNhapNgayTroVe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut + 1));
        thanhNhapNgayTroVe.setFocusable(false);
        donDatVe.add(thanhNhapNgayTroVe);

        JLabel tieuDeGioDen = new JLabel("Giờ Đến:");
        tieuDeGioDen.setForeground(xanhBrandeis);
        tieuDeGioDen.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeGioDen.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        donDatVe.add(tieuDeGioDen);

        thanhNhapGioDen = new JTextField();
        thanhNhapGioDen.setForeground(xanhBrandeis);
        thanhNhapGioDen.setBackground(trang);
        thanhNhapGioDen.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhNhapGioDen.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut + 1));
        donDatVe.add(thanhNhapGioDen);

        JLabel tieuDeLoaiGhe = new JLabel("Loại Ghế:");
        tieuDeLoaiGhe.setForeground(xanhBrandeis);
        tieuDeLoaiGhe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeLoaiGhe.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        donDatVe.add(tieuDeLoaiGhe);

        thanhCacLoaiGhe = new JComboBox<>();
        thanhCacLoaiGhe.setForeground(xanhBrandeis);
        thanhCacLoaiGhe.setBackground(trang);
        thanhCacLoaiGhe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhCacLoaiGhe.setFocusable(false);
        thanhCacLoaiGhe.addItem("Ghế mềm");
        thanhCacLoaiGhe.addItem("Giường nằm 2 tầng");
        thanhCacLoaiGhe.addItem("Giường nằm 3 tầng");
        thanhCacLoaiGhe.addItem("Giường nằm 1 tầng");
        thanhCacLoaiGhe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        thanhCacLoaiGhe.setRenderer(new CustomComboBoxRenderer());
        thanhCacLoaiGhe.addItemListener(mucDaChon);
        donDatVe.add(thanhCacLoaiGhe);

        JLabel tieuDeSoLuong = new JLabel("Số Lượng:");
        tieuDeSoLuong.setForeground(xanhBrandeis);
        tieuDeSoLuong.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeSoLuong.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        tieuDeSoLuong.setBackground(Color.cyan);
        donDatVe.add(tieuDeSoLuong);

        JPanel dongSoLuongTreEm = new JPanel();
        dongSoLuongTreEm.setBackground(trang);
        dongSoLuongTreEm.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        dongSoLuongTreEm.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        donDatVe.add(dongSoLuongTreEm);

        nutGiamSoLuongTreEm = new JButton("<");
        nutGiamSoLuongTreEm.setPreferredSize(new Dimension(20, 20));
        nutGiamSoLuongTreEm.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        nutGiamSoLuongTreEm.setForeground(trang);
        nutGiamSoLuongTreEm.setBorderPainted(false);
        nutGiamSoLuongTreEm.setBackground(xanhBrandeis);
        nutGiamSoLuongTreEm.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutGiamSoLuongTreEm.addActionListener(hanhDong);
        nutGiamSoLuongTreEm.addMouseListener(thaoTacChuot);
        dongSoLuongTreEm.add(nutGiamSoLuongTreEm);

        thanhSoLuongTreEm = new JTextField("0");
        thanhSoLuongTreEm.setHorizontalAlignment(SwingConstants.CENTER);
        thanhSoLuongTreEm.setForeground(xanhBrandeis);
        thanhSoLuongTreEm.setBackground(trang);
        thanhSoLuongTreEm.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhSoLuongTreEm.setPreferredSize(new Dimension(chieuDaiNut - 150, chieuRongNut));
        dongSoLuongTreEm.add(thanhSoLuongTreEm);

        nutTangSoLuongTreEm = new JButton(">");
        nutTangSoLuongTreEm.setPreferredSize(new Dimension(20, 20));
        nutTangSoLuongTreEm.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        nutTangSoLuongTreEm.setForeground(trang);
        nutTangSoLuongTreEm.setBackground(xanhBrandeis);
        nutTangSoLuongTreEm.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutTangSoLuongTreEm.addActionListener(hanhDong);
        nutTangSoLuongTreEm.setBorderPainted(false);
        nutTangSoLuongTreEm.addMouseListener(thaoTacChuot);
        dongSoLuongTreEm.add(nutTangSoLuongTreEm);

        JLabel tieuDeSoLuongRong = new JLabel();
        tieuDeSoLuongRong.setForeground(xanhBrandeis);
        tieuDeSoLuongRong.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeSoLuongRong.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        tieuDeSoLuongRong.setBackground(Color.cyan);
        donDatVe.add(tieuDeSoLuongRong);

        JPanel dongSoLuongNguoiLon = new JPanel();
        dongSoLuongNguoiLon.setBackground(trang);
        dongSoLuongNguoiLon.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut + 1));
        dongSoLuongNguoiLon.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        donDatVe.add(dongSoLuongNguoiLon);

        nutGiamSoLuongNguoiLon = new JButton("<");
        nutGiamSoLuongNguoiLon.setPreferredSize(new Dimension(20, 20));
        nutGiamSoLuongNguoiLon.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        nutGiamSoLuongNguoiLon.setForeground(trang);
        nutGiamSoLuongNguoiLon.setBackground(xanhBrandeis);
        nutGiamSoLuongNguoiLon.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutGiamSoLuongNguoiLon.addActionListener(hanhDong);
        nutGiamSoLuongNguoiLon.setBorderPainted(false);
        nutGiamSoLuongNguoiLon.addMouseListener(thaoTacChuot);
        dongSoLuongNguoiLon.add(nutGiamSoLuongNguoiLon);

        thanhSoLuongNguoiLon = new JTextField("0");
        thanhSoLuongNguoiLon.setHorizontalAlignment(SwingConstants.CENTER);
        thanhSoLuongNguoiLon.setForeground(xanhBrandeis);
        thanhSoLuongNguoiLon.setBackground(trang);
        thanhSoLuongNguoiLon.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhSoLuongNguoiLon.setPreferredSize(new Dimension(chieuDaiNut - 150, chieuRongNut + 1));
        dongSoLuongNguoiLon.add(thanhSoLuongNguoiLon);

        nutTangSoLuongNguoiLon = new JButton(">");
        nutTangSoLuongNguoiLon.setPreferredSize(new Dimension(20, 20));
        nutTangSoLuongNguoiLon.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        nutTangSoLuongNguoiLon.setForeground(trang);
        nutTangSoLuongNguoiLon.setBorderPainted(false);
        nutTangSoLuongNguoiLon.setBackground(xanhBrandeis);
        nutTangSoLuongNguoiLon.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutTangSoLuongNguoiLon.addActionListener(hanhDong);
        nutTangSoLuongNguoiLon.addMouseListener(thaoTacChuot);
        dongSoLuongNguoiLon.add(nutTangSoLuongNguoiLon);

        JLabel tieuDeViTriGhe = new JLabel("Vị trí ghế:");
        tieuDeViTriGhe.setForeground(xanhBrandeis);
        tieuDeViTriGhe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeViTriGhe.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        donDatVe.add(tieuDeViTriGhe);

        nutHienThiSoDoGhe = new JButton("Sơ đồ ghế");
        nutHienThiSoDoGhe.setForeground(trang);
        nutHienThiSoDoGhe.setBackground(xanhBrandeis);
        nutHienThiSoDoGhe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        nutHienThiSoDoGhe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut + 1));
        nutHienThiSoDoGhe.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutHienThiSoDoGhe.setBorderPainted(false);
        nutHienThiSoDoGhe.addActionListener(hanhDong);
        nutHienThiSoDoGhe.addMouseListener(thaoTacChuot);
        donDatVe.add(nutHienThiSoDoGhe);

        trangDonDatVe.add(trangChuaDonDat);
    }

    private void taoTrangThongTinKhachHang() {
        JPanel trangChuaDonTT = new JPanel();
        trangChuaDonTT.setPreferredSize(new Dimension(580, 700));
        trangChuaDonTT.setBackground(trang);
        trangChuaDonTT.setLayout(new BorderLayout());

        JPanel cachDongBac = new JPanel();
        cachDongBac.setPreferredSize(new Dimension(580, 45));
        cachDongBac.setBackground(trang);
        trangChuaDonTT.add(cachDongBac, BorderLayout.NORTH);

        JPanel donThongTinKH = new JPanel();
        // donThongTinKH.setBackground(new Color(100, 255, 255));
        donThongTinKH.setBackground(trang);
        donThongTinKH.setPreferredSize(new Dimension(580, 600));
        donThongTinKH.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        trangChuaDonTT.add(donThongTinKH, BorderLayout.WEST);

        JPanel phanThongTin = new JPanel();
        phanThongTin.setPreferredSize(new Dimension(500, 450));
        phanThongTin.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        phanThongTin.setBackground(trang);
        phanThongTin.setBorder(vienDam);
        donThongTinKH.add(phanThongTin);

        JLabel tieuDeHoTen = new JLabel("Họ tên:");
        tieuDeHoTen.setForeground(xanhBrandeis);
        tieuDeHoTen.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeHoTen.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        phanThongTin.add(tieuDeHoTen);

        thanhNhapHoTen = new JTextField();
        thanhNhapHoTen.setForeground(xanhBrandeis);
        thanhNhapHoTen.setBackground(trang);
        thanhNhapHoTen.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhNhapHoTen.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        phanThongTin.add(thanhNhapHoTen);

        JLabel tieuDeSoDienThoai = new JLabel("Điện thoại:");
        tieuDeSoDienThoai.setForeground(xanhBrandeis);
        tieuDeSoDienThoai.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeSoDienThoai.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        phanThongTin.add(tieuDeSoDienThoai);

        thanhNhapDienThoai = new JTextField();
        thanhNhapDienThoai.setForeground(xanhBrandeis);
        thanhNhapDienThoai.setBackground(trang);
        thanhNhapDienThoai.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhNhapDienThoai.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut + 1));
        phanThongTin.add(thanhNhapDienThoai);

        // Tạo tiêu đề giới tính
        JLabel tieuDeGioiTinh = new JLabel("Giới Tính:");
        tieuDeGioiTinh.setForeground(xanhBrandeis);
        tieuDeGioiTinh.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeGioiTinh.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        phanThongTin.add(tieuDeGioiTinh);

        // Tạo nút lựa chọn giới tính nam
        nutLuaChonNam = new JRadioButton("Nam");
        nutLuaChonNam.setPreferredSize(new Dimension(chieuDaiNut / 2 - 10, chieuRongNut));
        nutLuaChonNam.setForeground(xanhBrandeis);
        nutLuaChonNam.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        nutLuaChonNam.setBackground(trang);
        nutLuaChonNam.setFocusPainted(false);
        nutLuaChonNam.setContentAreaFilled(false);
        nutLuaChonNam.setOpaque(false);
        nutLuaChonNam.setHorizontalTextPosition(SwingConstants.LEFT);
        nutLuaChonNam.addActionListener(hanhDong);
        phanThongTin.add(nutLuaChonNam);

        // Tạo nút lựa chọn giới tính nữ
        nutLuaChonNu = new JRadioButton("Nữ");
        nutLuaChonNu.setOpaque(false);
        nutLuaChonNu.setPreferredSize(new Dimension(chieuDaiNut / 2 - 10, chieuRongNut));
        nutLuaChonNu.setForeground(xanhBrandeis);
        nutLuaChonNu.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        nutLuaChonNu.setBackground(trang);
        nutLuaChonNu.setFocusPainted(false);
        nutLuaChonNu.setContentAreaFilled(false);
        nutLuaChonNu.setHorizontalTextPosition(SwingConstants.LEFT);
        nutLuaChonNu.addActionListener(hanhDong);
        phanThongTin.add(nutLuaChonNu);

        JLabel tieuDeThuDienTu = new JLabel("Thư Điện Tử:");
        tieuDeThuDienTu.setForeground(xanhBrandeis);
        tieuDeThuDienTu.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeThuDienTu.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        phanThongTin.add(tieuDeThuDienTu);

        thanhNhapThuDienTu = new JTextField();
        thanhNhapThuDienTu.setForeground(xanhBrandeis);
        thanhNhapThuDienTu.setBackground(trang);
        thanhNhapThuDienTu.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhNhapThuDienTu.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        phanThongTin.add(thanhNhapThuDienTu);

        JLabel tieuDeNgaySinh = new JLabel("Ngày Sinh:");
        tieuDeNgaySinh.setForeground(xanhBrandeis);
        tieuDeNgaySinh.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeNgaySinh.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        phanThongTin.add(tieuDeNgaySinh);

        thanhNhapNgaySinh = new JDateChooser();
        thanhNhapNgaySinh.setForeground(xanhBrandeis);
        thanhNhapNgaySinh.setBackground(trang);
        thanhNhapNgaySinh.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhNhapNgaySinh.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut + 1));
        thanhNhapNgaySinh.setFocusable(false);
        phanThongTin.add(thanhNhapNgaySinh);

        JLabel tieuDeGhiChu = new JLabel("Ghi Chú:");
        tieuDeGhiChu.setForeground(xanhBrandeis);
        tieuDeGhiChu.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut * 3));
        tieuDeGhiChu.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        tieuDeGhiChu.setVerticalAlignment(SwingConstants.TOP);
        phanThongTin.add(tieuDeGhiChu);

        thanhNhapGhiChu = new JTextArea(8, 20);
        thanhNhapGhiChu.setForeground(xanhBrandeis);
        thanhNhapGhiChu.setBackground(trang);
        thanhNhapGhiChu.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhNhapGhiChu.setLineWrap(true); // Cho chữ chỉ trong 1 vùng
        thanhNhapGhiChu.setWrapStyleWord(true); // Cho chữ chỉ trong giới hạn cái JTextArea
        thanhNhapGhiChu.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut * 3));
        phanThongTin.add(thanhNhapGhiChu);

        JPanel phanThanhToan = new JPanel();
        phanThanhToan.setBackground(trang);
        phanThanhToan.setPreferredSize(new Dimension(500, 100));
        phanThanhToan.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        donThongTinKH.add(phanThanhToan);

        JLabel tieuDeThanhToan = new JLabel("Tổng Tiền:");
        tieuDeThanhToan.setForeground(xanhBrandeis);
        tieuDeThanhToan.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeThanhToan.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        phanThanhToan.add(tieuDeThanhToan);

        thanhNhapTongTien = new JTextField();
        thanhNhapTongTien.setForeground(xanhBrandeis);
        thanhNhapTongTien.setBackground(trang);
        thanhNhapTongTien.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhNhapTongTien.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut + 1));
        phanThanhToan.add(thanhNhapTongTien);

        JPanel cachDong = new JPanel();
        cachDong.setBackground(trang);
        cachDong.setPreferredSize(new Dimension(500, 20));
        phanThanhToan.add(cachDong);

        nutThanhToan = new JButton("Thanh Toán");
        nutThanhToan.setPreferredSize(new Dimension(500, chieuRongNut));
        nutThanhToan.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        nutThanhToan.setForeground(trang);
        nutThanhToan.setBackground(xanhBrandeis);
        nutThanhToan.addActionListener(hanhDong);
        nutThanhToan.addMouseListener(thaoTacChuot);
        nutThanhToan.setFocusPainted(false); // Bỏ viền khi click (focus)
        // Bỏ fill màu mặc định của JButton (nếu cần)
        phanThanhToan.add(nutThanhToan);

        trangDonDatVe.add(trangChuaDonTT);
    }

    private void taoTrangChuaNutDS() {
        JPanel trangChuaNutDS = new JPanel();
        trangChuaNutDS.setPreferredSize(new Dimension(1200, 50));
        trangChuaNutDS.setBackground(trang);
        trangChuaNutDS.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        this.nutDSVe = new JButton("Danh Sách Vé");
        this.nutDSVe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 14));
        this.nutDSVe.setPreferredSize(new Dimension(150, chieuRongNut));
        this.nutDSVe.setForeground(new Color(trang.getRGB()));
        this.nutDSVe.setBackground(new Color(xanhBrandeis.getRGB()));
        this.nutDSVe.setFocusPainted(false); // Bỏ viền khi click (focus)
        this.nutDSVe.setBorderPainted(false); // Bỏ viền của nút
        this.nutDSVe.addActionListener(hanhDong);
        this.nutDSVe.addMouseListener(thaoTacChuot);
        trangChuaNutDS.add(nutDSVe);

        add(trangChuaNutDS, BorderLayout.NORTH);
    }
}
