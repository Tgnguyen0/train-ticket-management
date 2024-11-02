package app.giao_dien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Component;

public class TrangLichSuDatVe extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TrangLichSuDatVe frame = new TrangLichSuDatVe();
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
    public TrangLichSuDatVe() {

        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        setSize(1200, 700);
        setLocationRelativeTo(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label_lichSuDatVe = new JLabel("Lịch sử đặt vé");
        label_lichSuDatVe.setBounds(5, 5, 1176, 49);
        label_lichSuDatVe.setHorizontalAlignment(SwingConstants.CENTER);
        label_lichSuDatVe.setFont(new Font("Tahoma", Font.PLAIN, 40));
        contentPane.add(label_lichSuDatVe);

        JPanel panel = new JPanel();
        panel.setBounds(5, 54, 409, 604);
        contentPane.add(panel);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel label_maKH = new JLabel("Mã khách hàng:");
        label_maKH.setHorizontalAlignment(SwingConstants.LEFT);
        label_maKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_maKH);

        JLabel label_hienThiMaKH = new JLabel("<mã khách hàng>>>>");
        label_hienThiMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_hienThiMaKH);

        JLabel label_tenKH = new JLabel("Tên khách hàng:");
        label_tenKH.setHorizontalAlignment(SwingConstants.LEFT);
        label_tenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_tenKH);

        JLabel label_hienThiTenKH = new JLabel("<Tên khách hàng>>>>");
        label_hienThiTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_hienThiTenKH);

        JLabel label_sdt = new JLabel("Số điện thoại:");
        label_sdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_sdt);

        JLabel label_hienSDT = new JLabel("<số điện thoại>>>>>>>>");
        label_hienSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_hienSDT);

        JLabel label_gioiTinh = new JLabel("Giới tính:");
        label_gioiTinh.setHorizontalAlignment(SwingConstants.LEFT);
        label_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_gioiTinh);

        JLabel label_hienGioiTinh = new JLabel("<Giới tính>>>>>>>>>>>>>");
        label_hienGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_hienGioiTinh);

        JLabel label_email = new JLabel("Email:");
        label_email.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_email);

        JLabel label_hienEmail = new JLabel("<Email>>>>>>>>>>>>>>>>>");
        label_hienEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_hienEmail);

        JLabel lable_tongSoHD = new JLabel("Tổng số hoá đơn:");
        lable_tongSoHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(lable_tongSoHD);

        JLabel lblNewLabel = new JLabel("<số hoá đơn>");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(419, 54, 762, 604);
        contentPane.add(panel_1);
    }
}
