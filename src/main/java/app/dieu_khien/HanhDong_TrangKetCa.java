package app.dieu_khien;

import app.dao.CaTruc_DAO;
import app.giao_dien.TrangDangNhap;
import app.giao_dien.TrangDinhHuong;
import app.giao_dien.TrangKetCa;
import app.thuc_the.CaTruc;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.*;
import org.apache.poi.xwpf.usermodel.*;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.text.AttributedCharacterIterator;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static jdk.jfr.consumer.EventStream.openFile;


public class HanhDong_TrangKetCa implements ActionListener {
    public HanhDong_TrangKetCa(TrangKetCa trangKetCa) {
        this.trangKetCa = trangKetCa;
    }

    TrangKetCa trangKetCa;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.trangKetCa.btn_minus_1000) {
            if (this.trangKetCa.soTo1000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo1000--;
                this.trangKetCa.textField_1000.setText(String.valueOf(this.trangKetCa.soTo1000));
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_1000) {
            this.trangKetCa.soTo1000++;
            this.trangKetCa.textField_1000.setText(String.valueOf(this.trangKetCa.soTo1000));
        } else if (e.getSource() == this.trangKetCa.btn_minus_2000) {
            if (this.trangKetCa.soTo2000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo2000--;
                this.trangKetCa.textField_2000.setText(String.valueOf(this.trangKetCa.soTo2000));
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_2000) {
            this.trangKetCa.soTo2000++;
            this.trangKetCa.textField_2000.setText(String.valueOf(this.trangKetCa.soTo2000));
        } else if (e.getSource() == this.trangKetCa.btn_minus_5000) {
            if (this.trangKetCa.soTo5000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo5000--;
                this.trangKetCa.textField_5000.setText(String.valueOf(this.trangKetCa.soTo5000));
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_5000) {
            this.trangKetCa.soTo5000++;
            this.trangKetCa.textField_5000.setText(String.valueOf(this.trangKetCa.soTo5000));
        } else if (e.getSource() == this.trangKetCa.btn_minus_10000) {
            if (this.trangKetCa.soTo10000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo10000--;
                this.trangKetCa.textField_10000.setText(String.valueOf(this.trangKetCa.soTo10000));
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_10000) {
            this.trangKetCa.soTo10000++;
            this.trangKetCa.textField_10000.setText(String.valueOf(this.trangKetCa.soTo10000));

        } else if (e.getSource() == this.trangKetCa.btn_minus_20000) {
            if (this.trangKetCa.soTo20000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo20000--;
                this.trangKetCa.textField_20000.setText(String.valueOf(this.trangKetCa.soTo20000));
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_20000) {
            this.trangKetCa.soTo20000++;
            this.trangKetCa.textField_20000.setText(String.valueOf(this.trangKetCa.soTo20000));
        } else if (e.getSource() == this.trangKetCa.btn_minus_50000) {
            if (this.trangKetCa.soTo50000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo50000--;
                this.trangKetCa.textField_50000.setText(String.valueOf(this.trangKetCa.soTo50000));
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_50000) {
            this.trangKetCa.soTo50000++;
            this.trangKetCa.textField_50000.setText(String.valueOf(this.trangKetCa.soTo50000));
        } else if (e.getSource() == this.trangKetCa.btn_minus_100000) {
            if (this.trangKetCa.soTo100000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo100000--;
                this.trangKetCa.textField_100000.setText(String.valueOf(this.trangKetCa.soTo100000));
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_100000) {
            this.trangKetCa.soTo100000++;
            this.trangKetCa.textField_100000.setText(String.valueOf(this.trangKetCa.soTo100000));
        } else if (e.getSource() == this.trangKetCa.btn_minus_200000) {
            if (this.trangKetCa.soTo200000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo200000--;
                this.trangKetCa.textField_200000.setText(String.valueOf(this.trangKetCa.soTo200000));
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_200000) {
            this.trangKetCa.soTo200000++;
            this.trangKetCa.textField_200000.setText(String.valueOf(this.trangKetCa.soTo200000));
        } else if (e.getSource() == this.trangKetCa.btn_minus_500000) {
            if (this.trangKetCa.soTo500000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo500000--;
                this.trangKetCa.textField_500000.setText(String.valueOf(this.trangKetCa.soTo500000));
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_500000) {
            this.trangKetCa.soTo500000++;
            this.trangKetCa.textField_500000.setText(String.valueOf(this.trangKetCa.soTo500000));
        } else if (e.getSource() == this.trangKetCa.btn_minus_100000) {
            if (this.trangKetCa.soTo100000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo100000--;
                this.trangKetCa.textField_100000.setText(String.valueOf(this.trangKetCa.soTo100000));
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_100000) {
            this.trangKetCa.soTo100000++;
            this.trangKetCa.textField_100000.setText(String.valueOf(this.trangKetCa.soTo100000));
        } else if (e.getSource() == this.trangKetCa.btn_minus_200000) {
            if (this.trangKetCa.soTo200000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo200000--;
                this.trangKetCa.textField_200000.setText(String.valueOf(this.trangKetCa.soTo200000));
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_200000) {
            this.trangKetCa.soTo200000++;
            this.trangKetCa.textField_200000.setText(String.valueOf(this.trangKetCa.soTo200000));
        } else if (e.getSource() == this.trangKetCa.btn_minus_500000) {
            if (this.trangKetCa.soTo500000 == 0) {
                return;
            } else {
                this.trangKetCa.soTo500000--;
                this.trangKetCa.textField_500000.setText(String.valueOf(this.trangKetCa.soTo500000));
            }
        } else if (e.getSource() == this.trangKetCa.btn_plus_500000) {
            this.trangKetCa.soTo500000++;
            this.trangKetCa.textField_500000.setText(String.valueOf(this.trangKetCa.soTo500000));
        } else if (e.getSource() == trangKetCa.btn_xacNhan) {
            this.xacNhan();
        } else if (e.getSource() == trangKetCa.btn_hoanTat) {
            themCaTruc();
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
        Double tongTienCaTruoc = Double.parseDouble(trangKetCa.label_hienTongTienCaTruoc.getText());
        Double tongTienHoaDon = Double.parseDouble(trangKetCa.label_hienTongTienHeThong.getText());
        Double tongTienThucThu = Double.parseDouble(trangKetCa.textField_tienThucThu.getText());
        Double thatThoat = Double.parseDouble(trangKetCa.label_hienChechLech.getText());
        Double tongVAT = Double.parseDouble(trangKetCa.label_hienTongVAT.getText());
        Double tongTienGiamGia = Double.parseDouble(trangKetCa.label_hienTongGiam.getText());
        CaTruc caTruc = new CaTruc(maNhanVien, ngayGioBatDau_localDateTime, ngayGioKetThuc_localDateTime, tongHoaDon, tongTienCaTruoc, tongTienHoaDon, tongTienThucThu, thatThoat, tongVAT, tongTienGiamGia);
        if(CaTruc_DAO.themCaTruc(caTruc)){
            JOptionPane.showMessageDialog(trangKetCa, "Thêm ca trực thành công");
            int luaChon = JOptionPane.showConfirmDialog(trangKetCa, "Bạn có muốn in phiếu không?", "In phiếu", JOptionPane.YES_NO_OPTION);
            if (luaChon == JOptionPane.YES_OPTION) {
                CaTruc caTrucIn = CaTruc_DAO.layCaTrucTheoMaNV(maNhanVien);
                System.out.println(caTrucIn);
                inPhieu(caTrucIn);
                this.trangKetCa.setVisible(false);
                Window window = SwingUtilities.getWindowAncestor(TrangDinhHuong.getTrangChua());
                window.dispose();
                TrangDangNhap trangDangNhap = new TrangDangNhap();
                trangDangNhap.setVisible(true);
            } else if ( luaChon == JOptionPane.NO_OPTION) {
                this.trangKetCa.setVisible(false);
                Window window = SwingUtilities.getWindowAncestor(TrangDinhHuong.getTrangChua());
                window.dispose();
                TrangDangNhap trangDangNhap = new TrangDangNhap();
                trangDangNhap.setVisible(true);
            } else if ( luaChon == JOptionPane.CLOSED_OPTION) {
                this.trangKetCa.setVisible(false);
                Window window = SwingUtilities.getWindowAncestor(TrangDinhHuong.getTrangChua());
                window.dispose();
                TrangDangNhap trangDangNhap = new TrangDangNhap();
                trangDangNhap.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(trangKetCa, "Thêm ca trực thất bại");
        }


    }

    private void inPhieu( CaTruc caTruc) {
        String input = "src/main/java/app/resources/PhieuKetCa_mau.docx";
        String outputWord = "src/main/java/app/resources/PhieuKetCa_" + caTruc.getMaCaTruc() + ".docx";
        String outputPDF = "src/main/java/app/resources/PhieuKetCa_" + caTruc.getMaCaTruc() + ".pdf";

        String[] tokens = {"%MANHANVIEN%", "%TENNHANVIEN%", "%BATDAU%", "%KETTHUC%"};
        String[] values = {caTruc.getMaNhanVien(), trangKetCa.label_hienTenNV.getText(), trangKetCa.label_hienGioVaoCa.getText(), trangKetCa.label_hienGioKetCa.getText()};

        try (FileInputStream fis = new FileInputStream(input);
             XWPFDocument document = new XWPFDocument(fis)) {

            for (int i = 0; i < tokens.length; i++) {
                for (XWPFParagraph p : document.getParagraphs()) {
                    for (XWPFRun r : p.getRuns()) {
                        String text = r.getText(0);
                        if (text != null && text.contains(tokens[i])) {
                            // Thay thế token bằng giá trị tương ứng
                            text = text.replace(tokens[i], values[i]);
                            r.setText(text, 0);
                        }
                    }
                }
            }
            XWPFTable table = document.getTables().get(0);
            XWPFTableRow firstRow = table.getRow(0);
            firstRow.getCell(0).setText("Tổng số hóa đơn");
            firstRow.getCell( 1 ).setText(String.valueOf(caTruc.getTongHoaDon()));
            XWPFTableRow newRow = table.createRow();
            newRow.getCell(0).setText("Tổng tiền ca trực");
            newRow.getCell(1).setText(String.valueOf(caTruc.getTongTienCaTruoc()));
            newRow = table.createRow();
            newRow.getCell(0).setText("Tổng tiền hệ thống");
            newRow.getCell(1).setText(String.valueOf(caTruc.getTongTienHoaDon()));
            newRow = table.createRow();
            newRow.getCell(0).setText("Tổng VAT");
            newRow.getCell(1).setText(String.valueOf(caTruc.getTongVAT()));
            newRow = table.createRow();
            newRow.getCell(0).setText("Tổng giảm giá");
            newRow.getCell(1).setText(String.valueOf(caTruc.getTongTienGiamGia()));
            newRow = table.createRow();
            newRow.getCell(0).setText("Tổng tiền thực thu");
            newRow.getCell(1).setText(String.valueOf(caTruc.getTongTienThucThu()));
            newRow = table.createRow();
            newRow.getCell(0).setText("Chênh lệch");
            newRow.getCell(1).setText(String.valueOf(caTruc.getThatThoat()));
            FileOutputStream out = new FileOutputStream(outputWord);
            document.write(out);
            out.close();

        } catch (IOException e) {
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
        trangKetCa.textField_tienThucThu.setText(String.valueOf(trangKetCa.tongTien));
        Double tienHeThong = Double.parseDouble(trangKetCa.label_hienTongTienHeThong.getText());
        Double chenhLech = tienHeThong - trangKetCa.tongTien;
        trangKetCa.label_hienChechLech.setText(String.valueOf(chenhLech));
    }

}