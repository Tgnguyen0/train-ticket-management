package app.giao_dien;

import app.phong_chu_moi.PhongChuMoi;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class TrangGioiThieu extends JPanel {
    /* Khoi tao Cac thanh phan */
    public JPanel trangChua;

    /* Khoi Tao Phong Chu Mau Sac */
    public int kichThuocChu = 12;
    public int chieuDaiNut = 210;
    public int chieuRongNut = 30;
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public Color trang = new Color(255, 255, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    public Border vienNhat = BorderFactory.createLineBorder(xanhNhat);
    public Border vienDam = BorderFactory.createLineBorder(xanhBrandeis);
    public Border gachChanNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhNhat);
    public Border gachChanDam = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis);

    private ActionListener hanhDong;
    private MouseListener thaoTacChuot;
    private JPanel JPanel_tieuDe;
    private JLabel JLabel_tieuDeLon;
    private JPanel JPanel_tongHopNoiDung;
    private JPanel JPanel_lichSu;
    private JPanel JPanel_lichSu_hinhAnh;

    public TrangGioiThieu() {
        setPreferredSize(new Dimension(1200, 700));
        setLayout(new BorderLayout());
        setFont(this.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 13));

        trangChua = new JPanel();
        trangChua.setPreferredSize(new Dimension(1200, 700));
        trangChua.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        trangChua.setBackground(trang);
        add(trangChua, BorderLayout.CENTER);
        taoTieuDe();
        taoThongTinGioiThieu();
    }

    private void taoTieuDe() {

        // tạo panel cho tiêu đề
        JPanel_tieuDe = new JPanel();
        JPanel_tieuDe.setBackground(Color.white);
        JPanel_tieuDe.setSize(300, 300);
        JPanel_tieuDe.setLayout(new BorderLayout());

        //tạo tiêu đề lớn
        JLabel_tieuDeLon = new JLabel("<html>Giới Thiệu Ứng Dụng Đặt Vé Tàu - Ga Gò Vấp<br></html>",SwingConstants.CENTER);
        JLabel_tieuDeLon.setFont(this.phongTuyChinh.layPhongRobotoMonoReg(2, 30));
        JLabel_tieuDeLon.setForeground(xanhBrandeis);
        JLabel_tieuDeLon.setBackground(Color.white);


        //tạo tiêu đề nhỏ
        JLabel JLable_tieuDeNho = new JLabel("<html><div style=\"text-align: center;\">&#8213;Ga Gò Vấp tự hào mang đến cho bạn một ứng dụng đặt vé tàu&#8213;<br>tiện lợi, hiện đại và nhanh chóng</div></html>",SwingConstants.CENTER);
        JLable_tieuDeNho.setFont(phongTuyChinh.layPhongRobotoMonoReg(1,15));
        JLable_tieuDeNho.setForeground(xanhBrandeis);

        JPanel_tieuDe.add(JLabel_tieuDeLon, BorderLayout.NORTH);
        JPanel_tieuDe.add(JLable_tieuDeNho, BorderLayout.CENTER);

        trangChua.add(JPanel_tieuDe, BorderLayout.NORTH);


    }



    private void taoThongTinGioiThieu() {
        //chia nội dung thành 2 panel là lịch sử và thông tin phần mềm

        // tạo 1 panel chứa tất cả nội dung
        JPanel_tongHopNoiDung = new JPanel();
        JPanel_tongHopNoiDung.setLayout(new BorderLayout());

        //panel nội dung LỊCH SỬ
        JPanel_lichSu = new JPanel();
        JPanel_lichSu.setLayout(new BorderLayout());

        // chia lịch sử ra thành 2 panel nhỏ. 1 là hình, 1 là text

        //panel chứa hình ảnh
        JPanel_lichSu_hinhAnh = new JPanel(new BorderLayout());
        JPanel_lichSu_hinhAnh.setBackground(Color.white);
        JLabel JLabel_lichSuHinhThanh = new JLabel("Lịch sử hình thành", SwingConstants.CENTER);
        JLabel_lichSuHinhThanh.setFont(phongTuyChinh.layPhongRobotoMonoReg(2,13));
        JLabel_lichSuHinhThanh.setForeground(xanhBrandeis);

        JPanel_lichSu_hinhAnh.add(JLabel_lichSuHinhThanh, BorderLayout.NORTH);

        //tạo hình ảnh
        ImageIcon img_lichSu = new ImageIcon("assets/nhaGa.jpg");
        JLabel JLabel_hinhAnhLichSu = new JLabel(img_lichSu);


        JPanel_lichSu_hinhAnh.add(JLabel_hinhAnhLichSu, BorderLayout.SOUTH);

        JPanel_tongHopNoiDung.add(JPanel_lichSu_hinhAnh, BorderLayout.WEST);
        trangChua.add(JPanel_tongHopNoiDung, BorderLayout.CENTER);
    }
}
