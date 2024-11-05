package app.giao_dien;

import app.dao.CaTruc_DAO;
import app.dao.HoaDon_DAO;
import app.dieu_khien.HanhDong_TrangDangNhap;
import app.dieu_khien.HanhDong_TrangKetCa;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.io.Serial;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TrangKetCa extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    public  JLabel label_hienTenNV;
    public JLabel label_hienTongGiam;
    public JLabel label_hienTongVAT;
    public JLabel label_hienTongHoaDon;
    public JLabel label_hienGioKetCa;
    public JLabel label_hienGioVaoCa;
    public JLabel label_hienMaNV;
    public JLabel label_hienTongTienCaTruoc;
    public JLabel label_hienTongTienHeThong;
    public  JLabel label_hienChechLech;
    public  JButton btn_minus_1000;
    public  JButton btn_plus_1000;
    public  JButton btn_minus_2000;
    public  JButton btn_plus_2000;
    public  JButton btn_minus_5000;
    public  JTextField textField_5000;
    public  JButton btn_plus_5000;
    public  JButton btn_minus_10000;
    public  JTextField textField_10000;
    public  JButton btn_plus_10000;
    public  JButton btn_minus_20000;
    public  JTextField textField_20000;
    public  JButton btn_plus_20000;
    public  JButton btn_minus_50000;
    public  JTextField textField_50000;
    public  JButton btn_plus_50000;
    public  JButton btn_minus_100000;
    public  JTextField textField_100000;
    public  JButton btn_plus_100000;
    public  JButton btn_minus_200000;
    public  JTextField textField_200000;
    public  JButton btn_plus_200000;
    public  JButton btn_minus_500000;
    public  JTextField textField_500000;
    public  JButton btn_plus_500000;
    public  JButton btn_xacNhan;
    public  JButton btn_hoanTat;
    public JPanel contentPane;
    public JTextField textField_tienThucThu;
    public JTextField textField_1000;
    public JTextField textField_2000;
    public JTextField textField_chuyenKhoan;

    public Double tienThucThu = 0.0;
    public Double tienChuyenKhoan = 0.0;
    public int soTo1000 = 0;
    public int soTo2000 = 0;
    public int soTo5000 = 0;
    public int soTo10000 = 0;
    public int soTo20000 = 0;
    public int soTo50000 = 0;
    public int soTo100000 = 0;
    public int soTo200000 = 0;
    public int soTo500000 = 0;
    public Double tongTien = 0.0;

    public static LocalDateTime ngayGioBatDau;
    public static LocalDateTime ngayGioKetThuc;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TrangKetCa frame = new TrangKetCa();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TrangKetCa() {

        setBounds(100, 100, 963, 689);
        setLocationRelativeTo(null);
        setTitle("Kết ca");
        ImageIcon img = new ImageIcon("assets/icon.png");
        setIconImage(img.getImage());
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label_tenNhanVien = new JLabel("Nhân viên: ");
        label_tenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_tenNhanVien.setBounds(10, 10, 102, 25);
        contentPane.add(label_tenNhanVien);

        label_hienTenNV = new JLabel("<<Tên nhân viên>>");
        label_hienTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_hienTenNV.setBounds(120, 10, 287, 25);
        contentPane.add(label_hienTenNV);

        JLabel label_tongTienCaTruoc = new JLabel("Tổng tiền ca trước:");
        label_tongTienCaTruoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_tongTienCaTruoc.setBounds(10, 89, 171, 25);
        contentPane.add(label_tongTienCaTruoc);

        label_hienTongTienCaTruoc = new JLabel("<<tổng tiền ca trước>>");
        label_hienTongTienCaTruoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_hienTongTienCaTruoc.setBounds(191, 89, 216, 25);
        contentPane.add(label_hienTongTienCaTruoc);

        JLabel label_gioVaoCa = new JLabel("Giờ vào ca:");
        label_gioVaoCa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_gioVaoCa.setBounds(600, 10, 101, 25);
        contentPane.add(label_gioVaoCa);

        label_hienGioVaoCa = new JLabel("<<giờ vào ca>>");
        label_hienGioVaoCa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_hienGioVaoCa.setBounds(711, 10, 236, 25);
        contentPane.add(label_hienGioVaoCa);

        JLabel label_gioKetCa = new JLabel("Giờ kết ca:");
        label_gioKetCa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_gioKetCa.setBounds(605, 39, 96, 25);
        contentPane.add(label_gioKetCa);

        label_hienGioKetCa = new JLabel("<<giờ kết ca>>");
        label_hienGioKetCa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_hienGioKetCa.setBounds(711, 39, 236, 25);
        contentPane.add(label_hienGioKetCa);

        JPanel panel_chiTietHD = new JPanel();
        panel_chiTietHD.setBounds(10, 124, 409, 124);
        contentPane.add(panel_chiTietHD);
        panel_chiTietHD.setLayout(null);

        JLabel label_tongHoaDon = new JLabel("Tổng hoá đơn:");
        label_tongHoaDon.setBounds(0, 0, 132, 25);
        panel_chiTietHD.add(label_tongHoaDon);
        label_tongHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));

        label_hienTongHoaDon = new JLabel("<<Tổng hoá đơn>>");
        label_hienTongHoaDon.setBounds(142, 0, 182, 25);
        panel_chiTietHD.add(label_hienTongHoaDon);
        label_hienTongHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_tongTienHeThong = new JLabel("Tổng tiền hệ thống:");
        label_tongTienHeThong.setBounds(0, 29, 178, 25);
        panel_chiTietHD.add(label_tongTienHeThong);
        label_tongTienHeThong.setFont(new Font("Tahoma", Font.PLAIN, 20));

        label_hienTongTienHeThong = new JLabel("0.0");
        label_hienTongTienHeThong.setBounds(181, 29, 228, 25);
        panel_chiTietHD.add(label_hienTongTienHeThong);
        label_hienTongTienHeThong.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_tongVAT = new JLabel("Tổng thuế VAT:");
        label_tongVAT.setBounds(0, 64, 141, 25);
        panel_chiTietHD.add(label_tongVAT);
        label_tongVAT.setFont(new Font("Tahoma", Font.PLAIN, 20));

        label_hienTongVAT = new JLabel("<<tổng vat>>");
        label_hienTongVAT.setBounds(151, 64, 130, 25);
        panel_chiTietHD.add(label_hienTongVAT);
        label_hienTongVAT.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_tongGiam = new JLabel("Tổng giảm giá:");
        label_tongGiam.setBounds(0, 98, 135, 25);
        panel_chiTietHD.add(label_tongGiam);
        label_tongGiam.setFont(new Font("Tahoma", Font.PLAIN, 20));

        label_hienTongGiam = new JLabel("<<tổng tiền giảm giá>>");
        label_hienTongGiam.setBounds(142, 99, 219, 25);
        panel_chiTietHD.add(label_hienTongGiam);
        label_hienTongGiam.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_tongGiam_1 = new JLabel("Tổng tiền thực thu:");
        label_tongGiam_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_tongGiam_1.setBounds(10, 301, 173, 25);
        contentPane.add(label_tongGiam_1);

        textField_tienThucThu = new JTextField();
        textField_tienThucThu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_tienThucThu.setBounds(191, 303, 184, 25);
        contentPane.add(textField_tienThucThu);
        textField_tienThucThu.setColumns(10);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "X\u00E1c nh\u1EADn ti\u1EC1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_1.setBounds(499, 124, 448, 408);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(30, 32, 388, 347);
        panel_1.add(panel);
        panel.setLayout(null);

        JLabel label_1000d = new JLabel("Số tờ 1000đ:");
        label_1000d.setBounds(59, 0, 116, 25);
        panel.add(label_1000d);
        label_1000d.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_2000d = new JLabel("Số tờ 2000đ:");
        label_2000d.setBounds(59, 35, 116, 25);
        panel.add(label_2000d);
        label_2000d.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_5000d = new JLabel("Số tờ 5000đ:");
        label_5000d.setBounds(59, 70, 116, 25);
        panel.add(label_5000d);
        label_5000d.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_10000d = new JLabel("Số tờ 10000đ:");
        label_10000d.setBounds(48, 105, 127, 25);
        panel.add(label_10000d);
        label_10000d.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_20000d = new JLabel("Số tờ 20000đ:");
        label_20000d.setBounds(48, 140, 127, 25);
        panel.add(label_20000d);
        label_20000d.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_50000d = new JLabel("Số tờ 50000đ:");
        label_50000d.setBounds(48, 177, 127, 25);
        panel.add(label_50000d);
        label_50000d.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_100000d = new JLabel("Số tờ 100000đ:");
        label_100000d.setBounds(37, 210, 138, 25);
        panel.add(label_100000d);
        label_100000d.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_200000d = new JLabel("Số tờ 200000đ:");
        label_200000d.setBounds(37, 245, 138, 25);
        panel.add(label_200000d);
        label_200000d.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_500000d = new JLabel("Số tờ 500000đ:");
        label_500000d.setBounds(37, 280, 138, 25);
        panel.add(label_500000d);
        label_500000d.setFont(new Font("Tahoma", Font.PLAIN, 20));

        btn_minus_1000 = new JButton("-");
        btn_minus_1000.setBounds(185, 0, 43, 27);
        panel.add(btn_minus_1000);
        btn_minus_1000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        textField_1000 = new JTextField();
        textField_1000.setBounds(238, 2, 97, 25);
        panel.add(textField_1000);
        textField_1000.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_1000.setColumns(7);

        btn_plus_1000 = new JButton("+");
        btn_plus_1000.setBounds(345, 0, 43, 27);
        panel.add(btn_plus_1000);
        btn_plus_1000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        btn_minus_2000 = new JButton("-");
        btn_minus_2000.setBounds(185, 35, 43, 27);
        panel.add(btn_minus_2000);
        btn_minus_2000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        textField_2000 = new JTextField();
        textField_2000.setBounds(238, 35, 97, 25);
        panel.add(textField_2000);
        textField_2000.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_2000.setColumns(7);

        btn_plus_2000 = new JButton("+");
        btn_plus_2000.setBounds(345, 35, 43, 27);
        panel.add(btn_plus_2000);
        btn_plus_2000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        btn_minus_5000 = new JButton("-");
        btn_minus_5000.setBounds(185, 70, 43, 27);
        panel.add(btn_minus_5000);
        btn_minus_5000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        textField_5000 = new JTextField();
        textField_5000.setBounds(238, 70, 97, 25);
        panel.add(textField_5000);
        textField_5000.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_5000.setColumns(7);

        btn_plus_5000 = new JButton("+");
        btn_plus_5000.setBounds(345, 70, 43, 27);
        panel.add(btn_plus_5000);
        btn_plus_5000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        btn_minus_10000 = new JButton("-");
        btn_minus_10000.setBounds(185, 105, 43, 27);
        panel.add(btn_minus_10000);
        btn_minus_10000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        textField_10000 = new JTextField();
        textField_10000.setBounds(238, 105, 97, 25);
        panel.add(textField_10000);
        textField_10000.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_10000.setColumns(7);

        btn_plus_10000 = new JButton("+");
        btn_plus_10000.setBounds(345, 105, 43, 27);
        panel.add(btn_plus_10000);
        btn_plus_10000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        btn_minus_20000 = new JButton("-");
        btn_minus_20000.setBounds(185, 140, 43, 27);
        panel.add(btn_minus_20000);
        btn_minus_20000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        textField_20000 = new JTextField();
        textField_20000.setBounds(238, 140, 97, 25);
        panel.add(textField_20000);
        textField_20000.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_20000.setColumns(7);

        btn_plus_20000 = new JButton("+");
        btn_plus_20000.setBounds(345, 140, 43, 27);
        panel.add(btn_plus_20000);
        btn_plus_20000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        btn_minus_50000 = new JButton("-");
        btn_minus_50000.setBounds(185, 175, 43, 27);
        panel.add(btn_minus_50000);
        btn_minus_50000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        textField_50000 = new JTextField();
        textField_50000.setBounds(238, 175, 97, 25);
        panel.add(textField_50000);
        textField_50000.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_50000.setColumns(7);

        btn_plus_50000 = new JButton("+");
        btn_plus_50000.setBounds(345, 175, 43, 27);
        panel.add(btn_plus_50000);
        btn_plus_50000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        btn_minus_100000 = new JButton("-");
        btn_minus_100000.setBounds(185, 210, 43, 27);
        panel.add(btn_minus_100000);
        btn_minus_100000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        textField_100000 = new JTextField();
        textField_100000.setBounds(238, 210, 97, 25);
        panel.add(textField_100000);
        textField_100000.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_100000.setColumns(7);

        btn_plus_100000 = new JButton("+");
        btn_plus_100000.setBounds(345, 210, 43, 27);
        panel.add(btn_plus_100000);
        btn_plus_100000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        btn_minus_200000 = new JButton("-");
        btn_minus_200000.setBounds(185, 245, 43, 27);
        panel.add(btn_minus_200000);
        btn_minus_200000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        textField_200000 = new JTextField();
        textField_200000.setBounds(238, 245, 97, 25);
        panel.add(textField_200000);
        textField_200000.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_200000.setColumns(7);

        btn_plus_200000 = new JButton("+");
        btn_plus_200000.setBounds(345, 245, 43, 27);
        panel.add(btn_plus_200000);
        btn_plus_200000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        btn_minus_500000 = new JButton("-");
        btn_minus_500000.setBounds(185, 280, 43, 27);
        panel.add(btn_minus_500000);
        btn_minus_500000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        textField_500000 = new JTextField();
        textField_500000.setBounds(238, 280, 97, 25);
        panel.add(textField_500000);
        textField_500000.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_500000.setColumns(7);

        btn_plus_500000 = new JButton("+");
        btn_plus_500000.setBounds(345, 280, 43, 27);
        panel.add(btn_plus_500000);
        btn_plus_500000.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel label_chuyenKhoan = new JLabel("Tiền chuyển khoản:");
        label_chuyenKhoan.setBounds(0, 320, 175, 25);
        panel.add(label_chuyenKhoan);
        label_chuyenKhoan.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField_chuyenKhoan = new JTextField();
        textField_chuyenKhoan.setBounds(185, 322, 203, 25);
        panel.add(textField_chuyenKhoan);
        textField_chuyenKhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_chuyenKhoan.setColumns(10);

        btn_xacNhan = new JButton("Xác nhận");
        btn_xacNhan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_xacNhan.setBounds(824, 546, 115, 33);
        contentPane.add(btn_xacNhan);

        btn_hoanTat = new JButton("Hoàn tất");
        btn_hoanTat.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btn_hoanTat.setBounds(10, 597, 149, 45);
        contentPane.add(btn_hoanTat);

        JLabel label_chenhLech = new JLabel("Chênh lệch:");
        label_chenhLech.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label_chenhLech.setBounds(10, 546, 159, 37);
        contentPane.add(label_chenhLech);

        label_hienChechLech = new JLabel("0.0");
        label_hienChechLech.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label_hienChechLech.setBounds(179, 546, 238, 37);
        contentPane.add(label_hienChechLech);

        JLabel label_maNV = new JLabel("Mã nhân viên:");
        label_maNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_maNV.setBounds(10, 39, 126, 25);
        contentPane.add(label_maNV);

        label_hienMaNV = new JLabel("<<mã nhân viên>>");
        label_hienMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_hienMaNV.setBounds(146, 39, 273, 25);
        contentPane.add(label_hienMaNV);

        HanhDong_TrangKetCa hdTrangKetCa = new HanhDong_TrangKetCa(this);
        btn_minus_1000.addActionListener(hdTrangKetCa);
        btn_plus_1000.addActionListener(hdTrangKetCa);
        btn_minus_2000.addActionListener(hdTrangKetCa);
        btn_plus_2000.addActionListener(hdTrangKetCa);
        btn_minus_5000.addActionListener(hdTrangKetCa);
        btn_plus_5000.addActionListener(hdTrangKetCa);
        btn_minus_10000.addActionListener(hdTrangKetCa);
        btn_plus_10000.addActionListener(hdTrangKetCa);
        btn_minus_20000.addActionListener(hdTrangKetCa);
        btn_plus_20000.addActionListener(hdTrangKetCa);
        btn_minus_50000.addActionListener(hdTrangKetCa);
        btn_plus_50000.addActionListener(hdTrangKetCa);
        btn_minus_100000.addActionListener(hdTrangKetCa);
        btn_plus_100000.addActionListener(hdTrangKetCa);
        btn_minus_200000.addActionListener(hdTrangKetCa);
        btn_plus_200000.addActionListener(hdTrangKetCa);
        btn_minus_500000.addActionListener(hdTrangKetCa);
        btn_plus_500000.addActionListener(hdTrangKetCa);
        btn_xacNhan.addActionListener(hdTrangKetCa);
        btn_hoanTat.addActionListener(hdTrangKetCa);

        String gioVaoCa = HanhDong_TrangDangNhap.gioVaoTruc;
        ngayGioBatDau = HanhDong_TrangDangNhap.ngayGioBatDau;
        label_hienGioVaoCa.setText(gioVaoCa);

        label_hienTenNV.setText(HanhDong_TrangDangNhap.tenNV);

        hienGioKetCa();

        hienTienCaTruoc();
        hienMaNV();
        hienTongVAT();
        hienTongGiamGia();
        hienSoHoaDon();
        hienTongTienHeThong();
    }

    public void hienTienCaTruoc(){
        double tienCaTruoc = CaTruc_DAO.layTienCaTruoc();
        label_hienTongTienCaTruoc.setText(String.valueOf(tienCaTruoc));
    }
    public void hienMaNV(){
        label_hienMaNV.setText(HanhDong_TrangDangNhap.maNV);
    }
    public void hienGioKetCa(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(formatter);
        label_hienGioKetCa.setText(formattedDateTime);
        ngayGioKetThuc = now;
    }
    public void hienTongVAT(){
        double tongVAT = HoaDon_DAO.layTongVAT();
        label_hienTongVAT.setText(String.valueOf(tongVAT));
    }
    public void hienTongGiamGia(){
        double tongGiamGia = HoaDon_DAO.layTongGiamGia();
        label_hienTongGiam.setText(String.valueOf(tongGiamGia));
    }
    public void hienSoHoaDon(){
        int soHoaDon = HoaDon_DAO.laySoHoaDon();
        label_hienTongHoaDon.setText(String.valueOf(soHoaDon));
    }
    public void hienTongTienHeThong (){
        double tongTienHeThong = HoaDon_DAO.layTongTienHeThong();
        label_hienTongTienHeThong.setText(String.valueOf(tongTienHeThong));
    }

}
