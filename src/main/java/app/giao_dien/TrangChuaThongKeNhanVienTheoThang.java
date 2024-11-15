package app.giao_dien;



import app.dao.HoaDon_DAO;
import app.dao.NhanVien_DAO;
import app.dieu_khien.HanhDong_TrangThongKeNhanVienTheoThang;
import app.phan_tu_tuy_chinh.BieuDoCot;
import app.phan_tu_tuy_chinh.CustomCellRenderer;
import app.phan_tu_tuy_chinh.CustomHeaderRenderer;
import app.phong_chu_moi.PhongChuMoi;
import app.thuc_the.NhanVien;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class TrangChuaThongKeNhanVienTheoThang extends JPanel {
    public  JButton buttonThongKe;
    public  JButton buttonThongKeDoanhThu;
    public  JButton buttonThongKeTheoNamNhanVien;
    public  JComboBox<String> danhSachNam;
    public  JComboBox<String> danhSachThang;
    public  JLabel labelChuThich;
    public  JLabel labelDoanhThu;
    public  JLabel labelGioiTinh;
    public  JLabel labelMa;
    public  JLabel labelNam;
    public  JLabel labelNgaySinh;
    public  JLabel labelNhanVienUuTu;
    public  JLabel labelSoDienThoai;
    public  JLabel labelTen;
    public  JLabel labelThang;
    public  JLabel labelThongKe;
    public  JPanel mauChuThich;
    public  JScrollPane scrollPane;
    public  JTable tableDoanhThu;
    public  JLabel textFieldChuThich;
    public  JTextField textFieldDoanhThuNhanVien;
    public  JTextField textFieldGioiTinhNhanVien;
    public  JTextField textFieldMaNhanVien;
    public  JTextField textFieldNgaySinhNhanVien;
    public  JTextField textFieldSoDienThoaiNhanVien;
    public  JTextField textFieldTenNhanVien;
    public  JPanel trangChuaBieuDoCot;
    public  JPanel trangChuaCacNutLoc;
    public  JPanel trangChuaCacThongTinThongKe;
    public  JPanel trangChuaChiTietThongTin;
    public  JPanel trangChuaChuThich;
    public  JPanel trangChuaGioiTinhNhanVien;
    public  JPanel trangChuaMaNhanVien;
    public  JPanel trangChuaNgaySinhNhanVien;
    public  JPanel trangChuaNoiDungChuThich;
    public  JPanel trangChuaNutChonNam;
    public  JPanel trangChuaNutChonThang;
    public  JPanel trangChuaNutChuyenDoiTrang;
    public  JPanel trangChuaSoDienThoaiNhanVien;
    public  JPanel trangChuaTenNhanVien;
    public  JPanel trangChuaThongCuoiCuaNhanVien;
    public  JPanel trangChuaThongDauCuaNhanVien;
    public  JPanel trangChuaThongKe;
    public  JPanel trangChuaThongTinNhanVien;
    public  JPanel trangChuaThongTinNhanVienUuTu;
    public  JPanel trangChuaThongTinThongKe;
    public  JPanel trangChuaTongDoanhThu;
    public  JPanel trangChuaTongDoanhThuNhanVien;
    public TrangDinhHuong  trangDinhHuong;

    public DefaultComboBoxModel<String> model_DanhSachCacThang;
    public DefaultComboBoxModel<String> model_DanhSachCacNam;
    public DefaultTableModel model_DoanhThu;
    public Color xanhBrandeis = new Color(0, 112, 255);
    public  Color trang = new Color(255, 255, 255);

    ActionListener ac ;
    MouseListener mouse ;
    public BieuDoCot bieuDoCot;
    public TrangChuaThongKeNhanVienTheoThang(TrangDinhHuong mainFrame){
        trangChuaThongTinNhanVien = new JPanel();
        trangChuaCacThongTinThongKe = new  JPanel();
        trangChuaCacNutLoc = new  JPanel();
        trangChuaNutChonThang = new  JPanel();
        labelThang = new  JLabel();
        danhSachThang = new  JComboBox<>();
        trangChuaNutChonNam = new  JPanel();
        labelNam = new  JLabel();
        danhSachNam = new  JComboBox<>();
        buttonThongKe = new  JButton();
        trangChuaTongDoanhThu = new  JPanel();
        scrollPane = new  JScrollPane();
        tableDoanhThu = new  JTable();
        trangChuaThongTinNhanVienUuTu = new  JPanel();
        trangChuaChiTietThongTin = new  JPanel();
        labelNhanVienUuTu = new  JLabel();
        trangChuaThongDauCuaNhanVien = new  JPanel();
        trangChuaMaNhanVien = new  JPanel();
        labelMa = new  JLabel();
        textFieldMaNhanVien = new  JTextField();
        trangChuaTenNhanVien = new  JPanel();
        labelTen = new  JLabel();
        textFieldTenNhanVien = new  JTextField();
        trangChuaNgaySinhNhanVien = new  JPanel();
        labelNgaySinh = new  JLabel();
        textFieldNgaySinhNhanVien = new  JTextField();
        trangChuaThongCuoiCuaNhanVien = new  JPanel();
        trangChuaSoDienThoaiNhanVien = new  JPanel();
        labelSoDienThoai = new  JLabel();
        textFieldSoDienThoaiNhanVien = new  JTextField();
        trangChuaGioiTinhNhanVien = new  JPanel();
        labelGioiTinh = new  JLabel();
        textFieldGioiTinhNhanVien = new  JTextField();
        trangChuaTongDoanhThuNhanVien = new  JPanel();
        labelDoanhThu = new  JLabel();
        textFieldDoanhThuNhanVien = new  JTextField();
        trangChuaThongTinThongKe = new  JPanel();
        trangChuaThongKe = new  JPanel();
        labelThongKe = new  JLabel();
        trangChuaBieuDoCot = new  JPanel();
        trangChuaChuThich = new  JPanel();
        labelChuThich = new  JLabel();
        trangChuaNoiDungChuThich = new  JPanel();
        mauChuThich = new  JPanel();
        textFieldChuThich = new  JLabel();
        trangChuaNutChuyenDoiTrang = new  JPanel();
        buttonThongKeDoanhThu = new  JButton();
        buttonThongKeTheoNamNhanVien = new  JButton();
        model_DanhSachCacThang = new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
        model_DanhSachCacNam = new DefaultComboBoxModel<>();
        model_DoanhThu = new DefaultTableModel(new Object[]{"Tháng", "Năm", "  Tổng Doanh Thu"}, 0){
            @Override
            public boolean isCellEditable(int data, int columnName) {
                return false;
            }
        };
        this.trangDinhHuong = mainFrame;
       // this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);

        // thiết lập trang chứa nút chọn tháng
        this. thietLap_TrangChuaNutChonThang();

        // thiết lập trang chứa nút chọn năm
        this. thietLap_TrangChuaNutChonNam();

        // thiết lập trang chứa các nút chọn lọc
        this. thietLap_TrangChuaCacNutLoc();

        // thiết lập trang chứa tổng doanh thu
        this. thietLap_TrangChuaTongDoanhThu();

        // thiết lập trang chứa các thông tin thống kê
        this. thietLap_TrangChuaCacThongTinThongKe();

        // thiết lập trang chứa mã nhân viên
        this.thietLap_trangChuaMaNhanVien();

        // thiết lập trang chứa tên nhân viên
        this.thietLap_TrangChuaTenNhanVien();

        // thiết lập trang chứa ngày sinh nhân viên
        this.thietLap_TrangChuaNgaySinhNhanVien();

        // thiết lập trang chứa thông tin đầu của nhân viên
        this.thietLap_TrangChuaThongTinDauCuaNhanVien();

        // thiết lập trang chứa thông tin số điện thoại của nhân viên
        this.thietLap_TrangChuaSoDienThoaiNhanVien();

        // thiết lập trang chứa thông tin về giới tính của nhân viên
        this.thietLap_TrangChuaGioiTinhNhanVien();

        // thiết lập trang chứa doamh thu của nhân viên
        this.thietLap_TrangChuaDoanhThuNhanVien();

        // thiết lập trang chứ thông tin cuối của nhân viên
        this.thietLap_TrangChuaThongTinCuoiCuaNhanVien();

        // thiết lập trang chứa chi tiết thông tin
        this.thietLap_TrangChuaChiTietThongTin();

        // thiết lập trang chứa thông tin nhân viên ưu tú
        this.thietLap_TrangChuaThongTinNhanVienUuTu();

        // thiết lập trang chứ thông tin nhân  viên
        this.thietLap_TrangChuaThongTinNhanVien();

        // thiết lập trang chứa thống kê
        this.thietLap_TrangChuaThongKe();

        // thiết lập trang chứa chú thích
        this.thietLap_TrangChuaChuThich();

        // thiết lập trang chứa nút chuyển trang
        this.thietLap_TrangChuaNutChuyenTrang();

        // liết lập trang chứa thông tin thống ke
        this.thietLap_TrangChuaThongTinThongKe();
        
        // gom tất cả các giao diện vào trong giao diện này
        this.thietLap_TrangChuaThongKeNhanVienTheoThang();

        dayCacNamLenGiaoDien();
        tinhTongDoanhThu();
        timNhanVienUuTu();
        taoBieuDoCotThongKeDoanhThu();

        ac = new HanhDong_TrangThongKeNhanVienTheoThang(this);
        mouse = new HanhDong_TrangThongKeNhanVienTheoThang(this);
        this.buttonThongKeDoanhThu.addActionListener(ac);
        this.buttonThongKeTheoNamNhanVien.addActionListener(ac);
        this.buttonThongKe.addActionListener(ac);
    }


    public void  thietLap_TrangChuaNutChonThang(){
        labelThang.setText("Tháng");

        danhSachThang.setModel(model_DanhSachCacThang);

        javax.swing.GroupLayout trangChuaNutChonThangLayout = new javax.swing.GroupLayout(trangChuaNutChonThang);
        trangChuaNutChonThang.setLayout(trangChuaNutChonThangLayout);
        trangChuaNutChonThangLayout.setHorizontalGroup(
                trangChuaNutChonThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNutChonThangLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(labelThang, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaNutChonThangLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(danhSachThang, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaNutChonThangLayout.setVerticalGroup(
                trangChuaNutChonThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNutChonThangLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelThang, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(danhSachThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    public void  thietLap_TrangChuaNutChonNam(){
        labelNam.setText("Năm");

        danhSachNam.setModel(model_DanhSachCacNam);

        javax.swing.GroupLayout trangChuaNutChonNamLayout = new javax.swing.GroupLayout(trangChuaNutChonNam);
        trangChuaNutChonNam.setLayout(trangChuaNutChonNamLayout);
        trangChuaNutChonNamLayout.setHorizontalGroup(
                trangChuaNutChonNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNutChonNamLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(labelNam, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaNutChonNamLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(danhSachNam, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaNutChonNamLayout.setVerticalGroup(
                trangChuaNutChonNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNutChonNamLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelNam, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(danhSachNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }

    public void  thietLap_TrangChuaCacNutLoc(){
        buttonThongKe.setText("Thống Kê");
        buttonThongKe.setForeground(this.trang);
        buttonThongKe.setBackground(this.xanhBrandeis);
        buttonThongKe.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 14));

        javax.swing.GroupLayout trangChuaCacNutLocLayout = new javax.swing.GroupLayout(trangChuaCacNutLoc);
        trangChuaCacNutLoc.setLayout(trangChuaCacNutLocLayout);
        trangChuaCacNutLocLayout.setHorizontalGroup(
                trangChuaCacNutLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaCacNutLocLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(trangChuaNutChonThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChuaNutChonNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(buttonThongKe, 100, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
        );
        trangChuaCacNutLocLayout.setVerticalGroup(
                trangChuaCacNutLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(trangChuaNutChonNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(trangChuaCacNutLocLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(buttonThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE))
                        .addComponent(trangChuaNutChonThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    public void  thietLap_TrangChuaTongDoanhThu(){
        tableDoanhThu.setModel(model_DoanhThu);
        tableDoanhThu.getTableHeader().setReorderingAllowed(false);
        tableDoanhThu.setRowHeight(20);
        tableDoanhThu.setFont((new PhongChuMoi()).layPhongRobotoMonoReg(Font.PLAIN, 12));
        // Cấu hình renderer cho phần header
        JTableHeader header = tableDoanhThu.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        header.setDefaultRenderer(new CustomHeaderRenderer()); // Sử dụng renderer tùy chỉnh
//        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
//        renderer.setHorizontalAlignment(SwingConstants.CENTER);

// Cấu hình renderer cho các ô trong bảng
        tableDoanhThu.setDefaultRenderer(Object.class, new CustomCellRenderer());
        scrollPane.setViewportView(tableDoanhThu);
        scrollPane.setBorder(BorderFactory.createLineBorder(this.xanhBrandeis));


        javax.swing.GroupLayout trangChuaTongDoanhThuLayout = new javax.swing.GroupLayout(trangChuaTongDoanhThu);
        trangChuaTongDoanhThu.setLayout(trangChuaTongDoanhThuLayout);
        trangChuaTongDoanhThuLayout.setHorizontalGroup(
                trangChuaTongDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaTongDoanhThuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        trangChuaTongDoanhThuLayout.setVerticalGroup(
                trangChuaTongDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaTongDoanhThuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    public void  thietLap_TrangChuaCacThongTinThongKe(){
        javax.swing.GroupLayout trangChuaCacThongTinThongKeLayout = new javax.swing.GroupLayout(trangChuaCacThongTinThongKe);
        trangChuaCacThongTinThongKe.setLayout(trangChuaCacThongTinThongKeLayout);
        trangChuaCacThongTinThongKeLayout.setHorizontalGroup(
                trangChuaCacThongTinThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(trangChuaCacNutLoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trangChuaTongDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        trangChuaCacThongTinThongKeLayout.setVerticalGroup(
                trangChuaCacThongTinThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaCacThongTinThongKeLayout.createSequentialGroup()
                                .addComponent(trangChuaCacNutLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaTongDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    public void  thietLap_trangChuaMaNhanVien(){
        labelMa.setText("Mã Nhân Viên:");

        textFieldMaNhanVien.setText("");
        textFieldMaNhanVien.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldMaNhanVien.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));
        javax.swing.GroupLayout trangChuaMaNhanVienLayout = new javax.swing.GroupLayout(trangChuaMaNhanVien);
        trangChuaMaNhanVien.setLayout(trangChuaMaNhanVienLayout);
        trangChuaMaNhanVienLayout.setHorizontalGroup(
                trangChuaMaNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaMaNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelMa, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaMaNhanVienLayout.setVerticalGroup(
                trangChuaMaNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaMaNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaMaNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelMa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(16, Short.MAX_VALUE))
        );
    }

    public void  thietLap_TrangChuaTenNhanVien(){
        labelTen.setText("Họ Và Tên:");

        textFieldTenNhanVien.setText("");
        textFieldTenNhanVien.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldTenNhanVien.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));

        javax.swing.GroupLayout trangChuaTenNhanVienLayout = new javax.swing.GroupLayout(trangChuaTenNhanVien);
        trangChuaTenNhanVien.setLayout(trangChuaTenNhanVienLayout);
        trangChuaTenNhanVienLayout.setHorizontalGroup(
                trangChuaTenNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaTenNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelTen, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        trangChuaTenNhanVienLayout.setVerticalGroup(
                trangChuaTenNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaTenNhanVienLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(trangChuaTenNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelTen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(18, Short.MAX_VALUE))
        );
    }

    public void thietLap_TrangChuaNgaySinhNhanVien(){
        labelNgaySinh.setText("Ngày Sinh:");

        textFieldNgaySinhNhanVien.setText("");
        textFieldNgaySinhNhanVien.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldNgaySinhNhanVien.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));

        javax.swing.GroupLayout trangChuaNgaySinhNhanVienLayout = new javax.swing.GroupLayout(trangChuaNgaySinhNhanVien);
        trangChuaNgaySinhNhanVien.setLayout(trangChuaNgaySinhNhanVienLayout);
        trangChuaNgaySinhNhanVienLayout.setHorizontalGroup(
                trangChuaNgaySinhNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNgaySinhNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldNgaySinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaNgaySinhNhanVienLayout.setVerticalGroup(
                trangChuaNgaySinhNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNgaySinhNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaNgaySinhNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldNgaySinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(16, Short.MAX_VALUE))
        );
    }

    public void  thietLap_TrangChuaThongTinDauCuaNhanVien(){
        javax.swing.GroupLayout trangChuaThongDauCuaNhanVienLayout = new javax.swing.GroupLayout(trangChuaThongDauCuaNhanVien);
        trangChuaThongDauCuaNhanVien.setLayout(trangChuaThongDauCuaNhanVienLayout);
        trangChuaThongDauCuaNhanVienLayout.setHorizontalGroup(
                trangChuaThongDauCuaNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongDauCuaNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaThongDauCuaNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChuaTenNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaNgaySinhNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        trangChuaThongDauCuaNhanVienLayout.setVerticalGroup(
                trangChuaThongDauCuaNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaThongDauCuaNhanVienLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChuaMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(trangChuaTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaNgaySinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }

    public void thietLap_TrangChuaSoDienThoaiNhanVien(){
        labelSoDienThoai.setText("Số Điện Thoại:");

        textFieldSoDienThoaiNhanVien.setText("");
        textFieldSoDienThoaiNhanVien.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldSoDienThoaiNhanVien.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));

        javax.swing.GroupLayout trangChuaSoDienThoaiNhanVienLayout = new javax.swing.GroupLayout(trangChuaSoDienThoaiNhanVien);
        trangChuaSoDienThoaiNhanVien.setLayout(trangChuaSoDienThoaiNhanVienLayout);
        trangChuaSoDienThoaiNhanVienLayout.setHorizontalGroup(
                trangChuaSoDienThoaiNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaSoDienThoaiNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldSoDienThoaiNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaSoDienThoaiNhanVienLayout.setVerticalGroup(
                trangChuaSoDienThoaiNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaSoDienThoaiNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaSoDienThoaiNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldSoDienThoaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(16, Short.MAX_VALUE))
        );
    }

    public void thietLap_TrangChuaGioiTinhNhanVien(){
        labelGioiTinh.setText("Giới Tính:");

        textFieldGioiTinhNhanVien.setText("");
        textFieldGioiTinhNhanVien.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldGioiTinhNhanVien.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));

        javax.swing.GroupLayout trangChuaGioiTinhNhanVienLayout = new javax.swing.GroupLayout(trangChuaGioiTinhNhanVien);
        trangChuaGioiTinhNhanVien.setLayout(trangChuaGioiTinhNhanVienLayout);
        trangChuaGioiTinhNhanVienLayout.setHorizontalGroup(
                trangChuaGioiTinhNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaGioiTinhNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldGioiTinhNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaGioiTinhNhanVienLayout.setVerticalGroup(
                trangChuaGioiTinhNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaGioiTinhNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaGioiTinhNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldGioiTinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(16, Short.MAX_VALUE))
        );
    }

    public void thietLap_TrangChuaDoanhThuNhanVien(){
        labelDoanhThu.setText("Doanh Thu:");

        textFieldDoanhThuNhanVien.setText("");
        textFieldDoanhThuNhanVien.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldDoanhThuNhanVien.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));

        javax.swing.GroupLayout trangChuaTongDoanhThuNhanVienLayout = new javax.swing.GroupLayout(trangChuaTongDoanhThuNhanVien);
        trangChuaTongDoanhThuNhanVien.setLayout(trangChuaTongDoanhThuNhanVienLayout);
        trangChuaTongDoanhThuNhanVienLayout.setHorizontalGroup(
                trangChuaTongDoanhThuNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaTongDoanhThuNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldDoanhThuNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaTongDoanhThuNhanVienLayout.setVerticalGroup(
                trangChuaTongDoanhThuNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaTongDoanhThuNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaTongDoanhThuNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldDoanhThuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(16, Short.MAX_VALUE))
        );
    }

    public void thietLap_TrangChuaThongTinCuoiCuaNhanVien(){
        javax.swing.GroupLayout trangChuaThongCuoiCuaNhanVienLayout = new javax.swing.GroupLayout(trangChuaThongCuoiCuaNhanVien);
        trangChuaThongCuoiCuaNhanVien.setLayout(trangChuaThongCuoiCuaNhanVienLayout);
        trangChuaThongCuoiCuaNhanVienLayout.setHorizontalGroup(
                trangChuaThongCuoiCuaNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(trangChuaGioiTinhNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trangChuaTongDoanhThuNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trangChuaSoDienThoaiNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        trangChuaThongCuoiCuaNhanVienLayout.setVerticalGroup(
                trangChuaThongCuoiCuaNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaThongCuoiCuaNhanVienLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChuaSoDienThoaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(trangChuaGioiTinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(trangChuaTongDoanhThuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

    }

    public void  thietLap_TrangChuaChiTietThongTin(){
        labelNhanVienUuTu.setText("Nhân Viên Ứu Tú");
        labelNhanVienUuTu.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 15));
        javax.swing.GroupLayout trangChuaChiTietThongTinLayout = new javax.swing.GroupLayout(trangChuaChiTietThongTin);
        trangChuaChiTietThongTin.setLayout(trangChuaChiTietThongTinLayout);
        trangChuaChiTietThongTinLayout.setHorizontalGroup(
                trangChuaChiTietThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaChiTietThongTinLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelNhanVienUuTu, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(trangChuaChiTietThongTinLayout.createSequentialGroup()
                                .addComponent(trangChuaThongDauCuaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaThongCuoiCuaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaChiTietThongTinLayout.setVerticalGroup(
                trangChuaChiTietThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaChiTietThongTinLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelNhanVienUuTu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(trangChuaChiTietThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChuaThongCuoiCuaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaThongDauCuaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaThongTinNhanVienUuTu(){
        javax.swing.GroupLayout trangChuaThongTinNhanVienUuTuLayout = new javax.swing.GroupLayout(trangChuaThongTinNhanVienUuTu);
        trangChuaThongTinNhanVienUuTu.setLayout(trangChuaThongTinNhanVienUuTuLayout);
        trangChuaThongTinNhanVienUuTuLayout.setHorizontalGroup(
                trangChuaThongTinNhanVienUuTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongTinNhanVienUuTuLayout.createSequentialGroup()
                                .addComponent(trangChuaChiTietThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaThongTinNhanVienUuTuLayout.setVerticalGroup(
                trangChuaThongTinNhanVienUuTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongTinNhanVienUuTuLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(trangChuaChiTietThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

    public void  thietLap_TrangChuaThongTinNhanVien(){
        this.trangChuaThongTinNhanVien.setPreferredSize(new java.awt.Dimension(1200, 400));
        javax.swing.GroupLayout trangChuaThongTinNhanVienLayout = new javax.swing.GroupLayout(trangChuaThongTinNhanVien);
        trangChuaThongTinNhanVien.setLayout(trangChuaThongTinNhanVienLayout);
        trangChuaThongTinNhanVienLayout.setHorizontalGroup(
                trangChuaThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongTinNhanVienLayout.createSequentialGroup()
                                .addComponent(trangChuaCacThongTinThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaThongTinNhanVienUuTu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaThongTinNhanVienLayout.setVerticalGroup(
                trangChuaThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaThongTinNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(trangChuaThongTinNhanVienUuTu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaCacThongTinThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaThongKe(){
        labelThongKe.setText("Thống Kê Doanh Thu");
        labelThongKe.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 15));

        javax.swing.GroupLayout trangChuaThongKeLayout = new javax.swing.GroupLayout(trangChuaThongKe);
        trangChuaThongKe.setLayout(trangChuaThongKeLayout);
        trangChuaThongKeLayout.setHorizontalGroup(
                trangChuaThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(trangChuaBieuDoCot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(trangChuaThongKeLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(labelThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaThongKeLayout.setVerticalGroup(
                trangChuaThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongKeLayout.createSequentialGroup()
                                .addComponent(labelThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaBieuDoCot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaChuThich(){
        labelChuThich.setText("Chú Thích Biểu Đồ");
        labelChuThich.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 15));

        mauChuThich.setBackground(Color.BLUE);
        javax.swing.GroupLayout mauChuThichLayout = new javax.swing.GroupLayout(mauChuThich);
        mauChuThich.setLayout(mauChuThichLayout);
        mauChuThichLayout.setHorizontalGroup(
                mauChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 65, Short.MAX_VALUE)
        );
        mauChuThichLayout.setVerticalGroup(
                mauChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 35, Short.MAX_VALUE)
        );

        textFieldChuThich.setText("Doanh Thu Của Nhân Viên Trong Tháng Đã Bán Được");
        textFieldChuThich.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        javax.swing.GroupLayout trangChuaNoiDungChuThichLayout = new javax.swing.GroupLayout(trangChuaNoiDungChuThich);
        trangChuaNoiDungChuThich.setLayout(trangChuaNoiDungChuThichLayout);
        trangChuaNoiDungChuThichLayout.setHorizontalGroup(
                trangChuaNoiDungChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNoiDungChuThichLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(mauChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldChuThich, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaNoiDungChuThichLayout.setVerticalGroup(
                trangChuaNoiDungChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNoiDungChuThichLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textFieldChuThich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(mauChuThich, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );


        javax.swing.GroupLayout trangChuaChuThichLayout = new javax.swing.GroupLayout(trangChuaChuThich);
        trangChuaChuThich.setLayout(trangChuaChuThichLayout);
        trangChuaChuThichLayout.setHorizontalGroup(
                trangChuaChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaChuThichLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(290, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaChuThichLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChuaNoiDungChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        trangChuaChuThichLayout.setVerticalGroup(
                trangChuaChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaChuThichLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(trangChuaNoiDungChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    public void thietLap_TrangChuaNutChuyenTrang(){
        buttonThongKeDoanhThu.setText("<html>&nbsp;&nbsp;&nbsp;Thống Kê<br>Doanh Thu Nhà Ga</html>");
        buttonThongKeDoanhThu.setBackground(this.xanhBrandeis);
        buttonThongKeDoanhThu.setForeground(this.trang);
        buttonThongKeDoanhThu.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 14));
        buttonThongKeTheoNamNhanVien.setText("<html>Thống Kê Doanh Thu  <br> Nhân Viên Theo Năm</html>");
        buttonThongKeTheoNamNhanVien.setBackground(this.xanhBrandeis);
        buttonThongKeTheoNamNhanVien.setForeground(this.trang);
        buttonThongKeTheoNamNhanVien.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 14));

        javax.swing.GroupLayout trangChuaCacNutChuyenTrangLayout = new javax.swing.GroupLayout(trangChuaNutChuyenDoiTrang);
        trangChuaNutChuyenDoiTrang.setLayout(trangChuaCacNutChuyenTrangLayout);
        trangChuaCacNutChuyenTrangLayout.setHorizontalGroup(
                trangChuaCacNutChuyenTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaCacNutChuyenTrangLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(buttonThongKeDoanhThu,180, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20) // 20px gap between buttons
                                .addComponent(buttonThongKeTheoNamNhanVien, 180, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(54, Short.MAX_VALUE))
        );
        trangChuaCacNutChuyenTrangLayout.setVerticalGroup(
                trangChuaCacNutChuyenTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaCacNutChuyenTrangLayout.createSequentialGroup()
                                .addContainerGap(50, Short.MAX_VALUE)
                                .addComponent(buttonThongKeDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                        .addGroup(trangChuaCacNutChuyenTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(trangChuaCacNutChuyenTrangLayout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(buttonThongKeTheoNamNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(39, Short.MAX_VALUE)))
        );
    }
    public void thietLap_TrangChuaThongTinThongKe(){
        javax.swing.GroupLayout trangChuaThongTinThongKeLayout = new javax.swing.GroupLayout(trangChuaThongTinThongKe);
        trangChuaThongTinThongKe.setLayout(trangChuaThongTinThongKeLayout);
        trangChuaThongTinThongKeLayout.setHorizontalGroup(
                trangChuaThongTinThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongTinThongKeLayout.createSequentialGroup()
                                .addComponent(trangChuaThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(trangChuaThongTinThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(trangChuaChuThich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaNutChuyenDoiTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 6, Short.MAX_VALUE))
        );
        trangChuaThongTinThongKeLayout.setVerticalGroup(
                trangChuaThongTinThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(trangChuaThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(trangChuaThongTinThongKeLayout.createSequentialGroup()
                                .addComponent(trangChuaChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaNutChuyenDoiTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 103, Short.MAX_VALUE))
        );
    }
    public void thietLap_TrangChuaThongKeNhanVienTheoThang(){
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        this.setPreferredSize(new java.awt.Dimension(1200, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(trangChuaThongTinNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(trangChuaThongTinThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChuaThongTinNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaThongTinThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // pack();
    }

    public void dayCacNamLenGiaoDien(){
        ArrayList<String> listNam = HoaDon_DAO.layToanBoNamTuHoaDon();
        this.danhSachNam.setSelectedItem(-1);
        for (String nam:listNam) {
            this.model_DanhSachCacNam.addElement(nam);
        }
        this.danhSachNam.setSelectedIndex(this.model_DanhSachCacNam.getSize()-2);
        int currentMonth = LocalDate.now().getMonthValue(); // This returns the current month (1-12)
        danhSachThang.setSelectedItem(String.valueOf(currentMonth));
    }

    public void tinhTongDoanhThu(){
        this.model_DoanhThu.setRowCount(0);
        int thang = Integer.parseInt((String) this.danhSachThang.getSelectedItem());
        int nam = Integer.parseInt((String) this.danhSachNam.getSelectedItem());
        DecimalFormat df = new DecimalFormat("#,###.##");
        double doanhThu = HoaDon_DAO.tongDoanhThuCuaThang_Nam(nam, thang);
        Object[] objects = {thang+"", nam+"",df.format(doanhThu)};
        this.model_DoanhThu.addRow(objects);
        this.tableDoanhThu.isRowSelected(-1);
    }

    public void timNhanVienUuTu(){
        int thang = Integer.parseInt((String) this.danhSachThang.getSelectedItem());
        int nam = Integer.parseInt((String) this.danhSachNam.getSelectedItem());
        Map<String, Double> nhanVienUuTu = HoaDon_DAO.layDoanhThuCuaNhanVienUuTuTheo_Thang_Nam(nam, thang);
        String tenNhanVien = "";
        double doanhThu = 0;
        for (String nhanVien: nhanVienUuTu.keySet()) {
            tenNhanVien = nhanVien;
            doanhThu += nhanVienUuTu.get(nhanVien);
            break;
        }
        DecimalFormat df = new DecimalFormat("#,###.##");
        NhanVien nv = NhanVien_DAO.layNhanVienTheo_TenNhanVien(tenNhanVien);
        if(nv!= null){
            this.textFieldMaNhanVien.setText(nv.getMaNV());
            this.textFieldTenNhanVien.setText(nv.getTenNV());
            this.textFieldNgaySinhNhanVien.setText(nv.getNgaySinh().toString());
            this.textFieldSoDienThoaiNhanVien.setText(nv.getSoDT());
            this.textFieldGioiTinhNhanVien.setText(nv.getGioiTinh().getValue());
            this.textFieldDoanhThuNhanVien.setText(df.format(doanhThu)+"VNĐ");
        }
        else {
            this.textFieldMaNhanVien.setText("");
            this.textFieldTenNhanVien.setText("");
            this.textFieldNgaySinhNhanVien.setText("");
            this.textFieldSoDienThoaiNhanVien.setText("");
            this.textFieldGioiTinhNhanVien.setText("");
            this.textFieldDoanhThuNhanVien.setText("");
        }
    }

    public void taoBieuDoCotThongKeDoanhThu(){
        this.trangChuaBieuDoCot.removeAll();
        int thang = Integer.parseInt((String) this.danhSachThang.getSelectedItem());
        int nam = Integer.parseInt((String) this.danhSachNam.getSelectedItem());
        Map<String, Double> danhSachDoanhThuNhanVien = HoaDon_DAO.layDoanhThuCuaTungNhanVienTheo_Thang_Nam(nam, thang);
        this.bieuDoCot = new BieuDoCot(danhSachDoanhThuNhanVien, TrangChuaThongKeNhanVienTheoThang.class);

        javax.swing.GroupLayout trangChuaBieuDoCotLayout = new javax.swing.GroupLayout(trangChuaBieuDoCot);
        trangChuaBieuDoCot.setLayout(trangChuaBieuDoCotLayout);
        trangChuaBieuDoCotLayout.setHorizontalGroup(
                trangChuaBieuDoCotLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaBieuDoCotLayout.createSequentialGroup()
                                .addComponent(bieuDoCot, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)) // Không có khoảng cách giữa bieuDoCot và cạnh trái
        );
        trangChuaBieuDoCotLayout.setVerticalGroup(
                trangChuaBieuDoCotLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(bieuDoCot, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        this.trangChuaBieuDoCot.revalidate();
        this.trangChuaBieuDoCot.repaint();
    }

}
