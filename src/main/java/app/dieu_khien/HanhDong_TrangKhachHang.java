package app.dieu_khien;

import app.giao_dien.TrangKhachHang;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HanhDong_TrangKhachHang implements ActionListener, MouseListener, ListSelectionListener {
    private TrangKhachHang trangKhachHang;

    public HanhDong_TrangKhachHang(TrangKhachHang trangKhachHang) {
        this.trangKhachHang = trangKhachHang;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e, JTable table) {
        if(!e.getValueIsAdjusting()){
            int selectedRow = table.getSelectedRow();
            if(selectedRow != -1){
                String maKH = (String) table.getValueAt(selectedRow, 0);
                String tenKH = (String) table.getValueAt(selectedRow, 1);
                String diaChi = (String) table.getValueAt(selectedRow, 2);
                String soDT = (String) table.getValueAt(selectedRow, 3);
                String email = (String) table.getValueAt(selectedRow, 4);
                String gioiTinh = (String) table.getValueAt(selectedRow, 5);

                trangKhachHang.;
                trangKhachHang.setTenKH(tenKH);
                trangKhachHang.setDiaChi(diaChi);
                trangKhachHang.setSoDT(soDT);
                trangKhachHang.setEmail(email);
                trangKhachHang.setGioiTinh(gioiTinh);
            }
        }
    }
}
