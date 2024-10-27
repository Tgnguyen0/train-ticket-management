package app.dieu_khien;

import app.dao.Ve_DAO;
import app.dao.testDataVe;
import app.giao_dien.TrangDanhSachVeTau;
import app.giao_dien.TrangDinhHuong;
import app.thuc_the.Ve;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
@Slf4j
public class HanhDong_TrangDanhSachVe implements ActionListener, MouseListener {
    Logger logger = LoggerFactory.getLogger(TrangDanhSachVeTau.class);
    TrangDanhSachVeTau trangDanhSachVeTau ;
    Ve_DAO databaseVe ;
    public HanhDong_TrangDanhSachVe(TrangDanhSachVeTau trangDanhSachVeTau){
        this.trangDanhSachVeTau = trangDanhSachVeTau;
        this.databaseVe = new Ve_DAO();

        List<Ve> dsVe = null;
        try {
            dsVe = databaseVe.layToanBoVe();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        trangDanhSachVeTau.dayDuLieuVaoBang(dsVe);
        logger.info("lấy thành công");

    }


    public  void quanLyDanhSachVeTrongBang() throws SQLException {
        List<Ve> dsVe = databaseVe.layToanBoVe();
        trangDanhSachVeTau.dayDuLieuVaoBang(dsVe);
        logger.info("lấy thành công");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == this.trangDanhSachVeTau.lamMoi) {
//            try {
//                quanLyDanhSachVeTrongBang();
//                logger.info("lấy thành công");
//
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
//        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int location = this.trangDanhSachVeTau.table.getSelectedRow();
        logger.info(location+"");
        String maVe = (String) this.trangDanhSachVeTau.model.getValueAt(location, 0);
        logger.info(maVe);
        try {
            Ve ve = databaseVe.layVe_DuaVaoMaVe(maVe);
            logger.info(ve.toString());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

//        this.trangDanhSachVeTau.thanh
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
