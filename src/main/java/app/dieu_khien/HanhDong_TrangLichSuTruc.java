package app.dieu_khien;

import app.dao.CaTruc_DAO;
import app.giao_dien.TrangLichSuTruc;
import app.phan_tu_tuy_chinh.GanAmThanh;
import app.thuc_the.CaTruc;


import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class HanhDong_TrangLichSuTruc implements MouseListener, PropertyChangeListener {
    private TrangLichSuTruc trangLichSuTruc;

    public HanhDong_TrangLichSuTruc(TrangLichSuTruc trangLichSuTruc) {
        this.trangLichSuTruc = trangLichSuTruc;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        GanAmThanh.playSound();

        Object o = e.getSource();
        if (o == trangLichSuTruc.table) {
            this.layCaTruc();
        } else if ( o == trangLichSuTruc.btn_xemToanBo) {
            trangLichSuTruc.hienDanhSachTruc(trangLichSuTruc.label_hienMaNV.getText());
        }
    }

    private void layCaTruc() {
        int row = trangLichSuTruc.table.getSelectedRow();
        String maCaTruc = trangLichSuTruc.table.getValueAt(row, 1).toString();
        CaTruc caTruc = CaTruc_DAO.layThongTinCaTruc(maCaTruc);
        trangLichSuTruc.label_hienTongHD.setText(String.valueOf(caTruc.getTongHoaDon()));
        trangLichSuTruc.label_hienTongTienHT.setText(chuyenSangVND(caTruc.getTongTienHoaDon()));
        trangLichSuTruc.label_hienTienCaTruoc.setText(chuyenSangVND(caTruc.getTongTienCaTruoc()));
        trangLichSuTruc.label_hienTongThucThu.setText(chuyenSangVND(caTruc.getTongTienThucThu()));
        if( caTruc.getThatThoat() > 0){
            trangLichSuTruc.label_hienChenhLech.setText("Dư "+ chuyenSangVND(caTruc.getThatThoat()));
        } else if (caTruc.getThatThoat() < 0){
            trangLichSuTruc.label_hienChenhLech.setText("Thiếu " + chuyenSangVND(caTruc.getThatThoat() * -1));
        } else if (caTruc.getThatThoat() == 0){
            trangLichSuTruc.label_hienChenhLech.setText("Không chênh lệch");
            }
        trangLichSuTruc.label_hienTongVAT.setText(chuyenSangVND(caTruc.getTongVAT()));
        trangLichSuTruc.label_hienTongGiamGia.setText(chuyenSangVND(caTruc.getTongTienGiamGia()));
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
    public void propertyChange(PropertyChangeEvent evt) {
        Object newValue = evt.getNewValue();
        if (newValue instanceof Date) {
            LocalDateTime date = ((Date) newValue).toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            if (date != null) {
                this.hienLichSuTrucTheoNgay(date, trangLichSuTruc.label_hienMaNV.getText());
            }
        }
    }

    private void hienLichSuTrucTheoNgay(LocalDateTime date, String maNV) {
        DefaultTableModel tableModel = (DefaultTableModel) trangLichSuTruc.table.getModel();
        tableModel.setRowCount(0);
        ArrayList<CaTruc> dsCaTruc = CaTruc_DAO.layCaTrucTheoNgay(date, maNV);
        for (int i = 0; i < dsCaTruc.size(); i++) {
            CaTruc caTruc = dsCaTruc.get(i);
            tableModel.addRow(new Object[]{
                    i + 1,
                    caTruc.getMaCaTruc(),
                    caTruc.getNgayGioBatDau(),
                    caTruc.getNgayGioKetThuc()
            });
        }
    }
    private String chuyenSangVND(double tien) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(localeVN);
        String tienVND = formatter.format(tien);
        return tienVND;
    }

}
