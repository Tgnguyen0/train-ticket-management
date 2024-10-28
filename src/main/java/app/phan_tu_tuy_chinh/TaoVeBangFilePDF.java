package app.phan_tu_tuy_chinh;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
public class TaoVeBangFilePDF {
    public void generateTicketPDF(String fileName, String maVe, String tenKhachHang, String gaKhoiHanh,
                                  String gaKetThuc,String ngayDatVe , String ngayKhoiHanh, String loaiVe , String soGhe
                                    ,String loaiDoiTuong, String giaVe) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            // Tiêu đề hóa đơn
            Font titleFont = new Font(Font.HELVETICA, 18, Font.BOLD, new Color(0, 102, 204));
            Paragraph title = new Paragraph("VÉ TÀU", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Thêm khoảng cách sau tiêu đề
            document.add(new Paragraph(" "));

            // Bảng chứa thông tin vé
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(80);
            table.setSpacingBefore(10);
            table.setSpacingAfter(10);

            // Font cho nội dung bảng
            Font font = new Font(Font.HELVETICA, 12, Font.NORMAL);

            // Dòng mã vé
            table.addCell(createCell("Mã vé:", font));
            table.addCell(createCell(maVe, font));

            // Dòng tên hành khách
            table.addCell(createCell("Tên hành khách:", font));
            table.addCell(createCell(tenKhachHang, font));

            // Dòng ga đi
            table.addCell(createCell("Ga Khởi Hành:", font));
            table.addCell(createCell(gaKhoiHanh, font));

            // Dòng ga đến
            table.addCell(createCell("Ga Kết Thúc:", font));
            table.addCell(createCell(gaKetThuc, font));

            // Dòng Đặt Vé
            table.addCell(createCell("Ngày Đặt Vé:", font));
            table.addCell(createCell(ngayDatVe, font));

            // Dòng ngày khởi hành
            table.addCell(createCell("Ngày khởi hành:", font));
            table.addCell(createCell(ngayKhoiHanh, font));

            // Dòng số ghế
            table.addCell(createCell("Số ghế:", font));
            table.addCell(createCell(soGhe, font));

            // Loại Đối Tượng
            table.addCell(createCell("Loại Đối Tượng:", font));
            table.addCell(createCell(loaiDoiTuong, font));


            table.addCell(createCell("Loại Vé:", font));
            table.addCell(createCell(loaiVe, font));

            table.addCell(createCell("Gía Vé:", font));
            table.addCell(createCell(giaVe, font));

            document.add(table);

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
        cell.setBorderColor(Color.LIGHT_GRAY);
        cell.setPadding(5);
        return cell;
    }

    public static void main(String[] args) {
        TaoVeBangFilePDF invoice = new TaoVeBangFilePDF();
//        invoice.generateTicketPDF("D:\\VeTau.pdf", "VN123456", "Nguyen Van A", "Hà Nội", "Hồ Chí Minh",
//                "2024-11-15", "15A");
    }
}
