package app.dieu_khien;

import app.dao.CaTruc_DAO;
import app.giao_dien.TrangDangNhap;
import app.giao_dien.TrangDinhHuong;
import app.giao_dien.TrangKetCa;
import app.phan_tu_tuy_chinh.GanAmThanh;
import app.thuc_the.CaTruc;


import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.parser.Line;
import org.apache.poi.xwpf.usermodel.*;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.apache.poi.ss.util.CellUtil.createCell;


public class HanhDong_TrangKetCa implements ActionListener {
    private double chenhLech;

    public HanhDong_TrangKetCa(TrangKetCa trangKetCa) {
        this.trangKetCa = trangKetCa;
    }

    TrangKetCa trangKetCa;

    @Override
    public void actionPerformed(ActionEvent e) {
        GanAmThanh.playSound();

        if (e.getSource() == this.trangKetCa.btn_minus_1000) {
            if (this.trangKetCa.soTo1000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo1000--;
                this.trangKetCa.textField_1000.setText(String.valueOf(this.trangKetCa.soTo1000));
                this.trangKetCa.tienMat -= 1000;
                String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
                this.trangKetCa.label_hienTien.setText(tienMat);
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_1000) {
            this.trangKetCa.soTo1000++;
            this.trangKetCa.textField_1000.setText(String.valueOf(this.trangKetCa.soTo1000));
            this.trangKetCa.tienMat += 1000;
            String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
            this.trangKetCa.label_hienTien.setText(tienMat);

        } else if (e.getSource() == this.trangKetCa.btn_minus_2000) {
            if (this.trangKetCa.soTo2000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo2000--;
                this.trangKetCa.textField_2000.setText(String.valueOf(this.trangKetCa.soTo2000));
                this.trangKetCa.tienMat -= 2000;
                String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
                this.trangKetCa.label_hienTien.setText(tienMat);
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_2000) {
            this.trangKetCa.soTo2000++;
            this.trangKetCa.textField_2000.setText(String.valueOf(this.trangKetCa.soTo2000));
            this.trangKetCa.tienMat += 2000;
            String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
            this.trangKetCa.label_hienTien.setText(tienMat);
        } else if (e.getSource() == this.trangKetCa.btn_minus_5000) {
            if (this.trangKetCa.soTo5000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo5000--;
                this.trangKetCa.textField_5000.setText(String.valueOf(this.trangKetCa.soTo5000));
                this.trangKetCa.tienMat -= 5000;
                String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
                this.trangKetCa.label_hienTien.setText(tienMat);
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_5000) {
            this.trangKetCa.soTo5000++;
            this.trangKetCa.textField_5000.setText(String.valueOf(this.trangKetCa.soTo5000));
            this.trangKetCa.tienMat += 5000;
            String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
            this.trangKetCa.label_hienTien.setText(tienMat);
        } else if (e.getSource() == this.trangKetCa.btn_minus_10000) {
            if (this.trangKetCa.soTo10000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo10000--;
                this.trangKetCa.textField_10000.setText(String.valueOf(this.trangKetCa.soTo10000));
                this.trangKetCa.tienMat -= 10000;
                String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
                this.trangKetCa.label_hienTien.setText(tienMat);
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_10000) {
            this.trangKetCa.soTo10000++;
            this.trangKetCa.textField_10000.setText(String.valueOf(this.trangKetCa.soTo10000));
            this.trangKetCa.tienMat += 10000;
            String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
            this.trangKetCa.label_hienTien.setText(tienMat);

        } else if (e.getSource() == this.trangKetCa.btn_minus_20000) {
            if (this.trangKetCa.soTo20000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo20000--;
                this.trangKetCa.textField_20000.setText(String.valueOf(this.trangKetCa.soTo20000));
                this.trangKetCa.tienMat -= 20000;
                String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
                this.trangKetCa.label_hienTien.setText(tienMat);
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_20000) {
            this.trangKetCa.soTo20000++;
            this.trangKetCa.textField_20000.setText(String.valueOf(this.trangKetCa.soTo20000));
            this.trangKetCa.tienMat += 20000;
            String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
            this.trangKetCa.label_hienTien.setText(tienMat);
        } else if (e.getSource() == this.trangKetCa.btn_minus_50000) {
            if (this.trangKetCa.soTo50000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo50000--;
                this.trangKetCa.textField_50000.setText(String.valueOf(this.trangKetCa.soTo50000));
                this.trangKetCa.tienMat -= 50000;
                String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
                this.trangKetCa.label_hienTien.setText(tienMat);
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_50000) {
            this.trangKetCa.soTo50000++;
            this.trangKetCa.textField_50000.setText(String.valueOf(this.trangKetCa.soTo50000));
            this.trangKetCa.tienMat += 50000;
            String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
            this.trangKetCa.label_hienTien.setText(tienMat);
        } else if (e.getSource() == this.trangKetCa.btn_minus_100000) {
            if (this.trangKetCa.soTo100000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo100000--;
                this.trangKetCa.textField_100000.setText(String.valueOf(this.trangKetCa.soTo100000));
                this.trangKetCa.tienMat -= 100000;
                String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
                this.trangKetCa.label_hienTien.setText(tienMat);
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_100000) {
            this.trangKetCa.soTo100000++;
            this.trangKetCa.textField_100000.setText(String.valueOf(this.trangKetCa.soTo100000));
            this.trangKetCa.tienMat += 100000;
            String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
            this.trangKetCa.label_hienTien.setText(tienMat);
        } else if (e.getSource() == this.trangKetCa.btn_minus_200000) {
            if (this.trangKetCa.soTo200000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo200000--;
                this.trangKetCa.textField_200000.setText(String.valueOf(this.trangKetCa.soTo200000));
                this.trangKetCa.tienMat -= 200000;
                String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
                this.trangKetCa.label_hienTien.setText(tienMat);
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_200000) {
            this.trangKetCa.soTo200000++;
            this.trangKetCa.textField_200000.setText(String.valueOf(this.trangKetCa.soTo200000));
            this.trangKetCa.tienMat += 200000;
            String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
            this.trangKetCa.label_hienTien.setText(tienMat);
        } else if (e.getSource() == this.trangKetCa.btn_minus_500000) {
            if (this.trangKetCa.soTo500000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo500000--;
                this.trangKetCa.textField_500000.setText(String.valueOf(this.trangKetCa.soTo500000));
                this.trangKetCa.tienMat -= 500000;
                String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
                this.trangKetCa.label_hienTien.setText(tienMat);
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_500000) {
            this.trangKetCa.soTo500000++;
            this.trangKetCa.textField_500000.setText(String.valueOf(this.trangKetCa.soTo500000));
            this.trangKetCa.tienMat += 500000;
            String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
            this.trangKetCa.label_hienTien.setText(tienMat);
        } else if (e.getSource() == trangKetCa.btn_xacNhan) {
            this.xacNhan();
        } else if (e.getSource() == trangKetCa.btn_hoanTat) {
            themCaTruc();
        } else if (e.getSource() instanceof javax.swing.JTextField) {
            tinhTienMat();
        }

    }

    private void themCaTruc() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String maNhanVien = trangKetCa.label_hienMaNV.getText();
        String ngayGioBatDau = trangKetCa.label_hienGioVaoCa.getText();
        LocalDateTime ngayGioBatDau_localDateTime = LocalDateTime.parse(ngayGioBatDau, formatter);
        String ngayGioKetThuc = trangKetCa.label_hienGioKetCa.getText();
        LocalDateTime ngayGioKetThuc_localDateTime = LocalDateTime.parse(ngayGioKetThuc, formatter);
        int tongHoaDon = Integer.parseInt(trangKetCa.label_hienTongHoaDon.getText());
        Double tongTienCaTruoc = trangKetCa.tienCaTruoc;
        Double tongTienHoaDon = trangKetCa.tongTienHeThong;
        Double tongTienThucThu = trangKetCa.tongTien;
        Double thatThoat = chenhLech;
        Double tongVAT = trangKetCa.tongVAT;
        Double tongTienGiamGia = trangKetCa.tongGiamGia;
        CaTruc caTruc = new CaTruc(maNhanVien, ngayGioBatDau_localDateTime, ngayGioKetThuc_localDateTime, tongHoaDon, tongTienCaTruoc, tongTienHoaDon, tongTienThucThu, thatThoat, tongVAT, tongTienGiamGia);
        CaTruc_DAO.themCaTruc(caTruc);

        JOptionPane.showMessageDialog(trangKetCa, "Thêm ca trực thành công");

        CaTruc caTrucIn = CaTruc_DAO.layCaTrucTheoMaNV(maNhanVien);
        inPhieuPdf(caTrucIn);
        this.trangKetCa.setVisible(false);
        Window window = SwingUtilities.getWindowAncestor(TrangDinhHuong.getTrangChua());
        window.dispose();
        TrangDangNhap trangDangNhap = new TrangDangNhap();
        trangDangNhap.setVisible(true);
    }

    public void inPhieuPdf(CaTruc caTruc) {
        String outPutPdf = "src/main/java/app/resources/PhieuKetCa_" + caTruc.getMaCaTruc() + ".pdf";
        try {
            // Đường dẫn tới file font hỗ trợ tiếng Việt (đảm bảo file này tồn tại trong thư mục dự án)
            String fontPath = "font/Arial.ttf";
            BaseFont baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font fontTitle = new Font(baseFont, 20, Font.BOLD);
            Font fontSubtitle = new Font(baseFont, 16, Font.BOLD);
            Font fontContent = new Font(baseFont, 12, Font.NORMAL);

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(outPutPdf));
            document.open();

            // Nội dung của tài liệu PDF
            Paragraph nhaGa = new Paragraph("Nhà Ga Sài Gòn", fontTitle);
            nhaGa.setAlignment(Element.ALIGN_CENTER);
            document.add(nhaGa);

            Paragraph diaChi = new Paragraph("123 đường Thống Nhất, P.10, quận Gò Vấp, TP.Hồ Chí Minh", fontContent);
            diaChi.setAlignment(Element.ALIGN_CENTER);
            document.add(diaChi);

            //add line
            LineSeparator line = new LineSeparator();
            document.add(new Chunk(line));

            Paragraph phieuKetCa = new Paragraph("Báo Cáo Kết Ca", fontSubtitle);
            phieuKetCa.setAlignment(Element.ALIGN_CENTER);
            document.add(phieuKetCa);


            document.add(new Chunk(line));
            // Thông tin chi tiết
            document.add(new Paragraph("Mã nhân viên: " + caTruc.getMaNhanVien(), fontContent));
            document.add(new Paragraph("Tên nhân viên: " + trangKetCa.label_hienTenNV.getText(), fontContent));
            document.add(new Paragraph("Ngày giờ bắt đầu: " + trangKetCa.label_hienGioVaoCa.getText(), fontContent));
            document.add(new Paragraph("Ngày giờ kết thúc: " + trangKetCa.label_hienGioKetCa.getText(), fontContent));

            // Tạo bảng thông tin
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
            //tieu de moi hang
            PdfPCell cell = new PdfPCell(new Phrase("Tổng số hóa đơn", fontContent));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(String.valueOf(caTruc.getTongHoaDon()), fontContent));
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Tổng tiền ca trực trước", fontContent));
            table.addCell(cell);
            String tienCaTruoc = chuyenSangVND(caTruc.getTongTienCaTruoc());
            cell = new PdfPCell(new Phrase(tienCaTruoc, fontContent));
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Tổng tiền hệ thống", fontContent));
            table.addCell(cell);
            String tienHoaDon = chuyenSangVND(caTruc.getTongTienHoaDon());
            cell = new PdfPCell(new Phrase(tienHoaDon, fontContent));
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Tổng VAT", fontContent));
            table.addCell(cell);
            String tongVAT = chuyenSangVND(caTruc.getTongVAT());
            cell = new PdfPCell(new Phrase(tongVAT, fontContent));
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Tổng giảm giá", fontContent));
            table.addCell(cell);
            String tongGiamGia = chuyenSangVND(caTruc.getTongTienGiamGia());
            cell = new PdfPCell(new Phrase(tongGiamGia, fontContent));
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Tổng tiền thực thu", fontContent));
            table.addCell(cell);
            String tienThucThu = chuyenSangVND(caTruc.getTongTienThucThu());
            cell = new PdfPCell(new Phrase(tienThucThu, fontContent));
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Chênh lệch", fontContent));
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(trangKetCa.label_hienThatThoat.getText(), fontContent));
            table.addCell(cell);

            document.add(table);
            document.add(new Chunk(line));

            Paragraph kyTen = new Paragraph("Ký và ghi rõ họ tên", fontContent);
            kyTen.setAlignment(Element.ALIGN_CENTER);
            document.add(kyTen);

            Paragraph label_kyTen = new Paragraph("Nhân viên kết ca                                                         Nhân viên nhận ca", fontContent);
            label_kyTen.setAlignment(Element.ALIGN_CENTER);

            document.add(label_kyTen);


            document.close();

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }


    private void xacNhan() {
        trangKetCa.tongTien = 0.0;
        trangKetCa.tongTien += this.trangKetCa.soTo1000 * 1000;
        trangKetCa.tongTien += this.trangKetCa.soTo2000 * 2000;
        trangKetCa.tongTien += this.trangKetCa.soTo5000 * 5000;
        trangKetCa.tongTien += this.trangKetCa.soTo10000 * 10000;
        trangKetCa.tongTien += this.trangKetCa.soTo20000 * 20000;
        trangKetCa.tongTien += this.trangKetCa.soTo50000 * 50000;
        trangKetCa.tongTien += this.trangKetCa.soTo100000 * 100000;
        trangKetCa.tongTien += this.trangKetCa.soTo200000 * 200000;
        trangKetCa.tongTien += this.trangKetCa.soTo500000 * 500000;
        Double tienChuyenKhoan = 0.0;
        if (!trangKetCa.textField_chuyenKhoan.getText().equals("")) {
            tienChuyenKhoan = Double.parseDouble(trangKetCa.textField_chuyenKhoan.getText());
        }

        trangKetCa.tongTien += tienChuyenKhoan;
        String tongTien = chuyenSangVND(trangKetCa.tongTien);
        trangKetCa.textField_tienThucThu.setText(tongTien);
        chenhLech = trangKetCa.tongTien - trangKetCa.tongTienHeThong;
        if(chenhLech > 0){
            String chenhLechString = chuyenSangVND(chenhLech);
            trangKetCa.label_hienThatThoat.setText("Dư " + chenhLechString);
        } else if (chenhLech == 0){
            trangKetCa.label_hienThatThoat.setText("Không chênh lệch");
        } else {
            String chenhLechString = chuyenSangVND(chenhLech);
            trangKetCa.label_hienThatThoat.setText("Thiếu " + chenhLechString);
        }
    }
    private String chuyenSangVND(double tien) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(localeVN);
        String tienVND = formatter.format(tien);
        return tienVND;
    }

    private int layGiaTriTextField(javax.swing.JTextField textField) {
        try {
            return Integer.parseInt(textField.getText());
        } catch (NumberFormatException e) {
            return 0; // Trả về 0 nếu người dùng không nhập
        }
    }
    private void tinhTienMat() {
        this.trangKetCa.soTo1000 = layGiaTriTextField(this.trangKetCa.textField_1000);
        this.trangKetCa.soTo2000 = layGiaTriTextField(this.trangKetCa.textField_2000);
        this.trangKetCa.soTo5000 = layGiaTriTextField(this.trangKetCa.textField_5000);
        this.trangKetCa.soTo10000 = layGiaTriTextField(this.trangKetCa.textField_10000);
        this.trangKetCa.soTo20000 = layGiaTriTextField(this.trangKetCa.textField_20000);
        this.trangKetCa.soTo50000 = layGiaTriTextField(this.trangKetCa.textField_50000);
        this.trangKetCa.soTo100000 = layGiaTriTextField(this.trangKetCa.textField_100000);
        this.trangKetCa.soTo200000 = layGiaTriTextField(this.trangKetCa.textField_200000);
        this.trangKetCa.soTo500000 = layGiaTriTextField(this.trangKetCa.textField_500000);

        this.trangKetCa.tienMat =
                this.trangKetCa.soTo1000 * 1000 +
                        this.trangKetCa.soTo2000 * 2000 +
                        this.trangKetCa.soTo5000 * 5000 +
                        this.trangKetCa.soTo10000 * 10000 +
                        this.trangKetCa.soTo20000 * 20000 +
                        this.trangKetCa.soTo50000 * 50000 +
                        this.trangKetCa.soTo100000 * 100000 +
                        this.trangKetCa.soTo200000 * 200000 +
                        this.trangKetCa.soTo500000 * 500000;

        String tienMat = chuyenSangVND(this.trangKetCa.tienMat);
        this.trangKetCa.label_hienTien.setText(tienMat);
        System.out.println("Số tờ 500000: " + this.trangKetCa.soTo500000);
        System.out.println("Tổng tiền mặt: " + this.trangKetCa.tienMat);
    }

}
