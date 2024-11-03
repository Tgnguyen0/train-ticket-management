package app.dieu_khien;

import app.dao.KhachHang_DAO;
import app.giao_dien.*;
import app.phan_tu_tuy_chinh.TaoVeBangFilePDF;
import app.thuc_the.*;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        this.dsVeDaDat = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

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

        if (source == this.trangDatVe.nutHienThiSoDoGhe) {
            LocalDateTime ngayKhoiHanh = trangDatVe.thanhNhapNgayDi.getDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            String maGa = this.trangDatVe.gaDao.ChonTheoTen( (String) this.trangDatVe.thanhCacDiemDi.getSelectedItem()).getMaGa();

            List<LichCapBenGa> dsLich = this.trangDatVe.lichDao.ChonTheoNgayKHVaGa(ngayKhoiHanh, maGa);

            this.trangCacTau = new TrangCacTau(this.trangDatVe.layDSTau(), this.trangDatVe.layGheDao(), dsLich);
            trangCacTau.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            trangCacTau.setVisible(true);
        }

//        if (this.trangCacTau.laySoHieuTauChon() != null) {
//            this.trangDatVe.soHieuDaChon = this.trangCacTau.laySoHieuTauChon();
//        } else {
//            this.trangDatVe.soHieuDaChon = null;
//        }

        if (source == this.trangDatVe.nutXacNhan) {
            List<KhachHang> dsKhDatVe = this.trangDatVe.layDSKhDatVe();

            String hoTen = dsKhDatVe.get(bienSoTang).getTenKH();
            String sdt = dsKhDatVe.get(bienSoTang).getSoDT();
            String email = dsKhDatVe.get(bienSoTang).getEmail();

            if (bienSoTang < dsKhDatVe.size()) {
                this.trangDatVe.thanhNhapHoTen.setText(dsKhDatVe.get(bienSoTang + 1).getTenKH());
                this.trangDatVe.thanhNhapDienThoai.setText(dsKhDatVe.get(bienSoTang + 1).getSoDT());
                this.trangDatVe.thanhNhapThuDienTu.setText(dsKhDatVe.get(bienSoTang + 1).getEmail());
            }

            GIOI_TINH gioiTinh = dsKhDatVe.get(bienSoTang).getGioiTinh();

            if (gioiTinh.getValue().equals("Nam")) {
                this.trangDatVe.nutLuaChonNam.setSelected(true);
                this.trangDatVe.nutLuaChonNu.setSelected(false);
            } else {
                this.trangDatVe.nutLuaChonNam.setSelected(false);
                this.trangDatVe.nutLuaChonNu.setSelected(true);
            }

            String diemDi = (String) trangDatVe.thanhCacDiemDi.getSelectedItem();
            String diemDen = (String) trangDatVe.thanhCacDiemDen.getSelectedItem();
            String loaiVe = trangDatVe.nutLuaChonKhuHoi.isSelected() ? "Khu Hoi" : "Mot Chieu";

            LocalDateTime ngayKhoiHanh = trangDatVe.thanhNhapNgayDi.getDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            LocalDateTime ngayTroVe = trangDatVe.thanhNhapNgayTroVe.getDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            List<Ghe> dsChoDaDat = new ArrayList<>(this.trangDatVe.gheDao.layDSGheDat());

            String soHieuTau = this.trangDatVe.soHieuDaChon;
            String maToa = dsChoDaDat.get(bienSoTang).getMaToa();
            String soGhe = dsChoDaDat.get(bienSoTang).getSoGhe();
            String loaiDoiTuong = (String) this.trangDatVe.thanhCacLoaiDoiTuong.getSelectedItem();

            // Tính toán giá vé
            int khoangCach = this.trangDatVe.gaDao.luocDoKhoangCach.get(diemDen) - this.trangDatVe.gaDao.luocDoKhoangCach.get(diemDi);
            int giaCoBan = this.trangDatVe.veDao.giaVeCoBan.get(dsChoDaDat.get(bienSoTang).getLoaiGhe().toString()).get(loaiDoiTuong);
            double giaVe = khoangCach * giaCoBan;

            // Khởi tạo đối tượng vé
            this.ve = new Ve(loaiDoiTuong, ngayKhoiHanh, ngayTroVe, diemDi, diemDen, giaVe, this.trangDatVe.dsKHDatVe.get(bienSoTang).getMaKH(), dsChoDaDat.get(bienSoTang).getMaGhe(), dsChoDaDat.get(bienSoTang).getLoaiGhe().toString());

            // Dòng dữ liệu
            Object[] duLieu = {String.valueOf(bienSoTang + 1), ve.getMaVe(), hoTen, ve.getLoaiDoiTuong(), (int) ve.getGiaVe(), ve.getGaKhoiHanh(), ve.getGaKetThuc(), LocalDate.now(), ve.getNgayKhoiHanh().toString(), ve.getNgayDatVe(), soHieuTau, "10:00AM", ve.getLoaiVe().toString(), maToa, soGhe};

            // Thêm vào bảng
            this.trangDatVe.moHinhBang.addRow(duLieu);

            // Thêm vào danh sách vé đã đặt
            dsVeDaDat.add(ve);

            this.bienSoTang++;
        }
        if (e.getSource() == this.trangDatVe.nutThanhToan) {
            // Lấy model của JTable trong TrangDatVe
            DefaultTableModel modelDatVe = (DefaultTableModel) this.trangDatVe.bangVeDangDat.getModel();

            // Tạo danh sách để lưu các vé
            List<Ve> danhSachVe = new ArrayList<>();

//            // Duyệt qua các dòng của modelDatVe và thêm vào danh sách
//            for (int i = 0; i < modelDatVe.getRowCount(); i++) {
//                Ve ve = new Ve();
//
//                ve.setMaKhachHang(modelDatVe.getValueAt(i, 1).toString());
//                ve.setLoaiDoiTuong(modelDatVe.getValueAt(i, 2).toString());
//                ve.setLoaiVe(modelDatVe.getValueAt(i, 9).toString()); // Sửa index phù hợp
//                ve.setMaGhe(modelDatVe.getValueAt(i, 11).toString());  // Sửa index phù hợp
//                ve.setGiaVe(Float.parseFloat(modelDatVe.getValueAt(i, 4).toString()));
//
//                danhSachVe.add(ve);
//            }

            // Tạo đối tượng TrangThanhToan và truyền danh sách vé qua
            TrangThanhToan trangThanhToan = new TrangThanhToan(danhSachVe);
            trangThanhToan.setVisible(true);

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
                    ve.setNgayKhoiHanh(LocalDateTime.now().plusDays(5)); // Ngày khởi hành sau 5 ngày từ hiện tại
                    ve.setNgayDatVe(LocalDateTime.now());                // Ngày đặt vé là hôm nay
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

    private LocalDate layNgay(JDateChooser dateChooser) {
        Date date = dateChooser.getDate(); // Lấy giá trị từ dateChooser
        if (date == null) {
            // Nếu date là null, trả về giá trị mặc định (hoặc có thể xử lý theo cách khác tùy thuộc vào logic của bạn)
            return LocalDate.now(); // Hoặc một giá trị phù hợp khác
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
