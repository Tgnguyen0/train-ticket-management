package app.dieu_khien;

import app.dao.Ve_DAO;
import app.giao_dien.TrangDanhSachVeTau;
import app.thuc_the.Ve;
import lombok.SneakyThrows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

public class HanhDong_TrangDanhSachVe implements ActionListener, MouseListener {
    TrangDanhSachVeTau trangDanhSachVeTau ;
    Ve_DAO databaseVe ;
    public HanhDong_TrangDanhSachVe(TrangDanhSachVeTau trangDanhSachVeTau) {
        this.trangDanhSachVeTau = trangDanhSachVeTau;
        this.databaseVe = new Ve_DAO();

    }


    public  void quanLyDanhSachVeTrongBang() throws SQLException {
        List<Ve> dsVe = databaseVe.layToanBoVe();
        trangDanhSachVeTau.dayDuLieuVaoBang(dsVe);
    }

    @SneakyThrows
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.trangDanhSachVeTau.lamMoi) {
            quanLyDanhSachVeTrongBang();
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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
