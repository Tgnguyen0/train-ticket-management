package app.giao_dien;

import app.dao.Ghe_DAO;
import app.dao.KhachHang_DAO;
import app.dao.Toa_DAO;
import app.dieu_khien.HanhDong_TrangDatVe;
import app.dieu_khien.HanhDong_TrangInVe;
import app.phong_chu_moi.PhongChuMoi;
import app.thuc_the.Ghe;
import app.thuc_the.KhachHang;
import app.thuc_the.Toa;
import app.thuc_the.Ve;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TrangInVe extends JFrame {
    public JScrollPane trangChuaVe;
    public JPanel trangChua;
    public JButton nutXacNhanIn;

    public Color trang = new Color(255, 255, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    public PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public int charSize = 13;
    public int chieuDaiNut = 160;
    public int chieuRongNut = 50;
    public Border vienNhat = BorderFactory.createLineBorder(xanhNhat);
    public Border vienDam = BorderFactory.createLineBorder(xanhBrandeis);
    public Border gachChanNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhNhat);
    public Border gachChanDam = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis);

    public ActionListener hanhDong;
    public MouseListener thaoTacChuot;

    public Toa_DAO toaDao;

    public List<Ve> dsVe;
    public List<Ghe> dsGhe;
    public List<KhachHang> dsKH;

    public TrangInVe(List<Ve> dsVe, List<KhachHang> dsKhachDat, List<Ghe> dsGhe) {
        this.toaDao = new Toa_DAO();

        this.dsVe = dsVe;
        this.dsGhe = dsGhe;
        this.dsKH = dsKhachDat;

        this.hanhDong = hanhDong;

        setTitle("Quản lý bán vé tại ga");
        setSize(new Dimension(800, 550));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(trang);
        setResizable(false);

        this.hanhDong = new HanhDong_TrangInVe(this);
        this.thaoTacChuot = new HanhDong_TrangInVe(this);

        taoTrangChuaVe();
        taoNutXacNhanIn();

        add(trangChuaVe, BorderLayout.CENTER);
        add(nutXacNhanIn, BorderLayout.SOUTH);
    }

    private void taoTrangChuaVe() {
        trangChua = new JPanel();
        trangChua.setLayout(new BoxLayout(trangChua, BoxLayout.Y_AXIS));
        trangChua.setBackground(trang);

        for (int i = 0; i < dsVe.size(); i++) {
            Ve ve = dsVe.get(i);

            Ghe ghe = null;
            for (int j = 0 ; j < this.dsGhe.size() ; j++) {
                if (dsGhe.get(j).getMaGhe().equals(ve.getMaGhe())) {
                    ghe = dsGhe.get(j);
                }
            }

            KhachHang kh = null;
            for (int j = 0 ; j < this.dsKH.size() ; j++) {
                if (dsKH.get(i).getMaKH().equals(ve.getMaKhachHang())) {
                    kh = dsKH.get(j);
                }
            }

            Toa toa = toaDao.ChonTheoMa(ghe.getMaToa());
            String soHieu = toa.getSoHieu();

            // Assuming ve.getGiaVe() returns a double; if not, ensure it does
            String thongTinVe = String.format(
                    "<html>" +
                            "<table>" +
                            "<thead>" +
                            "<tr><th colspan=\"2\" style=\"font-size: 18px;\">Vé Lên Tàu</th></tr>" +
                            "</thead>" +
                            "<tbody>" +
                            "<tr><td colspan=\"2\" style=\"text-align: center; padding: 20px; font-size: 11px;\">Mã vé: %s</td></tr>" +
                            "<tr><td style=\"font-size: 14px;\"><b>Thông Tin Chuyến đi</b></td><td style=\"font-size: 14px;\"><b>Thông Tin Khách hàng</b></td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Tàu: %s</td><td style=\"font-size: 11px;\">Tên khách hàng: %s</td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Ga khởi hành: %s</td><td style=\"font-size: 11px;\">Số điện thoại: %s</td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Ga kết thúc: %s</td><td style=\"font-size: 11px;\">Email: %s</td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Ngày khởi hành: %s</td><td style=\"font-size: 11px;\">Loại vé: Khu Hoi</td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Ngày đặt vé: %s</td><td></td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Giờ đi: %s</td><td></td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Loại ghế: %s</td><td></td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Toa: %s</td><td></td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Vị trí: %s</td><td></td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Giá vé: %.0f VND</td><td></td></tr>" +
                            "</tbody>" +
                            "</table>" +
                            "</html>",
                    ve.getMaVe(),
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
                    ve.getGiaVe()
            );

            JButton nutVe = new JButton(thongTinVe);
            nutVe.setPreferredSize(new Dimension(800, 450));
            nutVe.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 14));
            nutVe.setBackground(trang);
            nutVe.setBorder(gachChanDam);
            nutVe.setForeground(xanhBrandeis);
            nutVe.setFocusPainted(false);
            nutVe.addActionListener(this.hanhDong); // Gắn hành động

            trangChua.add(nutVe);
        }

        trangChuaVe = new JScrollPane(trangChua);
        trangChuaVe.setPreferredSize(new Dimension(800, 500));
        trangChuaVe.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        trangChuaVe.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        trangChuaVe.getViewport().setBackground(trang);
    }

    private void taoNutXacNhanIn() {
        nutXacNhanIn = new JButton("Xác nhận in vé");
        nutXacNhanIn.setPreferredSize(new Dimension(800, 50));
        nutXacNhanIn.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 14));
        nutXacNhanIn.setBackground(xanhBrandeis);
        nutXacNhanIn.setForeground(trang);
        nutXacNhanIn.setFocusPainted(false);
        nutXacNhanIn.setBorderPainted(false);
        nutXacNhanIn.addActionListener(hanhDong); // Gắn hành động in/xem trước
    }
}
