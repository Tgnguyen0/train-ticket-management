package app.dao;

import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.ChiTietHoaDon;
import app.thuc_the.Ve;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public class ChiTietHoaDon_DAO {
    public static String layMaHoaDonDuaVao_MaVe(String maVe){
        String maHoaDon = "";
        String sql = "select MaHD from Ve v " +
                        " join ChiTietHoaDon ct on v.MaVe = ct.MaVe where ct.MaVe = ? ";

        try {
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, maVe);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                maHoaDon = rs.getString("MaHD");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maHoaDon;
    }

    public static ArrayList<Ve> layDanhSachVeTau_MaHoaDon(String maHoaDon){
        ArrayList<Ve> danhSachVe = new ArrayList<>();
        String sql = "select v.MaVe as MaVe, \n" +
                "\t\tv.NgayDatVe as NgayDatVe,\n" +
                "\t\tv.GiaVe as GiaVe ,\n" +
                "\t\tv.MaKH as MaKH, \n" +
                "\t\tv.GaKhoiHanh as GaKhoiHanh, \n" +
                "\t\tv.GaKetThuc as GaKetThuc, \n" +
                "\t\tv.MaGhe as MaGhe, v.LoaiVe as LoaiVe, \n" +
                "\t\tv.LoaiDoiTuong as LoaiDoiTuong,\n" +
                "\t\tv.NgayKhoiHanh as NgayKhoiHanh\n" +
                "\t\t from  Ve v join ChiTietHoaDon ct on v.MaVe = ct.MaVe join HoaDon hd on ct.MaHD = hd.MaHD where ct.MaHD =  ?  ";

        try {
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, maHoaDon);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String maVe = resultSet.getString("MaVe");
                LocalDateTime ngayDatVe = resultSet.getTimestamp("NgayDatVe")
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime(); // Chuyển đổi thành LocalDateTime
                double giaVe = resultSet.getDouble("GiaVe");
                String maKh = resultSet.getString("MaKH");
                String gaKhoiHanh = resultSet.getString("GaKhoiHanh");
                String gaKetThuc = resultSet.getString("GaKetThuc");
                String maGhe = resultSet.getString("MaGhe");
                String loaiVe = resultSet.getString("LoaiVe");
                String loaiDoiTuong = resultSet.getString("LoaiDoiTuong");
                LocalDateTime ngayKhoiHanh = resultSet.getTimestamp("NgayKhoiHanh")
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime(); // Chuyển đổi thành LocalDateTime

                danhSachVe.add(new Ve(maVe, loaiDoiTuong, ngayKhoiHanh, ngayDatVe, gaKhoiHanh, gaKetThuc, giaVe, maKh, maGhe, loaiVe));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return danhSachVe;
    }

    public static  void xoaChiTietHoaDon(String maVe, String maHoaDon){
        String sql = "DELETE ChiTietHoaDon WHERE MaVe = ? AND MaHD = ? ";

        try (Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Gán các giá trị vào câu lệnh SQL
           preparedStatement.setString(1, maVe);
           preparedStatement.setString(2, maHoaDon);

            // Thực thi câu lệnh
            int rowsUpdated = preparedStatement.executeUpdate() ;
//            System.out.println("rowsUpdated: "+ rowsUpdated);
            if (rowsUpdated > 0 || rowsUpdated == -1) {
                //System.out.println("Cập nhật thành công hóa đơn có mã: " + hoaDon.getMaHoaDon());
                //JOptionPane.showMessageDialog(null, "Cập nhật thành công hóa đơn có mã: " + maVe);
                System.out.println("Xóa thành công chi tiết hóa đơn của "+ maHoaDon);
            } else {
                // System.out.println("Không tìm thấy hóa đơn với mã: " + hoaDon.getMaHoaDon());
                //JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn với mã: " + );
                System.out.println("Xóa không thành công chi tiết hóa đơn của "+ maHoaDon);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lưu chi tiết hóa đơn vào cơ sở dữ liệu
    public static void themCTHD(ChiTietHoaDon cthd) {
        String sql = "INSERT INTO ChiTietHoaDon(MaVe,MaHD) VALUES (?,?)"; // câu lệnh sql để lưu

        LuuSQL(
                sql,
                cthd.getMaVe(),
                cthd.getMaHoaDon()
        );
    }

    // Tiến hành kết nối và lưu
    public static void LuuSQL(String sql, Object... args) {
        try {
            try (PreparedStatement stmt = KetNoiCoSoDuLieu.layCauLenh(sql, args)) {
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // In ra nếu kết nối thất bại
            throw new RuntimeException(ex);
        }
    }
}
