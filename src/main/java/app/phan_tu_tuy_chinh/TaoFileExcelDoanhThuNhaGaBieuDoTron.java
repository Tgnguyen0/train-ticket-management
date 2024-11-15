package app.phan_tu_tuy_chinh;

import app.thuc_the.HoaDon;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class TaoFileExcelDoanhThuNhaGaBieuDoTron {
    public void TaoFileExcelDoanhThuNhaGaBieuDoTron(String month, String year, String soVe, String doanhThu, ArrayList<HoaDon> danhSachHoaDon, BufferedImage chartImage) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Biểu Đồ Tròn");
        sheet.setColumnWidth(0, 5000);
        sheet.setColumnWidth(1, 5000);
        sheet.setColumnWidth(2, 5000);
        sheet.setColumnWidth(3, 5000);
        sheet.setColumnWidth(4, 5000);
        sheet.setColumnWidth(5, 5000);
        sheet.setColumnWidth(6, 5000);
        sheet.setColumnWidth(7, 5000);

// Tạo tiêu đề chính
// Tạo hàng và ô tiêu đề
        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("Doanh Thu Cua Nha Ga Go Vap Trong Thang " + month + " Nam " + year);

// Định dạng tiêu đề
        CellStyle titleStyle = workbook.createCellStyle();
        Font titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 24);
        titleFont.setBold(true);
        titleStyle.setFont(titleFont);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);

// Thiết lập border cho tiêu đề
        titleStyle.setBorderTop(BorderStyle.THIN);
        titleStyle.setBorderBottom(BorderStyle.THIN);
        titleStyle.setBorderLeft(BorderStyle.THIN);
        titleStyle.setBorderRight(BorderStyle.THIN);

// Áp dụng style cho ô tiêu đề
        titleCell.setCellStyle(titleStyle);

// Hợp nhất các ô cho tiêu đề
        CellRangeAddress mergedRegion = new CellRangeAddress(0, 0, 0, 7);
        sheet.addMergedRegion(mergedRegion);

// Thiết lập border cho vùng ô đã hợp nhất
        RegionUtil.setBorderTop(BorderStyle.THIN, mergedRegion, sheet);
        RegionUtil.setBorderBottom(BorderStyle.THIN, mergedRegion, sheet);
        RegionUtil.setBorderLeft(BorderStyle.THIN, mergedRegion, sheet);
        RegionUtil.setBorderRight(BorderStyle.THIN, mergedRegion, sheet);


        // Tạo header
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 16);
        headerFont.setBold(true);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);

        Row headerRow = sheet.createRow(1);
        headerRow.createCell(0).setCellValue("Mã Hóa Đơn");
        headerRow.getCell(0).setCellStyle(headerStyle);
        headerRow.createCell(1).setCellValue("Ngày Lập");
        headerRow.getCell(1).setCellStyle(headerStyle);
        headerRow.createCell(2).setCellValue("Thành Tiền");
        headerRow.getCell(2).setCellStyle(headerStyle);
        headerRow.createCell(3).setCellValue("Số Lượng");
        headerRow.getCell(3).setCellStyle(headerStyle);
        headerRow.createCell(4).setCellValue("Tổng Tiền");
        headerRow.getCell(4).setCellStyle(headerStyle);
        headerRow.createCell(5).setCellValue("Trạng Thái");
        headerRow.getCell(5).setCellStyle(headerStyle);
        headerRow.createCell(6).setCellValue("Đãi Ngộ");
        headerRow.getCell(6).setCellStyle(headerStyle);
        headerRow.createCell(7).setCellValue("Thuế");
        headerRow.getCell(7).setCellStyle(headerStyle);


        int startRow = 2;
        Font valueFont = workbook.createFont();
        valueFont.setFontHeightInPoints((short) 16);
        DataFormat dataFormat = workbook.createDataFormat();
        CellStyle numberCellStyle = workbook.createCellStyle();
        numberCellStyle.setFont(valueFont);
        numberCellStyle.setDataFormat(dataFormat.getFormat("#,##0")); // Định dạng số với dấu phân cách hàng nghìn
        numberCellStyle.setAlignment(HorizontalAlignment.CENTER);
        numberCellStyle.setBorderTop(BorderStyle.THIN);
        numberCellStyle.setBorderBottom(BorderStyle.THIN);
        numberCellStyle.setBorderLeft(BorderStyle.THIN);
        numberCellStyle.setBorderRight(BorderStyle.THIN);


        DataFormat dateFormat = workbook.createDataFormat();
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setFont(valueFont);
        dateCellStyle.setDataFormat(dateFormat.getFormat("dd-MM-yyyy"));
        dateCellStyle.setAlignment(HorizontalAlignment.CENTER);
        dateCellStyle.setBorderTop(BorderStyle.THIN);
        dateCellStyle.setBorderBottom(BorderStyle.THIN);
        dateCellStyle.setBorderLeft(BorderStyle.THIN);
        dateCellStyle.setBorderRight(BorderStyle.THIN);

        CellStyle normalCellStyle = workbook.createCellStyle();
        normalCellStyle.setFont(valueFont);
        normalCellStyle.setAlignment(HorizontalAlignment.CENTER);
        normalCellStyle.setBorderTop(BorderStyle.THIN);
        normalCellStyle.setBorderBottom(BorderStyle.THIN);
        normalCellStyle.setBorderLeft(BorderStyle.THIN);
        normalCellStyle.setBorderRight(BorderStyle.THIN);


        for (HoaDon hoaDon : danhSachHoaDon) {
            Row dataRow = sheet.createRow(startRow);

            // Cột 1 - Mã hóa đơn (dữ liệu dạng chuỗi)
            dataRow.createCell(0).setCellValue(hoaDon.getMaHoaDon());
            dataRow.getCell(0).setCellStyle(numberCellStyle);

            // Cột 2 - Ngày lập hóa đơn (dữ liệu dạng chuỗi)
            dataRow.createCell(1).setCellValue(hoaDon.getNgayLapHoaDon());
            System.out.println(Date.valueOf(hoaDon.getNgayLapHoaDon()));
            dataRow.getCell(1).setCellStyle(dateCellStyle);

            // Cột 3 - Thành tiền (dữ liệu dạng số)
            dataRow.createCell(2).setCellValue(hoaDon.getThanhTien());
            dataRow.getCell(2).setCellStyle(numberCellStyle);

            // Cột 4 - Số lượng (dữ liệu dạng số)
            dataRow.createCell(3).setCellValue(hoaDon.getSoLuong());
            dataRow.getCell(3).setCellStyle(numberCellStyle);

            // Cột 5 - Tổng tiền (dữ liệu dạng số)
            dataRow.createCell(4).setCellValue(hoaDon.getTongTien());
            dataRow.getCell(4).setCellStyle(numberCellStyle);

            // Cột 6 - Trạng thái (dữ liệu dạng chuỗi)
            dataRow.createCell(5).setCellValue(hoaDon.getTrangThai());
            dataRow.getCell(5).setCellStyle(numberCellStyle);

            // Cột 7 - Đãi ngộ (dữ liệu dạng số)
            dataRow.createCell(6).setCellValue(hoaDon.getDaiNgo().getValue());
            dataRow.getCell(6).setCellStyle(normalCellStyle);

            // Cột 8 - Thuế (dữ liệu dạng số)
            dataRow.createCell(7).setCellValue(hoaDon.getThue());
            dataRow.getCell(7).setCellStyle(normalCellStyle);

            startRow++;
        }

        /*
            tạo hàng tổng số lượng vé
         */
// Tạo hàng và thiết lập giá trị cho ô đầu tiên

        Row tongSoVeRow = sheet.createRow(startRow);
        tongSoVeRow.createCell(0).setCellValue("Tổng Số Lượng Vé: "+ soVe);
        tongSoVeRow.getCell(0).setCellStyle(headerStyle);

// Thiết lập giá trị cho các ô còn lại trong vùng hợp nhất (cột 1 đến cột 7) nếu cần
        for (int i = 1; i <= 7; i++) {
            tongSoVeRow.createCell(i).setCellStyle(headerStyle);  // Thiết lập CellStyle cho các ô còn lại
        }

// Hợp nhất các ô cho tiêu đề
        CellRangeAddress mergedTongSoVe = new CellRangeAddress(startRow, startRow, 0, 7);
        sheet.addMergedRegion(mergedTongSoVe);

// Thiết lập border cho toàn bộ vùng ô đã hợp nhất
        RegionUtil.setBorderTop(BorderStyle.THIN, mergedTongSoVe, sheet);
        RegionUtil.setBorderBottom(BorderStyle.THIN, mergedTongSoVe, sheet);
        RegionUtil.setBorderLeft(BorderStyle.THIN, mergedTongSoVe, sheet);
        RegionUtil.setBorderRight(BorderStyle.THIN, mergedTongSoVe, sheet);

        startRow+=1;

        /*
            tạo hàng tổng doanh thu
         */
        Font tongDoanhThuFont = workbook.createFont();
        tongDoanhThuFont.setFontHeightInPoints((short) 16);
        tongDoanhThuFont.setBold(true);
        DataFormat tongDoanhThuFormat = workbook.createDataFormat();
        CellStyle tongDoanhThuCellStyle = workbook.createCellStyle();
        tongDoanhThuCellStyle.setFont(tongDoanhThuFont);
        tongDoanhThuCellStyle.setDataFormat(tongDoanhThuFormat.getFormat("#,##0")); // Định dạng số với dấu phân cách hàng nghìn
        tongDoanhThuCellStyle.setAlignment(HorizontalAlignment.CENTER);
        tongDoanhThuCellStyle.setBorderTop(BorderStyle.THIN);
        tongDoanhThuCellStyle.setBorderBottom(BorderStyle.THIN);
        tongDoanhThuCellStyle.setBorderLeft(BorderStyle.THIN);
        tongDoanhThuCellStyle.setBorderRight(BorderStyle.THIN);
// Tạo hàng và thiết lập giá trị cho ô đầu tiên

        Row tongDoanhThuRow = sheet.createRow(startRow);
        tongDoanhThuRow.createCell(0).setCellValue("Tổng Doanh Thu: "+ doanhThu);
        tongDoanhThuRow.getCell(0).setCellStyle(tongDoanhThuCellStyle);

// Thiết lập giá trị cho các ô còn lại trong vùng hợp nhất (cột 1 đến cột 7) nếu cần
        for (int i = 1; i <= 7; i++) {
            tongDoanhThuRow.createCell(i).setCellStyle(headerStyle);  // Thiết lập CellStyle cho các ô còn lại
        }

// Hợp nhất các ô cho tiêu đề
        CellRangeAddress mergedTongDoanhThu = new CellRangeAddress(startRow, startRow, 0, 7);
        sheet.addMergedRegion(mergedTongDoanhThu);

// Thiết lập border cho toàn bộ vùng ô đã hợp nhất
        RegionUtil.setBorderTop(BorderStyle.THIN, mergedTongDoanhThu, sheet);
        RegionUtil.setBorderBottom(BorderStyle.THIN, mergedTongDoanhThu, sheet);
        RegionUtil.setBorderLeft(BorderStyle.THIN, mergedTongDoanhThu, sheet);
        RegionUtil.setBorderRight(BorderStyle.THIN, mergedTongDoanhThu, sheet);


        // thêm ảnh biểu đồ tròn vào trong file excel
        File imageFile = new File("chart.png");
        try {
            ImageIO.write(chartImage, "png", imageFile);
            FileInputStream inputStream = new FileInputStream(imageFile);
            byte[] bytes = IOUtils.toByteArray(inputStream);
            int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            inputStream.close();

            // Chèn hình ảnh vào Excel
            XSSFDrawing drawing = (XSSFDrawing) sheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = new XSSFClientAnchor();
            anchor.setCol1(9); // Cột bắt đầu
            anchor.setRow1(1); // Dòng bắt đầu (sau dữ liệu)
            XSSFPicture picture = drawing.createPicture(anchor, pictureIdx);
            picture.resize();
            sheet.setColumnWidth(9, 5000);
            sheet.setColumnWidth(10, 5000);
            sheet.setColumnWidth(11, 5000);
            // Ghi file Excel ra đĩa
            try (FileOutputStream fileOut = new FileOutputStream("D:\\BieuDoTron.xlsx")) {
                workbook.write(fileOut);
                JOptionPane.showMessageDialog(null, "Xuất file Excel thành công!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Xuất file Excel thất bại!");
                e.printStackTrace();
            } finally {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
