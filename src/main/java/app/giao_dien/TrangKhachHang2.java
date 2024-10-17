package app.giao_dien;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class TrangKhachHang2 extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField_timKiem;
    private JTextField textField_tenKH;
    private JTextField textField_sdt;
    private JTable table_bangThongTinKH;
    private JTextField textField_timTen;
    private JTextField textField_timSDT;

    /**
     * Create the panel.
     */
    public TrangKhachHang2() {

        setSize(new Dimension(TrangDinhHuong.WIDTH, TrangDinhHuong.HEIGHT));
        setLayout(new BorderLayout(0, 0));

        JPanel panel_noiDung = new JPanel();
        panel_noiDung.setBorder(null);
        panel_noiDung.setPreferredSize(new Dimension(TrangDinhHuong.WIDTH, TrangDinhHuong.HEIGHT));
        add(panel_noiDung, BorderLayout.CENTER);
        panel_noiDung.setLayout(new BorderLayout(0, 0));

        JPanel panel_baoCacThanhPhan = new JPanel();
        panel_noiDung.add(panel_baoCacThanhPhan);

        panel_baoCacThanhPhan.setLayout(null);
        panel_baoCacThanhPhan.setPreferredSize(new Dimension(TrangDinhHuong.WIDTH, TrangDinhHuong.HEIGHT));

        JPanel panel_cum2TieuDe = new JPanel();
        panel_cum2TieuDe.setBounds(53, 0, 1030, 37);
        panel_baoCacThanhPhan.add(panel_cum2TieuDe);
        panel_cum2TieuDe.setLayout(null);

        JLabel lblThngTinKhch = new JLabel("Thông tin khách hàng");
        lblThngTinKhch.setBounds(0, 0, 294, 37);
        panel_cum2TieuDe.add(lblThngTinKhch);
        lblThngTinKhch.setHorizontalAlignment(SwingConstants.CENTER);
        lblThngTinKhch.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblThngTinKhch.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JLabel label_chucNang = new JLabel("Chức năng");
        label_chucNang.setBounds(876, 0, 144, 37);
        panel_cum2TieuDe.add(label_chucNang);
        label_chucNang.setFont(new Font("Tahoma", Font.PLAIN, 30));

        JPanel panel_cumThongTinKH = new JPanel();
        panel_cumThongTinKH.setBounds(50, 47, 746, 217);
        panel_baoCacThanhPhan.add(panel_cumThongTinKH);
        panel_cumThongTinKH.setBorder(new LineBorder(new Color(0, 0, 0)));
        SpringLayout sl_panel_cumThongTinKH = new SpringLayout();
        panel_cumThongTinKH.setLayout(sl_panel_cumThongTinKH);

        JLabel label_maKH = new JLabel("Mã khách hàng:");
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.NORTH, label_maKH, 10, SpringLayout.NORTH, panel_cumThongTinKH);
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.WEST, label_maKH, 10, SpringLayout.WEST, panel_cumThongTinKH);
        panel_cumThongTinKH.add(label_maKH);
        label_maKH.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_HienThiMaKH = new JLabel("<mã khách hàng>");
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.NORTH, label_HienThiMaKH, 10, SpringLayout.NORTH, panel_cumThongTinKH);
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.WEST, label_HienThiMaKH, 162, SpringLayout.WEST, panel_cumThongTinKH);
        panel_cumThongTinKH.add(label_HienThiMaKH);
        label_HienThiMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_tenKH = new JLabel("Họ và tên:");
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.NORTH, label_tenKH, 10, SpringLayout.NORTH, panel_cumThongTinKH);
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.WEST, label_tenKH, 351, SpringLayout.WEST, panel_cumThongTinKH);
        panel_cumThongTinKH.add(label_tenKH);
        label_tenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField_tenKH = new JTextField();
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.NORTH, textField_tenKH, 7, SpringLayout.NORTH, panel_cumThongTinKH);
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.WEST, textField_tenKH, 478, SpringLayout.WEST, panel_cumThongTinKH);
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.EAST, textField_tenKH, 733, SpringLayout.WEST, panel_cumThongTinKH);
        textField_tenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_cumThongTinKH.add(textField_tenKH);
        textField_tenKH.setColumns(10);

        JLabel lblSinThoi = new JLabel("Số điện thoại:");
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.NORTH, lblSinThoi, 60, SpringLayout.NORTH, panel_cumThongTinKH);
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.WEST, lblSinThoi, 351, SpringLayout.WEST, panel_cumThongTinKH);
        lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_cumThongTinKH.add(lblSinThoi);

        textField_sdt = new JTextField();
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.NORTH, textField_sdt, -3, SpringLayout.NORTH, lblSinThoi);
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.WEST, textField_sdt, 0, SpringLayout.WEST, textField_tenKH);
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.EAST, textField_sdt, 0, SpringLayout.EAST, textField_tenKH);
        textField_sdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_cumThongTinKH.add(textField_sdt);
        textField_sdt.setColumns(10);

        JLabel lblGiiTnh = new JLabel("Giới tính:");
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.NORTH, lblGiiTnh, 60, SpringLayout.NORTH, panel_cumThongTinKH);
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.WEST, lblGiiTnh, 10, SpringLayout.WEST, panel_cumThongTinKH);
        lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_cumThongTinKH.add(lblGiiTnh);

        JComboBox comboBox = new JComboBox();
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.NORTH, comboBox, 57, SpringLayout.NORTH, panel_cumThongTinKH);
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.WEST, comboBox, 162, SpringLayout.WEST, panel_cumThongTinKH);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
        comboBox.setMaximumRowCount(2);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_cumThongTinKH.add(comboBox);

        JLabel lblaCh = new JLabel("Địa chỉ:");
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.NORTH, lblaCh, 107, SpringLayout.NORTH, panel_cumThongTinKH);
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.WEST, lblaCh, 10, SpringLayout.WEST, panel_cumThongTinKH);
        lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_cumThongTinKH.add(lblaCh);

        JTextArea textArea_diaChi = new JTextArea();
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.NORTH, textArea_diaChi, 111, SpringLayout.NORTH, panel_cumThongTinKH);
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.WEST, textArea_diaChi, 88, SpringLayout.WEST, panel_cumThongTinKH);
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.SOUTH, textArea_diaChi, 207, SpringLayout.NORTH, panel_cumThongTinKH);
        sl_panel_cumThongTinKH.putConstraint(SpringLayout.EAST, textArea_diaChi, 733, SpringLayout.WEST, panel_cumThongTinKH);
        panel_cumThongTinKH.add(textArea_diaChi);

        table_bangThongTinKH = new JTable();
        table_bangThongTinKH.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "STT", "Mã khách hàng", "Họ và tên", "Số điện thoại", "Giới tính", "Địa chỉ"
                }
        ));
        table_bangThongTinKH.setBounds(0, 0, 1, 1);


        JScrollPane scrollPane = new JScrollPane(table_bangThongTinKH);
        scrollPane.setBounds(53, 369, 1089, 262);
        panel_baoCacThanhPhan.add(scrollPane);

        JPanel panel_cumNut = new JPanel();
        panel_cumNut.setBounds(845, 47, 297, 217);
        panel_baoCacThanhPhan.add(panel_cumNut);
        panel_cumNut.setLayout(null);

        JButton btn_CapNhat = new JButton("Cập nhật");
        btn_CapNhat.setBounds(0, 0, 152, 109);
        btn_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 25));
        panel_cumNut.add(btn_CapNhat);

        JButton btn_LamMoi = new JButton("Làm mới");
        btn_LamMoi.setBounds(147, 0, 152, 109);
        btn_LamMoi.setFont(new Font("Tahoma", Font.PLAIN, 25));
        panel_cumNut.add(btn_LamMoi);

        JButton btn_xemLichSu = new JButton("Xem lịch sử đặt vé");
        btn_xemLichSu.setBounds(0, 108, 297, 109);
        btn_xemLichSu.setFont(new Font("Tahoma", Font.PLAIN, 25));
        panel_cumNut.add(btn_xemLichSu);

        JPanel panel_cumTimKiem = new JPanel();
        panel_cumTimKiem.setBounds(53, 291, 1089, 52);
        panel_baoCacThanhPhan.add(panel_cumTimKiem);
        FlowLayout flowLayout = (FlowLayout) panel_cumTimKiem.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);

        JLabel label_timTen = new JLabel("Tìm kiếm theo tên:");
        label_timTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_cumTimKiem.add(label_timTen);

        textField_timTen = new JTextField();
        textField_timTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_cumTimKiem.add(textField_timTen);
        textField_timTen.setColumns(10);

        JLabel lblTmKimTheo = new JLabel("Tìm kiếm theo số điện thoại:");
        lblTmKimTheo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_cumTimKiem.add(lblTmKimTheo);

        textField_timSDT = new JTextField();
        textField_timSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_cumTimKiem.add(textField_timSDT);
        textField_timSDT.setColumns(10);

        JButton btn_tim = new JButton("Tìm");
        btn_tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_cumTimKiem.add(btn_tim);

        JLabel label_quanLyKH = new JLabel("<html><u>Quản lý khách hàng</u></html>");
        label_quanLyKH.setHorizontalAlignment(SwingConstants.CENTER);
        label_quanLyKH.setFont(new Font("Tahoma", Font.PLAIN, 40));
        label_quanLyKH.setBounds(34, 32, 1134, 49);
        add(label_quanLyKH, BorderLayout.NORTH);


    }
}
