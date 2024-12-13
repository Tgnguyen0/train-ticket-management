package app.phan_tu_tuy_chinh;
import app.phong_chu_moi.PhongChuMoi;
import com.lowagie.text.Image;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;

public class TaoVeBangFilePDF {
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();

    public void generateTicketPDF(String fileName, String maVe, String soHieu, String tenToa, String tenKhachHang, String gaKhoiHanh,
                                  String gaKetThuc, String ngayDatVe, String ngayKhoiHanh, String gioKhoiHanh, String loaiVe, String soGhe,
                                  String loaiDoiTuong, String giaVe) {
        // Get the path to the "ve" directory relative to the project's root directory
        /*String relativePath = ".." + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "ve";

        // Get the current working directory (the directory where the JAR is run from)
        String currentDir = System.getProperty("user.dir");

        // Combine the current directory with the relative path
        File veDirectory = new File(currentDir, relativePath);

        // Check if the directory exists, create it if it doesn't
        if (!veDirectory.exists()) {
            veDirectory.mkdirs(); // Create the directory if it doesn't exist
        }

        // Prepare the output file in the "ve" directory
        File outputFile = new File(veDirectory, fileName);*/

        String relativePath = "C:/Users/DELL/Desktop/Visual Studio Code/Java Project/train_ticket_management_app/src/main/resources/ve/" + fileName;

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(relativePath));
            document.open();

            Paragraph tieuDeTongCongTy = new Paragraph("TỔNG CÔNG TY ĐƯỜNG SẮT VIỆT NAM", phongTuyChinh.layPhongHelvetica(12, Font.NORMAL, new Color(0, 102, 204)));
            tieuDeTongCongTy.setAlignment(Element.ALIGN_CENTER);
            document.add(tieuDeTongCongTy);

            Paragraph tieuDeCongTyCon1 = new Paragraph("CÔNG TY CỔ PHẦN ĐƯỜNG SẮT SÀI GÒN", phongTuyChinh.layPhongHelvetica(12, Font.NORMAL, new Color(0, 102, 204)));
            tieuDeCongTyCon1.setAlignment(Element.ALIGN_CENTER);
            document.add(tieuDeCongTyCon1);

            Paragraph tieuDeCongTyCon2 = new Paragraph("GA GÒ VẤP", phongTuyChinh.layPhongHelvetica(12, Font.NORMAL, new Color(0, 102, 204)));
            tieuDeCongTyCon2.setAlignment(Element.ALIGN_CENTER);
            document.add(tieuDeCongTyCon2);

            Paragraph title = new Paragraph("THẺ LÊN TÀU HỎA", phongTuyChinh.layPhongHelvetica(20, Font.NORMAL, new Color(0, 102, 204)));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            Paragraph tieuDeTheTauAnhNgu = new Paragraph("BOARDING PASS", phongTuyChinh.layPhongHelvetica(15, Font.NORMAL, new Color(0, 102, 204)));
            tieuDeTheTauAnhNgu.setAlignment(Element.ALIGN_CENTER);
            document.add(tieuDeTheTauAnhNgu);

            // Thêm khoảng cách sau tiêu đề
            document.add(new Paragraph(" "));

            PdfPTable thongTin = new PdfPTable(2);
            thongTin.setWidthPercentage(90);
            thongTin.setSpacingBefore(10);
            thongTin.setSpacingAfter(10);

            // Bảng chứa thông tin vé
            PdfPTable thongTinTau = new PdfPTable(2);
            thongTinTau.setWidthPercentage(45);
            thongTinTau.setSpacingBefore(10);
            thongTinTau.setSpacingAfter(10);

            // Font cho nội dung bảng
            Font font = phongTuyChinh.layPhongHelvetica(12, Font.NORMAL, null);

            // Dòng mã vé
            thongTinTau.addCell(createCell("Mã vé:", font));
            thongTinTau.addCell(createCell(maVe, font));

            // Dòng ga đi
            thongTinTau.addCell(createCell("Ga Khởi Hành:", font));
            thongTinTau.addCell(createCell(gaKhoiHanh.toUpperCase(), font));

            // Dòng ga đến
            thongTinTau.addCell(createCell("Ga Kết Thúc:", font));
            thongTinTau.addCell(createCell(gaKetThuc.toUpperCase(), font));

            // Dòng số hiệu tàu
            thongTinTau.addCell(createCell("Số hiệu:", font));
            thongTinTau.addCell(createCell(soHieu, font));

            // Dòng tên toa
            thongTinTau.addCell(createCell("Toa:", font));
            thongTinTau.addCell(createCell(tenToa, font));

            // Dòng ngày khởi hành
            thongTinTau.addCell(createCell("Ngày khởi hành:", font));
            thongTinTau.addCell(createCell(ngayKhoiHanh, font));

            thongTinTau.addCell(createCell("Giờ khởi hành:", font));
            thongTinTau.addCell(createCell(gioKhoiHanh, font));

            // Dòng loại ghế
            thongTinTau.addCell(createCell("Số ghế:", font));
            thongTinTau.addCell(createCell(soGhe, font));

            thongTinTau.addCell(createCell("Loại Vé:", font));
            thongTinTau.addCell(createCell(loaiVe, font));

            thongTinTau.addCell(createCell("Giá Vé:", font));
            thongTinTau.addCell(createCell(giaVe, font));

            PdfPTable thongTinKH = new PdfPTable(2);
            thongTinKH.setWidthPercentage(45);
            thongTinKH.setSpacingBefore(10);
            thongTinKH.setSpacingAfter(10);

            // Dòng tên hành khách
            thongTinKH.addCell(createCell("Tên hành khách:", font));
            thongTinKH.addCell(createCell(tenKhachHang, font));

            // Loại Đối Tượng
            thongTinKH.addCell(createCell("Loại Đối Tượng:", font));
            thongTinKH.addCell(createCell(loaiDoiTuong, font));

            // Thông tin của vé
            String thongTinCuaVe = "Ma Ve: " + maVe + "\n" +
                    "So Hieu: " + soHieu + "\n" +
                    "Ten Toa: " + tenToa + "\n" +
                    "Ten Khach Hang: " + tenKhachHang + "\n" +
                    "Ga Khoi Hanh: " + gaKhoiHanh + "\n" +
                    "Ga Ket Thuc: " + gaKetThuc + "\n" +
                    "Ngay Dat Ve: " + ngayDatVe + "\n" +
                    "Ngay Khoi Hanh: " + ngayKhoiHanh + "\n" +
                    "Gio Khoi Hanh: " + gioKhoiHanh + "\n" +
                    "Loai Ve: " + loaiVe + "\n" +
                    "So Ghe: " + soGhe + "\n" +
                    "Loai Doi Tuong: " + loaiDoiTuong + "\n" +
                    "Gia Ve: " + giaVe;

            Image anhMaQR = addQRCode(thongTinCuaVe);
            PdfPCell chuaMaQR = new PdfPCell(anhMaQR);
            chuaMaQR.setColspan(2);
            chuaMaQR.setBorderColor(Color.WHITE);
            thongTinKH.addCell(chuaMaQR);

            PdfPCell tieuDebenTrai = new PdfPCell(new Paragraph("Thông tin Vé", phongTuyChinh.layPhongHelvetica(16, Font.NORMAL, Color.BLACK)));
            tieuDebenTrai.setBorderColor(Color.WHITE);
            tieuDebenTrai.setVerticalAlignment(Element.ALIGN_LEFT);
            tieuDebenTrai.setPaddingRight(45);
            thongTin.addCell(tieuDebenTrai);

            PdfPCell tieuDeBenPhai = new PdfPCell(new Paragraph("Thông tin Khách hàng", phongTuyChinh.layPhongHelvetica(16, Font.NORMAL, Color.BLACK)));
            tieuDeBenPhai.setBorderColor(Color.WHITE);
            tieuDeBenPhai.setVerticalAlignment(Element.ALIGN_RIGHT);
            tieuDeBenPhai.setPaddingLeft(45);
            thongTin.addCell(tieuDeBenPhai);

            PdfPCell benTrai = new PdfPCell(thongTinTau);
            benTrai.setBorderColor(Color.WHITE);
            benTrai.setVerticalAlignment(Element.ALIGN_LEFT);
            benTrai.setPaddingRight(45);
            thongTin.addCell(benTrai);

            PdfPCell benPhai = new PdfPCell(thongTinKH);
            benPhai.setBorderColor(Color.WHITE);
            benPhai.setVerticalAlignment(Element.ALIGN_RIGHT);
            benPhai.setPaddingLeft(45);
            thongTin.addCell(benPhai);

            document.add(thongTin);

            // Thông điệp cảm ơn
            Font thankYouFont = new Font(Font.HELVETICA, 12, Font.ITALIC, Color.GRAY);
            Paragraph thankYou = new Paragraph("Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi!", thankYouFont);
            thankYou.setAlignment(Element.ALIGN_CENTER);
            document.add(thankYou);

            document.close();
            System.out.println("Hóa đơn vé tàu đã được tạo thành công!");

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    private PdfPCell createCell(String content, Font font) {
        PdfPCell cell = new PdfPCell(new Paragraph(content, font));
        //cell.setBorder(PdfPCell.NO_BORDER);
        cell.setBorderColor(Color.WHITE);
        cell.setPadding(5);
        return cell;
    }

    public Image addQRCode(String qrText) {
        // Tạo mã QR

        try {
            BufferedImage qrImage = new TaoMaQR().generateQRCodeImage(qrText); //
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); //
            ImageIO.write(qrImage, "png", baos); // Ảnh theo dịnh dạng .png
            Image qrCode = Image.getInstance(baos.toByteArray()); //
            qrCode.scaleAbsolute(160, 160); // Thiết lặp kích thước

            return qrCode;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        TaoVeBangFilePDF invoice = new TaoVeBangFilePDF();
//        invoice.generateTicketPDF("D:\\VeTau.pdf", "VN123456", "Nguyen Van A", "Hà Nội", "Hồ Chí Minh",
//                "2024-11-15", "15A");
          invoice.generateTicketPDF(
                  "vé được tạo/VeTau.pdf",
                  "V123456",
                  "VN0173",
                  "A1",
                  "Nguyen Tran Van A",
                  "Sài gòn",
                  "Hà nội",
                  String.valueOf(LocalDateTime.now().getYear()) + "-" + LocalDateTime.now().getMonthValue() + "-" + LocalDateTime.now().getDayOfMonth(),
                  LocalDateTime.now().getYear() + "-" + LocalDateTime.now().getMonthValue() + "-" + LocalDateTime.now().getDayOfMonth(),
                  "10:00",
                  "Ghế mềm",
                  "45","Người lớn",
                  "754000"
          );
    }
}
