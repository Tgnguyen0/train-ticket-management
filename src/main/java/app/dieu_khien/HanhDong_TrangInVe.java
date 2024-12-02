package app.dieu_khien;

import app.giao_dien.TrangDatVe;
import app.giao_dien.TrangDinhHuong;
import app.giao_dien.TrangInVe;
import app.phan_tu_tuy_chinh.TaoVeBangFilePDF;
import app.thuc_the.Ghe;
import app.thuc_the.KhachHang;
import app.thuc_the.Toa;
import app.thuc_the.Ve;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;

public class HanhDong_TrangInVe implements ActionListener, MouseListener, WindowListener {
    public TrangInVe trangInVe;

    public HanhDong_TrangInVe(TrangInVe trangInVe) {
        this.trangInVe = trangInVe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TaoVeBangFilePDF taoVeBangFilePDF = new TaoVeBangFilePDF();

        System.out.println(this.trangInVe.dsVe.get(0).getMaVe());

        if (e.getSource() == this.trangInVe.nutXacNhanIn) {

            for (Ve ve : this.trangInVe.dsVe) {

                Ghe ghe = null;
                for (int j = 0 ; j < this.trangInVe.dsGhe.size() ; j++) {
                    if (this.trangInVe.dsGhe.get(j).getMaGhe().equals(ve.getMaGhe())) {
                        ghe = this.trangInVe.dsGhe.get(j);
                    }
                }

                KhachHang kh = null;
                for (int j = 0 ; j < this.trangInVe.dsKH.size() ; j++) {
                    if (this.trangInVe.dsKH.get(j).getMaKH().equals(ve.getMaKhachHang())) {
                        kh = this.trangInVe.dsKH.get(j);
                    }
                }

                Toa toa = this.trangInVe.toaDao.ChonTheoMa(ghe.getMaToa());

                /*ve.getMaVe(),
                        soHieu,
                        kh.getTenKH(),
                        ve.getGaKhoiHanh(),
                        kh.getSoDT(),
                        ve.getGaKetThuc(),
                        kh.getEmail(),
                        ve.getNgayKhoiHanh().getYear() + "-" + ve.getNgayKhoiHanh().getMonth().getValue() + "-" + ve.getNgayKhoiHanh().getDayOfMonth(),
                        ve.getNgayDatVe().getYear() + "-" + ve.getNgayDatVe().getMonth().getValue() + "-" + ve.getNgayDatVe().getDayOfMonth(),
                        ve.getNgayKhoiHanh().getHour() + ":" + ve.getNgayKhoiHanh().getMinute(),
                        ve.getLoaiVe(),
                        toa.getTenToa(),
                        ghe.getSoGhe(),
                        ve.getGiaVe()*/

                String maVe = ve.getMaVe();
                /*String soHieu = toa.getSoHieu();
                String tenKH = kh.getTenKH();
                String diemDi = ve.getGaKhoiHanh();
                String sdtKH = kh.getSoDT();
                String diemDen = ve.getGaKetThuc();
                String emailKH = kh.getEmail();*/
                String ngayKhoiHanh = ve.getNgayKhoiHanh().getYear() + "-" + ve.getNgayKhoiHanh().getMonth().getValue() + "-" + ve.getNgayKhoiHanh().getDayOfMonth();
                String ngayDatVe = ve.getNgayDatVe().getYear() + "-" + ve.getNgayDatVe().getMonth().getValue() + "-" + ve.getNgayDatVe().getDayOfMonth();
                String gioKhoiHanh = ve.getNgayKhoiHanh().getHour() + ":" + ve.getNgayKhoiHanh().getMinute();
                /*String loaiVe = ve.getLoaiVe();
                String soGhe = String.valueOf(ghe.getSoGhe());
                String giaVe = String.valueOf(ve.getGiaVe());*/

                taoVeBangFilePDF.generateTicketPDF(
                        "vé được tạo/" + maVe + ".pdf",
                        ve.getMaVe(),
                        toa.getSoHieu(),
                        toa.getTenToa(),
                        kh.getTenKH(),
                        ve.getGaKhoiHanh(),
                        ve.getGaKetThuc(),
                        ngayDatVe,
                        ngayKhoiHanh,
                        gioKhoiHanh,
                        ve.getLoaiVe(),
                        ghe.getSoGhe(),
                        ve.getLoaiDoiTuong(),
                        String.valueOf(ve.getGiaVe())
                );
            }

            System.out.println("Den day 8");
            for (int i = ((TrangDatVe) TrangDinhHuong.getTrangChua().getComponent(1)).moHinhBang.getRowCount() - 1; i >= 0; i--) {
                ((TrangDatVe) TrangDinhHuong.getTrangChua().getComponent(1)).moHinhBang.removeRow(i);
            }

            System.out.println("Den day 9");
            hienThiThongBao("In vé thành công", "Thông báo in vé");

            System.out.println("Den day 10");
            this.trangInVe.dispose();
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

    private void hienThiThongBao(String chuThich, String tieuDe) {
        JLabel thongBao = new JLabel(chuThich);
        thongBao.setFont(this.trangInVe.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));

        JOptionPane hienThiLoi = new JOptionPane(thongBao, JOptionPane.INFORMATION_MESSAGE);
        hienThiLoi.setForeground(this.trangInVe.xanhBrandeis);

        JDialog hoiThoai = hienThiLoi.createDialog(tieuDe);
        ImageIcon bieuTuongTau = new ImageIcon("assets/icon.png");
        hoiThoai.setIconImage(bieuTuongTau.getImage());
        hoiThoai.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        ((TrangDatVe) TrangDinhHuong.getTrangChua().getComponent(1)).veDao.xoaDSVeDat();
        ((TrangDatVe) TrangDinhHuong.getTrangChua().getComponent(1)).gheDao.xoaDSGheChon();
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
