package app.giao_dien;

import app.phong_chu_moi.PhongChuMoi;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.LineBorder;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.Serial;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;


public class TrangKhachHang extends JPanel {
    public Color trang = new Color(255, 255, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();

    @Serial
    private static final long serialVersionUID = 1L;

    private JTextField textField_tenKH;
    private JTextField textField_sdt;
    private JTable table_bangThongTinKH;
    private JTextField textField_timTen;
    private JTextField textField_timSDT;

    /**
     * Create the panel.
     */
    public TrangKhachHang() {
        setPreferredSize(new Dimension(1200, 700));
        setLayout(new BorderLayout(0, 0));

        JLabel label_tieuDe = new JLabel("<html><u>Quản lý khách hàng</u></html>");
        label_tieuDe.setHorizontalAlignment(SwingConstants.CENTER);
        label_tieuDe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 40));
        add(label_tieuDe, BorderLayout.NORTH);

        JPanel panel_noiDung = new JPanel();
        panel_noiDung.setBorder(null);
        add(panel_noiDung, BorderLayout.CENTER);
        panel_noiDung.setLayout(null);

        JLabel lblThngTinKhch = new JLabel("Thông tin khách hàng");
        lblThngTinKhch.setBounds(10, 10, 324, 37);
        lblThngTinKhch.setHorizontalAlignment(SwingConstants.LEFT);
        lblThngTinKhch.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 30));
        lblThngTinKhch.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        panel_noiDung.add(lblThngTinKhch);

        JPanel panel_cumThongTinKH = new JPanel();
        panel_cumThongTinKH.setBorder(new LineBorder(new Color(0, 112, 255)));
        panel_cumThongTinKH.setBounds(34, 58, 743, 217);
        panel_noiDung.add(panel_cumThongTinKH);
        panel_cumThongTinKH.setLayout(null);

        JLabel label_maKH = new JLabel("Mã khách hàng:");
        label_maKH.setBounds(10, 10, 142, 25);
        panel_cumThongTinKH.add(label_maKH);
        label_maKH.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 20));

        JLabel label_HienThiMaKH = new JLabel("<mã khách hàng>");
        label_HienThiMaKH.setBounds(162, 10, 165, 25);
        panel_cumThongTinKH.add(label_HienThiMaKH);
        label_HienThiMaKH.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 20));

        JLabel label_tenKH = new JLabel("Họ và tên:");
        label_tenKH.setBounds(351, 10, 93, 25);
        panel_cumThongTinKH.add(label_tenKH);
        label_tenKH.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 20));

        textField_tenKH = new JTextField();
        textField_tenKH.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 20));
        textField_tenKH.setBorder(new LineBorder(new Color(0, 112, 255)));
        textField_tenKH.setBounds(478, 7, 255, 31);
        panel_cumThongTinKH.add(textField_tenKH);
        textField_tenKH.setColumns(10);

        JLabel lblSinThoi = new JLabel("Số điện thoại:");
        lblSinThoi.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 20));
        lblSinThoi.setBounds(351, 60, 124, 25);
        panel_cumThongTinKH.add(lblSinThoi);

        textField_sdt = new JTextField();
        textField_sdt.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 20));
        textField_sdt.setBorder(new LineBorder(new Color(0, 112, 255)));
        textField_sdt.setBounds(478, 57, 255, 31);
        panel_cumThongTinKH.add(textField_sdt);
        textField_sdt.setColumns(10);

        JLabel lblGiiTnh = new JLabel("Giới tính:");
        lblGiiTnh.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 20));
        lblGiiTnh.setBounds(10, 60, 82, 25);
        panel_cumThongTinKH.add(lblGiiTnh);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
        comboBox.setMaximumRowCount(2);
        comboBox.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 20));
        comboBox.setBounds(162, 57, 78, 31);
        panel_cumThongTinKH.add(comboBox);

        JLabel lblaCh = new JLabel("Địa chỉ:");
        lblaCh.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 20));
        lblaCh.setBounds(10, 107, 68, 25);
        panel_cumThongTinKH.add(lblaCh);

        JTextArea textArea_diaChi = new JTextArea();
        textArea_diaChi.setBounds(88, 111, 645, 96);
        textArea_diaChi.setBorder(new LineBorder(new Color(0, 112, 255)));
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
        scrollPane.setBounds(10, 347, 1180, 262);
        panel_noiDung.add(scrollPane);

        JPanel panel_cumNut = new JPanel();
        panel_cumNut.setBounds(823, 58, 345, 217);
        panel_noiDung.add(panel_cumNut);
        panel_cumNut.setLayout(null);

        JButton btn_CapNhat = new JButton("Cập nhật");
        btn_CapNhat.setBounds(0, 0, 172, 108);
        btn_CapNhat.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 25));
        panel_cumNut.add(btn_CapNhat);

        JButton btn_LamMoi = new JButton("Làm mới");
        btn_LamMoi.setBounds(172, 0, 172, 108);
        btn_LamMoi.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 25));
        panel_cumNut.add(btn_LamMoi);

        JButton btn_xemLichSu = new JButton("Xem lịch sử đặt vé");
        btn_xemLichSu.setBounds(0, 108, 344, 108);
        btn_xemLichSu.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 25));
        panel_cumNut.add(btn_xemLichSu);

        JLabel label_chucNang = new JLabel("Chức năng");
        label_chucNang.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 30));
        label_chucNang.setBounds(924, 10, 144, 37);
        panel_noiDung.add(label_chucNang);

        JPanel panel_cumTimKiem = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_cumTimKiem.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel_cumTimKiem.setBounds(34, 285, 1134, 52);
        panel_noiDung.add(panel_cumTimKiem);

        JLabel label_timTen = new JLabel("Tìm kiếm theo tên:");
        label_timTen.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 20));
        panel_cumTimKiem.add(label_timTen);

        textField_timTen = new JTextField();
        textField_timTen.setBorder(new LineBorder(new Color(0, 112, 255)));
        textField_timTen.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 20));
        panel_cumTimKiem.add(textField_timTen);
        textField_timTen.setColumns(10);

        JLabel lblTmKimTheo = new JLabel("Tìm kiếm theo số điện thoại:");
        lblTmKimTheo.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 20));
        panel_cumTimKiem.add(lblTmKimTheo);

        textField_timSDT = new JTextField();
        textField_timSDT.setBorder(new LineBorder(new Color(0, 112, 255)));
        textField_timSDT.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 20));
        panel_cumTimKiem.add(textField_timSDT);
        textField_timSDT.setColumns(10);

        JButton btn_tim = new JButton("Tìm");
        btn_tim.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 20));
        panel_cumTimKiem.add(btn_tim);


    }
}
