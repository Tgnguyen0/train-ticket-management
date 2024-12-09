package app.phan_tu_tuy_chinh;

import app.dao.NhanVien_DAO;
import app.thuc_the.NhanVien;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class TaoFileExcelTienThuongNhanVienTrongNam {
    public void TaoFileExcelTienThuongNhanVienTrongNam(Map<String, Double> danhSachDoanhThu,  String filePath, int nam, int thang) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Thống kê Tiền Thưởng Nhân Viên");



// Tạo tiêu đề chính
// Tạo hàng và ô tiêu đề
        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(5);
        if(thang != 0){
            titleCell.setCellValue("Thống kê Tiền Thưởng Nhân Viên Tháng " + thang + " Năm "+nam);
        }
        titleCell.setCellValue("Thống kê Tiền Thưởng Nhân Viên Năm "+nam);

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
        CellRangeAddress mergedRegion = new CellRangeAddress(0, 0, 5, 12);
        sheet.addMergedRegion(mergedRegion);

// Thiết lập border cho vùng ô đã hợp nhất
        RegionUtil.setBorderTop(BorderStyle.THIN, mergedRegion, sheet);
        RegionUtil.setBorderBottom(BorderStyle.THIN, mergedRegion, sheet);
        RegionUtil.setBorderLeft(BorderStyle.THIN, mergedRegion, sheet);
        RegionUtil.setBorderRight(BorderStyle.THIN, mergedRegion, sheet);

// Tạo dòng tiêu đề cột
        Row headerRow = sheet.createRow(1); // Dòng thứ 2 (bỏ qua dòng tiêu đề)
        String[] columns = {"MaNV", "Họ Và Tên", "Ngày Sinh", "SĐT","Vai Trò", "Doanh Thu (VNĐ)", "Thưởng (%)", "Thành Tiền (VNĐ)"};
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

// Tạo CellStyle cho tiền tệ
        CellStyle numberCellStyle = workbook.createCellStyle();
        numberCellStyle.setFont(valueFont);

        // Định dạng tiền tệ cho Việt Nam (VND)
        Locale vietnamLocale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnamLocale);

        // Định dạng số với dấu phân cách hàng nghìn và tiền tệ
        numberCellStyle.setDataFormat(workbook.createDataFormat().getFormat("#,##0"));  // Định dạng VND
        numberCellStyle.setAlignment(HorizontalAlignment.CENTER);
        numberCellStyle.setBorderTop(BorderStyle.THIN);
        numberCellStyle.setBorderBottom(BorderStyle.THIN);
        numberCellStyle.setBorderLeft(BorderStyle.THIN);
        numberCellStyle.setBorderRight(BorderStyle.THIN);

// tạo cell style cho định ngày sinh
        // Sử dụng Locale của Việt Nam

        // String[] columns = {"MaNV", "Họ Và Tên", "Ngày Sinh", "SĐT","Vai Trò", "Doanh Thu", "Thưởng (%)", "Thành Tiền"};
        // Tạo một CellStyle để định dạng ngày tháng
        CellStyle dateCellStyle = workbook.createCellStyle();
        short dateFormat = workbook.createDataFormat().getFormat("dd-mm-yyyy");
        dateCellStyle.setDataFormat(dateFormat);
        dateCellStyle.setFont(valueFont);
        dateCellStyle.setAlignment(HorizontalAlignment.CENTER);
        dateCellStyle.setBorderTop(BorderStyle.THIN);
        dateCellStyle.setBorderBottom(BorderStyle.THIN);
        dateCellStyle.setBorderLeft(BorderStyle.THIN);
        dateCellStyle.setBorderRight(BorderStyle.THIN);

// tạo cell style cho định dạnh chữ
        CellStyle wordCellStyle = workbook.createCellStyle();
        wordCellStyle.setFont(valueFont);
        wordCellStyle.setAlignment(HorizontalAlignment.CENTER);
        wordCellStyle.setBorderTop(BorderStyle.THIN);
        wordCellStyle.setBorderBottom(BorderStyle.THIN);
        wordCellStyle.setBorderLeft(BorderStyle.THIN);
        wordCellStyle.setBorderRight(BorderStyle.THIN);

        int rowNum = 2;
        int stt = 1;
        double tongDoanhThu= 0;
        if(thang==0){
            for (String key : danhSachDoanhThu.keySet()){
                String maNV = key;
                double doanhThu = danhSachDoanhThu.get(key);
                NhanVien nv = NhanVien_DAO.layNhanVienTheo_MaNhanVien(maNV);
                String hoTen = nv.getTenNV();
                double percentage = 0;
                if(stt == 1){
                    percentage = 0.045;
                }
                else if(stt == 2){
                    percentage = 0.04;
                }
                else if(stt == 3){
                    percentage = 0.035;
                }
                else {
                    percentage = 0.03;
                }
                double thanhTien = doanhThu * percentage;
                tongDoanhThu += thanhTien;
                Row row = sheet.createRow(rowNum++);
                // Lùi vào 5 ô (cột từ 5 trở đi)
                Cell cell0 = row.createCell(5); // Ô "" sẽ ở cột 5
                cell0.setCellValue(maNV);
                cell0.setCellStyle(numberCellStyle);
                sheet.setColumnWidth(5, 10000);

                Cell cell1 = row.createCell(6); // Ô "Doanh Thu" sẽ ở cột 6
                cell1.setCellValue(hoTen);
                cell1.setCellStyle(numberCellStyle);
                sheet.setColumnWidth(6, 12000); // Cột "Doanh Thu"

                Cell cell2 = row.createCell(7); // Ô "Doanh Thu" sẽ ở cột 6
                cell2.setCellValue(nv.getNgaySinh());
                cell2.setCellStyle(dateCellStyle);
                sheet.setColumnWidth(7, 10000); // Cột "Doanh Thu"

                Cell cell3 = row.createCell(8); // Ô "Doanh Thu" sẽ ở cột 6
                cell3.setCellValue(nv.getSoDT());
                cell3.setCellStyle(numberCellStyle);
                sheet.setColumnWidth(8, 10000); // Cột "Doanh Thu"

                Cell cell4 = row.createCell(9); // Ô "Doanh Thu" sẽ ở cột 6
                cell4.setCellValue(nv.getVaiTro());
                cell4.setCellStyle(wordCellStyle);
                sheet.setColumnWidth(9, 10000); // Cột "Doanh Thu"

                Cell cell5 = row.createCell(10); // Ô "Doanh Thu" sẽ ở cột 6
                cell5.setCellValue(doanhThu);
                cell5.setCellStyle(numberCellStyle);
                sheet.setColumnWidth(10, 10000); // Cột "Doanh Thu"

                Cell cell6 = row.createCell(11); // Ô "Doanh Thu" sẽ ở cột 6
                cell6.setCellValue(percentage+"");
                cell6.setCellStyle(numberCellStyle);
                sheet.setColumnWidth(11, 10000); // Cột "Doanh Thu"

                Cell cell7 = row.createCell(12); // Ô "Doanh Thu" sẽ ở cột 6
                cell7.setCellValue(thanhTien);
                cell7.setCellStyle(numberCellStyle);
                sheet.setColumnWidth(12, 10000); // Cột "Doanh Thu"

                stt+=1;
            }
        }
        else {
            for (String key : danhSachDoanhThu.keySet()){
                String maNV = key;
                double doanhThu = danhSachDoanhThu.get(key);
                NhanVien nv = NhanVien_DAO.layNhanVienTheo_MaNhanVien(maNV);
                String hoTen = nv.getTenNV();
                double percentage = 0;
                if(stt == 1){
                    percentage =  0.2;
                }
                else if(stt == 2){
                    percentage = 0.17;
                }
                else if(stt == 3){
                    percentage = 0.15;
                }
                else {
                    percentage = 0.1;
                }
                double thanhTien = doanhThu * percentage;
                tongDoanhThu += thanhTien;
                Row row = sheet.createRow(rowNum++);
                // Lùi vào 5 ô (cột từ 5 trở đi)
                Cell cell0 = row.createCell(5); // Ô "" sẽ ở cột 5
                cell0.setCellValue(maNV);
                cell0.setCellStyle(numberCellStyle);
                sheet.setColumnWidth(5, 10000);

                Cell cell1 = row.createCell(6); // Ô "Doanh Thu" sẽ ở cột 6
                cell1.setCellValue(hoTen);
                cell1.setCellStyle(numberCellStyle);
                sheet.setColumnWidth(6, 12000); // Cột "Doanh Thu"

                Cell cell2 = row.createCell(7); // Ô "Doanh Thu" sẽ ở cột 6
                cell2.setCellValue(nv.getNgaySinh());
                cell2.setCellStyle(dateCellStyle);
                sheet.setColumnWidth(7, 10000); // Cột "Doanh Thu"

                Cell cell3 = row.createCell(8); // Ô "Doanh Thu" sẽ ở cột 6
                cell3.setCellValue(nv.getSoDT());
                cell3.setCellStyle(numberCellStyle);
                sheet.setColumnWidth(8, 10000); // Cột "Doanh Thu"

                Cell cell4 = row.createCell(9); // Ô "Doanh Thu" sẽ ở cột 6
                cell4.setCellValue(nv.getVaiTro());
                cell4.setCellStyle(wordCellStyle);
                sheet.setColumnWidth(9, 10000); // Cột "Doanh Thu"

                Cell cell5 = row.createCell(10); // Ô "Doanh Thu" sẽ ở cột 6
                cell5.setCellValue(doanhThu);
                cell5.setCellStyle(numberCellStyle);
                sheet.setColumnWidth(10, 10000); // Cột "Doanh Thu"

                Cell cell6 = row.createCell(11); // Ô "Doanh Thu" sẽ ở cột 6
                cell6.setCellValue(percentage+"");
                cell6.setCellStyle(numberCellStyle);
                sheet.setColumnWidth(11, 10000); // Cột "Doanh Thu"

                Cell cell7 = row.createCell(12); // Ô "Doanh Thu" sẽ ở cột 6
                cell7.setCellValue(thanhTien);
                cell7.setCellStyle(numberCellStyle);
                sheet.setColumnWidth(12, 10000); // Cột "Doanh Thu"

                stt+=1;
            }
        }

        Row row = sheet.createRow(rowNum);
        Cell cellLabel = row.createCell(5); // Ô "" sẽ ở cột 5
        cellLabel.setCellValue("Tổng Số Tiền Thưởng: ");
        cellLabel.setCellStyle(wordCellStyle);
        CellRangeAddress mergedRegion_LabelTongTien = new CellRangeAddress(rowNum, rowNum, 5, 10);
        sheet.addMergedRegion(mergedRegion_LabelTongTien);
// Thiết lập border cho vùng ô đã hợp nhất
        RegionUtil.setBorderTop(BorderStyle.THIN, mergedRegion_LabelTongTien, sheet);
        RegionUtil.setBorderBottom(BorderStyle.THIN, mergedRegion_LabelTongTien, sheet);
        RegionUtil.setBorderLeft(BorderStyle.THIN, mergedRegion_LabelTongTien, sheet);
        RegionUtil.setBorderRight(BorderStyle.THIN, mergedRegion_LabelTongTien, sheet);

        Cell cellTongDoanhThu = row.createCell(11); // Ô "Doanh Thu" sẽ ở cột 6
        cellTongDoanhThu.setCellValue(tongDoanhThu);
        cellTongDoanhThu.setCellStyle(numberCellStyle);
        CellRangeAddress mergedRegion_TongTien = new CellRangeAddress(rowNum, rowNum, 11, 12);
        sheet.addMergedRegion(mergedRegion_TongTien);
// Thiết lập border cho vùng ô đã hợp nhất
        RegionUtil.setBorderTop(BorderStyle.THIN, mergedRegion_TongTien, sheet);
        RegionUtil.setBorderBottom(BorderStyle.THIN, mergedRegion_TongTien, sheet);
        RegionUtil.setBorderLeft(BorderStyle.THIN, mergedRegion_TongTien, sheet);
        RegionUtil.setBorderRight(BorderStyle.THIN, mergedRegion_TongTien, sheet);

// Ghi workbook ra file
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
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
