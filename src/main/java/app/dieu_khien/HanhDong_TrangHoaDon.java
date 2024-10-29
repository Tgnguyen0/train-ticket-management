package app.dieu_khien;
import app.Dao.HoaDon_DAO;
import app.giao_dien.*;
import app.thuc_the.HoaDon;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Timer;

public class HanhDong_TrangHoaDon implements ActionListener, MouseListener, ItemListener {
    TrangHoaDon trangHoaDon ;
    HoaDon_DAO hoaDon_dao = new HoaDon_DAO();

    public HanhDong_TrangHoaDon(TrangHoaDon trangHoaDon) {
        this.trangHoaDon = trangHoaDon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == this.trangHoaDon.buttonChiTiet) {
            JFrame chiTietlHoaDon = new JFrame();
            chiTietlHoaDon.setSize(600, 500);
            chiTietlHoaDon.getContentPane().setBackground(new Color(0, 112, 255)); // Đặt màu nền xanh dương

            // Tạo tiêu đề
            JLabel detailTitle = new JLabel("CHI TIẾT HÓA ĐƠN", SwingConstants.CENTER);
            detailTitle.setFont(new Font("Serif", Font.BOLD, 28)); // Font lớn hơn
            detailTitle.setForeground(Color.WHITE); // Màu chữ trắng
            detailTitle.setBounds(150, 10, 300, 30);

            // Các thành phần khác như mã hóa đơn, ngày mua, tên khách hàng, trạng thái
            JLabel lblMaHoaDon = new JLabel("Mã Hóa Đơn:");
            lblMaHoaDon.setForeground(Color.WHITE); // Màu chữ trắng
            lblMaHoaDon.setBounds(50, 60, 100, 25);
            JTextField txtMaHoaDon = new JTextField();
            txtMaHoaDon.setBounds(150, 60, 150, 25);

            JLabel lblMaKhachHang = new JLabel("Mã Khách Hàng:");
            lblMaKhachHang.setForeground(Color.WHITE); // Màu chữ trắng
            lblMaKhachHang.setBounds(350, 60, 100, 25);
            JTextField txtMaKhachHang = new JTextField();
            txtMaKhachHang.setBounds(450, 60, 100, 25);

            JLabel lblNgayLap = new JLabel("Ngày Lập:");
            lblNgayLap.setForeground(Color.WHITE); // Màu chữ trắng
            lblNgayLap.setBounds(50, 100, 100, 25);
            JTextField txtNgayLap = new JTextField();
            txtNgayLap.setBounds(150, 100, 150, 25);

            JLabel lblSoLuong = new JLabel("Số Lượng:");
            lblSoLuong.setForeground(Color.WHITE); // Màu chữ trắng
            lblSoLuong.setBounds(350, 100, 100, 25);
            JTextField txtSoLuong = new JTextField();
            txtSoLuong.setBounds(450, 100, 100, 25);


            JLabel lblMaNhanVien = new JLabel("Mã Nhân Viên:");
            lblMaNhanVien.setForeground(Color.WHITE); // Màu chữ trắng
            lblMaNhanVien.setBounds(50, 140, 100, 25);
            JTextField txtMaNhanVien = new JTextField();
            txtMaNhanVien.setBounds(150, 140, 150, 25);

            JLabel lblTrangThai = new JLabel("Trạng Thái:");
            lblTrangThai.setForeground(Color.WHITE); // Màu chữ trắng
            lblTrangThai.setBounds(350, 140, 100, 25);
            JTextField txtTrangThai = new JTextField();
            txtTrangThai.setBounds(450, 140, 100, 25);

            //
            JPanel panelPhanCach = new JPanel();
            panelPhanCach.setBackground(Color.white);
            JLabel titlePhanCach = new JLabel("Thông tin thanh toán", SwingConstants.CENTER);
            titlePhanCach.setFont(new Font("Serif", Font.BOLD, 16));
            titlePhanCach.setForeground(Color.RED);
            panelPhanCach.setBounds(0, 210, 600, 30);

            // Thông tin tổng cộng, khuyến mãi, thuế, tổng tiền
            JLabel lblTongCong = new JLabel("Tổng cộng:");
            lblTongCong.setForeground(Color.WHITE);
            lblTongCong.setFont(new Font("Serif", Font.BOLD, 14));
            lblTongCong.setBounds(100, 270, 150, 25);
            JTextField txtTongCong = new JTextField();
            txtTongCong.setBounds(365, 270, 150, 25);

            JLabel lblKhuyenMai = new JLabel("Khuyến mãi (%):");
            lblKhuyenMai.setForeground(Color.WHITE);
            lblKhuyenMai.setFont(new Font("Serif", Font.BOLD, 14));
            lblKhuyenMai.setBounds(100, 310, 150, 25);
            JTextField txtKhuyenMai = new JTextField();
            txtKhuyenMai.setBounds(365, 310, 150, 25);

            JLabel lblThue = new JLabel("Thuế (VAT) %:");
            lblThue.setForeground(Color.WHITE);
            lblThue.setFont(new Font("Serif", Font.BOLD, 14));
            lblThue.setBounds(100, 350, 150, 25);
            JTextField txtThue = new JTextField();
            txtThue.setBounds(365, 350, 150, 25);

            JLabel lblTongTien = new JLabel("Tổng tiền (VND):");
            lblTongTien.setForeground(Color.WHITE);
            lblTongTien.setFont(new Font("Serif", Font.BOLD, 20));
            lblTongTien.setBounds(100, 400, 150, 25);
            JTextField txtTongTien = new JTextField();
            txtTongTien.setBounds(365, 400, 150, 25);

            // Thêm tất cả các thành phần vào frame
            chiTietlHoaDon.add(detailTitle);
            chiTietlHoaDon.add(lblMaHoaDon);
            chiTietlHoaDon.add(txtMaHoaDon);
            chiTietlHoaDon.add(lblNgayLap);
            chiTietlHoaDon.add(txtNgayLap);
            chiTietlHoaDon.add(lblMaKhachHang);
            chiTietlHoaDon.add(txtMaKhachHang);
            chiTietlHoaDon.add(lblSoLuong);
            chiTietlHoaDon.add(txtSoLuong);
            chiTietlHoaDon.add(lblMaNhanVien);
            chiTietlHoaDon.add(txtMaNhanVien);
            chiTietlHoaDon.add(lblTrangThai);
            chiTietlHoaDon.add(txtTrangThai);
            chiTietlHoaDon.add(lblTongCong);
            chiTietlHoaDon.add(txtTongCong);
            chiTietlHoaDon.add(lblKhuyenMai);
            chiTietlHoaDon.add(txtKhuyenMai);
            chiTietlHoaDon.add(lblThue);
            chiTietlHoaDon.add(txtThue);
            chiTietlHoaDon.add(lblTongTien);
            chiTietlHoaDon.add(txtTongTien);
            panelPhanCach.add(titlePhanCach);
            chiTietlHoaDon.add(panelPhanCach);


            // Cài đặt layout và hiển thị frame
            chiTietlHoaDon.setLayout(null);
            chiTietlHoaDon.setLocationRelativeTo(null); // Đặt JFrame ở giữa màn hình
            chiTietlHoaDon.setVisible(true);
        }else if (source == this.trangHoaDon.buttonTimKiem) {
            String maHD = this.trangHoaDon.tfTimKiem.getText().trim();
            String maKH = this.trangHoaDon.tfTimKiem.getText().trim();

            // Kiểm tra xem có nhập mã hóa đơn hoặc mã khách hàng không
            if (maHD.isEmpty() && maKH.isEmpty()) {
                UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 16)); // Đặt font chữ lớn hơn

                JOptionPane.showMessageDialog(this.trangHoaDon, "Vui lòng nhập Mã Hóa Đơn hoặc Mã Khách Hàng để tìm kiếm", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return; // Kết thúc nếu không có dữ liệu
            }

            List<HoaDon> ketQuaTimKiem = hoaDon_dao.TimKiemHoaDon(maHD, maKH);

            // Kiểm tra xem có tìm thấy hóa đơn nào không
            if (ketQuaTimKiem.isEmpty()) {
                JOptionPane.showMessageDialog(this.trangHoaDon, "Mã Hóa Đơn không tồn tại, Vui lòng Nhập Lại", "Thông báo", JOptionPane.ERROR_MESSAGE);
                trangHoaDon.tfTimKiem.setText("");
            } else {
                // Cập nhật JTable với kết quả tìm kiếm
                DefaultTableModel model = (DefaultTableModel) this.trangHoaDon.tableDanhSach.getModel();
                model.setRowCount(0); // Xóa dữ liệu cũ

                int stt = 1;
                for (HoaDon o : ketQuaTimKiem) {
                    model.addRow(new Object[]{
                            stt++,
                            o.getMaHD(),
                            o.getMaKH(),
                            o.getThanhTien(),
                            o.getNgayLap(),
                            o.getSoLuong(),
                            o.getTongTien(),
                            o.getTrangThai(),
                            o.getMaNV()
                    });
                }
            }
        } else if (source == trangHoaDon.buttonLamMoi) {
            trangHoaDon.lamMoiDuLieu();

            UIManager.put("OptionPane.background", new Color(0, 112, 255)); // Màu nền #0070FF
            UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 16)); // Đặt font chữ lớn hơn

            JOptionPane.showMessageDialog(this.trangHoaDon, "Làm mới dữ liệu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }

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
