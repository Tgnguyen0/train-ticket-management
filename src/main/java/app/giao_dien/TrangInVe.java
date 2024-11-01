package app.giao_dien;

import app.dieu_khien.HanhDong_TrangDatVe;
import app.dieu_khien.HanhDong_TrangInVe;
import app.phong_chu_moi.PhongChuMoi;
import app.thuc_the.Ve;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TrangInVe extends JFrame {
    public JScrollPane trangChuaVe;
    public JPanel trangChua;
    public JButton nutXacNhanIn;

    public Color trang = new Color(255, 255, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public int charSize = 13;
    public int chieuDaiNut = 160;
    public int chieuRongNut = 50;
    public Border vienNhat = BorderFactory.createLineBorder(xanhNhat);
    public Border vienDam = BorderFactory.createLineBorder(xanhBrandeis);
    public Border gachChanNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhNhat);
    public Border gachChanDam = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis);

    public List<Ve> dsVe;
    public ActionListener hanhDong;
    public MouseListener thaoTacChuot;

    public TrangInVe(List<Ve> dsVe) {
        this.dsVe = dsVe;
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

            // Tạo văn bản mô tả chi tiết của vé
            String thongTinVe = String.format(
                    "<html>" +
                            "<table>" +
                            "<thead>" +
                            "<tr><th colspan=\"2\" style=\"font-size: 18px;\">Vé Lên Tàu</th></tr>" +  // Increase font size for the table header
                            "</thead>" +
                            "<tbody>" +
                            "<tr><td colspan=\"2\" style=\"text-align: center; padding: 20px; font-size: 11px;\">Mã vé: %s</td></tr>" +  // Increase font size for ticket code
                            "<tr><td style=\"font-size: 14px;\"><b>Thông Tin Chuyến đi</b></td><td style=\"font-size: 14px;\"><b>Thông Tin Khách hàng</b></td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Tàu: VN5432</td><td style=\"font-size: 11px;\">Tên khách hàng: Nguyễn Nhật Tấn</td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Ga khởi hành: %s</td><td style=\"font-size: 11px;\">Số điện thoại: </td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Ga kết thúc: %s</td><td style=\"font-size: 11px;\">Email: </td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Ngày khởi hành: %s</td><td style=\"font-size: 11px;\">Loại vé: %s</td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Ngày trở về: %s</td><td></td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Giờ đi: 10:00AM</td><td></td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Loại ghế: Ghế mềm</td><td></td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Toa: 1</td><td></td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Khoang: 1</td><td></td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Vị trí: 48</td><td></td></tr>" +
                            "<tr><td style=\"font-size: 11px; padding-right: 100px;\">Giá vé: %.0f VND</td><td></td></tr>" +
                            "</tbody>" +
                            "</table>" +
                            "</html>",
                    ve.getMaVe(),
                    ve.getGaKhoiHanh(),
                    ve.getGaKetThuc(),
                    ve.getNgayKhoiHanh(),
                    ve.getNgayDatVe(),
                    ve.getLoaiVe(),      // Assuming there's a method to get ticket type
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

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            // Giả sử dsVe chứa danh sách các đối tượng vé
            List<Ve> dsVe = new ArrayList<Ve>();/* khởi tạo danh sách các đối tượng vé */;
            dsVe.add(new Ve());
            dsVe.add(new Ve());
            dsVe.add(new Ve());
            dsVe.add(new Ve());
            dsVe.add(new Ve());
            dsVe.add(new Ve());
            dsVe.add(new Ve());
            dsVe.add(new Ve());
            dsVe.add(new Ve());

            for (int i = 0; i < dsVe.size(); i++) {
                Ve ve = dsVe.get(i);

                // Thiết lập các thuộc tính
                // Mã vé giả lập
                ve.setLoaiDoiTuong("Người lớn");                 // Loại đối tượng
                ve.setNgayKhoiHanh(LocalDateTime.now().plusDays(5)); // Ngày khởi hành sau 5 ngày từ hiện tại
                ve.setNgayDatVe(LocalDateTime.now());                // Ngày đặt vé là hôm nay
                ve.setGaKhoiHanh("Hà Nội");                      // Ga khởi hành
                ve.setGaKetThuc("Hồ Chí Minh");                  // Ga kết thúc
                ve.setGiaVe(100000 + (i * 50000));               // Giá vé tăng dần
                ve.setMaKhachHang("KH" + (100 + i));             // Mã khách hàng giả lập
                ve.setMaGhe("G" + (i + 1));                      // Mã ghế
                ve.setLoaiVe("Thường");                          // Loại vé
            }

            TrangInVe trangInVe = new TrangInVe(dsVe);
            trangInVe.setVisible(true);
        });
    }
}
