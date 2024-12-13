package app.dieu_khien;

import app.dao.Ghe_DAO;
import app.dao.KhachHang_DAO;
import app.dao.Tau_DAO;
import app.dao.Toa_DAO;
import app.giao_dien.*;
import app.phan_tu_tuy_chinh.GanAmThanh;
import app.phan_tu_tuy_chinh.TaoVeBangFilePDF;
import app.thuc_the.*;
import com.toedter.calendar.JDateChooser;
import java.time.temporal.ChronoUnit;

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
    //public List<Ve> dsVeDaDat;
    public List<Ghe> dsGhe;
    public String maGa;
    public boolean khonglonHonHoacBangNgayHienTai;
    public boolean khongQuaBaNgaySoVoiHienTai;

    public HanhDong_TrangDatVe(TrangDatVe trangDatVe) {
        this.trangDatVe = trangDatVe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        GanAmThanh.playSound();

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
           // TrangDanhSachVeTau.moGiaoDienDanhSach();
            CardLayout cardLayout = (CardLayout) this.trangDatVe.trangDinhHuong.getTrangChua().getLayout();
            cardLayout.show(this.trangDatVe.trangDinhHuong.getTrangChua(), "Trang Danh Sach Ve");
        }

        if (source == this.trangDatVe.nutHienThiSoDoGhe) {
            if (khonglonHonHoacBangNgayHienTai) {
                hienThiThongBao("Ngày đi phải sau Ngày hiện tại.", "Lỗi chọn ngày đi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (khongQuaBaNgaySoVoiHienTai) {
                hienThiThongBao("Ngày đi không được cách quá 2 ngày so với ngày hiện tại.", "Lỗi chọn ngày đi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (trangDatVe.thanhNhapNgayDi.getDate() == null) {
                hienThiThongBao("Chưa chọn ngày khởi hành", "Lỗi chọn ngày", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (trangDatVe.layDSKhDatVe() == null) {
                hienThiThongBao("Chưa có danh sách khách đặt vé", "Lỗi đặt vé", JOptionPane.ERROR_MESSAGE);
                return;
            }

            LocalDateTime ngayKhoiHanh = trangDatVe.thanhNhapNgayDi.getDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            this.maGa = this.trangDatVe.gaDao.ChonTheoTen( (String) this.trangDatVe.thanhCacDiemDi.getSelectedItem()).getMaGa();

            List<LichCapBenGa> dsLich = this.trangDatVe.lichDao.ChonTheoNgayKHVaGa(ngayKhoiHanh, maGa);
            this.trangDatVe.layGheDao().datSoGheToiDa(this.trangDatVe.layDSKhDatVe().size());

            /*for (int i = 0 ; i < dsLich.size() ; i++) {
                System.out.println(dsLich.get(i).getMaTau());
            }*/

            trangCacTau = new TrangCacTau(this.trangDatVe, null, this.trangDatVe.layDSTau(), this.trangDatVe.layGheDao(), dsLich);
            trangCacTau.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            trangCacTau.setVisible(true);

            /*if (this.trangDatVe.soHieuDaChon != null) {
                trangCacTau.datSoHieuTauChon(this.trangDatVe.soHieuDaChon);
            }*/

            trangCacTau.datMaGa(maGa);
        }

        if (source == this.trangDatVe.nutXacNhan) {
            // Lấy danh sách khách hàng đã đặt vé
            List<KhachHang> dsKhDatVe = this.trangDatVe.layDSKhDatVe();
            // Lấy danh sách chỗ đã đặt
            this.dsGhe = new ArrayList<>(this.trangDatVe.gheDao.layDSGheDat());

            // Phải đăng nhập mới cho đặt vé
            if (this.trangDatVe.layMaNV() == null) {
                hienThiThongBao("Chưa có đăng nhập!", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Phải có danh sách khách đặt vé
            if (dsKhDatVe == null) {
                hienThiThongBao("Chưa có thông tin khách hàng !", "Lỗi đặt véNV0173", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Phải đặt ghế trước đã rồi mới đặt vé
            if (dsGhe.isEmpty()) {
                hienThiThongBao("Chưa có đặt ghế !", "Lỗi đặt ghế", JOptionPane.ERROR_MESSAGE);
                return;
            }

            System.out.println("Sai o day 1");

            KhachHang kh = null;
            for (int i = 0 ; i < dsKhDatVe.size() ; i++) {
                if (dsKhDatVe.get(i).getMaKH().equals(this.trangDatVe.thanhChonKhachHang.getSelectedItem())) {
                    kh = dsKhDatVe.get(i);
                }
            }

            if (!this.trangDatVe.veDao.layDSVeDat().isEmpty()) {
                for (int i = 0 ; i < this.trangDatVe.veDao.layDSVeDat().size() ; i++) {
                    if (this.trangDatVe.veDao.layDSVeDat().get(i).getMaKhachHang().equals(kh.getMaKH())) {
                        hienThiThongBao("Vé đã có khách hàng này!", "Lỗi đặt vé", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            //String hoTen = dsKhDatVe.get(bienSoTang).getTenKH(); // Lấy họ tên
            //String sdt = dsKhDatVe.get(bienSoTang).getSoDT(); // lấy số điện thoại
            //String email = dsKhDatVe.get(bienSoTang).getEmail(); // lấy email

            // Đặt cho khách hàng tiếp theo
            /*if (bienSoTang + 1 < dsKhDatVe.size()) {  // Thay đổi ở đây
                this.trangDatVe.thanhNhapHoTen.setText(dsKhDatVe.get(bienSoTang + 1).getTenKH());
                this.trangDatVe.thanhNhapDienThoai.setText(dsKhDatVe.get(bienSoTang + 1).getSoDT());
                this.trangDatVe.thanhNhapThuDienTu.setText(dsKhDatVe.get(bienSoTang + 1).getEmail());
            } else if (bienSoTang + 1 == dsKhDatVe.size()) {
                this.trangDatVe.thanhNhapHoTen.setText("");
                this.trangDatVe.thanhNhapDienThoai.setText("");
                this.trangDatVe.thanhNhapThuDienTu.setText("");
            }*/

            // Lấy giới tính
            /*GIOI_TINH gioiTinh = dsKhDatVe.get(bienSoTang).getGioiTinh();

            // Đặt cho các nút lựa chọn giới
            if (gioiTinh.getValue().equals("Nam")) {
                this.trangDatVe.nutLuaChonNam.setSelected(true);
                this.trangDatVe.nutLuaChonNu.setSelected(false);
            } else {
                this.trangDatVe.nutLuaChonNam.setSelected(false);
                this.trangDatVe.nutLuaChonNu.setSelected(true);
            }*/

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

            Ghe daDat = this.trangDatVe.gheDao.traGheChon(); // lấy ghế đã đặt

            // Quan trọng !!!!
            for (Ghe ghe : this.trangDatVe.gheDao.layDSGheDat()) {
                if (ghe.getMaGhe() == this.trangDatVe.gheDao.layThuTuGheDat().get(bienSoTang)) {
                    daDat = ghe;
                }
            }

            // Nhớ là để comment khi không dùng nữa 🤡
            /*for (Ghe ghe: this.trangDatVe.gheDao.layDSGheDat()) {
                System.out.println("dsChoDaDat: " + ghe.getMaGhe());
            }*/

            String maToa = daDat.getMaToa(); // Lấy mã toa
            String soGhe = daDat.getSoGhe(); // Lấy số ghế
            String loaiDoiTuong = (String) this.trangDatVe.thanhCacLoaiDoiTuong.getSelectedItem(); // Lấy loại đối tượng

            String soHieuTau = Toa_DAO.layToaTheoMaToa(maToa).getSoHieu(); // Lấy số hiệu tàu đã chọn
            LichCapBenGa lich = this.trangDatVe.lichDao.ChonTheoSoHieuNgayKHVaGa(soHieuTau, ngayKhoiHanh, maGa); // Lấy lịch tàu đó

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
                    kh.getMaKH(),// Mã khách hàng
                    daDat.getMaGhe(),                                             // Mã ghế
                    daDat.getLoaiGhe().toString()                                 // Loại ghế
            );

            // Nhớ là để comment khi không dùng nữa 🤡
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
                    kh.getTenKH(),                                                          // Họ tên khách hàng
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
            this.trangDatVe.veDao.layDSVeDat().add(veDat);

            // Nhớ là để comment khi không dùng nữa 🤡
            /*for (int i = 0 ; i < this.trangDatVe.veDao.layDSVeDat().size(); i++) {
                System.out.println(this.trangDatVe.veDao.layDSVeDat().get(i).getMaVe());
            }*/

            // Tăng đơn vị
            this.bienSoTang++;
            System.out.println("Bien so tang SAU CUNG: " + this.bienSoTang);
        }

        if (e.getSource() == this.trangDatVe.nutThanhToan) {

            // Phải đăng nhập mới cho thanh toán vé
            if (this.trangDatVe.layMaNV() == null) {
                hienThiThongBao("Chưa có đăng nhập!", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Nếu danh sách vé rỗng
            if (this.trangDatVe.veDao.layDSVeDat().isEmpty()) {
                hienThiThongBao("Danh sách vé rỗng!", "Lỗi đặt vé", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Thông báo không cho thanh toán nếu chưa đặt vé xong
            if (this.trangDatVe.veDao.layDSVeDat().size() != this.trangDatVe.dsKHDatVe.size()) {
                hienThiThongBao("Chưa đặt vé xong!", "Lỗi đặt vé", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Khởi tạo trang thanh toán
            TrangThanhToan trangThanhToan = new TrangThanhToan(this.trangDatVe, this.trangDatVe.veDao.layDSVeDat(), this.trangDatVe.dsKHDatVe, this.dsGhe);
            trangThanhToan.setVisible(true);

            // Thiết lập mã nhân viên tạo vé
            trangThanhToan.datMaNV(this.trangDatVe.layMaNV());

            bienSoTang = 0;
        }

        // Nếu là chọn nút in vé
        if (e.getSource() == this.trangDatVe.nutInVe) {
            // Thông báo nếu chưa thanh toán vé và thoát
            if (!this.trangDatVe.daThanhToan) {
                hienThiThongBao("Chưa được in vé khi chưa thanh toán", "Lỗi thanh toán", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Lấy danh sách vé đặt
            List<Ve> dsVe = this.trangDatVe.veDao.layDSVeDaThanhToan();
            List<KhachHang> dsKh = new ArrayList<>(this.trangDatVe.layDSKhDatVe());
            this.trangDatVe.layDSKhDatVe().clear();

            // Khởi tạo trang in vé với các giá trị truyền vào
            TrangInVe trangInVe = new TrangInVe(dsVe, dsKh, this.dsGhe);
            trangInVe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            trangInVe.setVisible(true);

            /*if (!trangInVe.isActive()) {
                System.out.println("Hu xoa ds ve");
                this.trangDatVe.veDao.xoaDSVeDat();
                //this.dsVeDaDat.clear();
                System.out.println("Hu xoa ds ghe");
                this.trangDatVe.gheDao.xoaDSGheChon();
            }*/

            this.trangDatVe.daThanhToan = false;

            //bienSoTang = 0;
        }

        if (e.getSource() == this.trangDatVe.nutXoaVe) {
            if (this.trangDatVe.bangVeDangDat.getSelectedRow() == -1) {
                hienThiThongBao("Chưa chọn vé để xóa", "Lỗi chọn vé", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String maVe = (String) this.trangDatVe.moHinhBang.getValueAt(this.trangDatVe.bangVeDangDat.getSelectedRow(), 1);

            for (int i = 0 ; i < this.trangDatVe.veDao.layDSVeDat().size() ; i++) {
                if (maVe.equals(this.trangDatVe.veDao.layDSVeDat().get(i).getMaVe())) {
                    this.trangDatVe.veDao.layDSVeDat().remove(this.trangDatVe.veDao.layDSVeDat().get(i));
                }
            }

            this.trangDatVe.moHinhBang.removeRow(this.trangDatVe.bangVeDangDat.getSelectedRow());

            this.bienSoTang--;

            hienThiThongBao("Xóa vé đặt thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            //String loaiGheDaChon = (String) e.getItem();

            // Kiểm tra việc chọn điểm đi và điểm đến
            if (this.trangDatVe.thanhCacDiemDen.getSelectedItem().equals(this.trangDatVe.thanhCacDiemDi.getSelectedItem())) {
                hienThiThongBao("Điểm đi và điểm đến không được trùng", "Lỗi chọn địa điểm", JOptionPane.ERROR_MESSAGE);
            }

            if (!this.trangDatVe.layDSKhDatVe().isEmpty()) {
                for (int i = 0 ; i < this.trangDatVe.layDSKhDatVe().size() ; i++) {
                    if (this.trangDatVe.thanhChonKhachHang.getSelectedItem().equals(this.trangDatVe.layDSKhDatVe().get(i).getMaKH())) {
                        this.trangDatVe.thanhNhapHoTen.setText(this.trangDatVe.layDSKhDatVe().get(i).getTenKH());
                        this.trangDatVe.thanhNhapDienThoai.setText(this.trangDatVe.layDSKhDatVe().get(i).getSoDT());

                        GIOI_TINH gioiTinh = ((TrangDatVe) TrangDinhHuong.getTrangChua().getComponent(1)).dsKHDatVe.get(0).getGioiTinh();

                        if (gioiTinh.getValue().equals("Nam")) {
                            this.trangDatVe.nutLuaChonNam.setSelected(true);
                            this.trangDatVe.nutLuaChonNu.setSelected(false);
                        } else {
                            this.trangDatVe.nutLuaChonNam.setSelected(false);
                            this.trangDatVe.nutLuaChonNu.setSelected(true);
                        }

                        this.trangDatVe.thanhNhapThuDienTu.setText(this.trangDatVe.layDSKhDatVe().get(i).getEmail());
                    }
                }
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
        GanAmThanh.playSound();

        // Kiểm tra thay đổi thực sự của ngày
        if (evt.getOldValue() != evt.getNewValue()) {
            //LocalDate ngayDi = layNgay(this.trangDatVe.thanhNhapNgayDi); // Lấy ngày đi tại thời điểm thay đổi
            //LocalDate ngayTroVe = layNgay(this.trangDatVe.thanhNhapNgayTroVe); // Lấy ngày trở về tại thời điểm thay đổi

            // Kiểm tra ngày đi hợp lệ
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
        LocalDate ngayDi = layNgay(this.trangDatVe.thanhNhapNgayDi); // Lấy ngày đi từ JDateChooser
        LocalDate ngayHienTai = LocalDate.now(); // Ngày hiện tại

        // Kiểm tra nếu ngày đi không hợp lệ (trước ngày hiện tại)
        if (!ngayDi.isAfter(ngayHienTai) && !ngayDi.equals(ngayHienTai)) {
            if (!isErrorDialogVisible) {
                hienThiThongBao("Ngày đi phải sau Ngày hiện tại.", "Lỗi chọn ngày đi", JOptionPane.ERROR_MESSAGE);
                isErrorDialogVisible = true; // Để tránh hiện lên nhiều lần
            }

            khonglonHonHoacBangNgayHienTai = true; // Đặt nếu ngày chọn là trước ngày hiện tại
        }
        // Kiểm tra nếu ngày đi cách quá 2 ngày
        else if (ChronoUnit.DAYS.between(ngayHienTai, ngayDi) > 2) {
            if (!isErrorDialogVisible) {
                hienThiThongBao("Ngày đi không được cách quá 2 ngày so với ngày hiện tại.", "Lỗi chọn ngày đi", JOptionPane.ERROR_MESSAGE);
                isErrorDialogVisible = true; // Để tránh hiện lên nhiều lần
            }

            khongQuaBaNgaySoVoiHienTai = true; // Đặt nếu ngày chọn không quá 3 ngày
        }
        // Ngày đi hợp lệ
        else {
            // Giữ nguyên mặc định
            khonglonHonHoacBangNgayHienTai = false;
            khongQuaBaNgaySoVoiHienTai = false;
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
        // Khởi tạo JLabel
        JLabel thongBao = new JLabel(chuThich);
        thongBao.setFont(this.trangDatVe.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));

        // Khởi tạo JOptionPane
        JOptionPane hienThiLoi = new JOptionPane(thongBao, message);
        hienThiLoi.setForeground(this.trangDatVe.xanhBrandeis);

        // Khởi tạo JDialog
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
