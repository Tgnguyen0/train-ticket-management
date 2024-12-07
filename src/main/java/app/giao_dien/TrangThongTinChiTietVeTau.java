package app.giao_dien;

import app.dao.Ga_DAO;
import app.dao.Ghe_DAO;
import app.dao.LichCapBenGa_DAO;
import app.dieu_khien.HanhDong_TrangDanhSachVe;
import app.dieu_khien.HanhDong_TrangThongTinChiTietVeTau;
import app.phong_chu_moi.PhongChuMoi;
import app.thuc_the.Ghe;
import app.thuc_the.NhaGa;
import app.thuc_the.TRANG_THAI_GHE;
import com.toedter.calendar.JDateChooser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

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
    public JLabel labelNgayKhoiHanh;
    public javax.swing.JLabel labelNgayTroVe;
    public javax.swing.JLabel labelSoHieu;
    public javax.swing.JLabel labelTenKhachHang;
    public javax.swing.JLabel labelToa;
    public javax.swing.JLabel labelGiaVe;
    public JComboBox<String> thanhChonDiemDen;
    public JComboBox<String> thanhChonDiemDi;
    public javax.swing.JTextField textFieldGhe;
    public javax.swing.JTextField textFieldLoaiDoiTuong;
    public javax.swing.JTextField textFieldLoaiVe;
    public javax.swing.JTextField textFieldMaVe;
    public JDateChooser thanhChonNgayDatVe;
    public JDateChooser thanhChonNgayKhoiHanh;
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
    public javax.swing.JPanel trangCha;
    public ActionListener ac;
    public MouseListener mouse;

    public Ga_DAO gaDao;
    public LichCapBenGa_DAO lichDao;
    public Ghe_DAO gheDao;
    //public Ghe ghe;
    public List<NhaGa> dsGa;
    public Color xanhBrandeis = new Color(0, 112, 255);

    Logger logger = LoggerFactory.getLogger(TrangThongTinChiTietVeTau.class);

    public TrangThongTinChiTietVeTau(JPanel trang, String maVe, String loaiVe, String diemDi, String diemDen, LocalDateTime ngayKhoiHanh,
                                     String ngayTroVe, String tenKhachHang, String soHieu, String tenToa,
                                     Ghe ghe, LocalDateTime ngayDatVe, String doiTuong, String giaVe){
        this.setSize(724, 331); // Đặt kích thước cụ thể cho cửa sổ
        setResizable(false);
        setLocationRelativeTo(null);
        this.lichDao = new LichCapBenGa_DAO(); // Lấy LichCapBenGa_DAO
        this.gaDao = new Ga_DAO(); // Lấy Ga_DAO

        /* Quan trọng */
        //this.ghe = ghe;
        this.trangCha = trang; // Để setText cho TrangDanhSachVe
        this.gheDao = new Ghe_DAO(); // Khởi tạo ghế dao
        gheDao.capNhatTrangThaiGhe(TRANG_THAI_GHE.Trong.getValue(), ghe.getMaGhe());
        ghe.setTrangThai(TRANG_THAI_GHE.Trong); // Chỉnh về trạng thái trống
        gheDao.themGhe(ghe); // Thêm ghe đã có vào dsGheDat

        dsGa = this.gaDao.ChonTatCa(); // Lấy danh sách nhà ga
        this.ac = new HanhDong_TrangThongTinChiTietVeTau(this);
        this.mouse = new HanhDong_TrangThongTinChiTietVeTau(this);

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
        thanhChonDiemDi = new JComboBox<>();
        trangChuaTenToa = new javax.swing.JPanel();
        labelToa = new javax.swing.JLabel();
        textFieldToa = new javax.swing.JTextField();
        trangChuaDiemDen = new javax.swing.JPanel();
        labelDiemDen = new javax.swing.JLabel();
        thanhChonDiemDen = new JComboBox<>();
        trangChuaViTriGhe = new javax.swing.JPanel();
        labelGhe = new javax.swing.JLabel();
        textFieldGhe = new javax.swing.JTextField();
        trangChuaNgayKhoiHanh = new javax.swing.JPanel();
        labelNgayKhoiHanh = new javax.swing.JLabel();
        thanhChonNgayKhoiHanh = new JDateChooser();
        trangChuaNgayDatVe = new javax.swing.JPanel();
        labelNgayDatVe = new javax.swing.JLabel();
        thanhChonNgayDatVe = new JDateChooser();
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

        for (int i = 0 ; i < dsGa.size() ; i++) {
            // Bỏ "vũng tàu" với "cần thơ" vì không có đường ray qua
            if (!dsGa.get(i).getTenGa().equals("Vũng Tàu") && !dsGa.get(i).getTenGa().equals("Cần Thơ")) {
                thanhChonDiemDi.addItem(dsGa.get(i).getTenGa());
            }
        }

        this.thanhChonDiemDi.setSelectedItem(diemDi);
        //logger.info(diemDi);

        for (int i = 0 ; i < dsGa.size() ; i++) {
            // Bỏ "vũng tàu" với "cần thơ" vì không có đường ray qua
            if (!dsGa.get(i).getTenGa().equals("Vũng Tàu") && !dsGa.get(i).getTenGa().equals("Cần Thơ")) {
                thanhChonDiemDen.addItem(dsGa.get(i).getTenGa());
            }
        }

        this.thanhChonDiemDen.setSelectedItem(diemDen);

        // Đặt ngày khởi hành
        this.thanhChonNgayKhoiHanh.setDate(Date.from(ngayKhoiHanh.atZone(ZoneId.systemDefault()).toInstant()));
        this.textFieldNgayTroVe.setText(ngayTroVe);
        this.textFieldTenKhachHang.setText(tenKhachHang);
        this.textFieldSoHieu.setText(soHieu);
        this.textFieldToa.setText(tenToa);
        this.textFieldGhe.setText(ghe.getSoGhe());
        // Đặt ngày đặt vé
        this.thanhChonNgayDatVe.setDate(Date.from(ngayDatVe.atZone(ZoneId.systemDefault()).toInstant()));
        this.textFieldLoaiDoiTuong.setText(doiTuong);
        this.textFieldGiaVe.setText(giaVe);
        this.thanhChonDiemDi.setEditable(false);
        this.thanhChonDiemDen.setEditable(false);

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
        labelGiaVe.setFont(new Font("Arial", Font.PLAIN, 13));
        textFieldMaVe.setText("");
        textFieldMaVe.setForeground(Color.BLUE);
        textFieldMaVe.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldMaVe.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));

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
        labelTenKhachHang.setFont(new Font("Arial", Font.PLAIN, 13));

        textFieldTenKhachHang.setText("");
        textFieldTenKhachHang.setForeground(Color.BLUE);
        textFieldTenKhachHang.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldTenKhachHang.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));
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
        labelLoaiVe.setFont(new Font("Arial", Font.PLAIN, 13));

        textFieldLoaiVe.setText("");
        textFieldLoaiVe.setForeground(Color.BLUE);
        textFieldLoaiVe.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldLoaiVe.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));
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
        labelSoHieu.setFont(new Font("Arial", Font.PLAIN, 13));

        textFieldSoHieu.setText("");
        textFieldSoHieu.setForeground(Color.BLUE);
        textFieldSoHieu.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldSoHieu.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));
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
        labelDiemDi.setFont(new Font("Arial", Font.PLAIN, 13));

        //thanhChonDiemDi.setText("");
        thanhChonDiemDi.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        thanhChonDiemDi.setRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                    javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

                // Gọi phương thức mặc định để thiết lập label
                javax.swing.JLabel renderer = (javax.swing.JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                // Căn giữa chữ trong JComboBox
                renderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                renderer.setFont(new Font("Arial", Font.PLAIN, 13));
                // Kiểm tra nếu mục được chọn hoặc có con trỏ chuột đang chỉ vào
                if (isSelected || cellHasFocus) {
                    renderer.setBackground(xanhBrandeis); // Màu nền xanh
                    renderer.setForeground(Color.WHITE); // Màu chữ trắng
                    renderer.setFont(new Font("Arial", Font.BOLD, 13));

                } else {
                    renderer.setBackground(Color.WHITE); // Màu nền trắng khi không chọn
                    renderer.setForeground(xanhBrandeis); // Màu chữ đen khi không chọn
                }
                return renderer;
            }
        });

        javax.swing.GroupLayout trangChuaDiemDiLayout = new javax.swing.GroupLayout(trangChuaDiemDi);
        trangChuaDiemDi.setLayout(trangChuaDiemDiLayout);
        trangChuaDiemDiLayout.setHorizontalGroup(
                trangChuaDiemDiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaDiemDiLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelDiemDi, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thanhChonDiemDi, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        trangChuaDiemDiLayout.setVerticalGroup(
                trangChuaDiemDiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaDiemDiLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaDiemDiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelDiemDi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(thanhChonDiemDi, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaTenToa(){

        labelToa.setText("Tên Toa:");
        labelToa.setFont(new Font("Arial", Font.PLAIN, 13));

        textFieldToa.setText("");
        textFieldToa.setForeground(Color.BLUE);
        textFieldToa.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldToa.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));
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
        labelDiemDen.setFont(new Font("Arial", Font.PLAIN, 13));

        //thanhChonDiemDen.setText("");
        thanhChonDiemDen.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        thanhChonDiemDen.setRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                    javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

                // Gọi phương thức mặc định để thiết lập label
                javax.swing.JLabel renderer = (javax.swing.JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                // Căn giữa chữ trong JComboBox
                renderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                renderer.setFont(new Font("Arial", Font.PLAIN, 13));
                // Kiểm tra nếu mục được chọn hoặc có con trỏ chuột đang chỉ vào
                if (isSelected || cellHasFocus) {
                    renderer.setBackground(xanhBrandeis); // Màu nền xanh
                    renderer.setForeground(Color.WHITE); // Màu chữ trắng
                    renderer.setFont(new Font("Arial", Font.BOLD, 13));
                } else {
                    renderer.setBackground(Color.WHITE); // Màu nền trắng khi không chọn
                    renderer.setForeground(xanhBrandeis); // Màu chữ đen khi không chọn
                }
                return renderer;
            }
        });
        javax.swing.GroupLayout trangChuaDiemDenLayout = new javax.swing.GroupLayout(trangChuaDiemDen);
        trangChuaDiemDen.setLayout(trangChuaDiemDenLayout);
        trangChuaDiemDenLayout.setHorizontalGroup(
                trangChuaDiemDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaDiemDenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelDiemDen, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thanhChonDiemDen, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaDiemDenLayout.setVerticalGroup(
                trangChuaDiemDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaDiemDenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChuaDiemDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelDiemDen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(thanhChonDiemDen, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaViTriGhe(){


        labelGhe.setText("Vị Trí Ghế:");
        labelGhe.setFont(new Font("Arial", Font.PLAIN, 13));

        textFieldGhe.setText("");
        textFieldGhe.setForeground(Color.BLUE);
        textFieldGhe.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldGhe.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));
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
        labelNgayKhoiHanh.setText("<html>&nbsp;&nbsp;&nbsp;Ngày<br>KhởiHành:</html>");
        labelNgayKhoiHanh.setFont(new Font("Arial", Font.PLAIN, 13));

        javax.swing.GroupLayout trangChuaNgayKhoiHanhLayout = new javax.swing.GroupLayout(trangChuaNgayKhoiHanh);
        trangChuaNgayKhoiHanh.setLayout(trangChuaNgayKhoiHanhLayout);
        trangChuaNgayKhoiHanhLayout.setHorizontalGroup(
                trangChuaNgayKhoiHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNgayKhoiHanhLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelNgayKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thanhChonNgayKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        trangChuaNgayKhoiHanhLayout.setVerticalGroup(
                trangChuaNgayKhoiHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNgayKhoiHanhLayout.createSequentialGroup()
                                .addGroup(trangChuaNgayKhoiHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(thanhChonNgayKhoiHanh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                        .addGroup(trangChuaNgayKhoiHanhLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(labelNgayKhoiHanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaNgayDatVe(){
        labelNgayDatVe.setText("<html>&nbsp;&nbsp;Ngày<br>Đặt Vé:");
        labelNgayDatVe.setFont(new Font("Arial", Font.PLAIN, 13));

        javax.swing.GroupLayout trangChuaNgayDatVeLayout = new javax.swing.GroupLayout(trangChuaNgayDatVe);
        trangChuaNgayDatVe.setLayout(trangChuaNgayDatVeLayout);
        trangChuaNgayDatVeLayout.setHorizontalGroup(
                trangChuaNgayDatVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNgayDatVeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelNgayDatVe, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thanhChonNgayDatVe, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaNgayDatVeLayout.setVerticalGroup(
                trangChuaNgayDatVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaNgayDatVeLayout.createSequentialGroup()
                                .addGroup(trangChuaNgayDatVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(thanhChonNgayDatVe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                        .addComponent(labelNgayDatVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    public void thietLap_TrangChuaNgayTroVe(){
        labelNgayTroVe.setText("Ngày Trở Về:");
        labelNgayTroVe.setFont(new Font("Arial", Font.PLAIN, 13));

        textFieldNgayTroVe.setText("");
        textFieldNgayTroVe.setForeground(Color.BLUE);

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
        labelLoaiDoiTuong.setFont(new Font("Arial", Font.PLAIN, 13));

        textFieldLoaiDoiTuong.setText("");
        textFieldLoaiDoiTuong.setForeground(Color.BLUE);
        textFieldLoaiDoiTuong.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldLoaiDoiTuong.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));
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
        labelGiaVe.setFont(new Font("Arial", Font.PLAIN, 13));

        textFieldGiaVe.setText("");
        textFieldGiaVe.setForeground(Color.BLUE);
        textFieldGiaVe.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        textFieldGiaVe.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));
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
        buttonCapNhat.setBackground(xanhBrandeis);
        buttonCapNhat.setForeground(Color.WHITE);
        buttonCapNhat.setFont(new Font("Arial", Font.BOLD, 14));

        buttonXacNhan.setText("Xác Nhận");
        buttonXacNhan.setBackground(xanhBrandeis);
        buttonXacNhan.setForeground(Color.WHITE);
        buttonXacNhan.setFont(new Font("Arial", Font.BOLD, 14));

        buttonInVe.setText("In Vé");
        buttonInVe.setBackground(xanhBrandeis);
        buttonInVe.setForeground(Color.WHITE);
        buttonInVe.setFont(new Font("Arial", Font.BOLD, 14));

        buttonViTriGhe.setText("Vị Trí Ghế");
        buttonViTriGhe.setBackground(xanhBrandeis);
        buttonViTriGhe.setForeground(Color.WHITE);
        buttonViTriGhe.setFont(new Font("Arial", Font.BOLD, 14));

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
                                                .addComponent(trangChuaGiaVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(trangChuaGiaVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(trangChuaThongTinVeChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(trangChuaCacButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        ))
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
        this.textFieldNgayTroVe.setEditable(false);
        this.textFieldTenKhachHang.setEditable(false);
        this.textFieldSoHieu.setEditable(false);
        this.textFieldToa.setEditable(false);
        this.textFieldGhe.setEditable(false);
        //this.thanhChonNgayDatVe.setEditable(false);
        this.textFieldLoaiDoiTuong.setEditable(false);
        this.textFieldGiaVe.setEditable(false);
        this.buttonViTriGhe.setEnabled(false);
        this.thanhChonDiemDi.setEnabled(false);
        this.thanhChonDiemDen.setEnabled(false);
        this.thanhChonNgayKhoiHanh.setEnabled(false);
        this.thanhChonNgayDatVe.setEnabled(false);
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
