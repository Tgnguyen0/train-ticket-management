package app.dieu_khien;

import app.dao.NhanVien_DAO;
import app.giao_dien.TrangOTP;
import app.giao_dien.TrangQuenMatKhau;
import app.phan_tu_tuy_chinh.GanAmThanh;
import app.thuc_the.NhanVien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HanhDong_TrangOTP implements ActionListener, MouseListener {
    private TrangOTP trangOTP;
    public static String maNV;
    private boolean flag = false;

    public HanhDong_TrangOTP(TrangOTP trangOTP) {
        this.trangOTP = trangOTP;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GanAmThanh.playSound();

        if (e.getSource() == trangOTP.btn_guiOTP) {
            // Code here
            maNV = trangOTP.textField_nhapMaNV.getText();
            NhanVien nv = NhanVien_DAO.layThongTinNV(maNV);
            if( nv != null) {
                JOptionPane.showMessageDialog(null, "Đã gửi OTP về số điện thoại " + nv.getSoDT(), "Gửi OTP", JOptionPane.INFORMATION_MESSAGE);
                flag = true;
            } else if (nv == null) {
                JOptionPane.showMessageDialog(null, "Mã nhân viên không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == trangOTP.btn_xacNhan) {
            String regex = "^\\d$";
            if(!flag) {
                JOptionPane.showMessageDialog(null, "Vui lòng gửi OTP trước", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (trangOTP.textField_otp1.getText().matches(regex) && trangOTP.textField_otp2.getText().matches(regex) && trangOTP.textField_otp3.getText().matches(regex) && trangOTP.textField_otp4.getText().matches(regex)) {

                String otp = trangOTP.textField_otp1.getText() + trangOTP.textField_otp2.getText() + trangOTP.textField_otp3.getText() + trangOTP.textField_otp4.getText();
                if (otp.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Xác nhận OTP thành công", "Xác nhận OTP", JOptionPane.INFORMATION_MESSAGE);
                    trangOTP.dispose();
                    new TrangQuenMatKhau().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "OTP không chính xác", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "OTP không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if(source == trangOTP.btn_guiOTP) {
            trangOTP.btn_guiOTP.setBackground(new Color(66, 186, 255));
        } else if(source == trangOTP.btn_xacNhan) {
            trangOTP.btn_xacNhan.setBackground(new Color(66, 186, 255));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        if(source == trangOTP.btn_guiOTP) {
            trangOTP.btn_guiOTP.setBackground(new Color(0, 112, 255));
        } else if(source == trangOTP.btn_xacNhan) {
            trangOTP.btn_xacNhan.setBackground(new Color(0, 112, 255));
        }

    }
}
