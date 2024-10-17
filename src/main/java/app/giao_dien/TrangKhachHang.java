package app.giao_dien;

import app.Dao.KhachHang_DAO;
import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.DanhSachKhachHang;
import app.thuc_the.KhachHang;

import javax.swing.*;
import java.awt.BorderLayout;

import java.awt.Font;

import java.awt.Color;


import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import javax.swing.border.LineBorder;




public class TrangKhachHang extends JPanel {

    private static final long serialVersionUID = 1L;
    private final JTextArea textArea_diaChi;
    private JTable table;
    private JTextField textField_HoTen;
    private JTextField textField_SDT;
    private JTextField textField_timTen;
    private JTextField textField_timSDT;


    /**
     * Create the panel.
     */
    public TrangKhachHang() {
        setBorder(new LineBorder(new Color(0, 128, 255), 1, true));
        setLayout(new BorderLayout(10, 0));
        setSize(1200, 700);

        JLabel label_quanLyKH = new JLabel("<html><u>QUẢN LÝ KHÁCH HÀNG</u></html>");
        label_quanLyKH.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        label_quanLyKH.setBackground(new Color(0, 64, 128));
        label_quanLyKH.setForeground(new Color(0, 128, 255));
        label_quanLyKH.setHorizontalAlignment(SwingConstants.CENTER);
        label_quanLyKH.setFont(new Font("Bahnschrift", Font.BOLD, 40));
        add(label_quanLyKH, BorderLayout.NORTH);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setForeground(new Color(0, 0, 128));
        desktopPane.setBackground(new Color(0, 0, 128));
        add(desktopPane, BorderLayout.CENTER);
        desktopPane.setLayout(new BorderLayout(0, 0));

        JPanel panel_cumTieuDe = new JPanel();
        panel_cumTieuDe.setBorder(null);
        desktopPane.add(panel_cumTieuDe, BorderLayout.NORTH);
        panel_cumTieuDe.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblThngTinKhch = new JLabel(" Thông tin khách hàng");
        lblThngTinKhch.setHorizontalAlignment(SwingConstants.LEFT);
        lblThngTinKhch.setFont(new Font("Tahoma", Font.PLAIN, 30));
        panel_cumTieuDe.add(lblThngTinKhch);

        JPanel panel_noiDung = new JPanel();
        desktopPane.add(panel_noiDung, BorderLayout.CENTER);
        panel_noiDung.setLayout(new GridLayout(2, 0, 0, 0));



        JPanel panel_thongTinKH = new JPanel();
        panel_thongTinKH.setBorder(new LineBorder(new Color(0, 128, 255), 1, true));
        panel_noiDung.add(panel_thongTinKH);
        panel_thongTinKH.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(89, 50, 943, 206);
        panel_thongTinKH.add(panel_1);
        panel_1.setLayout(null);

        JLabel label_maKH = new JLabel("Mã khách hàng:");
        label_maKH.setBounds(0, 0, 142, 25);
        panel_1.add(label_maKH);
        label_maKH.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField_HoTen = new JTextField();
        textField_HoTen.setBorder(new LineBorder(new Color(0, 128, 255)));
        textField_HoTen.setBounds(152, 35, 296, 45);
        panel_1.add(textField_HoTen);
        textField_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_HoTen.setColumns(15);

        JLabel label_hienThiMaKH = new JLabel("<mã khách hàng>");
        label_hienThiMaKH.setBounds(152, 0, 165, 25);
        panel_1.add(label_hienThiMaKH);
        label_hienThiMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_hoTen = new JLabel("Họ và tên:");
        label_hoTen.setBounds(0, 44, 93, 25);
        panel_1.add(label_hoTen);
        label_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_sdt = new JLabel("Số điện thoại");
        label_sdt.setBounds(0, 99, 117, 25);
        panel_1.add(label_sdt);
        label_sdt.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField_SDT = new JTextField();
        textField_SDT.setBorder(new LineBorder(new Color(0, 128, 255)));
        textField_SDT.setBounds(152, 90, 296, 45);
        panel_1.add(textField_SDT);
        textField_SDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_SDT.setColumns(15);

        JLabel lblGiiTnh = new JLabel("Giới tính:");
        lblGiiTnh.setBounds(0, 143, 82, 25);
        panel_1.add(lblGiiTnh);
        lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(152, 145, 82, 25);
        panel_1.add(comboBox);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
        comboBox.setMaximumRowCount(2);

        JLabel label_diaChi = new JLabel("Địa chỉ:");
        label_diaChi.setBounds(508, 0, 68, 25);
        panel_1.add(label_diaChi);
        label_diaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textArea_diaChi = new JTextArea();
        textArea_diaChi.setBounds(508, 35, 390, 100);
        textArea_diaChi.setBorder(new LineBorder(new Color(0, 128, 255)));
        textArea_diaChi.setLineWrap(true);
        panel_1.add(textArea_diaChi);
        textArea_diaChi.setFont(new Font("Monospaced", Font.PLAIN, 15));

        JPanel panel_table = new JPanel();
        panel_table.setBorder(null);
        panel_noiDung.add(panel_table);
        panel_table.setLayout(new BorderLayout(0, 0));

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "STT", "Mã khách hàng", "Họ và tên", "Số điện thoại", "Giới tính", "Địa chỉ"
                }
        ));

        table.setFont(new Font("Tahoma", Font.PLAIN, 20));
        table.setBounds(0, 0, 1, 1);

        KhachHang_DAO khachHang_dao = new KhachHang_DAO();
        ArrayList<KhachHang> dsKH = (ArrayList<KhachHang>) khachHang_dao.ChonTatCa();

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < dsKH.size(); i++) {
            model.addRow(new Object[] {i + 1, dsKH.get(i).getMaKH(), dsKH.get(i).getTenKH(), dsKH.get(i).getSoDT(), dsKH.get(i).getGioiTinh(), dsKH.get(i).getDiaChi()});
        }


        JScrollPane scrollPane = new JScrollPane(table);
        panel_table.add(scrollPane);

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel_table.add(panel, BorderLayout.NORTH);

        JLabel label_timTen = new JLabel("Tìm theo tên:");
        label_timTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_timTen);

        textField_timTen = new JTextField();
        textField_timTen.setBorder(new LineBorder(new Color(0, 128, 255)));
        textField_timTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(textField_timTen);
        textField_timTen.setColumns(15);

        JLabel label_timSDT = new JLabel("Tìm theo số điện thoại:");
        label_timSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_timSDT);

        textField_timSDT = new JTextField();
        textField_timSDT.setBorder(new LineBorder(new Color(0, 128, 255)));
        textField_timSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(textField_timSDT);
        textField_timSDT.setColumns(10);

        JButton btn_tim = new JButton("Tìm");
        btn_tim.setForeground(new Color(255, 255, 255));
        btn_tim.setBackground(new Color(0, 128, 255));
        btn_tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(btn_tim);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new LineBorder(new Color(0, 128, 255)));
        desktopPane.add(panel_2, BorderLayout.WEST);
        panel_2.setLayout(new GridLayout(2, 1, 0, 0));

        JPanel panel_3 = new JPanel();
        panel_2.add(panel_3);
        panel_3.setLayout(new GridLayout(3, 1, 0, 0));

        JButton btn_capNhat = new JButton("Cập nhật");
        btn_capNhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_capNhat.setForeground(new Color(255, 255, 255));
        btn_capNhat.setBackground(new Color(0, 128, 255));
        panel_3.add(btn_capNhat);

        JButton btn_XemLichSu = new JButton("Xem lịch sử đặt vé");
        btn_XemLichSu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_XemLichSu.setForeground(new Color(255, 255, 255));
        btn_XemLichSu.setBackground(new Color(0, 128, 255));
        panel_3.add(btn_XemLichSu);

        JButton btn_lamMoi = new JButton("Làm mới");
        btn_lamMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_lamMoi.setForeground(new Color(255, 255, 255));
        btn_lamMoi.setBackground(new Color(0, 128, 255));
        panel_3.add(btn_lamMoi);



    }

}
