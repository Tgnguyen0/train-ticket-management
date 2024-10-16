package app.giao_dien;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.ScrollPane;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class TrangKhachHang extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField_timKiem;
    private JTable table;

    /**
     * Create the panel.
     */
    public TrangKhachHang() {
        setPreferredSize(new Dimension(1200, 700));
        setLayout(new BorderLayout(0, 0));

        JLabel label_tieuDe = new JLabel("<html><u>Quản lý khách hàng</u></html>");
        label_tieuDe.setHorizontalAlignment(SwingConstants.CENTER);
        label_tieuDe.setFont(new Font("Tahoma", Font.PLAIN, 40));
        label_tieuDe.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(label_tieuDe, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel label_thongTinKH = new JLabel("Thông tin khách hàng:");
        label_thongTinKH.setBounds(10, 10, 324, 37);
        label_thongTinKH.setHorizontalAlignment(SwingConstants.LEFT);
        label_thongTinKH.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label_thongTinKH.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        panel.add(label_thongTinKH);

        JLabel lblMKhchHng = new JLabel("Mã khách hàng:");
        lblMKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMKhchHng.setBounds(34, 58, 142, 25);
        panel.add(lblMKhchHng);

        JLabel labelHienThiMaKH = new JLabel("<mã khách hàng>");
        labelHienThiMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelHienThiMaKH.setBounds(186, 58, 165, 25);
        panel.add(labelHienThiMaKH);
    }
}
