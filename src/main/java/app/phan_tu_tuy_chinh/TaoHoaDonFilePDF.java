package app.phan_tu_tuy_chinh;

import app.dao.KhachHang_DAO;
import app.dao.NhanVien_DAO;
import app.dao.Ve_DAO;
import app.phong_chu_moi.PhongChuMoi;
import app.thuc_the.HoaDon;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TaoHoaDonFilePDF {
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public static KhachHang_DAO khachHang_dao = new KhachHang_DAO();
    public static Ve_DAO ve_dao = new Ve_DAO();

    public static void createInvoicePdf(HoaDon hoaDon) {
        try {
//            // Đường dẫn lưu file vào ổ D:\
            Document document = new Document();
            /*String qrCodePath = ".." + File.separator + "src" + File.separator + "main"
                    + File.separator + "resources" + File.separator + "hoa_don" + File.separator + hoaDon.getMaHoaDon() + ".png";*/
            String qrCodePath = "C:/Users/DELL/Desktop/Visual Studio Code/Java Project/train_ticket_management_app/src/main/resources/hoa_don/" + hoaDon.getMaHoaDon() + ".png";

            // Tạo mã QR chứa thông tin hóa đơn
            String qrContent = "Ngày Lập : " + hoaDon.getNgayLapHoaDon() +
                    "\nMã Hóa Đơn : " + hoaDon.getMaHoaDon() +
                    "\nMã Khách Hàng : " + hoaDon.getMaKhachHang() +
                    "\nTên Khách Hàng : " + khachHang_dao.layTenKhachHang(hoaDon.getMaKhachHang()) +
                    "\nSố Điện Thoại : " + khachHang_dao.laySoDT(hoaDon.getMaKhachHang()) +
                    "\nLoại Vé : " + ve_dao.layLoaiDoiTuongVe(hoaDon.getMaKhachHang()) +
                    "\nSố Lượng : " + hoaDon.getSoLuong() +
                    "\nTổng Tiền : " + hoaDon.getTongTien()
                    + "\nĐãi Ngộ : " + hoaDon.getDaiNgo()
                    + "\nThuế : " + hoaDon.getThue()
                    + "\nThành Tiền: " + hoaDon.getThanhTien();

            QRHoaDon.generateQRCode(qrContent, qrCodePath);

            /*String filePath = ".." + File.separator + "src" + File.separator + "main"
                    + File.separator + "resources" + File.separator + "hoa_don" + File.separator + hoaDon.getMaHoaDon() + ".pdf";*/
            String filePath = "C:/Users/DELL/Desktop/Visual Studio Code/Java Project/train_ticket_management_app/src/main/resources/hoa_don/"+hoaDon.getMaHoaDon()+".pdf";
//            // Khởi tạo tài liệu PDF
//            String filePath = "hoá đơn được tạo/" + hoaDon.getMaHoaDon() + ".pdf";

            /*String currentDir = System.getProperty("user.dir");

            // Combine the current directory with the relative path
            File hoaDonDirectory = new File(currentDir, filePath);

            // Check if the directory exists, create it if it doesn't
            if (!hoaDonDirectory.exists()) {
                hoaDonDirectory.mkdirs(); // Create the directory if it doesn't exist
            }
            // Prepare the output file in the "ve" directory
            File outputFile = new File(hoaDonDirectory, filePath);*/

        try {
            // Khởi tạo tài liệu PDF
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Định nghĩa font chữ
            BaseFont bf = BaseFont.createFont("font/RobotoMono-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font fontTitle = new Font(bf, 18, Font.BOLD);
            Font fontNormal = new Font(bf, 12, Font.NORMAL);
            Font fontItalic = new Font(bf, 12, Font.ITALIC);

            // Phần 1: Logo và tiêu đề "Hóa Đơn"
            try {
                // Load the image from the resource path
                Image logo = Image.getInstance(TaoHoaDonFilePDF.class.getResource("/assets/logo.png"));

                // Scale the image to fit within 100x100
                logo.scaleToFit(100, 100);

                // Center align the image
                logo.setAlignment(Element.ALIGN_CENTER);

                // Add the image to the document
                document.add(logo);

            } catch (Exception e) {
                e.printStackTrace();
            }

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
            invoiceInfo.add(new Paragraph("Thông Tin Hóa Đơn", fontTitle));
            invoiceInfo.add(new Paragraph(""));
            invoiceInfo.add(new Paragraph("Mã hóa đơn: " + hoaDon.getMaHoaDon() + "                Ngày Lập: " + hoaDon.getNgayLapHoaDon().toString(), fontNormal));
            invoiceInfo.add(new Paragraph("Mã khách hàng: " + hoaDon.getMaKhachHang(), fontNormal));

            invoiceInfo.add(new Paragraph("Loại vé: " + ve_dao.layLoaiDoiTuongVe(hoaDon.getMaKhachHang()), fontNormal));
            invoiceInfo.add((new Paragraph("_________________________________________________________________", fontNormal)));
            document.add(new Paragraph(" "));
            String soDT = khachHang_dao.laySoDT(hoaDon.getMaKhachHang());
            String tenKH= khachHang_dao.layTenKhachHang(hoaDon.getMaKhachHang());
            invoiceInfo.add(new Paragraph("Thông Tin Khách Hàng", fontTitle));
            invoiceInfo.add(new Paragraph(""));
            invoiceInfo.add(new Paragraph("Tên khách hàng: " + tenKH, fontNormal));
            invoiceInfo.add(new Paragraph("Số điện thoại: " + soDT, fontNormal));
            invoiceInfo.add(new Paragraph("Số lượng: " + hoaDon.getSoLuong(), fontNormal));
            invoiceInfo.add(new Paragraph("Tổng tiền: " + currencyFormat.format(hoaDon.getTongTien()), fontNormal));
            invoiceInfo.add(new Paragraph("Đãi ngộ: " + hoaDon.getDaiNgo(), fontNormal));
            invoiceInfo.add(new Paragraph("Thuế: " + hoaDon.getThue(), fontNormal));
            invoiceInfo.add(new Paragraph("THÀNH TIỀN: " + currencyFormat.format(hoaDon.getThanhTien()), fontNormal));
            invoiceInfo.add(new Paragraph("Trạng Thái: " + hoaDon.getTrangThai(), fontNormal));
            document.add(invoiceInfo);

            document.add(new Paragraph(" "));

            // Phần 3: Phần ký tên và xác nhận công ty
            // Người phụ trách căn lề trái
            Paragraph signatures = new Paragraph();
            signatures.setAlignment(Element.ALIGN_LEFT);
            NhanVien_DAO nvDAO= new NhanVien_DAO();
            String tenNV = nvDAO.layTenNhanVien(hoaDon.getMaNhanVien());
            signatures.add(new Paragraph("Người Phụ Trách: " + tenNV, fontItalic));
            signatures.add(new Paragraph("Mã Nhân Viên: " + hoaDon.getMaNhanVien(), fontItalic));
            signatures.add(new Paragraph(" ", fontItalic)); // Khoảng trống cho chỗ ký tên

            document.add(signatures);

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

//            // Phần 1: Logo và tiêu đề "Hóa Đơn"
//            addLogoToDocument(document);
//            addInvoiceTitle(document, fontTitle);
//
//            // Phần 2: Thông tin công ty và thông tin hóa đơn
//            addCompanyInfo(document, fontNormal);
//            addInvoiceDetails(document, hoaDon, fontNormal, fontItalic);
//
//            // Phần 3: Phần ký tên và xác nhận công ty
//            addSignatures(document, hoaDon, fontItalic);

            // Thêm mã QR vào PDF
            Image qrImage = Image.getInstance(qrCodePath);
            qrImage.scaleToFit(100, 100);
            qrImage.setAlignment(Element.ALIGN_CENTER);
            document.add(qrImage);
//            // Đóng tài liệu
              document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    } catch (Exception e) {
            throw new RuntimeException(e);
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
}
