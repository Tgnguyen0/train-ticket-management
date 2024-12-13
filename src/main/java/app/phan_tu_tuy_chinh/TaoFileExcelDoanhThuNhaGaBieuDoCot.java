package app.phan_tu_tuy_chinh;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class TaoFileExcelDoanhThuNhaGaBieuDoCot {
    public void TaoFileExcelDoanhThuNhaGa(Map<String, Double> danhSachDoanhThu, byte[] chartImage, String filePath) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Thống kê doanh thu");
        sheet.setColumnWidth(0, 5000); // Cột "Năm"
        sheet.setColumnWidth(1, 12000); // Cột "Doanh Thu"

// Tạo tiêu đề chính
// Tạo hàng và ô tiêu đề
        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(5);
        titleCell.setCellValue("Doanh Thu Cua Nha Ga Go Vap");

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
        CellRangeAddress mergedRegion = new CellRangeAddress(0, 0, 5, 6);
        sheet.addMergedRegion(mergedRegion);

// Thiết lập border cho vùng ô đã hợp nhất
        RegionUtil.setBorderTop(BorderStyle.THIN, mergedRegion, sheet);
        RegionUtil.setBorderBottom(BorderStyle.THIN, mergedRegion, sheet);
        RegionUtil.setBorderLeft(BorderStyle.THIN, mergedRegion, sheet);
        RegionUtil.setBorderRight(BorderStyle.THIN, mergedRegion, sheet);

// Tạo dòng tiêu đề cột
        Row headerRow = sheet.createRow(1); // Dòng thứ 2 (bỏ qua dòng tiêu đề)
        String[] columns = {"Năm", "Doanh Thu"};
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 16);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headerCellStyle.setBorderTop(BorderStyle.THIN);
        headerCellStyle.setBorderBottom(BorderStyle.THIN);
        headerCellStyle.setBorderLeft(BorderStyle.THIN);
        headerCellStyle.setBorderRight(BorderStyle.THIN);

        int location = 4;
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(++location);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

// Tạo CellStyle cho định dạng số
        Font valueFont = workbook.createFont();
        valueFont.setFontHeightInPoints((short) 16);
        CellStyle numberCellStyle = workbook.createCellStyle();
        numberCellStyle.setFont(valueFont);
        DataFormat dataFormat = workbook.createDataFormat();
        numberCellStyle.setDataFormat(dataFormat.getFormat("#,##0")); // Định dạng số với dấu phân cách hàng nghìn
        numberCellStyle.setAlignment(HorizontalAlignment.CENTER);
        numberCellStyle.setBorderTop(BorderStyle.THIN);
        numberCellStyle.setBorderBottom(BorderStyle.THIN);
        numberCellStyle.setBorderLeft(BorderStyle.THIN);
        numberCellStyle.setBorderRight(BorderStyle.THIN);

        int rowNum = 2;
        for (Map.Entry<String, Double> entry : danhSachDoanhThu.entrySet()) {
            Row row = sheet.createRow(rowNum++);
            // Lùi vào 5 ô (cột từ 5 trở đi)
            Cell cell0 = row.createCell(5); // Ô "Năm" sẽ ở cột 5
            cell0.setCellValue(entry.getKey());
            cell0.setCellStyle(numberCellStyle);

            Cell cell1 = row.createCell(6); // Ô "Doanh Thu" sẽ ở cột 6
            cell1.setCellValue(entry.getValue());
            cell1.setCellStyle(numberCellStyle);
        }

// Tự động điều chỉnh kích thước cột
        sheet.setColumnWidth(5, 5000); // Cột "Năm"
        sheet.setColumnWidth(6, 12000); // Cột "Doanh Thu"

// Chèn hình ảnh vào Excel
        if (chartImage != null) {
            int pictureIdx = workbook.addPicture(chartImage, Workbook.PICTURE_TYPE_PNG);
            CreationHelper helper = workbook.getCreationHelper();
            Drawing<?> drawing = sheet.createDrawingPatriarch();
            ClientAnchor anchor = helper.createClientAnchor();
            anchor.setCol1(0); // Cột bắt đầu
            anchor.setRow1(rowNum + 2); // Dòng bắt đầu (sau dữ liệu)

            Picture picture = drawing.createPicture(anchor, pictureIdx);
            picture.resize(); // Tự động điều chỉnh kích thước hình ảnh
        }

        // Đường dẫn của file
        /*String relativePath = ".." + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "thong_ke" + File.separator + filePath;*/

        String relativePath = "C:/Users/DELL/Desktop/Visual Studio Code/Java Project/train_ticket_management_app/src/main/resources/thong_ke/" + filePath;

        // Ghi workbook ra file
        try (FileOutputStream fileOut = new FileOutputStream(relativePath)) {
            workbook.write(fileOut);
            JOptionPane.showMessageDialog(
                    null,
                    "Xuất file Excel thành công!"
            );
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Xuất File Thất Bại!");
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
