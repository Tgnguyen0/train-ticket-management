package app.giao_dien;

import app.phong_chu_moi.PhongChuMoi;

import javax.swing.*;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Color;



public class TrangKhachHang extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField_timKiem;
    private JTable table;

    /**
     * Create the panel.
     */
    public TrangKhachHang() {
        setLayout(null);
        setPreferredSize(new Dimension(1200, 700));
        JLabel lblQunLKhch = new JLabel("<html><u>Quản lý khách hàng</u></html>");
        lblQunLKhch.setFont(new Font("Tahoma", Font.PLAIN, 40));
        lblQunLKhch.setBounds(100, 44, 353, 49);
        add(lblQunLKhch);

        JLabel lblMt = new JLabel("Một số chi tiết khác:");
        lblMt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMt.setBounds(100, 121, 190, 25);
        add(lblMt);

        JLabel lblGiiTnh = new JLabel("Giới tính:");
        lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblGiiTnh.setBounds(100, 168, 84, 20);
        add(lblGiiTnh);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmail.setBounds(343, 168, 63, 20);
        add(lblEmail);

        JLabel lblSinThoi = new JLabel("Số điện thoại:");
        lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSinThoi.setBounds(100, 198, 124, 25);
        add(lblSinThoi);

        JLabel lable_timKiem = new JLabel("Tìm kiếm khách hàng");
        lable_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lable_timKiem.setBounds(579, 109, 200, 49);
        add(lable_timKiem);

        textField_timKiem = new JTextField();
        textField_timKiem.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        textField_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_timKiem.setBounds(789, 118, 176, 31);
        add(textField_timKiem);
        textField_timKiem.setColumns(10);

        JButton btn_timKiem = new JButton("Tìm");
        btn_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_timKiem.setBounds(975, 121, 67, 25);
        add(btn_timKiem);

        JLabel label_luuY = new JLabel("Lưu ý:");
        label_luuY.setForeground(Color.RED);
        label_luuY.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_luuY.setBounds(579, 166, 56, 25);
        add(label_luuY);

        JLabel label_nhapDu10So = new JLabel("Nhập đủ 10 số");
        label_nhapDu10So.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_nhapDu10So.setBounds(645, 166, 130, 25);
        add(label_nhapDu10So);



        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 13));
        table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 112, 255), new Color(0, 112, 255)));
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                },
                new String[] {
                        "STT", "M\u00E3 kh\u00E1ch h\u00E0ng", "H\u1ECD v\u00E0 t\u00EAn", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9"
                }
        ));
        JTableHeader header = table.getTableHeader();
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 247, 865, 302);
        add(scrollPane);

        JLabel label_hienThiGioiTinh = new JLabel("<gioi tinh>");
        label_hienThiGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_hienThiGioiTinh.setBounds(189, 166, 101, 25);
        add(label_hienThiGioiTinh);

        JLabel label_hienThiSDT = new JLabel("<sdt>");
        label_hienThiSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_hienThiSDT.setBounds(234, 198, 55, 25);
        add(label_hienThiSDT);

        JLabel label_hienThiEmail = new JLabel("<email>");
        label_hienThiEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_hienThiEmail.setBounds(416, 166, 76, 25);
        add(label_hienThiEmail);

        JPanel panel_chucNang = new JPanel();
        panel_chucNang.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 112, 255), new Color(0, 112, 255)));
        panel_chucNang.setBounds(975, 247, 110, 302);
        add(panel_chucNang);

        JLabel lblChcNng = new JLabel("Chức năng");
        lblChcNng.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_chucNang.add(lblChcNng);

        JButton btnLamMoi = new JButton("Làm mới");
        btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel_chucNang.add(btnLamMoi);

        JButton btnCapNhat = new JButton("Cập nhật");
        btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel_chucNang.add(btnCapNhat);




    }
}
