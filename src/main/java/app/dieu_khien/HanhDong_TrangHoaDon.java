package app.dieu_khien;

import app.dao.HoaDon_DAO;
import app.giao_dien.*;
import app.phan_tu_tuy_chinh.GanAmThanh;
import app.phan_tu_tuy_chinh.TaoHoaDonFilePDF;
import app.thuc_the.HoaDon;
import app.thuc_the.KhachHang;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

public class HanhDong_TrangHoaDon implements ActionListener, MouseListener, ItemListener {
    TrangHoaDon trangHoaDon ;
    HoaDon_DAO hoaDon_dao = new HoaDon_DAO();
    Logger logger = LoggerFactory.getLogger(HanhDong_TrangHoaDon.class);
    List<HoaDon> ketQuaTimKiem;

    public HanhDong_TrangHoaDon(TrangHoaDon trangHoaDon) {
        this.trangHoaDon = trangHoaDon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        GanAmThanh.playSound();

        if (source == this.trangHoaDon.buttonChiTiet) {
            int selectedRow = trangHoaDon.tableDanhSach.getSelectedRow();

            // Kiểm tra nếu có hàng nào được chọn
            if (selectedRow != -1) {
                // Lấy mã hóa đơn và tên khách hàng từ hàng được chọn
                String maHD = (String) trangHoaDon.tableDanhSach.getValueAt(selectedRow, 1); // Giả sử mã hóa đơn ở cột 1
                String tenKH = (String) trangHoaDon.tableDanhSach.getValueAt(selectedRow, 2); // Giả sử tên khách hàng ở cột 2

                // Gọi phương thức TimKiemHoaDon với mã hóa đơn và tên khách hàng
                List<HoaDon> ketQua = null;
                try {
                    ketQua = hoaDon_dao.TimKiemHoaDon(maHD, tenKH);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                //List<HoaDon> ketQua = hoaDon_dao.ChonTheoMaHD(maHD);

                // Kiểm tra nếu tìm thấy kết quả
                if (!ketQua.isEmpty()) {
                    // Lấy hóa đơn đầu tiên từ kết quả tìm kiếm (giả sử kết quả duy nhất)
                    HoaDon hoaDon = ketQua.get(0);

                    // Mở trang chi tiết hóa đơn với dữ liệu chính xác
                    TrangXemThuHoaDon xemThuHoaDon = new TrangXemThuHoaDon(hoaDon);
                    xemThuHoaDon.setVisible(true);
                } else if (this.trangHoaDon.hdTao != null) {
                    TrangXemThuHoaDon xemThuHoaDon = new TrangXemThuHoaDon(this.trangHoaDon.hdTao);
                    xemThuHoaDon.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(trangHoaDon, "Hóa đơn không tồn tại hoặc đã bị xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(trangHoaDon, "Bạn chưa chọn hóa đơn!");
            }
    }else if (source == this.trangHoaDon.buttonTimKiem) {
            String maHD = this.trangHoaDon.tfTimKiem.getText().trim();
            String soDienThoai = this.trangHoaDon.tfTimKiem.getText().trim();
            // Kiểm tra xem có nhập mã hóa đơn hoặc mã khách hàng không
            if (maHD.isEmpty() && soDienThoai.isEmpty()) {
                UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 16)); // Đặt font chữ lớn hơn

                JOptionPane.showMessageDialog(this.trangHoaDon, "Vui lòng nhập Mã Hóa Đơn hoặc Mã Khách Hàng để tìm kiếm", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return; // Kết thúc nếu không có dữ liệu
            }
            try {
                ketQuaTimKiem = hoaDon_dao.TimKiemHoaDon(maHD, soDienThoai);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

//            List<HoaDon> ketQuaTimKiem = hoaDon_dao.ChonTheoMaHD(maHD);

            //
            // List<HoaDon> ketQuaTimKiem = hoaDon_dao.ChonTheoMaHDHayMaKh(maHD, maKH);


            // Kiểm tra xem có tìm thấy hóa đơn nào không
            if (ketQuaTimKiem.isEmpty()) {
                JOptionPane.showMessageDialog(this.trangHoaDon, "Mã Hóa Đơn không tồn tại, Vui lòng nhập Lại", "Thông báo", JOptionPane.ERROR_MESSAGE);
                trangHoaDon.tfTimKiem.setText("");
            } else {
                // Cập nhật JTable với kết quả tìm kiếm
                DefaultTableModel model = (DefaultTableModel) this.trangHoaDon.tableDanhSach.getModel();
                model.setRowCount(0); // Xóa dữ liệu cũ

                int stt = 1;
                for (HoaDon o : ketQuaTimKiem) {
                    model.addRow(new Object[]{
                            stt++,
                            o.getMaHoaDon(),
                            o.getMaKhachHang(),
                            o.getThanhTien(),
                            o.getNgayLapHoaDon(),
                            o.getSoLuong(),
                            o.getTongTien(),
                            o.getTrangThai(),
                            o.getMaNhanVien(),
                    });
                // Thiết lập hàng đầu tiên là được chọn
            }}
        } else if (source == trangHoaDon.buttonLamMoi) {
            trangHoaDon.lamMoiDuLieu();
            UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 16)); // Đặt font chữ lớn hơn
            JOptionPane.showMessageDialog(this.trangHoaDon, "Làm mới dữ liệu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            Object[] duLieu = {
                    this.trangHoaDon.tableDanhSach.getRowCount() + 1,
                    this.trangHoaDon.hdTao.getMaHoaDon(),
                    this.trangHoaDon.hdTao.getMaKhachHang(),
                    this.trangHoaDon.hdTao.getThanhTien(),
                    this.trangHoaDon.hdTao.getNgayLapHoaDon(),
                    this.trangHoaDon.hdTao.getSoLuong(),
                    this.trangHoaDon.hdTao.getTongTien(),
                    this.trangHoaDon.hdTao.getTrangThai(),
            };

            this.trangHoaDon.model.addRow(duLieu);

        } else if (source == trangHoaDon.buttonInHoaDon) {
            int selectedRow = trangHoaDon.tableDanhSach.getSelectedRow();
            // Nếu không click chọn hóa đơn
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(trangHoaDon, "Vui lòng chọn hóa đơn để in.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                // Nếu có hàng được chọn, hiển thị thông báo xác nhận
                int xacNhan = JOptionPane.showConfirmDialog(trangHoaDon, "Bạn có chắc chắn muốn in hóa đơn này không?", "Xác nhận in hóa đơn", JOptionPane.YES_NO_OPTION);
                //Trường hợp có
                if (xacNhan == JOptionPane.YES_OPTION) {
                    printSelectedInvoice(selectedRow);
                    JOptionPane.showMessageDialog(trangHoaDon, "In hóa đơn thành công! File hóa đơn đã được lưu.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    trangHoaDon.lamMoiDuLieu();
                } else {
                    JOptionPane.showMessageDialog(trangHoaDon, "In hóa đơn thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }else if (source == trangHoaDon.buttonInHoaDon) {
            int selectedRow = trangHoaDon.tableDanhSach.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(trangHoaDon, "Vui lòng chọn hóa đơn để in.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                int xacNhan = JOptionPane.showConfirmDialog(trangHoaDon, "Bạn có chắc chắn muốn in hóa đơn này không?", "Xác nhận in hóa đơn", JOptionPane.YES_NO_OPTION);
                if (xacNhan == JOptionPane.YES_OPTION) {
                    String maHoaDon = trangHoaDon.tableDanhSach.getValueAt(selectedRow, 1).toString(); // Lấy mã hóa đơn từ bảng
                    String trangThai = trangHoaDon.tableDanhSach.getValueAt(selectedRow, 7).toString(); // Lấy trạng thái từ bảng

                    printSelectedInvoice(selectedRow); // Thực hiện in hóa đơn

                    if ("Chưa in".equalsIgnoreCase(trangThai)) {
                        // Cập nhật trạng thái nếu là "Chưa in"
                        boolean capNhatThanhCong = hoaDon_dao.capNhatTrangThaiHoaDon(maHoaDon);
                        if (capNhatThanhCong) {
                            JOptionPane.showMessageDialog(trangHoaDon, "In hóa đơn thành công! Trạng thái đã được cập nhật.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(trangHoaDon, "Lỗi khi cập nhật trạng thái hóa đơn.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        // Nếu trạng thái đã là "Đã in", chỉ hiển thị thông báo
                        JOptionPane.showMessageDialog(trangHoaDon, "In lại hóa đơn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                    trangHoaDon.lamMoiDuLieu(); // Làm mới dữ liệu trong bảng
                } else {
                    JOptionPane.showMessageDialog(trangHoaDon, "In hóa đơn thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    public void printSelectedInvoice(int selectedRow) {
        // Lấy mã hóa đơn từ hàng đã chọn
        String maHoaDon = (String) trangHoaDon.tableDanhSach.getValueAt(selectedRow, 1); // Giả sử mã hóa đơn ở cột 1

        // Tìm hóa đơn tương ứng từ cơ sở dữ liệu
        HoaDon hoaDon = null;
        KhachHang khachHang = null;
        try {
            List<HoaDon> ketQua = hoaDon_dao.TimKiemHoaDon(maHoaDon, null); // Bạn có thể bỏ qua mã khách hàng nếu không cần thiết
            if (!ketQua.isEmpty()) {
                hoaDon = ketQua.get(0); // Giả sử chỉ có một hóa đơn cho mã này
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(trangHoaDon, "Lỗi khi tìm hóa đơn để in: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Nếu hóa đơn không tìm thấy
        if (hoaDon == null) {
            JOptionPane.showMessageDialog(trangHoaDon, "Hóa đơn không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Gọi phương thức tạo PDF
        TaoHoaDonFilePDF.createInvoicePdf(hoaDon);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        trangHoaDon.layDuLieuVaoTFNhanVien();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

