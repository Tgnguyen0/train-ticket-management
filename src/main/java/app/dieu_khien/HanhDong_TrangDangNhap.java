package app.dieu_khien;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import app.dao.NhanVien_DAO;
import app.giao_dien.TrangDinhHuong;
import app.giao_dien.TrangDangNhap;
import app.giao_dien.TrangNhanVien;
import app.giao_dien.TrangOTP;
import app.phan_tu_tuy_chinh.GanAmThanh;
import app.thuc_the.GIOI_TINH;

import javax.swing.*;

public class HanhDong_TrangDangNhap implements ActionListener, MouseListener {
    TrangDangNhap trangDangNhap;
    public static String gioVaoTruc;
    public static String tenNV;
    public static String maNV;
    public static LocalDateTime ngayGioBatDau;


    public HanhDong_TrangDangNhap(TrangDangNhap trangDangNhap) {
        this.trangDangNhap = trangDangNhap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        GanAmThanh.playSound();

        if (source == this.trangDangNhap.nutDangNhap || source == this.trangDangNhap.truongMatKhau) {
            String username = this.trangDangNhap.truongTen.getText();
            username = username.trim();
            String twoLettersOfUsername = username.substring(0, 2);
            if(!twoLettersOfUsername.equals("NV")){
                JOptionPane.showMessageDialog(this.trangDangNhap, "Tên đăng nhập không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String password = new String(this.trangDangNhap.truongMatKhau.getPassword());
            if(NhanVien_DAO.login(username, password)) {
                maNV = username;
                this.trangDangNhap.setVisible(false);
                TrangDinhHuong trangDinhHuong = new TrangDinhHuong();
                if(NhanVien_DAO.getVaiTro(username).equals("manager")) {
                    TrangNhanVien.label_nhanVien.setText("QUẢN LÝ");
                }
                trangDinhHuong.trangNhanVien.lable_hienMaNV.setText(NhanVien_DAO.layThongTinNV(username).getMaNV());
                trangDinhHuong.trangNhanVien.textField_hoTen.setText(NhanVien_DAO.layThongTinNV(username).getTenNV());
                trangDinhHuong.trangNhanVien.dateChooser_ngaySinh.setDate(Date.from(NhanVien_DAO.layThongTinNV(username).getNgaySinh().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                trangDinhHuong.trangNhanVien.textArea_diaChi.setText(NhanVien_DAO.layThongTinNV(username).getDiaChi());
                trangDinhHuong.trangNhanVien.textField_sdt.setText(NhanVien_DAO.layThongTinNV(username).getSoDT());
                trangDinhHuong.trangNhanVien.comboBox_gt.setSelectedItem(NhanVien_DAO.layThongTinNV(username).getGioiTinh().getValue());


                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String formattedDateTime = now.format(formatter);
                ngayGioBatDau = now;
                gioVaoTruc = formattedDateTime;
                trangDinhHuong.trangNhanVien.label_hienGioVaoTruc.setText(formattedDateTime);
                trangDinhHuong.setVisible(true);
                TrangDangNhap.tenDangNhap = username;

                trangDinhHuong.trangDatVe.datMaNV(NhanVien_DAO.layThongTinNV(username).getMaNV());
                tenNV = NhanVien_DAO.layThongTinNV(username).getTenNV();
            } else {
                JOptionPane.showMessageDialog(this.trangDangNhap, "Sai tên đăng nhập hoặc mật khẩu", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (source == this.trangDangNhap.nutDangXuat) {
            System.exit(0);
        }

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == this.trangDangNhap.nhanQuenMatKhau) {
            this.trangDangNhap.setVisible(false);
            new TrangOTP().setVisible(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();

        if (source == this.trangDangNhap.nutDangNhap) {
            this.trangDangNhap.nutDangNhap.setBackground(new Color(this.trangDangNhap.xanhNhat.getRGB()));
        }

        if (source == this.trangDangNhap.nutDangXuat) {
            this.trangDangNhap.nutDangXuat.setBackground(new Color(this.trangDangNhap.xanhNhat.getRGB()));
        }

        if (source == this.trangDangNhap.nhanQuenMatKhau) {
            this.trangDangNhap.nhanQuenMatKhau.setForeground(new Color(this.trangDangNhap.xanhNhat.getRGB()));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();

        if (source == this.trangDangNhap.nutDangNhap) {
            this.trangDangNhap.nutDangNhap.setBackground(new Color(this.trangDangNhap.xanhBrandeis.getRGB()));
        }

        if (source == this.trangDangNhap.nutDangXuat) {
            this.trangDangNhap.nutDangXuat.setBackground(new Color(this.trangDangNhap.xanhBrandeis.getRGB()));
        }

        if (source == this.trangDangNhap.nhanQuenMatKhau) {
            this.trangDangNhap.nhanQuenMatKhau.setForeground(new Color(this.trangDangNhap.xanhBrandeis.getRGB()));
        }
    }
}
