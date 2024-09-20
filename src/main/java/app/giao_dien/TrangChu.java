package app.giao_dien;

import java.awt.*;

import app.phong_chu_moi.PhongChuMoi;
import javax.swing.*;

public class TrangChu extends JPanel {
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();

    public TrangChu() {
        setPreferredSize(new Dimension(1100, 200)); // 800, 500
        setLayout(new BorderLayout());
        setVisible(true);
        setFont(this.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 13));

        String duongDanAnh = "train_ticket_management/assets/trang-chu.png"; // Cho vscode
        // cho intelJ, eclipse
        // String duongDanAnh = "assets/coffee.gif";

        // Tạo icon cho ảnh
        ImageIcon bieuTuongAnh = new ImageIcon(duongDanAnh); // image_width: 2560, 1440

        // Tạo imageLabel cho ảnh
        JLabel tieuDeAnh = new JLabel(bieuTuongAnh);

        // Thêm imageLabel vào optionMenu
        add(tieuDeAnh, BorderLayout.WEST);
    }
}
