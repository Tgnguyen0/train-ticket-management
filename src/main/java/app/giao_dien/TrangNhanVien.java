package app.giao_dien;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;

public class TrangNhanVien extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField_hoTen;
    private JTextField textField_sdt;
    private JTextField textField;

    /**
     * Create the panel.
     */
    public TrangNhanVien() {
        setSize(1515, 701);
        setLayout(new BorderLayout(0, 0));

        JLabel lblNhnVin = new JLabel("Nhân viên");
        lblNhnVin.setHorizontalAlignment(SwingConstants.CENTER);
        lblNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 40));
        add(lblNhnVin, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel label_thongTinChiTiet = new JLabel("Thông tin chi tiết");
        label_thongTinChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label_thongTinChiTiet.setBounds(167, 10, 230, 37);
        panel.add(label_thongTinChiTiet);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(71, 73, 427, 385);
        panel.add(panel_3);
        panel_3.setLayout(null);

        JLabel label_hoTen = new JLabel("Họ và tên:");
        label_hoTen.setBounds(33, 38, 93, 25);
        panel_3.add(label_hoTen);
        label_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField_hoTen = new JTextField();
        textField_hoTen.setBounds(136, 35, 291, 31);
        panel_3.add(textField_hoTen);
        textField_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_hoTen.setColumns(10);

        JLabel label_maNV = new JLabel("Mã nhân viên:");
        label_maNV.setBounds(0, 0, 126, 25);
        panel_3.add(label_maNV);
        label_maNV.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel lable_hienMaNV = new JLabel("<<lorem ipsum>>");
        lable_hienMaNV.setBounds(136, 0, 167, 25);
        panel_3.add(lable_hienMaNV);
        lable_hienMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_sdt = new JLabel("Số điện thoại:");
        label_sdt.setBounds(2, 120, 124, 25);
        panel_3.add(label_sdt);
        label_sdt.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_email = new JLabel("Email:");
        label_email.setBounds(71, 165, 55, 25);
        panel_3.add(label_email);
        label_email.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField_sdt = new JTextField();
        textField_sdt.setBounds(136, 117, 291, 31);
        panel_3.add(textField_sdt);
        textField_sdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_sdt.setColumns(10);

        JLabel label_ngaySinh = new JLabel("Ngày sinh:");
        label_ngaySinh.setBounds(32, 79, 94, 25);
        panel_3.add(label_ngaySinh);
        label_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(136, 79, 291, 31);
        panel_3.add(dateChooser);

        textField = new JTextField();
        textField.setBounds(136, 162, 291, 31);
        panel_3.add(textField);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField.setColumns(10);

        JLabel label_gioiTinh = new JLabel("Giới tính:");
        label_gioiTinh.setBounds(44, 213, 82, 25);
        panel_3.add(label_gioiTinh);
        label_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JComboBox comboBox_gt = new JComboBox();
        comboBox_gt.setBounds(136, 210, 78, 31);
        panel_3.add(comboBox_gt);
        comboBox_gt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        comboBox_gt.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));

        JLabel lblNewLabel_1 = new JLabel("Địa chỉ:");
        lblNewLabel_1.setBounds(58, 255, 68, 25);
        panel_3.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JTextArea textArea = new JTextArea();
        textArea.setBounds(136, 259, 291, 126);
        panel_3.add(textArea);

        JPanel panel_5 = new JPanel();
        panel_5.setBounds(1041, 10, 286, 66);
        panel.add(panel_5);
        panel_5.setLayout(null);

        JLabel label_gioVaoTruc = new JLabel("Giờ vào trực:");
        label_gioVaoTruc.setBounds(0, 0, 142, 31);
        panel_5.add(label_gioVaoTruc);
        label_gioVaoTruc.setFont(new Font("Tahoma", Font.PLAIN, 25));

        JLabel label_hienGioVaoTruc = new JLabel("lorem ipsum");
        label_hienGioVaoTruc.setBounds(152, 0, 134, 31);
        panel_5.add(label_hienGioVaoTruc);
        label_hienGioVaoTruc.setFont(new Font("Tahoma", Font.PLAIN, 25));

        JLabel label_gioVaoTruc_1 = new JLabel("Thời gian trực:");
        label_gioVaoTruc_1.setBounds(10, 41, 132, 25);
        panel_5.add(label_gioVaoTruc_1);
        label_gioVaoTruc_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_hienGioVaoTruc_1 = new JLabel("lorem ipsum");
        label_hienGioVaoTruc_1.setBounds(152, 41, 116, 25);
        panel_5.add(label_hienGioVaoTruc_1);
        label_hienGioVaoTruc_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JPanel panel_6 = new JPanel();
        panel_6.setBounds(680, 113, 647, 388);
        panel.add(panel_6);
        panel_6.setLayout(null);

        JPanel panel_4 = new JPanel();
        panel_4.setBounds(0, 0, 647, 347);
        panel_6.add(panel_4);
        panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "L\u1ECACH S\u1EEC TR\u1EF0C", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_4.setLayout(new BorderLayout(0, 0));

        JTable table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Giờ vào trực", "Giờ kết ca"
                }
        ));


        JScrollPane scrollPane = new JScrollPane(table);
        panel_4.add(scrollPane);

        JDateChooser dateChooser_1 = new JDateChooser();
        dateChooser_1.setBounds(197, 357, 291, 31);
        panel_6.add(dateChooser_1);

        JPanel panel_menu = new JPanel();
        add(panel_menu, BorderLayout.WEST);
        panel_menu.setLayout(new GridLayout(2, 1, 0, 0));

        JPanel panel_1 = new JPanel();
        panel_menu.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 1, 40, 20));

        JLabel lblNewLabel = new JLabel("Menu");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        panel_1.add(lblNewLabel);

        JButton btn_capNhatThongTin = new JButton("Cập nhật thông tin");
        btn_capNhatThongTin.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel_1.add(btn_capNhatThongTin);

        JButton btn_quanLyNV = new JButton("Quản lý nhân viên");
        btn_quanLyNV.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel_1.add(btn_quanLyNV);

        JButton btn_doiMK = new JButton("Đổi mật khẩu");
        btn_doiMK.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel_1.add(btn_doiMK);

        JButton btn_ketCa = new JButton("Kết ca");
        btn_ketCa.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel_1.add(btn_ketCa);

        JPanel panel_2 = new JPanel();
        panel_menu.add(panel_2);
    }
}
