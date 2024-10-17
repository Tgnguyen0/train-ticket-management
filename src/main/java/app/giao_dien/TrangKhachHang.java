package app.giao_dien;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;




public class TrangKhachHang extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private JTextField textField_HoTen;
    private JTextField textField_SDT;


    /**
     * Create the panel.
     */
    public TrangKhachHang() {
        setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        setLayout(new BorderLayout(10, 0));
        setSize(1200, 700);

        JLabel label_quanLyKH = new JLabel("<html><u>QUẢN LÝ KHÁCH HÀNG</u></html>");
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
        panel_thongTinKH.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        panel_noiDung.add(panel_thongTinKH);
        panel_thongTinKH.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(58, 50, 943, 206);
        panel_thongTinKH.add(panel_1);
        panel_1.setLayout(null);

        JLabel label_maKH = new JLabel("Mã khách hàng:");
        label_maKH.setBounds(0, 0, 142, 25);
        panel_1.add(label_maKH);
        label_maKH.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField_HoTen = new JTextField();
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

        JTextArea textArea_diaChi = new JTextArea();
        textArea_diaChi.setBounds(508, 35, 390, 100);
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

        JScrollPane scrollPane = new JScrollPane(table);
        panel_table.add(scrollPane);

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel_table.add(panel, BorderLayout.NORTH);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
        desktopPane.add(panel_2, BorderLayout.WEST);
        panel_2.setLayout(new GridLayout(2, 1, 0, 0));

        JPanel panel_3 = new JPanel();
        panel_2.add(panel_3);
        panel_3.setLayout(new GridLayout(3, 1, 0, 0));

        JButton btn_capNhat = new JButton("Cập nhật");
        btn_capNhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_3.add(btn_capNhat);

        JButton btn_XemLichSu = new JButton("Xem lịch sử đặt vé");
        btn_XemLichSu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_3.add(btn_XemLichSu);

        JButton btn_lamMoi = new JButton("Làm mới");
        btn_lamMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_3.add(btn_lamMoi);

    }
}
