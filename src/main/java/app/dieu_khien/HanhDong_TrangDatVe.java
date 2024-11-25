package app.dieu_khien;

import app.dao.KhachHang_DAO;
import app.giao_dien.*;
import app.phan_tu_tuy_chinh.TaoVeBangFilePDF;
import app.thuc_the.*;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.List;

public class HanhDong_TrangDatVe implements ActionListener, MouseListener, ItemListener, PropertyChangeListener {
    public TrangDatVe trangDatVe;
    public TrangCacTau trangCacTau;
    public int bienSoTang = 0;
    public List<Ve> dsVeDaDat;
    public List<Ghe> dsGhe;
    public String maGa;

    public HanhDong_TrangDatVe(TrangDatVe trangDatVe) {
        this.trangDatVe = trangDatVe;
        this.dsVeDaDat = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        /*if (source == this.trangDatVe.nutLuaChonMotChieu) {
            this.trangDatVe.nutLuaChonKhuHoi.setSelected(false);
            //this.trangDatVe.thanhNhapNgayTroVe.setEnabled(false);
        }

        if (source == this.trangDatVe.nutLuaChonKhuHoi) {
            this.trangDatVe.nutLuaChonMotChieu.setSelected(false);
            //this.trangDatVe.thanhNhapNgayTroVe.setEnabled(true);
        }*/

        if (source == this.trangDatVe.nutLuaChonNam) {
            this.trangDatVe.nutLuaChonNu.setSelected(false);
        }

        if (source == this.trangDatVe.nutLuaChonNu) {
            this.trangDatVe.nutLuaChonNam.setSelected(false);
        }

        if (source == this.trangDatVe.nutDSVe) {
            TrangDanhSachVeTau.moGiaoDienDanhSach();
        }

        if (source == this.trangDatVe.nutHienThiSoDoGhe) {
            if (trangDatVe.thanhNhapNgayDi.getDate() != null) {
                LocalDateTime ngayKhoiHanh = trangDatVe.thanhNhapNgayDi.getDate()
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();

                this.maGa = this.trangDatVe.gaDao.ChonTheoTen( (String) this.trangDatVe.thanhCacDiemDi.getSelectedItem()).getMaGa();

                List<LichCapBenGa> dsLich = this.trangDatVe.lichDao.ChonTheoNgayKHVaGa(ngayKhoiHanh, maGa);

                for (int i = 0 ; i < dsLich.size() ; i++) {
                    System.out.println(dsLich.get(i).getMaTau());
                }

                this.trangCacTau = new TrangCacTau(this.trangDatVe.layDSTau(), this.trangDatVe.layGheDao(), dsLich);
                trangCacTau.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                trangCacTau.setVisible(true);
            } else {
                hienThiThongBao("Chưa chọn ngày khởi hành", "Lỗi chọn ngày", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (this.trangCacTau != null && this.trangCacTau.laySoHieuTauChon() != null) {
            this.trangDatVe.soHieuDaChon = this.trangCacTau.laySoHieuTauChon();

            LocalDateTime ngayKhoiHanh = this.trangDatVe.thanhNhapNgayDi.getDate()       // Lấy ngày khởi hành
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            // Lấy lịch tàu đó
            LichCapBenGa lich = this.trangDatVe.lichDao.ChonTheoSoHieuNgayKHVaGa(
                    this.trangDatVe.soHieuDaChon,
                    ngayKhoiHanh,
                    this.maGa
            );

            this.trangDatVe.thanhNhapGioDen.setText(lich.getGioKhoiHanh().getHour() +
                    ":" + lich.getGioKhoiHanh().getMinute());
        } else {
            this.trangDatVe.soHieuDaChon = null;
        }

        if (source == this.trangDatVe.nutXacNhan) {
            // Lấy danh sách khách hàng đã đặt vé
            List<KhachHang> dsKhDatVe = this.trangDatVe.layDSKhDatVe();

            String hoTen = dsKhDatVe.get(bienSoTang).getTenKH(); // Lấy họ tên
            String sdt = dsKhDatVe.get(bienSoTang).getSoDT(); // lấy số điện thoại
            String email = dsKhDatVe.get(bienSoTang).getEmail(); // lấy email

            // Đặt cho khách hàng tiếp theo
            if (bienSoTang + 1 < dsKhDatVe.size()) {  // Thay đổi ở đây
                this.trangDatVe.thanhNhapHoTen.setText(dsKhDatVe.get(bienSoTang + 1).getTenKH());
                this.trangDatVe.thanhNhapDienThoai.setText(dsKhDatVe.get(bienSoTang + 1).getSoDT());
                this.trangDatVe.thanhNhapThuDienTu.setText(dsKhDatVe.get(bienSoTang + 1).getEmail());
            }

            // Lấy giới tính
            GIOI_TINH gioiTinh = dsKhDatVe.get(bienSoTang).getGioiTinh();

            // Đặt cho các nút lựa chọn giới
            if (gioiTinh.getValue().equals("Nam")) {
                this.trangDatVe.nutLuaChonNam.setSelected(true);
                this.trangDatVe.nutLuaChonNu.setSelected(false);
            } else {
                this.trangDatVe.nutLuaChonNam.setSelected(false);
                this.trangDatVe.nutLuaChonNu.setSelected(true);
            }

            String diemDi = (String) trangDatVe.thanhCacDiemDi.getSelectedItem(); // Lấy ga xuất phát
            String diemDen = (String) trangDatVe.thanhCacDiemDen.getSelectedItem(); // Lấy ga đích
            //String loaiVe = trangDatVe.nutLuaChonKhuHoi.isSelected() ? "Khu Hoi" : "Mot Chieu"; // Lấy loại vé

            LocalDateTime ngayKhoiHanh = trangDatVe.thanhNhapNgayDi.getDate()       // Lấy ngày khởi hành
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            /*LocalDateTime ngayTroVe = trangDatVe.thanhNhapNgayTroVe.getDate()      // Lấy ngày trở về
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();*/

            this.dsGhe = new ArrayList<>(this.trangDatVe.gheDao.layDSGheDat()); // lấy danh sách chỗ đã đặt
            Ghe daDat = this.trangDatVe.gheDao.traGheChon(); // lấy ghế đã đặt

            for (Ghe ghe: this.trangDatVe.gheDao.layDSGheDat()) {
                System.out.println("dsChoDaDat: " + ghe.getMaGhe());
            }

            String soHieuTau = this.trangDatVe.soHieuDaChon; // Lấy số hiệu tàu đã chọn
            LichCapBenGa lich = this.trangDatVe.lichDao.ChonTheoSoHieuNgayKHVaGa(soHieuTau, ngayKhoiHanh, maGa); // Lấy lịch tàu đó

            String maToa = daDat.getMaToa(); // Lấy mã toa
            String soGhe = daDat.getSoGhe(); // Lấy số ghế
            String loaiDoiTuong = (String) this.trangDatVe.thanhCacLoaiDoiTuong.getSelectedItem(); // Lấy loại đối tượng

            // Tính toán giá vé
            int khoangCach = this.trangDatVe.gaDao.luocDoKhoangCach.get(diemDen) - // khoảng cách giữa ga xuất phát và ga đích
                    this.trangDatVe.gaDao.luocDoKhoangCach.get(diemDi);
            int giaCoBan = this.trangDatVe.veDao.giaVeCoBan.get(                   // Giá cơ bản của loại vé (loại ghế)
                    daDat.getLoaiGhe().toString()).get(loaiDoiTuong);
            double giaVe = khoangCach * giaCoBan; // giá vé được tính

            // Khởi tạo đối tượng vé
            Ve veDat = new Ve(
                    loaiDoiTuong,                                                 // Loại đối tượng
                    lich.getGioKhoiHanh(),                                        // Ngày khởi hành
                    LocalDateTime.now(),                                          // Ngày đặt vé
                    diemDi,                                                       // Ga xuất phát
                    diemDen,                                                      // Ga đích
                    giaVe,                                                        // Giá vé
                    this.trangDatVe.dsKHDatVe.get(bienSoTang).getMaKH(),          // Mã khách hàng
                    daDat.getMaGhe(),                                             // Mã ghế
                    daDat.getLoaiGhe().toString()                                 // Loại ghế
            );

            /*System.out.println(
                    ve.getMaVe() + " " +
                            ve.getLoaiDoiTuong() + " " +
                            ve.getNgayKhoiHanh() + " " +
                            ve.getNgayDatVe() + " " +
                            ve.getGaKhoiHanh() + " " +
                            ve.getGaKetThuc() + " " +
                            ve.getGiaVe() + " " +
                            ve.getMaKhachHang() + " " +
                            ve.getMaGhe()
            );*/

            // Dòng dữ liệu
            Object[] duLieu = {
                    String.valueOf(bienSoTang + 1),                               // Thứ tự
                    veDat.getMaVe(),                                                // Mã vé
                    hoTen,                                                          // Họ tên khách hàng
                    veDat.getLoaiDoiTuong(),                                        // Loại đối tượng
                    (int) veDat.getGiaVe(),                                         // Giá vé
                    veDat.getGaKhoiHanh(),                                          // Ga xuất phát
                    veDat.getGaKetThuc(),                                           // Ga đích
                    LocalDate.now(),                                                // Ngày đặt vé
                    veDat.getNgayKhoiHanh().getYear() + "-" +                       // Ngày khởi hành
                            veDat.getNgayKhoiHanh().getMonth().getValue() + "-" +
                            veDat.getNgayKhoiHanh().getDayOfMonth(),
                    soHieuTau,                                                      // Số hiệu tàu
                    veDat.getNgayKhoiHanh().toLocalTime().getHour() + ":" +         // Giờ xuất phát
                            veDat.getNgayKhoiHanh().toLocalTime().getMinute(),
                    daDat.getLoaiGhe().toString(),                                 // Loại ghế
                    maToa,                                                         // Mã toa
                    soGhe                                                          // Số ghế
            };

            // Thêm vào bảng
            this.trangDatVe.moHinhBang.addRow(duLieu);

            // Thêm vào danh sách vé đã đặt
            this.dsVeDaDat.add(veDat);

            // Tăng đơn vị
            this.bienSoTang++;
        }

        if (e.getSource() == this.trangDatVe.nutThanhToan) {
            if (!this.dsVeDaDat.isEmpty()) {
                //hienThiThongBao("Không có vé để thanh toán!", "Lỗi thanh toán", JOptionPane.INFORMATION_MESSAGE);

                this.trangDatVe.veDao.themDSVe(this.dsVeDaDat);

                TrangThanhToan trangThanhToan = new TrangThanhToan(this.trangDatVe.veDao.layDSVeDat(), this.trangDatVe.dsKHDatVe, this.dsGhe);
                trangThanhToan.setVisible(true);
            } else {
                hienThiThongBao("Không có vé để thanh toán!", "Lỗi thanh toán", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == this.trangDatVe.nutInVe) {
            if (!this.dsVeDaDat.isEmpty()) {
                TrangInVe trangInVe = new TrangInVe(this.dsVeDaDat, this.trangDatVe.layDSKhDatVe(), this.dsGhe);
                trangInVe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                trangInVe.setVisible(true);
            } else {
                hienThiThongBao("Không có vé để in !", "Lỗi in vé", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String loaiGheDaChon = (String) e.getItem();

            if (this.trangDatVe.thanhCacDiemDen.getSelectedItem().equals(this.trangDatVe.thanhCacDiemDi.getSelectedItem())) {
                hienThiThongBao("Điểm đi và điểm đến không được trùng", "Lỗi chọn địa điểm", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton enteredButton = (JButton) e.getComponent();
        enteredButton.setBackground(new Color(this.trangDatVe.xanhNhat.getRGB())); // Thay đổi màu khi hover
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton exitedButton = (JButton) e.getComponent();
        exitedButton.setBackground(new Color(this.trangDatVe.xanhBrandeis.getRGB())); // Khôi phục màu ban đầu khi di chuột ra khỏi nút
    }

    private boolean isErrorDialogVisible = false;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object source = evt.getSource();

        // Kiểm tra thay đổi thực sự của ngày
        if (evt.getOldValue() != evt.getNewValue()) {
            LocalDate ngayDi = layNgay(this.trangDatVe.thanhNhapNgayDi); // Lấy ngày đi tại thời điểm thay đổi
            //LocalDate ngayTroVe = layNgay(this.trangDatVe.thanhNhapNgayTroVe); // Lấy ngày trở về tại thời điểm thay đổi

            // Check for departure date validation
            if (source == this.trangDatVe.thanhNhapNgayDi.getDateEditor() /*&&
                    this.trangDatVe.nutLuaChonKhuHoi.isSelected()*/) {
                kiemTraNgayDi();
            }

            // Check for return date validation
            /*if (source == this.trangDatVe.thanhNhapNgayTroVe.getDateEditor() &&
                    this.trangDatVe.nutLuaChonKhuHoi.isSelected()) {
                kiemTraNgayTroVe();
            }*/
        }
    }

    private void kiemTraNgayDi() {
        LocalDate ngayDi = layNgay(this.trangDatVe.thanhNhapNgayDi);
        LocalDate ngayHienTai = LocalDate.now();

        if (!ngayDi.isAfter(ngayHienTai) && !ngayDi.equals(ngayHienTai)) {
            if (!isErrorDialogVisible) {
                hienThiThongBao("Ngày đi phải sau Ngày hiện tại.", "Lỗi chọn ngày đi", JOptionPane.ERROR_MESSAGE);
                isErrorDialogVisible = true;
            }
        } else {
            isErrorDialogVisible = false;
        }
    }

    /*private void kiemTraNgayTroVe() {
        LocalDate ngayDi = layNgay(this.trangDatVe.thanhNhapNgayDi);
        LocalDate ngayTroVe = layNgay(this.trangDatVe.thanhNhapNgayTroVe);

        if (!ngayTroVe.isAfter(ngayDi)) {
            if (!isErrorDialogVisible) {
                hienThiThongBao("Ngày Trở Về phải sau Ngày Đi.", "Lỗi chọn ngày trở về");
                isErrorDialogVisible = true;
            }
        } else {
            isErrorDialogVisible = false;
        }
    }*/

    private void hienThiThongBao(String chuThich, String tieuDe, int message) {
        JLabel thongBao = new JLabel(chuThich);
        thongBao.setFont(this.trangDatVe.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));

        JOptionPane hienThiLoi = new JOptionPane(thongBao, message);
        hienThiLoi.setForeground(this.trangDatVe.xanhBrandeis);

        JDialog hoiThoai = hienThiLoi.createDialog(tieuDe);
        ImageIcon bieuTuongTau = new ImageIcon("assets/icon.png");
        hoiThoai.setIconImage(bieuTuongTau.getImage());
        hoiThoai.setVisible(true);
    }

    private LocalDate layNgay(JDateChooser dateChooser) {
        Date date = dateChooser.getDate(); // Lấy giá trị từ dateChooser
        if (date == null) {
            // Nếu date là null, trả về giá trị mặc định (hoặc có thể xử lý theo cách khác tùy thuộc vào logic của bạn)
            return LocalDate.now(); // Hoặc một giá trị phù hợp khác
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
