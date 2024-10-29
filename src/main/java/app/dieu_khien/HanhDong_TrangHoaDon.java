package app.dieu_khien;
import app.giao_dien.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
public class HanhDong_TrangHoaDon implements ActionListener, MouseListener, ItemListener {
    TrangHoaDon trangHoaDon ;

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
            JLabel detailTitle = new JLabel("Chi tiết hóa đơn", SwingConstants.CENTER);
            detailTitle.setFont(new Font("Serif", Font.BOLD, 28)); // Font lớn hơn
            detailTitle.setForeground(Color.WHITE); // Màu chữ trắng
            detailTitle.setBounds(150, 10, 300, 30);

            // Các thành phần khác như mã hóa đơn, ngày mua, tên khách hàng, trạng thái
            JLabel lblMaHoaDon = new JLabel("Mã hóa đơn:");
            lblMaHoaDon.setForeground(Color.WHITE); // Màu chữ trắng
            lblMaHoaDon.setBounds(50, 60, 100, 25);
            JTextField txtMaHoaDon = new JTextField();
            txtMaHoaDon.setBounds(150, 60, 150, 25);

            JLabel lblNgayMua = new JLabel("Ngày mua:");
            lblNgayMua.setForeground(Color.WHITE); // Màu chữ trắng
            lblNgayMua.setBounds(350, 60, 100, 25);
            JTextField txtNgayMua = new JTextField();
            txtNgayMua.setBounds(450, 60, 100, 25);

            JLabel lblTenKhachHang = new JLabel("Tên khách hàng:");
            lblTenKhachHang.setForeground(Color.WHITE); // Màu chữ trắng
            lblTenKhachHang.setBounds(50, 100, 100, 25);
            JTextField txtTenKhachHang = new JTextField();
            txtTenKhachHang.setBounds(150, 100, 150, 25);

            JLabel lblTrangThai = new JLabel("Trạng thái:");
            lblTrangThai.setForeground(Color.WHITE); // Màu chữ trắng
            lblTrangThai.setBounds(350, 100, 100, 25);
            JTextField txtTrangThai = new JTextField();
            txtTrangThai.setBounds(450, 100, 100, 25);

            // Bảng hiển thị thông tin hóa đơn
            String[] columnNames = {"STT", "Loại ghế", "Loại vé", "Điểm đi", "Điểm đến", "Đơn giá", "Số lượng", "Thành tiền"};
            Object[][] data = {
                    {"1", "Giường toa 4", "Người lớn", "Gò Vấp", "Hà Nội", "480,000", "2", "960,000"},
                    {"2", "Giường toa 4", "Trẻ em", "Gò Vấp", "Hà Nội", "430,000", "2", "860,000"}
            };

            DefaultTableModel model= new DefaultTableModel(data, columnNames){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            JTable detailTable = new JTable(model);
            detailTable.setForeground(Color.black); // Màu chữ trắng
            JScrollPane detailscrollPane = new JScrollPane(detailTable);
            detailscrollPane.setBounds(20, 150, 550, 100);
            detailTable.setFillsViewportHeight(true); // Đảm bảo bảng lấp đầy khu vực hiển thị

            chiTietlHoaDon.add(detailscrollPane);

            // Thông tin tổng cộng, khuyến mãi, thuế, tổng tiền
            JLabel lblTongCong = new JLabel("Tổng cộng:");
            lblTongCong.setForeground(Color.WHITE);
            lblTongCong.setBounds(50, 270, 150, 25);
            JTextField txtTongCong = new JTextField();
            txtTongCong.setBounds(300, 270, 150, 25);

            JLabel lblKhuyenMai = new JLabel("Khuyến mãi (giảm giá) %:");
            lblKhuyenMai.setForeground(Color.WHITE);
            lblKhuyenMai.setBounds(50, 310, 150, 25);
            JTextField txtKhuyenMai = new JTextField();
            txtKhuyenMai.setBounds(300, 310, 150, 25);

            JLabel lblThue = new JLabel("Thuế (VAT) %:");
            lblThue.setForeground(Color.WHITE);
            lblThue.setBounds(50, 350, 150, 25);
            JTextField txtThue = new JTextField();
            txtThue.setBounds(300, 350, 150, 25);

            JLabel lblTongTien = new JLabel("Tổng tiền (VND):");
            lblTongTien.setForeground(Color.WHITE);
            lblTongTien.setFont(new Font("Serif", Font.BOLD, 20));
            lblTongTien.setBounds(50, 400, 150, 25);
            JTextField txtTongTien = new JTextField();
            txtTongTien.setBounds(300, 400, 150, 25);

            // Thêm tất cả các thành phần vào frame
            chiTietlHoaDon.add(detailTitle);
            chiTietlHoaDon.add(lblMaHoaDon);
            chiTietlHoaDon.add(txtMaHoaDon);
            chiTietlHoaDon.add(lblNgayMua);
            chiTietlHoaDon.add(txtNgayMua);
            chiTietlHoaDon.add(lblTenKhachHang);
            chiTietlHoaDon.add(txtTenKhachHang);
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

            // Cài đặt layout và hiển thị frame
            chiTietlHoaDon.setLayout(null);
            chiTietlHoaDon.setLocationRelativeTo(null); // Đặt JFrame ở giữa màn hình
            chiTietlHoaDon.setVisible(true);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        e.getSource();

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
