package app.dao;

import app.giao_dien.TrangHoaDon;
import app.ket_noi_co_so_du_lieu.JDBCUtil;
import app.thuc_the.*;

import java.sql.*;
import app.giao_dien.TrangKetCa;
import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.HoaDon;

import java.sql.ResultSet;
import java.sql.SQLException;

import app.giao_dien.TrangChuaThongKeDoanhThuNhaGa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoaDon_DAO {
    String CHON_15_SQL = "SELECT * FROM HoaDon ORDER BY NgayLap DESC;";
    String CHON_TAT_SQL = "SELECT * FROM HoaDon";
    String CHON_THEO_MAHD_SQL = "SELECT * FROM HoaDon WHERE MaHD =?";
    String CHON_THEO_MAKH_SQL = "SELECT * FROM HoaDon WHERE MaKH =?";
    String LUU_HOA_DON_SQL = "INSERT INTO HoaDon(MaHD,NgayLap,MaNV,ThanhTien,MaKH,SoLuong,TongTien,TrangThai,DaiNgo,Thue) VALUES (?,?,?,?,?,?,?,?,?,?)";
    String CAP_NHAT_TRANG_THAI_SQL = "UPDATE HoaDon SET TrangThai = ? WHERE MaHD = ?";
    String CHON_THEO_MAHD_HAY_MAKH_SQL = "SELECT * FROM HoaDon WHERE MaHD =? OR MaKH =?";

    ArrayList<HoaDon> dshd;

    Logger logger  = LoggerFactory.getLogger(TrangChuaThongKeDoanhThuNhaGa.class);




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
                hd.setMaHoaDon(rs.getString("MaHD"));
                hd.setNgayLapHoaDon(rs.getDate("NgayLap").toLocalDate());
                hd.setMaNhanVien(rs.getString("MaNV"));
                hd.setThanhTien(rs.getFloat("ThanhTien"));
                hd.setMaKhachHang(rs.getString("MaKH"));
                hd.setSoLuong(rs.getInt("SoLuong"));
                hd.setTongTien(rs.getFloat("TongTien"));
                hd.setTrangThai(rs.getString("TrangThai"));
                if(rs.getFloat("DaiNgo") == 0){
                    hd.setDaiNgo(DaiNgo.KhongDaiNgo);
                }
                else if( rs.getFloat("DaiNgo") == 0.2  ){
                    hd.setDaiNgo(DaiNgo.GIAMGIAHAIMUOIPHANTRAM);
                }
                else if( rs.getFloat("DaiNgo") == 0.1  ){
                    hd.setDaiNgo(DaiNgo.GIAMGIAMUOIPHANTRAM);
                }
                else if( rs.getFloat("DaiNgo") == 0.05  ){
                    hd.setDaiNgo(DaiNgo.GIAMGIANAMPHANTRAM);
                }

                //hd.setDaiNgo(rs.getFloat("DaiNgo"));
                hd.setThue(rs.getFloat("Thue"));

                danhSachHoaDon.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachHoaDon;
    }
//    public List<HoaDon> TimKiemHoaDon (String maHD, String maKH) throws SQLException {
//            List<HoaDon> danhSachHoaDon = new ArrayList<>();
//            String sql = "SELECT * FROM HoaDon WHERE MaHD LIKE ? OR MaKH LIKE ?";
//
//            try (Connection conn = JDBCUtil.getConnection();
//                 PreparedStatement ps = conn.prepareStatement(sql)) {
//                ps.setString(1, "%" + maHD + "%"); // Tìm kiếm theo mã hóa đơn
//                ps.setString(2, "%" + maKH + "%"); // Tìm kiếm theo mã khách hàng
//
//                ResultSet rs = ps.executeQuery();
//
//                while (rs.next()) {
//                    HoaDon hoaDon = new HoaDon();
//                    // Giả sử bạn có các phương thức set tương ứng để gán giá trị cho các thuộc tính
//                    hoaDon.setMaHoaDon(rs.getString("MaHD"));
//                    hoaDon.setMaKhachHang(rs.getString("MaKH"));
//                    hoaDon.setNgayLapHoaDon(rs.getDate("NgayLap").toLocalDate());
//                    hoaDon.setMaNhanVien(rs.getString("MaNV"));
//                    hoaDon.setThanhTien(rs.getFloat("ThanhTien"));
//                    hoaDon.setSoLuong(rs.getInt("SoLuong"));
//                    hoaDon.setTongTien(rs.getFloat("TongTien"));
//                    hoaDon.setTrangThai(rs.getString("TrangThai"));
//                    if(rs.getFloat("DaiNgo") == 0){
//                        hoaDon.setDaiNgo(DaiNgo.KhongDaiNgo);
//                    }
//                    else if( rs.getFloat("DaiNgo") == 0.2  ){
//                        hoaDon.setDaiNgo(DaiNgo.GIAMGIAHAIMUOIPHANTRAM);
//                    }
//                    else if( rs.getFloat("DaiNgo") == 0.1  ){
//                        hoaDon.setDaiNgo(DaiNgo.GIAMGIAMUOIPHANTRAM);
//                    }
//                    else if( rs.getFloat("DaiNgo") == 0.05  ){
//                        hoaDon.setDaiNgo(DaiNgo.GIAMGIANAMPHANTRAM);
//                    }
//                    hoaDon.setThue(rs.getFloat("Thue"));
//                    danhSachHoaDon.add(hoaDon);
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return danhSachHoaDon;
//        }
    public List<HoaDon> TimKiemHoaDon (String maHD, String soDienThoai) throws SQLException {
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon o join KhachHang k on o.MaKH=k.MaKH WHERE o.MaHD LIKE ? OR k.SoDT LIKE ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + maHD + "%"); // Tìm kiếm theo mã hóa đơn
            ps.setString(2, "%" + soDienThoai + "%"); // Tìm kiếm theo mã khách hàng

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                // Giả sử bạn có các phương thức set tương ứng để gán giá trị cho các thuộc tính
                hoaDon.setMaHoaDon(rs.getString("MaHD"));
                hoaDon.setMaKhachHang(rs.getString("MaKH"));
                hoaDon.setNgayLapHoaDon(rs.getDate("NgayLap").toLocalDate());
                hoaDon.setMaNhanVien(rs.getString("MaNV"));
                hoaDon.setThanhTien(rs.getFloat("ThanhTien"));
                hoaDon.setSoLuong(rs.getInt("SoLuong"));
                hoaDon.setTongTien(rs.getFloat("TongTien"));
                hoaDon.setTrangThai(rs.getString("TrangThai"));
                if(rs.getFloat("DaiNgo") == 0){
                    hoaDon.setDaiNgo(DaiNgo.KhongDaiNgo);
                }
                else if( rs.getFloat("DaiNgo") == 0.2  ){
                    hoaDon.setDaiNgo(DaiNgo.GIAMGIAHAIMUOIPHANTRAM);
                }
                else if( rs.getFloat("DaiNgo") == 0.1  ){
                    hoaDon.setDaiNgo(DaiNgo.GIAMGIAMUOIPHANTRAM);
                }
                else if( rs.getFloat("DaiNgo") == 0.05  ){
                    hoaDon.setDaiNgo(DaiNgo.GIAMGIANAMPHANTRAM);
                }
                hoaDon.setThue(rs.getFloat("Thue"));
                danhSachHoaDon.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachHoaDon;
    }
    public List<HoaDon> ChonTheoMaHD(String maHD) {
        List<HoaDon> ds = this.chonSql(CHON_THEO_MAHD_SQL, maHD);
        return ds;
    }

    public HoaDon ChonTheoMaKH(String maKH){
        List<HoaDon> ds = this.chonSql(CHON_THEO_MAKH_SQL, maKH);
        return ds.size() > 0 ? ds.get(0) : null;
    }

    public List<HoaDon> ChonTheoMaHDHayMaKh(String maHD, String maKH) {
        List<HoaDon> ds = this.chonSql(CHON_THEO_MAHD_HAY_MAKH_SQL, maHD, maKH);
        return ds;
    }

    public List<HoaDon> chonTatCa() {
        return this.chonSql(CHON_15_SQL);
    }

    public List<HoaDon> chonSql(String sql, Object...args){
        List<HoaDon> ds = new ArrayList<>();

        try {
            ResultSet boKetQua = null;
            try {
                boKetQua = KetNoiCoSoDuLieu.truyVan(sql, args);

                while (boKetQua.next()) {
                    HoaDon hd = new HoaDon();

                    hd.setMaHDTuCSDL(boKetQua.getString("MaHD"));
                    hd.setNgayLapHoaDon(boKetQua.getDate("NgayLap").toLocalDate());
                    hd.setMaNhanVien(boKetQua.getString("MaNV"));
                    hd.setThanhTien(boKetQua.getDouble("ThanhTien"));
                    hd.setMaKhachHang(boKetQua.getString("MaKH"));
                    hd.setSoLuong(boKetQua.getInt("SoLuong"));
                    hd.setTongTien(boKetQua.getDouble("TongTien"));
                    hd.setTrangThai(boKetQua.getString("TrangThai"));
                    hd.setThue(boKetQua.getFloat("Thue"));

                    ds.add(hd);
                }

            } finally {
                boKetQua.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

        return ds;
    }

    public void LuuHoaDon(HoaDon hd) {
        LuuSQL(
                LUU_HOA_DON_SQL,
                hd.getMaHoaDon(),
                hd.getNgayLapHoaDon(),
                hd.getMaNhanVien(),
                hd.getThanhTien(),
                hd.getMaKhachHang(),
                hd.getSoLuong(),
                hd.getTongTien(),
                hd.getTrangThai(),
                hd.getDaiNgo().getValue(),
                hd.getThue()
        );
    }

    public void LuuSQL(String sql, Object... args) {
        try {
            try (PreparedStatement stmt = KetNoiCoSoDuLieu.layCauLenh(sql, args)) {
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public void capNhatTrangThai(HoaDon hd) {
        try {
            KetNoiCoSoDuLieu.capNhat(CAP_NHAT_TRANG_THAI_SQL,
                    hd.getTrangThai(),
                    hd.getMaHoaDon()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static double layTongTienHeThong() {
        Connection c;
        try {
            c = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            if (c == null) {
                System.out.println("Ket noi that bai");
                return 0.0;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dauNgay = LocalDate.now().atStartOfDay();
            String formattedDateTime_start = dauNgay.format(formatter);
            LocalDateTime ngayGioKetThuc = TrangKetCa.ngayGioKetThuc;
            String formattedDateTime_end = ngayGioKetThuc.format(formatter);

            String sql = "SELECT SUM(ThanhTien) AS tongTienHeThong FROM [dbo].[HoaDon] WHERE NgayLap BETWEEN ? AND ?; ";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, formattedDateTime_start);
            ps.setString(2, formattedDateTime_end);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                double tongTienHeThong = rs.getDouble("tongTienHeThong");
                System.out.printf("Thanh cong!Tong tien he thong: %f", tongTienHeThong);
                return tongTienHeThong;
            }
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.printf("Tong tien he thong: %f", 0.0);
        }
        return 0.0;
    }
    public static double layTongVAT(){
        Connection c;
        try {
            c = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            if (c == null) {
                System.out.println("Ket noi that bai");
                return 0.0;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dauNgay = LocalDate.now().atStartOfDay();
            String formattedDateTime_start = dauNgay.format(formatter);
            LocalDateTime ngayGioKetThuc = TrangKetCa.ngayGioKetThuc;
            String formattedDateTime_end = ngayGioKetThuc.format(formatter);

            String sql = "SELECT SUM((TongTien*Thue)) AS tongVAT FROM [dbo].[HoaDon] WHERE NgayLap BETWEEN ? AND ?; ";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, formattedDateTime_start);
            ps.setString(2, formattedDateTime_end);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                double tongVAT = rs.getDouble("tongVAT");
                System.out.printf("Thanh cong!Tong VAT: %f", tongVAT);
                return tongVAT;
            }
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.printf("Tong VAT: %f", 0.0);
        }
        return 0.0;
    }
    public static double layTongGiamGia(){
        Connection c;
        try {
            c = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            if (c == null) {
                System.out.println("Ket noi that bai");
                return 0.0;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dauNgay = LocalDate.now().atStartOfDay();
            String formattedDateTime_start = dauNgay.format(formatter);
            LocalDateTime ngayGioKetThuc = TrangKetCa.ngayGioKetThuc;
            String formattedDateTime_end = ngayGioKetThuc.format(formatter);

            String sql = "SELECT SUM((TongTien*DaiNgo)) AS tongGiamGia FROM [dbo].[HoaDon] WHERE NgayLap BETWEEN ? AND ?; ";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, formattedDateTime_start);
            ps.setString(2, formattedDateTime_end);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                double tongGiamGia = rs.getDouble("tongGiamGia");
                System.out.printf("ThanhCong! Tong giam gia: %f", tongGiamGia);
                return tongGiamGia;
            }
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.printf("Tong giam gia: %f", 0.0);}
        return 0.0;
    }
    public static int laySoHoaDon(){
        Connection c;
        try {
            c = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            if (c == null) {
                System.out.println("Ket noi that bai");
                return 0;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dauNgay = LocalDate.now().atStartOfDay();
            String formattedDateTime_start = dauNgay.format(formatter);
            LocalDateTime ngayGioKetThuc = TrangKetCa.ngayGioKetThuc;
            String formattedDateTime_end = ngayGioKetThuc.format(formatter);

            String sql = "SELECT COUNT(MaHD) AS tongHoaDon FROM [dbo].[HoaDon] WHERE NgayLap BETWEEN ? AND ?; ";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, formattedDateTime_start);
            ps.setString(2, formattedDateTime_end);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int tongHoaDon = rs.getInt("tongHoaDon");
                System.out.printf("ThanhCong! Tong hoa don: %d", tongHoaDon);
                return tongHoaDon;
            }
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.printf("Tong hoa don: %d", 0);}
        return 0;
    }
}

