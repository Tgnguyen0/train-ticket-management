package app.giao_dien;



import javax.swing.*;
import java.awt.*;

public class TrangChuaThongKeNhanVienTheoThang extends JPanel {
    private  JButton buttonThongKe;
    private  JButton buttonThongKeDoanhThu;
    private  JButton buttonThongKeTheoNamNhanVien;
    private  JComboBox<String> danhSachNam;
    private  JComboBox<String> danhSachThang;
    private  JLabel labelChuThich;
    private  JLabel labelDoanhThu;
    private  JLabel labelGioiTinh;
    private  JLabel labelMa;
    private  JLabel labelNam;
    private  JLabel labelNgaySinh;
    private  JLabel labelNhanVienUuTu;
    private  JLabel labelSoDienThoai;
    private  JLabel labelTen;
    private  JLabel labelThang;
    private  JLabel labelThongKe;
    private  JPanel mauChuThich;
    private  JScrollPane scrollPane;
    private  JTable tableDoanhThu;
    private  JLabel textFieldChuThich;
    private  JTextField textFieldDoanhThuNhanVien;
    private  JTextField textFieldGioiTinhNhanVien;
    private  JTextField textFieldMaNhanVien;
    private  JTextField textFieldNgaySinhNhanVien;
    private  JTextField textFieldSoDienThoaiNhanVien;
    private  JTextField textFieldTenNhanVien;
    private  JPanel trangChuaBieuDoCot;
    private  JPanel trangChuaCacNutLoc;
    private  JPanel trangChuaCacThongTinThongKe;
    private  JPanel trangChuaChiTietThongTin;
    private  JPanel trangChuaChuThich;
    private  JPanel trangChuaGioiTinhNhanVien;
    private  JPanel trangChuaMaNhanVien;
    private  JPanel trangChuaNgaySinhNhanVien;
    private  JPanel trangChuaNoiDungChuThich;
    private  JPanel trangChuaNutChonNam;
    private  JPanel trangChuaNutChonThang;
    private  JPanel trangChuaNutChuyenDoiTrang;
    private  JPanel trangChuaSoDienThoaiNhanVien;
    private  JPanel trangChuaTenNhanVien;
    private  JPanel trangChuaThongCuoiCuaNhanVien;
    private  JPanel trangChuaThongDauCuaNhanVien;
    private  JPanel trangChuaThongKe;
    private  JPanel trangChuaThongTinNhanVien;
    private  JPanel trangChuaThongTinNhanVienUuTu;
    private  JPanel trangChuaThongTinThongKe;
    private  JPanel trangChuaTongDoanhThu;
    private  JPanel trangChuaTongDoanhThuNhanVien;

    public TrangChuaThongKeNhanVienTheoThang(JFrame mainFrame){
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
    }


    private void  thietLap_TrangChuaNutChonThang(){
        labelThang.setText("Tháng");

        danhSachThang.setModel(new  DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

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

    private void  thietLap_TrangChuaNutChonNam(){
        labelNam.setText("Năm");

        danhSachNam.setModel(new  DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

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

    private void  thietLap_TrangChuaCacNutLoc(){
        buttonThongKe.setText("Thống Kê");

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
                                .addComponent(buttonThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void  thietLap_TrangChuaTongDoanhThu(){
        tableDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        scrollPane.setViewportView(tableDoanhThu);

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

    private void  thietLap_TrangChuaCacThongTinThongKe(){
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

    private void  thietLap_trangChuaMaNhanVien(){
        labelMa.setText("Mã Nhân Viên:");

        textFieldMaNhanVien.setText("22674201");

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

    private void  thietLap_TrangChuaTenNhanVien(){
        labelTen.setText("Họ Và Tên:");

        textFieldTenNhanVien.setText("Phạm Văn Hinh");

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

    private void thietLap_TrangChuaNgaySinhNhanVien(){
        labelNgaySinh.setText("Ngày Sinh:");

        textFieldNgaySinhNhanVien.setText("20/10/2004");

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

    private void  thietLap_TrangChuaThongTinDauCuaNhanVien(){
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

    private void thietLap_TrangChuaSoDienThoaiNhanVien(){
        labelSoDienThoai.setText("Số Điện Thoại:");

        textFieldSoDienThoaiNhanVien.setText("0969880914");

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

    private void thietLap_TrangChuaGioiTinhNhanVien(){
        labelGioiTinh.setText("Giới Tính:");

        textFieldGioiTinhNhanVien.setText("Nam");

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

    private void thietLap_TrangChuaDoanhThuNhanVien(){
        labelDoanhThu.setText("Doanh Thu:");

        textFieldDoanhThuNhanVien.setText("100000VNĐ");

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
    private void thietLap_TrangChuaThongTinCuoiCuaNhanVien(){
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
    private void  thietLap_TrangChuaChiTietThongTin(){
        labelNhanVienUuTu.setText("Nhân Viên Ứu Tú");
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

    private void  thietLap_TrangChuaThongTinNhanVien(){
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

    private void thietLap_TrangChuaThongKe(){
        labelThongKe.setText("Thống Kê Doanh Thu");

        javax.swing.GroupLayout trangChuaBieuDoCotLayout = new javax.swing.GroupLayout(trangChuaBieuDoCot);
        trangChuaBieuDoCot.setLayout(trangChuaBieuDoCotLayout);
        trangChuaBieuDoCotLayout.setHorizontalGroup(
                trangChuaBieuDoCotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        trangChuaBieuDoCotLayout.setVerticalGroup(
                trangChuaBieuDoCotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

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

    private void thietLap_TrangChuaChuThich(){
        labelChuThich.setText("Chú Thích Biểu Đồ");

        javax.swing.GroupLayout mauChuThichLayout = new javax.swing.GroupLayout(mauChuThich);
        mauChuThich.setLayout(mauChuThichLayout);
        mauChuThichLayout.setHorizontalGroup(
                mauChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 153, Short.MAX_VALUE)
        );
        mauChuThichLayout.setVerticalGroup(
                mauChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        textFieldChuThich.setText("jLabel12");

        javax.swing.GroupLayout trangChuaNoiDungChuThichLayout = new javax.swing.GroupLayout(trangChuaNoiDungChuThich);
        trangChuaNoiDungChuThich.setLayout(trangChuaNoiDungChuThichLayout);
        trangChuaNoiDungChuThichLayout.setHorizontalGroup(
                trangChuaNoiDungChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNoiDungChuThichLayout.createSequentialGroup()
                                .addComponent(mauChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldChuThich, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaNoiDungChuThichLayout.setVerticalGroup(
                trangChuaNoiDungChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mauChuThich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(trangChuaNoiDungChuThichLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textFieldChuThich, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout trangChuaChuThichLayout = new javax.swing.GroupLayout(trangChuaChuThich);
        trangChuaChuThich.setLayout(trangChuaChuThichLayout);
        trangChuaChuThichLayout.setHorizontalGroup(
                trangChuaChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaChuThichLayout.createSequentialGroup()
                                .addContainerGap(25, Short.MAX_VALUE)
                                .addComponent(trangChuaNoiDungChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(trangChuaChuThichLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaChuThichLayout.setVerticalGroup(
                trangChuaChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaChuThichLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(trangChuaNoiDungChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void thietLap_TrangChuaNutChuyenTrang(){
        buttonThongKeDoanhThu.setText("<html>Thống Kê Doanh Thu <br>        Nhà Ga</html>");
        // căn các chữ của button về giữa
//        buttonThongKeDoanhThu.setHorizontalAlignment(SwingConstants.CENTER);
        buttonThongKeTheoNamNhanVien.setText("<html>Thống Kê Doanh Thu <br>  Nhân Viên Theo Tháng</html>");

        javax.swing.GroupLayout trangChuaNutChuyenDoiTrangLayout = new javax.swing.GroupLayout(trangChuaNutChuyenDoiTrang);
        trangChuaNutChuyenDoiTrang.setLayout(trangChuaNutChuyenDoiTrangLayout);
        trangChuaNutChuyenDoiTrangLayout.setHorizontalGroup(
                trangChuaNutChuyenDoiTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaNutChuyenDoiTrangLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonThongKeTheoNamNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65))
                        .addGroup(trangChuaNutChuyenDoiTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(trangChuaNutChuyenDoiTrangLayout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addComponent(buttonThongKeDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(254, Short.MAX_VALUE)))
        );
        trangChuaNutChuyenDoiTrangLayout.setVerticalGroup(
                trangChuaNutChuyenDoiTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaNutChuyenDoiTrangLayout.createSequentialGroup()
                                .addContainerGap(50, Short.MAX_VALUE)
                                .addComponent(buttonThongKeTheoNamNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                        .addGroup(trangChuaNutChuyenDoiTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(trangChuaNutChuyenDoiTrangLayout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(buttonThongKeDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(39, Short.MAX_VALUE)))
        );
    }
    private void thietLap_TrangChuaThongTinThongKe(){
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
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        trangChuaThongTinThongKeLayout.setVerticalGroup(
                trangChuaThongTinThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(trangChuaThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(trangChuaThongTinThongKeLayout.createSequentialGroup()
                                .addComponent(trangChuaChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addComponent(trangChuaNutChuyenDoiTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

    }

    private void thietLap_TrangChuaThongKeNhanVienTheoThang(){
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
                                .addComponent(trangChuaThongTinThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

// Thực thi lại kích thước cố định cho giao diện
//        this.setMinimumSize(new java.awt.Dimension(1200, 600));
//        this.setMaximumSize(new java.awt.Dimension(1200, 600));


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
//            new TrangChuaThongKeNhanVienTheoThang().setVisible(true);
//        });
//
//    }
}
