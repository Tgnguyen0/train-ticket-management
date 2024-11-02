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
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class HanhDong_TrangDatVe implements ActionListener, MouseListener, ItemListener, PropertyChangeListener {
    public TrangDatVe trangDatVe;
    public TrangCacTau trangCacTau;
    public int bienSoTang = 0;
    public Ve ve;
    public KhachHang khachHang;
    public List<Ve> dsVeDaDat;

    public HanhDong_TrangDatVe(TrangDatVe trangDatVe) {
        this.trangDatVe = trangDatVe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == this.trangDatVe.nutHienThiSoDoGhe) {
            this.trangCacTau = new TrangCacTau(this.trangDatVe.layDSTau(), this.trangDatVe.layGheDao());
            trangCacTau.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            trangCacTau.setVisible(true);
        }

        this.trangDatVe.soHieuDaChon = this.trangCacTau.laySoHieuTauChon();

        if (source == this.trangDatVe.nutLuaChonMotChieu) {
            this.trangDatVe.nutLuaChonKhuHoi.setSelected(false);
            this.trangDatVe.thanhNhapNgayTroVe.setEnabled(false);
        }

        if (source == this.trangDatVe.nutLuaChonKhuHoi) {
            this.trangDatVe.nutLuaChonMotChieu.setSelected(false);
            this.trangDatVe.thanhNhapNgayTroVe.setEnabled(true);
        }

        if (source == this.trangDatVe.nutLuaChonMotChieu) {
            this.trangDatVe.nutLuaChonKhuHoi.setSelected(false);
        }

        if (source == this.trangDatVe.nutLuaChonNam) {
            this.trangDatVe.nutLuaChonNu.setSelected(false);
        }

        if (source == this.trangDatVe.nutLuaChonNu) {
            this.trangDatVe.nutLuaChonNam.setSelected(false);
        }

        if (source == this.trangDatVe.nutDSVe) {
            TrangDanhSachVeTau.moGiaoDienDanhSach();
        }

        if (source == this.trangDatVe.nutXacNhan) {
            String diemDi = (String) trangDatVe.thanhCacDiemDi.getSelectedItem();
            String diemDen = (String) trangDatVe.thanhCacDiemDen.getSelectedItem();
            String loaiVe = trangDatVe.nutLuaChonKhuHoi.isSelected() ? "Khu Hoi" : "Mot Chieu";

            LocalDate ngayKhoiHanh = trangDatVe.thanhNhapNgayDi
                    .getDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            LocalDate ngayTroVe = trangDatVe.thanhNhapNgayTroVe
                    .getDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            List<Ghe> dsChoDaDat = new ArrayList<>(this.trangDatVe.gheDao.layDSGheDat());

            String hoTen = this.trangDatVe.thanhNhapHoTen.getText();
            String sdt = this.trangDatVe.thanhNhapDienThoai.getText();
            String email = this.trangDatVe.thanhNhapThuDienTu.getText();

            LocalDate ngaySinh = trangDatVe.thanhNhapNgaySinh
                    .getDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            if (6 <= LocalDate.now().getYear() - ngaySinh.getYear() && LocalDate.now().getYear() - ngaySinh.getYear() <= 10) {
                this.trangDatVe.thanhLoaiDoiTuong.setText("Trẻ em");
            } else {
                this.trangDatVe.thanhLoaiDoiTuong.setText("Người lớn");
            }

            String loaiDoiTuong = this.trangDatVe.thanhLoaiDoiTuong.getText();
            GIOI_TINH gioiTinh = trangDatVe.nutLuaChonNam.isSelected() ? GIOI_TINH.NAM : GIOI_TINH.NU;
            DaiNgo daiNgo = DaiNgo.GIAMGIAKHONGPHANTRAM;
            String soHieuTau = this.trangDatVe.soHieuDaChon;
            String maToa = dsChoDaDat.get(bienSoTang).getMaToa();
            String soGhe = dsChoDaDat.get(bienSoTang).getSoGhe();

            System.out.println("Trang Dat ve" + soGhe);

            this.khachHang = new KhachHang("Nguyễn Nhật Tấn", "Ai bít", "0768558858", "nguyennhattan223344@gmail.com", GIOI_TINH.NAM);

            this.ve = new Ve(loaiDoiTuong, ngayKhoiHanh, ngayTroVe, diemDi, diemDen, 100000, (new KhachHang()).getMaKH(), dsChoDaDat.get(bienSoTang).getMaGhe(), dsChoDaDat.get(bienSoTang).getLoaiGhe().toString());

            Object[] duLieu = {String.valueOf(bienSoTang + 1), ve.getMaVe(), hoTen, ve.getLoaiDoiTuong(), ve.getGiaVe(), ve.getGaKhoiHanh(), ve.getGaKetThuc(), ve.getNgayKhoiHanh().toString(), ve.getNgayDatVe(), soHieuTau, "10:00AM", ve.getLoaiVe().toString(), maToa, soGhe};

            this.trangDatVe.moHinhBang.addRow(duLieu);

            dsVeDaDat.add(ve);

            bienSoTang++;
        }

        if (e.getSource() == this.trangDatVe.nutInVe) {
            if (this.ve.getMaVe() != null) {
                /*String maVe = this.ve.getMaVe();
                String tenKhachHang = this.khachHang.getTenKH();
                String maGhe = this.ve.getMaGhe();
                String diemDi = this.ve.getGaKhoiHanh();
                String diemDen = this.ve.getGaKetThuc();
                String loaiVe = this.ve.getLoaiVe();
                String doiTuong = this.ve.getLoaiDoiTuong();
                String ngayDatVe = this.ve.getNgayDatVe().toString();
                String ngayKhoiHanh = this.ve.getNgayKhoiHanh().toString();
                String giaVe = String.valueOf(this.ve.getGiaVe());

                TaoVeBangFilePDF taoVeBangFilePDF = new TaoVeBangFilePDF();
                taoVeBangFilePDF.generateTicketPDF("vé được tạo/VeTau.pdf", maVe, tenKhachHang, diemDi, diemDen, ngayDatVe,
                        ngayKhoiHanh, loaiVe, maGhe,doiTuong, giaVe);*/
                /*List<Ve> dsVe = new ArrayList<>();*/

                List<Ve> dsVe = new ArrayList<Ve>();/* khởi tạo danh sách các đối tượng vé */;
                dsVe.add(new Ve());
                dsVe.add(new Ve());
                dsVe.add(new Ve());
                dsVe.add(new Ve());
                dsVe.add(new Ve());
                dsVe.add(new Ve());
                dsVe.add(new Ve());
                dsVe.add(new Ve());
                dsVe.add(new Ve());

                for (int i = 0; i < dsVe.size(); i++) {
                    Ve ve = dsVe.get(i);

                    // Thiết lập các thuộc tính
                    // Mã vé giả lập
                    ve.setLoaiDoiTuong("Người lớn");                 // Loại đối tượng
                    ve.setNgayKhoiHanh(LocalDate.now().plusDays(5)); // Ngày khởi hành sau 5 ngày từ hiện tại
                    ve.setNgayDatVe(LocalDate.now());                // Ngày đặt vé là hôm nay
                    ve.setGaKhoiHanh("Hà Nội");                      // Ga khởi hành
                    ve.setGaKetThuc("Hồ Chí Minh");                  // Ga kết thúc
                    ve.setGiaVe(100000 + (i * 50000));               // Giá vé tăng dần
                    ve.setMaKhachHang("KH" + (100 + i));             // Mã khách hàng giả lập
                    ve.setMaGhe("G" + (i + 1));                      // Mã ghế
                    ve.setLoaiVe("Thường");                          // Loại vé
                }

                TrangInVe trangInVe = new TrangInVe(dsVe);
                trangInVe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                trangInVe.setVisible(true);
            } else {
                hienThiThongBao("Không có vé để in !", "Lỗi in vé");
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String loaiGheDaChon = (String) e.getItem();

            if (this.trangDatVe.thanhCacDiemDen.getSelectedItem().equals(this.trangDatVe.thanhCacDiemDi.getSelectedItem())) {
                JLabel thongBao = new JLabel("Điểm đi và điểm đến không được trùng");
                thongBao.setFont(this.trangDatVe.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));

                JOptionPane hienThiLoi = new JOptionPane(thongBao, JOptionPane.ERROR_MESSAGE);
                hienThiLoi.setForeground(this.trangDatVe.xanhBrandeis);

                JDialog hoiThoai = hienThiLoi.createDialog("Lỗi chọn địa điểm");
                ImageIcon bieuTuongTau = new ImageIcon("assets/icon.png"); // Đường dẫn đến biểu tượng
                hoiThoai.setIconImage(bieuTuongTau.getImage());
                hoiThoai.setVisible(true);
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
            LocalDate ngayTroVe = layNgay(this.trangDatVe.thanhNhapNgayTroVe); // Lấy ngày trở về tại thời điểm thay đổi

            // Check for departure date validation
            if (source == this.trangDatVe.thanhNhapNgayDi.getDateEditor() &&
                    this.trangDatVe.nutLuaChonKhuHoi.isSelected()) {
                kiemTraNgayDi();
            }

            // Check for return date validation
            if (source == this.trangDatVe.thanhNhapNgayTroVe.getDateEditor() &&
                    this.trangDatVe.nutLuaChonKhuHoi.isSelected()) {
                kiemTraNgayTroVe();
            }

            // Handle date of birth and age categorization
            if (source == this.trangDatVe.thanhNhapNgaySinh.getDateEditor()) {
                duaRaLoaiDoiTuong();
            }
        }
    }

    private void kiemTraNgayDi() {
        LocalDate ngayDi = layNgay(this.trangDatVe.thanhNhapNgayDi);
        LocalDate ngayHienTai = LocalDate.now();

        if (!ngayDi.isAfter(ngayHienTai)) {
            if (!isErrorDialogVisible) {
                hienThiThongBao("Ngày đi phải sau Ngày hiện tại.", "Lỗi chọn ngày đi");
                isErrorDialogVisible = true;
            }
        } else {
            isErrorDialogVisible = false;
        }
    }

    private void kiemTraNgayTroVe() {
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
    }

    private void hienThiThongBao(String chuThich, String tieuDe) {
        JLabel thongBao = new JLabel(chuThich);
        thongBao.setFont(this.trangDatVe.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));

        JOptionPane hienThiLoi = new JOptionPane(thongBao, JOptionPane.ERROR_MESSAGE);
        hienThiLoi.setForeground(this.trangDatVe.xanhBrandeis);

        JDialog hoiThoai = hienThiLoi.createDialog(tieuDe);
        ImageIcon bieuTuongTau = new ImageIcon("assets/icon.png");
        hoiThoai.setIconImage(bieuTuongTau.getImage());
        hoiThoai.setVisible(true);
    }

    private void duaRaLoaiDoiTuong() {
        LocalDate ngaySinh;
        LocalDate ngayHienTai = LocalDate.now();

        if (this.trangDatVe.thanhNhapNgaySinh.getDate() == null) {
            ngaySinh = ngayHienTai;
        } else {
            ngaySinh = this.trangDatVe.thanhNhapNgaySinh.getDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        }

        int tuoi = ngayHienTai.getYear() - ngaySinh.getYear();

        String loaiDoiTuong = (tuoi <= 10) ? "Trẻ em" : "Người lớn";
        this.trangDatVe.thanhLoaiDoiTuong.setText(loaiDoiTuong);
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
