package app.giao_dien;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.Font;

import app.dao.CaTruc_DAO;
import app.dieu_khien.HanhDong_TrangDangNhap;
import app.dieu_khien.HanhDong_TrangNhanVien;
import app.thuc_the.CaTruc;
import com.toedter.calendar.JDateChooser;

import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class TrangNhanVien extends JPanel {

    private static final long serialVersionUID = 1L;
    public final JButton btn_quanLyNV;
    public JDateChooser dateChooser_ngayTruc;
    public static JLabel label_nhanVien;
    public JLabel lable_hienMaNV;
    public JTextArea textArea_diaChi;
    public JTable table;
    public JComboBox comboBox_gt;
    public JLabel label_hienGioVaoTruc;
    public JDateChooser dateChooser_ngaySinh;
    public JTextField textField_hoTen;
    public JTextField textField_sdt;
    public DefaultTableModel tableModel;



    /**
     * Create the panel.
     */
    public TrangNhanVien() {
        setSize(1515, 701);
        setLayout(new BorderLayout(0, 0));
        this.setBackground(Color.WHITE); // #E0F7FA

        label_nhanVien = new JLabel("NHÂN VIÊN");
        label_nhanVien.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        label_nhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        label_nhanVien.setFont(new Font("Tahoma", Font.PLAIN, 40));
        add(label_nhanVien, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel label_thongTinChiTiet = new JLabel("Thông tin chi tiết");
        label_thongTinChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label_thongTinChiTiet.setBounds(167, 10, 230, 37);
        panel.add(label_thongTinChiTiet);

        JPanel panel_thongTinNV = new JPanel();
        panel_thongTinNV.setBounds(72, 73, 492, 494);
        panel.add(panel_thongTinNV);
        panel_thongTinNV.setLayout(null);

        JLabel label_hoTen = new JLabel("Họ và tên:");
        label_hoTen.setBounds(33, 65, 93, 25);
        panel_thongTinNV.add(label_hoTen);
        label_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField_hoTen = new JTextField();
        textField_hoTen.setBounds(156, 62, 291, 31);
        panel_thongTinNV.add(textField_hoTen);
        textField_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 17));
        textField_hoTen.setColumns(10);

        JLabel label_maNV = new JLabel("Mã nhân viên:");
        label_maNV.setBounds(0, 0, 126, 25);
        panel_thongTinNV.add(label_maNV);
        label_maNV.setFont(new Font("Tahoma", Font.PLAIN, 20));

        lable_hienMaNV = new JLabel("<<lorem ipsum>>");
        lable_hienMaNV.setBounds(136, 0, 167, 25);
        panel_thongTinNV.add(lable_hienMaNV);
        lable_hienMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_sdt = new JLabel("Số điện thoại:");
        label_sdt.setBounds(2, 203, 124, 25);
        panel_thongTinNV.add(label_sdt);
        label_sdt.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField_sdt = new JTextField();
        textField_sdt.setBounds(156, 200, 291, 31);
        panel_thongTinNV.add(textField_sdt);
        textField_sdt.setFont(new Font("Tahoma", Font.PLAIN, 17));
        textField_sdt.setColumns(10);

        JLabel label_ngaySinh = new JLabel("Ngày sinh:");
        label_ngaySinh.setBounds(32, 134, 94, 25);
        panel_thongTinNV.add(label_ngaySinh);
        label_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));

        dateChooser_ngaySinh = new JDateChooser();
        dateChooser_ngaySinh.setBounds(156, 128, 291, 31);
        panel_thongTinNV.add(dateChooser_ngaySinh);

        JLabel label_gioiTinh = new JLabel("Giới tính:");
        label_gioiTinh.setBounds(44, 268, 82, 25);
        panel_thongTinNV.add(label_gioiTinh);
        label_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));

        comboBox_gt = new JComboBox();
        comboBox_gt.setBounds(156, 265, 78, 31);
        panel_thongTinNV.add(comboBox_gt);
        comboBox_gt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        comboBox_gt.setModel(new DefaultComboBoxModel(new String[]{"Nam", "Nữ"}));

        JLabel label_diaChi = new JLabel("Địa chỉ:");
        label_diaChi.setBounds(58, 332, 68, 25);
        panel_thongTinNV.add(label_diaChi);
        label_diaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textArea_diaChi = new JTextArea();
        textArea_diaChi.setBounds(156, 336, 291, 126);
        panel_thongTinNV.add(textArea_diaChi);

        JPanel panel_time = new JPanel();
        panel_time.setBackground(Color.WHITE);
        panel_time.setBounds(963, 10, 364, 66);
        panel.add(panel_time);
        panel_time.setLayout(null);

        JLabel label_gioVaoTruc = new JLabel("Giờ vào trực:");
        label_gioVaoTruc.setBounds(0, 0, 142, 31);
        panel_time.add(label_gioVaoTruc);
        label_gioVaoTruc.setFont(new Font("Tahoma", Font.PLAIN, 25));

        label_hienGioVaoTruc = new JLabel("lorem ipsum");
        label_hienGioVaoTruc.setBounds(152, 0, 200, 31);
        panel_time.add(label_hienGioVaoTruc);
        label_hienGioVaoTruc.setFont(new Font("Tahoma", Font.PLAIN, 20));


        JPanel panel_Table = new JPanel();
        panel_Table.setBounds(680, 113, 647, 345);
        panel.add(panel_Table);
        panel_Table.setLayout(null);

        JPanel panel_table = new JPanel();
        panel_table.setBounds(0, 0, 647, 347);
        panel_Table.add(panel_table);
        panel_table.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, new Color(0, 51, 102)), "L\u1ECACH S\u1EEC TR\u1EF0C", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(33, 150, 243)));
        panel_table.setLayout(new BorderLayout(0, 0));
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(144, 202, 249), new Color(66, 165, 245)));

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
        table.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Giờ vào trực", "Giờ kết ca"
                }
        ));


        JScrollPane scrollPane = new JScrollPane(table);
        panel_table.add(scrollPane);

        dateChooser_ngayTruc = new JDateChooser();


        JPanel panel_menu = new JPanel();
        panel_menu.setBounds(0, 0, 71, 701);
        panel_menu.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, new Color(0, 51, 102)));
        panel_menu.setBackground(Color.WHITE);
        add(panel_menu, BorderLayout.WEST);
        panel_menu.setLayout(new GridLayout(2, 1, 0, 0));

        JPanel panel_buttonGroup = new JPanel();
        panel_buttonGroup.setBackground(Color.WHITE);
        panel_menu.add(panel_buttonGroup);
        panel_buttonGroup.setLayout(new GridLayout(0, 1, 40, 20));

        JLabel label_menu = new JLabel("Menu");
        label_menu.setHorizontalAlignment(SwingConstants.CENTER);
        label_menu.setFont(new Font("Tahoma", Font.PLAIN, 25));
        panel_buttonGroup.add(label_menu);

        JButton btn_capNhatThongTin = new JButton("Cập nhật thông tin");
        btn_capNhatThongTin.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel_buttonGroup.add(btn_capNhatThongTin);

        btn_quanLyNV = new JButton("Quản lý nhân viên");
        btn_quanLyNV.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel_buttonGroup.add(btn_quanLyNV);

        JButton btn_doiMK = new JButton("Đổi mật khẩu");
        btn_doiMK.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel_buttonGroup.add(btn_doiMK);

        JButton btn_ketCa = new JButton("Kết ca");
        btn_ketCa.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel_buttonGroup.add(btn_ketCa);

        JPanel panel_timeChooser = new JPanel();
        panel_table.setBounds(0, 0, 647, 347);
        panel_table.add(panel_timeChooser, BorderLayout.NORTH);
        panel_timeChooser.setLayout(new GridLayout(0, 1, 0, 0));
        panel_timeChooser.add(dateChooser_ngayTruc);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        panel_menu.add(panel_2);

        panel_Table.setBackground(Color.WHITE); // #E0F7FA
        panel_table.setBackground(Color.WHITE); // #E0F7FA
        panel_thongTinNV.setBackground(Color.WHITE); // #E0F7FA
        panel_time.setBackground(Color.WHITE); // #E0F7FA
        panel_menu.setBackground(Color.WHITE); // #E0F7FA
        panel_buttonGroup.setBackground(Color.WHITE); // #E0F7FA
        panel_2.setBackground(Color.WHITE); // #E0F7FA

        panel_menu.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(144, 202, 249), new Color(66, 165, 245))); // #90CAF9, #42A5F5


        label_nhanVien.setForeground(new Color(33, 150, 243)); // #2196F3
        label_thongTinChiTiet.setForeground(new Color(25, 118, 210)); // #1976D2

        btn_capNhatThongTin.setBackground(new Color(100, 181, 246)); // #64B5F6
        btn_capNhatThongTin.setForeground(Color.WHITE);

        btn_quanLyNV.setBackground(new Color(100, 181, 246)); // #64B5F6
        btn_quanLyNV.setForeground(Color.WHITE);

        btn_doiMK.setBackground(new Color(100, 181, 246)); // #64B5F6
        btn_doiMK.setForeground(Color.WHITE);

        btn_ketCa.setBackground(new Color(100, 181, 246)); // #64B5F6
        btn_ketCa.setForeground(Color.WHITE);

        textField_hoTen.setBackground(Color.WHITE); // #E8F5FD
        textField_sdt.setBackground(Color.WHITE); // #E8F5FD
        this.textArea_diaChi.setBackground(Color.WHITE); // #E8F5FD

        comboBox_gt.setBackground(Color.WHITE); // #E8F5FD

        dateChooser_ngayTruc.setBackground(Color.WHITE); // #E8F5FD
        table.setBackground(Color.WHITE); // #E8F5FD

        table.setBackground(Color.WHITE); // #E8F5FD
        table.getTableHeader().setBackground(new Color(144, 202, 249)); // #90CAF9

        table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 16)); // Font đậm hơn cho tiêu đề
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(144, 202, 249))); // #90CAF9
        table.setSelectionBackground(new Color(179, 229, 252)); // #B3E5FC khi chọn hàng
        table.setGridColor(Color.WHITE); // #E0F7FA cho đường viền giữa các ô

        dateChooser_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        dateChooser_ngaySinh.setForeground(new Color(144, 202, 249));
        dateChooser_ngaySinh.setBackground(Color.WHITE); // #E8F5FD

        tableModel = (DefaultTableModel) table.getModel();
        hienLichSuTruc();
        table.setDefaultEditor(Object.class, null);

// ADD ACTION LISTENER
        HanhDong_TrangNhanVien hanhDong_trangNhanVien = new HanhDong_TrangNhanVien(this);
        btn_capNhatThongTin.addActionListener(hanhDong_trangNhanVien);
        btn_doiMK.addActionListener(hanhDong_trangNhanVien);
        btn_ketCa.addActionListener(hanhDong_trangNhanVien);
        btn_quanLyNV.addActionListener(hanhDong_trangNhanVien);
        dateChooser_ngayTruc.addPropertyChangeListener(hanhDong_trangNhanVien);
    }

    public void regexCapNhat(String ten, String sdt, String diaChi) {
        if (!regexTen(ten) || !regexSDT(sdt) || !regexDiaChi(diaChi)) {
        }
    }

    public static boolean regexTen(String ten) {
        String regex = "^[\\p{L}]+(?:\\s+[\\p{L}'-]+)+$";
        //xoa khoang trang thua giua cac tu


        if (!ten.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Tên không được có ký tự đặc biệt, số hoặc chỉ có một từ!");
            return false;
        }
        return true;
    }

    public static boolean regexDiaChi(String diaChi) {
        String regex = "^([\\p{L}0-9\\s,./-]+)?$";
        if (!diaChi.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Địa chỉ không được có ký tự đặc biệt!");
            return false;
        }
        return true;
    }

    public static boolean regexSDT(String sdt) {
        String regex = "^[0-9]{10}$";
        if (!sdt.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Số điện thoại phải đủ 10 số và không có ký tự đặc biệt!");
            return false;
        }
        return true;
    }

    public boolean regex_birthDay() {
        Date date = dateChooser_ngaySinh.getDate();
        LocalDate ngaySinh = LocalDate.of(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
        LocalDate ngayHienTai = LocalDate.now();
        // phai tren 18 tuoi
        if (ngayHienTai.getYear() - ngaySinh.getYear() < 18) {
            JOptionPane.showMessageDialog(null, "Nhân viên phải trên 18 tuổi");
            return false;
        }
        return true;
    }
    private void hienLichSuTruc () {
        tableModel.setRowCount(0);

        ArrayList<CaTruc> dsCaTruc = CaTruc_DAO.layDanhSachTruc(HanhDong_TrangDangNhap.maNV);
        for (CaTruc caTruc : dsCaTruc) {
            this.tableModel.addRow(new Object[]{
                    caTruc.getNgayGioBatDau(),
                    caTruc.getNgayGioKetThuc()
            });
        }
    }
}
