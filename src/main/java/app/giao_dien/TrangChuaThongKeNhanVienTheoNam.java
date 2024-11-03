package app.giao_dien;



import app.dao.HoaDon_DAO;
import app.dao.NhanVien_DAO;
import app.dieu_khien.HanhDong_TrangThongKeNhanVienTheoNam;
import app.dieu_khien.HanhDong_TrangThongKeNhanVienTheoThang;
import app.phan_tu_tuy_chinh.BieuDoCot;
import app.phan_tu_tuy_chinh.CustomCellRenderer;
import app.phan_tu_tuy_chinh.CustomHeaderRenderer;
import app.phong_chu_moi.PhongChuMoi;
import app.thuc_the.NhanVien;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

public class TrangChuaThongKeNhanVienTheoNam extends JPanel{
    public  JButton buttonThongKe;
    public  JButton buttonThongKeDoanhThu;
    public JButton buttonThongKeTheoThangCuaNhanVien;
    public  JComboBox<String> danhSachNam;
    public  JScrollPane jScrollPane1;
    public  JTable danhSachNhanVienUuTu;
    public  JLabel labelGioiThieuThongKe;
    public  JLabel labelGioiThieuTop3NhanVienUuTu;
    public  JLabel labelGioiTinh;
    public  JLabel labelMaNhanVien;
    public  JLabel labelNgaySinh;
    public  JLabel labelSoDienThoai;
    public  JLabel labelTenNhanVien;
    public  JLabel labelThongKeTheoNam;
    public  JLabel labelThongTinNhanVien;
    public  JLabel labelTongDoanhThu;
    public  JTable table;
    public  JScrollPane tableDanhSachNhanVienUuTu;
    public  JTextField textFieldDoanhThu;
    public  JTextField textFieldGioiTinhNhanVien;
    public  JTextField textFieldMaNhanVien;
    public  JTextField textFieldNgaySinhNhanVien;
    public  JTextField textFieldSoDienThoai;
    public  JTextField textFieldTenNhanVien;
    public  JPanel trangChuaBangThongKe;
    public  JPanel trangChuaBieuDo;
    public  JPanel trangChuaBieuDoCot;
    public  JPanel trangChuaCacNhanVienUuTu;
    public  JPanel trangChuaCacNutChuyenTrang;
    public  JPanel trangChuaChonNamThongKe;
    public  JPanel trangChuaDoanhThu;
    public  JPanel trangChuaGioiTinh;
    public  JPanel trangChuaMaNhanvien;
    public  JPanel trangChuaNgaySinhNhanVien;
    public  JPanel trangChuaNhanVienUuTu;
    public  JPanel trangChuaPhanCuoiThongTin;
    public  JPanel trangChuaPhanDauThongTin;
    public  JPanel trangChuaSoDienThoaiNhanVien;
    public  JPanel trangChuaTenNhanVien;
    public  JPanel trangChuaThongKe;
    public  JPanel trangChuaThongTin;
    public  JPanel trangChuaThongTinNhanVien;
    public  JPanel trangChuaThongTinThongKe;

    public DefaultComboBoxModel<String> model_DanhSachNam;
    public DefaultTableModel model_DanhSachNhanVienUuTu;
    public DefaultTableModel model_TongDoanhThu;
    public BieuDoCot bieuDoCot;

    public ActionListener ac;
    public MouseListener mouse;
    public TrangDinhHuong trangDinhHuong;
    Logger logger = LoggerFactory.getLogger(TrangChuaThongKeNhanVienTheoNam.class);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public  Color trang = new Color(255, 255, 255);

    public TrangChuaThongKeNhanVienTheoNam(TrangDinhHuong mainFrame){
        this.trangDinhHuong = mainFrame;
        trangChuaThongTin = new JPanel();
        trangChuaThongTinThongKe = new    JPanel();
        trangChuaChonNamThongKe = new    JPanel();
        labelThongKeTheoNam = new    JLabel();
        danhSachNam = new    JComboBox<>();
        buttonThongKe = new    JButton();
        trangChuaBangThongKe = new    JPanel();
        jScrollPane1 = new    JScrollPane();
        table = new    JTable();
        trangChuaNhanVienUuTu = new    JPanel();
        trangChuaThongTinNhanVien = new    JPanel();
        labelThongTinNhanVien = new    JLabel();
        trangChuaPhanDauThongTin = new    JPanel();
        trangChuaMaNhanvien = new    JPanel();
        labelMaNhanVien = new    JLabel();
        textFieldMaNhanVien = new    JTextField();
        trangChuaTenNhanVien = new    JPanel();
        labelTenNhanVien = new    JLabel();
        textFieldTenNhanVien = new    JTextField();
        trangChuaNgaySinhNhanVien = new    JPanel();
        labelNgaySinh = new    JLabel();
        textFieldNgaySinhNhanVien = new    JTextField();
        trangChuaPhanCuoiThongTin = new    JPanel();
        trangChuaSoDienThoaiNhanVien = new    JPanel();
        labelSoDienThoai = new    JLabel();
        textFieldSoDienThoai = new    JTextField();
        trangChuaGioiTinh = new    JPanel();
        labelGioiTinh = new    JLabel();
        textFieldGioiTinhNhanVien = new    JTextField();
        trangChuaDoanhThu = new    JPanel();
        labelTongDoanhThu = new    JLabel();
        textFieldDoanhThu = new    JTextField();
        trangChuaThongKe = new    JPanel();
        trangChuaBieuDo = new    JPanel();
        labelGioiThieuThongKe = new    JLabel();
        trangChuaBieuDoCot = new    JPanel();
        trangChuaCacNhanVienUuTu = new    JPanel();
        labelGioiThieuTop3NhanVienUuTu = new    JLabel();
        tableDanhSachNhanVienUuTu = new    JScrollPane();
        danhSachNhanVienUuTu = new    JTable();
        trangChuaCacNutChuyenTrang = new    JPanel();
        buttonThongKeDoanhThu = new    JButton();
        buttonThongKeTheoThangCuaNhanVien = new    JButton();
        model_DanhSachNam = new DefaultComboBoxModel<>();
        model_DanhSachNhanVienUuTu = new DefaultTableModel(new String [] {
                "STT",  "Họ Và Tên", "Tổng Doanh Thu"}, 0);
        model_TongDoanhThu = new DefaultTableModel(new String [] {"Năm", "Tổng Doanh Thu"}, 0);
        //this.setDefaultCloseOperation(   WindowConstants.EXIT_ON_CLOSE);


        // thiết lập trang chứa thông tin thống kê
        this.thietLap_TrangChuaThongTinThongKe();

        // thiết lập trang chứa thông tin nhân viên
        this.thietLap_TrangChuaThongTinNhanVien();

        // thiết lập trang chứa thông tin nhân viên ưu tú
        this.thietLap_TrangChuaThongTinNhanVienUuTu();

        // thiết lập trang chứa thông tin
        this.thietLap_TrangChuaThongTin();

        // thiết lập trang chứa biểu đồ
        this.thietLap_TrangChuaBieuDo();

        // thiết lập trang chứa các danh sách nhân ưu tú
        this.thietLap_TrangChuaCacNhanVienUuTu();

        // thiết lập trang chứa các nút chuyển trang
        this.thietLap_TrangChuaCacNutChuyenTrang();

        // thiết lập trang chứa trang chứa thống kê
        this.thietLap_TrangChuaThongKe();

        // add toàn bộ các trang chứa vào trang thống kê nhân viên theo năm
        this.thietLap_TrangChuaThongKeNhanVienTheoNam();

        /*
            xử lý dữ liệu
         */
        this.dayDanhSachNam();
        this.tinhTongDoanhThu();
        this.layCacNhanVienUuTu();
        this.taoBieuDoCotThongKeDoanhThuNhanVien();

        this.ac = new HanhDong_TrangThongKeNhanVienTheoNam(this);
        this.mouse = new HanhDong_TrangThongKeNhanVienTheoNam(this);
        this.buttonThongKe.addActionListener(ac);
        this.buttonThongKeDoanhThu.addActionListener(ac);
        this.buttonThongKeTheoThangCuaNhanVien.addActionListener(ac);
        this.danhSachNhanVienUuTu.addMouseListener(mouse);
    }

    public void thietLap_TrangChuaThongTinThongKe(){
        labelThongKeTheoNam.setText("Thống kê theo năm");

        danhSachNam.setModel(model_DanhSachNam);

        buttonThongKe.setText("Thống Kê");
        buttonThongKe.setForeground(this.trang);
        buttonThongKe.setBackground(this.xanhBrandeis);
        buttonThongKe.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 14));

        javax.swing.GroupLayout trangChuaChonNamThongKeLayout = new javax.swing.GroupLayout(trangChuaChonNamThongKe);
        trangChuaChonNamThongKe.setLayout(trangChuaChonNamThongKeLayout);
        trangChuaChonNamThongKeLayout.setHorizontalGroup(
                trangChuaChonNamThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaChonNamThongKeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelThongKeTheoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(danhSachNam, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonThongKe)
                                .addContainerGap(124, Short.MAX_VALUE))
        );
        trangChuaChonNamThongKeLayout.setVerticalGroup(
                trangChuaChonNamThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaChonNamThongKeLayout.createSequentialGroup()
                                .addContainerGap(65, Short.MAX_VALUE)
                                .addGroup(trangChuaChonNamThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelThongKeTheoNam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(danhSachNam, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(buttonThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                                .addContainerGap())
        );

        table.setModel(model_TongDoanhThu);
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(20);
        table.setFont((new PhongChuMoi()).layPhongRobotoMonoReg(Font.PLAIN, 12));
        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        header.setDefaultRenderer(new CustomHeaderRenderer());
        table.setDefaultRenderer(Object.class, new CustomCellRenderer());
        jScrollPane1.setViewportView(table);
        jScrollPane1.setBorder(BorderFactory.createLineBorder(this.xanhBrandeis));

        javax.swing.GroupLayout trangChuaBangThongKeLayout = new javax.swing.GroupLayout(trangChuaBangThongKe);
        trangChuaBangThongKe.setLayout(trangChuaBangThongKeLayout);
        trangChuaBangThongKeLayout.setHorizontalGroup(
                trangChuaBangThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaBangThongKeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        trangChuaBangThongKeLayout.setVerticalGroup(
                trangChuaBangThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaBangThongKeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout trangChuaThongTinThongKeLayout = new javax.swing.GroupLayout(trangChuaThongTinThongKe);
        trangChuaThongTinThongKe.setLayout(trangChuaThongTinThongKeLayout);
        trangChuaThongTinThongKeLayout.setHorizontalGroup(
                trangChuaThongTinThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(trangChuaBangThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(trangChuaThongTinThongKeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(trangChuaChonNamThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaThongTinThongKeLayout.setVerticalGroup(
                trangChuaThongTinThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongTinThongKeLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(trangChuaChonNamThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(trangChuaBangThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    public void thietLap_TrangChuaThongTinNhanVien(){
        labelThongTinNhanVien.setText("Nhân Viên Ứu Tú Của Năm");

        labelMaNhanVien.setText("Mã Nhân Viên:");

        textFieldMaNhanVien.setText("");
        textFieldMaNhanVien.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldMaNhanVien.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));

        javax.swing.GroupLayout trangChuaMaNhanvienLayout = new javax.swing.GroupLayout(trangChuaMaNhanvien);
        trangChuaMaNhanvien.setLayout(trangChuaMaNhanvienLayout);
        trangChuaMaNhanvienLayout.setHorizontalGroup(
                trangChuaMaNhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaMaNhanvienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaMaNhanvienLayout.setVerticalGroup(
                trangChuaMaNhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaMaNhanvienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaMaNhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        labelTenNhanVien.setText("Họ và Tên:");

        textFieldTenNhanVien.setText("");
        textFieldTenNhanVien.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldTenNhanVien.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));

        javax.swing.GroupLayout trangChuaTenNhanVienLayout = new javax.swing.GroupLayout(trangChuaTenNhanVien);
        trangChuaTenNhanVien.setLayout(trangChuaTenNhanVienLayout);
        trangChuaTenNhanVienLayout.setHorizontalGroup(
                trangChuaTenNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaTenNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(66, Short.MAX_VALUE))
        );
        trangChuaTenNhanVienLayout.setVerticalGroup(
                trangChuaTenNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaTenNhanVienLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(trangChuaTenNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        labelNgaySinh.setText("Ngày Sinh");

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
                                .addComponent(textFieldNgaySinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        javax.swing.GroupLayout trangChuaPhanDauThongTinLayout = new javax.swing.GroupLayout(trangChuaPhanDauThongTin);
        trangChuaPhanDauThongTin.setLayout(trangChuaPhanDauThongTinLayout);
        trangChuaPhanDauThongTinLayout.setHorizontalGroup(
                trangChuaPhanDauThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaPhanDauThongTinLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaPhanDauThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChuaTenNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaNgaySinhNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaMaNhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        trangChuaPhanDauThongTinLayout.setVerticalGroup(
                trangChuaPhanDauThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaPhanDauThongTinLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChuaMaNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(trangChuaTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaNgaySinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        labelSoDienThoai.setText("Số Điện Thoại:");

        textFieldSoDienThoai.setText("");
        textFieldSoDienThoai.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldSoDienThoai.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));

        javax.swing.GroupLayout trangChuaSoDienThoaiNhanVienLayout = new javax.swing.GroupLayout(trangChuaSoDienThoaiNhanVien);
        trangChuaSoDienThoaiNhanVien.setLayout(trangChuaSoDienThoaiNhanVienLayout);
        trangChuaSoDienThoaiNhanVienLayout.setHorizontalGroup(
                trangChuaSoDienThoaiNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaSoDienThoaiNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaSoDienThoaiNhanVienLayout.setVerticalGroup(
                trangChuaSoDienThoaiNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaSoDienThoaiNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaSoDienThoaiNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        labelGioiTinh.setText("Giới Tính:");

        textFieldGioiTinhNhanVien.setText("");
        textFieldGioiTinhNhanVien.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldGioiTinhNhanVien.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));

        javax.swing.GroupLayout trangChuaGioiTinhLayout = new javax.swing.GroupLayout(trangChuaGioiTinh);
        trangChuaGioiTinh.setLayout(trangChuaGioiTinhLayout);
        trangChuaGioiTinhLayout.setHorizontalGroup(
                trangChuaGioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaGioiTinhLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldGioiTinhNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaGioiTinhLayout.setVerticalGroup(
                trangChuaGioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaGioiTinhLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaGioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldGioiTinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        labelTongDoanhThu.setText("Tổng Doanh Thu:");

        textFieldDoanhThu.setText("");
        textFieldDoanhThu.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldDoanhThu.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));

        javax.swing.GroupLayout trangChuaDoanhThuLayout = new javax.swing.GroupLayout(trangChuaDoanhThu);
        trangChuaDoanhThu.setLayout(trangChuaDoanhThuLayout);
        trangChuaDoanhThuLayout.setHorizontalGroup(
                trangChuaDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaDoanhThuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaDoanhThuLayout.setVerticalGroup(
                trangChuaDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaDoanhThuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout trangChuaPhanCuoiThongTinLayout = new javax.swing.GroupLayout(trangChuaPhanCuoiThongTin);
        trangChuaPhanCuoiThongTin.setLayout(trangChuaPhanCuoiThongTinLayout);
        trangChuaPhanCuoiThongTinLayout.setHorizontalGroup(
                trangChuaPhanCuoiThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(trangChuaGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trangChuaDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trangChuaSoDienThoaiNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        trangChuaPhanCuoiThongTinLayout.setVerticalGroup(
                trangChuaPhanCuoiThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaPhanCuoiThongTinLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChuaSoDienThoaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(trangChuaGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(trangChuaDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout trangChuaThongTinNhanVienLayout = new javax.swing.GroupLayout(trangChuaThongTinNhanVien);
        trangChuaThongTinNhanVien.setLayout(trangChuaThongTinNhanVienLayout);
        trangChuaThongTinNhanVienLayout.setHorizontalGroup(
                trangChuaThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongTinNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelThongTinNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(trangChuaThongTinNhanVienLayout.createSequentialGroup()
                                .addComponent(trangChuaPhanDauThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaPhanCuoiThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaThongTinNhanVienLayout.setVerticalGroup(
                trangChuaThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongTinNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelThongTinNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(trangChuaThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChuaPhanCuoiThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaPhanDauThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaThongTinNhanVienUuTu(){
        javax.swing.GroupLayout trangChuaNhanVienUuTuLayout = new javax.swing.GroupLayout(trangChuaNhanVienUuTu);
        trangChuaNhanVienUuTu.setLayout(trangChuaNhanVienUuTuLayout);
        trangChuaNhanVienUuTuLayout.setHorizontalGroup(
                trangChuaNhanVienUuTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNhanVienUuTuLayout.createSequentialGroup()
                                .addComponent(trangChuaThongTinNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaNhanVienUuTuLayout.setVerticalGroup(
                trangChuaNhanVienUuTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNhanVienUuTuLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(trangChuaThongTinNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

    }

    public void thietLap_TrangChuaThongTin(){
        this.trangChuaThongTin.setPreferredSize(new java.awt.Dimension(1200, 400));

        javax.swing.GroupLayout trangChuaThongTinLayout = new javax.swing.GroupLayout(trangChuaThongTin);
        trangChuaThongTin.setLayout(trangChuaThongTinLayout);
        trangChuaThongTinLayout.setHorizontalGroup(
                trangChuaThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongTinLayout.createSequentialGroup()
                                .addComponent(trangChuaThongTinThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaNhanVienUuTu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaThongTinLayout.setVerticalGroup(
                trangChuaThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaThongTinLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(trangChuaNhanVienUuTu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaThongTinThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaBieuDo(){
        labelGioiThieuThongKe.setText("Thống Kê Doanh Thu Theo Năm Của Nhân Viên");
        labelGioiThieuThongKe.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 15));


        javax.swing.GroupLayout trangChuaBieuDoLayout = new javax.swing.GroupLayout(trangChuaBieuDo);
        trangChuaBieuDo.setLayout(trangChuaBieuDoLayout);
        trangChuaBieuDoLayout.setHorizontalGroup(
                trangChuaBieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(trangChuaBieuDoCot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(trangChuaBieuDoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelGioiThieuThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaBieuDoLayout.setVerticalGroup(
                trangChuaBieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaBieuDoLayout.createSequentialGroup()
                                .addComponent(labelGioiThieuThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaBieuDoCot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaCacNhanVienUuTu(){
        labelGioiThieuTop3NhanVienUuTu.setText("Top 3 Nhân Viên Bán Vé Nhiều Nhất");
        labelGioiThieuTop3NhanVienUuTu.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 15));

        danhSachNhanVienUuTu.setModel(model_DanhSachNhanVienUuTu);
        danhSachNhanVienUuTu.getTableHeader().setReorderingAllowed(false);
        danhSachNhanVienUuTu.setRowHeight(20);
        danhSachNhanVienUuTu.setFont((new PhongChuMoi()).layPhongRobotoMonoReg(Font.PLAIN, 12));
        JTableHeader header = danhSachNhanVienUuTu.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        header.setDefaultRenderer(new CustomHeaderRenderer());
        danhSachNhanVienUuTu.setDefaultRenderer(Object.class, new CustomCellRenderer());
        tableDanhSachNhanVienUuTu.setViewportView(danhSachNhanVienUuTu);
        tableDanhSachNhanVienUuTu.setBorder(BorderFactory.createLineBorder(this.xanhBrandeis));

        javax.swing.GroupLayout trangChuaCacNhanVienUuTuLayout = new javax.swing.GroupLayout(trangChuaCacNhanVienUuTu);
        trangChuaCacNhanVienUuTu.setLayout(trangChuaCacNhanVienUuTuLayout);
        trangChuaCacNhanVienUuTuLayout.setHorizontalGroup(
                trangChuaCacNhanVienUuTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaCacNhanVienUuTuLayout.createSequentialGroup()
                                .addContainerGap(143, Short.MAX_VALUE)
                                .addComponent(labelGioiThieuTop3NhanVienUuTu, 300, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(129, 129, 129))
                        .addGroup(trangChuaCacNhanVienUuTuLayout.createSequentialGroup()
                                .addContainerGap() // Khoảng cách mặc định
                                //.addGap(100) // Khoảng cách thêm vào để dịch table sang phải
                                .addComponent(tableDanhSachNhanVienUuTu, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaCacNhanVienUuTuLayout.setVerticalGroup(
                trangChuaCacNhanVienUuTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaCacNhanVienUuTuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelGioiThieuTop3NhanVienUuTu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tableDanhSachNhanVienUuTu, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    public void thietLap_TrangChuaCacNutChuyenTrang(){
        buttonThongKeDoanhThu.setText("<html> Thống Kê <br> Doanh Thu </html>");
        buttonThongKeDoanhThu.setBackground(this.xanhBrandeis);
        buttonThongKeDoanhThu.setForeground(this.trang);
        buttonThongKeDoanhThu.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 14));

        buttonThongKeTheoThangCuaNhanVien.setText("<html>Thống Kê Theo Tháng  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Nhân Viên </html>");
        buttonThongKeTheoThangCuaNhanVien.setBackground(this.xanhBrandeis);
        buttonThongKeTheoThangCuaNhanVien.setForeground(this.trang);
        buttonThongKeTheoThangCuaNhanVien.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 14));

        javax.swing.GroupLayout trangChuaCacNutChuyenTrangLayout = new javax.swing.GroupLayout(trangChuaCacNutChuyenTrang);
        trangChuaCacNutChuyenTrang.setLayout(trangChuaCacNutChuyenTrangLayout);
        trangChuaCacNutChuyenTrangLayout.setHorizontalGroup(
                trangChuaCacNutChuyenTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaCacNutChuyenTrangLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(buttonThongKeDoanhThu,180, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20) // 20px gap between buttons
                                .addComponent(buttonThongKeTheoThangCuaNhanVien, 180, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(54, Short.MAX_VALUE))
        );
        trangChuaCacNutChuyenTrangLayout.setVerticalGroup(
                trangChuaCacNutChuyenTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaCacNutChuyenTrangLayout.createSequentialGroup()
                                .addContainerGap(50, Short.MAX_VALUE)
                                .addComponent(buttonThongKeTheoThangCuaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                        .addGroup(trangChuaCacNutChuyenTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(trangChuaCacNutChuyenTrangLayout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(buttonThongKeDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(39, Short.MAX_VALUE)))
        );

    }

    public void thietLap_TrangChuaThongKe(){
        javax.swing.GroupLayout trangChuaThongKeLayout = new javax.swing.GroupLayout(trangChuaThongKe);
        trangChuaThongKe.setLayout(trangChuaThongKeLayout);
        trangChuaThongKeLayout.setHorizontalGroup(
                trangChuaThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongKeLayout.createSequentialGroup()
                                .addComponent(trangChuaBieuDo, 900, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(trangChuaThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(trangChuaCacNhanVienUuTu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaCacNutChuyenTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        trangChuaThongKeLayout.setVerticalGroup(
                trangChuaThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(trangChuaBieuDo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(trangChuaThongKeLayout.createSequentialGroup()
                                .addComponent(trangChuaCacNhanVienUuTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(trangChuaCacNutChuyenTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 96, Short.MAX_VALUE))
        );
    }

    public void thietLap_TrangChuaThongKeNhanVienTheoNam(){
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);

// Center components horizontally
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) // Flexible spacing on the left
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(trangChuaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(trangChuaThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) // Flexible spacing on the right
        );

// Center components vertically
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) // Flexible spacing on top
                        .addComponent(trangChuaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trangChuaThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) // Flexible spacing at the bottom
        );

        // pack();
    }

    public void dayDanhSachNam(){
        ArrayList<String> danhSach =  HoaDon_DAO.layToanBoNamTuHoaDon();
        danhSachNam.setSelectedItem(-1);
        for (String nam:danhSach) {
            model_DanhSachNam.addElement(nam);
        }
        danhSachNam.setSelectedIndex(model_DanhSachNam.getSize()-1);
    }

    public void layCacNhanVienUuTu(){
        int nam = Integer.parseInt((String) danhSachNam.getSelectedItem());
        Map<String, Double> danhSachDoanhThu = HoaDon_DAO.layDoanhThuCuaNhanVienUuTuTheo_Nam(nam);
        DecimalFormat df = new DecimalFormat("#,###.##");
        this.model_DanhSachNhanVienUuTu.setRowCount(0);
        int stt = 1;
        for (String i : danhSachDoanhThu.keySet()) {
            Double doanhThu = danhSachDoanhThu.get(i); // Lấy giá trị từ bản đồ
            // Kiểm tra nếu giá trị không null
            if (doanhThu != null) {
                Object[] objects = {stt+"", i, df.format(doanhThu)+" VNĐ"};
                // Giới hạn độ dài và thêm dấu ba chấm
                this.model_DanhSachNhanVienUuTu.addRow(objects);
            }
            stt+=1;
        }
    }
    public void taoBieuDoCotThongKeDoanhThuNhanVien(){
        this.trangChuaBieuDoCot.removeAll();
        int nam = Integer.parseInt((String) danhSachNam.getSelectedItem());
        Map<String, Double> danhSachDoanhThu = HoaDon_DAO.layDoanhThuCuaTungNhanVienTheo_Nam(nam);
        bieuDoCot = new BieuDoCot(danhSachDoanhThu);


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
                        .addComponent(bieuDoCot, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        this.trangChuaBieuDoCot.revalidate();
        this.trangChuaBieuDoCot.repaint();
    }

    public void tinhTongDoanhThu(){
        int nam = Integer.parseInt((String) danhSachNam.getSelectedItem());
        DecimalFormat df = new DecimalFormat("#,###.##");
        double doanhThu = HoaDon_DAO.tongDoanhThuCuaNam(nam);
        this.model_TongDoanhThu.setRowCount(0);
        Object[] objects = {nam+"",df.format(doanhThu)+" VNĐ"};
        this.model_TongDoanhThu.addRow(objects);

    }

    public void xacDinhNhanVienDuocChon(int index){
        String tenNhanVien = (String) this.model_DanhSachNhanVienUuTu.getValueAt(index, 1);
        String doanhThu = (String) this.model_DanhSachNhanVienUuTu.getValueAt(index, 2);
        NhanVien nv = NhanVien_DAO.layNhanVienTheo_TenNhanVien(tenNhanVien);
        this.textFieldMaNhanVien.setText(nv.getMaNV());
        this.textFieldTenNhanVien.setText(nv.getTenNV());
        this.textFieldNgaySinhNhanVien.setText(nv.getNgaySinh().toString());
        this.textFieldSoDienThoai.setText(nv.getSoDT());
        this.textFieldGioiTinhNhanVien.setText(nv.getGioiTinh().getValue());
        this.textFieldDoanhThu.setText(doanhThu);
    }
}
