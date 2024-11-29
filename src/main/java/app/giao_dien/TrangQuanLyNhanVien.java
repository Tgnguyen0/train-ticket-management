package app.giao_dien;


import javax.swing.*;
import java.awt.*;


import javax.swing.table.DefaultTableModel;

import app.dieu_khien.HanhDong_TrangQuanLyNhanVien;
import com.toedter.calendar.JDateChooser;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class TrangQuanLyNhanVien extends JFrame {

    public static final long serialVersionUID = 1L;
    public final JTextArea textArea_diaChi;
    public final JLabel label_hienThiMaNV;
    public final JButton btn_xemLichSuTruc;
    public JComboBox comboBox_gioiTinh;
    public JTable table;
    public JTextField textField_HoTen;
    public JTextField textField_SDT;
    public JTextField textField_timTen;
    public JTextField textField_timSDT;


    /**
     * Create the panel.
     */

    public TrangQuanLyNhanVien() {

        setTitle("Quản lý nhân viên");
        setSize(1043, 882);
        setLocationRelativeTo(null);


        JLabel label_quanLyKH = new JLabel("<html><u>QUẢN LÝ KHÁCH HÀNG</u></html>");
        label_quanLyKH.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        label_quanLyKH.setBackground(new Color(0, 64, 128));
        label_quanLyKH.setForeground(new Color(0, 128, 255));
        label_quanLyKH.setHorizontalAlignment(SwingConstants.CENTER);
        label_quanLyKH.setFont(new Font("Bahnschrift", Font.BOLD, 40));
        getContentPane().add(label_quanLyKH);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setForeground(new Color(0, 0, 128));
        desktopPane.setBackground(new Color(0, 0, 128));
        getContentPane().add(desktopPane);
        desktopPane.setLayout(new BorderLayout(0, 0));

        JPanel panel_cumTieuDe = new JPanel();
        panel_cumTieuDe.setBorder(null);
        desktopPane.add(panel_cumTieuDe, BorderLayout.NORTH);
        panel_cumTieuDe.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel label_quanLyNV = new JLabel(" Quản lý nhân viên");
        label_quanLyNV.setHorizontalAlignment(SwingConstants.LEFT);
        label_quanLyNV.setFont(new Font("Tahoma", Font.PLAIN, 30));
        panel_cumTieuDe.add(label_quanLyNV);

        JPanel panel_noiDung = new JPanel();
        desktopPane.add(panel_noiDung, BorderLayout.CENTER);
        panel_noiDung.setLayout(new GridLayout(2, 0, 0, 0));

        JPanel panel_thongTinKH = new JPanel();
        panel_thongTinKH.setBorder(new LineBorder(new Color(0, 128, 255), 1, true));
        panel_noiDung.add(panel_thongTinKH);
        panel_thongTinKH.setLayout(null);

        JPanel panel_thongTinNV = new JPanel();
        panel_thongTinNV.setBorder(new TitledBorder(null, "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_thongTinNV.setBounds(28, 87, 980, 230);
        panel_thongTinKH.add(panel_thongTinNV);
        panel_thongTinNV.setLayout(null);


        JLabel label_maNV = new JLabel("Mã nhân viên:");
        label_maNV.setBounds(10, 32, 142, 25);
        panel_thongTinNV.add(label_maNV);
        label_maNV.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField_HoTen = new JTextField();
        textField_HoTen.setBorder(new LineBorder(new Color(0, 128, 255)));
        textField_HoTen.setBounds(143, 67, 227, 24);
        panel_thongTinNV.add(textField_HoTen);
        textField_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_HoTen.setColumns(15);

        label_hienThiMaNV = new JLabel("<mã nhân viên>");
        label_hienThiMaNV.setBounds(162, 34, 152, 22);
        panel_thongTinNV.add(label_hienThiMaNV);
        label_hienThiMaNV.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JLabel label_hoTen = new JLabel("Họ và tên:");
        label_hoTen.setBounds(10, 67, 93, 25);
        panel_thongTinNV.add(label_hoTen);
        label_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel lblSinThoi = new JLabel("Số điện thoại:");
        lblSinThoi.setBounds(10, 101, 124, 25);
        panel_thongTinNV.add(lblSinThoi);
        lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField_SDT = new JTextField();
        textField_SDT.setBorder(new LineBorder(new Color(0, 128, 255)));
        textField_SDT.setBounds(143, 102, 227, 24);
        panel_thongTinNV.add(textField_SDT);
        textField_SDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_SDT.setColumns(15);

        JLabel lblGiiTnh = new JLabel("Giới tính:");
        lblGiiTnh.setBounds(10, 171, 82, 25);
        panel_thongTinNV.add(lblGiiTnh);
        lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 20));

        comboBox_gioiTinh = new JComboBox();
        comboBox_gioiTinh.setBounds(143, 173, 82, 25);
        panel_thongTinNV.add(comboBox_gioiTinh);
        comboBox_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBox_gioiTinh.setModel(new DefaultComboBoxModel(new String[]{"Nam", "Nữ"}));
        comboBox_gioiTinh.setMaximumRowCount(2);

        JLabel label_diaChi = new JLabel("Địa chỉ:");
        label_diaChi.setBounds(488, 58, 68, 25);
        panel_thongTinNV.add(label_diaChi);
        label_diaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textArea_diaChi = new JTextArea();
        textArea_diaChi.setBounds(580, 61, 390, 100);
        textArea_diaChi.setBorder(new LineBorder(new Color(0, 128, 255)));
        textArea_diaChi.setLineWrap(true);
        panel_thongTinNV.add(textArea_diaChi);
        textArea_diaChi.setFont(new Font("Monospaced", Font.PLAIN, 15));

        JLabel label_sdt_1 = new JLabel("Ngày sinh:");
        label_sdt_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_sdt_1.setBounds(10, 136, 94, 25);
        panel_thongTinNV.add(label_sdt_1);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(143, 138, 227, 25);
        panel_thongTinNV.add(dateChooser);

        JLabel label_vaiTro = new JLabel("Vai trò:");
        label_vaiTro.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_vaiTro.setBounds(488, 171, 66, 25);
        panel_thongTinNV.add(label_vaiTro);

        JComboBox comboBox_vaiTro = new JComboBox();
        comboBox_vaiTro.setModel(new DefaultComboBoxModel(new String[]{"Nhân viên", "Quản lý"}));
        comboBox_vaiTro.setMaximumRowCount(2);
        comboBox_vaiTro.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBox_vaiTro.setBounds(580, 171, 110, 25);
        panel_thongTinNV.add(comboBox_vaiTro);

        JButton btn_capNhat = new JButton("Cập nhật");
        btn_capNhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_capNhat.setBounds(229, 37, 115, 33);
        panel_thongTinKH.add(btn_capNhat);

        JButton btn_lamMoi = new JButton("Làm mới");
        btn_lamMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_lamMoi.setBounds(354, 37, 115, 33);
        panel_thongTinKH.add(btn_lamMoi);

        JButton btn_themNV = new JButton("Thêm nhân viên");
        btn_themNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_themNV.setBounds(28, 37, 191, 33);
        panel_thongTinKH.add(btn_themNV);

        btn_xemLichSuTruc = new JButton("Xem lịch sử trực");
        btn_xemLichSuTruc.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_xemLichSuTruc.setBounds(479, 37, 191, 33);
        panel_thongTinKH.add(btn_xemLichSuTruc);

        JButton btn_thuHoiTK = new JButton("Thu hồi tài khoản");
        btn_thuHoiTK.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_thuHoiTK.setBounds(817, 327, 191, 33);
        panel_thongTinKH.add(btn_thuHoiTK);

        JPanel panel_table = new JPanel();
        panel_table.setBorder(null);
        panel_noiDung.add(panel_table);
        panel_table.setLayout(new BorderLayout(0, 0));

        table = new JTable();

        table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"STT", "Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Giới tính"}));
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);

        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
        table.setBounds(0, 0, 1, 1);

        JScrollPane scrollPane_table = new JScrollPane(table);
        panel_table.add(scrollPane_table);

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel_table.add(panel, BorderLayout.NORTH);

        JLabel label_timTen = new JLabel("Tìm tên:");
        label_timTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_timTen);

        textField_timTen = new JTextField();
        textField_timTen.setBorder(new LineBorder(new Color(0, 128, 255)));
        textField_timTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(textField_timTen);
        textField_timTen.setColumns(15);

        JLabel label_timSDT = new JLabel("Tìm số điện thoại:");
        label_timSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_timSDT);

        textField_timSDT = new JTextField();
        textField_timSDT.setBorder(new LineBorder(new Color(0, 128, 255)));
        textField_timSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(textField_timSDT);
        textField_timSDT.setColumns(10);

        JButton btn_tim = new JButton("Tìm");
        btn_tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(btn_tim);

        JButton btn_lamTrongDanhSach = new JButton("Làm trống danh sách");
        panel.add(btn_lamTrongDanhSach);
        btn_lamTrongDanhSach.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton btn_xemToanBo = new JButton("Xem toàn bộ");
        btn_xemToanBo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(btn_xemToanBo);

        //--------------------------------------ADD ACTION LISTENER--------------------------------------
        HanhDong_TrangQuanLyNhanVien hanhDong_trangQuanLyNhanVien = new HanhDong_TrangQuanLyNhanVien(this);
        btn_xemLichSuTruc.addActionListener(hanhDong_trangQuanLyNhanVien);
    }
}
