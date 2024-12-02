package app.dieu_khien;

import app.dao.CaTruc_DAO;
import app.giao_dien.TrangLichSuTruc;
import app.thuc_the.CaTruc;


import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class HanhDong_TrangLichSuTruc implements MouseListener, PropertyChangeListener {
    private TrangLichSuTruc trangLichSuTruc;

    public HanhDong_TrangLichSuTruc(TrangLichSuTruc trangLichSuTruc) {
        this.trangLichSuTruc = trangLichSuTruc;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
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
        trangLichSuTruc.label_hienTongTienHT.setText(String.valueOf(caTruc.getTongTienHoaDon()));
        trangLichSuTruc.label_hienTienCaTruoc.setText(String.valueOf(caTruc.getTongTienCaTruoc()));
        trangLichSuTruc.label_hienTongThucThu.setText(String.valueOf(caTruc.getTongTienThucThu()));
        trangLichSuTruc.label_hienChenhLech.setText(String.valueOf(caTruc.getThatThoat()));
        trangLichSuTruc.label_hienTongVAT.setText(String.valueOf(caTruc.getTongVAT()));
        trangLichSuTruc.label_hienTongGiamGia.setText(String.valueOf(caTruc.getTongTienGiamGia()));
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

}
