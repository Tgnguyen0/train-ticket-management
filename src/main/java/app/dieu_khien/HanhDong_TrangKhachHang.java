package app.dieu_khien;

import app.giao_dien.TrangKhachHang;
import app.thuc_the.GIOI_TINH;
import app.thuc_the.KhachHang;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
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
    public void valueChanged(ListSelectionEvent e) {
        hienThiThongTinKhachHang(layThongTinKhachHangTuTable());
    }
    public KhachHang layThongTinKhachHangTuTable() {

        DefaultTableModel model = (DefaultTableModel) trangKhachHang.table.getModel();
        int row = trangKhachHang.table.getSelectedRow();
        String maKH = (String) model.getValueAt(row, 1);
        String hoTen = (String) model.getValueAt(row, 2);
        String sdt = (String) model.getValueAt(row, 3);
        String gioiTinh = (String) model.getValueAt(row, 4);
        String email = (String) model.getValueAt(row, 5);
        GIOI_TINH gt = GIOI_TINH.NAM;
        if (gioiTinh.equals("Nữ")) {
            gt = GIOI_TINH.NU;
        }
        String diaChi = (String) model.getValueAt(row, 6);
        return new KhachHang(maKH, hoTen, diaChi, sdt, email, gt);
    }

    public void hienThiThongTinKhachHang(KhachHang kh) {
        kh = layThongTinKhachHangTuTable();
        trangKhachHang.label_hienThiMaKH.setText(kh.getMaKH());
        trangKhachHang.textField_HoTen.setText(kh.getTenKH());
        trangKhachHang.textField_SDT.setText(kh.getSoDT());
        trangKhachHang.textField_email.setText(kh.getEmail());
        trangKhachHang.textArea_diaChi.setText(kh.getDiaChi());
        if (kh.getGioiTinh() == GIOI_TINH.NAM) {
            trangKhachHang.comboBox_gioiTinh.setSelectedIndex(0);
        } else {
            trangKhachHang.comboBox_gioiTinh.setSelectedIndex(1);
        }

    }
}
