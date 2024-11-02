package app.giao_dien;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TrangChuaThongKeNhanVienTheoNam extends JPanel{
    private  JButton buttonThongKe;
    private  JButton buttonThongKeDoanhThu;
    private JButton buttonThongKeTheoThangCuaNhanVien;
    private  JComboBox<String> danhSachNam;
    private  JScrollPane jScrollPane1;
    private  JTable jTable2;
    private  JLabel labelGioiThieuThongKe;
    private  JLabel labelGioiThieuTop3NhanVienUuTu;
    private  JLabel labelGioiTinh;
    private  JLabel labelMaNhanVien;
    private  JLabel labelNgaySinh;
    private  JLabel labelSoDienThoai;
    private  JLabel labelTenNhanVien;
    private  JLabel labelThongKeTheoNam;
    private  JLabel labelThongTinNhanVien;
    private  JLabel labelTongDoanhThu;
    private  JTable table;
    private  JScrollPane tableDanhSachNhanVienUuTu;
    private  JTextField textFieldDoanhThu;
    private  JTextField textFieldGioiTinhNhanVien;
    private  JTextField textFieldMaNhanVien;
    private  JTextField textFieldNgaySinhNhanVien;
    private  JTextField textFieldSoDienThoai;
    private  JTextField textFieldTenNhanVien;
    private  JPanel trangChuaBangThongKe;
    private  JPanel trangChuaBieuDo;
    private  JPanel trangChuaBieuDoCot;
    private  JPanel trangChuaCacNhanVienUuTu;
    private  JPanel trangChuaCacNutChuyenTrang;
    private  JPanel trangChuaChonNamThongKe;
    private  JPanel trangChuaDoanhThu;
    private  JPanel trangChuaGioiTinh;
    private  JPanel trangChuaMaNhanvien;
    private  JPanel trangChuaNgaySinhNhanVien;
    private  JPanel trangChuaNhanVienUuTu;
    private  JPanel trangChuaPhanCuoiThongTin;
    private  JPanel trangChuaPhanDauThongTin;
    private  JPanel trangChuaSoDienThoaiNhanVien;
    private  JPanel trangChuaTenNhanVien;
    private  JPanel trangChuaThongKe;
    private  JPanel trangChuaThongTin;
    private  JPanel trangChuaThongTinNhanVien;
    private  JPanel trangChuaThongTinThongKe;

    public TrangChuaThongKeNhanVienTheoNam(){
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
        jTable2 = new    JTable();
        trangChuaCacNutChuyenTrang = new    JPanel();
        buttonThongKeDoanhThu = new    JButton();
        buttonThongKeTheoThangCuaNhanVien = new    JButton();

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
    }

    public void thietLap_TrangChuaThongTinThongKe(){
        labelThongKeTheoNam.setText("Thống kê theo năm");

        danhSachNam.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonThongKe.setText("Thống Kê");

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

        table.setModel(new DefaultTableModel(
                new Object [][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String [] {
                        "Năm", "Tổng Doanh Thu"
                }
        ));
        jScrollPane1.setViewportView(table);

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

    private void thietLap_TrangChuaThongTinNhanVien(){
        labelThongTinNhanVien.setText("Nhân Viên Ứu Tú Của Năm");

        labelMaNhanVien.setText("Mã Nhân Viên:");

        textFieldMaNhanVien.setText("22674201");

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

        textFieldTenNhanVien.setText("Phạm Văn Hinh");

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

        textFieldNgaySinhNhanVien.setText("20/10/2004");

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

        textFieldSoDienThoai.setText("0969880914");

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

        textFieldGioiTinhNhanVien.setText("Nam");

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

        textFieldDoanhThu.setText("10000000VNĐ");

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

    private void thietLap_TrangChuaThongTinNhanVienUuTu(){
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

    private void thietLap_TrangChuaThongTin(){
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

    private void thietLap_TrangChuaBieuDo(){
        labelGioiThieuThongKe.setText("Thống Kê Doanh Thu Theo Năm Của Nhân Viên");

        javax.swing.GroupLayout trangChuaBieuDoCotLayout = new javax.swing.GroupLayout(trangChuaBieuDoCot);
        trangChuaBieuDoCot.setLayout(trangChuaBieuDoCotLayout);
        trangChuaBieuDoCotLayout.setHorizontalGroup(
                trangChuaBieuDoCotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 741, Short.MAX_VALUE)
        );
        trangChuaBieuDoCotLayout.setVerticalGroup(
                trangChuaBieuDoCotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

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

    private void thietLap_TrangChuaCacNhanVienUuTu(){
        labelGioiThieuTop3NhanVienUuTu.setText("Top 3 Nhân Viên Bán Vé Nhiều Nhất");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "STT", "Mã Nhân Viên", "Họ Và Tên", "Tổng Doanh Thu"
                }
        ));
        tableDanhSachNhanVienUuTu.setViewportView(jTable2);

        javax.swing.GroupLayout trangChuaCacNhanVienUuTuLayout = new javax.swing.GroupLayout(trangChuaCacNhanVienUuTu);
        trangChuaCacNhanVienUuTu.setLayout(trangChuaCacNhanVienUuTuLayout);
        trangChuaCacNhanVienUuTuLayout.setHorizontalGroup(
                trangChuaCacNhanVienUuTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaCacNhanVienUuTuLayout.createSequentialGroup()
                                .addContainerGap(143, Short.MAX_VALUE)
                                .addComponent(labelGioiThieuTop3NhanVienUuTu, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(129, 129, 129))
                        .addGroup(trangChuaCacNhanVienUuTuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tableDanhSachNhanVienUuTu, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaCacNhanVienUuTuLayout.setVerticalGroup(
                trangChuaCacNhanVienUuTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaCacNhanVienUuTuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelGioiThieuTop3NhanVienUuTu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tableDanhSachNhanVienUuTu, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

    private void thietLap_TrangChuaCacNutChuyenTrang(){
        buttonThongKeDoanhThu.setText("Thống Kê Doanh Thu");

        buttonThongKeTheoThangCuaNhanVien.setText("Thống Kê Theo Tháng Của Nhân Viên");

        javax.swing.GroupLayout trangChuaCacNutChuyenTrangLayout = new javax.swing.GroupLayout(trangChuaCacNutChuyenTrang);
        trangChuaCacNutChuyenTrang.setLayout(trangChuaCacNutChuyenTrangLayout);
        trangChuaCacNutChuyenTrangLayout.setHorizontalGroup(
                trangChuaCacNutChuyenTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaCacNutChuyenTrangLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonThongKeTheoThangCuaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65))
                        .addGroup(trangChuaCacNutChuyenTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(trangChuaCacNutChuyenTrangLayout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addComponent(buttonThongKeDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(254, Short.MAX_VALUE)))
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

    private void thietLap_TrangChuaThongKe(){
        this.trangChuaThongKe.setPreferredSize(new java.awt.Dimension(1200, 400));
        javax.swing.GroupLayout trangChuaThongKeLayout = new javax.swing.GroupLayout(trangChuaThongKe);
        trangChuaThongKe.setLayout(trangChuaThongKeLayout);
        trangChuaThongKeLayout.setHorizontalGroup(
                trangChuaThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongKeLayout.createSequentialGroup()
                                .addComponent(trangChuaBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(trangChuaCacNhanVienUuTu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaCacNutChuyenTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }

    private void thietLap_TrangChuaThongKeNhanVienTheoNam(){
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChuaThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(trangChuaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(trangChuaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        // pack();
    }
//    public static void main(String[] args) {
//        try {
//            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//
//                    // Cấu hình thuộc tính Nimbus
//                    UIManager.put("control", new javax.swing.plaf.ColorUIResource(255, 255, 255)); // Màu nền
//                    UIManager.put("nimbusBase", new javax.swing.plaf.ColorUIResource(255, 255, 255)); // Màu cơ bản
//                    UIManager.put("nimbusBorder", new javax.swing.plaf.ColorUIResource(0, 112, 255)); // Màu viền
//                    UIManager.put("nimbusLightBackground", new javax.swing.plaf.ColorUIResource(255, 255, 255)); // Màu nền sáng
//                    UIManager.put("nimbusFocus", new javax.swing.plaf.ColorUIResource(0, 112, 255)); // Màu focus
//                    UIManager.put("textForeground", new Color(0, 112, 255)); // Màu chữ
//                    UIManager.put("ComboBox.foreground", new Color(0, 112, 255)); // Màu chữ cho JComboBox
//                    UIManager.put("ComboBox.background", new Color(255, 255, 255));
//                    UIManager.put("JCalendar.border", new Color(255, 255, 255));
//
//                    // Đặt màu nền và màu chữ khi chọn cho JTextField
//                    UIManager.put("TextField.selectionBackground", new Color(0, 112, 255)); // Màu nền khi chọn
//                    UIManager.put("TextField.selectionForeground", new Color(255, 255, 255)); // Màu chữ khi chọncho JComboBox
//
//                    break;
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        // Sau đó, khởi chạy giao diện của bạn
//        java.awt.EventQueue.invokeLater(() -> {
//            new TrangChuaThongKeNhanVienTheoNam().setVisible(true);
//        });
//
//    }
}
