package app.giao_dien;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import app.phong_chu_moi.PhongChuMoi;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TrangChu extends JPanel {
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();

    public TrangChu() {
        setPreferredSize(new Dimension(1200, 600)); // Default size
        setLayout(new BorderLayout()); // Use BorderLayout for proper resizing
        setBackground(Color.red); // Background color, if the image doesn't fill the space
        setFont(this.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 13));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Always call the superclass's method first

        String duongDanAnh = "train_ticket_management_app/assets/trang-chu.png"; // Path to your image file
        File taiLieuAnh = new File(duongDanAnh);

        // Load and draw the image
        try {
            Image image = ImageIO.read(taiLieuAnh); // Load the image

            // Scale the image to the current panel's dimensions
            int chieuDai = getWidth(); // Get the width of the panel
            int chieuRong = getHeight(); // Get the height of the panel
            Image scaledImage = image.getScaledInstance(chieuDai, chieuRong, Image.SCALE_SMOOTH);

            // Draw the scaled image
            g.drawImage(scaledImage, 0, 0, this); // Draw at (0, 0)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}