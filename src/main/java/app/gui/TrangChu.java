package app.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TrangChu extends JFrame {
    public TrangChu() {
        ImageIcon icon = new ImageIcon("train_ticket_management_app/assets/icon.png"); // For vscode
        setSize(new Dimension(1000, 700));
        setLocationRelativeTo(null);
        setIconImage(icon.getImage());
        setTitle("Trang Chủ");

        getContentPane().setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());

    }

}
