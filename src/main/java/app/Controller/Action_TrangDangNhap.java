package app.Controller;

import app.gui.TrangChu;
import app.gui.TrangDangNhap;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Action_TrangDangNhap implements ActionListener, MouseListener {
    TrangDangNhap trangDangNhap;

    public Action_TrangDangNhap(TrangDangNhap trangDangNhap) {
        this.trangDangNhap = trangDangNhap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == this.trangDangNhap.loginButton) {
            String username = this.trangDangNhap.nameField.getText();
            String password = new String(this.trangDangNhap.passwordField.getPassword());

            if (username.equals("Admin") && password.equals("123")) {
                this.trangDangNhap.isCorrect = true;
                this.trangDangNhap.setVisible(false);
                TrangChu page = new TrangChu();
                page.setVisible(true);
            } else {
                this.trangDangNhap.isCorrect = false;
            }
        }

        if (source == this.trangDangNhap.logoutButton) {
            System.exit(0);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();

        if (source == this.trangDangNhap.loginButton) {
            this.trangDangNhap.loginButton.setBackground(new Color(this.trangDangNhap.lightBlue.getRGB()));
        }

        if (source == this.trangDangNhap.logoutButton) {
            this.trangDangNhap.logoutButton.setBackground(new Color(this.trangDangNhap.lightBlue.getRGB()));
        }

        if (source == this.trangDangNhap.forgetPassLabel) {
            this.trangDangNhap.forgetPassLabel.setForeground(new Color(this.trangDangNhap.lightBlue.getRGB()));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();

        if (source == this.trangDangNhap.loginButton) {
            this.trangDangNhap.loginButton.setBackground(new Color(this.trangDangNhap.brandeisBlue.getRGB()));
        }

        if (source == this.trangDangNhap.logoutButton) {
            this.trangDangNhap.logoutButton.setBackground(new Color(this.trangDangNhap.brandeisBlue.getRGB()));
        }

        if (source == this.trangDangNhap.forgetPassLabel) {
            this.trangDangNhap.forgetPassLabel.setForeground(new Color(this.trangDangNhap.brandeisBlue.getRGB()));
        }
    }
}
