package app.giao_dien;



import app.dieu_khien.HanhDong_TrangDanhSachVe;
import app.phan_tu_tuy_chinh.CustomCellRenderer;
import app.phan_tu_tuy_chinh.CustomHeaderRenderer;
import app.phong_chu_moi.PhongChuMoi;
import app.thuc_the.Ve;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import   javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import java.util.List;

@Slf4j
public class TrangDanhSachVeTau extends JFrame{

    public javax.swing.JButton buttonHuyVe;
    public javax.swing.JButton buttonInVe;
    public javax.swing.JButton buttonLamMoi;
    public javax.swing.JButton buttonThongTinChiTiet;
    public javax.swing.JLabel giaVe;
    public javax.swing.JLabel ngayDatVe;
    public javax.swing.JLabel ngayKhoiHanh;
    public javax.swing.JScrollPane scrollPane;
    public javax.swing.JTable table;
    public javax.swing.JTextField textFieldDiemDen;
    public javax.swing.JTextField textFieldDiemDi;
    public javax.swing.JTextField textFieldDoiTuong;
    public javax.swing.JTextField textFieldLoaiVe;
    public javax.swing.JTextField textFieldMaGhe;
    public javax.swing.JTextField textFieldMaKhachHang;
    public javax.swing.JTextField textFieldMaVe;
    public javax.swing.JTextField thanhTimKiem;
    public javax.swing.JLabel tieuDe;
    public javax.swing.JLabel tieuDeGiaVe;
    public javax.swing.JLabel tieuDeNgayDatVe;
    public javax.swing.JLabel tieuDeNgayKhoiHanh;
    public javax.swing.JLabel tieuDe_DiemDen;
    public javax.swing.JLabel tieuDe_DiemDi;
    public javax.swing.JLabel tieuDe_DoiTuong;
    public javax.swing.JLabel tieuDe_LoaiGhe;
    public javax.swing.JLabel tieuDe_MaGhe;
    public javax.swing.JLabel tieuDe_MaKhachHang;
    public javax.swing.JLabel tieuDe_MaVe;
    public javax.swing.JButton timKiem;
    public javax.swing.JLabel timKiemVe;
    public javax.swing.JPanel trangChua_ButtonThongTinChiTiet;
    public javax.swing.JPanel trangChua_CacCongCuChinhSua;
    public javax.swing.JPanel trangChua_CongCu;
    public javax.swing.JPanel trangChua_DanhSachVe;
    public javax.swing.JPanel trangChua_DiemDen;
    public javax.swing.JPanel trangChua_DiemDi;
    public javax.swing.JPanel trangChua_DoiTuong;
    public javax.swing.JPanel trangChua_GiaVe;
    public javax.swing.JPanel trangChua_LoaiVe;
    public javax.swing.JPanel trangChua_MaGhe;
    public javax.swing.JPanel trangChua_MaKhachHang;
    public javax.swing.JPanel trangChua_MaVe;
    public javax.swing.JPanel trangChua_NgayDatVe;
    public javax.swing.JPanel trangChua_NgayKhoiHanh;
    public javax.swing.JPanel trangChua_TableDanhSach;
    public javax.swing.JPanel trangChua_ThanhTimKiem;
    public javax.swing.JPanel trangChua_ThongTinChiTiet;
    public javax.swing.JPanel trangChua_ThongTinGiaVe;
    public javax.swing.JPanel trangChua_ThongTinMaVe;
    public javax.swing.JPanel trangChua_ThongTinThoiDiem;
    public javax.swing.JPanel trangChua_ThongTinVe;
    public javax.swing.JPanel trangChua_TieuDe;

    public DefaultTableModel model ;
    public Color xanhBrandeis = new Color(0, 112, 255);
    public  Color trang = new Color(255, 255, 255);
    public Border gachChanDam = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis);

    //public static final Logger logger = LoggerFactory.getLogger(TrangDanhSachVeTau.class);
    /*
        các thuộc tính xử lý hành động
     */
    ActionListener ac ;
    MouseListener mouse ;
    Logger logger = LoggerFactory.getLogger(TrangDanhSachVeTau.class);

    public TrangDanhSachVeTau(){

        // setting basic config for interface
       // this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       // this.setPreferredSize(new Dimension(1500, 700))
        //this.setSize(new Dimension(1500, 700));
//        this.setResizable(false);
//        this.pack();
//        this.setLocationRelativeTo(null);

        this.setSize(1286, 684); // Đặt kích thước cụ thể cho cửa sổ
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        trangChua_TieuDe = new javax.swing.JPanel();
        tieuDe = new javax.swing.JLabel();
        trangChua_ThanhTimKiem = new javax.swing.JPanel();
        timKiemVe = new javax.swing.JLabel();
        thanhTimKiem = new javax.swing.JTextField();
        timKiem = new javax.swing.JButton();
        trangChua_ThongTinChiTiet = new javax.swing.JPanel();
        trangChua_ThongTinMaVe = new javax.swing.JPanel();
        trangChua_MaVe = new javax.swing.JPanel();
        tieuDe_MaVe = new javax.swing.JLabel();
        textFieldMaVe = new javax.swing.JTextField();
        trangChua_MaKhachHang = new javax.swing.JPanel();
        tieuDe_MaKhachHang = new javax.swing.JLabel();
        textFieldMaKhachHang = new javax.swing.JTextField();
        trangChua_MaGhe = new javax.swing.JPanel();
        tieuDe_MaGhe = new javax.swing.JLabel();
        textFieldMaGhe = new javax.swing.JTextField();
        trangChua_ThongTinVe = new javax.swing.JPanel();
        trangChua_DiemDi = new javax.swing.JPanel();
        tieuDe_DiemDi = new javax.swing.JLabel();
        textFieldDiemDi = new javax.swing.JTextField();
        trangChua_DiemDen = new javax.swing.JPanel();
        tieuDe_DiemDen = new javax.swing.JLabel();
        textFieldDiemDen = new javax.swing.JTextField();
        trangChua_LoaiVe = new javax.swing.JPanel();
        tieuDe_LoaiGhe = new javax.swing.JLabel();
        textFieldLoaiVe = new javax.swing.JTextField();
        trangChua_DoiTuong = new javax.swing.JPanel();
        tieuDe_DoiTuong = new javax.swing.JLabel();
        textFieldDoiTuong = new javax.swing.JTextField();
        trangChua_ThongTinGiaVe = new javax.swing.JPanel();
        trangChua_ThongTinThoiDiem = new javax.swing.JPanel();
        trangChua_NgayDatVe = new javax.swing.JPanel();
        tieuDeNgayDatVe = new javax.swing.JLabel();
        ngayDatVe = new javax.swing.JLabel();
        trangChua_NgayKhoiHanh = new javax.swing.JPanel();
        tieuDeNgayKhoiHanh = new javax.swing.JLabel();
        ngayKhoiHanh = new javax.swing.JLabel();
        trangChua_GiaVe = new javax.swing.JPanel();
        tieuDeGiaVe = new javax.swing.JLabel();
        giaVe = new javax.swing.JLabel();
        trangChua_DanhSachVe = new javax.swing.JPanel();
        trangChua_TableDanhSach = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        trangChua_CongCu = new javax.swing.JPanel();
        trangChua_CacCongCuChinhSua = new javax.swing.JPanel();
        buttonLamMoi = new javax.swing.JButton();
        buttonHuyVe = new javax.swing.JButton();
        buttonInVe = new javax.swing.JButton();
        trangChua_ButtonThongTinChiTiet = new javax.swing.JPanel();
        buttonThongTinChiTiet = new javax.swing.JButton();


        // config trang chứa tiêu đề
        thietLap_TrangChuaTieuDe();

        // config trang chứa thanh tìm kiếm
        thietLap_TrangChuaThanhTimKiem();

        // config trang  chứa mã vé
        thietLap_TrangChuaMaVe();

        // config trang chữa mã khách hàng
        thietLap_TrangChuaMaKhachHang();

        // config trang chứa mã ghế
        thietLap_TrangChuaMaGhe();

        // config trang chứa thông tin mã vé
        thietLap_TrangChuaThongTinMaVe();

        // config trang chứa điểm đi
        thietLap_TrangChuaDiemDi();

        // config trang chứa điểm đến
        thietLap_TrangChuaDiemDen();

        // config trang chứa loại vé
        thietLap_TrangChuaLoaiVe();

        // config trang chứa đối tượng
        thietLap_TrangChuaDoiTuong();

        // config trang thiết lập trang chứa thông tin vé
        thietLap_TrangChuaThongTinVe();

        thietLap_TrangChuaNgayDatVe();
        thietLap_NgayKhoiHanh();
        thietLap_TrangChuaThoiTinThoiDiem();

        thietLap_TrangChuaGiaVe();
        thietLap_TrangChuaThongTinGiaVe();
        thietLap_TrangChuaThongTinChiTiet();
        thietLap_BangChuaDanhSachVeTau();
        thietLap_TrangChuaCongCuChinhSua();
        thietLap_trangChuaButtonThongTinChiTiet();
        thietLap_TrangChuaCongCu();
        thietLap_TrangGiaoDien();


        // thiết kế background
        this.setBackground(new Color(255, 255, 255));
        //trangChua_DonGia.setBackground(new Color(255, 255, 255));
//        tragChua_TieuDeThongTinChiTiet.setBackground(new Color(255, 255, 255));
//        trangChua_ChiTietCacCongCu.setBackground(new Color(255, 255, 255));
//        trangChua_Email.setBackground(new Color(255, 255, 255));
//        trangChua_CongCu.setBackground(new Color(255, 255, 255));
//        trangChua_DanhSachVe.setBackground(new Color(255, 255, 255));;
//        trangChua_SoDienThoai.setBackground(new Color(255, 255, 255));
        this.ac = new HanhDong_TrangDanhSachVe(this);
        this.mouse = new HanhDong_TrangDanhSachVe(this);
        table.addMouseListener(mouse);
        this.setVisible(true);
    }

    public void thietLap_TrangChuaTieuDe(){
        tieuDe.setText("                                                            Danh Sach Bán Vé Tàu");

        javax.swing.GroupLayout trangChua_TieuDeLayout = new javax.swing.GroupLayout(trangChua_TieuDe);
        trangChua_TieuDe.setLayout(trangChua_TieuDeLayout);
        trangChua_TieuDeLayout.setHorizontalGroup(
                trangChua_TieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChua_TieuDeLayout.createSequentialGroup()
                                .addContainerGap(126, Short.MAX_VALUE)
                                .addComponent(tieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        trangChua_TieuDeLayout.setVerticalGroup(
                trangChua_TieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_TieuDeLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(tieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    public void thietLap_TrangChuaThanhTimKiem(){
        timKiemVe.setText("Tìm Kiếm vé ");

        thanhTimKiem.setText("jTextField1");

        timKiem.setText("jButton1");
        timKiem.addActionListener(ac);

        javax.swing.GroupLayout trangChua_ThanhTimKiemLayout = new javax.swing.GroupLayout(trangChua_ThanhTimKiem);
        trangChua_ThanhTimKiem.setLayout(trangChua_ThanhTimKiemLayout);
        trangChua_ThanhTimKiemLayout.setHorizontalGroup(
                trangChua_ThanhTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThanhTimKiemLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(timKiemVe, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thanhTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        trangChua_ThanhTimKiemLayout.setVerticalGroup(
                trangChua_ThanhTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThanhTimKiemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_ThanhTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(trangChua_ThanhTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(thanhTimKiem)
                                                .addComponent(timKiemVe, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))
        );
    }
    public void thietLap_TrangChuaMaVe(){
        //trangChua_ThongTinMaVe.setBackground(new java.awt.Color(0, 255, 51));


        trangChua_MaVe.setPreferredSize(new java.awt.Dimension(370, 75));
        trangChua_MaVe.setRequestFocusEnabled(false);

        tieuDe_MaVe.setText("Mã Vé:");

        textFieldMaVe.setText("");

        javax.swing.GroupLayout trangChua_MaVeLayout = new javax.swing.GroupLayout(trangChua_MaVe);
        trangChua_MaVe.setLayout(trangChua_MaVeLayout);
        trangChua_MaVeLayout.setHorizontalGroup(
                trangChua_MaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_MaVeLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(tieuDe_MaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(10, Short.MAX_VALUE))
        );
        trangChua_MaVeLayout.setVerticalGroup(
                trangChua_MaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_MaVeLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(trangChua_MaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDe_MaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(22, Short.MAX_VALUE))
        );
    }
    public void thietLap_TrangChuaMaKhachHang(){
        trangChua_MaKhachHang.setPreferredSize(new java.awt.Dimension(370, 75));
        trangChua_MaKhachHang.setRequestFocusEnabled(false);

        tieuDe_MaKhachHang.setText("Mã Khách Hàng:");

        textFieldMaKhachHang.setText("");

        javax.swing.GroupLayout trangChua_MaKhachHangLayout = new javax.swing.GroupLayout(trangChua_MaKhachHang);
        trangChua_MaKhachHang.setLayout(trangChua_MaKhachHangLayout);
        trangChua_MaKhachHangLayout.setHorizontalGroup(
                trangChua_MaKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_MaKhachHangLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(tieuDe_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(10, Short.MAX_VALUE))
        );
        trangChua_MaKhachHangLayout.setVerticalGroup(
                trangChua_MaKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChua_MaKhachHangLayout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addGroup(trangChua_MaKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDe_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21))
        );
    }
    public void thietLap_TrangChuaMaGhe(){
        trangChua_MaGhe.setPreferredSize(new java.awt.Dimension(370, 75));

        tieuDe_MaGhe.setText("Mã Ghế:");

        textFieldMaGhe.setText("");

        javax.swing.GroupLayout trangChua_MaGheLayout = new javax.swing.GroupLayout(trangChua_MaGhe);
        trangChua_MaGhe.setLayout(trangChua_MaGheLayout);
        trangChua_MaGheLayout.setHorizontalGroup(
                trangChua_MaGheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_MaGheLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(tieuDe_MaGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldMaGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(10, Short.MAX_VALUE))
        );
        trangChua_MaGheLayout.setVerticalGroup(
                trangChua_MaGheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_MaGheLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(trangChua_MaGheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDe_MaGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldMaGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(21, Short.MAX_VALUE))
        );
    }
    public void thietLap_TrangChuaThongTinMaVe(){
        //trangChua_ThongTinMaVe.setBackground(new java.awt.Color(0, 255, 51));
        trangChua_ThongTinMaVe.setPreferredSize(new java.awt.Dimension(380, 249));
        javax.swing.GroupLayout trangChua_ThongTinMaVeLayout = new javax.swing.GroupLayout(trangChua_ThongTinMaVe);
        trangChua_ThongTinMaVe.setLayout(trangChua_ThongTinMaVeLayout);
        trangChua_ThongTinMaVeLayout.setHorizontalGroup(
                trangChua_ThongTinMaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinMaVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_ThongTinMaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChua_MaVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(trangChua_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(trangChua_MaGhe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 13, Short.MAX_VALUE))
        );
        trangChua_ThongTinMaVeLayout.setVerticalGroup(
                trangChua_ThongTinMaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinMaVeLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChua_MaVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(trangChua_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_MaGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }
    public void thietLap_TrangChuaDiemDi(){
        trangChua_DiemDi.setPreferredSize(new java.awt.Dimension(370, 50));
        trangChua_DiemDi.setRequestFocusEnabled(false);

        tieuDe_DiemDi.setText("Điểm Đi:");

        textFieldDiemDi.setText("");

        javax.swing.GroupLayout trangChua_DiemDiLayout = new javax.swing.GroupLayout(trangChua_DiemDi);
        trangChua_DiemDi.setLayout(trangChua_DiemDiLayout);
        trangChua_DiemDiLayout.setHorizontalGroup(
                trangChua_DiemDiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_DiemDiLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tieuDe_DiemDi, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldDiemDi, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        trangChua_DiemDiLayout.setVerticalGroup(
                trangChua_DiemDiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_DiemDiLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_DiemDiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDe_DiemDi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldDiemDi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(13, Short.MAX_VALUE))
        );

    }
    public void thietLap_TrangChuaDiemDen(){
        trangChua_DiemDen.setPreferredSize(new java.awt.Dimension(370, 50));
        trangChua_DiemDen.setRequestFocusEnabled(false);

        tieuDe_DiemDen.setText("Điểm Đến:");

        textFieldDiemDen.setText("");


        javax.swing.GroupLayout trangChua_DiemDenLayout = new javax.swing.GroupLayout(trangChua_DiemDen);
        trangChua_DiemDen.setLayout(trangChua_DiemDenLayout);
        trangChua_DiemDenLayout.setHorizontalGroup(
                trangChua_DiemDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_DiemDenLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tieuDe_DiemDen, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldDiemDen, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        trangChua_DiemDenLayout.setVerticalGroup(
                trangChua_DiemDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_DiemDenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_DiemDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDe_DiemDen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldDiemDen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(13, Short.MAX_VALUE))
        );
    }
    public void thietLap_TrangChuaLoaiVe(){
        trangChua_LoaiVe.setPreferredSize(new java.awt.Dimension(370, 50));
        trangChua_LoaiVe.setRequestFocusEnabled(false);

        tieuDe_LoaiGhe.setText("Loại Ghế:");

        textFieldLoaiVe.setText("jTextField2");

        javax.swing.GroupLayout trangChua_LoaiVeLayout = new javax.swing.GroupLayout(trangChua_LoaiVe);
        trangChua_LoaiVe.setLayout(trangChua_LoaiVeLayout);
        trangChua_LoaiVeLayout.setHorizontalGroup(
                trangChua_LoaiVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_LoaiVeLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tieuDe_LoaiGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldLoaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        trangChua_LoaiVeLayout.setVerticalGroup(
                trangChua_LoaiVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_LoaiVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_LoaiVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDe_LoaiGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldLoaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(13, Short.MAX_VALUE))
        );

    }
    public void thietLap_TrangChuaDoiTuong(){
        trangChua_DoiTuong.setPreferredSize(new java.awt.Dimension(370, 50));
        trangChua_DoiTuong.setRequestFocusEnabled(false);

        tieuDe_DoiTuong.setText("Đối Tượng:");

        textFieldDoiTuong.setText("");

        javax.swing.GroupLayout trangChua_DoiTuongLayout = new javax.swing.GroupLayout(trangChua_DoiTuong);
        trangChua_DoiTuong.setLayout(trangChua_DoiTuongLayout);
        trangChua_DoiTuongLayout.setHorizontalGroup(
                trangChua_DoiTuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_DoiTuongLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tieuDe_DoiTuong, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldDoiTuong, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        trangChua_DoiTuongLayout.setVerticalGroup(
                trangChua_DoiTuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_DoiTuongLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_DoiTuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDe_DoiTuong, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldDoiTuong, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(13, Short.MAX_VALUE))
        );
    }
    public void thietLap_TrangChuaThongTinVe(){
        //trangChua_ThongTinVe.setBackground(new java.awt.Color(204, 0, 204));
        trangChua_ThongTinVe.setPreferredSize(new java.awt.Dimension(380, 249));
        javax.swing.GroupLayout trangChua_ThongTinVeLayout = new javax.swing.GroupLayout(trangChua_ThongTinVe);
        trangChua_ThongTinVe.setLayout(trangChua_ThongTinVeLayout);
        trangChua_ThongTinVeLayout.setHorizontalGroup(
                trangChua_ThongTinVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_ThongTinVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChua_DiemDi, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                                        .addComponent(trangChua_DiemDen, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                                        .addComponent(trangChua_LoaiVe, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                                        .addComponent(trangChua_DoiTuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                                .addContainerGap())
        );
        trangChua_ThongTinVeLayout.setVerticalGroup(
                trangChua_ThongTinVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinVeLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(trangChua_DiemDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_DiemDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_LoaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_DoiTuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    public void thietLap_TrangChuaNgayDatVe(){
        tieuDeNgayDatVe.setText("Ngày Đặt Vé:");

        javax.swing.GroupLayout trangChua_NgayDatVeLayout = new javax.swing.GroupLayout(trangChua_NgayDatVe);
        trangChua_NgayDatVe.setLayout(trangChua_NgayDatVeLayout);
        trangChua_NgayDatVeLayout.setHorizontalGroup(
                trangChua_NgayDatVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_NgayDatVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tieuDeNgayDatVe, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ngayDatVe, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChua_NgayDatVeLayout.setVerticalGroup(
                trangChua_NgayDatVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_NgayDatVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_NgayDatVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDeNgayDatVe, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                        .addComponent(ngayDatVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }
    public void thietLap_NgayKhoiHanh(){
        tieuDeNgayKhoiHanh.setText("Ngày Khởi Hành");

        javax.swing.GroupLayout trangChua_NgayKhoiHanhLayout = new javax.swing.GroupLayout(trangChua_NgayKhoiHanh);
        trangChua_NgayKhoiHanh.setLayout(trangChua_NgayKhoiHanhLayout);
        trangChua_NgayKhoiHanhLayout.setHorizontalGroup(
                trangChua_NgayKhoiHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_NgayKhoiHanhLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tieuDeNgayKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ngayKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(37, Short.MAX_VALUE))
        );
        trangChua_NgayKhoiHanhLayout.setVerticalGroup(
                trangChua_NgayKhoiHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_NgayKhoiHanhLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(trangChua_NgayKhoiHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDeNgayKhoiHanh, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                        .addComponent(ngayKhoiHanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(7, 7, 7))
        );

    }
    public void thietLap_TrangChuaThoiTinThoiDiem(){
            //trangChua_ThongTinThoiDiem.setBackground(new java.awt.Color(0, 0, 255));
        javax.swing.GroupLayout trangChua_ThongTinThoiDiemLayout = new javax.swing.GroupLayout(trangChua_ThongTinThoiDiem);
        trangChua_ThongTinThoiDiem.setLayout(trangChua_ThongTinThoiDiemLayout);
        trangChua_ThongTinThoiDiemLayout.setHorizontalGroup(
                trangChua_ThongTinThoiDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinThoiDiemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_ThongTinThoiDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChua_NgayKhoiHanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChua_NgayDatVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        trangChua_ThongTinThoiDiemLayout.setVerticalGroup(
                trangChua_ThongTinThoiDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinThoiDiemLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(trangChua_NgayDatVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(trangChua_NgayKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

    }
    public void thietLap_TrangChuaGiaVe(){
       // trangChua_GiaVe.setBackground(new java.awt.Color(0, 153, 153));
        tieuDeGiaVe.setText("Giá vé:");

        giaVe.setText("20000");

        javax.swing.GroupLayout trangChua_GiaVeLayout = new javax.swing.GroupLayout(trangChua_GiaVe);
        trangChua_GiaVe.setLayout(trangChua_GiaVeLayout);
        trangChua_GiaVeLayout.setHorizontalGroup(
                trangChua_GiaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_GiaVeLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(trangChua_GiaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(giaVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tieuDeGiaVe, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChua_GiaVeLayout.setVerticalGroup(
                trangChua_GiaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_GiaVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tieuDeGiaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(giaVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

    }
    public void thietLap_TrangChuaThongTinGiaVe(){
        //trangChua_ThongTinGiaVe.setBackground(new java.awt.Color(255, 51, 51));
        trangChua_ThongTinGiaVe.setPreferredSize(new java.awt.Dimension(380, 300));
        javax.swing.GroupLayout trangChua_ThongTinGiaVeLayout = new javax.swing.GroupLayout(trangChua_ThongTinGiaVe);
        trangChua_ThongTinGiaVe.setLayout(trangChua_ThongTinGiaVeLayout);
        trangChua_ThongTinGiaVeLayout.setHorizontalGroup(
                trangChua_ThongTinGiaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChua_ThongTinGiaVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_ThongTinGiaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(trangChua_ThongTinThoiDiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChua_GiaVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        trangChua_ThongTinGiaVeLayout.setVerticalGroup(
                trangChua_ThongTinGiaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinGiaVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(trangChua_ThongTinThoiDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(trangChua_GiaVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
        );
    }
    public void thietLap_TrangChuaThongTinChiTiet(){
        javax.swing.GroupLayout trangChua_ThongTinChiTietLayout = new javax.swing.GroupLayout(trangChua_ThongTinChiTiet);
        trangChua_ThongTinChiTiet.setLayout(trangChua_ThongTinChiTietLayout);
        trangChua_ThongTinChiTietLayout.setHorizontalGroup(
                trangChua_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinChiTietLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(trangChua_ThongTinMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChua_ThongTinVe, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(trangChua_ThongTinGiaVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        trangChua_ThongTinChiTietLayout.setVerticalGroup(
                trangChua_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinChiTietLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(trangChua_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChua_ThongTinGiaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(trangChua_ThongTinVe, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(trangChua_ThongTinMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }
    public void thietLap_BangChuaDanhSachVeTau(){
         this.model =new DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "Mã Vé","Điểm Đi", "Điểm Đến","Đối Tượng","Giá Vé", "Ngày Đặt Vé", "Ngày Khởi Hành"
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
        // add mouse listener cho table

        table.setModel(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(30);
        table.setFont((new PhongChuMoi()).layPhongRobotoMonoReg(Font.PLAIN, 12));

// Cấu hình renderer cho phần header
        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        header.setDefaultRenderer(new CustomHeaderRenderer()); // Sử dụng renderer tùy chỉnh

// Cấu hình renderer cho các ô trong bảng
        table.setDefaultRenderer(Object.class, new CustomCellRenderer());

        // cấu hình kích thước cho ô STT
        TableColumnModel columnModel = table.getColumnModel();
//        columnModel.getColumn(0).setPreferredWidth(100); // Chiều rộng mong muốn
//        columnModel.getColumn(0).setMinWidth(100);       // Chiều rộng nhỏ nhất
//        columnModel.getColumn(0).setMaxWidth(100);
//        columnModel.getColumn(1).setPreferredWidth(1000); // Chiều rộng mong muốn
//        columnModel.getColumn(1).setMinWidth(100);       // Chiều rộng nhỏ nhất
//        columnModel.getColumn(1).setMaxWidth(100);
//        columnModel.getColumn(2).setPreferredWidth(100); // Chiều rộng mong muốn
//        columnModel.getColumn(2).setMinWidth(100);       // Chiều rộng nhỏ nhất
//        columnModel.getColumn(2).setMaxWidth(100);
//        columnModel.getColumn(3).setPreferredWidth(100); // Chiều rộng mong muốn
//        columnModel.getColumn(3).setMinWidth(100);       // Chiều rộng nhỏ nhất
//        columnModel.getColumn(3).setMaxWidth(100);
//        columnModel.getColumn(4).setPreferredWidth(100); // Chiều rộng mong muốn
//        columnModel.getColumn(4).setMinWidth(100);       // Chiều rộng nhỏ nhất
//        columnModel.getColumn(4).setMaxWidth(100);
//        columnModel.getColumn(5).setPreferredWidth(100); // Chiều rộng mong muốn
//        columnModel.getColumn(5).setMinWidth(100);       // Chiều rộng nhỏ nhất
//        columnModel.getColumn(5).setMaxWidth(100);
//        columnModel.getColumn(6).setPreferredWidth(100); // Chiều rộng mong muốn
//        columnModel.getColumn(6).setMinWidth(100);       // Chiều rộng nhỏ nhất
//        columnModel.getColumn(6).setMaxWidth(100);
// Cấu hình scrollpane
        scrollPane.setViewportView(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(0, 112, 255)));



        /*
            config giao diện cho bảng danh sách
         */
        javax.swing.GroupLayout trangChua_TableDanhSachLayout = new javax.swing.GroupLayout(trangChua_TableDanhSach);
        trangChua_TableDanhSach.setLayout(trangChua_TableDanhSachLayout);
        trangChua_TableDanhSachLayout.setHorizontalGroup(
                trangChua_TableDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_TableDanhSachLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChua_TableDanhSachLayout.setVerticalGroup(
                trangChua_TableDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_TableDanhSachLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );


    }
    public void thietLap_TrangChuaCongCuChinhSua(){
        buttonLamMoi.setText("Làm Mới");
        buttonLamMoi.setBackground(xanhBrandeis);
        buttonLamMoi.setForeground(Color.WHITE);
        buttonLamMoi.addActionListener(ac);

        buttonHuyVe.setText("Hủy Vé");
        buttonHuyVe.setBackground(xanhBrandeis);
        buttonHuyVe.setForeground(Color.WHITE);
        buttonHuyVe.addActionListener(ac);

        buttonInVe.setText("In Vé");
        buttonInVe.setBackground(xanhBrandeis);
        buttonInVe.setForeground(Color.WHITE);
        buttonInVe.addActionListener(ac);

        javax.swing.GroupLayout trangChua_CacCongCuChinhSuaLayout = new javax.swing.GroupLayout(trangChua_CacCongCuChinhSua);
        trangChua_CacCongCuChinhSua.setLayout(trangChua_CacCongCuChinhSuaLayout);
        trangChua_CacCongCuChinhSuaLayout.setHorizontalGroup(
                trangChua_CacCongCuChinhSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_CacCongCuChinhSuaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_CacCongCuChinhSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(trangChua_CacCongCuChinhSuaLayout.createSequentialGroup()
                                                .addComponent(buttonLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChua_CacCongCuChinhSuaLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(trangChua_CacCongCuChinhSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(buttonHuyVe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(buttonInVe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        trangChua_CacCongCuChinhSuaLayout.setVerticalGroup(
                trangChua_CacCongCuChinhSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChua_CacCongCuChinhSuaLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(buttonLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(buttonHuyVe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(buttonInVe, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    public void thietLap_trangChuaButtonThongTinChiTiet(){
        buttonThongTinChiTiet.setText("Xem Chi Tiết Thông Tin");
        buttonThongTinChiTiet.setBackground(xanhBrandeis);
        buttonThongTinChiTiet.setForeground(Color.WHITE);
        buttonThongTinChiTiet.addActionListener(ac);
        javax.swing.GroupLayout trangChua_ButtonThongTinChiTietLayout = new javax.swing.GroupLayout(trangChua_ButtonThongTinChiTiet);
        trangChua_ButtonThongTinChiTiet.setLayout(trangChua_ButtonThongTinChiTietLayout);
        trangChua_ButtonThongTinChiTietLayout.setHorizontalGroup(
                trangChua_ButtonThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChua_ButtonThongTinChiTietLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonThongTinChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
        );
        trangChua_ButtonThongTinChiTietLayout.setVerticalGroup(
                trangChua_ButtonThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ButtonThongTinChiTietLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(buttonThongTinChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );
    }
    public void thietLap_TrangChuaCongCu(){
        javax.swing.GroupLayout trangChua_CongCuLayout = new javax.swing.GroupLayout(trangChua_CongCu);
        trangChua_CongCu.setLayout(trangChua_CongCuLayout);
        trangChua_CongCuLayout.setHorizontalGroup(
                trangChua_CongCuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_CongCuLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChua_CacCongCuChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_ButtonThongTinChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
        );
        trangChua_CongCuLayout.setVerticalGroup(
                trangChua_CongCuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_CongCuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_CongCuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(trangChua_CongCuLayout.createSequentialGroup()
                                                .addComponent(trangChua_CacCongCuChinhSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(trangChua_CongCuLayout.createSequentialGroup()
                                                .addComponent(trangChua_ButtonThongTinChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
    }

    public void thietLap_TrangGiaoDien(){
        javax.swing.GroupLayout trangChua_DanhSachVeLayout = new javax.swing.GroupLayout(trangChua_DanhSachVe);
        trangChua_DanhSachVe.setLayout(trangChua_DanhSachVeLayout);
        trangChua_DanhSachVeLayout.setHorizontalGroup(
                trangChua_DanhSachVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_DanhSachVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(trangChua_TableDanhSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_CongCu, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        trangChua_DanhSachVeLayout.setVerticalGroup(
                trangChua_DanhSachVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_DanhSachVeLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(trangChua_DanhSachVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(trangChua_TableDanhSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChua_CongCu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(275, 275, 275)
                                                                .addComponent(trangChua_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(trangChua_DanhSachVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(trangChua_ThanhTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(trangChua_ThongTinChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChua_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(trangChua_ThanhTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(trangChua_ThongTinChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_DanhSachVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pack();
    }

    public void dayDuLieuVaoBang(List<Ve> dsVe){


        for (Ve ve: dsVe) {
            Object[] data = {ve.getMaVe()+"",ve.getGaKhoiHanh()+"",
                    ve.getGaKetThuc()+"", ve.getLoaiDoiTuong()+"", ve.getGiaVe()+"",
                    ve.getNgayDatVe()+"", ve.getNgayKhoiHanh()};
            model.addRow(data);
        }
    }

    public static   void moGiaoDienDanhSach(){
        new TrangDanhSachVeTau().setVisible(true);
    }


    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangDanhSachVeTau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangDanhSachVeTau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangDanhSachVeTau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangDanhSachVeTau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangDanhSachVeTau().setVisible(true);
            }
        });
    }

}
