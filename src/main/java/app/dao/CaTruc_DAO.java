package app.dao;

import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.CaTruc;

import javax.swing.text.DateFormatter;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CaTruc_DAO {
    public static double layTienCaTruoc(){
        Connection c;
        double tienCaTruoc = 0.0;
        try {
            c = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            if (c == null) {
                System.out.println("Ket noi that bai");
                return 0.0;
            }
            String sql = "SELECT TOP 1 tongTienThucThu FROM [dbo].[CaTruc] ORDER BY ngayGioBatDau DESC;\n";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tienCaTruoc = Double.parseDouble(rs.getString("tongTienThucThu"));
                // Process the data
            } else {
                System.out.println("No data found.");
                // Handle the case when no data is available
            }
            System.out.printf("Tien ca truoc: %f", tienCaTruoc);
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.printf("Tien ca truoc: %f", tienCaTruoc);
        return tienCaTruoc;
    }

    public CaTruc_DAO() {
    }
    public static boolean themCaTruc(CaTruc caTruc) {
        Connection c ;//= null;
        int kq = 0;
        try {
            c = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            /*if (c == null) {
                System.out.println("Ket noi that bai");
                return false;
            }*/
            String sql = "INSERT INTO [dbo].[CaTruc] ([maNV],[ngayGioBatDau],[ngayGioKetCa],[tongHoaDon],[tongTienCaTruoc],[tongTienHoaDon],[tongTienThucThu],[thatThoat],[tongVAT],[tongTienGiamGia]) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, caTruc.getMaNhanVien());
            ps.setString(2, caTruc.getNgayGioBatDau().toString());
            ps.setString(3, caTruc.getNgayGioKetThuc().toString());
            ps.setInt(4, caTruc.getTongHoaDon());
            ps.setDouble(5, caTruc.getTongTienCaTruoc());
            ps.setDouble(6, caTruc.getTongTienHoaDon());
            ps.setDouble(7, caTruc.getTongTienThucThu());
            ps.setDouble(8, caTruc.getThatThoat());
            ps.setDouble(9, caTruc.getTongVAT());
            ps.setDouble(10, caTruc.getTongTienGiamGia());
            kq = ps.executeUpdate();
            ps.close();
            c.close();
            /*if (kq > 0) {
                System.out.println("Them thanh cong");
                return true;
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("kq: " + kq);
        if (kq > 0) {
                System.out.println("Them thanh cong");
                return true;
            }

        return  false;
    }

    public static ArrayList<CaTruc> layDanhSachTruc(String maNV) {
        System.out.println(maNV);
        ArrayList<CaTruc> danhSachTruc = new ArrayList<>();
        Connection c = null;
        try {
            c = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            if (c == null) {
                System.out.println("Ket noi that bai");
                return null;
            }
            String sql = "SELECT * FROM [dbo].[CaTruc] WHERE maNV = ? order by maCa desc;";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, maNV);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            while (rs.next()) {
                System.out.println(1);
                String maNhanVien = rs.getString("maNV");
                System.out.println(2);
                String ngayGioBatDau = rs.getString("ngayGioBatDau").replace(".0", "");
                String ngayGioKetThuc = rs.getString("ngayGioKetCa").replace(".0", "");
                System.out.println(4);
                System.out.println(ngayGioKetThuc);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime ngayGioBatDau_localDateTime = LocalDateTime.parse(ngayGioBatDau, formatter);
                LocalDateTime ngayGioKetThuc_localDateTime = LocalDateTime.parse(ngayGioKetThuc, formatter);

                CaTruc caTruc = new CaTruc(maNhanVien, ngayGioBatDau_localDateTime, ngayGioKetThuc_localDateTime);
                System.out.printf(caTruc.toString());
                danhSachTruc.add(caTruc);
            }
            ps.close();
            c.close();
            return danhSachTruc;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static CaTruc layCaTrucTheoMaNV(String maNhanVien) {
        Connection c = null;
        CaTruc caTruc = null;
        try {
            c = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            if (c == null) {
                System.out.println("Ket noi that bai");
                return null;
            }
            String sql = "SELECT * FROM [dbo].[CaTruc] WHERE maNV = ? order by maCa desc;";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String maCaTruc = rs.getString("maCa");
                String maNV = rs.getString("maNV");
                String ngayGioBatDau = rs.getString("ngayGioBatDau").replace(".0", "");
                String ngayGioKetThuc = rs.getString("ngayGioKetCa").replace(".0", "");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime ngayGioBatDau_localDateTime = LocalDateTime.parse(ngayGioBatDau, formatter);
                LocalDateTime ngayGioKetThuc_localDateTime = LocalDateTime.parse(ngayGioKetThuc, formatter);

                int tongHoaDon = rs.getInt("tongHoaDon");
                double tongTienCaTruoc = rs.getDouble("tongTienCaTruoc");
                double tongTienHoaDon = rs.getDouble("tongTienHoaDon");
                double tongTienThucThu = rs.getDouble("tongTienThucThu");
                double thatThoat = rs.getDouble("thatThoat");
                double tongVAT = rs.getDouble("tongVAT");
                double tongTienGiamGia = rs.getDouble("tongTienGiamGia");

                caTruc = new CaTruc(maCaTruc, maNV, ngayGioBatDau_localDateTime, ngayGioKetThuc_localDateTime, tongHoaDon, tongTienCaTruoc, tongTienHoaDon, tongTienThucThu, thatThoat, tongVAT, tongTienGiamGia);

            }
            ps.close();
            c.close();
            return caTruc;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}