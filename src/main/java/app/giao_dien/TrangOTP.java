package app.giao_dien;

import app.dieu_khien.HanhDong_TrangOTP;

import java.awt.*;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TrangOTP extends JFrame {

    private static final long serialVersionUID = 1L;
    public JButton btn_guiOTP;
    private JPanel contentPane;
    public JTextField textField_nhapMaNV;
    public JTextField textField_otp1;
    public JTextField textField_otp2;
    public JTextField textField_otp3;
    public JTextField textField_otp4;
    public JButton btn_xacNhan;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TrangOTP frame = new TrangOTP();
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
    public TrangOTP() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 396, 310);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.WHITE); // Set white background

        setTitle("Xác nhận OTP");
        setIconImage(Toolkit.getDefaultToolkit().getImage("assets/icon.png"));

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        setLocationRelativeTo(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label_nhapMaNV = new JLabel("Nhập mã nhân viên:");
        label_nhapMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_nhapMaNV.setForeground(new Color(0x0070FF)); // Set text color to #0070FF
        label_nhapMaNV.setBounds(10, 10, 180, 25);
        contentPane.add(label_nhapMaNV);

        textField_nhapMaNV = new JTextField();
        textField_nhapMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_nhapMaNV.setBounds(200, 7, 176, 31);
        contentPane.add(textField_nhapMaNV);
        textField_nhapMaNV.setColumns(10);

        btn_guiOTP = new JButton("Gửi OTP");
        btn_guiOTP.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_guiOTP.setBounds(269, 48, 107, 33);

        btn_guiOTP.setForeground(new Color(255, 255, 255));
        btn_guiOTP.setBackground(new Color(0, 112, 255));
        btn_guiOTP.setBorderPainted(false); // Bỏ viền của nút
        contentPane.add(btn_guiOTP);

        JPanel panel = new JPanel();
        panel.setBounds(10, 106, 366, 110);
        panel.setBackground(Color.WHITE); // Set white background
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel label_nhapOTP = new JLabel("Nhập mã OTP:");
        label_nhapOTP.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_nhapOTP.setForeground(new Color(0x0070FF)); // Set text color to #0070FF
        label_nhapOTP.setBounds(10, 10, 131, 25);
        panel.add(label_nhapOTP);

        textField_otp1 = new JTextField();
        textField_otp1.setFont(new Font("Tahoma", Font.PLAIN, 40));
        textField_otp1.setBounds(93, 45, 40, 55);
        panel.add(textField_otp1);
        textField_otp1.setColumns(1);

        textField_otp2 = new JTextField();
        textField_otp2.setFont(new Font("Tahoma", Font.PLAIN, 40));
        textField_otp2.setColumns(1);
        textField_otp2.setBounds(143, 45, 40, 55);
        panel.add(textField_otp2);

        textField_otp3 = new JTextField();
        textField_otp3.setFont(new Font("Tahoma", Font.PLAIN, 40));
        textField_otp3.setColumns(1);
        textField_otp3.setBounds(193, 45, 40, 55);
        panel.add(textField_otp3);

        textField_otp4 = new JTextField();
        textField_otp4.setFont(new Font("Tahoma", Font.PLAIN, 40));
        textField_otp4.setColumns(1);
        textField_otp4.setBounds(243, 45, 40, 55);
        panel.add(textField_otp4);

        btn_xacNhan = new JButton("Xác nhận");
        btn_xacNhan.setFont(new Font("Tahoma", Font.PLAIN, 20));

        btn_xacNhan.setForeground(new Color(255, 255, 255));
        btn_xacNhan.setBackground(new Color(0, 112, 255));
        btn_xacNhan.setBorderPainted(false); // Bỏ viền của nút

        btn_xacNhan.setBounds(261, 230, 115, 33);
        contentPane.add(btn_xacNhan);

        HanhDong_TrangOTP hd_trangOTP = new HanhDong_TrangOTP(this);
        MouseListener thaoTacChuot = hd_trangOTP;
        btn_guiOTP.addActionListener(hd_trangOTP);
        btn_xacNhan.addActionListener(hd_trangOTP);
        btn_guiOTP.addMouseListener(thaoTacChuot);
        btn_xacNhan.addMouseListener(thaoTacChuot);

    }

}
