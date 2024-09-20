package app.giao_dien;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import app.custom_component.RoundedBorder;
import app.init_font.PhongChuMoi;

// @important
// old Color: 161, 103, 37
// old OnClick Color: 196, 125, 44

public class TrangChu extends JFrame implements MouseListener, ActionListener {
    private JPanel trangChua;
    private JButton nutTrangChu;
    private JButton nutVe;
    private JButton nutHoaDon;
    private JButton nutGioiThieu;
    private JButton nutKhachHang;
    private JButton nutThongKe;
    private JButton nutNhanVien;

    private Color white = new Color(255, 255, 255);
    private Color brandeisBlue = new Color(0, 112, 255);
    private Color lightBlue = new Color(66, 186, 255);
    private int charSize = 13;
    private int doCaoNut = 50;
    private int doRongNut = 160;
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();
    private Border vienNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(lightBlue.getRGB()));
    private Border vienDam = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(brandeisBlue.getRGB()));

    // Function tạo GUI chính
    public TrangChu() {
        ImageIcon icon = new ImageIcon("train_ticket_management_app/assets/icon.png"); // Cho vscode
        // ImageIcon icon = new ImageIcon("asset/icon.png"); // Cho eclipse, Intelj
        setTitle("Quản lý bán vé tại ga");
        setSize(new Dimension(1200, 700));

        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(true);
        setLayout(new BorderLayout());

        taoThanhDinhHuong();
        taoTrangChua();
    }

    public void taoThanhDinhHuong() {
        JPanel thanhDinhHuong = new JPanel();
        thanhDinhHuong.setPreferredSize(new Dimension(1200, doCaoNut));
        thanhDinhHuong.setBackground(new Color(white.getRGB()));
        // thanhDinhHuong.setBackground(Color.RED);
        thanhDinhHuong.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        thanhDinhHuong.setBorder(this.vienDam);

        // Tạo Nút dẫn đến trang chủ
        nutTrangChu = new JButton("Trang Chủ");
        nutTrangChu.setPreferredSize(new Dimension(doRongNut, doCaoNut));
        nutTrangChu.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutTrangChu.setForeground(new Color(brandeisBlue.getRGB()));
        nutTrangChu.setBackground(new Color(white.getRGB()));
        nutTrangChu.setBorder(this.vienDam);
        nutTrangChu.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutTrangChu.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutTrangChu.addMouseListener(this);
        nutTrangChu.addActionListener(this);
        thanhDinhHuong.add(nutTrangChu);

        // Tạo Nút đến trang bán hàng
        nutVe = new JButton("Đặt Vé");
        nutVe.setPreferredSize(new Dimension(doRongNut, doCaoNut));
        nutVe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutVe.setForeground(new Color(brandeisBlue.getRGB()));
        nutVe.setBackground(new Color(white.getRGB()));
        nutVe.setBorder(this.vienDam);
        nutVe.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutVe.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutVe.addMouseListener(this);
        nutVe.addActionListener(this);
        thanhDinhHuong.add(nutVe);

        // Tạo Nút đến trang hóa đơn
        nutHoaDon = new JButton("Hóa Đơn");
        nutHoaDon.setPreferredSize(new Dimension(doRongNut, doCaoNut));
        nutHoaDon.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutHoaDon.setForeground(new Color(brandeisBlue.getRGB()));
        nutHoaDon.setBackground(new Color(white.getRGB()));
        nutHoaDon.setBorder(this.vienDam);
        nutHoaDon.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutHoaDon.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutHoaDon.setEnabled(false);
        nutHoaDon.addMouseListener(this);
        thanhDinhHuong.add(nutHoaDon);

        // Tạo Nút đến trang khách hàng
        nutKhachHang = new JButton("Khuyến Mại");
        nutKhachHang.setPreferredSize(new Dimension(doRongNut, doCaoNut));
        nutKhachHang.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutKhachHang.setForeground(new Color(brandeisBlue.getRGB()));
        nutKhachHang.setBackground(new Color(white.getRGB()));
        nutKhachHang.setBorder(this.vienDam);
        nutKhachHang.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutKhachHang.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutKhachHang.addMouseListener(this);
        nutKhachHang.addActionListener(this);
        thanhDinhHuong.add(nutKhachHang);

        // Tạo Nút đến trang thống kê
        nutThongKe = new JButton("Thống Kê");
        nutThongKe.setPreferredSize(new Dimension(doRongNut, doCaoNut));
        nutThongKe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutThongKe.setForeground(new Color(brandeisBlue.getRGB()));
        nutThongKe.setBackground(new Color(white.getRGB()));
        nutThongKe.setBorder(this.vienDam);
        nutThongKe.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutThongKe.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutThongKe.addMouseListener(this);
        nutThongKe.addActionListener(this);
        thanhDinhHuong.add(nutThongKe);

        // Tạo Nút đến trang sản phẩm
        nutGioiThieu = new JButton("Giới Thiệu");
        nutGioiThieu.setPreferredSize(new Dimension(doRongNut, doCaoNut));
        nutGioiThieu.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, charSize));
        nutGioiThieu.setForeground(new Color(brandeisBlue.getRGB()));
        nutGioiThieu.setBackground(new Color(white.getRGB()));
        nutGioiThieu.setBorder(vienDam);
        nutGioiThieu.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutGioiThieu.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)
        nutGioiThieu.addMouseListener(this);
        nutGioiThieu.addActionListener(this);
        thanhDinhHuong.add(nutGioiThieu);

        JPanel userPanel = new JPanel();
        userPanel.setPreferredSize(new Dimension(100, doCaoNut));
        userPanel.setBackground(new Color(white.getRGB()));
        userPanel.setBorder(this.vienDam);
        userPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 5));

        double doCaoTK = doCaoNut * 0.8;

        // Tạo Nút đến trang nhân viên
        nutNhanVien = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                String imagePath = "train_ticket_management_app/assets/icon.png"; // Cho vscode
                // String imagePath = "assets/icon.png"; // Cho intelJ, eclipse

                File imageFile = new File(imagePath);

                try {
                    Image avatar = ImageIO.read(imageFile);
                    double newWidth = doCaoTK; // Lấy độ rộng của nút
                    double newHeight = doCaoTK; // Lấy độ cao của nút
                    // Chỉnh kích thước ảnh phù hợp
                    avatar = avatar.getScaledInstance((int) newWidth, (int) newHeight, Image.SCALE_SMOOTH);

                    g.drawImage(avatar, 0, 0, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        nutNhanVien.setPreferredSize(new Dimension((int) doCaoTK, (int) doCaoTK));
        nutNhanVien.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        nutNhanVien.setForeground(new Color(brandeisBlue.getRGB()));
        nutNhanVien.setBackground(new Color(white.getRGB()));

        // Bỏ viền và focus của nút
        nutNhanVien.setBorderPainted(false); // Bỏ viền của nút
        nutNhanVien.setFocusPainted(false); // Bỏ viền khi click (focus)
        nutNhanVien.setContentAreaFilled(false); // Bỏ fill màu mặc định của JButton (nếu cần)

        nutNhanVien.addActionListener(this);
        userPanel.add(nutNhanVien);

        thanhDinhHuong.add(userPanel);

        add(thanhDinhHuong, BorderLayout.NORTH);
    }

    public void taoTrangChua() {
        // Khởi tạo trang chứa
        this.trangChua = new JPanel();
        this.trangChua.setPreferredSize(new Dimension(200, 200));
        this.trangChua.setLayout(new CardLayout());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {

        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton enteredButton = (JButton) e.getComponent();
        enteredButton.setForeground(new Color(lightBlue.getRGB())); // Thay đổi màu khi hover
        enteredButton.setBorder(this.vienNhat);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton exitedButton = (JButton) e.getComponent();
        exitedButton.setForeground(new Color(brandeisBlue.getRGB())); // Khôi phục màu ban đầu khi di chuột ra khỏi nút
        exitedButton.setBorder(this.vienDam);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) trangChua.getLayout();
        String command = e.getActionCommand();

        switch (command) {
            case "Trang Chủ":
                cardLayout.show(trangChua, "Home Page");
                break;
            case "Bán Hàng":
                cardLayout.show(trangChua, "Trang Đặt Vé");
                break;
            case "Hóa Đơn":
                cardLayout.show(trangChua, "Trang Hóa Đơn");
                break;
            case "Sản Phẩm":
                cardLayout.show(trangChua, "Trang Khách Hàng");
                break;
            case "Khuyến Mại":
                cardLayout.show(trangChua, "Trang Thống Kê");
                break;
            case "Thống Kê":
                cardLayout.show(trangChua, "Trang Giới Thiệu");
                break;
            case "Nhân Viên":
                cardLayout.show(trangChua, "Employee Page");
                break;
        }
    }
}
