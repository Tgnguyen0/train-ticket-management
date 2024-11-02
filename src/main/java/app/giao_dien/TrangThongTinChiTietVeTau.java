package app.giao_dien;

import app.dieu_khien.HanhDong_TrangDanhSachVe;
import app.dieu_khien.HanhDong_TrangThongTinChiTietVeTau;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class TrangThongTinChiTietVeTau extends JFrame {
    public javax.swing.JButton buttonCapNhat;
    public javax.swing.JButton buttonInVe;
    public javax.swing.JButton buttonViTriGhe;
    public javax.swing.JButton buttonXacNhan;
    public javax.swing.JLabel labelDiemDen;
    public javax.swing.JLabel labelDiemDi;
    public javax.swing.JLabel labelGhe;
    public javax.swing.JLabel labelLoaiDoiTuong;
    public javax.swing.JLabel labelLoaiVe;
    public javax.swing.JLabel labelMaVe;
    public javax.swing.JLabel labelNgayDatVe;
    public javax.swing.JLabel labelNgayKhoiHanh;
    public javax.swing.JLabel labelNgayTroVe;
    public javax.swing.JLabel labelSoHieu;
    public javax.swing.JLabel labelTenKhachHang;
    public javax.swing.JLabel labelToa;
    public javax.swing.JLabel labelGiaVe;
    public javax.swing.JTextField textFieldDiemDen;
    public javax.swing.JTextField textFieldDiemDi;
    public javax.swing.JTextField textFieldGhe;
    public javax.swing.JTextField textFieldLoaiDoiTuong;
    public javax.swing.JTextField textFieldLoaiVe;
    public javax.swing.JTextField textFieldMaVe;
    public javax.swing.JTextField textFieldNgayDatVe;
    public javax.swing.JTextField textFieldNgayKhoiHanh;
    public javax.swing.JTextField textFieldNgayTroVe;
    public javax.swing.JTextField textFieldSoHieu;
    public javax.swing.JTextField textFieldTenKhachHang;
    public javax.swing.JTextField textFieldToa;
    public javax.swing.JTextField textFieldGiaVe;
    public javax.swing.JPanel trangChuaCacButton;
    public javax.swing.JPanel trangChuaDiemDen;
    public javax.swing.JPanel trangChuaDiemDi;
    public javax.swing.JPanel trangChuaLoaiDoiTuong;
    public javax.swing.JPanel trangChuaLoaiVe;
    public javax.swing.JPanel trangChuaMaVe;
    public javax.swing.JPanel trangChuaNgayDatVe;
    public javax.swing.JPanel trangChuaNgayKhoiHanh;
    public javax.swing.JPanel trangChuaNgayTroVe;
    public javax.swing.JPanel trangChuaSoHieuTau;
    public javax.swing.JPanel trangChuaTenKhachHang;
    public javax.swing.JPanel trangChuaTenToa;
    public javax.swing.JPanel trangChuaThongTinVeChiTiet;
    public javax.swing.JPanel trangChuaViTriGhe;
    public javax.swing.JPanel trangChuaGiaVe;
    public ActionListener ac;
    public MouseListener mouse;

    public TrangThongTinChiTietVeTau(String maVe, String loaiVe, String diemDi, String diemDen, String ngayKhoiHanh,
                                     String ngayTroVe, String tenKhachHang, String soHieu, String tenToa,
                                     String viTriGhe, String ngayDatVe, String doiTuong, String giaVe){
        this.setSize(724, 331); // Đặt kích thước cụ thể cho cửa sổ
        setResizable(false);
        setLocationRelativeTo(null);

        trangChuaThongTinVeChiTiet = new javax.swing.JPanel();
        trangChuaMaVe = new javax.swing.JPanel();
        labelMaVe = new javax.swing.JLabel();
        textFieldMaVe = new javax.swing.JTextField();
        trangChuaTenKhachHang = new javax.swing.JPanel();
        labelTenKhachHang = new javax.swing.JLabel();
        textFieldTenKhachHang = new javax.swing.JTextField();
        trangChuaLoaiVe = new javax.swing.JPanel();
        labelLoaiVe = new javax.swing.JLabel();
        textFieldLoaiVe = new javax.swing.JTextField();
        trangChuaSoHieuTau = new javax.swing.JPanel();
        labelSoHieu = new javax.swing.JLabel();
        textFieldSoHieu = new javax.swing.JTextField();
        trangChuaDiemDi = new javax.swing.JPanel();
        labelDiemDi = new javax.swing.JLabel();
        textFieldDiemDi = new javax.swing.JTextField();
        trangChuaTenToa = new javax.swing.JPanel();
        labelToa = new javax.swing.JLabel();
        textFieldToa = new javax.swing.JTextField();
        trangChuaDiemDen = new javax.swing.JPanel();
        labelDiemDen = new javax.swing.JLabel();
        textFieldDiemDen = new javax.swing.JTextField();
        trangChuaViTriGhe = new javax.swing.JPanel();
        labelGhe = new javax.swing.JLabel();
        textFieldGhe = new javax.swing.JTextField();
        trangChuaNgayKhoiHanh = new javax.swing.JPanel();
        labelNgayKhoiHanh = new javax.swing.JLabel();
        textFieldNgayKhoiHanh = new javax.swing.JTextField();
        trangChuaNgayDatVe = new javax.swing.JPanel();
        labelNgayDatVe = new javax.swing.JLabel();
        textFieldNgayDatVe = new javax.swing.JTextField();
        trangChuaNgayTroVe = new javax.swing.JPanel();
        labelNgayTroVe = new javax.swing.JLabel();
        textFieldNgayTroVe = new javax.swing.JTextField();
        trangChuaLoaiDoiTuong = new javax.swing.JPanel();
        labelLoaiDoiTuong = new javax.swing.JLabel();
        textFieldLoaiDoiTuong = new javax.swing.JTextField();
        trangChuaCacButton = new javax.swing.JPanel();
        buttonCapNhat = new javax.swing.JButton();
        buttonXacNhan = new javax.swing.JButton();
        buttonInVe = new javax.swing.JButton();
        buttonViTriGhe = new javax.swing.JButton();
        labelGiaVe = new JLabel();
        textFieldGiaVe = new JTextField();
        trangChuaGiaVe = new JPanel();
        /*
            trình tự các thiết lập trang chứa giao diện
         */

        thietLap_TrangChuaMaVe();

        thietLap_TrangTenKhacHang();

        thietLap_TrangChuaLoaiVe();

        thietLap_TrangChuaSoHieuTau();

        thietLap_TrangChuaDiemDi();

        thietLap_TrangChuaTenToa();

        thietLap_TrangChuaDiemDen();

        thietLap_TrangChuaViTriGhe();

        thietLap_TrangChuaNgayKhoiHanh();

        thietLap_TrangChuaNgayDatVe();

        thietLap_TrangChuaNgayTroVe();

        trangChua_TrangChuaLoaiDoiTuong();

        thietLap_TrangChuaGiaVe();

        thietLap_TrangChuaCacButton();

        thietLap_TrangChuaThongTinChiTietVe();

        /*
            đẩy các dữ liệu vào jtextField
         */
        this.textFieldMaVe.setText(maVe);
        this.textFieldLoaiVe.setText(loaiVe);
        this.textFieldDiemDi.setText(diemDi);
        this.textFieldDiemDen.setText(diemDen);
        this.textFieldNgayKhoiHanh.setText(ngayKhoiHanh);
        this.textFieldNgayTroVe.setText(ngayTroVe);
        this.textFieldTenKhachHang.setText(tenKhachHang);
        this.textFieldSoHieu.setText(soHieu);
        this.textFieldToa.setText(tenToa);
        this.textFieldGhe.setText(viTriGhe);
        this.textFieldNgayDatVe.setText(ngayDatVe);
        this.textFieldLoaiDoiTuong.setText(doiTuong);
        this.textFieldGiaVe.setText(giaVe);

        /*
            cài đặt vô hiệu hóa các jtextField
         */
        caiDatVoHieuHoa();

        /*
            thêm các actionlistener cho các button
         */
        this.ac = new HanhDong_TrangThongTinChiTietVeTau(this);
        this.mouse = new HanhDong_TrangThongTinChiTietVeTau(this);
        addActionForButton();

        pack();
    }

    public void thietLap_TrangChuaMaVe(){
        labelMaVe.setText("Mã Vé: ");

        textFieldMaVe.setText("");

        javax.swing.GroupLayout trangChuaMaVeLayout = new javax.swing.GroupLayout(trangChuaMaVe);
        trangChuaMaVe.setLayout(trangChuaMaVeLayout);
        trangChuaMaVeLayout.setHorizontalGroup(
                trangChuaMaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaMaVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        trangChuaMaVeLayout.setVerticalGroup(
                trangChuaMaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaMaVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaMaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelMaVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textFieldMaVe, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangTenKhacHang(){

        labelTenKhachHang.setText("Họ Và Tên:");

        textFieldTenKhachHang.setText("");

        javax.swing.GroupLayout trangChuaTenKhachHangLayout = new javax.swing.GroupLayout(trangChuaTenKhachHang);
        trangChuaTenKhachHang.setLayout(trangChuaTenKhachHangLayout);
        trangChuaTenKhachHangLayout.setHorizontalGroup(
                trangChuaTenKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaTenKhachHangLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE))
        );
        trangChuaTenKhachHangLayout.setVerticalGroup(
                trangChuaTenKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaTenKhachHangLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaTenKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textFieldTenKhachHang)
                                        .addComponent(labelTenKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaLoaiVe(){

        labelLoaiVe.setText("Loại Vé:");

        textFieldLoaiVe.setText("");

        javax.swing.GroupLayout trangChuaLoaiVeLayout = new javax.swing.GroupLayout(trangChuaLoaiVe);
        trangChuaLoaiVe.setLayout(trangChuaLoaiVeLayout);
        trangChuaLoaiVeLayout.setHorizontalGroup(
                trangChuaLoaiVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaLoaiVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelLoaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldLoaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        trangChuaLoaiVeLayout.setVerticalGroup(
                trangChuaLoaiVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaLoaiVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaLoaiVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelLoaiVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textFieldLoaiVe, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaSoHieuTau(){
        labelSoHieu.setText("Số Hiệu:");

        textFieldSoHieu.setText("");

        javax.swing.GroupLayout trangChuaSoHieuTauLayout = new javax.swing.GroupLayout(trangChuaSoHieuTau);
        trangChuaSoHieuTau.setLayout(trangChuaSoHieuTauLayout);
        trangChuaSoHieuTauLayout.setHorizontalGroup(
                trangChuaSoHieuTauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaSoHieuTauLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelSoHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldSoHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        trangChuaSoHieuTauLayout.setVerticalGroup(
                trangChuaSoHieuTauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaSoHieuTauLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaSoHieuTauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textFieldSoHieu)
                                        .addComponent(labelSoHieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaDiemDi(){

        labelDiemDi.setText("Điểm Đi:");

        textFieldDiemDi.setText("");

        javax.swing.GroupLayout trangChuaDiemDiLayout = new javax.swing.GroupLayout(trangChuaDiemDi);
        trangChuaDiemDi.setLayout(trangChuaDiemDiLayout);
        trangChuaDiemDiLayout.setHorizontalGroup(
                trangChuaDiemDiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaDiemDiLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelDiemDi, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldDiemDi, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        trangChuaDiemDiLayout.setVerticalGroup(
                trangChuaDiemDiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaDiemDiLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaDiemDiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelDiemDi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textFieldDiemDi, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaTenToa(){

        labelToa.setText("Tên Toa:");

        textFieldToa.setText("");

        javax.swing.GroupLayout trangChuaTenToaLayout = new javax.swing.GroupLayout(trangChuaTenToa);
        trangChuaTenToa.setLayout(trangChuaTenToaLayout);
        trangChuaTenToaLayout.setHorizontalGroup(
                trangChuaTenToaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaTenToaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelToa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldToa, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaTenToaLayout.setVerticalGroup(
                trangChuaTenToaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaTenToaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaTenToaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelToa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textFieldToa, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaDiemDen(){
        labelDiemDen.setText("Điểm Đến:");

        textFieldDiemDen.setText("");

        javax.swing.GroupLayout trangChuaDiemDenLayout = new javax.swing.GroupLayout(trangChuaDiemDen);
        trangChuaDiemDen.setLayout(trangChuaDiemDenLayout);
        trangChuaDiemDenLayout.setHorizontalGroup(
                trangChuaDiemDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaDiemDenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelDiemDen, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldDiemDen, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaDiemDenLayout.setVerticalGroup(
                trangChuaDiemDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaDiemDenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaDiemDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelDiemDen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textFieldDiemDen, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaViTriGhe(){


        labelGhe.setText("Vị Trí Ghế:");

        textFieldGhe.setText("");

        javax.swing.GroupLayout trangChuaViTriGheLayout = new javax.swing.GroupLayout(trangChuaViTriGhe);
        trangChuaViTriGhe.setLayout(trangChuaViTriGheLayout);
        trangChuaViTriGheLayout.setHorizontalGroup(
                trangChuaViTriGheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaViTriGheLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaViTriGheLayout.setVerticalGroup(
                trangChuaViTriGheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaViTriGheLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaViTriGheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(textFieldGhe, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                        .addComponent(labelGhe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaNgayKhoiHanh(){
        labelNgayKhoiHanh.setText("Ngày Khởi Hành:");

        textFieldNgayKhoiHanh.setText("");

        javax.swing.GroupLayout trangChuaNgayKhoiHanhLayout = new javax.swing.GroupLayout(trangChuaNgayKhoiHanh);
        trangChuaNgayKhoiHanh.setLayout(trangChuaNgayKhoiHanhLayout);
        trangChuaNgayKhoiHanhLayout.setHorizontalGroup(
                trangChuaNgayKhoiHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNgayKhoiHanhLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelNgayKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldNgayKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        trangChuaNgayKhoiHanhLayout.setVerticalGroup(
                trangChuaNgayKhoiHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNgayKhoiHanhLayout.createSequentialGroup()
                                .addGroup(trangChuaNgayKhoiHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textFieldNgayKhoiHanh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                        .addGroup(trangChuaNgayKhoiHanhLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(labelNgayKhoiHanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaNgayDatVe(){
        labelNgayDatVe.setText("Ngày Đặt Vé:");

        textFieldNgayDatVe.setText("");

        javax.swing.GroupLayout trangChuaNgayDatVeLayout = new javax.swing.GroupLayout(trangChuaNgayDatVe);
        trangChuaNgayDatVe.setLayout(trangChuaNgayDatVeLayout);
        trangChuaNgayDatVeLayout.setHorizontalGroup(
                trangChuaNgayDatVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNgayDatVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelNgayDatVe, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldNgayDatVe, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaNgayDatVeLayout.setVerticalGroup(
                trangChuaNgayDatVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaNgayDatVeLayout.createSequentialGroup()
                                .addGroup(trangChuaNgayDatVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(textFieldNgayDatVe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                        .addComponent(labelNgayDatVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaNgayTroVe(){
        labelNgayTroVe.setText("Ngày Trở Về:");

        textFieldNgayTroVe.setText("");

        javax.swing.GroupLayout trangChuaNgayTroVeLayout = new javax.swing.GroupLayout(trangChuaNgayTroVe);
        trangChuaNgayTroVe.setLayout(trangChuaNgayTroVeLayout);
        trangChuaNgayTroVeLayout.setHorizontalGroup(
                trangChuaNgayTroVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNgayTroVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelNgayTroVe, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldNgayTroVe, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        trangChuaNgayTroVeLayout.setVerticalGroup(
                trangChuaNgayTroVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNgayTroVeLayout.createSequentialGroup()
                                .addComponent(labelNgayTroVe, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(trangChuaNgayTroVeLayout.createSequentialGroup()
                                .addComponent(textFieldNgayTroVe)
                                .addContainerGap())
        );
    }

    public void trangChua_TrangChuaLoaiDoiTuong(){
        labelLoaiDoiTuong.setText("Đối Tượng:");

        textFieldLoaiDoiTuong.setText("");

        javax.swing.GroupLayout trangChuaLoaiDoiTuongLayout = new javax.swing.GroupLayout(trangChuaLoaiDoiTuong);
        trangChuaLoaiDoiTuong.setLayout(trangChuaLoaiDoiTuongLayout);
        trangChuaLoaiDoiTuongLayout.setHorizontalGroup(
                trangChuaLoaiDoiTuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaLoaiDoiTuongLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelLoaiDoiTuong, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldLoaiDoiTuong, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE))
        );
        trangChuaLoaiDoiTuongLayout.setVerticalGroup(
                trangChuaLoaiDoiTuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaLoaiDoiTuongLayout.createSequentialGroup()
                                .addGroup(trangChuaLoaiDoiTuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelLoaiDoiTuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textFieldLoaiDoiTuong))
                                .addContainerGap())
        );
    }
    public void thietLap_TrangChuaGiaVe(){
        labelGiaVe.setText("Giá Vé:");

        textFieldGiaVe.setText("");

        javax.swing.GroupLayout trangChuaGiaVeLayout = new javax.swing.GroupLayout(trangChuaGiaVe);
        trangChuaGiaVe.setLayout(trangChuaGiaVeLayout);
        trangChuaGiaVeLayout.setHorizontalGroup(
                trangChuaGiaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaGiaVeLayout.createSequentialGroup()
                                .addGroup(trangChuaGiaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(trangChuaGiaVeLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(labelGiaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(trangChuaGiaVeLayout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(textFieldGiaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaGiaVeLayout.setVerticalGroup(
                trangChuaGiaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaGiaVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelGiaVe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldGiaVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    public void thietLap_TrangChuaCacButton(){
        buttonCapNhat.setText("Cập Nhật");

        buttonXacNhan.setText("Xác Nhận");

        buttonInVe.setText("In Vé");

        buttonViTriGhe.setText("Vị Trí Ghế");


        javax.swing.GroupLayout trangChuaCacButtonLayout = new javax.swing.GroupLayout(trangChuaCacButton);
        trangChuaCacButton.setLayout(trangChuaCacButtonLayout);
        trangChuaCacButtonLayout.setHorizontalGroup(
                trangChuaCacButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaCacButtonLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(buttonCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(buttonXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(buttonInVe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(buttonViTriGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaCacButtonLayout.setVerticalGroup(
                trangChuaCacButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaCacButtonLayout.createSequentialGroup()
                                .addGroup(trangChuaCacButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonInVe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonViTriGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaThongTinChiTietVe(){
        javax.swing.GroupLayout trangChuaThongTinVeChiTietLayout = new javax.swing.GroupLayout(trangChuaThongTinVeChiTiet);
        trangChuaThongTinVeChiTiet.setLayout(trangChuaThongTinVeChiTietLayout);
        trangChuaThongTinVeChiTietLayout.setHorizontalGroup(
                trangChuaThongTinVeChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongTinVeChiTietLayout.createSequentialGroup()
                                .addComponent(trangChuaMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                .addComponent(trangChuaTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(trangChuaThongTinVeChiTietLayout.createSequentialGroup()
                                .addComponent(trangChuaLoaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChuaSoHieuTau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(trangChuaThongTinVeChiTietLayout.createSequentialGroup()
                                .addGroup(trangChuaThongTinVeChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(trangChuaThongTinVeChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(trangChuaNgayTroVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(trangChuaThongTinVeChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(trangChuaDiemDen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(trangChuaNgayKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(trangChuaDiemDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(trangChuaThongTinVeChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(trangChuaTenToa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaViTriGhe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaNgayDatVe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaLoaiDoiTuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaThongTinVeChiTietLayout.createSequentialGroup()
                                .addComponent(trangChuaGiaVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaCacButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        trangChuaThongTinVeChiTietLayout.setVerticalGroup(
                trangChuaThongTinVeChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongTinVeChiTietLayout.createSequentialGroup()
                                .addGroup(trangChuaThongTinVeChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(trangChuaTenKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaMaVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(trangChuaThongTinVeChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(trangChuaLoaiVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaSoHieuTau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(trangChuaThongTinVeChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChuaDiemDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(trangChuaTenToa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(trangChuaThongTinVeChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(trangChuaThongTinVeChiTietLayout.createSequentialGroup()
                                                .addComponent(trangChuaViTriGhe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(trangChuaNgayDatVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(trangChuaThongTinVeChiTietLayout.createSequentialGroup()
                                                .addComponent(trangChuaDiemDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(trangChuaNgayKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(trangChuaThongTinVeChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(trangChuaLoaiDoiTuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaNgayTroVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(trangChuaThongTinVeChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(trangChuaCacButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaGiaVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(trangChuaThongTinVeChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(trangChuaThongTinVeChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }

    public void caiDatVoHieuHoa(){
        this.textFieldMaVe.setEditable(false);
        this.textFieldLoaiVe.setEditable(false);
        this.textFieldDiemDi.setEditable(false);
        this.textFieldDiemDen.setEditable(false);
        this.textFieldNgayKhoiHanh.setEditable(false);
        this.textFieldNgayTroVe.setEditable(false);
        this.textFieldTenKhachHang.setEditable(false);
        this.textFieldSoHieu.setEditable(false);
        this.textFieldToa.setEditable(false);
        this.textFieldGhe.setEditable(false);
        this.textFieldNgayDatVe.setEditable(false);
        this.textFieldLoaiDoiTuong.setEditable(false);
        this.textFieldGiaVe.setEditable(false);
        this.buttonViTriGhe.setEnabled(false);
    }

    public void choPhepCapNhat(){
        //this.textFieldLoaiVe.setEditable(true);
//        this.textFieldDiemDi.setEditable(true);
//        this.textFieldDiemDen.setEditable(true);
//        this.textFieldNgayKhoiHanh.setEditable(true);
//        this.textFieldNgayTroVe.setEditable(true);this.textFieldTenKhachHang.setEditable(true);
//        this.textFieldSoHieu.setEditable(true);
//        this.textFieldToa.setEditable(true);
//        this.textFieldGhe.setEditable(true);
//        this.textFieldNgayDatVe.setEditable(true);
        //this.textFieldLoaiDoiTuong.setEditable(true);
        this.buttonViTriGhe.setEnabled(true);
    }
    public void addActionForButton(){
        this.buttonCapNhat.addActionListener(ac);
        this.buttonInVe.addActionListener(ac);
        this.buttonViTriGhe.addActionListener(ac);
        this.buttonXacNhan.addActionListener(ac);
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
            java.util.logging.Logger.getLogger(TrangThongTinChiTietVeTau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangThongTinChiTietVeTau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangThongTinChiTietVeTau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangThongTinChiTietVeTau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new TrangThongTinChiTietVeTau("", "", "", "", "", "",
//                "", "", "", "", "", "").setVisible(true);
            }
        });
    }
}
