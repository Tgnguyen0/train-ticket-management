package app.phan_tu_tuy_chinh;

import app.dao.NhanVien_DAO;
import app.phong_chu_moi.PhongChuMoi;
import app.thuc_the.HoaDon;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TaoHoaDonFilePDF {
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();

    public void createInvoicePdf(HoaDon hoaDon) {
        String filePath = "hoá đơn được tạo/" + hoaDon.getMaHoaDon() + ".pdf";

        Document document = new Document();
        try {
            // Khởi tạo tài liệu PDF
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Định nghĩa font chữ
            BaseFont baseFont = BaseFont.createFont("font/RobotoMono-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font fontTitle = new Font(baseFont, 18, Font.BOLD);
            Font fontNormal = new Font(baseFont, 12, Font.NORMAL);
            Font fontItalic = new Font(baseFont, 12, Font.ITALIC);

            // Phần 1: Logo và tiêu đề "Hóa Đơn"
            addLogoToDocument(document);
            addInvoiceTitle(document, fontTitle);

            // Phần 2: Thông tin công ty và thông tin hóa đơn
            addCompanyInfo(document, fontNormal);
            addInvoiceDetails(document, hoaDon, fontNormal, fontItalic);

            // Phần 3: Phần ký tên và xác nhận công ty
            addSignatures(document, hoaDon, fontItalic);

            // Đóng tài liệu
            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void addLogoToDocument(Document document) throws DocumentException, IOException {
        Image logo = Image.getInstance("assets/logo.png");
        logo.scaleToFit(100, 100);
        logo.setAlignment(Element.ALIGN_CENTER);
        document.add(logo);
    }

    private static void addInvoiceTitle(Document document, Font fontTitle) throws DocumentException {
        Paragraph title = new Paragraph("HÓA ĐƠN", fontTitle);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(new Paragraph(" ")); // Thêm khoảng trắng
    }

    private static void addCompanyInfo(Document document, Font fontNormal) throws DocumentException {
        Paragraph companyInfo = new Paragraph();
        companyInfo.setAlignment(Element.ALIGN_LEFT);
        companyInfo.add(new Paragraph("Tên công ty: Nhà ga Gò Vấp", fontNormal));
        companyInfo.add(new Paragraph("Hotline: 0909-123-456", fontNormal));
        companyInfo.add(new Paragraph("Email: gaGV@gmail.com", fontNormal));
        companyInfo.add(new Paragraph("Địa chỉ văn phòng: 123 Đường Thống Nhất, Quận Gò Vấp,\nThành phố Hồ Chí Minh, Việt Nam", fontNormal));
        document.add(companyInfo);
        document.add(new Paragraph(" ")); // Thêm khoảng trắng
    }

    private static void addInvoiceDetails(Document document, HoaDon hoaDon, Font fontNormal, Font fontItalic) throws DocumentException {
        Paragraph invoiceInfo = new Paragraph();
        invoiceInfo.setAlignment(Element.ALIGN_LEFT);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        invoiceInfo.add(new Paragraph("_________________________________________________________________", fontNormal));
        invoiceInfo.add(new Paragraph("THÔNG TIN HOA ĐƠN", fontNormal));
        invoiceInfo.add(new Paragraph("Mã Hóa Đơn: " + hoaDon.getMaHoaDon() + "                Ngày Lập: " + hoaDon.getNgayLapHoaDon(), fontNormal));
        invoiceInfo.add(new Paragraph("Mã Khách Hàng: " + hoaDon.getMaKhachHang(), fontNormal));
        invoiceInfo.add(new Paragraph("Số lượng: " + hoaDon.getSoLuong(), fontNormal));
        invoiceInfo.add(new Paragraph("Tổng Tiền: " + currencyFormat.format(hoaDon.getTongTien()), fontNormal));
        invoiceInfo.add(new Paragraph("Đãi Ngộ: " + hoaDon.getDaiNgo(), fontNormal));
        invoiceInfo.add(new Paragraph("Thuế: " + hoaDon.getThue(), fontNormal));
        invoiceInfo.add(new Paragraph("THÀNH TIỀN: " + currencyFormat.format(hoaDon.getThanhTien()), fontNormal));
        invoiceInfo.add(new Paragraph("Trạng Thái: " + hoaDon.getTrangThai(), fontNormal));

        document.add(invoiceInfo);
        document.add(new Paragraph(" ")); // Thêm khoảng trắng
    }

    private static void addSignatures(Document document, HoaDon hoaDon, Font fontItalic) throws DocumentException {
        NhanVien_DAO nvDAO = new NhanVien_DAO();
        String tenNV = nvDAO.ChonTheoMa(hoaDon.getMaNhanVien()).getTenNV();

        Paragraph signatures = new Paragraph();
        signatures.setAlignment(Element.ALIGN_LEFT);
        signatures.add(new Paragraph("Người Phụ Trách: " + tenNV, fontItalic));
        signatures.add(new Paragraph("Mã Nhân Viên: " + hoaDon.getMaNhanVien(), fontItalic));
        signatures.add(new Paragraph(" ", fontItalic)); // Khoảng trống cho chỗ ký tên
        document.add(signatures);

        // Ngày hiện tại căn lề phải
        String currentDate = new SimpleDateFormat("dd 'tháng' MM 'năm' yyyy").format(new Date());
        Paragraph dateParagraph = new Paragraph("Ngày " + currentDate, fontItalic);
        dateParagraph.setAlignment(Element.ALIGN_RIGHT);
        document.add(new Paragraph(" ")); // Thêm khoảng trắng
        document.add(dateParagraph);

        // Kết hợp xác nhận công ty và khách hàng trên một dòng
        Phrase signaturePhrase = new Phrase();
        signaturePhrase.add(new Chunk("Xác nhận Khách Hàng", fontItalic));
        signaturePhrase.add(new Chunk(new VerticalPositionMark())); // Dấu phân cách
        signaturePhrase.add(new Chunk("Xác nhận Công Ty", fontItalic));
        document.add(new Paragraph(" ")); // Thêm khoảng trắng
        document.add(signaturePhrase);
    }

    public static void main() {
        TaoHoaDonFilePDF tao = new TaoHoaDonFilePDF();
    }
}