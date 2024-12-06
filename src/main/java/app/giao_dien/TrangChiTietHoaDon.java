package app.giao_dien;

import app.dao.ChiTietHoaDon_DAO;
import app.dao.HoaDon_DAO;
import app.dao.Ve_DAO;
import app.dieu_khien.HanhDong_TrangChiTietHoaDon;
import app.phan_tu_tuy_chinh.CustomCellRenderer;
import app.phan_tu_tuy_chinh.CustomHeaderRenderer;
import app.phong_chu_moi.PhongChuMoi;
import app.thuc_the.DaiNgo;
import app.thuc_the.HoaDon;
import app.thuc_the.Ve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

public class TrangChiTietHoaDon extends JFrame {
    // Variables declaration - do not modify                     
    public javax.swing.JButton button_XacNhan;
    public javax.swing.JLabel label_DanhSachVe;
    public javax.swing.JLabel label_SoLuong;
    public javax.swing.JLabel label_TienKhachTra;
    public javax.swing.JLabel label_TieuDe;
    public javax.swing.JLabel label_TongTien;
    public javax.swing.JScrollPane scrollPane;
    public javax.swing.JTable table_DanhSachVe;
    public javax.swing.JTextField textField_SoLuong;
    public javax.swing.JTextField textField_TienKhachTra;
    public javax.swing.JTextField textField_TongTiien;
    public javax.swing.JPanel trangChua_ChiTietThongTin;
    public javax.swing.JPanel trangChua_DanhSachVe;
    public javax.swing.JPanel trangChua_NutXacNhan;
    public javax.swing.JPanel trangChua_SoLuong;
    public javax.swing.JPanel trangChua_TienKhachTra;
    public javax.swing.JPanel trangChua_TieuDe;
    public javax.swing.JPanel trangChua_TongTien;

    public DefaultTableModel model;
    public Color xanhBrandeis = new Color(0, 112, 255);
    private TrangDanhSachVeTau trangDanhSachVeTau;
    private String maVe;
    private Ve ve;
    private HoaDon hoaDon;
    Logger logger = LoggerFactory.getLogger(TrangChiTietHoaDon.class);
    public TrangChiTietHoaDon(String maVe, TrangDanhSachVeTau trangDanhSachVeTau){
        trangChua_TieuDe = new javax.swing.JPanel();
        label_TieuDe = new javax.swing.JLabel();
        trangChua_DanhSachVe = new javax.swing.JPanel();
        label_DanhSachVe = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        table_DanhSachVe = new javax.swing.JTable();
        trangChua_ChiTietThongTin = new javax.swing.JPanel();
        trangChua_TongTien = new javax.swing.JPanel();
        label_TongTien = new javax.swing.JLabel();
        textField_TongTiien = new javax.swing.JTextField();
        trangChua_SoLuong = new javax.swing.JPanel();
        label_SoLuong = new javax.swing.JLabel();
        textField_SoLuong = new javax.swing.JTextField();
        trangChua_TienKhachTra = new javax.swing.JPanel();
        label_TienKhachTra = new javax.swing.JLabel();
        textField_TienKhachTra = new javax.swing.JTextField();
        trangChua_NutXacNhan = new javax.swing.JPanel();
        button_XacNhan = new javax.swing.JButton();
        model = new javax.swing.table.DefaultTableModel(null, new String [] {"STT", "Mã Vé", "Giá Vé" });
        this.maVe = maVe;
        this.trangDanhSachVeTau =trangDanhSachVeTau;
        this.ve = Ve_DAO.layVe_DuaVaoMaVe(this.maVe).get(0);
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Thiết lập  trang chứa giao diện tiêu đề
        thietLap_TrangChuaTieuDe();
        // Thiết lập  trang chứa giao diện danh sách các vé
        thietLap_TrangChuaDanhSachVe();
        // Thiết lập  trang chứa giao diện chi tiết thông tin vé
        thietLap_TrangChuaThongTinChiTiet();
        // Thiết lập trang chứa giao diện nút xác nhận
        thietLap_TrangChuaButtonXacNhan();
        // thiết lập trang chứa giao diện toàn trang
        thietLap_TrangGiaoDienChiTietHoaDon();

        ImageIcon icon = new ImageIcon("assets/icon.png");
        setIconImage(icon.getImage());
        setTitle("Chi Tiết Hóa Đơn");
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        /*
            thiết lập không cho phép chỉnh sửa
         */
        caiDatEnableCacThanhTextField();

        /*
            đẩy các dữ liệu vào các thanh
         */
        dayCacDuLieuVeVaoTrongTable();

        ActionListener ac = new HanhDong_TrangChiTietHoaDon(this);
        this.button_XacNhan.addActionListener(ac);
    }

    private void thietLap_TrangChuaTieuDe(){
        label_TieuDe.setText("       Chi Tiết Hóa Đơn");
        label_TieuDe.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 15));

        javax.swing.GroupLayout trangChua_TieuDeLayout = new javax.swing.GroupLayout(trangChua_TieuDe);
        trangChua_TieuDe.setLayout(trangChua_TieuDeLayout);
        trangChua_TieuDeLayout.setHorizontalGroup(
                trangChua_TieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChua_TieuDeLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(134, 134, 134))
        );
        trangChua_TieuDeLayout.setVerticalGroup(
                trangChua_TieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_TieuDeLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(label_TieuDe)
                                .addContainerGap(15, Short.MAX_VALUE))
        );
    }

    private void thietLap_TrangChuaDanhSachVe(){
        label_DanhSachVe.setText("Danh Sách Vé:");
        label_DanhSachVe.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));

        table_DanhSachVe.setModel(model);
        table_DanhSachVe.getTableHeader().setReorderingAllowed(false);
        table_DanhSachVe.setRowHeight(30);
        table_DanhSachVe.setFont((new PhongChuMoi()).layPhongRobotoMonoReg(Font.PLAIN, 13));
        // Cấu hình renderer cho phần header
        JTableHeader header = table_DanhSachVe.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        header.setDefaultRenderer(new CustomHeaderRenderer()); // Sử dụng renderer tùy chỉnh
        // Cấu hình renderer cho các ô trong bảng
        table_DanhSachVe.setDefaultRenderer(Object.class, new CustomCellRenderer());

        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(0, 112, 255)));
        scrollPane.setViewportView(table_DanhSachVe);

        javax.swing.GroupLayout trangChua_DanhSachVeLayout = new javax.swing.GroupLayout(trangChua_DanhSachVe);
        trangChua_DanhSachVe.setLayout(trangChua_DanhSachVeLayout);
        trangChua_DanhSachVeLayout.setHorizontalGroup(
                trangChua_DanhSachVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_DanhSachVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_DanhSachVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                                        .addGroup(trangChua_DanhSachVeLayout.createSequentialGroup()
                                                .addComponent(label_DanhSachVe, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        trangChua_DanhSachVeLayout.setVerticalGroup(
                trangChua_DanhSachVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_DanhSachVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label_DanhSachVe)
                                .addGap(12, 12, 12)
                                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
        );
    }

    private void thietLap_TrangChuaThongTinChiTiet(){
        label_TongTien.setText("Tổng Tiền:");
        label_TongTien.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));

        textField_TongTiien.setText("");
        textField_TongTiien.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 14));
        textField_TongTiien.setForeground(Color.BLUE);
        textField_TongTiien.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));

        javax.swing.GroupLayout trangChua_TongTienLayout = new javax.swing.GroupLayout(trangChua_TongTien);
        trangChua_TongTien.setLayout(trangChua_TongTienLayout);
        trangChua_TongTienLayout.setHorizontalGroup(
                trangChua_TongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_TongTienLayout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(label_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textField_TongTiien, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))
        );
        trangChua_TongTienLayout.setVerticalGroup(
                trangChua_TongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_TongTienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_TongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label_TongTien)
                                        .addComponent(textField_TongTiien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(10, Short.MAX_VALUE))
        );

        label_SoLuong.setText("Số Lượng:");
        label_SoLuong.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));

        textField_SoLuong.setText("");
        textField_SoLuong.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 14));
        textField_SoLuong.setForeground(Color.BLUE);
        textField_SoLuong.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));

        javax.swing.GroupLayout trangChua_SoLuongLayout = new javax.swing.GroupLayout(trangChua_SoLuong);
        trangChua_SoLuong.setLayout(trangChua_SoLuongLayout);
        trangChua_SoLuongLayout.setHorizontalGroup(
                trangChua_SoLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_SoLuongLayout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(label_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textField_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))
        );
        trangChua_SoLuongLayout.setVerticalGroup(
                trangChua_SoLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_SoLuongLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_SoLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label_SoLuong)
                                        .addComponent(textField_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        label_TienKhachTra.setText("Tiền Trả Lại Khách:");
        label_TienKhachTra.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));

        textField_TienKhachTra.setText("");
        textField_TienKhachTra.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 14));
        textField_TienKhachTra.setForeground(Color.BLUE);
        textField_TienKhachTra.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));

        javax.swing.GroupLayout trangChua_TienKhachTraLayout = new javax.swing.GroupLayout(trangChua_TienKhachTra);
        trangChua_TienKhachTra.setLayout(trangChua_TienKhachTraLayout);
        trangChua_TienKhachTraLayout.setHorizontalGroup(
                trangChua_TienKhachTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_TienKhachTraLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(label_TienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textField_TienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))
        );
        trangChua_TienKhachTraLayout.setVerticalGroup(
                trangChua_TienKhachTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_TienKhachTraLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_TienKhachTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label_TienKhachTra)
                                        .addComponent(textField_TienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout trangChua_ChiTietThongTinLayout = new javax.swing.GroupLayout(trangChua_ChiTietThongTin);
        trangChua_ChiTietThongTin.setLayout(trangChua_ChiTietThongTinLayout);
        trangChua_ChiTietThongTinLayout.setHorizontalGroup(
                trangChua_ChiTietThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ChiTietThongTinLayout.createSequentialGroup()
                                .addGroup(trangChua_ChiTietThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChua_TongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChua_SoLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChua_TienKhachTra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        trangChua_ChiTietThongTinLayout.setVerticalGroup(
                trangChua_ChiTietThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ChiTietThongTinLayout.createSequentialGroup()
                                .addComponent(trangChua_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_TienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }

    public void thietLap_TrangChuaButtonXacNhan(){

        button_XacNhan.setText("Xác Nhận");
        button_XacNhan.setBackground(xanhBrandeis);
        button_XacNhan.setForeground(Color.WHITE);
        button_XacNhan.setFont(new Font("Arial", Font.BOLD, 14));

        javax.swing.GroupLayout trangChua_NutXacNhanLayout = new javax.swing.GroupLayout(trangChua_NutXacNhan);
        trangChua_NutXacNhan.setLayout(trangChua_NutXacNhanLayout);
        trangChua_NutXacNhanLayout.setHorizontalGroup(
                trangChua_NutXacNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_NutXacNhanLayout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(button_XacNhan, 210, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChua_NutXacNhanLayout.setVerticalGroup(
                trangChua_NutXacNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_NutXacNhanLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(button_XacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

    public void thietLap_TrangGiaoDienChiTietHoaDon(){
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(trangChua_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trangChua_DanhSachVe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trangChua_ChiTietThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trangChua_NutXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(trangChua_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_DanhSachVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_ChiTietThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_NutXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(35, Short.MAX_VALUE))
        );
        pack();
    }

    public void dayCacDuLieuVeVaoTrongTable(){
        String maHoaDon = ChiTietHoaDon_DAO.layMaHoaDonDuaVao_MaVe(this.maVe);
        this.hoaDon = HoaDon_DAO.layHoaDonDuaVao_MaHoaDon(maHoaDon);

        ArrayList<Ve> danhSachVe = ChiTietHoaDon_DAO.layDanhSachVeTau_MaHoaDon(maHoaDon);
        this.model.setRowCount(0);
        int stt = 0;
        for (Ve ve: danhSachVe) {
            if(ve.getMaVe().compareToIgnoreCase(this.maVe) != 0){
                Object[] objects = {++stt+"",ve.getMaVe(), ve.getGiaVe()};
                this.model.addRow(objects);
                logger.info(ve.getMaVe());
            }
        }
        tinhTongTien();
    }
    public void tinhTongTien(){
       // double tongTien = this.hoaDon.getTongTien();
        double tongTien = this.hoaDon.getThanhTien() - this.ve.getGiaVe();
        double thanhTien = 0;
        logger.info("Giá vé lúc đầu: "+ this.ve.getGiaVe());
        double tienPhat = 0;
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime ngayKhoiHanh = this.ve.getNgayKhoiHanh();
        Duration duration = Duration.between(current, ngayKhoiHanh);
        if(duration.toHours() > 24){
            tienPhat = this.ve.getGiaVe() * 0.1;
        }
        else{
            tienPhat = this.ve.getGiaVe() * 0.25;
        }

        Locale vietnam = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnam);

        thanhTien = this.tongTienSauKhuyenMai(tongTien);
        logger.info(tienPhat+"");
        thanhTien += tienPhat;

        this.hoaDon.setTongTien(tongTien);
        this.hoaDon.setThanhTien(thanhTien);
        this.hoaDon.setTrangThai("Chưa In");
        this.hoaDon.setNgayLapHoaDon(LocalDate.from(LocalDateTime.now()));

        this.textField_TongTiien.setText(currencyFormatter.format(thanhTien));
        this.textField_TienKhachTra.setText(currencyFormatter.format(this.ve.getGiaVe() - tienPhat));
    }

    public double tongTienSauKhuyenMai(double tongTien){
        int soLuongVeHienTai = this.model.getRowCount();
        this.hoaDon.setSoLuong(soLuongVeHienTai);
        this.textField_SoLuong.setText(soLuongVeHienTai+"");
        double tienKhuyenMai = 0;
        if(soLuongVeHienTai < 4){
            tienKhuyenMai = 0;
            this.hoaDon.setDaiNgo(DaiNgo.KhongDaiNgo);
        }else if(soLuongVeHienTai >= 4 && soLuongVeHienTai < 10){
            tienKhuyenMai = DaiNgo.GIAMGIANAMPHANTRAM.getValue();
            this.hoaDon.setDaiNgo(DaiNgo.GIAMGIANAMPHANTRAM);
        }else if(soLuongVeHienTai >= 10 && soLuongVeHienTai < 15){
            tienKhuyenMai = DaiNgo.GIAMGIAMUOIPHANTRAM.getValue();
            this.hoaDon.setDaiNgo(DaiNgo.GIAMGIAMUOIPHANTRAM);
        }else if(soLuongVeHienTai >= 15){
            tienKhuyenMai = DaiNgo.GIAMGIAHAIMUOIPHANTRAM.getValue();
            this.hoaDon.setDaiNgo(DaiNgo.GIAMGIAHAIMUOIPHANTRAM);
        }
        logger.info(tienKhuyenMai+"");
        return  tongTien + (tongTien * tienKhuyenMai);
    }
    public void caiDatEnableCacThanhTextField(){
        this.textField_SoLuong.setEditable(false);
        this.textField_TienKhachTra.setEditable(false);
        this.textField_TongTiien.setEditable(false);
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void capNhatHoaDon(){
        logger.info("Mã Vé: " +this.maVe );
        ChiTietHoaDon_DAO.xoaChiTietHoaDon(this.maVe, this.hoaDon.getMaHoaDon());

        logger.info("Hóa Đơn: " + this.hoaDon.getMaHoaDon());
        HoaDon_DAO.capNhatHoaDon(this.hoaDon);
        this.trangDanhSachVeTau.xacNhan = true;
        logger.info(trangDanhSachVeTau.xacNhan+"");
        if(this.trangDanhSachVeTau.xacNhan){
            // JOptionPane.showMessageDialog(null, "Hủy Vé Thành Công!");
            Ve_DAO.xoaVe(maVe);
            int location = this.trangDanhSachVeTau.table.getSelectedRow();
            logger.info(location+"");
            this.trangDanhSachVeTau.model.removeRow(location);
            this.trangDanhSachVeTau.lamMoiCacThanh();
            this.trangDanhSachVeTau.xacNhan = false;
        }
    }

    public void dongGiaoDien(){
        this.setVisible(false);
    }
}
