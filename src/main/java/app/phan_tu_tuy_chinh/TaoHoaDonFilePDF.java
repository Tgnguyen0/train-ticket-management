package app.phan_tu_tuy_chinh;

import app.dao.NhanVien_DAO;
import app.phong_chu_moi.PhongChuMoi;
import app.thuc_the.HoaDon;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TaoHoaDonFilePDF {
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();

    public static void createInvoicePdf(HoaDon hoaDon) {
        try {
            // Đường dẫn lưu file vào ổ D:\
            String filePath = "D:\\HoaDon\\HoaDon_" + hoaDon.getMaHD() + ".pdf";

            // Khởi tạo tài liệu PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Định nghĩa font chữ
            BaseFont bf = BaseFont.createFont("font/RobotoMono-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font fontTitle = new Font(bf, 18, Font.BOLD);
            Font fontNormal = new Font(bf, 12, Font.NORMAL);
            Font fontItalic = new Font(bf, 12, Font.ITALIC);

            // Phần 1: Logo và tiêu đề "Hóa Đơn"
            Image logo = Image.getInstance("D:\\logo.png"); // Đường dẫn đến file logo
            logo.scaleToFit(100, 100);
            logo.setAlignment(Element.ALIGN_CENTER);
            document.add(logo);

            // Thêm tiêu đề hóa đơn
            Paragraph title = new Paragraph("HÓA ĐƠN", fontTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Thêm khoảng trắng
            document.add(new Paragraph(" "));

            // Phần 2: Thông tin công ty và thông tin hóa đơn

            // Thông tin công ty căn lề trái
            Paragraph companyInfo = new Paragraph();
            companyInfo.setAlignment(Element.ALIGN_LEFT);
            companyInfo.add(new Paragraph("Tên công ty: Nhà ga Gò Vấp", fontNormal));
            companyInfo.add(new Paragraph("Hotline: 0909-123-456", fontNormal));
            companyInfo.add(new Paragraph("Email: gaGV@gmail.com", fontNormal));
            companyInfo.add(new Paragraph("Địa chỉ văn phòng: 123 Đường Thống Nhất, Quận Gò Vấp,\nThành phố Hồ Chí Minh, Việt Nam", fontNormal));
            document.add(companyInfo);

            // Thêm khoảng trắng
            document.add(new Paragraph(" "));

            // Thông tin hóa đơn căn lề trái
            Paragraph invoiceInfo = new Paragraph();
            invoiceInfo.setAlignment(Element.ALIGN_LEFT);
            // Định dạng số thành tiền tệ
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
            invoiceInfo.add((new Paragraph("_________________________________________________________________", fontNormal)));
            invoiceInfo.add(new Paragraph("THÔNG TIN HOA ĐƠN", fontNormal));

            invoiceInfo.add(new Paragraph("Mã Hóa Đơn: " + hoaDon.getMaHD() + "                Ngày Lập: " + hoaDon.getNgayLap().toString(), fontNormal));
            invoiceInfo.add(new Paragraph("Mã Khách Hàng: " + hoaDon.getMaKH(), fontNormal));
            invoiceInfo.add(new Paragraph("Số lượng: " + hoaDon.getSoLuong(), fontNormal));
            invoiceInfo.add(new Paragraph("Tổng Tiền: " + currencyFormat.format(hoaDon.getTongTien()), fontNormal));
            invoiceInfo.add(new Paragraph("Đãi Ngộ: " + hoaDon.getDaiNgo(), fontNormal));
            invoiceInfo.add(new Paragraph("Thuế: " + hoaDon.getThue(), fontNormal));
            invoiceInfo.add(new Paragraph("THÀNH TIỀN: " + currencyFormat.format(hoaDon.getThanhTien()), fontNormal));
            invoiceInfo.add(new Paragraph("Trạng Thái: " + hoaDon.getTrangThai(), fontNormal));
            document.add(invoiceInfo);

            // Thêm khoảng trắng
            document.add(new Paragraph(" "));

            // Phần 3: Phần ký tên và xác nhận công ty

            // Người phụ trách căn lề trái
            Paragraph signatures = new Paragraph();
            signatures.setAlignment(Element.ALIGN_LEFT);
            NhanVien_DAO nvDAO= new NhanVien_DAO();
            String tenNV = nvDAO.layTenNhanVien(hoaDon.getMaNV());
            signatures.add(new Paragraph("Người Phụ Trách: " + tenNV, fontItalic));
            signatures.add(new Paragraph("Mã Nhân Viên: " + hoaDon.getMaNV(), fontItalic));
            signatures.add(new Paragraph(" ", fontItalic)); // Khoảng trống cho chỗ ký tên

            document.add(signatures);

            // Thêm khoảng trắng
            document.add(new Paragraph(" "));

            // Ngày hiện tại căn lề phải
            String currentDate = new SimpleDateFormat("dd 'tháng' MM 'năm' yyyy").format(new Date());
            Paragraph dateParagraph = new Paragraph("Ngày " + currentDate, fontItalic);
            dateParagraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(new Paragraph(" "));
            document.add(dateParagraph);

            // Kết hợp xác nhận công ty và khách hàng trên một dòng
            Phrase signaturePhrase = new Phrase();
            signaturePhrase.add(new Chunk("Xác nhận Khách Hàng", fontItalic));
            document.add(new Paragraph(" "));

            signaturePhrase.add(new Chunk(new Chunk(new VerticalPositionMark())));
            signaturePhrase.add(new Chunk("Xác nhận Công Ty", fontItalic));
            document.add(new Paragraph(" "));


            // Thêm phrase vào tài liệu
            document.add(signaturePhrase);

            // Đóng tài liệu
            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
