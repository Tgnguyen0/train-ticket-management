package app.giao_dien;

import app.phong_chu_moi.PhongChuMoi;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

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
    private JPanel jPanel_lichSu_hinhAnh;
    private JLabel jLabel_lichSuHinhThanh;

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

        // PHẦN HÌNH ********************************

        //panel chứa hình ảnh
        jPanel_lichSu_hinhAnh = new JPanel(new BorderLayout());
        jPanel_lichSu_hinhAnh.setBackground(Color.white);
        jLabel_lichSuHinhThanh = new JLabel("Lịch sử hình thành", SwingConstants.CENTER);
        jLabel_lichSuHinhThanh.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 13));
        jLabel_lichSuHinhThanh.setForeground(xanhBrandeis);

        jPanel_lichSu_hinhAnh.add(jLabel_lichSuHinhThanh, BorderLayout.NORTH);
        // Xử lý ảnh
        Image roundedImage;
        try {
            BufferedImage image = ImageIO.read(new File("assets/nhaGa.jpg"));
            Image resizedImage = image.getScaledInstance(300, 200, Image.SCALE_SMOOTH);

            roundedImage = createRoundedImage(image, 40);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        JLabel jLabel_hinhAnhLichSu = new JLabel(new ImageIcon(roundedImage));


        jPanel_lichSu_hinhAnh.add(jLabel_hinhAnhLichSu, BorderLayout.SOUTH);

        // PHẦN LIST ********************************

        JPanel jPanel_lichSu_list = new JPanel();
        jPanel_lichSu_list.setLayout(new FlowLayout());
        jPanel_lichSu_list.setBackground(Color.white);
        String content = "<html> <div style=\"text-align: justify;\"> <br>"
                + "&#9906; 2010: Ga Gò Vấp chính thức được thành lập, cung cấp dịch vụ bán vé tàu tại ga <br> cho hành khách địa phương và du khách.<br>"
                + "&#9906; 2010 - 2024: Trong giai đoạn này, ga ghi vé bằng tay để phục vụ số lượng <br> khách lớn, giúp hàng triệu hành khách mỗi năm có chuyến đi thuận lợi.<br>"
                + "&#9906; 2024: Ra mắt ứng dụng đặt vé tàu \"Ga Gò Vấp\", cho phép người dùng dễ dàng <br> tìm kiếm và đặt vé tàu chỉ với vài cú chạm, đánh dấu bước tiến quan trọng <br> trong việc nâng cao trải nghiệm khách hàng."
                + "</div></html>";

        JLabel jLabel_list = new JLabel(content);
        jLabel_list.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        jLabel_list.setFont(phongTuyChinh.layPhongRobotoMonoReg(1, 13));
        jLabel_list.setForeground(xanhBrandeis);
        jPanel_lichSu_list.add(jLabel_list);


        // add các thành phần
        JPanel_tongHopNoiDung.add(jPanel_lichSu_list, BorderLayout.EAST);
        JPanel_tongHopNoiDung.add(jPanel_lichSu_hinhAnh, BorderLayout.WEST);
        trangChua.add(JPanel_tongHopNoiDung, BorderLayout.CENTER);
    }

    public static BufferedImage createRoundedImage(BufferedImage image, int cornerRadius) {
        int width = image.getWidth();
        int height = image.getHeight();

        // Tạo một BufferedImage mới với cùng kích thước
        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Vẽ ảnh bo góc vào BufferedImage
        Graphics2D g2 = output.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setClip(new RoundRectangle2D.Float(0, 0, width, height, cornerRadius, cornerRadius));
        g2.drawImage(image, 0, 0, null);
        g2.dispose();

        return output;
    }
}
