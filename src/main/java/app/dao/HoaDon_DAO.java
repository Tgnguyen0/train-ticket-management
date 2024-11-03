package app.dao;

import app.giao_dien.TrangHoaDon;
import app.ket_noi_co_so_du_lieu.JDBCUtil;
import app.thuc_the.HoaDon;
import app.thuc_the.KhachHang;
import app.thuc_the.NhanVien;

import java.sql.*;

import app.giao_dien.TrangChuaThongKeDoanhThuNhaGa;
import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.HoaDon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoaDon_DAO {
    ArrayList<HoaDon> dshd;

    Logger logger  = LoggerFactory.getLogger(TrangChuaThongKeDoanhThuNhaGa.class);

    // Khởi tạo danh sách khách hàng
    public HoaDon_DAO() {
        dshd = new ArrayList<HoaDon>();
    }

    public List<HoaDon> layDanhSachHoaDon() {
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        String sql = "SELECT TOP 15 *\n" +
                "FROM HoaDon\n" +
                "ORDER BY NgayLap DESC;\n";

        try (Connection conn = JDBCUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setNgayLap(rs.getDate("NgayLap").toLocalDate());
                hd.setMaNV(rs.getString("MaNV"));
                hd.setThanhTien(rs.getFloat("ThanhTien"));
                hd.setMaKH(rs.getString("MaKH"));
                hd.setSoLuong(rs.getInt("SoLuong"));
                hd.setTongTien(rs.getFloat("TongTien"));
                hd.setTrangThai(rs.getString("TrangThai"));
                hd.setDaiNgo(rs.getFloat("DaiNgo"));
                hd.setThue(rs.getFloat("Thue"));

                danhSachHoaDon.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachHoaDon;
    }
    public List<HoaDon> TimKiemHoaDon (String maHD, String maKH){
            List<HoaDon> danhSachHoaDon = new ArrayList<>();
            String sql = "SELECT * FROM HoaDon WHERE MaHD LIKE ? OR MaKH LIKE ?";

            try (Connection conn = JDBCUtil.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, "%" + maHD + "%"); // Tìm kiếm theo mã hóa đơn
                ps.setString(2, "%" + maKH + "%"); // Tìm kiếm theo mã khách hàng

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    HoaDon hoaDon = new HoaDon();
                    // Giả sử bạn có các phương thức set tương ứng để gán giá trị cho các thuộc tính
                    hoaDon.setMaHD(rs.getString("MaHD"));
                    hoaDon.setMaKH(rs.getString("MaKH"));
                    hoaDon.setNgayLap(rs.getDate("NgayLap").toLocalDate());
                    hoaDon.setMaNV(rs.getString("MaNV"));
                    hoaDon.setThanhTien(rs.getFloat("ThanhTien"));
                    hoaDon.setSoLuong(rs.getInt("SoLuong"));
                    hoaDon.setTongTien(rs.getFloat("TongTien"));
                    hoaDon.setTrangThai(rs.getString("TrangThai"));
                    hoaDon.setDaiNgo(rs.getFloat("DaiNgo"));
                    // Thêm các thuộc tính khác nếu cần
                    danhSachHoaDon.add(hoaDon);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return danhSachHoaDon;
        }


    public static ArrayList<String> layToanBoNamTuHoaDon(){
        ArrayList<String> namList = new ArrayList<>();
        String sql = "SELECT DISTINCT YEAR(NgayLap) AS nam FROM HoaDon  order by YEAR(NgayLap) ASC";

        try (Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String nam = resultSet.getString("nam");
                namList.add(nam);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return namList;
    }

    public static double tongDoanhThuCuaNam(int nam){
        double tongDoanhThu = 0.0;
        String query = "SELECT SUM(ThanhTien) AS Total FROM HoaDon WHERE YEAR(NgayLap) = ?";

        try (Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, nam);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tongDoanhThu = resultSet.getDouble("Total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tongDoanhThu;
    }
    public static double tongDoanhThuCuaThang_Nam(int nam, int thang){
        double tongDoanhThu = 0.0;
        String query = "SELECT SUM(ThanhTien) AS Total FROM HoaDon WHERE YEAR(NgayLap) = ? and MONTH(NgayLap) = ?";

        try (Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, nam);
            preparedStatement.setInt(2, thang);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tongDoanhThu = resultSet.getDouble("Total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tongDoanhThu;
    }

    public static int tongSoLuongCuaThang_Nam(int nam, int thang){
        int tongSoLuong = 0;
        String query = "SELECT SUM(SoLuong) AS Total FROM HoaDon WHERE YEAR(NgayLap) = ? and MONTH(NgayLap) = ?";

        try (Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, nam);
            preparedStatement.setInt(2, thang);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tongSoLuong = resultSet.getInt("Total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tongSoLuong;
    }

    public static Map<String, Double> layDoanhThuCacNam(int namXuatPhat, int namKetThuc){
        Map<String, Double> doanhThuTheoNam = new HashMap<>();

        String sql = "SELECT YEAR(NgayLap) AS nam, SUM(ThanhTien) AS tongDoanhThu " +
                "FROM HoaDon " +
                "WHERE YEAR(NgayLap) >= ? AND YEAR(NgayLap) <= ? " +
                "GROUP BY YEAR(NgayLap)";

        try (Connection conn = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, namXuatPhat);
            pstmt.setInt(2, namKetThuc);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int nam = rs.getInt("nam");
                    double tongDoanhThu = rs.getDouble("tongDoanhThu");
                    doanhThuTheoNam.put(nam+"", tongDoanhThu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return doanhThuTheoNam;
    }

    public static int tongSoLuongCuaNam(int nam){
        int tongSoLuong = 0;
        String query = "SELECT SUM(SoLuong) AS Total FROM HoaDon WHERE YEAR(NgayLap) = ?";

        try (Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, nam);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tongSoLuong = resultSet.getInt("Total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tongSoLuong;
    }

    public static Map<String, Double> layDoanhThuCuaTungNhanVienTheo_Nam(int nam){
        Map<String, Double> danhSachDoanhThu = new HashMap<>();
        String sql = "SELECT SUM(hd.ThanhTien) AS DoanhThu, nv.TenNV " +
                "FROM HoaDon hd " +
                "JOIN NhanVien nv ON hd.MaNV = nv.MaNV " +
                "WHERE YEAR(hd.NgayLap) = ? " +
                "GROUP BY hd.MaNV, nv.TenNV";

        try (Connection conn = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, nam); // Set the year in the query

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String tenNV = rs.getString("TenNV");
                    double doanhThu = rs.getDouble("DoanhThu");
                    danhSachDoanhThu.put(tenNV, doanhThu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  danhSachDoanhThu;
    }

    public static Map<String, Double> layDoanhThuCuaNhanVienUuTuTheo_Nam(int nam){
        Map<String, Double> danhSachDoanhThu = new HashMap<>();
        String sql = "SELECT Top 3 SUM(hd.ThanhTien) AS DoanhThu, nv.TenNV " +
                "FROM HoaDon hd " +
                "JOIN NhanVien nv ON hd.MaNV = nv.MaNV " +
                "WHERE YEAR(hd.NgayLap) = ? " +
                "GROUP BY hd.MaNV, nv.TenNV" +
                " order by sum(hd.ThanhTien)  DESC";

        try (Connection conn = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, nam); // Set the year in the query

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String tenNV = rs.getString("TenNV");
                    double doanhThu = rs.getDouble("DoanhThu");
                    danhSachDoanhThu.put(tenNV, doanhThu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  danhSachDoanhThu;
    }
    public static Map<String, Double> layDoanhThuCuaNhanVienUuTuTheo_Thang_Nam(int nam, int thang){
        Map<String, Double> danhSachDoanhThu = new HashMap<>();
        String sql = "SELECT Top 1 SUM(hd.ThanhTien) AS DoanhThu, nv.TenNV " +
                "FROM HoaDon hd " +
                "JOIN NhanVien nv ON hd.MaNV = nv.MaNV " +
                "WHERE YEAR(hd.NgayLap) = ? and MONTH(hd.NgayLap) = ? " +
                "GROUP BY hd.MaNV, nv.TenNV" +
                " order by sum(hd.ThanhTien)  DESC";

        try (Connection conn = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, nam); // Set the year in the query
            stmt.setInt(2, thang);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String tenNV = rs.getString("TenNV");
                    double doanhThu = rs.getDouble("DoanhThu");
                    danhSachDoanhThu.put(tenNV, doanhThu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  danhSachDoanhThu;
    }

    public static Map<String, Double> layDoanhThuCuaTungNhanVienTheo_Thang_Nam(int nam, int thang){
        Map<String, Double> danhSachDoanhThu = new HashMap<>();
        String sql = "SELECT SUM(hd.ThanhTien) AS DoanhThu, nv.TenNV " +
                "FROM HoaDon hd " +
                "JOIN NhanVien nv ON hd.MaNV = nv.MaNV " +
                "WHERE YEAR(hd.NgayLap) = ? and MONTH(hd.NgayLap) = ? " +
                "GROUP BY hd.MaNV, nv.TenNV";

        try (Connection conn = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, nam); // Set the year in the query
            stmt.setInt(2, thang);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String tenNV = rs.getString("TenNV");
                    double doanhThu = rs.getDouble("DoanhThu");
                    danhSachDoanhThu.put(tenNV, doanhThu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  danhSachDoanhThu;
    }
}

