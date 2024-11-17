package app.giao_dien;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TrangOTP extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JButton btn_guiOTP_1;

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

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField.setBounds(200, 7, 176, 31);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btn_guiOTP = new JButton("Gửi OTP");
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

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
        textField_1.setBounds(93, 45, 40, 55);
        panel.add(textField_1);
        textField_1.setColumns(1);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
        textField_2.setColumns(1);
        textField_2.setBounds(143, 45, 40, 55);
        panel.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
        textField_3.setColumns(1);
        textField_3.setBounds(193, 45, 40, 55);
        panel.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
        textField_4.setColumns(1);
        textField_4.setBounds(243, 45, 40, 55);
        panel.add(textField_4);

        btn_guiOTP_1 = new JButton("Xác nhận");
        btn_guiOTP_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        btn_guiOTP_1.setForeground(new Color(255, 255, 255));
        btn_guiOTP_1.setBackground(new Color(0, 112, 255));
        btn_guiOTP_1.setBorderPainted(false); // Bỏ viền của nút

        btn_guiOTP_1.setBounds(261, 230, 115, 33);
        contentPane.add(btn_guiOTP_1);
    }

}
