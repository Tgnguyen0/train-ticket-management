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
import java.io.IOException;

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
    private JPanel JPanel_tongHopNoiDungLichSu;
    private JPanel JPanel_lichSu;
    private JPanel jPanel_lichSu_phanHinhAnh;
    private JLabel jLabel_lichSuHinhThanh;
    private JLabel jLabel_hinhAnhLichSu;
    private JPanel jPanel_lichSu_phanText;
    private JLabel jLabel_hinhAnhNhanVien;
    private JLabel jLabel_hinhAnhHotline;

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
        JPanel_tieuDe.setLayout(new BorderLayout());

        //tạo tiêu đề lớn
        JLabel_tieuDeLon = new JLabel("<html>Giới Thiệu Ứng Dụng Đặt Vé Tàu - Ga Gò Vấp<br></html>",SwingConstants.CENTER);
        JLabel_tieuDeLon.setFont(this.phongTuyChinh.layPhongRobotoMonoReg(2, 30));
        JLabel_tieuDeLon.setForeground(xanhBrandeis);
        JLabel_tieuDeLon.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        JLabel_tieuDeLon.setBackground(Color.white);


        //tạo tiêu đề nhỏ
        JLabel JLable_tieuDeNho = new JLabel("<html><div style=\"text-align: center;\">&#8213;Ga Gò Vấp tự hào mang đến cho bạn một ứng dụng đặt vé tàu&#8213;<br>tiện lợi, hiện đại và nhanh chóng</div></html>",SwingConstants.CENTER);
        JLable_tieuDeNho.setFont(phongTuyChinh.layPhongRobotoMonoReg(3,15));
        JLable_tieuDeNho.setForeground(xanhBrandeis);
        JLable_tieuDeNho.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));


        JPanel_tieuDe.add(JLabel_tieuDeLon, BorderLayout.NORTH);
        JPanel_tieuDe.add(JLable_tieuDeNho, BorderLayout.CENTER);

        trangChua.add(JPanel_tieuDe, BorderLayout.NORTH);


    }



    private void taoThongTinGioiThieu() {
        //chia nội dung thành 2 panel là lịch sử và contact

        // tạo 1 panel chứa tất cả nội dung LS
        JPanel_tongHopNoiDungLichSu = new JPanel();
        JPanel_tongHopNoiDungLichSu.setLayout(new BorderLayout());
        JPanel_tongHopNoiDungLichSu.setBackground(Color.white);
        JPanel_tongHopNoiDungLichSu.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));

        //*********************PANEL PHẦN LỊCH SỬ***********************


        // chia lịch sử ra thành 2 panel nhỏ. 1 là hình, 1 là text

        // PHẦN HÌNH *********

        //panel chứa hình ảnh
        jPanel_lichSu_phanHinhAnh = new JPanel(new BorderLayout());
        jPanel_lichSu_phanHinhAnh.setBackground(Color.white);
        jLabel_lichSuHinhThanh = new JLabel("Lịch sử hình thành", SwingConstants.CENTER);
        jLabel_lichSuHinhThanh.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 13));
        jLabel_lichSuHinhThanh.setForeground(xanhBrandeis);

        jPanel_lichSu_phanHinhAnh.add(jLabel_lichSuHinhThanh, BorderLayout.NORTH);
        // Xử lý ảnh

        // Tải ảnh từ file
        try {
            BufferedImage image = ImageIO.read(new File("assets/nhaGa.jpg"));

            // Thay đổi kích thước ảnh trước khi bo góc (200x100)
            Image resizedImage = image.getScaledInstance(400, 200, Image.SCALE_SMOOTH);

            // Bo góc ảnh đã được thay đổi kích thước với góc bo 40px và thêm viền
            BufferedImage roundedImageWithBorder = createRoundedImageWithBorder(toBufferedImage(resizedImage), 40, 1, xanhBrandeis);

            // Chuyển đổi ảnh bo góc với viền thành ImageIcon
            ImageIcon iconImage = new ImageIcon(roundedImageWithBorder);

            // Đưa icon vào JLabel
            jLabel_hinhAnhLichSu = new JLabel(iconImage);


        } catch (IOException e) {
            e.printStackTrace();
        }

        jPanel_lichSu_phanHinhAnh.add(jLabel_hinhAnhLichSu, BorderLayout.SOUTH);

        // PHẦN TEXT ********************************
        jPanel_lichSu_phanText = new JPanel();
        jPanel_lichSu_phanText.setLayout(new BorderLayout());
        jPanel_lichSu_phanText.setBackground(Color.white);
        String content = "<html> <div style=\"text-align: justify;\"> <br>"
                + "&#9906; 2010: Ga Gò Vấp chính thức được thành lập, cung cấp dịch vụ bán vé tàu tại ga <br> cho hành khách địa phương và du khách.<br><br>"
                + "&#9906; 2010 - 2024: Trong giai đoạn này, ga ghi vé bằng tay để phục vụ số lượng <br> khách lớn, giúp hàng triệu hành khách mỗi năm có chuyến đi thuận lợi.<br><br>"
                + "&#9906; 2024: Ra mắt ứng dụng đặt vé tàu \"Ga Gò Vấp\", cho phép người dùng dễ dàng <br> tìm kiếm và đặt vé tàu chỉ với vài cú chạm, đánh dấu bước tiến quan trọng <br> trong việc nâng cao trải nghiệm khách hàng."
                + "</div></html>";

        JLabel jLabel_list = new JLabel(content);
        jLabel_list.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        jLabel_list.setFont(phongTuyChinh.layPhongRobotoMonoReg(1, 13));
        jLabel_list.setForeground(xanhBrandeis);
        jPanel_lichSu_phanText.add(jLabel_list, BorderLayout.CENTER);


        // add các thành phần
        JPanel_tongHopNoiDungLichSu.add(jPanel_lichSu_phanHinhAnh, BorderLayout.WEST);
        JPanel_tongHopNoiDungLichSu.add(jPanel_lichSu_phanText, BorderLayout.EAST);


        //*********************PANEL PHẦN CONTACT VÀ LÝ DO***********************
        // tạo panel chứa nội dung tong hop
        JPanel JPanel_tongHopContactVaLyDo = new JPanel();
        JPanel_tongHopContactVaLyDo.setLayout(new BorderLayout());
        JPanel_tongHopContactVaLyDo.setBackground(Color.white);

        // tạo panel chứa nội dung lý do
        JPanel JPanel_lyDo = new JPanel();
        JPanel_lyDo.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        JPanel_lyDo.setLayout(new BorderLayout());
        JPanel_lyDo.setBackground(Color.white);
        JLabel jLabel_lyDo = new JLabel("Lý do chọn ứng dụng", SwingConstants.LEFT);
        jLabel_lyDo.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 13));
        jLabel_lyDo.setForeground(xanhBrandeis);
        JPanel_lyDo.add(jLabel_lyDo, BorderLayout.NORTH);
        // xu ly anh lý do
        jLabel_hinhAnhNhanVien = new JLabel();
        try {
            BufferedImage image = ImageIO.read(new File("assets/nhanVien.png"));

            // Thay đổi kích thước ảnh trước khi bo góc (200x100)
            Image resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

            // Bo góc ảnh đã được thay đổi kích thước với góc bo 40px và thêm viền
            BufferedImage roundedImageWithBorder = createRoundedImageWithBorder(toBufferedImage(resizedImage), 40, 1, xanhBrandeis);

            // Chuyển đổi ảnh bo góc với viền thành ImageIcon
            ImageIcon iconImage = new ImageIcon(roundedImageWithBorder);

            // Đưa icon vào JLabel
            jLabel_hinhAnhNhanVien = new JLabel(iconImage);


        } catch (IOException e) {
            e.printStackTrace();
        }
        JPanel_lyDo.add(jLabel_hinhAnhNhanVien, BorderLayout.WEST);

        // tạo nội dung lý do
        String content_lyDo = "<html> <div style=\"text-align: justify;\"> <br>"
                + "&#10003; Dễ Dàng Sử Dụng<br><br>"
                + "&#10003; Quản Lý Về Hiệu Quả<br><br>"
                + "&#10003; Thông Tin Chi Tiết<br><br>"
                + "&#10003; Tích Hợp Thanh Toán<br><br>"
                + "&#10003; Nâng Cao Trải Nghiệm Khách Hàng<br><br>"
                + "&#10003; Tiết Kiệm Thời Gian<br>"
                + "</div></html>";

        JLabel jLabel_lyDo_text = new JLabel(content_lyDo);
        jLabel_lyDo_text.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        jLabel_lyDo_text.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 13));
        jLabel_lyDo_text.setForeground(xanhBrandeis);
        JPanel_lyDo.add(jLabel_lyDo_text, BorderLayout.EAST);


        // tạo panel chứa nội dung contact
        JPanel JPanel_contact = new JPanel();
        JPanel_contact.setLayout(new BorderLayout());
        JPanel_contact.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        JPanel_contact.setBackground(Color.white);
        JLabel jLabel_contact = new JLabel("Thông tin liên hệ", SwingConstants.LEFT);
        jLabel_contact.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 13));
        jLabel_contact.setForeground(xanhBrandeis);
        JPanel_contact.add(jLabel_contact, BorderLayout.NORTH);

        // tạo nội dung hinh anh contact
        // xu ly anh contact
        jLabel_hinhAnhHotline = new JLabel();
        try {
            BufferedImage image = ImageIO.read(new File("assets/hotline.png"));

            // Thay đổi kích thước ảnh trước khi bo góc (200x100)
            Image resizedImage = image.getScaledInstance(300, 200, Image.SCALE_SMOOTH);

            // Bo góc ảnh đã được thay đổi kích thước với góc bo 40px và thêm viền
            BufferedImage roundedImageWithBorder = createRoundedImageWithBorder(toBufferedImage(resizedImage), 40, 1, xanhBrandeis);

            // Chuyển đổi ảnh bo góc với viền thành ImageIcon
            ImageIcon iconImage = new ImageIcon(roundedImageWithBorder);

            // Đưa icon vào JLabel
            jLabel_hinhAnhHotline = new JLabel(iconImage);


        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel_contact.add(jLabel_hinhAnhHotline, BorderLayout.CENTER);

        // tao noi dung contact
        String content_contact = "<html> <div style=\"text-align: justify;\"> "
                + "<b>Email</b>:<br> gaGV@gmail.com<br><br>"
                + "<b>Hotline</b>:<br> 0909-123-456<br><br>"
                + "<b>Địa chỉ văn phòng</b>: <br> 123 Đường Thống Nhất, Quận <br> Gò Vấp, TP. Hồ Chí Minh, Việt Nam<br>";
        JLabel jLabel_contact_text = new JLabel(content_contact);
        jLabel_contact_text.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        jLabel_contact_text.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 13));
        jLabel_contact_text.setForeground(xanhBrandeis);
        JPanel_contact.add(jLabel_contact_text, BorderLayout.EAST);





        JPanel_tongHopContactVaLyDo.add(JPanel_lyDo, BorderLayout.WEST);
        JPanel_tongHopContactVaLyDo.add(JPanel_contact, BorderLayout.EAST);

        //add vao trang chua
        trangChua.add(JPanel_tongHopNoiDungLichSu, BorderLayout.CENTER);
        trangChua.add(JPanel_tongHopContactVaLyDo, BorderLayout.SOUTH);
    }

    // Hàm tạo ảnh bo góc với viền
    public static BufferedImage createRoundedImageWithBorder(BufferedImage image, int cornerRadius, int borderWidth, Color borderColor) {
        int width = image.getWidth();
        int height = image.getHeight();

        // Tạo một BufferedImage mới với cùng kích thước và thêm vùng cho viền
        BufferedImage output = new BufferedImage(width + 2 * borderWidth, height + 2 * borderWidth, BufferedImage.TYPE_INT_ARGB);

        // Vẽ viền tròn vào BufferedImage
        Graphics2D g2 = output.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ viền trước
        g2.setColor(borderColor);
        g2.fill(new RoundRectangle2D.Float(0, 0, width + 2 * borderWidth, height + 2 * borderWidth, cornerRadius + borderWidth, cornerRadius + borderWidth));

        // Vẽ ảnh bo góc vào giữa viền
        g2.setClip(new RoundRectangle2D.Float(borderWidth, borderWidth, width, height, cornerRadius, cornerRadius));
        g2.drawImage(image, borderWidth, borderWidth, null);

        // Giải phóng tài nguyên
        g2.dispose();

        return output;
    }

    // Chuyển đổi Image thành BufferedImage
    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Tạo một BufferedImage với cùng kích thước của ảnh
        BufferedImage bimage = new BufferedImage(
                img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Vẽ ảnh vào BufferedImage
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bimage;
    }


}
