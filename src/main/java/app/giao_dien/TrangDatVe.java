package app.giao_dien;

import app.phan_tu_tuy_chinh.BongCuaChu;
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
    public JTextField thanhNhapHoTen;
    public JTextField thanhNhapDienThoai;
    public JTextField thanhNhapThuDienTu;
    public JTextField thanhNhapNgaySinh;
    public JTextField thanhNhapGhiChu;
    public JTextField thanhNhapTongTien;
    public JButton nutThanhToan;
    public JPanel trangChua;

    /* Khoi Tao Phong Chu Mau Sac */
    public int kichThuocChu = 12;
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

        trangChua = new JPanel();
        trangChua.setPreferredSize(new Dimension(1200, 700));
        trangChua.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        trangChua.setBackground(trang);

        taoTrangChuaNutDS();
        add(trangChua, BorderLayout.CENTER);
        taoDonThongTinVe();
        taoTrangThongTinKhachHang();
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
        trangChuaTieuDe.setPreferredSize(new Dimension(505, 45));
        trangChuaTieuDe.setBackground(trang);
        trangChuaTieuDe.setBorder(duongVienChu);
        trangChuaTieuDe.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        trangChuaDonDat.add(trangChuaTieuDe);

        // Tạo đơn đặt vé
        JPanel donDatVe = new JPanel();
        donDatVe.setPreferredSize(new Dimension(505, 605));
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
        thanhCacDiemDi.setBorder(vienDam);
        thanhCacDiemDi.setFocusable(false);
        thanhCacDiemDi.addItem("Tất cả");
        thanhCacDiemDi.addItem("Cà phê");
        thanhCacDiemDi.addItem("Soda");
        thanhCacDiemDi.addItem("Kem");
        thanhCacDiemDi.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
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
        nutLuaChonMotChieu.setBorder(vienDam);
        nutLuaChonMotChieu.setHorizontalTextPosition(SwingConstants.LEFT);
        donDatVe.add(nutLuaChonMotChieu);

        // Tạo nút lựa chọn khứ hồi
        nutLuaChonKhuHoi = new JRadioButton("Khứ Hồi");
        nutLuaChonKhuHoi.setOpaque(false);
        nutLuaChonKhuHoi.setPreferredSize(new Dimension(chieuDaiNut / 2 - 10, chieuRongNut));
        nutLuaChonKhuHoi.setForeground(xanhBrandeis);
        nutLuaChonKhuHoi.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        nutLuaChonKhuHoi.setBackground(trang);
        nutLuaChonKhuHoi.setFocusPainted(false);
        nutLuaChonKhuHoi.setBorder(vienDam);
        nutLuaChonKhuHoi.setContentAreaFilled(false);
        nutLuaChonKhuHoi.setHorizontalTextPosition(SwingConstants.LEFT);
        donDatVe.add(nutLuaChonKhuHoi);

        JLabel tieuDeNgayDi = new JLabel("Ngày đi:");
        tieuDeNgayDi.setForeground(xanhBrandeis);
        tieuDeNgayDi.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeNgayDi.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        donDatVe.add(tieuDeNgayDi);

        thanhNhapNgayDi = new JTextField();
        thanhNhapNgayDi.setForeground(xanhBrandeis);
        thanhNhapNgayDi.setBackground(trang);
        thanhNhapNgayDi.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhNhapNgayDi.setBorder(gachChanDam);
        thanhNhapNgayDi.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut + 1));
        donDatVe.add(thanhNhapNgayDi);

        JLabel tieuDeNgayDen = new JLabel("Ngày Trở Về:");
        tieuDeNgayDen.setForeground(xanhBrandeis);
        tieuDeNgayDen.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeNgayDen.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        donDatVe.add(tieuDeNgayDen);

        thanhNhapNgayDen = new JTextField();
        thanhNhapNgayDen.setForeground(xanhBrandeis);
        thanhNhapNgayDen.setBackground(trang);
        thanhNhapNgayDen.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhNhapNgayDen.setBorder(gachChanDam);
        thanhNhapNgayDen.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        donDatVe.add(thanhNhapNgayDen);

        JLabel tieuDeGioDen = new JLabel("Giờ Đến:");
        tieuDeGioDen.setForeground(xanhBrandeis);
        tieuDeGioDen.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeGioDen.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        donDatVe.add(tieuDeGioDen);

        thanhNhapGioDen = new JTextField();
        thanhNhapGioDen.setForeground(xanhBrandeis);
        thanhNhapGioDen.setBackground(trang);
        thanhNhapGioDen.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhNhapGioDen.setBorder(gachChanDam);
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
        tieuDeSoLuong.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        tieuDeSoLuong.setBackground(Color.cyan);
        donDatVe.add(tieuDeSoLuong);

        thanhSoLuongTreEm = new JTextField();
        thanhSoLuongTreEm.setForeground(xanhBrandeis);
        thanhSoLuongTreEm.setBackground(trang);
        thanhSoLuongTreEm.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhSoLuongTreEm.setBorder(vienDam);
        thanhSoLuongTreEm.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        donDatVe.add(thanhSoLuongTreEm);

        JLabel tieuDeSoLuongRong = new JLabel();
        tieuDeSoLuongRong.setForeground(xanhBrandeis);
        tieuDeSoLuongRong.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeSoLuongRong.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        tieuDeSoLuongRong.setBackground(Color.cyan);
        donDatVe.add(tieuDeSoLuongRong);

        thanhSoLuongNguoiLon = new JTextField();
        thanhSoLuongNguoiLon.setForeground(xanhBrandeis);
        thanhSoLuongNguoiLon.setBackground(trang);
        thanhSoLuongNguoiLon.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhSoLuongNguoiLon.setBorder(vienDam);
        thanhSoLuongNguoiLon.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut + 1));
        donDatVe.add(thanhSoLuongNguoiLon);

        JLabel tieuDeViTriGhe = new JLabel("Vị trí ghế:");
        tieuDeViTriGhe.setForeground(xanhBrandeis);
        tieuDeViTriGhe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeViTriGhe.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        donDatVe.add(tieuDeViTriGhe);

        thanhNhapViTriGhe = new JTextField();
        thanhNhapViTriGhe.setForeground(xanhBrandeis);
        thanhNhapViTriGhe.setBackground(trang);
        thanhNhapViTriGhe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhNhapViTriGhe.setBorder(gachChanDam);
        thanhNhapViTriGhe.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        donDatVe.add(thanhNhapViTriGhe);

        trangChua.add(trangChuaDonDat);
    }

    private void taoTrangThongTinKhachHang() {
        JPanel trangChuaDonTT = new JPanel();
        trangChuaDonTT.setPreferredSize(new Dimension(580, 710));
        trangChuaDonTT.setBackground(trang);
        trangChuaDonTT.setLayout(new BorderLayout());

        JPanel cachDongBac = new JPanel();
        cachDongBac.setPreferredSize(new Dimension(580, 50));
        cachDongBac.setBackground(trang);
        trangChuaDonTT.add(cachDongBac, BorderLayout.NORTH);

        JPanel donThongTinKH = new JPanel();
        //donThongTinKH.setBackground(new Color(100, 255, 255));
        donThongTinKH.setBackground(trang);
        donThongTinKH.setPreferredSize(new Dimension(501, 580));
        donThongTinKH.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        trangChuaDonTT.add(donThongTinKH, BorderLayout.WEST);

        JPanel phanThongTin = new JPanel();
        phanThongTin.setPreferredSize(new Dimension(501, 500));
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
        thanhNhapHoTen.setBorder(gachChanDam);
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
        thanhNhapDienThoai.setBorder(gachChanDam);
        thanhNhapDienThoai.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        phanThongTin.add(thanhNhapDienThoai);

        JLabel tieuDeGioiTinh = new JLabel("Giới Tính:");
        tieuDeGioiTinh.setForeground(xanhBrandeis);
        tieuDeGioiTinh.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeGioiTinh.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        phanThongTin.add(tieuDeGioiTinh);

        // Tạo nút lựa chọn 1 chiều
        nutLuaChonMotChieu = new JRadioButton("Một Chiều");
        nutLuaChonMotChieu.setPreferredSize(new Dimension(chieuDaiNut / 2 - 10, chieuRongNut));
        nutLuaChonMotChieu.setForeground(xanhBrandeis);
        nutLuaChonMotChieu.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        nutLuaChonMotChieu.setBackground(trang);
        nutLuaChonMotChieu.setFocusPainted(false);
        nutLuaChonMotChieu.setContentAreaFilled(false);
        nutLuaChonMotChieu.setOpaque(false);
        nutLuaChonMotChieu.setBorder(vienDam);
        nutLuaChonMotChieu.setHorizontalTextPosition(SwingConstants.LEFT);
        phanThongTin.add(nutLuaChonMotChieu);

        // Tạo nút lựa chọn khứ hồi
        nutLuaChonKhuHoi = new JRadioButton("Khứ Hồi");
        nutLuaChonKhuHoi.setOpaque(false);
        nutLuaChonKhuHoi.setPreferredSize(new Dimension(chieuDaiNut / 2 - 10, chieuRongNut));
        nutLuaChonKhuHoi.setForeground(xanhBrandeis);
        nutLuaChonKhuHoi.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        nutLuaChonKhuHoi.setBackground(trang);
        nutLuaChonKhuHoi.setFocusPainted(false);
        nutLuaChonKhuHoi.setBorder(vienDam);
        nutLuaChonKhuHoi.setContentAreaFilled(false);
        nutLuaChonKhuHoi.setHorizontalTextPosition(SwingConstants.LEFT);
        phanThongTin.add(nutLuaChonKhuHoi);

        JLabel tieuDeThuDienTu = new JLabel("Thư Điện Tử:");
        tieuDeThuDienTu.setForeground(xanhBrandeis);
        tieuDeThuDienTu.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeThuDienTu.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        phanThongTin.add(tieuDeThuDienTu);

        thanhNhapThuDienTu = new JTextField();
        thanhNhapThuDienTu.setForeground(xanhBrandeis);
        thanhNhapThuDienTu.setBackground(trang);
        thanhNhapThuDienTu.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhNhapThuDienTu.setBorder(gachChanDam);
        thanhNhapThuDienTu.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        phanThongTin.add(thanhNhapThuDienTu);

        JLabel tieuDeNgaySinh = new JLabel("Ngày Sinh:");
        tieuDeNgaySinh.setForeground(xanhBrandeis);
        tieuDeNgaySinh.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeNgaySinh.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        phanThongTin.add(tieuDeNgaySinh);

        thanhNhapNgaySinh = new JTextField();
        thanhNhapNgaySinh.setForeground(xanhBrandeis);
        thanhNhapNgaySinh.setBackground(trang);
        thanhNhapNgaySinh.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhNhapNgaySinh.setBorder(gachChanDam);
        thanhNhapNgaySinh.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        phanThongTin.add(thanhNhapNgaySinh);

        JLabel tieuDeGhiChu = new JLabel("Ghi Chú:");
        tieuDeGhiChu.setForeground(xanhBrandeis);
        tieuDeGhiChu.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        tieuDeGhiChu.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, kichThuocChu));
        phanThongTin.add(tieuDeGhiChu);

        thanhNhapGhiChu = new JTextField();
        thanhNhapGhiChu.setForeground(xanhBrandeis);
        thanhNhapGhiChu.setBackground(trang);
        thanhNhapGhiChu.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        thanhNhapGhiChu.setBorder(gachChanDam);
        thanhNhapGhiChu.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        phanThongTin.add(thanhNhapGhiChu);

        JPanel phanThanhToan = new JPanel();
        phanThanhToan.setBackground(trang);
        phanThanhToan.setPreferredSize(new Dimension(500, 50));
        phanThanhToan.setLayout(new FlowLayout(FlowLayout.CENTER));
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
        thanhNhapTongTien.setBorder(gachChanDam);
        thanhNhapTongTien.setPreferredSize(new Dimension(chieuDaiNut, chieuRongNut));
        phanThanhToan.add(thanhNhapTongTien);

        nutThanhToan = new JButton("Thanh Toán");
        nutThanhToan.setPreferredSize(new Dimension(580, chieuRongNut));
        nutThanhToan.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu + 2));
        nutThanhToan.setForeground(trang);
        nutThanhToan.setBackground(xanhBrandeis);
        nutThanhToan.setBorder(this.vienDam);
        nutThanhToan.setFocusPainted(false); // Bỏ viền khi click (focus)
        // Bỏ fill màu mặc định của JButton (nếu cần)
        donThongTinKH.add(nutThanhToan);

        trangChua.add(trangChuaDonTT);
    }

    private void taoTrangChuaNutDS() {
        JPanel trangChuaNutDS = new JPanel();
        trangChuaNutDS.setPreferredSize(new Dimension(this.getWidth(), 40));
        trangChuaNutDS.setBackground(trang);
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
