package app.giao_dien;



import app.phan_tu_tuy_chinh.CustomCellRenderer;
import app.phan_tu_tuy_chinh.CustomHeaderRenderer;
import app.phong_chu_moi.PhongChuMoi;

import   javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class TrangDanhSachVeTau extends JFrame{

    private  JButton capNhat;
    private  JPanel trangChua_ChiTietCacCongCu;
    private  JScrollPane scrollpane;
    private  JButton lamMoi;
    private  JLabel soTienVeNguoiLon;
    private  JLabel soTienVeTreEm;
    private  JTable table;
    private  JTextField thanhEmail;
    private  JTextField thanhNgayDi;
    private  JTextField thanhNgayVe;
    private  JTextField thanhSoDienThoai;
    private  JTextField thanhSoHieu;
    private  JTextField thanhSoLuong;
    private  JTextField thanhTenKhachHang;
    private  JTextField thanhTimKiem;
    private  JLabel tieuDe;
    private  JLabel tieuDeTongTien;
    private  JLabel tieuDeVeNguoiLon;
    private  JLabel tieuDeVeTreEm;
    private  JLabel tieuDe_DonGia;
    private  JLabel tieuDe_Email;
    private  JLabel tieuDe_NgayDi;
    private  JLabel tieuDe_NgayVe;
    private  JLabel tieuDe_SoDienThoai;
    private  JLabel tieuDe_SoHieu;
    private  JLabel tieuDe_SoLuong;
    private  JLabel tieuDe_TenKhachHang;
    private  JLabel tieuDe_ThongTinChiTiet;
    private  JLabel timKiemVe;
    private  JLabel tongTien;
    private  JPanel tragChua_TieuDeThongTinChiTiet;
    private  JPanel trangChua_CongCu;
    private  JPanel trangChua_DanhSachVe;
    private  JPanel trangChua_DonGia;
    private  JPanel trangChua_Email;
    private  JPanel trangChua_SoDienThoai;
    private  JPanel trangChua_SoHieu;
    private  JPanel trangChua_TableDanhSach;
    private  JPanel trangChua_TenKhachHang;
    private  JPanel trangChua_ThanhTimKiem;
    private  JPanel trangChua_ThongTinChiTiet;
    private  JPanel trangChua_ThongTinKhachang;
    private  JPanel trangChua_ThongTinNgayDi;
    private  JPanel trangChua_ThongTinNgayVe;
    private  JPanel trangChua_ThongTinSoLuong;
    private  JPanel trangChua_ThongTinSoTien;
    private  JPanel trangChua_ThongTinVe;
    private  JPanel trangChua_TieuDe;
    private  JPanel trangChua_TongTien;
    private  JPanel trangChua_VeNguoiLon;
    private  JPanel trangChua_VeTreEm;
    private  JButton xoa;
    public DefaultTableModel model ;
    public Color xanhBrandeis = new Color(0, 112, 255);
    public  Color trang = new Color(255, 255, 255);
    public Border gachChanDam = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis);
    private JButton timKiem;

    private TrangDanhSachVeTau(){

        // setting basic config for interface
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1200, 800));
        this.setResizable(false);
        this.setSize(new Dimension(1200, 800));
        this.setLocationRelativeTo(null);

        this.trangChua_ThongTinChiTiet = new JPanel();
        trangChua_ThongTinChiTiet.setPreferredSize(new Dimension(1150, 300));

        // config trang chứa tiêu đề
        thietLap_TrangChuaTieuDe();

        // config trang chứa thanh tìm kiếm
        thietLap_TrangChuaThanhTimKiem();

        // config trang  chứa thông tin chi tiết
        thietLap_TrangChuaTieuDEThongTinChiTiet();

        // config trang chứa thông tin khách hàng
        thietLap_TrangChuaThongTinKhachHang();

        // config trang chứa thông tin vé
        thietLap_TrangChuaThongTinVe();

        // config trang chứa thông tin số tiền
        thietLap_TrangChuaThongTinSoTien();

        // config trang chứa thông tin chi tiết
        thietLap_TrangChuaThongTinChiTiet();

        // config trang chứa bảng danh sách
        thietLap_BangChuaDanhSachVeTau();

        // config trang chứa công cụ hỗ trợ
        thietLap_TrangChuaCongCuHoTro();

        // config trang chứa danh sách vé
        thietLap_TrangChuaDanhSachVe();

        // config trang thiết lập giao diện
        thietLap_TrangGiaoDien();

        // thiết kế background
        this.setBackground(new Color(255, 255, 255));
        trangChua_DonGia.setBackground(new Color(255, 255, 255));
//        tragChua_TieuDeThongTinChiTiet.setBackground(new Color(255, 255, 255));
//        trangChua_ChiTietCacCongCu.setBackground(new Color(255, 255, 255));
//        trangChua_Email.setBackground(new Color(255, 255, 255));
//        trangChua_CongCu.setBackground(new Color(255, 255, 255));
//        trangChua_DanhSachVe.setBackground(new Color(255, 255, 255));;
//        trangChua_SoDienThoai.setBackground(new Color(255, 255, 255));

        this.setVisible(true);
    }

    private void thietLap_TrangChuaTieuDe(){
        this.tieuDe = new JLabel();
        this.trangChua_TieuDe = new JPanel();
        this.tieuDe.setText("Danh Sách Vé Tàu");
        this.tieuDe.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 20));
        this.tieuDe.setHorizontalAlignment(SwingConstants.CENTER);
        GroupLayout trangChua_TieuDeLayout = new  GroupLayout(trangChua_TieuDe);
        trangChua_TieuDe.setLayout(trangChua_TieuDeLayout);
        trangChua_TieuDeLayout.setHorizontalGroup(
                trangChua_TieuDeLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_TieuDeLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(tieuDe,  GroupLayout.PREFERRED_SIZE, 493,  GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(68, Short.MAX_VALUE))
        );
        trangChua_TieuDeLayout.setVerticalGroup(
                trangChua_TieuDeLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_TieuDeLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(tieuDe,  GroupLayout.PREFERRED_SIZE, 42,  GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
        );
    }

    private void thietLap_TrangChuaThanhTimKiem(){
        this.timKiemVe = new JLabel();
        this.thanhTimKiem = new JTextField();
        this.timKiem = new JButton();
        this.trangChua_ThanhTimKiem = new JPanel();

        timKiemVe.setText("Tìm Kiếm vé ");
        timKiemVe.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        thanhTimKiem.setText("");
        thanhTimKiem.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        thanhTimKiem.setBorder(gachChanDam);
        
        timKiem.setText("Tìm kiếm");
        timKiemVe.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        timKiem.setForeground(trang);
        timKiem.setBackground(xanhBrandeis);

        GroupLayout trangChua_ThanhTimKiemLayout = new GroupLayout(trangChua_ThanhTimKiem);
        trangChua_ThanhTimKiem.setLayout(trangChua_ThanhTimKiemLayout);
        trangChua_ThanhTimKiemLayout.setHorizontalGroup(
                trangChua_ThanhTimKiemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThanhTimKiemLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(timKiemVe, javax.swing.GroupLayout.PREFERRED_SIZE, 127,  GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(thanhTimKiem,  GroupLayout.PREFERRED_SIZE, 235,  GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(timKiem,  GroupLayout.PREFERRED_SIZE, 83,  GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(49, Short.MAX_VALUE))
        );
        trangChua_ThanhTimKiemLayout.setVerticalGroup(
                trangChua_ThanhTimKiemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThanhTimKiemLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(trangChua_ThanhTimKiemLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                                        .addComponent(timKiemVe,  GroupLayout.PREFERRED_SIZE, 38,  GroupLayout.PREFERRED_SIZE)
                                        .addComponent(thanhTimKiem)
                                        .addComponent(timKiem))
                                .addContainerGap( GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void thietLap_TrangChuaTieuDEThongTinChiTiet(){
        this.tieuDe_ThongTinChiTiet = new JLabel();
        this.tragChua_TieuDeThongTinChiTiet = new JPanel();

        tieuDe_ThongTinChiTiet.setText("Thông Tin Chi Tiết:");
        tieuDe_ThongTinChiTiet.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 15));
        tieuDe_ThongTinChiTiet.setBorder(this.gachChanDam);

        GroupLayout tragChua_TieuDeThongTinChiTietLayout = new   GroupLayout(tragChua_TieuDeThongTinChiTiet);
        tragChua_TieuDeThongTinChiTiet.setLayout(tragChua_TieuDeThongTinChiTietLayout);
        tragChua_TieuDeThongTinChiTietLayout.setHorizontalGroup(
                tragChua_TieuDeThongTinChiTietLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(tragChua_TieuDeThongTinChiTietLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tieuDe_ThongTinChiTiet,   GroupLayout.PREFERRED_SIZE, 169,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        tragChua_TieuDeThongTinChiTietLayout.setVerticalGroup(
                tragChua_TieuDeThongTinChiTietLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(tragChua_TieuDeThongTinChiTietLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tieuDe_ThongTinChiTiet,   GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

    private void thietLap_TrangChuaThongTinKhachHang(){
        this.trangChua_ThongTinKhachang = new JPanel();
        this.trangChua_TenKhachHang = new JPanel();
        this.tieuDe_TenKhachHang = new JLabel();
        this.thanhTenKhachHang = new JTextField();

        /*
            thiết lập giao diện thanh tên khách hàng
         */
        trangChua_ThongTinKhachang.setPreferredSize(new java.awt.Dimension(380, 249));

        trangChua_TenKhachHang.setPreferredSize(new java.awt.Dimension(370, 75));
        trangChua_TenKhachHang.setRequestFocusEnabled(false);

        tieuDe_TenKhachHang.setText("Họ và tên:");
        tieuDe_TenKhachHang.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        thanhTenKhachHang.setText("");
        thanhTenKhachHang.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        thanhTenKhachHang.setBorder(gachChanDam);

        GroupLayout trangChua_TenKhachHangLayout = new   GroupLayout(trangChua_TenKhachHang);
        trangChua_TenKhachHang.setLayout(trangChua_TenKhachHangLayout);
        trangChua_TenKhachHangLayout.setHorizontalGroup(
                trangChua_TenKhachHangLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_TenKhachHangLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tieuDe_TenKhachHang,   GroupLayout.PREFERRED_SIZE, 114,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(thanhTenKhachHang,   GroupLayout.PREFERRED_SIZE, 228,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(10, Short.MAX_VALUE))
        );
        trangChua_TenKhachHangLayout.setVerticalGroup(
                trangChua_TenKhachHangLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_TenKhachHangLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(trangChua_TenKhachHangLayout.createParallelGroup(  GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDe_TenKhachHang,   GroupLayout.PREFERRED_SIZE, 31,   GroupLayout.PREFERRED_SIZE)
                                        .addComponent(thanhTenKhachHang,   GroupLayout.PREFERRED_SIZE, 31,   GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        /*
            thiết lập giao diện cho thanh số diện thoại
         */
        this.trangChua_SoDienThoai = new JPanel();
        this.tieuDe_SoDienThoai = new JLabel();
        this.thanhSoDienThoai = new JTextField();
        trangChua_SoDienThoai.setPreferredSize(new java.awt.Dimension(370, 75));
        trangChua_SoDienThoai.setRequestFocusEnabled(false);

        tieuDe_SoDienThoai.setText("Số điện thoại:");
        tieuDe_SoDienThoai.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        thanhSoDienThoai.setText("");
        thanhSoDienThoai.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        thanhSoDienThoai.setBorder(gachChanDam);

        GroupLayout trangChua_SoDienThoaiLayout = new   GroupLayout(trangChua_SoDienThoai);
        trangChua_SoDienThoai.setLayout(trangChua_SoDienThoaiLayout);
        trangChua_SoDienThoaiLayout.setHorizontalGroup(
                trangChua_SoDienThoaiLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_SoDienThoaiLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tieuDe_SoDienThoai,   GroupLayout.PREFERRED_SIZE, 114,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(thanhSoDienThoai,   GroupLayout.PREFERRED_SIZE, 228,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(10, Short.MAX_VALUE))
        );
        trangChua_SoDienThoaiLayout.setVerticalGroup(
                trangChua_SoDienThoaiLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(  GroupLayout.Alignment.TRAILING, trangChua_SoDienThoaiLayout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addGroup(trangChua_SoDienThoaiLayout.createParallelGroup(  GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDe_SoDienThoai,   GroupLayout.PREFERRED_SIZE, 31,   GroupLayout.PREFERRED_SIZE)
                                        .addComponent(thanhSoDienThoai,   GroupLayout.PREFERRED_SIZE, 31,   GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21))
        );


        /*
            thiết lập giao diện cho thanh email
         */
        this.trangChua_Email = new JPanel();
        this.tieuDe_Email = new JLabel();
        this.thanhEmail = new JTextField();
        trangChua_Email.setPreferredSize(new java.awt.Dimension(370, 75));

        tieuDe_Email.setText("Email:");
        tieuDe_Email.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        thanhEmail.setText(" ");
        thanhEmail.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        thanhEmail.setBorder(gachChanDam);

        GroupLayout trangChua_EmailLayout = new   GroupLayout(trangChua_Email);
        trangChua_Email.setLayout(trangChua_EmailLayout);
        trangChua_EmailLayout.setHorizontalGroup(
                trangChua_EmailLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_EmailLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tieuDe_Email,   GroupLayout.PREFERRED_SIZE, 114,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(thanhEmail,   GroupLayout.PREFERRED_SIZE, 228,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(10, Short.MAX_VALUE))
        );
        trangChua_EmailLayout.setVerticalGroup(
                trangChua_EmailLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_EmailLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(trangChua_EmailLayout.createParallelGroup(  GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDe_Email,   GroupLayout.PREFERRED_SIZE, 31,   GroupLayout.PREFERRED_SIZE)
                                        .addComponent(thanhEmail,   GroupLayout.PREFERRED_SIZE, 31,   GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(27, Short.MAX_VALUE))
        );

        // thiết cho trang chứa thoong tin khacách hàng
        this.trangChua_ThongTinKhachang = new JPanel();
        GroupLayout trangChua_ThongTinKhachangLayout = new   GroupLayout(trangChua_ThongTinKhachang);
        trangChua_ThongTinKhachang.setLayout(trangChua_ThongTinKhachangLayout);
        trangChua_ThongTinKhachangLayout.setHorizontalGroup(
                trangChua_ThongTinKhachangLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinKhachangLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_ThongTinKhachangLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChua_TenKhachHang,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                        .addComponent(trangChua_SoDienThoai,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                        .addComponent(trangChua_Email,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChua_ThongTinKhachangLayout.setVerticalGroup(
                trangChua_ThongTinKhachangLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinKhachangLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(trangChua_TenKhachHang,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(trangChua_SoDienThoai,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_Email,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(31, Short.MAX_VALUE))
        );
    }

    private void thietLap_TrangChuaThongTinVe(){
        /*
            thiết lập giao diện cho thanh số hiệu
         */
        this.trangChua_ThongTinVe = new JPanel();
        this.trangChua_SoHieu = new JPanel();
        this.tieuDe_SoHieu = new JLabel();
        this.thanhSoHieu = new JTextField();
        trangChua_ThongTinVe.setPreferredSize(new java.awt.Dimension(380, 249));

        trangChua_SoHieu.setPreferredSize(new java.awt.Dimension(370, 50));
        trangChua_SoHieu.setRequestFocusEnabled(false);

        tieuDe_SoHieu.setText("Số hiệu:");
        tieuDe_SoHieu.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        thanhSoHieu.setText(" ");
        thanhSoHieu.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        thanhSoHieu.setBorder(gachChanDam);

        GroupLayout trangChua_SoHieuLayout = new   GroupLayout(trangChua_SoHieu);
        trangChua_SoHieu.setLayout(trangChua_SoHieuLayout);
        trangChua_SoHieuLayout.setHorizontalGroup(
                trangChua_SoHieuLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_SoHieuLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(tieuDe_SoHieu,   GroupLayout.PREFERRED_SIZE, 114,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(thanhSoHieu,   GroupLayout.PREFERRED_SIZE, 228,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        trangChua_SoHieuLayout.setVerticalGroup(
                trangChua_SoHieuLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_SoHieuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_SoHieuLayout.createParallelGroup(  GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDe_SoHieu,   GroupLayout.PREFERRED_SIZE, 31,   GroupLayout.PREFERRED_SIZE)
                                        .addComponent(thanhSoHieu,   GroupLayout.PREFERRED_SIZE, 31,   GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(13, Short.MAX_VALUE))
        );

        /*
            thiết lập giao diện cho trang chứa thông tin ngày đi
         */
        this.trangChua_ThongTinNgayDi = new JPanel();
        this.tieuDe_NgayDi = new JLabel();
        this.thanhNgayDi = new JTextField();

        trangChua_ThongTinNgayDi.setPreferredSize(new java.awt.Dimension(370, 50));
        trangChua_ThongTinNgayDi.setRequestFocusEnabled(false);

        tieuDe_NgayDi.setText("Ngày đi:");
        tieuDe_NgayDi.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        thanhNgayDi.setText("");
        thanhNgayDi.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        thanhNgayDi.setBorder(gachChanDam);

        GroupLayout trangChua_ThongTinNgayDiLayout = new   GroupLayout(trangChua_ThongTinNgayDi);
        trangChua_ThongTinNgayDi.setLayout(trangChua_ThongTinNgayDiLayout);
        trangChua_ThongTinNgayDiLayout.setHorizontalGroup(
                trangChua_ThongTinNgayDiLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinNgayDiLayout.createSequentialGroup()
                                .addContainerGap(11, Short.MAX_VALUE)
                                .addComponent(tieuDe_NgayDi,   GroupLayout.PREFERRED_SIZE, 114,   GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(thanhNgayDi,   GroupLayout.PREFERRED_SIZE, 228,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        trangChua_ThongTinNgayDiLayout.setVerticalGroup(
                trangChua_ThongTinNgayDiLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinNgayDiLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_ThongTinNgayDiLayout.createParallelGroup(  GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDe_NgayDi,   GroupLayout.PREFERRED_SIZE, 31,   GroupLayout.PREFERRED_SIZE)
                                        .addComponent(thanhNgayDi,   GroupLayout.PREFERRED_SIZE, 31,   GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(13, Short.MAX_VALUE))
        );

        /*
            thiết lập giao diện cho trang thông tin ngày về
         */
        this.trangChua_ThongTinNgayVe = new JPanel();
        this.tieuDe_NgayVe = new JLabel();
        this.thanhNgayVe = new JTextField();

        trangChua_ThongTinNgayVe.setPreferredSize(new java.awt.Dimension(370, 50));
        trangChua_ThongTinNgayVe.setRequestFocusEnabled(false);

        tieuDe_NgayVe.setText("Ngày về:");
        tieuDe_NgayVe.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        thanhNgayVe.setText("");
        thanhNgayVe.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        thanhNgayVe.setBorder(gachChanDam);

        GroupLayout trangChua_ThongTinNgayVeLayout = new   GroupLayout(trangChua_ThongTinNgayVe);
        trangChua_ThongTinNgayVe.setLayout(trangChua_ThongTinNgayVeLayout);
        trangChua_ThongTinNgayVeLayout.setHorizontalGroup(
                trangChua_ThongTinNgayVeLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinNgayVeLayout.createSequentialGroup()
                                .addContainerGap(  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tieuDe_NgayVe,   GroupLayout.PREFERRED_SIZE, 114,   GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(thanhNgayVe,   GroupLayout.PREFERRED_SIZE, 228,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        trangChua_ThongTinNgayVeLayout.setVerticalGroup(
                trangChua_ThongTinNgayVeLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinNgayVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_ThongTinNgayVeLayout.createParallelGroup(  GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDe_NgayVe,   GroupLayout.PREFERRED_SIZE, 31,   GroupLayout.PREFERRED_SIZE)
                                        .addComponent(thanhNgayVe,   GroupLayout.PREFERRED_SIZE, 31,   GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(13, Short.MAX_VALUE))
        );

        /*
            thiết lập giao diện cho trang chứa thông tin số lượng
         */
        this.trangChua_ThongTinSoLuong = new JPanel();
        this.tieuDe_SoLuong = new JLabel();
        this.thanhSoLuong = new JTextField();
        trangChua_ThongTinSoLuong.setPreferredSize(new java.awt.Dimension(370, 50));
        trangChua_ThongTinSoLuong.setRequestFocusEnabled(false);

        tieuDe_SoLuong.setText("Số lượng:");
        tieuDe_SoLuong.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        thanhSoLuong.setText(" ");
        thanhSoLuong.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        thanhSoLuong.setBorder(gachChanDam);

        GroupLayout trangChua_ThongTinSoLuongLayout = new   GroupLayout(trangChua_ThongTinSoLuong);
        trangChua_ThongTinSoLuong.setLayout(trangChua_ThongTinSoLuongLayout);
        trangChua_ThongTinSoLuongLayout.setHorizontalGroup(
                trangChua_ThongTinSoLuongLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinSoLuongLayout.createSequentialGroup()
                                .addContainerGap(  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tieuDe_SoLuong,   GroupLayout.PREFERRED_SIZE, 114,   GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(thanhSoLuong,   GroupLayout.PREFERRED_SIZE, 228,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        trangChua_ThongTinSoLuongLayout.setVerticalGroup(
                trangChua_ThongTinSoLuongLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinSoLuongLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_ThongTinSoLuongLayout.createParallelGroup(  GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDe_SoLuong,   GroupLayout.PREFERRED_SIZE, 31,   GroupLayout.PREFERRED_SIZE)
                                        .addComponent(thanhSoLuong,   GroupLayout.PREFERRED_SIZE, 31,   GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(13, Short.MAX_VALUE))
        );

        /*
            thiết lập giao diện
         */
        this.trangChua_ThongTinVe = new JPanel();
        GroupLayout trangChua_ThongTinVeLayout = new   GroupLayout(trangChua_ThongTinVe);
        trangChua_ThongTinVe.setLayout(trangChua_ThongTinVeLayout);
        trangChua_ThongTinVeLayout.setHorizontalGroup(
                trangChua_ThongTinVeLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_ThongTinVeLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChua_SoHieu,   GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                                        .addComponent(trangChua_ThongTinNgayDi,   GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                                        .addComponent(trangChua_ThongTinNgayVe,   GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                                        .addComponent(trangChua_ThongTinSoLuong,   GroupLayout.Alignment.TRAILING,   GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
                                .addContainerGap())
        );
        trangChua_ThongTinVeLayout.setVerticalGroup(
                trangChua_ThongTinVeLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinVeLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(trangChua_SoHieu,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_ThongTinNgayDi,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_ThongTinNgayVe,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_ThongTinSoLuong,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void thietLap_TrangChuaThongTinSoTien(){
        /*
            thiết lập giao diện cho thông tin số tiền
         */
        this.trangChua_ThongTinSoTien = new JPanel();
        this.trangChua_DonGia = new JPanel();
        this.tieuDe_DonGia = new JLabel();
        this.tieuDeVeNguoiLon = new JLabel();
        this.soTienVeNguoiLon = new JLabel();
        this.trangChua_VeNguoiLon = new JPanel();
        this.tieuDeVeTreEm = new JLabel();
        this.soTienVeTreEm = new JLabel();
        this.trangChua_VeTreEm = new JPanel();
        this.tieuDeTongTien = new JLabel();
        this.tongTien = new JLabel();
        this.trangChua_TongTien = new JPanel();

        trangChua_ThongTinSoTien.setPreferredSize(new java.awt.Dimension(380, 300));

        trangChua_DonGia.setBackground(new java.awt.Color(0, 0, 255));

        tieuDe_DonGia.setText("Đơn giá: ");
        tieuDe_DonGia.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 16));
        tieuDe_DonGia.setBorder(gachChanDam);

        tieuDeVeNguoiLon.setText("Vé người lớn:");
        tieuDeVeNguoiLon.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN,13));

        soTienVeNguoiLon.setText("540.000.00");
        soTienVeNguoiLon.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN,13));
        soTienVeNguoiLon.setBorder(gachChanDam);

        GroupLayout trangChua_VeNguoiLonLayout = new   GroupLayout(trangChua_VeNguoiLon);
        trangChua_VeNguoiLon.setLayout(trangChua_VeNguoiLonLayout);
        trangChua_VeNguoiLonLayout.setHorizontalGroup(
                trangChua_VeNguoiLonLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_VeNguoiLonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tieuDeVeNguoiLon,   GroupLayout.PREFERRED_SIZE, 130,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(soTienVeNguoiLon,   GroupLayout.PREFERRED_SIZE, 171,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(37, Short.MAX_VALUE))
        );
        trangChua_VeNguoiLonLayout.setVerticalGroup(
                trangChua_VeNguoiLonLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_VeNguoiLonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_VeNguoiLonLayout.createParallelGroup(  GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDeVeNguoiLon,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(soTienVeNguoiLon,   GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                                .addContainerGap())
        );

        tieuDeVeTreEm.setText("Vé trẻ em:");
        tieuDeVeTreEm.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        soTienVeTreEm.setText("540.000.00");
        soTienVeTreEm.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        soTienVeTreEm.setBorder(gachChanDam);

        GroupLayout trangChua_VeTreEmLayout = new   GroupLayout(trangChua_VeTreEm);
        trangChua_VeTreEm.setLayout(trangChua_VeTreEmLayout);
        trangChua_VeTreEmLayout.setHorizontalGroup(
                trangChua_VeTreEmLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_VeTreEmLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tieuDeVeTreEm,   GroupLayout.PREFERRED_SIZE, 130,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(soTienVeTreEm,   GroupLayout.PREFERRED_SIZE, 171,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChua_VeTreEmLayout.setVerticalGroup(
                trangChua_VeTreEmLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_VeTreEmLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(trangChua_VeTreEmLayout.createParallelGroup(  GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDeVeTreEm,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(soTienVeTreEm,   GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                                .addGap(7, 7, 7))
        );

        GroupLayout trangChua_DonGiaLayout = new   GroupLayout(trangChua_DonGia);
        trangChua_DonGia.setLayout(trangChua_DonGiaLayout);
        trangChua_DonGiaLayout.setHorizontalGroup(
                trangChua_DonGiaLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_DonGiaLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(tieuDe_DonGia,   GroupLayout.PREFERRED_SIZE, 117,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(trangChua_DonGiaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_DonGiaLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChua_VeNguoiLon,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChua_VeTreEm,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        trangChua_DonGiaLayout.setVerticalGroup(
                trangChua_DonGiaLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_DonGiaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tieuDe_DonGia,   GroupLayout.PREFERRED_SIZE, 26,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChua_VeNguoiLon,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_VeTreEm,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        //trangChua_TongTien.setBackground(new java.awt.Color(0, 153, 153));

        tieuDeTongTien.setText("Tổng Tiền:");
        tieuDeTongTien.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        tongTien.setText("20000");
        tongTien.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 13));
        tongTien.setBorder(gachChanDam);

        GroupLayout trangChua_TongTienLayout = new   GroupLayout(trangChua_TongTien);
        trangChua_TongTien.setLayout(trangChua_TongTienLayout);
        trangChua_TongTienLayout.setHorizontalGroup(
                trangChua_TongTienLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_TongTienLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(trangChua_TongTienLayout.createParallelGroup(  GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tongTien,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tieuDeTongTien,   GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                                .addContainerGap(  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChua_TongTienLayout.setVerticalGroup(
                trangChua_TongTienLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_TongTienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tieuDeTongTien,   GroupLayout.PREFERRED_SIZE, 39,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tongTien,   GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                .addContainerGap())
        );

        GroupLayout trangChua_ThongTinSoTienLayout = new   GroupLayout(trangChua_ThongTinSoTien);
        trangChua_ThongTinSoTien.setLayout(trangChua_ThongTinSoTienLayout);
        trangChua_ThongTinSoTienLayout.setHorizontalGroup(
                trangChua_ThongTinSoTienLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(  GroupLayout.Alignment.TRAILING, trangChua_ThongTinSoTienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_ThongTinSoTienLayout.createParallelGroup(  GroupLayout.Alignment.TRAILING)
                                        .addComponent(trangChua_TongTien,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChua_DonGia,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        trangChua_ThongTinSoTienLayout.setVerticalGroup(
                trangChua_ThongTinSoTienLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinSoTienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(trangChua_DonGia,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(trangChua_TongTien,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE))
        );
    }

    // this page contain all informational customer.
    private void thietLap_TrangChuaThongTinChiTiet(){

        // thiết lập giao diện cho trang chứa thông tin chi tiết
        this.trangChua_ThongTinChiTiet = new JPanel();

        GroupLayout trangChua_ThongTinChiTietLayout = new   GroupLayout(trangChua_ThongTinChiTiet);
        trangChua_ThongTinChiTiet.setLayout(trangChua_ThongTinChiTietLayout);
        trangChua_ThongTinChiTietLayout.setHorizontalGroup(
                trangChua_ThongTinChiTietLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinChiTietLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tragChua_TieuDeThongTinChiTiet,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(trangChua_ThongTinChiTietLayout.createSequentialGroup()
                                .addComponent(trangChua_ThongTinKhachang,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_ThongTinVe,   GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_ThongTinSoTien,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        trangChua_ThongTinChiTietLayout.setVerticalGroup(
                trangChua_ThongTinChiTietLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinChiTietLayout.createSequentialGroup()
                                .addComponent(tragChua_TieuDeThongTinChiTiet,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(trangChua_ThongTinChiTietLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChua_ThongTinSoTien,   GroupLayout.PREFERRED_SIZE, 264,   GroupLayout.PREFERRED_SIZE)
                                        .addGroup(trangChua_ThongTinChiTietLayout.createParallelGroup(  GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(trangChua_ThongTinVe,   GroupLayout.Alignment.LEADING,   GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                                .addComponent(trangChua_ThongTinKhachang,   GroupLayout.Alignment.LEADING,   GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
    }

    private void thietLap_BangChuaDanhSachVeTau(){
         this.model =new DefaultTableModel(
                new Object [][] {
//                        {"1", "03294233", "TP.HCM", "VN123", "22:00pm","Giường 6 ghế", "A2", "A2.1", "12"},
//                        {"2", "03293234", "TP.HCM", "VN123", "22:00pm","Giường 6 ghế", "A4", "A4.2", "22"},
//                        {"3", "03294235", "TP.HCM", "VN123", "22:00pm","Giường 6 ghế", "B5", "B5.3", "34"},
//                        {"4", "03294236", "TP.HCM", "VN123", "22:00pm","Giường 6 ghế", "C6", "C6.4", "56"},
//                        {"5", "03294237", "TP.HCM", "VN123", "22:00pm","Giường 6 ghế", "D2", "D2.1", "31"},
//                        {"6", "03294238", "TP.HCM", "VN123", "22:00pm","Giường 6 ghế", "A2", "A2.2", "34"},
//                        {"7", "03294239", "TP.HCM", "VN123", "22:00pm","Giường 6 ghế", "B2", "B2.2", "23"},
                },
                new String [] {
                        "STT", "Mã Vé", "Điểm Đi", "Điểm Đến", "Giờ Đi", "Loại Ghế", "Toa", "Khoang" , "Vị Trí"
                }
        ){
            @Override
            public boolean isCellEditable(int data, int columnName) {
                return false;
            }
        };
        /*
            config basic tool interface for table
         */
        this.table = new JTable();
        table.setModel(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(30);
        table.setFont((new PhongChuMoi()).layPhongRobotoMonoReg(Font.PLAIN, 12));
        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        header.setDefaultRenderer(new CustomHeaderRenderer());

        // Sử dụng renderer tùy chỉnh cho các ô trong bảng
        table.setDefaultRenderer(Object.class, new CustomCellRenderer());


        /*
            config basic tool interface for scrollpane
         */
        this.scrollpane = new JScrollPane();
        scrollpane.setViewportView(table);
        scrollpane.setBorder(BorderFactory.createLineBorder(new Color(0, 112, 255)));
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        /*
            config giao diện cho bảng danh sách
         */
        this.trangChua_TableDanhSach = new JPanel();
        GroupLayout trangChua_TableDanhSachLayout = new   GroupLayout(trangChua_TableDanhSach);
        trangChua_TableDanhSach.setLayout(trangChua_TableDanhSachLayout);
        trangChua_TableDanhSachLayout.setHorizontalGroup(
                trangChua_TableDanhSachLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_TableDanhSachLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollpane,   GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChua_TableDanhSachLayout.setVerticalGroup(
                trangChua_TableDanhSachLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_TableDanhSachLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollpane,   GroupLayout.PREFERRED_SIZE, 240,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE))
        );
    }

    private void thietLap_TrangChuaCongCuHoTro(){
        this.capNhat = new JButton();
        this.xoa = new JButton();
        this.lamMoi = new JButton();
        this.trangChua_CongCu = new JPanel();
        this.trangChua_ChiTietCacCongCu = new JPanel();

        capNhat.setText("Cập Nhật");;
        capNhat.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 14));
        capNhat.setBackground(xanhBrandeis);
        capNhat.setForeground(trang);

        xoa.setText("Xóa");
        xoa.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 14));
        xoa.setBackground(xanhBrandeis);
        xoa.setForeground(trang);

        lamMoi.setText("Làm Mới");
        lamMoi.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 14));
        lamMoi.setBackground(xanhBrandeis);
        lamMoi.setForeground(trang);

        GroupLayout trangChua_CongCuLayout = new   GroupLayout(trangChua_CongCu);
        trangChua_CongCu.setLayout(trangChua_CongCuLayout);
        trangChua_CongCuLayout.setHorizontalGroup(
                trangChua_CongCuLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_CongCuLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(trangChua_CongCuLayout.createParallelGroup(  GroupLayout.Alignment.LEADING, false)
                                        .addComponent(capNhat,   GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                        .addComponent(xoa,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lamMoi,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(42, Short.MAX_VALUE))
        );
        trangChua_CongCuLayout.setVerticalGroup(
                trangChua_CongCuLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_CongCuLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(capNhat,   GroupLayout.PREFERRED_SIZE, 39,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(xoa,   GroupLayout.PREFERRED_SIZE, 40,   GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(lamMoi,   GroupLayout.PREFERRED_SIZE, 41,   GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
        );

        GroupLayout trangChua_ChiTietCacCongCuLayout = new   GroupLayout(trangChua_ChiTietCacCongCu);
        trangChua_ChiTietCacCongCu.setLayout(trangChua_ChiTietCacCongCuLayout);
        trangChua_ChiTietCacCongCuLayout.setHorizontalGroup(
                trangChua_ChiTietCacCongCuLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ChiTietCacCongCuLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(trangChua_CongCu,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(27, Short.MAX_VALUE))
        );
        trangChua_ChiTietCacCongCuLayout.setVerticalGroup(
                trangChua_ChiTietCacCongCuLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ChiTietCacCongCuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(trangChua_CongCu,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }


    private void thietLap_TrangChuaDanhSachVe(){
        this.trangChua_DanhSachVe = new JPanel();

        GroupLayout trangChua_DanhSachVeLayout = new   GroupLayout(trangChua_DanhSachVe);
        trangChua_DanhSachVe.setLayout(trangChua_DanhSachVeLayout);
        trangChua_DanhSachVeLayout.setHorizontalGroup(
                trangChua_DanhSachVeLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_DanhSachVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(trangChua_TableDanhSach,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(trangChua_ChiTietCacCongCu,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChua_DanhSachVeLayout.setVerticalGroup(
                trangChua_DanhSachVeLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_DanhSachVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_DanhSachVeLayout.createParallelGroup(  GroupLayout.Alignment.LEADING, false)
                                        .addComponent(trangChua_ChiTietCacCongCu,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChua_TableDanhSach,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(7, Short.MAX_VALUE))
        );
    }

    private void thietLap_TrangGiaoDien(){
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChua_TieuDe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChua_ThanhTimKiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChua_ThongTinChiTiet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChua_DanhSachVe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(trangChua_TieuDe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_ThanhTimKiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_ThongTinChiTiet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(trangChua_DanhSachVe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }

    public static void moGiaoDienDanhSach() {
        new TrangDanhSachVeTau();
    }
}
