package app.giao_dien;
import javax.swing.*;
import java.awt.*;

import app.thuc_the.HoaDon;
public class TrangXemThuHoaDon extends  JDialog{
    private HoaDon hoaDon;

    public TrangXemThuHoaDon( HoaDon hoaDon) {
        super();
        super.setTitle("Xem Thông Tin Hóa Đơn");
        this.hoaDon = hoaDon;
        hienThi();
    }

    private void hienThi() {
        setLayout(new BorderLayout());

// Panel chứa thông tin hóa đơn
        JPanel thongTinHoaDon = new JPanel(new GridLayout(0, 2));
        JPanel Pntitle = new JPanel();
        Pntitle.setBackground(new Color(0,112,255));
        thongTinHoaDon.setBackground(Color.white); // Màu nền xanh
        JLabel title = new JLabel("Thông Tin Hóa Đơn");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.white);
        Pntitle.add(title);
        add(Pntitle, BorderLayout.NORTH);

        thongTinHoaDon.add(new JLabel("Mã Hóa Đơn:")).setForeground(Color.BLACK); // Nhãn mã hóa đơn
        thongTinHoaDon.add(new JLabel(hoaDon.getMaHD())).setForeground(Color.BLACK);
        thongTinHoaDon.add(new JLabel("Mã Khách Hàng:")).setForeground(Color.BLACK);
        thongTinHoaDon.add(new JLabel(hoaDon.getMaKH())).setForeground(Color.BLACK);
        thongTinHoaDon.add(new JLabel("Ngày Lập:")).setForeground(Color.BLACK);
        thongTinHoaDon.add(new JLabel(hoaDon.getNgayLap().toString())).setForeground(Color.BLACK);
        thongTinHoaDon.add(new JLabel("Số lượng:")).setForeground(Color.BLACK);
        thongTinHoaDon.add(new JLabel(String.valueOf(hoaDon.getSoLuong()))).setForeground(Color.BLACK);
        thongTinHoaDon.add(new JLabel("Trạng Thái:")).setForeground(Color.BLACK);
        thongTinHoaDon.add(new JLabel(hoaDon.getTrangThai())).setForeground(Color.BLACK);
        thongTinHoaDon.add(new JLabel("Mã Nhân Viên:")).setForeground(Color.BLACK);
        thongTinHoaDon.add(new JLabel(hoaDon.getMaNV())).setForeground(Color.BLACK);

        add(thongTinHoaDon, BorderLayout.CENTER);

        JPanel thanhToan= new JPanel(new GridLayout(0, 2));
        thanhToan.setBackground(new Color(0,112,255));

        thanhToan.add(new Label(""));
        thanhToan.add(new Label(""));
        thanhToan.add(new JLabel(" - Tổng Tiền:")).setForeground(Color.WHITE);
        thanhToan.add(new JLabel(String.valueOf(hoaDon.getTongTien() ))).setForeground(Color.WHITE);
        thanhToan.add(new Label(""));
        thanhToan.add(new Label(""));
        thanhToan.add(new JLabel(" - Đãi Ngộ:")).setForeground(Color.WHITE);
        thanhToan.add(new JLabel(String.valueOf(hoaDon.getDaiNgo()))).setForeground(Color.WHITE);
        thanhToan.add(new Label(""));
        thanhToan.add(new Label(""));
        thanhToan.add(new JLabel(" - Thuế")).setForeground(Color.WHITE);
        thanhToan.add(new JLabel(String.valueOf(hoaDon.getThue()))).setForeground(Color.WHITE);
        thanhToan.add(new Label(""));
        thanhToan.add(new Label(""));
        thanhToan.add(new JLabel(" + THÀNH TIỀN:")).setForeground(Color.WHITE);
        thanhToan.add(new JLabel(String.valueOf(hoaDon.getThanhTien()))).setForeground(Color.WHITE);
        thanhToan.add(new Label(""));
        thanhToan.add(new Label(""));
        add(thanhToan, BorderLayout.SOUTH);
        JPanel Pnwest= new JPanel();
        Pnwest.setBackground(new Color(0,112,255));
        Pnwest.setPreferredSize(new Dimension(10, 30));
        add(Pnwest, BorderLayout.WEST);
        JPanel Pneast= new JPanel();
        Pneast.setBackground(new Color(0,112,255));
        Pneast.setPreferredSize(new Dimension(10, 30));
        add(Pneast, BorderLayout.EAST);

        setSize(450, 450); // Đặt kích thước cửa sổ
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Đóng cửa sổ khi nhấn nút đỏ
    }

}


